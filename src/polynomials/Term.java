/*
Ziad Malik
Section U01
Term.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package polynomials;

/**
 * The Term Class is where the Terms that the polynomials consist of are made
 * and upheld. Here each term is given a coefficient and an exponent. These 
 * "Details" of each term are stored within each Term object and this class
 * helps with accessing these details across other classes using accessor 
 * Methods. Along with this the Term class is responsible for putting together
 * terms into strings in order to be interpreted in the form of ax^b.
 * @author Ziad Malik
 */
public class Term {

    private int coeffecient; //The Coeffecient of Each Term. The Scalar 
    private int exponent; // The Exponent of each Term. The Power X is Raised to
    /**
     * The Constructor of this Class Term takes two parameters that Specify the
     * Coefficient and Exponent of Each Term and Initializes the Class Variables
     * to these Parameter Values. The Term Object has been made.
     * @param coeffecient Coefficient the Term Object's Coeff will be set to
     * @param exponent Exponent the Term Object's Exponent Will be Set to
     */
    public Term(int coeffecient, int exponent) {
        this.coeffecient = coeffecient;
        this.exponent = exponent;
    }
    
    /**
     * Simple Accessor Method for A Term Objects Exponent. Simply Returns the
     * Exponent of this Term Object.
     * @return Exponent Value of this Object
     */
    public int getExponent() {
        return this.exponent;
    }
    /**
     * Simple Accessor Method for A Term Objects Coefficient. Simply Returns the
     * Coefficient of this Term Object.
     * @return Coefficient Value of this Object
     */
    public int getCo() {
        return this.coeffecient;
    }
    /**
     * To String Method which is Overriden in order to Specify how the Terms 
     * Should be printed. Each Term within a Polynomial Is printed within the
     * Format Provided to us by the Instructor of ax^b. Also, a Space is 
     * appended in order to allow a polynomial to look clear. If a space
     * is not appended then terms of a polynomial printed in a cluster and bunch
     * @return A String that consists of all the Terms of a Polynomial Printed
     * in ax^b format.
     */
    @Override
    public String toString() {
        /*
        Local Variable out is simply a holder for the String that is to be 
        returned within the end of the method. Is initialized to nothing and 
        is appended the Terms based on the Type of Term it is. See Assignement
        Instructions to see Specific Cases where Different Strings are appended.
        The most Common format however, is ax^b when a and b are not 0 or 1.
        (Even though we have been told to assume that a will never be 0)
        */
        String out = "";
        if (this.coeffecient == 1 && this.exponent == 1) {
            out += "x ";
            return out;
        }      
        else if (this.coeffecient == 1){       
            out +=  "x^" + this.exponent + " " ;
            return out;      
        }        
        else if (this.exponent == 1){            
            out += this.coeffecient + "x ";
            return out;
        }     
        else if(this.exponent == 0){            
            out += this.coeffecient + " ";
            return out;
        }   
        else{            
            out += this.coeffecient + "x^" + this.exponent + " ";
            return out;
        }
    }
}
