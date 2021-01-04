/*
Ziad Malik
Section U01
PolynomialTester.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package polynomials;

/**
 * The Tester Class, which was created by the Instructor is where The Two 
 * Classes I have Created are tested. Using all the methods we have created
 * within the other classes, this Tester Class will make sure they work Properly
 * (See Output)
 * @author Greg Shaw
 */
public class PolynomialTester {

    public static void main(String[] args) {
        /*
        p1,p2,p0 are all Local Polynomials that are used to test the Two other
        Classes
        */
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial p0 = new Polynomial();
        /*
        Polynomial Nulltest, a local Polynomial checks to see if the Constructor
        of my Polynomial Class is correct. (What happens if a Polynomial with 
        no terms is added to a Polynomial with also no terms).
        */
        Polynomial nullTest = p1.polyAdd(p2); //polyAdd Method Tested
        System.out.println("\np1 = " + p1 + ", np2 = " + p2 + "\tp1 + p2 = "
                + nullTest);
        nullTest = p1.polyMultiply(p2); //polyMultiply Method Tested
        System.out.println("\np1 = " + p1 + ", np2 = " + p2 + "\tp1 * p2 is "
                + nullTest);

        //addTerm Method Tested.
        p1.addTerm(7, 1);
        p1.addTerm(8, 1);
        p1.addTerm(6, 1);
        p1.addTerm(5, 1);
       

        System.out.println("\np0 = " + p0);
        /*
        New Polynomails made that are Initialzied to the Sum or Product of two
        other terms using the polyAdd and polyMultiply Methods.
        */
        Polynomial p3 = p1.polyAdd(p2);
        System.out.println("\np1 = " + p1 + "\np2 = " + p2 + "\np1+p2 = " + p3);

        Polynomial p4 = p1.polyMultiply(p2);
        System.out.println("\np1 = " + p1 + "\np2 = " + p2 + "\np1*p2 = " + p4);

        Polynomial p5 = p2.polyMultiply(p2);
        System.out.println("\np2 = " + p2 + "\np2*p2 = " + p5);

        Polynomial p6 = p0.polyMultiply(p2);
        System.out.println("\np0 = " + p0 + "\n" + "p2 = " + p2 + "\np0*p2 = "
                + p6);

        Polynomial p7 = p0.polyAdd(p2);
        System.out.println("\np0 = " + p0 + "\n" + "p2 = " + p2 + "\np0+p2 = "
                + p7);

        p1 = p1.polyAdd(p2);
        System.out.println("\nAfter p1 = p1+p2  p1 = " + p1);

        p2 = p2.polyMultiply(p2);
        System.out.println("\nAfter p2 = p2*p2  p2 = " + p2);

        // Testing copy constructor
        Polynomial pCopy = new Polynomial(p1);
        System.out.println("\nAfter copy p1 =    " + p1);
        System.out.println("After copy pCopy = " + pCopy);
        p1.addTerm(10, 4);
        System.out.println("\nAfter adding 10x^4 to p1, p1 = " + p1);
        System.out.println("But pCopy is still             " + pCopy);

    }
}
