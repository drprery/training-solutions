package introdate;

public class EmployeeTest {
     public static void main(String[] args) {
          Employee employee=new Employee(1984, 1, 13, "John Doe");

          System.out.println("Az alkalmazott neve: "+employee.getName());
          System.out.println("Az alkalmazott születési ideje: "+employee.getDateOfBirth());
          System.out.println("Az alkalmazott belépési dátuma: "+employee.getBeginEmployment());
     }
}


