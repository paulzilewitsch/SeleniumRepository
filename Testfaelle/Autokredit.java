package Allgemein;

import org.testng.Assert;
import org.testng.TestNG;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Autokredit {
  private WebDriver driver;
  public  String baseURL;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  SoftAssert softAssert= new SoftAssert();
  
@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {  
	System.setProperty("webdriver.firefox.marionette","\\Testautomatisierung\\Libraries\\geckodriver-v0.10.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	baseURL="https://www.commerzbank.de/portal/de/privatkunden/produkte/finanzieren-und-erwerben/autokredit/autokredit.html";  
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
  }


@Test (timeOut = 500000, priority=0)
public void start_Application() throws Exception {
	  driver.get(baseURL); 
	  //assertEquals(driver.getTitle(), "Autokredit – damit Sie schneller ans Ziel kommen - Commerzbank"); 
	  softAssert.assertEquals(driver.getTitle(), "Autokredit – damit Sie schneller ans Ziel kommen - Commerzbank","Titel was verified" );
	  driver.findElement(By.linkText("Termin vereinbaren")).click();
}

  @Test (timeOut = 500000, priority=1)
  public void testBaufinanzierung_Antrag_Terminvereinbarung() throws Exception {
	  driver.findElement(By.id("elem666785")).clear(); 
	  driver.findElement(By.id("elem666785")).sendKeys("07.08.2017");
	  driver.findElement(By.id("elem666786")).clear(); 
	  driver.findElement(By.id("elem666786")).sendKeys("11:00"); 
	  driver.findElement(By.id("elem666787")).clear(); 
	  driver.findElement(By.id("elem666787")).sendKeys("12:00"); 
	  driver.findElement(By.id("elem666756")).clear(); 
	  driver.findElement(By.id("elem666756")).sendKeys("Dresden"); 
	  driver.findElement(By.id("elem666780")).clear(); 
	  driver.findElement(By.id("elem666780")).sendKeys("Autofinanzierung"); 
	  
	  WebElement webElement1 = driver.findElement(By.id("elem666780"));//You can use xpath, ID or name whatever you like
	  webElement1.sendKeys(Keys.TAB);
	  
	  WebElement webElement2 = driver.findElement(By.xpath("//div[@id='elem666784Wrapper']/div/fieldset/ul/li[2]/label[1]"));	
	  webElement2.sendKeys(Keys.ARROW_RIGHT);
	 
	 // driver.findElement(By.xpath("//div[@id='elem666784Wrapper']/div/fieldset/ul/li[2]/label[1]")).click();

	  
	  driver.findElement(By.id("elem666766")).clear(); 
	  driver.findElement(By.id("elem666766")).sendKeys("Jop"); 
	  driver.findElement(By.id("elem666744")).clear(); 
	  driver.findElement(By.id("elem666744")).sendKeys("Sieben");
	  driver.findElement(By.id("elem666753")).clear(); 
	  driver.findElement(By.id("elem666753")).sendKeys("Mainstrasse"); 
	  driver.findElement(By.id("elem666761")).clear();
	  driver.findElement(By.id("elem666761")).sendKeys("772");
	  driver.findElement(By.id("elem666762")).clear(); 
	  driver.findElement(By.id("elem666762")).sendKeys("727272");
	  driver.findElement(By.id("elem666777")).clear(); 
	  driver.findElement(By.id("elem666777")).sendKeys("Frankfurt"); 
	  driver.findElement(By.id("elem666772")).clear(); 
	  driver.findElement(By.id("elem666772")).sendKeys("Deutschland"); 
	  driver.findElement(By.id("elem666775")).clear(); 
	  driver.findElement(By.id("elem666775")).sendKeys("00339272627272727272"); 
	  driver.findElement(By.id("elem666782")).clear(); 
	  driver.findElement(By.id("elem666782")).sendKeys("gilberto@frankfurttest.de"); 
	  driver.findElement(By.xpath("//div[@id='panelActions']/div/span/input")).click(); 
	  


  }
  
  @Test (timeOut = 500000, priority=2)
  public void testBaufinanzierung_Antrag_Anfrage_Bestaetigung() throws Exception {
	  //Anfrage Bestätigung
	  
	    assertEquals(driver.findElement(By.id("elem666755_ueberschrift")).getText(), "Ihre Terminvereinbarung");
	    assertEquals(driver.findElement(By.xpath("//form[@id='panel']/div/div/div/div/span[8]")).getText(), "Dresden");
	    assertEquals(driver.findElement(By.xpath("//form[@id='panel']/div/div/div/div/span[10]")).getText(), "Autofinanzierung");
	   // driver.findElement(By.xpath("//div[@id='panelActions']/div[2]/span[2]/a")).click();

		//WebElement webElement3 = driver.findElement(By.xpath("//div[@id='panelActions']/div[2]/span[2]/a"));	
	    //WebElement webElement3 = driver.findElement(By.xpath("//div[@id='panelActions']"));	
	    //webElement3.sendKeys(Keys.TAB);
	    //webElement3.sendKeys(Keys.TAB);
	    //webElement3.sendKeys(Keys.ARROW_RIGHT);
	    //webElement3.sendKeys(Keys.ARROW_RIGHT);
	    
	    
	   //Anfrage  Abbruch
	   //assertEquals(driver.getTitle(), "Terminvereinbarung - KT01 - Zusammenfassung - Commerzbank");
	   //assertEquals(driver.findElement(By.xpath("//h1[@id='elem7325_ueberschrift']")).getText(), "Sie haben den Vorgang abgebrochen");
  }
  
  

  
@AfterClass (alwaysRun = true, timeOut = 50000)
  public void tearDown() throws Exception {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  

  
	public static void main(String[] args) {
		// TODO Auto-generated method stub	  
			  TestNG testng = new TestNG();
			  testng.setTestClasses(new Class[] { Autokredit.class });
			  testng.run();
	}
	
  
}




