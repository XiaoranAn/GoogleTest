package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	
	WebDriver driver;
	WebElement inputElement;
	public PageObject() {
		driver = new FirefoxDriver();
		navigate("https://www.google.com");
		inputElement = getInputBox();
	}
	
	public void navigate(String url) {
		driver.get(url);
	}
	
	public WebElement getInputBox() {
		return driver.findElement(By.name("q"));
	}
	
	public WebElement getSubmitBtn() {
		return driver.findElement(By.name("btnK"));
	}
	
	public WebElement getLuckyBtn() {
		return driver.findElement(By.name("btnI"));
	}
	
	public WebElement getGmailLink() {
		return driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
	}
	
	public WebElement getImageLink() {
		return driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[2]/a"));
	}
	
	public void typeInputText(String searchString) {
		inputElement.sendKeys(searchString);
	}
	
	public void search(String searchString) {
		typeInputText(searchString);
		inputElement.submit();
	}
	
	public void waitUtilTitle(final String title) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title);
            }
        });
	}
	
	public void waitUtilUrl(final String url) {
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().startsWith(url);
            }
        });
	}
	
	public String getCurrentTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void close() {
		driver.quit();
	}
}
