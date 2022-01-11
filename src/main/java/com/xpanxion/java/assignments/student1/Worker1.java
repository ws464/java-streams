package com.xpanxion.java.assignments.student1;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Worker1 {

    public void ex1() {
        var products = DataAccess.getProducts();
        Map<Integer, Department> departmentMap = DataAccess.getDepartments().stream()
                        .collect(Collectors.toMap(Department::getId, Function.identity()));

        products.forEach(p -> p.setDepartmentName(departmentMap.get(p.getDepartmentId()).getName()));
        System.out.println(products);
    }
}
