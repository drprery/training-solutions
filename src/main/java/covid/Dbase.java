package covid;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dbase {
    private DataSource dataSource;

    public Dbase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> queryStringColumn(String sql, String colName){
        List<String> res = new ArrayList<>();
        String[] colParts = sql.split("`");
        String col = colParts[1].trim();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(1, colName);
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                    res.add(rs.getString(col));
                }

                return new ArrayList<>(res);

        } catch (SQLException sqle){
            throw new IllegalStateException("Can not connect to the DB!");
        }
    }

    public long insert(String sql){
        return 0L;
    }
}
