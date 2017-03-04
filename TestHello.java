import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.fail;

/**
 * Created by joshdemusz on 3/2/17.
 */
public class TestHello
{
    static WebDriver driver = new HtmlUnitDriver();

    // Start at the web page we are testing
    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    /*
    This test makes sure that the base case for the "Hello" link works. Specifically, if there is nothing trailing on the URL,
        the String 'Hello CS1632, from Prof. Laboon!' should be visible.
     */
    @Test
    public void testNoTrailingUrl()
    {
        try
        {
            driver.findElement(By.linkText("Hello")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Hello CS1632, from Prof. Laboon!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the trailing case for the "Hello" link works. Specifically, if there is a trailing String <addition> on the URL,
        the String 'Hello CS1632, from <addition>!' should be visible.
     */
    @Test
    public void testTrailingUrl()
    {
        try
        {
            driver.findElement(By.linkText("Hello")).click();

            // Add to url
            String url = driver.getCurrentUrl();
            String newurl = url+"/melania_trump";
            driver.get(newurl);

            // Check if added String in url updates the String on the "Hello" page
            driver.findElement(By.xpath("//*[text()[contains(.,'Hello CS1632, from melania_trump!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

}
