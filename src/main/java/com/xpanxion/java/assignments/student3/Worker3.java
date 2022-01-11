package com.xpanxion.java.assignments.student3;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Worker3 {

    private List<Product> products = DataAccess.getProducts();
    private List<Department> departments = DataAccess.getDepartments();

    public void ex1() {
        System.out.println("Ex. 1...");

        Map<Integer, String> departmentMap = departments.stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        var l = products.stream().map(p -> {
            p.setDepartmentName(departmentMap.get(p.getDepartmentId()));
            return p;
        }).toList();

        System.out.println(l);
    }

    public void ex2(){
        System.out.println("Ex. 2...");

        var l = products.stream().map(p -> {
            p.setDepartmentName("N/A");
            return p;
        }).toList();

        System.out.println(l);
    }

    public void ex3(){
        System.out.println("Ex. 3...");

        var l = products.stream()
                .filter(p -> p.getDepartmentId() == 1)
                .filter(p -> p.getPrice() >= 10.0)
                .toList();

        System.out.println(l);
    }

    public void ex4(){
        System.out.println("Ex. 4...");

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        var l = products.stream().filter(p -> p.getDepartmentId() == 2).mapToDouble(Product::getPrice).sum();

        var price = formatter.format(l);

        System.out.println(price);
    }
}
