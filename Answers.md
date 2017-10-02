## COMP 271 F17 002 Lab 3

##### Completed by: Linda Ho


#### Try all the tests with a LinkedList - does it make any difference?

No, all the tests ran with the same results because ArrayList and LinkedLists both fulfill the functional requirements of the List interface. This is true for the methods in the TestList and TestIterator classes.


#### What does the first remove method do in the testRemoveObject?

```
list.remove(5); 
```

Removes the element at the specified index location

#### What does the  second remove method do in the testRemoveObject?

```
list.remove(Integer.valueOf(5));
```

Removes the first occurrence of an Integer equal to 5 in the list.

#### Run test and record running times for SIZE = 10, 100, 1000, 10000

    ArrayList Access with size of 10 took: 22
    LinkedList AddRemove with size of 10 took: 88
    LinkedList Access with size of 10 took: 23
    ArrayList AddRemove with size of 10 took: 45

    ArrayList Access with size of 100 took: 42
    LinkedList AddRemove with size of 100 took: 72
    LinkedList Access with size of 100 took: 55
    ArrayList AddRemove with size of 100 took: 116

    ArrayList Access with size of 1000 took: 17
    LinkedList AddRemove with size of 1000 took: 83
    LinkedList Access with size of 1000 took: 462
    ArrayList AddRemove with size of 1000 took: 274

    ArrayList Access with size of 10000 took: 26
    LinkedList AddRemove with size of 10000 took: 129
    LinkedList Access with size of 10000 took: 6593
    ArrayList AddRemove with size of 10000 took: 2444

#### Which of the two lists performs better as the size increases?

ArrayList performs better when accessing elements. LinkedLists perform better when adding or removing the first item of a list.



