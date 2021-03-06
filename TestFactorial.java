import com.google.common.math.BigIntegerMath;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.logging.Level;

import static org.junit.Assert.fail;

/*
    Josh Demusz
    CS 1632 - Deliverable 3
    3/13/17
 */

public class TestFactorial
{
    static WebDriver driver = new HtmlUnitDriver();

    // Start at the web page we are testing
    @Before
    public void setUp() throws Exception
    {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        driver.get("https://cs1632ex.herokuapp.com");
    }

    /*
    This test checks to make sure that data entered into the "Factorial" function is submitted properly.
        If there is any trouble submitting data, the test will fail.
     */
    @Test
    public void testInput()
    {
        try
        {
            // Test to make sure that data is being inputted
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the application handles invalid factorial input. Specifically, this test checks for negative integer input.
        For the application to correctly handle this invalid input, it should return '1' for the factorial.
     */
    @Test
    public void testNegativeInput()
    {
        try
        {
            // Test entering a negative value
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("-1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of -1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This tests the Factorial argument's lower boundary. Specifically, it tests what happens
        when 0 or 1 is inputted into the Factorial function.
     */
    @Test
    public void testLowerBoundaryInput()
    {
        try
        {
            // Test entering 0
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 0 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

        try
        {
            // Test entering 1
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This tests the Factorial argument's upper boundary. Specifically, it tests what happens
        when 100 or 101 is inputted into the Factorial function.
     */
    @Test
    public void testUpperBoundaryInput()
    {
        // Test entering 100
        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("100");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 100 is "+BigIntegerMath.factorial(100)+"!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

        // Test entering 101
        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("101");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 101 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
     This tests the input of a large integer into the Factorial function. This tests an unexpected
        use case.
      */
    @Test
    public void testIntegerInputLarge()
    {
        try
        {
            // Test entering 1,000,000
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("1000000");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 1000000 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
     This tests the input of "nothing" into the Factorial function. This tests an unexpected
        use case.
      */
    @Test
    public void testBlankInput()
    {
        try
        {
            // Test entering nothing
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
     This test makes sure that the application handles invalid factorial input. Specifically, this test checks for decimal input.
         For the application to correctly handle this invalid input, it should return '1' for the factorial.
      */
    @Test
    public void testDecimalInput()
    {
        try
        {
            // Test entering a decimal
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0.111");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 0.111 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the application handles invalid factorial input. Specifically, this test checks for text input.
        For the application to correctly handle this invalid input, it should return '1' for the factorial.
     */
    @Test
    public void testTextInput()
    {
        try
        {
            // Test entering a String
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("AH!");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of AH! is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
   This test makes sure that the application handles valid factorial input. Specifically, this test checks for positive integer input < 101.
       For the application to correctly handle this invalid input, it should return the factorial of the input.
    */
    @Test
    public void testIntegerInput()
    {
        try
        {
            // Test entering a valid integer input
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("5");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 5 is "+BigIntegerMath.factorial(5)+"!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

}
