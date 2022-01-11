package com.xpanxion.java.assignments.student3;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Worker3 {

    private List<Product> products = DataAccess.getProducts();
    private List<Department> departments = DataAccess.getDepartments();
    private List<Person> people = DataAccess.getPeople();
    private List<Cat> cats = DataAccess.getCats();
    private String words = DataAccess.getWords();

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

    public void ex5(){
        System.out.println("Ex. 5...");

        var l = people.stream().filter(p -> p.getId() <= 3).map(p -> {
            var ssn = p.getSsn();
            var last = ssn.substring(7);
            p.setSsn(last);
            return p;
        }).toList();

        System.out.println(l);
    }

    public void ex6(){
        System.out.println("Ex. 6...");

        var l = cats.stream()
                .sorted(Comparator.comparing(p -> p.getName()))
                .toList();

        System.out.println(l);
    }

    public void ex7(){
        System.out.println("Ex. 7...");

        Map<String, Integer> wordMap = new TreeMap<>();
        var stringTokenizer = new StringTokenizer(words);

        while (stringTokenizer.hasMoreTokens()){
            var w = stringTokenizer.nextToken();
            var count = w.length();
            wordMap.put(w, count);
        }

        wordMap.forEach((w, count) -> System.out.println(w + " = " + count));

    }

    public void ex8(){
        System.out.println("Ex. 8...");

        var l = people.stream().map(p -> {
            String nullifyString = "null";
            int nullifyInt = 0;
            p.setLastName(nullifyString);
            p.setSsn(nullifyString);
            p.setAge(nullifyInt);
            return p;
        }).toList();

        System.out.println(l);
    }

    public void ex9(){
        System.out.println("Ex. 9...");

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        var l = products.stream().map(p -> {
            var newPrice = p.getPrice() + 2.0f;
            p.setPrice(newPrice);
            return p;
        }).mapToDouble(Product::getPrice).sum();

        var totalCost = formatter.format(l);

        System.out.println(totalCost);
    }
}
