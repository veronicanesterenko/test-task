package org.example;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataWriter {

    public void printSortedData(PrintWriter writer, Comparator comparator, List<List<Object>> allData) throws IOException {
        List<Department> departments = extractDepartments(allData);
        List<Employee> employees = extractEmployees(allData);
        List<String> invalid = extractInvalidData(allData);

        departments.stream().sorted().forEach(dep -> {
            writer.println(dep.getName());
            writer.println(dep.getManager());
            Manager manager = dep.getManager();
            employees.stream()
                    .filter(employee -> employee.getManagerId().equals(String.valueOf(manager.getId())))
                    .sorted(comparator)
                    .forEach(writer::println);
            List<Employee> filteredEmployee = employees.stream().filter(employee ->
                            employee.getManagerId().equals(String.valueOf(manager.getId())))
                    .collect(Collectors.toList());
            writer.println(filteredEmployee.size() + "," + String.format("%.2f",
                    getAvgSales(filteredEmployee)));
        });

        if(!invalid.isEmpty()) {
            writer.println("Некорректные данные:");
            invalid.forEach(writer::println);
        }
        writer.flush();
    }

    public void printData(PrintWriter writer, List<List<Object>> allData) {
        List<Department> departments = extractDepartments(allData);
        List<Employee> employees = extractEmployees(allData);
        List<String> invalid = extractInvalidData(allData);

        departments.stream().sorted().forEach(dep -> {
            writer.println(dep.getName());
            writer.println(dep.getManager());
            Manager manager = dep.getManager();
            employees.stream()
                    .filter(employee -> employee.getManagerId().equals(String.valueOf(manager.getId())))
                    .forEach(writer::println);
            List<Employee> filteredEmployee = employees.stream().filter(employee ->
                            employee.getManagerId().equals(String.valueOf(manager.getId())))
                    .collect(Collectors.toList());
            writer.println(filteredEmployee.size() + "," + String.format("%.2f",
                    getAvgSales(filteredEmployee)));
        });

        if(!invalid.isEmpty()) {
            writer.println("Некорректные данные:");
            invalid.forEach(writer::println);
        }
        writer.flush();
    }

    public static List<Employee> extractEmployees(List<List<Object>> allData) {
        return allData.stream().flatMap(List::stream)
                .filter(o -> o instanceof Employee)
                .map(object -> (Employee)object).collect(Collectors.toList());
    }

    public static List<Department> extractDepartments(List<List<Object>> allData) {
        return allData.stream().flatMap(List::stream)
                .filter(o -> o instanceof Department)
                .map(object -> (Department)object)
                .collect(Collectors.toList());
    }

    public static List<String> extractInvalidData(List<List<Object>> allData) {
        return allData.stream().flatMap(List::stream)
                .filter(o -> o instanceof String)
                .map(object -> (String)object)
                .collect(Collectors.toList());
    }

    public static Double getAvgSales(List<Employee> employees) {
        double total = employees.stream().mapToDouble(Employee::getSalary).sum();
        return employees.isEmpty() ? 0 : total / employees.size();
    }
}
