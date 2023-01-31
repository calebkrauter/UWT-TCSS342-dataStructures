/**
 * @author Caleb Krauter
 * @version Jan, 31 2023
 */

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

/**
 * Polynomial is an ADT implementation that operates on a linked list.
 */

// Question, should a default polynomial be positive?
// ->> Perhaps deal with edge cases where adding or subtracting has a different result due to sign
public class Polynomial {

    /**
     * terms contains literals to be operated on.
     */
    private LinkedList terms;

    /**
     * Constructor
     */
    public Polynomial() {
        terms = new LinkedList();
    }


    // Inserts a term
    // -> Example input:
    // currentPoly = [(null,null)] // Might just set Literal to null instead of each coefficient and exponent
    // ->> Output = [(3, 4) -> (null, null)]

    // Question, what does the current polynomial (currentPoly) contain before any addition?
    // TODO - Test edge cases: Coefficient is zero, coefficient is 1, exponent is 0, coefficient is 1.

    /**
     * A functino for inserting literals given a coefficient and exponent.
     * @param coefficient
     * @param exponent
     */
    public void insertTerm(int coefficient, int exponent) {
        // Don't add a term if it's coefficient is 0.
        if (coefficient == 0) return;

        LinkedList.Iterator firstIterator = terms.zeroth();
        LinkedList.Iterator secondIterator = terms.iterator();
        Literal introducedLiteral = new Literal(coefficient, exponent);

        // Insert introducedLiteral when the list is empty.
        if (terms.isEmpty()) {
            terms.insert(introducedLiteral, firstIterator);
            return;
        }

        // Check edge cases, locate where to insert term and insert introducedLiteral.
        while (firstIterator.hasNext()) {
            // Assign to currentElement the element that is within the node which is addressed by the secondIterator.
            Literal currentElement = (Literal) secondIterator.getNode().getElement();
            // Assign the exponent of the current element in the list to existingExponent.
            int existingExponent = currentElement.getExponent();
            // Assign the coefficient of the current element in the list to existingExponent.
            int existingCoefficient = currentElement.getCoefficient();

            // Compare exponents in the current and existing term. The existing term
            // resides within the literal which is within the node which is within
            // the list to insert in the descending correct order.
            if (exponent > existingExponent) {
                terms.insert(introducedLiteral, firstIterator);
                return;
                // In the case that the exponents are equal, add the "like terms".
            } else if (exponent == existingExponent) {
                // In the case that the sum of the coefficients of the
                // "like terms" is zero, don't insert the newly introduced term.
                if (coefficient + existingCoefficient == 0) {
                    return;
                    // Set the coefficient of the term pointed to by secondIterator equal to the sum of
                    // the current coefficient plus the existing coefficient which resides within
                    // the literal which is within the node which is within the list.
                } else {
                    currentElement.setCoefficient(coefficient + existingCoefficient);
                }
                // The program has iterated to the end of the list, meaning that the current
                // term has an exponent smaller than any other exponent existing within a literal in the list.
                // Insert term where the secondIterator is pointing too.
            } else if (secondIterator.getNode().getNext() == null) {
                terms.insert(introducedLiteral, secondIterator);
                return;
                // In the situation that no cases in the loop were met, advance and repeat.
            } else {
                firstIterator.next();
                secondIterator.next();
            }
        }


    }


    // Clears linked list
    // -> Example input: [-> (3, 4) -> (6, 3) -> (2, 2) ->]
    // ->> Output = [-> (null, null) -> (null, null) -> (null, null)] // Might just set each Literal to null instead of each coefficient and exponent.
    // Question, when setting the first Literal or coefficient and exponent in the first Literal to null how does this effect the rest of the Linked List?
    // ->> My guess is that you can have a linked list full of literals that have null coefficients and exponents, this may be the same with setting the Literal
    // to null assuming the node still contains a pointer. So Perhaps set the first node to null and everything else after it will be
    // eliminated (the pointer and Literal with its contents).
    // TODO - Check for edge cases.
    //      - Test to make sure it does what it should

    /**
     * Sets the polynomial to empty.
     */
    public void zeroPolynomial() {
        terms.makeEmpty();
    }
    // Multiplies the polynomial coefficients by (-1)
    // -> Example input: (2x^2 + 2x + 1)
    // ->> Output: (-2x^2 + -2x + -1)
    // TODO - Test edge cases: A term contains a negative coefficient, coefficient is 1.

    /**
     * Negates the terms in the current linkedlist in the polynomial.
     * @return polynomial that is negated
     */
    public Polynomial negate() {
        Polynomial polynomial = new Polynomial();
        LinkedList.Iterator iterator = terms.zeroth();
        while (iterator.getNode().getNext() != null) {

            Literal element = (Literal) polynomial.terms.iterator().getNode().getElement();
            int negatedValue = -1 * element.getCoefficient();

            element.setCoefficient(negatedValue);
            polynomial.insertTerm(element.getCoefficient(), element.getExponent());
            iterator.next();
        }

        return polynomial;
    }

    // Adds the terms algebraically from the current polynomial to
    // a polynomial passed as an argument.
    // -> Example input:
    // currentPoly = (3x^2 + 2x + 1)
    // additive = (4x^2 + 2x + 2)
    // ->> Output: (7x^2 + 4x + 3)
    // TODO - Test edge cases: Has a not-alike term, negative exponent, coefficient sum equals zero.
    // TODO - add the  polynomial terms in order if the exponents are not equal.

    /**
     * Adds like terms and non-like terms.
     * @param polynomial
     * @return polynomial containing the combined sum of the polynomials.
     */
    public Polynomial plus(Polynomial polynomial) {
        Polynomial polynomialC = new Polynomial();

        LinkedList.Iterator iteratorA = terms.zeroth();
        LinkedList.Iterator iteratorB = polynomial.terms.zeroth();
        LinkedList.Iterator iteratorC = polynomialC.terms.zeroth();

        while (iteratorA.hasNext() || iteratorB.hasNext()) {
            Literal termA = (Literal) terms.iterator().getNode().getElement();
            Literal termB = (Literal) polynomial.terms.iterator().getNode().getElement();

            int currentCoefficientA = termA.getCoefficient();
            int currentCoefficientB = termB.getCoefficient();
            int currentExponentA = termA.getExponent();
            int currentExponentB = termB.getExponent();

            Literal newLiteral = new Literal(currentCoefficientA, currentExponentA);

            // In the case that the exponents of two terms are equal, add the coefficients and make a new literal using the sum
            // as the coefficient and the shared degree.
            if (currentExponentA == currentExponentB && iteratorC.getNode().getNext() == null) {
                // Inserts new term into new polynomial.
                newLiteral.setCoefficient(currentCoefficientA + currentCoefficientB);
                polynomialC.insertTerm(newLiteral.getCoefficient(), currentExponentB);
//                iteratorC.next();
                Literal test1 = (Literal) polynomialC.terms.iterator().getNode().getElement();
                iteratorA.next();
                iteratorB.next();
                break;
            } else if (iteratorC.getNode().getNext() != null) {
                iteratorC.next();
                break;
            } else if (currentExponentA > currentExponentB) {
                newLiteral.setCoefficient(currentCoefficientA);
                newLiteral.setExponent(currentExponentA);
                polynomialC.insertTerm(newLiteral.getCoefficient(), newLiteral.getExponent());
                Literal test1 = (Literal) polynomialC.terms.iterator().getNode().getElement();
                iteratorA.next();
                iteratorC.next();
                break;
            } else if (currentExponentA < currentExponentB) {
                // Expected: insert B and advance B, come across it again and insert
                newLiteral.setCoefficient(currentCoefficientB);
                newLiteral.setExponent(currentExponentB);
                polynomialC.insertTerm(newLiteral.getCoefficient(), newLiteral.getExponent());
                Literal test1 = (Literal) polynomialC.terms.iterator().getNode().getElement();
                iteratorB.next();
                iteratorC.next();
                break;
                // At end of
            } else if (iteratorA.getNode().getNext() == null) {
                newLiteral.setCoefficient(currentCoefficientB);
                newLiteral.setExponent(currentExponentB);
                polynomialC.insertTerm(newLiteral.getCoefficient(), newLiteral.getExponent());
                break;
            } else if (iteratorB.getNode().getNext() == null) {
                newLiteral.setCoefficient(currentCoefficientA);
                newLiteral.setExponent(currentExponentA);
                polynomialC.insertTerm(newLiteral.getCoefficient(), newLiteral.getExponent());
                break;
            } else {
                iteratorA.next();
                iteratorB.next();
            }
        }
        return polynomialC; // Return modified polynomial
    }
    // Subtracts the terms algebraically from the current polynomial to
    // a polynomial passed as an argument.
    // -> Example input:
    // currentPoly = (7x^2 + 4x + 3)
    // subtracted polynomial = (4x^2 + 2x + 2)
    // ->> Output: (3x^2 + 2x + 1)

    // TODO - Test edge cases: Has a not-alike term, negative exponent.

    /**
     * Subtracts two polynomials.
     * @param polynomial
     * @return
     */
    public Polynomial minus(Polynomial polynomial) {
        Polynomial minusedPolynomial = negate().plus(polynomial);
        return minusedPolynomial;
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

    /**
     * Takes the derivative of a polynomial.
     * @return polynomial.
     */
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

    /**
     * Prints out polynomials.
     * @return
     */
    public String print() {
        LinkedList.Iterator thisIter = terms.iterator();
        Literal lit;
        String polyString = "";

        StringBuilder sb = new StringBuilder();
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
}