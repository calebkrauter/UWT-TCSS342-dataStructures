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
        int decimal = 66;
        // Initialize the sum to 0 for accurate calculations.
        int sum = 0;
        octalDigitSum(decimal, sum);
    }

    /**
     * octalDigitSum calculates using recursion the sum of the octal digits from a given
     * a decimal number. The decimal number is converted to octal digits that are added
     * to form the "octal digit sum". If the digits are in the correct order they can
     * form a string of digits representing an octal number which is not done in this method.
     * @param n input value representing a base 10 decimal value.
     * @param sum input sum initialized at 0 that adds the sum in each call to the function
     *            giving the result.
     * @return the sum of the octal digits that in the right order form the octal converted value for n.
     */
    private static int octalDigitSum(int n, int sum) {
        
        // Divide n by 8 to get a quotient for the next division.
        int quotient = n / 8;
        
        // Get the remainder of the current input value divided by 8.
        int remainder = n % 8;
        
        // Add the remainder to our sum to get our octal digit sum.
        sum += remainder;
        
        // Base case, if our quotient is 0 we will return the sum,
        // if the quotient is greater than 0, call octalDigitSum and
        // pass the current quotient and the current sum.
        if (quotient > 0) {
            return octalDigitSum(quotient, sum);
        }
        return sum;
    }
}