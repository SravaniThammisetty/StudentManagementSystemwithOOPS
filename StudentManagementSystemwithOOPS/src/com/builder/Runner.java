package com.builder;

public class Runner {
    public static void main(String[] args) {


        Employee e2 = new Employee.Builder().name("Tammisetty").salary(20000).empID(201).build();
        System.out.println(e2);
    }
}
