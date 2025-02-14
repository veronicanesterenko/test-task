package org.example;

public class Employee {
    private String position;
    private Long id;
    private String name;
    private Double salary;
    private String managerId;


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position=" + position +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", managerId=" + managerId +
                '}';
    }

}
