package com.xpanxion.java.assignments;

import com.xpanxion.java.assignments.model.Cat;
import com.xpanxion.java.assignments.model.Person;

import java.util.Arrays;
import java.util.List;

public class DataAccess {

        public static List<Person> getPeople() {
                return Arrays.asList(
                        new Person(1, "Alice", "Enchange", 11, "111-11-1111"),
                        new Person(2, "Bob", "Smith", 22, "222-22-2222"),
                        new Person(3, "Charlie", "Jones", 33, "333-33-3333"),
                        new Person(4, "Dan", "Updegraf", 44, "444-44-4444"),
                        new Person(5, "Egar", "Harly", 55, "555-55-55555"),
                        new Person(6, "Frank", "Gamble", 66, "666-66-6666"),
                        new Person(7, "Guthrie", "Govan", 77, "777-77-7777"),
                        new Person(8, "Harry", "Code", 88, "888-88-8888"));
        }

        public static List<Cat> getCats() {
                return Arrays.asList(
                        new Cat(1, "Rocky", 19, "White"),
                        new Cat(2, "Baxie", 20, "Black & white"),
                        new Cat(3, "Lily", 14, "Brown"),
                        new Cat(4, "Gabby", 13, "Brown & black"),
                        new Cat(5, "Jack", 19, "Brown"),
                        new Cat(6, "Binky", 22, "Gray"),
                        new Cat(7, "Blaze", 21, "Black"),
                        new Cat(8, "Thomas", 14, "Black & Brown"));
        }

}
