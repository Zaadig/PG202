/**
 * Authors:
 * Ben Saad Mahmoud
 * Skander Khiari
 */
package tec;

public class TestPosition {

    public static final int MAX_TESTS = 12; // value of total tests

    Verify Verify = new Verify(MAX_TESTS, "tec.TestPosition");


    // test methods

    public void test_dehors_estDehors() {
        boolean isValid;
        if (Verify.verbose)
            System.out.println(Verify.C_GREEN + "\tTest dehors" + Verify.C_RESET + "\n");

        Position p = Position.NewPosition();
        isValid = Verify.verify(p.estDehors(), "LOG: estdehors() must return true");
        Verify.print_OK_NOTOK(isValid, "Testing if an outside defined passenger is outside");
    }

    public void test_dehors_estAssis() {
        boolean isValid;

        Position p = Position.NewPosition();
        isValid = Verify.verify(!p.estAssis());

        Verify.print_OK_NOTOK(isValid,"Testing if an outside defined passenger is not seated");
    }

    public void test_dehors_estDebout() {
        boolean isValid;

        Position p = Position.NewPosition();
        isValid = Verify.verify(!p.estDebout());

        Verify.print_OK_NOTOK(isValid,"Testing if an outside defined passenger is not standing");
    }

    public void test_dehors_estInterieur() {
        boolean isValid;

        Position p = Position.NewPosition();
        isValid = Verify.verify(!p.estInterieur(), "LOG: estInterieur() must return false");

        Verify.print_OK_NOTOK(isValid, "Testing if an outside defined passenger is not inside");
    }

    public void test_assis_estDehors() {
        boolean isValid;

        if (Verify.verbose)
            System.out.println(Verify.C_GREEN + "\tTest assis" + Verify.C_RESET + "\n");
        
        Position p = Position.assis();
        isValid = Verify.verify(!p.estDehors());

        Verify.print_OK_NOTOK(isValid,"Testing if a seated defined passenger is not outside");
    }

    public void test_assis_estAssis() {
        boolean isValid;

        Position p = Position.assis();
        isValid = Verify.verify(p.estAssis());

        Verify.print_OK_NOTOK(isValid, "Testing if a seated defined defined passenger is seated");
    }

    public void test_assis_estDebout() {
        boolean isValid;

        Position p = Position.assis();
        isValid = Verify.verify(!p.estDebout(), "LOG: estDebout() must return false");

        Verify.print_OK_NOTOK(isValid,"Testing if a seated defined defined passenger is not standing");
    }

    public void test_assis_estInterieur() {
        boolean isValid;

        Position p = Position.assis();
        isValid = Verify.verify(p.estInterieur());

        Verify.print_OK_NOTOK(isValid,"Testing if a seated defined passenger is inside");
    }

    public void test_debout_estDehors() {
        boolean isValid;

        if (Verify.verbose)
            System.out.println(Verify.C_GREEN + "\tTest debout" + Verify.C_RESET + "\n");

        Position p = Position.debout();
        isValid = Verify.verify(!p.estDehors());

        Verify.print_OK_NOTOK(isValid, "Testing if a standing defined passenger is not outside");
    }

    public void test_debout_estAssis() {
        boolean isValid;

        Position p = Position.debout();
        isValid = Verify.verify(!p.estAssis());

        Verify.print_OK_NOTOK(isValid, "Testing if a standing defined passenger is not seated");
    }

    public void test_debout_estDebout() {
        boolean isValid;

        Position p = Position.debout();
        isValid = Verify.verify(p.estDebout(), "LOG: estdebout() must return true");

        Verify.print_OK_NOTOK(isValid, "Testing if a standing defined passenger is standing");
    }

    public void test_debout_estInterieur() {
        boolean isValid;

        Position p = Position.debout();
        isValid = Verify.verify(p.estInterieur());

        Verify.print_OK_NOTOK(isValid, "Testing if a standing defined passenger is inside");
    }
}
