/*
Ziad Malik
Section U01
Polynomial.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package polynomials;

/**
 * A class to create, add, and multiply polynomials. A polynomial is defined as
 * a sum of terms where each term has variable x, an int coefficient, and a
 * nonnegative int exponent
 */
public class Polynomial {

    private Node head;   // points to the first Node of a Polynomial

    /**
     * Default constructor creates a Polynomial with no terms
     */
    public Polynomial() {
        head = null;
    }

    /**
     * "Copy" constructor. Creates a "deep copy" of a given Polynomial. I.e. a
     * new Polynomial with identical terms. Does this by adding each term of the
     * Parameter Polynomial to this.Polynomial. In better words, This Polynomial
     * Is adding The Terms of p Into itself.
     *
     * @param p the Polynomial to be copied
     */
    public Polynomial(Polynomial p) {
        /*
        Temporary Node "temp" is used to Traverse the Polynomial p. Is 
        Incremented to Each node's Next as we visit each Node.
         */
        Node temp = p.head;
        while (temp != null) {
            this.addTerm(temp.info.getCo(), temp.info.getExponent());
            temp = temp.next;
        }
    }

    /**
     * Creates a new Term and Node containing it and inserts it in its proper
     * place in this Polynomial (i.e. in ascending order by exponent). If This
     * Polynomials Head is empty, then the Term being added is added as the
     * head. If not, We check to see if the Term can be added to the end of the
     * Polynomial by comparing the Exponents of the Term we are attempting to
     * add and the Last Term's Exponent. If the last's Term Exponent is less or
     * equal to the Exponent of the Term we are trying to add, we add that term
     * to the end of the Polynomial. If not, We look for the first term in the
     * Polynomial that carries an exponent that is greater than the Exponent of
     * the Term we are trying to add. Once we find that term, we add our term we
     * are trying to add before that found term.
     *
     * @param coeff the coefficient of the new Term
     * @param expo the exponent of the new Term
     */
    public void addTerm(int coeff, int expo) {
        /*
        Temporary Node "insert" is used to create the Node Object that will 
        consist of the Info passed through the Method as Parameters which will
        be added into this Polynomial Object.
         */
        Node insert = new Node(new Term(coeff, expo));
        if (this.head == null) {
            this.head = insert;
        } else // get pointer to last node
        {
            /*
            Temporary Node "temp" is used to Traverse the Polynomial p. Is 
            Incremented to Each node's Next as we visit each Node. We are trying
            to get to the Last Node in the Polynomial
             */
            Node temp = this.head;           // ...start at head of list
            while (temp.next != null) // ...while not at last node...
            {
                temp = temp.next;   // ......move to next node
            }
            /*
            If Last Term carries a Lesser or equal Exponent than the Exponent
            of the Term we are trying to add, Add the Term to the End of the
            Polynomial
             */
            if (temp.info.getExponent() <= expo) {
                temp.next = new Node(new Term(coeff, expo));
            } else {
                /*                
                Temporary Node "prev" is used to Traverse the Polynomial p. Is 
                Incremented to Each node's Next as we visit each Node. Set to
                null and will be one node behind Node "current" We will add the
                Term in front of this Node if The Requirements are met for this
                condition.
                 */
                Node prev = null;
                /*
                Temporary Node "current" is used to Traverse the Polynomial p. 
                Is Incremented to Each node's Next as we visit each Node. Is
                One Node ahead of Prev. If Current carries the Term that has 
                an exponent higher than the Term's we are trying to add, it is 
                added before Current. We do this by Using Node Prev.
                 */
                Node current = this.head;
                while (current != null) {
                    if (current.info.getExponent() > expo) {
                        if (prev == null) {
                            this.head = insert;
                            this.head.next = current;
                            break;
                        } else {
                            insert.next = current;
                            prev.next = insert;
                            break;
                        }
                    }
                    prev = current;
                    current = current.next;
                }
            }
        }
    }

    /**
     * Returns a polynomial as a String in this form: x + 3x^2 + 7x^3 + x^5
     *
     * @return the polynomial as a String
     */
    @Override
    public String toString() {
        if (this.head == null) {

            return "0";
        }
        collectTerms();
        /*
        Local String Variable out simply initializes the String for which we 
        will add onto it the Contents of each Polynomial in the Form Mentioned.
         */
        String out = "";
        /*
        Temporary Node "temp" is used to Traverse the Polynomial p. Is 
        Incremented to Each node's Next as we visit each Node.
         */
        Node temp = this.head;
        // start at head of list 
        while (temp != null) // while more nodes on list...
        {
            if (temp.next == null) {
                out += temp.info.toString() + ""; // ...append current obj
                break;
            }
            out += temp.info.toString() + " + "; // ...append current obj
            temp = temp.next;		// ...and move to next node
        }
        return out + "\n";
    }

    // collect terms of a Polynomial object. I.e. replace all terms having the 
    // same exponent with a single term which is their sum
    /*
    Get the first Exponent and Coefficient Initialize currentEx and totalCo to 
    those values. Get the next Terms Exponent and if the CurrentEx matches
    that Exponent add the Coefficients of both terms. We continue to do this 
    until the  next term does not carry a matching exponent. When such Exponent 
    is found we add the combined term we have been adding to thusfar to a 
    temporary Polynomial we create within the Method.we change currentEx and 
    TotalCo to those Terms Values For Exponent and Coeff. After the loop has 
    been terminated (Current Term's Next is Null) we add the last Term to the 
    Temporary Polynomial.
     */
    private void collectTerms() {
        /*
        currentEx is a Temporary Variable used to hold the Exponent we are 
        comparing at any given point. Is changed when a Matching Exponent is
        not found.
        */
        int currentEx = this.head.info.getExponent();
        /*
        totalCo is a Temporary Variable used to hold the Coefficient of the Head
        Term. If Matching Exponents Are found Based on the Terms, We add onto
        this Integer the Coefficient of the Matching Term and Create a new 
        "Combined Term"
        */
        int totalCo = this.head.info.getCo();
        /*
        Temporary Node "temp" is used to Traverse the Polynomial p. Is 
        Incremented to Each node's Next as we visit each Node.
         */
        Node current = this.head;
        /*
        Temporary Polynomial "copy" is used to hold all the terms we go through
        within this Polynomial Whether or not they have been combined.
         */
        Polynomial copy = new Polynomial();
        while (current.next != null) {
            current = current.next;
            if (current.info.getExponent() == currentEx) {
                totalCo += current.info.getCo();
            } else {
                copy.addTerm(totalCo, currentEx);
                currentEx = current.info.getExponent();
                totalCo = current.info.getCo();
            }
        }
        copy.addTerm(current.info.getCo(), current.info.getExponent());
        /*
        We at the end of this method Point the Head of this Polynomial to the
        Head of the Copy Polynomial which holds the "Simplified" Polynomial. 
        Therefore This Polynomial now points to Polynomial Copy.
        */
        this.head = copy.head;
    }

    /**
     * Multiply this Polynomial by another Polynomial. We do this by 
     * Multiplying Each term of this Polynomial by the Current Term of p. The
     * Product is added to a Temporary Polynomial and current Term p is 
     * incremented after each term of this polynomial has been multiplied by
     * current Term of p.
     *
     * @param p the other Polynomial
     * @return the product of the two Polynomials
     */
    public Polynomial polyMultiply(Polynomial p) {
        
        /*
        Nodes pHolder and temp are both Temporary Nodes used to traverse through
        the Polynomials p and This Polynomial.
        */
        Node pHolder = p.head;
        Node temp = this.head;
        /*
        Temporary Polynomial newPoly is where the new Terms which are the 
        Product of the Terms of this Polynomial and p, are added. At the end
        of this method we return this Polynomial.
         */
        Polynomial newPoly = new Polynomial();
        while (pHolder != null) {
            while (temp != null) {
                newPoly.addTerm(pHolder.info.getCo() * temp.info.getCo(),
                        pHolder.info.getExponent()
                        + temp.info.getExponent());
                temp = temp.next;
            }
            pHolder = pHolder.next;
            temp = this.head;
        }
        return newPoly;
    }

    /**
     * Add this Polynomial and another Polynomial. Simply add to a temporary
     * Polynomial all the terms of this Polynomial and the Polynomial that is
     * passed through the method as a parameter.
     *
     * @param p the other Polynomial
     * @return the sum of the two Polynomials
     */
    public Polynomial polyAdd(Polynomial p) {
        /*
        Polynomial holder is where Terms of this Polynomial and Polynomial p 
        will go to create a Polynomial that is the sum of the two Polynomials.
        Is the Polynomial that is returned.
        */
        Polynomial holder = new Polynomial();
        /*
        Nodes pHolder and temp are both Temporary Nodes used to traverse through
        the Polynomials p and This Polynomial.
        */
        Node pHolder = p.head;
        Node temp = this.head;
        while (pHolder != null) // while more nodes...
        {
            holder.addTerm(pHolder.info.getCo(), pHolder.info.getExponent());
            pHolder = pHolder.next;
        }
        while (temp != null) // while more nodes...
        {
            holder.addTerm(temp.info.getCo(), temp.info.getExponent());
            temp = temp.next;
        }
        return holder;
    }

    // Node class definition - DO NOT MODIFY!
    class Node<E extends Term> {

        private E info;     // each node stores an object of the 
        // type-parameter class...
        private Node next;  // ...and a pointer to another node

        // Node Constructor 
        // parameter x is an object of the type-parameter class
        Node(E x) {
            info = x;	// set info portion to parameter passed
            next = null;	// not pointing to another Node yet
        }
    } // end of Node class definition ============================
} // end of Polynomial class definition =========================
