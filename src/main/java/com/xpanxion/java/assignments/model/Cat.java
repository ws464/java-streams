package com.xpanxion.java.assignments.model;

import java.util.Objects;

public class Cat {

    //
    // Data members
    //

    private int id;
    private String name;
    private int age;
    private String color;

    //
    // Constructors
    //

    public Cat() {
    }

    public Cat(int id, String name, int age, String color) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
    }

    //
    // Accessors
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //
    // Overrides
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return getId() == cat.getId() && getAge() == cat.getAge() && getName().equals(cat.getName()) && getColor().equals(cat.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getColor());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}' + '\n';
    }
}
