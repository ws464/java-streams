package com.xpanxion.java.assignments.student8;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

import java.text.NumberFormat;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Worker8 {

    public void ex1() {
        System.out.println("EXERCISE 1:");

        Map<Integer, String> departmentsMap = DataAccess.getDepartments().stream().collect(Collectors.toMap(Department::getId, Department::getName));

        var prodList = DataAccess.getProducts();

        var updatedProdList = prodList.stream().map(p -> {
            p.setDepartmentName(departmentsMap.get(p.getDepartmentId()));
            return p;
        }).toList();

        System.out.println(updatedProdList);
    }

    public void ex2() {
        System.out.println("\nEXERCISE 2:");
        var prodList = DataAccess.getProducts();

        var newProdList = prodList.stream().map(p -> {
            p.setDepartmentName("N/A");
            return p;
        }).toList();

        System.out.println(newProdList);
    }

    public void ex3() {
        System.out.println("\nEXERCISE 3:");
        var prodList = DataAccess.getProducts();
        Predicate<Product> prods10OrOver = p -> p.getPrice() >= 10.00;
        Predicate<Product> electronicProducts = p -> p.getDepartmentId() == 1;

        var electronicsPrice10AndOver = prodList.stream().filter(electronicProducts.and(prods10OrOver)).toList();
        System.out.println(electronicsPrice10AndOver);
    }

    public void ex4() {
        System.out.println("\nEXERCISE 4:");
        var prodList = DataAccess.getProducts();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Predicate<Product> foodProducts = p -> p.getDepartmentId() == 2;

        var foodItemsTotalCost = prodList.stream()
                .filter(foodProducts)
                .collect(Collectors.summingDouble(Product::getPrice));

        var foodItemsTotalCostInDollars = formatter.format(foodItemsTotalCost);
        System.out.println(foodItemsTotalCostInDollars);
    }

    public void ex5() {
        System.out.println("\nEXERCISE 5:");
        var peopleList = DataAccess.getPeople();
        Predicate<Person> people3OrLess = p -> p.getId() <= 3;

        var peopleUpdated = peopleList.stream()
                .filter(people3OrLess)
                .map(p -> {
            p.setSsn(p.getSsn().substring(p.getSsn().length() - 4));
            return p;
        }).toList();

        System.out.println(peopleUpdated);
    }

}
