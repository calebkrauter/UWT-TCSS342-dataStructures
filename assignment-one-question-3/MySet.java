/**
 * @author Caleb Krauter
 * @version 1.0
 * January 10 2023
 */

import java.util.Arrays;

/**
 * A collection built from an
 * array created to mimic a set containing Objects.
 */
public class MySet {

    /**
     * An array containing Objects
     */
    private Object[] array;

    /**
     * An array containing Objects
     */
    private Object[] newArray;

    /**
     * An arbitrary Object.
     */
    private static final Object obj1 = 1;

    /**
     * An arbitrary Object.
     */
    private static final Object obj2 = 2;

    /**
     * An arbitrary Object.
     */
    private static final Object obj3 = 3;

    /**
     * An arbitrary Object.
     */
    private static final Object obj4 = "One";

    /**
     * An arbitrary Object.
     */
    private static final Object obj5 = "Two";

    /**
     * An arbitrary Object.
     */
    private static final Object obj6 = 3;

    /**
     * An index counter.
     */
    private int myIndexCounter = 0;

    /**
     * A counter.
     */
    private int mySecondCounter = 0;

    /**
     * A constructor for MySet
     */
    public MySet() {

        // Creates array to collect Objects.
        array = new Object[mySecondCounter++];

        // Function to test all methods and edge cases.
        test();
    }

    /**
     * Checks if the collection is empty.
     * @return boolean.
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Sets the collection to empty.
     */
    public void makeEmpty() {
        mySecondCounter = 0;
        array = new Object[mySecondCounter++];
    }

    /**
     * Gets the size of the collection.
     * @return int length of array.
     */
    public int size() {
        return array.length;
    }

    /**
     * Function for inserting Objects into the collection.
     * @param theObject
     */
    public void insert(Object theObject) {
        if (isEmpty()) {
            myIndexCounter = 0;
        }

        // Replace array index with counter variable.
        mySecondCounter = myIndexCounter + 1;
        array = Arrays.copyOf(array, mySecondCounter++);
        array[myIndexCounter] = theObject;
        myIndexCounter++;
    }

    /**
     * Function for removing Objects from the collection.
     * @param x
     */
    public void remove(Object x) {
        for (int i = 0; i < size(); i++) {
            newArray = Arrays.copyOf(array, size() - 1);

            // Bad item at end then cut off end of the array.
            if (array[i].equals(array[size() - 1]) && array[i].equals(x)) {

                array = newArray;
            } else if (array[i].equals(x)) {

                // Swap consecutive pairs until bad item is at end and is cut off.
                for (int j = i + 1; size() > j; j++) {
                    newArray[i] = array[j];
                    i++;
                }
                array = newArray;
            }
        }
    }

    /**
     * Checks if an object is already present in the collection.
     * @param x
     * @return boolean value.
     */
    public boolean isPresent(Object x) {
        boolean isPresent = false;
        for (Object currentObject : array) {
            if(currentObject.equals(x)) {
                isPresent = true;
            } else {
                isPresent = false;
            }
        }
        return isPresent;
    }

    /**
     * A function that tests all methods and shares results in the console through
     * print statements.
     */
    public void test() {

        // Test size() should return 0 since no Objects have been inserted.
        size();
        System.out.println("Size " + size());

        // Test isEmpty() should return true.
        isEmpty();
        System.out.println(isEmpty());

        // Test insertion of different Objects.
        // The array automatically resizes, so it is not possible to
        // add an Object when the array is full.
        insert(obj1);
        insert(obj2);
        insert(obj2);
        insert(obj3);
        insert(obj4);
        insert(obj5);
        insert(obj6);
        System.out.println("Full collection " + Arrays.toString(array));
        // Test size() should return 7 because that is the amount of inserted Objects.
        size();
        System.out.println("Size " + size());

        // Test isPresent() should return true because obj3 is in the collection.
        isPresent(obj3);
        System.out.println("Object isPresent: " + isPresent(obj3));

        // Test isEmpty() should return false.
        isEmpty();
        System.out.println(isEmpty());

        // Test removal duplicate Objects.
        remove(obj2);
        remove(obj2);
        System.out.println(Arrays.toString(array));
        // Test removal of first Object.
        remove(obj1);
        System.out.println(Arrays.toString(array));
        // Test removal of last Object.
        remove(obj3);
        System.out.println(Arrays.toString(array));
        // Test removal of all Objects.
        remove(obj4);
        System.out.println(Arrays.toString(array));
        remove(obj5);
        System.out.println(Arrays.toString(array));
        remove(obj6);
        System.out.println(Arrays.toString(array));

        // Test isEmpty() should return true.
        isEmpty();

        insert(obj1);
        insert(obj2);
        System.out.println(Arrays.toString(array));

        // Test makeEmpty()
        makeEmpty();
        System.out.println(Arrays.toString(array));

        // Test isPresent() should return false because obj3 is not in the collection.
        isPresent(obj3);
        System.out.println("Object isPresent: " + isPresent(obj3));
    }

}
