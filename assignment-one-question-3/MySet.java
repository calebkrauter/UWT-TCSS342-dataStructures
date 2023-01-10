import java.util.Arrays;

public class MySet {
// stores a collection of Objects (in an array
// stores current size of the collection

    private Object[] array;
    private Object[] newArray;
    private int myIndexCounter = 0;

    final Object obj1 = 1;
    final Object obj2 = 2;
    final Object obj3 = 3;
    final Object obj4 = "One";
    final Object obj5 = "Two";
    final Object obj6 = 3;
    int arraySizeCounter = 0;

    public MySet() {

        // Creates array to collect objects.
        array = new Object[arraySizeCounter++];

        // Function to test all methods and edge cases.
        test();
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public void makeEmpty() {
        arraySizeCounter = 0;
        array = new Object[arraySizeCounter++];
    }

    public int size() {
        return array.length;
    }


    public void insert(Object theObject) {
        if (isEmpty()) {
            myIndexCounter = 0;
        }

        // Replace array index with counter variable.
        arraySizeCounter = myIndexCounter + 1;
        array = Arrays.copyOf(array, arraySizeCounter++);
        array[myIndexCounter] = theObject;
        myIndexCounter++;
    }

    public void remove(Object x) {
        for (int i = 0; i < size(); i++) {
            newArray = Arrays.copyOf(array, size() - 1);

            // Bad item at end then cut off end.
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

    public void test() {

        // Test size() should return 0 since no objects have been inserted.
        size();
        System.out.println("Size " + size());

        // Test isEmpty() should return true.
        isEmpty();
        System.out.println(isEmpty());

        // Test insertion of different Objects.
        // The array automatically resizes, so it is not possible to
        // add an object when the array is full.
        insert(obj1);
        insert(obj2);
        insert(obj2);
        insert(obj3);
        insert(obj4);
        insert(obj5);
        insert(obj6);
        System.out.println("Full collection " + Arrays.toString(array));
        // Test size() should return 7 because that is the amount of inserted objects.
        size();
        System.out.println("Size " + size());

        // Test isPresent() should return true because obj3 is in the collection.
        isPresent(obj3);
        System.out.println("Object isPresent: " + isPresent(obj3));

        // Test isEmpty() should return false.
        isEmpty();
        System.out.println(isEmpty());

        // Test removal duplicate objects.
        remove(obj2);
        remove(obj2);
        System.out.println(Arrays.toString(array));
        // Test removal of first object.
        remove(obj1);
        System.out.println(Arrays.toString(array));
        // Test removal of last object.
        remove(obj3);
        System.out.println(Arrays.toString(array));
        // Test removal of all objects.
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
        System.out.println(isPresent("Object isPresent: " + obj3));
    }

}
