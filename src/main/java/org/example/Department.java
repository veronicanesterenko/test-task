package org.example;

public class Department implements Comparable<Department> {
    private String name;
    private Manager manager;

    public Department(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }

    @Override
    public int compareTo(Department department) {
        return name.compareTo(department.getName());
    }
}
