
// Look at dumb print


// TODO - PROJECT REQUIREMENTS
//      Implement polynomial abstract data type.
//      - Deal with duplicates.
//      - Don't put plus sign before first term.
//      - Us () around negative exponents.
//      - Coefficient should never be zero.
//      - exponent of 1 should never be shown, ((-1), should be ok but check).
//      - insertTerm, negate and derivative should all run in O(n) time where n is the
//      number of terms in the polynomial being operated on.
//      - The functions plus and minus should run in time O(n + m) where n is the number of terms
//      in the first polynomial and m is the number of terms in the second polynomial.
//      - No polynomial is allowed to share terms with another polynomial. For example, after adding
//      two polynomials, all terms in the returned polynomial should not reuse Literals, but all
//      new terms(including reused terms) should have their own new Literal objects.
//      - Polynomial represented in a singly linked list
//      example: [-> (coefficient, exponent) -> (coefficient, exponent) -> (coefficient, exponent) -> END]
//      example 2: input-> [-> (5, 4) -> (2, 3) -> (5, 2) -> END]
//      Output ->> (5x^4 + 2x^3 + 5x^2)


import java.util.Iterator;

// Question, should a default polynomial be positive?
// ->> Perhaps deal with edge cases where adding or subtracting has a different result due to sign
public class Polynomial {
    // Fields
    private LinkedList terms;
//    private static int myExponent = 0;

//    private Polynomial p = ;
    
    // Constructors
    public Polynomial() {
        terms = new LinkedList();
    }

    // Methods

    // Inserts a term
    // -> Example input:
    // currentPoly = [(null,null)] // Might just set Literal to null instead of each coefficient and exponent
    // ->> Output = [(3, 4) -> (null, null)]

    // Question, what does the current polynomial (currentPoly) contain before any addition?
    // TODO - Test edge cases: Coefficient is zero, coefficient is 1, exponent is 0, coefficient is 1.
    public void insertTerm(int coefficient, int exponent) {
        Iterator<ListNode> iterator = terms.iterator();
        Literal literal = new Literal();

        literal.setCoefficient(coefficient);
        literal.setExponent(exponent);
        ListNode listNode = new ListNode(literal);
        Literal prevElement;
        Iterator current = terms.zeroth();
        Iterator previous = current;

        // TODO - keep track of previous element.
//        if (terms.zeroth().hasNext()) {
//            prevElement = (Literal) ((LinkedList.Iterator) iterator).getNode().getElement();
//            if (prevElement.getExponent() > exponent) {
//                terms.insert(prevElement, (LinkedList.Iterator) previous);
//            }
//        } else {
//            terms.insert(literal, (LinkedList.Iterator) previous);
//
//        }

//        if (prevElement.getExponent() > exponent) {
//            terms.insert(prevElement, (LinkedList.Iterator) previous);
//        } else {
            terms.insert(literal, (LinkedList.Iterator) previous);
//        }



    }

//    private void setMinimumExponent(int exponent) {
//        myExponent = exponent;
//    }
//    private int getMinimumExponent()
//

    // Clears linked list
    // -> Example input: [-> (3, 4) -> (6, 3) -> (2, 2) ->]
    // ->> Output = [-> (null, null) -> (null, null) -> (null, null)] // Might just set each Literal to null instead of each coefficient and exponent.

    // Question, when setting the first Literal or coefficient and exponent in the first Literal to null how does this effect the rest of the Linked List?
    // ->> My guess is that you can have a linked list full of literals that have null coefficients and exponents, this may be the same with setting the Literal
    // to null assuming the node still contains a pointer. So Perhaps set the first node to null and everything else after it will be
    // eliminated (the pointer and Literal with its contents).
    // TODO - Check for edge cases.
    public void zeroPolynomial() {
        terms = new LinkedList();
    }

    // Multiplies the polynomial coefficients by (-1)
    // -> Example input: (2x^2 + 2x + 1)
    // ->> Output: (-2x^2 + -2x + -1)
    // TODO - Test edge cases: A term contains a negative coefficient, coefficient is 1.
    public Polynomial negate() {
        Polynomial value = null;
        return value;
    }

    // Adds the terms algebraically from the current polynomial to
    // a polynomial passed as an argument.
    // -> Example input:
    // currentPoly = (3x^2 + 2x + 1)
    // additive = (4x^2 + 2x + 2)
    // ->> Output: (7x^2 + 4x + 3)
    // TODO - Test edge cases: Has a not-alike term, negative exponent.
    public Polynomial plus(Polynomial polynomial) {
        Polynomial value = null;
        return value;
    }

    // Subtracts the terms algebraically from the current polynomial to
    // a polynomial passed as an argument.
    // -> Example input:
    // currentPoly = (7x^2 + 4x + 3)
    // subtracted polynomial = (4x^2 + 2x + 2)
    // ->> Output: (3x^2 + 2x + 1)
    // TODO - Test edge cases: Has a not-alike term, negative exponent.
    public Polynomial minus(Polynomial polynomial) {
        Polynomial value = null;
        return value;
    }

    // Multiplies the terms of two polynomials together.
    // Algebraically this is shown below.
    // -> Example input:
    // currentPoly = (4x^2 + 4x + 2)
    // multiplicative = (4x^3, + 2x^2 + 2x + 1)
    // ->> Output: (8x^3 + 4x^2 + 4x + 2)
    // TODO - Test edge cases: negative coefficient, negative exponent.
    // Review Scratch work -> Pseudo code for the algorithm.
    public Polynomial times(Polynomial polynomial) {
        Polynomial value = null;
        return value;
    } // BONUS method

    // Calculates the derivative of a polynomial as derivatives are defined in calculus.
    // See page 3 of assignment for reference.
    // -> Example input:
    // currentPoly = (4x^4 + 3x^2 + 2x)
    // ->> Output: (16x^3 + 6x + 2)
    // TODO - Test edge cases: Exponent equals 1, exponent equals 0, negative exponent,
    //      containing multiple non-sequential powers (like exponents: 4, 3, 1, not exponents: 4, 3, 2, 1)
    public Polynomial derivative() {
        Polynomial value = null;
        return value;
    }

    // Prints output of any given applied operation over polynomials to the console and to gui.
    // -> Example input: [-> (3,2) -> (4,1) -> (1,0) ->]
    // ->> Output "3x^2 + 4x + 1"
    // TODO - Test for edge cases: What if linked list contains null Literals, null nodes, null coefficient, null exponent,
    //      '+' should not appear in front of polynomial, '-' should appear in front of polynomial depending on case, never a sign '-'/'+' after
    //      a polynomial, add spaces appropriately, no space before a polynomial, no space after polynomial.
    public String print() {
        Iterator thisIter = terms.iterator();
        Literal lit;
        String polyString = "";

        if (!thisIter.hasNext()) {
            return "0";
        }
        while (thisIter.hasNext()) {
            lit = (Literal) thisIter.next();
            polyString = polyString +
                    lit.getCoefficient() + "x^" +
                    lit.getExponent() + "+";
        }
        return polyString;
    }

//    public String DumbPrint ()
//    {
//        Iterator thisIter = terms.iterator();
//        Literal lit;
//        String polyString;
//
//        if (!thisIter.hasNext()) {
//            return “0”;
//        }
//        while (thisIter.hasNext()) {
//            lit = (Literal) thisIter.next();
//            polyString = polyString +
//                    lit.getCoefficient() + “x^” +
//                    lit.getExponent() + “+”;
//        }
//        return polyString;
//    }
}
