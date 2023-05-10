/**
 * Authors :
 * Elaloui Mohamed Seddiq
 * Atman Boz
 */
package tec;

public class TestJauge {

    public static final int MAX_TESTS = 11; // value of total tests

    Verify Verify = new Verify(MAX_TESTS, "tec.TestJauge");

    public void testInInterval() {
        boolean isValid;

        Jauge j = new Jauge(67899, 100);
        isValid = Verify.verify(j.estVert()) && Verify.verify(!j.estRouge());

        Verify.print_OK_NOTOK(isValid, "Testing green and red attributes when inside the interval");
    }

    public void testDepartMaxEq() {
        boolean isValid;
        Jauge j1 = new Jauge(100, 100);

        isValid = Verify.verify(!j1.estVert(),
                "LOG: Jauge must return false upon calling estVert() method (max = depart)")
                && Verify.verify(j1.estRouge());

        Verify.print_OK_NOTOK(isValid, "Testing green and red attributes when depart = max");
    }

    public void testDepartSupMax() {
        boolean isValid;

        Jauge j2 = new Jauge(100, 101);

        isValid = Verify.verify(!j2.estVert(),
                "LOG: Jauge must return false upon calling estVert() method (max > départ)")
                && Verify.verify(j2.estRouge());

        Verify.print_OK_NOTOK(isValid, "Testing green and red attributes when depart > max ");
    }

    public void testDepartNegative() {
        boolean isValid;

        Jauge j1 = new Jauge(10, -1);
        isValid = Verify.verify(!j1.estVert()) && Verify.verify(!j1.estRouge());

        Verify.print_OK_NOTOK(isValid, "Testing green and red attributes when depart < 0");
    }

    public void testDepartNull() {
        boolean isValid;

        Jauge j2 = new Jauge(10, 0);

        isValid = Verify.verify(j2.estVert()) && Verify.verify(!j2.estRouge());

        Verify.print_OK_NOTOK(isValid,"Testing green and red attributes when depart = 0");
    }

    public void testIncrementerMid() {
        boolean isValid;

        Jauge j = new Jauge(6, 3);

        j.incrementer();
        isValid = Verify.verify(!j.estRouge() && j.estVert(),
                "LOG: Jauge initiated at 3 with max value 6 should return false upon calling estRouge() method call");

        Verify.print_OK_NOTOK(isValid, "Testing incrementing method when jauge is in the middle");
    }

    public void testIncrementerErrorValue() { // to show increment issues
        boolean isValid = true;

        Jauge j1 = new Jauge(6, 3);
        Jauge j2 = new Jauge(10, 0);

        // Jauge 1 , the verbose conditionals aren't so beautiful but this is all i have for the moment
        
        if (Verify.verbose)
            System.out.println(Verify.C_GREEN + "new Jauge J1 : " + Verify.C_RESET + j1);

        if (Verify.verbose)
            System.out.println(Verify.C_YELLOW + "Incrementing J1" + Verify.C_RESET);
        j1.incrementer();
        if (Verify.verbose)
            System.out.println(j1);

        if (Verify.verbose)
            System.out.println(Verify.C_YELLOW + "Incrementing J1" + Verify.C_RESET);
        j1.incrementer();
        if (Verify.verbose)
            System.out.println(j1 + "\n");

        // Jauge 2
        if (Verify.verbose)
            System.out.println(Verify.C_GREEN + "new Jauge J2 : " + Verify.C_RESET + j2);

        if (Verify.verbose)
            System.out.println(Verify.C_YELLOW + "Incrementing J2" + Verify.C_RESET);
        j2.incrementer();
        if (Verify.verbose)
            System.out.println(j2);

        if (Verify.verbose)
            System.out.println(Verify.C_YELLOW + "Incrementing J2" + Verify.C_RESET);
        j2.incrementer();
        if (Verify.verbose)
            System.out.println(j2);

        Verify.print_OK_NOTOK(isValid, "Testing the incrementing method to deduce the error value");
    }

    public void testDecrementerMid() {
        boolean isValid;

        Jauge j = new Jauge(6, 3);

        j.decrementer();
        isValid = Verify.verify(!j.estRouge()) && Verify.verify(j.estVert());

        Verify.print_OK_NOTOK(isValid, "Testing decrementing method when the jauge is in the middle");
    }

    public void testDecrementerMax() {
        boolean isValid;

        Jauge j = new Jauge(6, 6);

        j.decrementer();
        isValid = Verify.verify(!j.estRouge()) && Verify.verify(j.estVert());

        Verify.print_OK_NOTOK(isValid, "Testing decrementing method when the jauge is on the max value");
    }

    public void testDecrementerNull() {
        boolean isValid;

        Jauge j = new Jauge(6, 0);

        j.decrementer();
        isValid = Verify.verify(!j.estRouge()) && Verify.verify(!j.estVert());

        Verify.print_OK_NOTOK(isValid, "Testing decrementing method when the jauge is on 0");
    }

    // Instanciation de Jauge
    public void testExceptionCasLimite() {
        Jauge inverse = null;
        try{
            inverse = new Jauge(-42, 10);
            //Quel comportement faut-il vérifier ?
            assert false: "Exception not triggered"; // Au cas ou l'exception n'est pas levee, cette assertion va arreter le processus
        } catch(IllegalArgumentException e) {
            // System.out.println("\n Value of inverse is :" + inverse);
            // Examination de la valeur de la variable inverse aprés l'exception
            // elle reste toujours null
        }

    }
}