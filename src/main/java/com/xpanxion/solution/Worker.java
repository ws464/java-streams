package com.xpanxion.solution;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
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
}
