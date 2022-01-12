package com.xpanxion.java.assignments.student5;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.*;

import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Worker5 {

    public void ex1() {
        List<Product> products = DataAccess.getProducts();
        List<Department> departmentList = DataAccess.getDepartments();

        Map<Integer, Department> departmentMap = departmentList.stream()
                .collect(Collectors.toMap(Department::getId, Function.identity()));

        products.stream().map(product -> {
          Integer departmentId = Integer.valueOf(product.getDepartmentId());
          product.setDepartmentName(departmentMap.get(departmentId).getName());
          return product;
        }).forEach(System.out::println);
    }

    public void ex2() {
        DataAccess.getProducts().stream().map(product -> {
            product.setDepartmentName("N/A");
            System.out.println(product);
            return product;
        }).toList();
    }

    public void ex3() {
        List<Product> products = DataAccess.getProducts().stream()
                .filter(product ->
                        product.getDepartmentId()==1 && product.getPrice()>=10.00)
                .toList();
        System.out.println(products);
    }

    public void ex4() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        List<Product> products = DataAccess.getProducts();

        double foodDeptSum = products.stream()
                .filter(product -> product.getDepartmentId() == 2)
                .mapToDouble(Product::getPrice).sum();

        System.out.println(formatter.format(foodDeptSum));
    }

    public void ex5() {
        List<Person> people = DataAccess.getPeople().stream().map(person -> {
                    var ssn = person.getSsn();
                    var ssnLength = ssn.length();
                    person.setSsn(ssn.substring(ssnLength-4));
                    return person;
                }).toList();
        System.out.println(people);
    }

    public void ex6() {
        List<Cat> cats =  DataAccess.getCats()
                .stream().sorted(Comparator.comparing(Cat::getName))
                .toList();

        System.out.println(cats);
    }

    public void ex7() {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        var words = new StringTokenizer(DataAccess.getWords());
        while (words.hasMoreTokens()) {
            var word = words.nextToken();
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        wordMap.forEach((word, count) -> System.out.println(word + " = " + count));
    }

    public void ex8() {
        DataAccess.getPeople().stream().forEach(person -> {
            person.setLastName(null);
            person.setAge(0);
            person.setSsn(null);
            System.out.println(person);
        });
    }

    public void ex9() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        List<Product> products = DataAccess.getProducts();

        var elecDeptSum = products.stream()
                .filter(product -> product.getDepartmentId() == 1)
                .mapToDouble(electronic -> {
                    float price = electronic.getPrice();
                    return price + 2;
                }).sum();

        System.out.println(formatter.format(elecDeptSum));
    }
}
