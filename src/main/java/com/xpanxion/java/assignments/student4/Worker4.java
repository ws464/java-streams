package com.xpanxion.java.assignments.student4;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Worker4 {

    public void ex1() {
        var  proList = DataAccess.getProducts();
        var depList = DataAccess.getDepartments();

        Map<Integer, Department> depMap = depList.stream().collect(Collectors.toMap(Department::getId, Function.identity()));
        var result = proList.stream().map(p -> {
            p.setDepartmentName(depMap.get(p.getDepartmentId()).getName());
            return p;
        }).toList();
        System.out.println(result);
    }
}
