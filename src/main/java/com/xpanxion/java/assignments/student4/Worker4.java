package com.xpanxion.java.assignments.student4;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;
import java.util.*;
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

    public void ex6(){
        var catList=DataAccess.getCats();
        var result=catList.stream()
                .sorted(Comparator.comparing(Cat::getName))
                .toList();
        System.out.println(result);
    }

    public void ex7() {
        var worList = DataAccess.getWords();
        Map<String, Integer> result = new HashMap<>();
        String[] tokens = worList.split(" "); // split based on space

        for (String token : tokens) {

            String word = token.toLowerCase();
            if (result.containsKey(word)) {
                int count = result.get(word); // get word count
                result.put(word, count + 1); // override word count
            } else {
                result.put(word, 1); // initial word count to 1
            }
        }
        Set<String> keys = result.keySet(); // list of unique words because it's a Set
        TreeSet<String> sortedKeys = new TreeSet<>(keys); // ascending order of words
        for (String str : sortedKeys) {
            System.out.println(str + " = " + result.get(str));
        }
    }

    public void ex8() {
        var perList = DataAccess.getPeople();
        var result = perList.stream().map(p -> {
            p.setLastName("null");
            p.setAge(0);
            p.setSsn("null");
            return p;
        }).toList();
        System.out.println(result);
    }
}
