/**
 * Author:
 * Elkarchi Jad
 */
package tec;

public class Verify {

    public final String C_RESET = "\u001B[0m"; // DEFAULT
    public final String C_GREEN = "\u001B[32m"; // GREEN
    public final String C_YELLOW = "\u001B[33m"; // YELLOW
    public final String C_RED = "\u001B[31m"; // RED

    public int VAL_TESTS;  // value of validated tests
    public int MAX_TESTS;
    public boolean verbose = false; // value of option
    public String testNameModule;

    Verify(int NEW_VAL_TESTS, String new_testNameModule){ // constructor
        VAL_TESTS = NEW_VAL_TESTS;
        MAX_TESTS = NEW_VAL_TESTS;
        testNameModule = new_testNameModule;
    }

    Verify(int NEW_VAL_TESTS){
        VAL_TESTS = NEW_VAL_TESTS;
        MAX_TESTS = NEW_VAL_TESTS;
        testNameModule = "";
    }

    public boolean verify(Boolean expression, String comment) { // verify catches AssertionErrors
        try {
            assert expression;
            return true;
        } catch (AssertionError e) {
            if (verbose){
                System.out.println(C_YELLOW + comment + C_RESET + C_RED + "\nAssertionError: " + e.getStackTrace()[1] + C_RESET);
            }
            VAL_TESTS--;
            return false;
        }
    }

    public boolean verify(Boolean expression) { // verify without comment
        return verify(expression, "");
    }

    public void setVerbose(boolean new_verbose){
        verbose = new_verbose;
    }

    public void print_OK_NOTOK(boolean expression, String testNameMethod) { // logs test SUCCESS or FAIL
        if (verbose){
            if (expression) {
                System.out.println(testNameMethod + C_GREEN + " SUCCESS\n" + C_RESET);
            } else {
                System.out.println(testNameMethod + C_RED + " FAIL\n" + C_RESET);
            }
        } else {
            if (expression) {
                System.out.print("."); 
            }
        }
    }

    public void print_trueFalseResult(){
        if (verbose){
            System.out.println("Valid Jauge tests : " + VAL_TESTS + "/" + MAX_TESTS);
        } else {
            System.out.print(":(" + VAL_TESTS + "):OK: " + testNameModule + "\n");
        }
        
    }
}