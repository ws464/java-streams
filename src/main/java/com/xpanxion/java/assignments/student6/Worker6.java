package com.xpanxion.java.assignments.student6;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Worker6 {

    public void ex1() {
        List<Product> productList = DataAccess.getProducts();
        List<Department> departmentList = DataAccess.getDepartments();

        Map<Integer, Department> departmentMap = departmentList.stream().collect(Collectors.toMap(Department::getId, i -> (Department)i));
        List<Product> newProductList = productList.stream().map(p -> {
            p.setDepartmentName(departmentMap.get(p.getDepartmentId()).getName());
            return p;
        }).toList();

        System.out.println(newProductList);
    }

    public void ex2() {
        List<Product> productList = DataAccess.getProducts();
        List<Product> newProductList = productList.stream().map(p -> {
            p.setDepartmentName("N/A");
            return p;
        }).toList();
        System.out.println(newProductList);

    }

    public void ex3() {
        List<Product> productList = DataAccess.getProducts();
        List<Product> newProductList = productList.stream().filter(p -> p.getDepartmentId() == 1).filter(p -> p.getPrice() >= 10).toList();
        System.out.println(newProductList);
    }

    public void ex4() {
        List<Product> productList = DataAccess.getProducts();
        double price = productList.stream().filter(p -> p.getDepartmentId() == 2).mapToDouble(Product::getPrice).sum();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(price));
    }

    public void ex5() {
        List<Person> personList = DataAccess.getPeople();
        List<Person> newPersonList = personList.stream().filter(p -> p.getId() <= 3).map(p -> {
            p.setSsn(p.getSsn().substring(7,11));
            return p;
        }).toList();
        System.out.println(newPersonList);
    }

    public void ex6() {
        List<Cat> catList = DataAccess.getCats();
        Comparator<Cat> catComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        catList.sort(catComparator);
        System.out.println(catList);
    }

    public void ex7() {
        String words = DataAccess.getWords();
        HashMap<String, Integer> hm = new HashMap<>();
        String [] holder = words.split(" ");
        int index = 0;
        while (index < holder.length) {
            String word = holder[index];
            index++;
            if (hm.containsKey(word))
                hm.put(word, hm.get(word) + 1);
            else
                hm.put(word, 1);
        }

        List<String> sortKeys = hm.keySet().stream().sorted().toList();
        List<String> results = sortKeys.stream().map(k -> k + " = " + hm.get(k)).toList();
        results.forEach(System.out::println);
    }

    public void ex8() {
        List<Person> personList = DataAccess.getPeople();
        List<Person> newPersonList = personList.stream().map(p -> {
            Person newPerson = new Person();
            newPerson.setId(p.getId());
            newPerson.setFirstName(p.getFirstName());
            return newPerson;
        }).toList();
        System.out.println(newPersonList);
    }
}
