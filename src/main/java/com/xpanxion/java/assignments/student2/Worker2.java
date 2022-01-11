package com.xpanxion.java.assignments.student2;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Worker2 {
    public void ex1() {
        Map<Integer, String> departmentMap = DataAccess.getDepartments()
                .stream()
                .collect(Collectors.toMap(Department::getId,
                        Department::getName));

        List<Product> products = DataAccess.getProducts()
                .stream()
                .map(p -> {
                    p.setDepartmentName(departmentMap.get(p.getDepartmentId()));
                    return p;
                }).collect(Collectors.toList());

        System.out.println("Ex. 1...");
        System.out.println(products);
    }

    public void ex2() {
        List<Product> products = DataAccess.getProducts()
                .stream()
                .map(p -> {
                    p.setDepartmentName("N/A");
                    return p;
                }).collect(Collectors.toList());

        System.out.println("Ex. 2...");
        System.out.println(products);
    }

    public void ex3() {
        List<Product> products = DataAccess.getProducts()
                .stream()
                .filter(p -> p.getPrice() >= 10)
                .collect(Collectors.toList());

        System.out.println("Ex. 3...");
        System.out.println(products);
    }

    public void ex4() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        List<Product> products = DataAccess.getProducts();
        float priceSum = products
                .stream()
                .filter(p -> p.getDepartmentId() == 2)
                .mapToInt(p -> (int) p.getPrice())
                .sum();

        System.out.println("Ex. 4...");
        System.out.println(currency.format(priceSum));
    }

    public void ex5() {
        List<Person> people = DataAccess.getPeople()
                .stream()
                .filter(p -> p.getId() <= 3)
                .map(p -> {
                    p.setSsn(p.getSsn().substring(p.getSsn().length() - 4));
                    return p;
                }).collect(Collectors.toList());

        System.out.println("Ex. 5...");
        System.out.println(people);
    }

    public void ex6() {
        List<Cat> cats = DataAccess.getCats()
                .stream()
                .sorted(Comparator.comparing(Cat::getName))
                .collect(Collectors.toList());

        System.out.println("Ex. 6...");
        System.out.println(cats);
    }

    public void ex7() {
        List<String> words = Arrays.asList(DataAccess.getWords().split(" "));

        Map<String, Long> wordCount = words
                .stream()
                .collect(groupingBy(Function.identity(), counting()));

        System.out.println("Ex. 7...");
        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .forEach(System.out::println);
    }
}


