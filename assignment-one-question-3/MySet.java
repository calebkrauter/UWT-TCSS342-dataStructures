import java.util.Arrays;

public class MySet {
// stores a collection of Objects (in an array
// stores current size of the collection

    private int myCollectionSize;
    private Object[] myArray;
    private static int i = -1;

    public MySet(int theCollectionSize) {
        myCollectionSize = theCollectionSize;
        myArray = new Object[myCollectionSize];

    }


public boolean isEmpty(boolean theBooleanValue) {
    return theBooleanValue;
}
public void makeEmpty() {
    myArray = new Object[0];
    isEmpty(true);
}
public int size() {
    return myCollectionSize;
}
public void insert() {
    i++;
    myArray.getClass()
}
public void remove(Object x) {
    myArray = Arrays.stream(myArray).filter(Object -> myArray.getClass().equals(x)).toArray();

}

/*
i = -1
i++
if obj at i equals x
    return new array containing size-1 not including currentObject at the current index// perhaps use a stream
else return array
 */

/*
   old array[1,3,2,6]
   found x = 3
   new array[]
 */

public boolean isPresent() {
    return false;
}
public void test() {

}

}



//    Write a Java class called MySet,
//    TODO REQUIREMENTS - that stores a collection of Objects (in an array) along
//        with the current size of the collection.
//    TODO REQUIREMENTS - An instance of MySet should behave just like a set:
//        to the caller of the methods, there is no order associated with the items in the
//        MySet object.
//    TODO REQUIREMENTS - Furthermore, there should not be two items in the MySet that are
//        .equals() to each other as a result of any of the MySet methods.
//
//    TODO - Provide public methods isEmpty, makeEmpty, size, insert, remove, and
//        isPresent.
//    TODO REQUIREMENTS - remove(x) should remove an item from the array that is equal to x (as
//        defined by equals).
//    TODO REQUIREMENTS - isPresent(x) returns true if and only if an Object that is equal
//        to x (as defined by equals) is present in the collection.
//    TODO - Carefully think about what the
//        parameters to the above methods are.
//    TODO - Write a method called test that makes calls to
//        your methods to demonstrate that they behave correctly. Be sure to test boundary
//        cases, such as inserting an item when the array is full.
