package com.xpanxion.java.assignments.instructor;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;

import java.util.Map;
import java.util.stream.Collectors;

public class Worker0 {

    public void ex1() {
        var pList = DataAccess.getProducts();
        var dList = DataAccess.getDepartments();

        Map<Integer, Department> departmentMap = dList.stream().collect(Collectors.toMap(Department::getId, i -> (Department)i));
        var pp = pList.stream().peek(p-> p.setDepartmentName(departmentMap.get(p.getDepartmentId()).getName())).toList();

        System.out.println(pp);
    }

    public void ex2() {
        var pList = DataAccess.getProducts();

        var l = pList.stream().map(p -> {
            p.setDepartmentName("N/A");
            return p;
        }).toList();
        System.out.println(l);
    }
}
