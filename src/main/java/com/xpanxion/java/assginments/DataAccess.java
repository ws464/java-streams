package com.xpanxion.java.assginments;

import com.xpanxion.java.assginments.model.Person;

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


}
