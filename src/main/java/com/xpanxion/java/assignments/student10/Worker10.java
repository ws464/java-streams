package com.xpanxion.java.assignments.student10;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Product;

import javax.xml.crypto.Data;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Worker10 {

    public List<Product> ex1() {
        System.out.println("Ex. 1");
        var productList = DataAccess.getProducts();
        var departmentList = DataAccess.getDepartments();
        HashMap<Integer, String> hashMap = new HashMap<>();
        departmentList.stream()
                .forEach(department -> {
                    hashMap.put(department.getId(), department.getName());
                });

        var newProductList = productList.stream()
                .map(product -> {
                    var departmentId = product.getDepartmentId();
                    var departmentName = hashMap.get(departmentId);
                    product.setDepartmentName(departmentName);
                    return product;
                })
                .collect(Collectors.toList());

        System.out.println(newProductList);
        return newProductList;
    }

    public void ex2() {
        var productList = ex1();
        var newProductList = productList.stream()
                .map(product -> {
                    product.setDepartmentName("N/A");
                    return product;
                })
                .collect(Collectors.toList());
        System.out.println(newProductList);
    }

    public void ex3() {
        var productList = DataAccess.getProducts();
        var filteredList = productList.stream()
                .filter(product -> product.getDepartmentId() == 1)
                .filter(product -> product.getPrice()>=10.0)
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }

    public void ex4() {
        var productList = DataAccess.getProducts();

        var total = productList.stream()
                .filter(product -> product.getDepartmentId()==2)
                .map(Product::getPrice)
                .reduce(0.00F, Float::sum);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println(formatter.format(total));
    }

    public void ex5() {
        var people = DataAccess.getPeople();

        var newPeople = people.stream()
                .filter(person -> person.getId()<= 3)
                .map(person -> {
                    var ssn = person.getSsn();
                    person.setSsn(person.getSsn().substring(7, 11));
                    return person;
                })
                .collect(Collectors.toList());
        System.out.println(newPeople);
    }

    public void ex6() {
        var cats = DataAccess.getCats();
        Collections.sort(cats);
        System.out.println(cats);
    }

    public void ex7() {
        var words = DataAccess.getWords();
        HashMap<String, Integer> hashMap = new HashMap<>();
        var wordArray = words.split(" ");
        var wordList = Arrays.stream(wordArray).toList();
        wordList.stream().forEach(str -> {
            Integer integer = hashMap.get(str);
            if (integer == null)
                hashMap.put(str, 1);
            else {
                hashMap.put(str, integer + 1);
            }
        });
        TreeMap<String, Integer> sortedMap = new TreeMap<>(hashMap);
        sortedMap.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    public void ex8() {
        var people = DataAccess.getPeople();
        var newPeople = people.stream()
                .map(person -> {
                    person.setLastName(null);
                    person.setSsn(null);
                    person.setAge(0);
                    return person;
                })
                .collect(Collectors.toList());
        System.out.println(newPeople);
    }
}
