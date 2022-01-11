package com.xpanxion.java.assignments.student5;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

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
        Map<String, Integer> wordMap = new HashMap<>();
        List<String> wordList = Arrays.stream(DataAccess.getWords().split(" ")).toList();

        wordList.forEach(word -> wordMap.put(word, wordMap.getOrDefault(word, 0) + 1));

        HashMap<String, Integer> sortedWords
                = wordMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        sortedWords.forEach((w, count) -> System.out.println(w + " = " + count));
    }
}
