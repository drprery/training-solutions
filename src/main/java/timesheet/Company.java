package timesheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private List<TimeSheetItem> timeSheetItems = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    public Company(InputStream employeesFile, InputStream projectsFile) {

        try (BufferedReader employeeReader = new BufferedReader(new InputStreamReader(employeesFile))) {
            String name;

            while ((name = employeeReader.readLine()) != null) {
                employees.add(new Employee(name.split(" ")[0], name.split(" ")[1]));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("The employee file not found!");
        }

        try (BufferedReader projectReader = new BufferedReader(new InputStreamReader(projectsFile))) {
            String name;

            while ((name = projectReader.readLine()) != null) {
                projects.add(new Project(name));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("The project file not found!");
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employee, int year, int month) {
        int i=0;
        boolean found = false;
        List<TimeSheetItem> filteredTSItemsByName;
        List<ReportLine> report = new ArrayList<>();
        Map<String,Integer> pPairs=new HashMap<>();

        for (Project project : projects) {
            report.add(new ReportLine(project, 0L));
            pPairs.put(project.getName(), i++);
        }

        for (Employee employee1 : employees) {
            if (employee1.getName().equals(employee)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException();
        }

        filteredTSItemsByName = timeSheetItems.stream().filter((timeSheetItem) ->
                timeSheetItem.getEmployee().getName().equals(employee) &&
                timeSheetItem.getBeginDate().getYear() == year &&
                timeSheetItem.getBeginDate().getMonthValue() == month).collect(Collectors.toList());

        for (TimeSheetItem timeSheetItem : filteredTSItemsByName) {
            String pName=timeSheetItem.getProject().getName();
            report.get(pPairs.get(pName)).addTime(timeSheetItem.hoursBetweenDates());
        }
        return report;
    }

    public void printToFile(String name, int year, int month, Path report){
        String rLine = name+"\t"+year+"-"+String.format("%02d",month)+"\t";
        List<ReportLine> reportLines;
        int totalHours=0;

        reportLines=calculateProjectByNameYearMonth(name, year, month);
        for(ReportLine reportLine : reportLines){
            totalHours+=reportLine.getTime();
        }

        rLine+=totalHours+"\n";

        for(ReportLine reportLine : reportLines){
            if(reportLine.getTime()!=0){
                rLine+=reportLine.getProject().getName()+"\t"+
                        reportLine.getTime()+"\n";
            }
        }

        try{
            Files.writeString(report, rLine);
        } catch (IOException ioe) {
            throw new IllegalStateException();
        }
    }
}
