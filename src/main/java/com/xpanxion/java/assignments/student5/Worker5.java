package com.xpanxion.java.assignments.student5;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Worker5 {

    public void ex1() {
        List<Product> products = DataAccess.getProducts();
        Map<Integer, String> departmentNames = new HashMap<>();

        DataAccess.getDepartments().stream()
                .forEach(department -> departmentNames.put(department.getId(),department.getName()));

        products.stream().map(product -> {
          Integer departmentId = Integer.valueOf(product.getDepartmentId());
          product.setDepartmentName(departmentNames.get(departmentId));
          return product;
        }).forEach(System.out::println);
    }
}
