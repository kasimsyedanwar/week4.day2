package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kasim");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Syed Anwar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("anwar");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("ECE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Engineer");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kasimsyedanwar@gmail.com");
		WebElement stateDropDown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	
		Select selectStateDropDown = new Select(stateDropDown);
		selectStateDropDown .selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Test Lead");
		driver.findElement(By.className("smallSubmit")).click();
		
		String actualResult = "View Lead | opentaps CRM";
		String expectedResult = driver.getTitle();
		if (actualResult.equals(expectedResult)) {
			System.out.println("create lead is created");
			
			
		}else {
			System.out.println("create lead is not created");
		}
	}

}

