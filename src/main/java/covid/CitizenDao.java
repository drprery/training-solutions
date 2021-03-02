package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;


public class CitizenDao {
    private MariaDbDataSource dataSource = new MariaDbDataSource();

    public CitizenDao() {
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("root");
            dataSource.setPassword("root74");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database!", se);
        }

    }

    public List<String> getSettlementsByZip(String zipCode) {
        Dbase dbase = new Dbase(dataSource);

        return dbase.queryStringColumn("SELECT `settlement` FROM `postcodes` WHERE `zip` = ? ORDER BY `settlement`", zipCode);
    }

    public String uploadCitizensFromFile(String fileName) {
        int sum = 0;

        try (InputStream is = CitizenDao.class.getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String cols = br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(";");
                Citizen citizen = new Citizen(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4]);
                uploadCitizenToDb(citizen);
                sum++;
            }
            return "Successfully uploaded " + sum + " citizens to the DB!";
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
    }

    public long uploadCitizenToDb(Citizen citizen) {
            try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO `citizens`(`citizen_name`, `zip`, `age`, `email`, `taj`) VALUES (?, ?, ?, ?, ?);",
                        Statement.RETURN_GENERATED_KEYS
                )) {
                ps.setString(1, citizen.getFullName());
                ps.setString(2, citizen.getZipCode());
                ps.setInt(3, citizen.getAge());
                ps.setString(4, citizen.getEmail());
                ps.setString(5, citizen.getSsn());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getLong(1);

            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not insert to DB!", sqle);
            }
    }

    public MariaDbDataSource getDataSource() {
        return dataSource;
    }
}
