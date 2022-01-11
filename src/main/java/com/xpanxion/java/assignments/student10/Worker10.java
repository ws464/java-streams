package com.xpanxion.java.assignments.student10;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Product;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Worker10 {

    public void ex1() {
        System.out.println("Ex. 1...");
        var productList = DataAccess.getProducts();
        var departmentList = DataAccess.getDepartments();

        var newProductList = productList.stream().map(product -> {
            var departmentId = product.getDepartmentId();
            var departmentName = departmentList.get(departmentId).getName();
            product.setDepartmentName(departmentName);
            return product;
        })
        .collect(Collectors.toList());
        System.out.println(newProductList);
    }
}
