package com.xpanxion.java.assignments.student10;

import com.xpanxion.java.assignments.DataAccess;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Worker10 {

    public void ex1() {
        System.out.println("Ex. 1");
        var productList = DataAccess.getProducts();
        var departmentList = DataAccess.getDepartments();
        HashMap<Integer, String> hashMap = new HashMap<>();
        departmentList.stream()
                .forEach(department -> {
                    hashMap.put(department.getId(), department.getName());
                });

        var newProductList = productList.stream()
                .map(product -> {
                    var departmentId = product.getDepartmentId();
                    var departmentName = hashMap.get(departmentId);
                    product.setDepartmentName(departmentName);
                    return product;
                })
                .collect(Collectors.toList());

        System.out.println(newProductList);
    }
}
