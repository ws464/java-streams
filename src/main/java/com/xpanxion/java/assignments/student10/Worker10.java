package com.xpanxion.java.assignments.student10;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Worker10 {

    public List<Product> ex1() {
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
        return newProductList;
    }

    public void ex2() {
        var productList = ex1();
        var newProductList = productList.stream()
                .map(product -> {
                    product.setDepartmentName("N/A");
                    return product;
                })
                .collect(Collectors.toList());
        System.out.println(newProductList);
    }

    public void ex3() {
        var productList = DataAccess.getProducts();
        var filteredList = productList.stream()
                .filter(product -> product.getDepartmentId() == 1)
                .filter(product -> product.getPrice()>=10.0)
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
