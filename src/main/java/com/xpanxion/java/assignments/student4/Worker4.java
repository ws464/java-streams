package com.xpanxion.java.assignments.student4;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

import java.text.NumberFormat;
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

    public void ex2() {
        var  proList = DataAccess.getProducts();
        var result=proList.stream().map(p->{
            p.setDepartmentName("N/A");
            return p;
        }).toList();
        System.out.println(result);
    }

    public void ex3() {
        var proList = DataAccess.getProducts();
        var result = proList.stream()
                .filter(p -> p.getDepartmentId() == 1)
                .filter(p -> p.getPrice() >= 10)
                .toList();
        System.out.println(result);
    }

    public void ex4() {
        var proList = DataAccess.getProducts();
        var result = proList.stream()
                .filter(p -> p.getDepartmentId() == 2)
                .map(Product::getPrice)
                .reduce(Float::sum);
        System.out.println(result);
    }

    public void ex5(){
        var perList = DataAccess.getPeople();
        var result = perList.stream()
                .filter(p -> p.getId() <= 3)
                .map(p -> {
                    p.setSsn(p.getSsn().substring(p.getSsn().length()-4));
                    return p;
                }).toList();
        System.out.println(result);
    }
}
