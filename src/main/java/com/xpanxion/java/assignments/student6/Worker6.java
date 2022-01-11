package com.xpanxion.java.assignments.student6;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Worker6 {

    public void ex1() {
        List<Product> productList = DataAccess.getProducts();
        List<Department> departmentList = DataAccess.getDepartments();

        Map<Integer, Department> departmentMap = departmentList.stream().collect(Collectors.toMap(Department::getId, i -> (Department)i));
        List<Product> newProductList = productList.stream().map(p -> {
            p.setDepartmentName(departmentMap.get(p.getDepartmentId()).getName());
            return p;
        }).toList();

        System.out.println(newProductList);
    }

    public void ex2() {
        List<Product> productList = DataAccess.getProducts();
        List<Product> newProductList = productList.stream().map(p -> {
            p.setDepartmentName("N/A");
            return p;
        }).toList();
        System.out.println(newProductList);

    }
}
