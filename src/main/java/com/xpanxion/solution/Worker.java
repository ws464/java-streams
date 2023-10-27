package com.xpanxion.solution;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

public class Worker {
    public void ex1 () {
        var list = DataAccess.getProducts();
        var departments = new HashMap<Integer, String>();
        departments.put(1, "Electronics");
        departments.put(2, "Food");
        departments.put(3, "Automotive");
        departments.put(4, "Home");
        var newList = list.stream().map(p -> new Product(p.getId(), p.getDepartmentId(), departments.get(p.getDepartmentId()), p.getName(), p.getPrice(), p.getSku())).collect(Collectors.toList());
        System.out.println(newList.toString());
    }
    public void ex2 () {
        var list = DataAccess.getProducts();
        var newList = list.stream().map(p -> new Product(p.getId(), p.getDepartmentId(), "N/A", p.getName(), p.getPrice(), p.getSku())).collect(Collectors.toList());
        System.out.println(newList.toString());
    }
    public void ex3 () {
        var list = DataAccess.getProducts();
        var newList = list.stream().filter(p -> (p.getDepartmentId()==1 && p.getPrice()>=(float)10.0)).collect(Collectors.toList());
        System.out.println(newList.toString());
    }
    public void ex4 () {
        var list = DataAccess.getProducts();
        var sum = list.stream().filter(p->p.getDepartmentId()==2).collect(Collectors.summingDouble(Product::getPrice));
        System.out.println("$"+sum);
    }
    public void ex5 () {
        var list = DataAccess.getPeople();
        var newList = list.stream().map(p -> new Person(p.getId(), p.getFirstName(), p.getLastName(), p.getAge(), (p.getId()<=3)?p.getSsn().substring(p.getSsn().length()-4):p.getSsn())).collect(Collectors.toList());
        System.out.println(newList.toString());
    }
    public void ex6 () {
        var list = DataAccess.getCats();
        list.sort((c1, c2)-> c1.getName().compareTo(c2.getName()));
        System.out.println(list.toString());
    }
    public void ex7 () {
        var words = new HashMap<String, Integer>();
        var list = DataAccess.getWords().split("\s+");
        for(String w : list){
            if(words.containsKey(w)){
                words.put(w, words.get(w)+1);
            }
            else{
                words.put(w, 1);
            }
        }
        var wordsAZ = words.keySet().stream().collect(Collectors.toList());
        wordsAZ.sort((c1, c2)-> c1.compareTo(c2));
        for(String w : wordsAZ){
            System.out.println(String.format("%s = %d",w, words.get(w)));
        }
    }
}
