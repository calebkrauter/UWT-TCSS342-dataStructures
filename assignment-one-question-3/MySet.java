import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

public class MySet {
// stores a collection of Objects (in an array
// stores current size of the collection

    private Object[] array;
    private Object[] newArray;
    private int myIndexCounter = 0;
    private Object[] newArray2;

    int myCollectionSize = 6;
    final Integer x = 2;
    final Integer obj1 = 1;
    final Integer obj2 = 2;
    final Integer obj3 = 3;
    final Integer obj4 = 1;
    final Integer obj5 = 2;
    final Integer obj6 = 3;
    int arraySizeCounter = 0;

    public MySet() {

        array = new Object[arraySizeCounter++];

        // Creates array to collect objects.

        test();
    }

    public boolean isEmpty() {
        return true;
    }
    public void makeEmpty() {

    }
    public int size() {
        return 0;
    }


    public void insert(Object theObject) {
        // Replace array index with counter variable.
        arraySizeCounter = myIndexCounter + 1;
        array = Arrays.copyOf(array, arraySizeCounter++);
        array[myIndexCounter] = theObject;
        myIndexCounter++;
    }
    public void remove(Object x) {
        if (array.length > 2) {
            for (int i = 0; i < array.length; i++) {
                // Replace == with .equals()

                newArray = Arrays.copyOf(array, array.length - 1);

                // Bad item at end then cut off end.
                if (array[i].equals(array[array.length - 1]) && array[i].equals(x)) {

                    array = newArray;
                } else if (array[i].equals(x)) {
                    // Swap consecutive pairs until bad item is at end and is cut off.
                    for (int j = i + 1; array.length > j; j++) {
                        newArray[i] = array[j];
                        i++;
                    }
                    array = newArray;
                }
            }
        }
    }

    public boolean isPresent() {
        return false;
    }
    public void test() {

        // Test insertion of different Objects
        insert(obj1);
        insert(obj2);
        insert(obj3);
        insert(obj4);
        insert(obj5);
        insert(obj6);
        System.out.println("Full array " + Arrays.toString(array));

        // Test removal duplicate objects.
        remove(obj2);
        System.out.println(Arrays.toString(array));
        remove(obj2);
        System.out.println(Arrays.toString(array));
        // Test removal of first object.
        remove(obj1);
        System.out.println(Arrays.toString(array));
        // Test removal of last object.
        remove(obj3);
        System.out.println(Arrays.toString(array));

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
