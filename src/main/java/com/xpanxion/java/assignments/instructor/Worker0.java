package com.xpanxion.java.assignments.instructor;

import com.xpanxion.java.assignments.DataAccess;

public class Worker0 {

    public void ex1() {
        var p = DataAccess.getPeople();
        var c = DataAccess.getCats();
        var pp = DataAccess.getProducts();
        var d = DataAccess.getDepartments();
        System.out.println(p);
        System.out.println(c);
        System.out.println(pp);
        System.out.println(d);
    }
}
