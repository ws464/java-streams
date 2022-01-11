package com.xpanxion.java.assignments.student3;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import java.util.Map;
import java.util.stream.Collectors;

public class Worker3 {

    public void ex1() {
        System.out.println("Ex. 1...");

        var products = DataAccess.getProducts();
        var departments = DataAccess.getDepartments();

        Map<Integer, String> departmentMap = departments.stream().collect(Collectors.toMap(Department::getId, Department::getName));
        var l = products.stream().map(p -> {
            p.setDepartmentName(departmentMap.get(p.getDepartmentId()));
            return p;
        }).toList();

        System.out.println(l);
    }
}
