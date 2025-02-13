package com.mapinterface.groupobjectsbyproperty;

// Employee class representing an employee with a name and department
class Employee {
    String name;
    String department;

    // Constructor to initialize name and department
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Overriding toString to print employee name instead of object reference
    @Override
    public String toString() {
        return name;
    }
}