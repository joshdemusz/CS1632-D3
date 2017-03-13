/*
    Josh Demusz
    CS 1632 - Deliverable 3
    3/13/17
 */

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestHomepage
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
    This test makes sure that the webpage contains the correct title. This was done as a preliminary
        test - having this title is not one of the requirements.
     */
    @Test
    public void testShowsCorrectTitle()
    {
        String title = driver.getTitle();
        assertTrue(title.contains("CS1632 D3"));
    }

    /*
    This test tests to make sure that the web app has the 5 links specified in the requirements.
        It tests to see if the full link String exists in any of the page's link elements.
     */
    @Test
    public void testHasCorrectHeaderLinks()
    {
        try
        {
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the String 'Welcome, friend, to a land of pure calculation' is present on the homepage.
        It tests to see if the full String exists in any of the page's elements.
     */
    @Test
    public void testText1()
    {
        try
        {
            driver.findElement(By.xpath("//*[text()[contains(.,'Welcome, friend, to a land of pure calculation')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    /*
    This test makes sure that the String 'Used for CS1632 Software Quality Assurance, taught by Bill Laboon' is present on the homepage.
        It tests to see if the full String exists in any of the page's elements.
     */
    @Test
    public void testText2()
    {
        try
        {
            driver.findElement(By.xpath("//*[text()[contains(.,'Used for CS1632 Software Quality Assurance, taught by Bill Laboon')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
}