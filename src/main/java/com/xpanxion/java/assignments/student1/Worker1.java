package com.xpanxion.java.assignments.student1;

import com.xpanxion.java.assignments.DataAccess;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker1 {

    public void ex1() {
        var products = DataAccess.getProducts();
        var departments = DataAccess.getDepartments();
        products
                .stream()
                .map(product -> product)
                .forEach(p -> {
                    departments.forEach(d -> {
                        if (d.getId() == p.getDepartmentId()) {
                            p.setDepartmentName(d.getName());
                        }
                    });
                });

        System.out.println(products);
    }
}
