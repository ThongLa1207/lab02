package com.example.lab02_5;

public class Employee {
    private String id;
    private String fullName;
    private boolean manager;

    public Employee(String id, String fullName, boolean manager) {
        this.id = id;
        this.fullName = fullName;
        this.manager = manager;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }
}

