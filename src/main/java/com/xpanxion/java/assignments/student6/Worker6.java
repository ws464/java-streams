package com.xpanxion.java.assignments.student6;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Person;
import com.xpanxion.java.assignments.model.Product;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
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
}
