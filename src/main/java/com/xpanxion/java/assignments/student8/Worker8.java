package com.xpanxion.java.assignments.student8;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Worker8 {

    DataAccess dataAccess;

    public void ex1() {
        System.out.println("Exercise 1, Student 8:");

        Map<Integer, String> departmentsMap = dataAccess.getDepartments().stream().collect(Collectors.toMap(Department::getId, Department::getName));

        var prodList = DataAccess.getProducts();

        var updatedProdList = prodList.stream().map(p -> {
            p.setDepartmentName(departmentsMap.get(p.getDepartmentId()));
            return p;
        }).toList();

        System.out.println(updatedProdList);

    }


}
