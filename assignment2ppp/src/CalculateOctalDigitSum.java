public class CalculateOctalDigitSum {
    public static void main(String[] args) {
        // Use any positive integer. I use 66 here.
        int octal1 = 66;
        // Initialize the sum to 0 for accurate calculations.
        int sum = 0;
        octalDigitSum(octal1, sum);
    }

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