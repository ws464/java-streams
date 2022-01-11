package com.xpanxion.java.assignments.student8;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.stream.Collectors;

public class Worker8 {

    public void ex1() {
        System.out.println("EXERCISE 1:");

        Map<Integer, String> departmentsMap = DataAccess.getDepartments().stream().collect(Collectors.toMap(Department::getId, Department::getName));

        var prodList = DataAccess.getProducts();

        var updatedProdList = prodList.stream().map(p -> {
            p.setDepartmentName(departmentsMap.get(p.getDepartmentId()));
            return p;
        }).toList();

        System.out.println(updatedProdList);
    }

    public void ex2() {
        System.out.println("\nEXERCISE 2:");

        var prodList = DataAccess.getProducts();

        var newProdList = prodList.stream().map(p -> {
            p.setDepartmentName("N/A");
            return p;
        }).toList();

        System.out.println(newProdList);
    }
}
