package com.xpanxion.java.assignments.student2;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Worker2 {

    DataAccess dataAccess = new DataAccess();
    HashMap<Integer, String> depNames = new HashMap<>();

    public void ex1() {
        depNames.put(1,"Electronics");
        depNames.put(2,"Food");

        List<Product> products = dataAccess.getProducts();
        products.stream()
                .map(p -> {
                    p.setDepartmentName(depNames.get(p.getDepartmentId()));
                    return p;
                }).collect(Collectors.toList());

        System.out.println("Ex. 1...");
        System.out.println(products);
    }

    public void ex2() {
        List<Product> products = dataAccess.getProducts();
        products.stream()
                .forEach(p -> p.setDepartmentName("N/A"));

        System.out.println("Ex. 2...");
        System.out.println(products);
    }
}
