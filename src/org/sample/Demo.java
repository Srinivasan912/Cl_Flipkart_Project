package org.sample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\workplace\\eclipse-wrokspace\\Flipkart_Project\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	
	WebElement btnclose = driver.findElement(By.xpath("//button[text()='✕']"));
	btnclose.click();
	WebElement searchtxt = driver.findElement(By.xpath("//input[@type='text']"));
	searchtxt.sendKeys("Iphone");
	WebElement btnsearch = driver.findElement(By.xpath("//button[@type='submit']"));
	btnsearch.click();
	Thread.sleep(3000);
	System.out.println("Product Name");
	System.out.println("------------");
	Thread.sleep(5000);
	List<WebElement> p = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	List<String> pn= new ArrayList<String>();
	for(int i=0;i<p.size();i++) {
		String product_name = p.get(i).getText();
		pn.add(product_name);
	System.out.println(product_name);
		
	}
	System.out.println();
	List<String> p1= new ArrayList<String>();
	System.out.println("Product Price");
	System.out.println("------------");
	Thread.sleep(3000);
	List<WebElement> pp = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	for (int i = 0; i < pp.size(); i++) {
		String product_price = pp.get(i).getText();
		p1.add(product_price);
		System.out.println(product_price);
	}
	
	System.out.println();
	for(int i=0;i<p1.size();i++) {
		System.out.println(pn.get(i)+"===>"+p1.get(i));
		
	}
	System.out.println();
	Collections.sort(p1);
	System.out.println("Maximum Price===>"+Collections.max(p1));
	System.out.println("Minimum Price===>"+Collections.min(p1));
}
}
