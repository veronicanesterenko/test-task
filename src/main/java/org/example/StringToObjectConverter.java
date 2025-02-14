package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringToObjectConverter {

    public List<List<Object>> convertToObjects(List<String> staff) {
        List<List<Object>> allData = new ArrayList<>();
        List<Object> employees = new ArrayList<>();
        List<Object> departmentsData = new ArrayList<>();
        List<Object> invalidData = new ArrayList<>();

        for (String staffMember : staff) {
            String[] strings = staffMember.trim().split(",");
            try {
                if (strings[0].equalsIgnoreCase("manager")) {
                    Manager manager = new Manager();
                    manager.setPosition(strings[0]);
                    manager.setId(Long.parseLong(strings[1]));
                    manager.setName(strings[2]);
                    manager.setSalary(Double.parseDouble(strings[3]));
                    manager.setDepartment(strings[4]);
                    departmentsData.add(new Department(strings[4], manager));

                } else if (strings[0].equalsIgnoreCase("employee")) {
                    Employee employee = new Employee();
                    employee.setPosition(strings[0]);
                    employee.setId(Long.parseLong(strings[1]));
                    employee.setName(strings[2]);
                    employee.setSalary(Double.parseDouble(strings[3]));
                    employee.setManagerId(strings[4]);

                    if (employee.getSalary() < 0) {
                        invalidData.add(staffMember);
                    } else {
                        employees.add(employee);
                    }

                }
            } catch (NumberFormatException e) {
                invalidData.add(staffMember);
            }
        }
        allData.add(invalidData);
        allData.add(departmentsData);
        allData.add(employees);
        return allData;
    }


}
