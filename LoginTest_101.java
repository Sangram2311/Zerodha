package testclases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClases.BaseClass;
import BaseClases.Utility;
import Configurations.PathConf;
import pomclases.KiteLogin1Page;
import pomclases.Login;

public class LoginTest_101 {

	WebDriver driver;
	BaseClass base;
	Sheet sh;
	Login login1;
	String tcID;
	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException  {
		
	Reporter.log("---Open Browser---",true);	
    FileInputStream file = new FileInputStream(PathConf.ExcelPath);
    sh = WorkbookFactory.create(file).getSheet("Sheet12");
	
	base = new BaseClass();
	driver = base.InitializeBrowser();
	login1 = new Login(driver);
	}	
	@BeforeMethod
	public void beforemethodrefresh() {
		driver.navigate().refresh();
	}	
	@Test
	public void LoginScenario1() {
		tcID = "101";
		Reporter.log("--login negative test- Blank Credentials--",true);
		login1.clickKiteLogin1PageLoginBtn();
		
		String actErrorMsg = login1.getKiteLogin1PageMsgUN();
		String expErrorMsg = "User ID should be minimum 6 characters.";
		Assert.assertEquals(actErrorMsg, expErrorMsg);
		
		String actErrorMsg1 = login1.getKitelogin2PageMsgPWD();
		String expErrorMsg1 = "Password should be minimum 6 characters.";
		Assert.assertEquals(actErrorMsg1, expErrorMsg1);
	}	
	@Test
	public void LoginScenario2_EnterOnlyUsername() throws EncryptedDocumentException, IOException {
		tcID = "102";
		Reporter.log("---TC Name: Login Negative Test- Blank UserId---");
		login1.clickKiteLogin1PageLoginBtn();
		login1.inpkitelogin1PagePassword(Utility.getTestData(1, 2));
		String actErrorMsg2 = login1.getKiteLogin1PageMsgUN();
		String expErrorMsg2 = "User ID should be minimum 6 characters.";
		Assert.assertEquals(actErrorMsg2, expErrorMsg2);
	
	}	
	@Test
	public void LoginScenario_EnterOnlyPassword() throws EncryptedDocumentException, IOException {
		tcID = "103";
		Reporter.log("---TC Name: Login Negative Test- Blank Password---");
		login1.clickKiteLogin1PageLoginBtn();
		login1.inpkitelogin1PageUserId(Utility.getTestData(2, 2));
		String actErrorMsg3 = login1.getKitelogin2PageMsgPWD();
		String expErrorMsg3 = "Password should be minimum 6 characters.";
		Assert.assertEquals(actErrorMsg3, expErrorMsg3);	
	}
	public void LoginScenario_EnterUserPass() throws EncryptedDocumentException, IOException {
		tcID = "104";
		Reporter.log("---TC Name: Login Positive Test---");
		login1.inpkitelogin1PageUserId(Utility.getTestData(3, 2));
		login1.inpkitelogin1PagePassword(Utility.getTestData(3, 2));
		login1.clickKiteLogin1PageLoginBtn();	
	}
	
	@AfterMethod
	public void takesscreenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, tcID);
		}
		
	}
	
    @AfterClass
    public void closebrowser() {
	Reporter.log("---Close Browser---", true);
	driver.close();
	

	}
	

}