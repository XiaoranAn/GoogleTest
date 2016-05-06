package com.seleniumtest;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
	PageObject pObj;
	@Before
    public void setUp() {
		pObj = new PageObject();
    }
 
    @Test
    public void testEmptyStringNotChangeUrl() {
    	String curUrl = pObj.getCurrentUrl();
    	pObj.search("");
    	assertEquals(pObj.getCurrentUrl(), curUrl);
    }
 
    @Test
    public void testSearchText() {
        String searchStr = "test";
        pObj.search(searchStr);
        pObj.waitUtilTitle(searchStr);
        assertEquals(pObj.getCurrentTitle(), searchStr+" - Google Search");
    }
    
    @After
    public void close() {
    	pObj.close();
    }
}
