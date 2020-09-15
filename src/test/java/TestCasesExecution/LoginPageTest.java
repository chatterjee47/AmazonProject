package TestCasesExecution;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import BaseClass.BrowserSetup;


public class LoginPageTest extends BrowserSetup {
	static WebDriver driver;
	static String date;
	String month;
	String year;
	static String caldt;
	String calmonth;
	String calyear;
	


	public static void main(String args[]) throws InterruptedException {

		driver = BrowserSetup.StartBrowser("Chrome", "https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//Instantiate Action Class        
        Actions actions = new Actions(driver);
    	WebElement menuOption = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));
    	WebElement SignInButton = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]"));
    	actions.moveToElement(menuOption).moveToElement(SignInButton).click().build().perform();
    	System.out.println("Done Mouse hover on 'SignInButton");
    	Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Login to application
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("immanuelraj0709@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Testing@1234");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(@class,'')][contains(text(),'Amazon Pay')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Bus Tickets')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_77142d7b']//div[@class='_9250a791']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter source city']")).sendKeys("Delhi");
		
		
		//Entering source
		Thread.sleep(2000);
		List<WebElement> SourceList =  driver.findElements(By.xpath("//div[@class='_90aa3c07 _41fd7233 a407febf _6078df67']"));
		int countofSourceList = SourceList.size();
		System.out.println("Count of Source List: " + countofSourceList);
		
		for(int i=0;i<countofSourceList;i++)
		{
			Thread.sleep(2000);
		  System.out.println("Print Lists: " + SourceList.get(i).getText());	
		  Thread.sleep(2000);
		 if( SourceList.get(i).getText().contains("Delhi"))
		 {
			 SourceList.get(i).click();
			 break;
		 }
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_97295edc']//div[@class='_9250a791']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter destination city']")).sendKeys("Indore");
		
		Thread.sleep(2000);
		List<WebElement> destinationList =  driver.findElements(By.xpath("//div[@class='_90aa3c07 _41fd7233 a407febf _6078df67']"));
		int countofdestinationList = destinationList.size();
		System.out.println("Count of destination List: " + countofdestinationList);
		Thread.sleep(2000);
		for(int j=0;j<countofdestinationList;j++)
		{
			Thread.sleep(1000);
		  System.out.println("Print Lists: " + destinationList.get(j).getText());	
		  Thread.sleep(1000);
		 if( destinationList.get(j).getText().equals("Indore"))
			 Thread.sleep(1000);
		 {
			 destinationList.get(j).click();
			 break;
		 }
		 }
		 Thread.sleep(2000);
		 
		driver.findElement(By.xpath(" //span[@class='_093f16e9 sizeMedium']")).click();
		 Thread.sleep(2000);
			driver.findElement(By.xpath(" //span[@class='_093f16e9 sizeMedium']")).click();
			 Thread.sleep(2000);
			 
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);  // number of days to add
		String today = sdf.format(c.getTime());
		 System.out.println(today);
		
        //find the calendar
        WebElement dateWidget = driver.findElement(By.xpath("//*[@class='_1711da50']"));  
        List<WebElement> columns=dateWidget.findElements(By.tagName("li"));  

        //comparing the text of cell with today's date and clicking it.
        for (WebElement cell : columns)
        {
           if (cell.getText().equals(today))
           {
              cell.click();
              break;
           }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Find Buses')]")).click();
        Thread.sleep(2000);
        
        
        //Validating the Search Result
        WebElement str = driver.findElement(By.xpath("//div[contains(@class,'_10eba5dc ddd43014')]"));  
        String ExpectedSearchResultDisplay = str.getText();
        System.out.println("Expected Search Result Display : " + ExpectedSearchResultDisplay);
		
		String ActualSearchResult = "Delhi - Indore, 16 Sept, 2020";
		Assert.assertEquals(ActualSearchResult, ExpectedSearchResultDisplay);
		
		Thread.sleep(2000);
		//Match the search count
        List<WebElement> ResultSearchcount =driver.findElements(By.xpath("//div[@class='c160fae3']/div"));
        int countofResultSearch = ResultSearchcount.size();
		System.out.println("Result Search count List: " + countofResultSearch);
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		//Match the search count
        List<WebElement> TopMostSearchResult =driver.findElements(By.xpath("//div[@class='c160fae3']/div[1]"));
        int countofTopMostSearchResult = TopMostSearchResult.size();
		System.out.println("Result Search count List: " + countofTopMostSearchResult);
		Thread.sleep(2000);
		
		for(int s=0;s<countofTopMostSearchResult;s++)
		{
		  Thread.sleep(2000);
		  System.out.println("Print Lists: " + TopMostSearchResult.get(s).getText());	
		  if(TopMostSearchResult.get(s).getText().contains("31 seats left"))
		  {
			System.out.println("It contains 31 seats left");
		  }
		}
		
		Thread.sleep(2000);
		WebElement BusFoundDisplay = driver.findElement(By.xpath("//div[contains(@class,'_5d17b3c7 _6c913dd6')]"));  
		String BusFound = BusFoundDisplay.getText();
		System.out.println("Bus Found Display : " + BusFound);
		Thread.sleep(2000);
		
		String[] arrSplit_3 = BusFound.split("\\s");
	    for (int r=0; r < arrSplit_3.length; r++)
	    {
	      System.out.println(arrSplit_3[r]);
	      if(arrSplit_3[r].contains("7"))
	      {
	    	  System.out.println("WebPage returns correct Result") ;
	    	  break;
	      }
	    }
	    Thread.sleep(2000);
	    System.out.println("Test Cases executed Successfully");
		driver.quit();
	}
}