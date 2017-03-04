/**
 * Created by joshdemusz on 2/27/17.
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class TestRunner
{
    public static void main(String[] args)
    {
        ArrayList<Class> test_classes = new ArrayList<Class>();
        boolean failures = false;

        // Add classes that will be tested
        test_classes.add(TestHomepage.class);
        test_classes.add(TestFactorial.class);
        test_classes.add(TestFibonacci.class);
        test_classes.add(TestHello.class);
        test_classes.add(TestCathedralPics.class);

        for (Class c: test_classes)
        {
            Result r = JUnitCore.runClasses(c);

            // Print out any failures for the current class
            for (Failure f : r.getFailures()) {
                System.out.println(f.toString());
            }

            if (!r.wasSuccessful())
            {
                failures = true;
            }
        }

        // Notify the user of the results of the tests
        if (failures)
        {
            System.out.println("\n!!! - At least one failure, see above.");
        } else {

            System.out.println("\nALL TESTS PASSED");
        }
    }
}
