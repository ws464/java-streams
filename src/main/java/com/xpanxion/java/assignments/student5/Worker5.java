package com.xpanxion.java.assignments.student5;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

import java.util.List;

import static com.xpanxion.java.assignments.DataAccess.getDepartments;

public class Worker5 {

    public void ex1() {
        List<Product> products = DataAccess.getProducts();
        List<Department> departments = getDepartments();

        products.stream().map(product -> {
          var departmentId = product.getDepartmentId();
          var departmentName = departments.get(departmentId).getName();
          product.setDepartmentName(departmentName);
          return product;
        }).forEach(System.out::println);
    }
}
