package com.ozka.test;

import org.junit.Assert;
import org.junit.Test;

public class SiteTest extends WebDriverSet {

    @Test
    public void firstTest() {
        driver.get("http://www.testng.org/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("TestNG - Welcome6"));
    }
}
