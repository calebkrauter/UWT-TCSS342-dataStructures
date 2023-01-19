/**
 * @Author Caleb Krauter
 * @Version 1.0
 */

/**
 * CalculateOctalDigitSum is a program that takes a positive-integer number known
 * as a decimal and adds the converted octal digits to form the "octal digit sum".
 * If the digits are in the correct order they form an octal number. Since this
 * is just a sum calculator the order of the digits is ignored.
 */
public class CalculateOctalDigitSum {
    public static void main(String[] args) {
        // Use any positive integer. I use 66 here.
        int decimal = 512;
        // Initialize the sum to 0 for accurate calculations.
        //int sum = 0;
        //octalDigitSum(decimal);
        System.out.println(octalDigitSum(decimal));
    }

    /**
     * octalDigitSum calculates using recursion the sum of the octal digits from a given
     * a decimal number. The decimal number is converted to octal digits that are added
     * to form the "octal digit sum". If the digits are in the correct order they can
     * form a string of digits representing an octal number which is not done in this method.
     * @param n input value representing a base 10 decimal value.
     // * @param sum input sum initialized at 0 that adds the sum in each call to the function
     *            giving the result.
     * @return the sum of the octal digits that in the right order form the octal converted value for n.
     */
    private static int octalDigitSum(int n) {
        int sum = 0;
        if (n > 0) {
            sum = n % 8;
            return sum +=octalDigitSum(n/8);
        }
        return sum;
       // int sum = 0;
//        int callCounter = 0;
//        // Divide n by 8 to get a quotient for the next division.
//        int quotient = n / 8;
//
//        // Get the remainder of the current input value divided by 8.
//        int remainder = n % 8;
//
//        // Add the remainder to our sum to get our octal digit sum.
////        if (callCounter == 0) {
//           // int sum = 0;
////        } else {
//            //sum += remainder;
////        }
//        // Base case, if our quotient is 0 we will return the sum,
//        // if the quotient is greater than 0, call octalDigitSum and
//        // pass the current quotient and the current sum.
//        if (quotient > 0) {
//            callCounter++;
//            return octalDigitSum(quotient);
//        }
//        return ;
    }
}

// Idea one: return an unraveling addition of the remainders
// Idea two, find a way to initialize the sum during only the first pass.

// pass in 14
//    private static int octalDigitSum(int n) { //pass 1; n = 14 // pass 2 n = 6
//        int quotient = n / 8; // Q = 1 // Q = 0
//        int remainder = n % 8; // R = 6 // R = 1
//        if (quotient > 0) { // True // False
//            return octalDigitSum(quotient); // Send Q = 6
//        }
//        return sum of R;
//    }
//
//
// pass in 14
//    private static int octalDigitSum(int n) { //pass 1; n = 14 // pass 2 n = 6
//          return sum +=octalDigitSum(n)