package com.xpanxion.java.assignments.student7;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Worker7 {

    public void ex1() {
        var products = DataAccess.getProducts();
        var departments = DataAccess.getDepartments();

        Map<Integer, Department> departmentsMap = departments.stream().collect(Collectors.toMap(Department::getId, Function.identity()));

        var correctProducts = products.stream()
                .map(p -> {
                        p.setDepartmentName(departmentsMap.get(p.getDepartmentId()).getName());
                    return p;
                })
                .collect(Collectors.toList());
        System.out.println(correctProducts);
    }
}
