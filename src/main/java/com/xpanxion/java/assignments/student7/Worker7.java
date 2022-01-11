package com.xpanxion.java.assignments.student7;

import com.xpanxion.java.assignments.DataAccess;

import java.util.stream.Collectors;

public class Worker7 {

    public void ex1() {
        var products = DataAccess.getProducts();
        var departments = DataAccess.getDepartments();

        var correctProducts = products.stream()
                .map(p -> {
                        p.setDepartmentName(departments.get(p.getDepartmentId()-1).getName());
                    return p;
                })
                .collect(Collectors.toList());
        System.out.println(correctProducts);
    }
}
