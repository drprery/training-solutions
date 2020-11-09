package intromethods.employee;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee employee = new Employee("Kovács János", 2020, 106000);

        System.out.println(employee);
        employee.raiseSalary(6000);

        System.out.println(employee);

        employee.setName("Kovács Péter");
        System.out.println("Name: " + employee.getName());
        System.out.println("Hiring year: " + employee.getHiringYear());
        System.out.println("Salary: " + employee.getSalary());
    }
}
