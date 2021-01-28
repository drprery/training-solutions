package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path path, List<Employee> employees) {
        try {
            return parse(Files.readString(path), employees);

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file!");
        }
    }

    private String parse(String template, List<Employee> employees) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Employee item : employees) {
            stringBuilder.append(template.replace("{nev}", item.getName()).replace("{ev}", Integer.toString(item.getYearOfBirth())) + "\n");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        List<Employee> employee = List.of(new Employee("John Doe", 1969), new Employee("Jane Doe", 1998));

        System.out.println(new TemplateMerger().merge(Path.of("template.txt"), employee));
    }
}
