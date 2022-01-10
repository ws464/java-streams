# Ex. 1 Department Name
Use a `stream.map()` to add the name of the department to the product list returned from the `DataAccess` class (`getProducts()`).

Example Output:
```
[Product{id=1, departmentId=1, departmentName='Electronics', name='8 Inch Speaker', price=8.0, sku='spk-008'}
, Product{id=2, departmentId=1, departmentName='Electronics', name='10 Inch Speaker', price=10.0, sku='spk-010'}
, Product{id=3, departmentId=1, departmentName='Electronics', name='12 Inch Speaker', price=12.0, sku='spk-012'}
, Product{id=4, departmentId=2, departmentName='Food', name='Bananna', price=1.0, sku='ban-008'}
, Product{id=5, departmentId=2, departmentName='Food', name='Apple', price=2.0, sku='app-008'}
, Product{id=6, departmentId=2, departmentName='Food', name='Orange', price=3.0, sku='ora-008'}
]
```

Bonus points for using a Map (Dictionary) in conjunction with the map function.  This solution can be
as simple as two lines of code.

# Ex. 2 Null to N/A
Use a `stream.map()` to rename the department name to 'N/A' for all the departments:

Example output:
```
[Product{id=1, departmentId=1, departmentName='N/A', name='8 Inch Speaker', price=8.0, sku='spk-008'}
, Product{id=2, departmentId=1, departmentName='N/A', name='10 Inch Speaker', price=10.0, sku='spk-010'}
, Product{id=3, departmentId=1, departmentName='N/A', name='12 Inch Speaker', price=12.0, sku='spk-012'}
, Product{id=4, departmentId=2, departmentName='N/A', name='Bananna', price=1.0, sku='ban-008'}
, Product{id=5, departmentId=2, departmentName='N/A', name='Apple', price=2.0, sku='app-008'}
, Product{id=6, departmentId=2, departmentName='N/A', name='Orange', price=3.0, sku='ora-008'}
]
```

# Ex. 3
Use a `stream.filter()` to return a list that only contains the products for departmentId 1 that are 
equal to or greater than $10.00:

Example output:
```
[Product{id=2, departmentId=1, departmentName='null', name='10 Inch Speaker', price=10.0, sku='spk-010'}
, Product{id=3, departmentId=1, departmentName='null', name='12 Inch Speaker', price=12.0, sku='spk-012'}
]
```

# Ex. 4 Sum of Food
Use functional programming to determine the sum of all the products for the food department:

Example output:
```
$6.00
```

# Ex. 5 Show Four
Use functional programming to only show the last four numbers of a person's social security number for 
people that have an id of 3 or less:

Example output:
```
[Person{id=1, firstName='Alice', lastName='Enchange', age=11, ssn='1111'}
, Person{id=2, firstName='Bob', lastName='Smith', age=22, ssn='2222'}
, Person{id=3, firstName='Charlie', lastName='Jones', age=33, ssn='3333'}
]

```

# Ex. 6 Sorted Cats
Use a Comparator to sort the list of cats by name in ascending order:

Example output:
```
[Cat{id=2, name='Baxie', age=20, color='Black & white'}
, Cat{id=6, name='Binky', age=22, color='Gray'}
, Cat{id=7, name='Blaze', age=21, color='Black'}
, Cat{id=4, name='Gabby', age=13, color='Brown & black'}
, Cat{id=5, name='Jack', age=19, color='Brown'}
, Cat{id=3, name='Lily', age=14, color='Brown'}
, Cat{id=1, name='Rocky', age=19, color='White'}
, Cat{id=8, name='Thomas', age=14, color='Black & Brown'}
]
```

# Ex. 7 Sorted Word Count
Use a `HashMap` to count the number of words returned from `DataAccess.getWords()` and display the list
in alphabetical order:

Example Output:
```
a=2
if=1
is=2
see=1
test=1
this=3
to=1
works=1
```

# Ex. 8


# Ex. 9


# Ex. 10

