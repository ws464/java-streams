package com.xpanxion.java.assignments.student9;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Worker9 {



    public void ex1() {

        Map<Integer, Department> departmentMap = DataAccess.getDepartments().stream()
                .collect(Collectors.toMap(Department::getId, Function.identity()));
        ;
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
}
