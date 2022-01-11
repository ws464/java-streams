package com.xpanxion.java.assignments.student7;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

import java.text.NumberFormat;
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

    public void ex2() {

        var products = DataAccess.getProducts();
        var updateProducts = products.stream()
                .map(p -> {
                    p.setDepartmentName("N/A");
                    return p;
                })
                .collect(Collectors.toList());
        System.out.println(updateProducts);
    }

    public void ex3() {
        var products = DataAccess.getProducts();

        var filteredProducts = products.stream()
                .filter(product -> product.getDepartmentId()==1 && product.getPrice()>=10.00)
        .collect(Collectors.toList());
        System.out.println(filteredProducts);

    }

    public void ex4() {
        var products = DataAccess.getProducts();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        var foodTotals = products.stream()
                .filter(product -> product.getDepartmentId()==2)
                .mapToDouble(Product::getPrice).sum();

        System.out.println(formatter.format(foodTotals));
    }

    public void ex5() {
    var people = DataAccess.getPeople();

    var fixedSsn = people.stream()
            .filter(p -> p.getId()<=3)
            .map(p -> {
                var split = p.getSsn().split("-");
                p.setSsn(split[2]);
                return p;
            })
           .toList();
        System.out.println(fixedSsn);
    }
}
