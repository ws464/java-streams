package com.xpanxion.java.assignments.instructor;

import com.xpanxion.java.assignments.DataAccess;

public class Worker0 {

    public void ex1() {
        var p = DataAccess.getPeople();
        var c = DataAccess.getCats();
        System.out.println(c);
    }
}
