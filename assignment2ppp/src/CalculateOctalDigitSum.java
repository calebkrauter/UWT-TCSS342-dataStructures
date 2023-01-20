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
        octalDigitSum(66);
        System.out.println(octalDigitSum(66));
    }

    /**
     * octalDigitSum calculates using recursion the sum of the octal digits from a given
     * a decimal number. The decimal number is converted to octal digits that are added
     * to form the "octal digit sum". If the digits are in the correct order they can
     * form a string of digits representing an octal number which is not done in this method.
     * @param n input value representing a base 10 decimal value.
     * @return the sum of the octal digits.
     */
    private static int octalDigitSum(int n) {
        // (During recursive calls), find the remainder and add it to the call
        // on octalDigitSum with n / 8 passed in for n.
        // The recursion will cause an unravelling effect
        // adding the remainders together after the base case is hit.
        // I wrote this in one line to clean up code and I
        // have no variable assignments making for more efficient code.
        return (n == 0) ? 0 : (n % 8 + octalDigitSum(n / 8));
   }
}