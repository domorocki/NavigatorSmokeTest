package com.navigator.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class CreatePlace {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  
  

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://www.navigator.ba/");
  }

  @Test(description= "Mora postojati naslov stranice" )
  public void AShouldBeAbleToCreateNewObject() {
    
    assertEquals(driver.getTitle(), "Navigator | Mapa Sarajeva");
    try {
      assertTrue(isElementPresent(By.cssSelector("span.text")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("span.text")).click();
  }
  
  @Test (description= "Mora biti u mogucnosti da upise ime novog objekta" )
  public void BShouldBeAbleToWriteNameOfNewObject() throws InterruptedException {
	  try {
	      assertTrue(isElementPresent(By.id("poi_name")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	driver.findElement(By.cssSelector("span.text")).click();
    driver.findElement(By.id("poi_name")).clear();
    driver.findElement(By.id("poi_name")).sendKeys("Test Caffe");
    Thread.sleep(3000);
  }
   
  @Test (description= "Mora biti u mogucnosti da upise ime grada" )
  public void CShouldBeAbleToWriteCityName() {
	  try {
	      assertTrue(isElementPresent(By.id("poi_city_name")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
  driver.findElement(By.id("poi_city_name")).clear();
  driver.findElement(By.id("poi_city_name")).sendKeys("Sarajevo");
  }
  
  @Test  (description= "Mora biti u mogucnosti da upise postanski broj" )
  public void DShouldBeAbleToWriteZipCode() {
	  try {
	      assertTrue(isElementPresent(By.id("poi_zip_code")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  driver.findElement(By.id("poi_zip_code")).clear();
	  driver.findElement(By.id("poi_zip_code")).sendKeys("71000");
  }
  
  
  @Test (description= "Mora biti u mogucnosti da upise adresu" )
  public void EShouldBeAbleToWriteAdress() {
	  try {
	      assertTrue(isElementPresent(By.id("poi_place_id")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  driver.findElement(By.id("poi_place_id")).clear();
	  driver.findElement(By.id("poi_place_id")).sendKeys("Testni");
  }
  
  @Test (description= "Mora biti u mogucnosti da upise kucni broj" )
  public void FShouldBeAbleToWriteHouseNumber() {
	  try {
	      assertTrue(isElementPresent(By.id("poi_house_number")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  driver.findElement(By.id("poi_house_number")).clear();
	    driver.findElement(By.id("poi_house_number")).sendKeys("10");
  }
  
  @Test (description= "Mora biti u mogucnosti da upise opis objekta" )
  public void GShouldBeAbleToWriteDescription() {
	  
	  try {
	      assertTrue(isElementPresent(By.id("poi_description")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  driver.findElement(By.id("poi_description")).clear();
	    driver.findElement(By.id("poi_description")).sendKeys("Najbolja kafa u gradu!");
	 
  }

    
  @Test (description= "Mora biti u mogucnosti da izabere tip objekta" )
  public void HShouldBeAbleToAddCategory() throws InterruptedException {
	  try {
	      assertTrue(isElementPresent(By.xpath("//div[2]/div/div/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  driver.findElement(By.xpath("//div[2]/div/div/button")).click();
	    new Select(driver.findElement(By.xpath("//select"))).selectByValue("5");
	   
	    
	  Thread.sleep(2000);
  }
  
  @Test (description= "Mora biti u mogucnosti da klikne na kreiranje objekta" )
  public void ItestObjectConfirm() throws InterruptedException  {
	
	  JavascriptExecutor jse = (JavascriptExecutor) driver;
	  jse.executeScript("document.getElementById('poi_has_wifi').focus();");
	  
	  try {
	        assertTrue(isElementPresent(By.cssSelector("button.btn.btn-success")));
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }
	  driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	Thread.sleep(5000);
  }
  
  
  @Test (description= "Mora biti u mogucnosti da pretrazuje ulicu" )
	public void JIsAbleToSearch() {
		try {
			assertTrue(isElementPresent(By.xpath("//input[2]")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//input[2]")).clear();
		driver.findElement(By.xpath("//input[2]")).sendKeys("Brèanska");
		driver.findElement(By.className("iconav-search")).click();
	}

	@Test (description= "Mora biti u mogucnosti da klikne na trazeni rezultat pretrage" )
	public void KSearchResultsShouldAppear() throws InterruptedException {
		try {
			assertEquals("Brèanska",
					driver.findElement(By.xpath("//*[@class='name'][contains(text(), 'Brèanska')]")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("//*[@class='name'][contains(text(), 'Brèanska')]")).click();
		
		Thread.sleep(3000);
	}

	@Test (description= "Mora biti u mogucnosti da koristi zoom" )
	public void LZoomShouldBeAvailable() throws InterruptedException {
		try {
			assertTrue(isElementPresent(By.linkText("+")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("+")).click();
	    driver.findElement(By.linkText("-")).click();
		Thread.sleep(3000);
	}
	
	@Test (description= "Mora biti u mogucnosti da se prebaci u satelite view" )
	public void MSateliteViewIsAvailable() throws InterruptedException {
		try {
			assertTrue(isElementPresent(By.cssSelector("span.caption")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.cssSelector("span.caption")).click();
		Thread.sleep(2000);
	}
	
	@Test (description= "Mora biti u mogucnosti da prebaci jezik na engleski" )
	public void NItShouldBeAvailableOnEN() throws InterruptedException {
		try {
			assertTrue(isElementPresent(By.cssSelector("a.btn-en.gaEvent")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.cssSelector("a.btn-en.gaEvent")).click();
		driver.findElement(By.xpath("//*[@class='name'][contains(text(), 'Brèanska')]")).click();
		Thread.sleep(5000);
	}
  
	  @Test (description= "Mora biti u mogucnosti da pretrazuje objekat" )
	public void OIsAbleToSearchObject() {
			try {
				assertTrue(isElementPresent(By.xpath("//input[2]")));
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
			driver.findElement(By.xpath("//input[2]")).clear();
			driver.findElement(By.xpath("//input[2]")).sendKeys("Test Caffe");
			driver.findElement(By.className("iconav-search")).click();
		}

	  @Test (description= "Mora biti u mogucnosti da klikne na trazeni rezultat pretrage" )
	public void PSearchResultsShouldAppear() throws InterruptedException {
			try {
				assertEquals("Test Caffe",
						driver.findElement(By.xpath("//*[@class='name'][contains(text(), 'Test Caffe')]")).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
			driver.findElement(By.xpath("//*[@class='name'][contains(text(), 'Test Caffe')]")).click();
			
			Thread.sleep(3000);
		}
	  	

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
}
