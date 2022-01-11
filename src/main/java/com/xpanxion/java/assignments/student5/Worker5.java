package com.xpanxion.java.assignments.student5;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Worker5 {

    public void ex1() {
        List<Product> products = DataAccess.getProducts();
        List<Department> departmentList = DataAccess.getDepartments();

        Map<Integer, Department> departmentMap = departmentList.stream()
                .collect(Collectors.toMap(Department::getId, Function.identity()));

        products.stream().map(product -> {
          Integer departmentId = Integer.valueOf(product.getDepartmentId());
          product.setDepartmentName(departmentMap.get(departmentId).getName());
          return product;
        }).forEach(System.out::println);
    }

    public void ex2() {
        DataAccess.getProducts().stream().map(product -> {
            product.setDepartmentName("N/A");
            System.out.println(product);
            return product;
        }).collect(Collectors.toList());
    }

    public void ex3() {
        List<Product> products = DataAccess.getProducts().stream()
                .filter(product ->
                        product.getDepartmentId()==1 && product.getPrice()>=10.00)
                .collect(Collectors.toList());
        System.out.println(products);
    }
}
