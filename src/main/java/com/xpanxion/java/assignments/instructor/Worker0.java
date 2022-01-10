package com.xpanxion.java.assignments.instructor;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

import javax.xml.crypto.Data;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Worker0 {

    public void ex1() {
        var pList = DataAccess.getProducts();
        var dList = DataAccess.getDepartments();

        Map<Integer, Department> departmentMap = dList.stream().collect(Collectors.toMap(Department::getId, i -> (Department)i));
        var pp = pList.stream().peek(p-> p.setDepartmentName(departmentMap.get(p.getDepartmentId()).getName())).toList();

        System.out.println(pp);
    }

    public void ex2() {
        var pList = DataAccess.getProducts();

        var l = pList.stream().map(p -> {
            p.setDepartmentName("N/A");
            return p;
        }).toList();
        System.out.println(l);
    }

    public void ex3() {
        var pList = DataAccess.getProducts();

        var fList = pList.stream()
                .filter(p -> p.getDepartmentId() == 1)
                .filter(p-> p.getPrice() >= 10.00)
                .toList();
        System.out.println(fList);
    }

    public void ex4() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        var pList = DataAccess.getProducts();
        var d = pList.stream()
                .filter(p -> p.getDepartmentId() == 2)
                .mapToDouble(Product::getPrice).sum();
        System.out.println(formatter.format(d));
    }

    public void ex5() {
        var pList = DataAccess.getPeople();

        var redactedList = pList.stream()
                .filter(p -> p.getId() <= 3)
                .map(p -> {
                    p.setSsn(p.getSsn().substring(7,11));
                return p;
                }).toList();

        System.out.println(redactedList);
    }

    public void ex6() {
        var cList = DataAccess.getCats();

        Comparator<Cat> c = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        cList.sort(c);

        System.out.println(cList);
    }

    public void ex7() {
        var words = DataAccess.getWords();
        var map = new HashMap<String, Integer>();
        var st = new StringTokenizer(words, " ");

        // Build dictionary.
        while (st.hasMoreElements()) {
            var word = st.nextToken();
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }

        // Sort and collect results.
        var sortedKeySet = map.keySet().stream().sorted().toList();
        var list = sortedKeySet.stream().map(k -> k + " = " + map.get(k)).toList();

        // Display results.
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void ex8() {

    }

    public void ex9() {

    }

    public void ex10() {

    }

}
