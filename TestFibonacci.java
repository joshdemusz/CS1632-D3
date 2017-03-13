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

public class TestFibonacci
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
    This test checks to make sure that data entered into the "Fibonacci" function is submitted properly.
        If there is any trouble submitting data, the test will fail.
     */
    @Test
    public void testInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the application handles invalid Fibonacci input. Specifically, this test checks for negative integer input.
        For the application to correctly handle this invalid input, it should return '1' for the Fibonacci number.
     */
    @Test
    public void testNegativeInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("-1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of -1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This tests the Fibonacci argument's lower boundary. Specifically, it tests what happens
        when 0 or 1 is inputted into the Fibonacci function.
     */
    @Test
    public void testLowerBoundaryInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 0 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
     This tests the Fibonacci argument's upper boundary. Specifically, it tests what happens
         when 100 or 101 is inputted into the Fibonacci function.
      */
    @Test
    public void testUpperBoundaryInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("100");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 100 is 354224848179261915075!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("101");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 101 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
     This tests the input of a large integer into the Fibonacci function. This tests an unexpected
        use case.
      */
    @Test
    public void testIntegerInputLarge()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("1000000");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 1000000 is 1!')]]"));
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
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
     This test makes sure that the application handles invalid Fibonacci input. Specifically, this test checks for decimal input.
         For the application to correctly handle this invalid input, it should return '1' for the Fibonacci number.
      */
    @Test
    public void testDecimalInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0.111");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 0.111 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the application handles invalid Fibonacci input. Specifically, this test checks for text input.
        For the application to correctly handle this invalid input, it should return '1' for the Fibonacci number.
     */
    @Test
    public void testTextInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("AH!");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of AH! is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the application handles valid Fibonacci input. Specifically, this test checks for positive integer input < 101.
        For the application to correctly handle this invalid input, it should return the Fibonacci number of the input.
     */
    @Test
    public void testIntegerInput()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("5");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 5 is 5!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    Determined by manual testing, 31 was the first valid input to yield a result of 1 instead of the Fibonacci number.
        I added this test to show that this defect is not an off-by-one error. Rather, the integer generated by the Fibonacci
        function is most likely too large. In order to fix this issue, some type of "BigInteger" data-type/class will need to be utilized
        in order to store large integer numbers.
     */
    @Test
    public void testIntegerInput31()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("5");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 31 is 1346269!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
}
