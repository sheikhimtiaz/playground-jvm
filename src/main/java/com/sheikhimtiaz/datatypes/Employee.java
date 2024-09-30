package com.sheikhimtiaz.datatypes;

public class Employee implements Comparable<Employee> {

    private Long id;
    private String name;

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
// constructor, getters, setters

    // override equals and hashCode
    @Override
    public int compareTo(Employee employee) {
        return (int)(this.id - employee.getId());
    }
}