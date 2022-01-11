package com.xpanxion.java.assignments.student9;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Worker9 {



    public void ex1() {

        Map<Integer, Department> departmentMap = DataAccess.getDepartments().stream()
                .collect(Collectors.toMap(Department::getId, Function.identity()));

        var tempProducts = DataAccess.getProducts();

        var newList = tempProducts.stream().map(m->
        {
            var productId = m.getId();
            var departmentId = m.getDepartmentId();
            var departName = departmentMap.get(m.getDepartmentId()).getName();
            var name = m.getName();
            var price = m.getPrice();
            var sku = m.getSku();
            return new Product(productId,departmentId,departName,name,price,sku);
        }).toList();

        System.out.println(newList);
    }

    public void ex2(){
        var tempProducts = DataAccess.getProducts();

        var newList = tempProducts.stream().map(m->
        {
            var productId = m.getId();
            var departmentId = m.getDepartmentId();
            var departName = "N/A";
            var name = m.getName();
            var price = m.getPrice();
            var sku = m.getSku();
            return new Product(productId,departmentId,departName,name,price,sku);
        }).toList();

        System.out.println(newList);
    }

    public void ex3(){
        var tempProducts = DataAccess.getProducts();
        var greaterThan10 = tempProducts.stream().filter(p ->
                p.getDepartmentId() == 1 && p.getPrice() >= 10).toList();

        System.out.println(greaterThan10);
    }

    public void ex4() {
        var foodList = DataAccess.getProducts().stream().filter(p -> p.getDepartmentId() ==2).toList();
        var sum = foodList.stream().map(Product::getPrice).reduce(0.0F,Float::sum);
        System.out.println(sum);
    }
    public void ex5() {
        var personList = DataAccess.getPeople().stream().filter(p ->p.getId() <=3).toList();
        var newList = personList.stream().map( m-> {
            var id = m.getId();
            var firstName = m.getFirstName();
            var lastName = m.getLastName();
            var age = m.getAge();
            var last4 = m.getSsn().substring(7,11);
            return new Person(id,firstName,lastName,age,last4);
        }).toList();
        System.out.println(newList);
    }
    public void ex6() {
        var catList =DataAccess.getCats();
        catList.sort(Comparator.comparing(Cat::getName));
        System.out.println(catList);
    }
    public void ex7() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        var tempString = DataAccess.getWords();
        String[] words = tempString.split(" ");
        var count = 0;

        while(count < words.length){
           Integer integer = hashMap.get(words[count]);
           if(integer == null){
               hashMap.put(words[count],1);
           } else {
               hashMap.put(words[count],integer+1);
           }
           count++;
        }

        TreeMap<String, Integer> sorted = new TreeMap<>(hashMap);

        System.out.println(sorted);
    }
    public void ex8() {
        var tempPeople = DataAccess.getPeople();
        var newList = tempPeople.stream().map( m -> {
            var id = m.getId();
            var first = m.getFirstName();
            var age = 0;
            return new Person(id,first,age);
        }).toList();
        System.out.println(newList);
    }

    public void ex9() {
        var tempPrices = DataAccess.getProducts().stream().filter(p -> p.getDepartmentId()==1).toList();
        var updatedPriceList = tempPrices.stream().map(p
                -> p.getPrice()+2.00F).reduce(0.0F,Float::sum);
        System.out.println(updatedPriceList);
    }
}
