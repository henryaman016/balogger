package com.balog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainUtil {
    public static void main(String[] args) {

        List<Employee> names = Arrays.asList(new Employee(2,"xyz"),new Employee(1,"abc"));

        Employee employee = names.stream().max(Employee::compareTo).get();

        System.out.println(employee.getId());
        System.out.println(employee.getName());
    }
}
