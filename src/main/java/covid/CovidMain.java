package covid;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CovidMain {
    private boolean quit;
    private CitizenDao citizenDao = new CitizenDao();

    public CovidMain(){
        run();
    }

    public static void main(String[] args) {
        CovidMain covidMain = new CovidMain();

        covidMain.run();
    }

    public void run(){
        while(!quit){
            printMenu();
            select();
        }
    }

    private void printMenu() {
        System.out.println("***************************");
        System.out.println("* 1. Regisztráció         *");
        System.out.println("* 2. Tömeges regisztráció *");
        System.out.println("* 3. Generálás            *");
        System.out.println("* 4. Oltás                *");
        System.out.println("* 5. Oltás meghiúsulás    *");
        System.out.println("* 6. Kilépés              *");
        System.out.println("***************************");

        System.out.print("Kérem, válasszon: ");
    }

    private void select() {
        Scanner scanner = new Scanner(System.in);

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1 : registration();
                    break;
            case 2 : massRegistration();
                    break;
            case 3 : reportGenerating();
                    break;
            case 4 : vaccination();
                    break;
            case 5 : failedVaccination();
                    break;
            case 6 : quit = true;
                    break;
            default:
                System.out.println("Kérem válasszon újra!\n");
        }
    }

    private void registration(){
        String name;
        String zip;
        int age;
        String email;
        String ssn;

        name = Registration.nameInput();
        zip = Registration.zipInput();
        age = Registration.ageInput();
        email = Registration.emailInput();
        ssn = Registration.ssnInput();

        Citizen citizen = new Citizen(name, zip, age, email, ssn);
        System.out.println(citizenDao.uploadCitizenToDb(citizen)+" sikeresen regisztrálva!");
    }

    private void massRegistration(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem adja meg a feltöltendő file nevét: ");
        String path = scanner.nextLine();
        try {
            System.out.println(citizenDao.uploadCitizensFromFile(path));
        } catch (IllegalStateException ise){
            System.out.println("A file nem található!");
        }
    }

    private void reportGenerating() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem adja meg az irányítószámot: ");
        String zip = scanner.nextLine();
        System.out.println("Kérem adja meg a mentendő file nevét: ");
        String path = scanner.nextLine();

        List<ExtendedCitizen> citizens = new ArrayList<>();
        try(Connection conn = citizenDao.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `citizens` WHERE `zip` = ? ORDER BY `age`, `name`;")){
                ps.setString(1, zip);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    citizens.add(new ExtendedCitizen(rs.getString("citizen_name"),
                            rs.getString("zip"),
                            rs.getInt("age"),
                            rs.getString("email"),
                            rs.getString("taj"),
                            rs.getInt("number_of_vaccination"),
                            rs.getDate("last_vaccination").toLocalDate()));
                }

                int numOfPerson = 0;
                LocalTime time = LocalTime.of(8, 0);

                try(BufferedWriter bw = Files.newBufferedWriter(Path.of(path))){
                    bw.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");

                    for(ExtendedCitizen citizen : citizens){
                        if(numOfPerson<16 && citizen.getNumOfVacc()==0 ||
                                (citizen.getNumOfVacc()==1 && citizen.getLastVacc().plusDays(15).isBefore(LocalDate.now()))){
                            numOfPerson++;
                            bw.write(time.getHour()+":"+time.getMinute()+";"+
                                    citizen.getFullName()+ ";"+
                                    citizen.getZipCode()+";"+
                                    citizen.getAge()+";"+
                                    citizen.getEmail()+";"+
                                    citizen.getSsn()+"\n");

                            time.plusMinutes(30);
                        }
                    }
                } catch (IOException ioe){
                    throw new IllegalStateException("File can not write!");
                }

        } catch (SQLException sqle){
            throw new IllegalStateException();
        }
    }

    private void vaccination(){

    }

    private void failedVaccination(){

    }

}
