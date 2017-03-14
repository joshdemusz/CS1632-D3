import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.logging.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/*
    Josh Demusz
    CS 1632 - Deliverable 3
    3/13/17
 */

public class TestCathedralPics
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
    Tests to make sure that there is an ordered list on the "Cathedral Pics" page. The requirements specify an ordered
        list with 3 cathedral pictures.
     */
    @Test
    public void testOrderedList()
    {
        try
        {
            // Checks to make sure 1 ordered/numbered list is present
            driver.findElement(By.linkText("Cathedral Pics")).click();
            List<WebElement> l = driver.findElements(By.tagName("ol"));
            assertEquals(1, l.size());
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    Tests to make sure that there are 3 images inside the ordered list on the "Cathedral Pics" page.
     */
    @Test
    public void testNumCathy()
    {
        try
        {
            driver.findElement(By.linkText("Cathedral Pics")).click();

            // Retrieves the ordered list on the page
            WebElement ordered_list = driver.findElement(By.tagName("ol"));

            // Makes sure that there are 3 images in the ordered list
            List<WebElement> l = ordered_list.findElements(By.tagName("img"));
            assertEquals(3, l.size());
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

}
