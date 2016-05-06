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
	public void validateElements() {
		assertNotNull(pObj.getInputBox());
		assertNotNull(pObj.getSubmitBtn());
		assertNotNull(pObj.getLuckyBtn());
		assertEquals(pObj.getSubmitBtn().getAttribute("value"),"Google Search");
		assertEquals(pObj.getGmailLink().getAttribute("href"), "https://mail.google.com/mail/?tab=wm");
	}
	
    /**
     * Test search empty string
     */
    @Test
    public void testEmptyStringNotChangeUrl() {
    	String curUrl = pObj.getCurrentUrl();
    	pObj.search("");
    	assertEquals(pObj.getCurrentUrl(), curUrl);
    }
 
    /**
     * Test search text
     */
    @Test
    public void testSearchText() {
        String searchStr = "test";
        pObj.search(searchStr);
        pObj.waitUtilTitle(searchStr);
        assertEquals(pObj.getCurrentTitle(), searchStr+" - Google Search");
    }
    
    /**
     * Test search special characters
     */
    @Test
    public void testSpecialCharacters() {
        String searchStr = "1*2%$(";
        pObj.search(searchStr);
        pObj.waitUtilTitle(searchStr);
        assertEquals(pObj.getCurrentTitle(), searchStr+" - Google Search");
    }
    
    @Test
    public void testGmailClick() {
    	pObj.getGmailLink().click();
    	String url = "https://www.google.com/intl/en/mail/help/about.html";
    	pObj.waitUtilUrl(url);
    	assertEquals(pObj.getCurrentTitle(), "Gmail - Free Storage and Email from Google");
    }
    
    @After
    public void close() {
    	pObj.close();
    }
}
