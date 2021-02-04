package com.crm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.Base_test;
import com.crm.autodesk.genericlib.Excellutills;
import com.crm.autodesk.genericlib.PropertyFileUtils;
import com.crm.autodesk.genericlib.WebDriverCommomLib;
import com.crm.autodesk.objectrepositorylib.Contact_info;
import com.crm.autodesk.objectrepositorylib.Contacts;
import com.crm.autodesk.objectrepositorylib.CreateContacts;
import com.crm.autodesk.objectrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrepositorylib.CreateNewQuotes;
import com.crm.autodesk.objectrepositorylib.Home;
import com.crm.autodesk.objectrepositorylib.Login;
import com.crm.autodesk.objectrepositorylib.Organization;
import com.crm.autodesk.objectrepositorylib.OrgnizationInfo;
import com.crm.autodesk.objectrepositorylib.ProductInfo;
import com.crm.autodesk.objectrepositorylib.Products;
import com.crm.autodesk.objectrepositorylib.Quoets;
import com.crm.autodesk.objectrepositorylib.Quotes_Info;
import com.crm.autodesk.objectrepositorylib.createNewProduct;

import javalib.Javalibb;

public class Creeate_quotes_in_pom  extends Base_test
{

	//object creation
	Base_test bLib = new Base_test();
	Excellutills eLib = new Excellutills();
	Javalibb jLib =new Javalibb();
	 PropertyFileUtils pLib = new PropertyFileUtils();
	 WebDriverCommomLib wLib =new WebDriverCommomLib();
	 
	 
	 @Test
	 public void create_quotes() throws Throwable
	 {
		 /* Common Data */
			int randomNum = jLib.getRandomNumber();
			String USERNAME = pLib.getPropertykeyValue(PRO_path, "username");
			String PASSWORD = pLib.getPropertykeyValue(PRO_path, "password");
			String URL = pLib.getPropertykeyValue(PRO_path, "url");
			String BROWSER = pLib.getPropertykeyValue(PRO_path, "browser");

			/* test Data */

			String orgName = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "orgname")+ randomNum;
			String orgType = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "orgType");
			String orgIndustry = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01","orgind");
			String orgRating = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "orgrating");

			String contLastNAme = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "contactName") + randomNum;
			
			String ProductName = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "ProductName") +randomNum;
			String UnitPrice  = eLib.getExcellData(EXCEL_path, "Sheet1","tc_01", "UnitPrice") ;
		
			String SubjecttName = eLib.getExcellData(EXCEL_path,"Sheet1","tc_01", "SubjecttName")+randomNum;
			
			String BillingAdd = eLib.getExcellData(EXCEL_path,"Sheet1", "tc_01", "BillingAdd")+randomNum;
			
			bLib.OpenBrowsr();
			//login to app
			Login loginPage = new Login(driver);
			loginPage.login(USERNAME, PASSWORD);
			//navigate to org
			Home HomePage = new Home(driver);
			HomePage.getOrgLink().click();
			//create org 
			Organization orgPage = new Organization(driver);
			 wLib.waitForHTMLDOM(driver);
			orgPage.getOrgImage().click();
			
			CreateNewOrganization CreateOrgPage = new CreateNewOrganization(driver);
			
			 CreateOrgPage.Createorganization(orgName, orgIndustry, orgType, orgRating);
			 
			 //verify org
			OrgnizationInfo orgInfo = new  OrgnizationInfo(driver);
			String actSuccessfullMsg = orgInfo.getSucessFullMasg().getText();
			 Assert.assertTrue(actSuccessfullMsg.contains(orgName));
			 
			 //navi to contact
			 HomePage.getContactLink().click();
			 
			 //create contact
			 Contacts conPage = new Contacts(driver);
			 wLib.waitForHTMLDOM(driver);
			 conPage.getCreateContacts().click();
			 
			CreateContacts newCont = new  CreateContacts (driver);
			newCont.createContact(contLastNAme, orgName);
			
			//verify contact
			
			Contact_info cI = new Contact_info (driver);
			String actSuccessfullMsgci = cI.getSuccessfullmasage().getText();
			Assert.assertTrue(actSuccessfullMsgci.contains(contLastNAme));
			
			//navi to products
			
			HomePage.getProductLink().click();
			//ceate product 
			Products proPage = new Products(driver);
			 wLib.waitForHTMLDOM(driver);
			proPage.getproImage().click();
			createNewProduct cnp = new createNewProduct (driver);
			cnp.CreateNewProduct(ProductName, UnitPrice);
			
			//verify product
			ProductInfo proInfo = new ProductInfo(driver);
			
			String actSuccessfullMsgpro = proInfo.getSucessFullMasg().getText();
			Assert.assertTrue(actSuccessfullMsgpro.contains(ProductName));
			
			//navi to quotes
			
			HomePage.getMoreLink().click();
			HomePage.getQuotesLink().click();
			
			//create quotes
			 Quoets qutPage = new Quoets(driver);
			 wLib.waitForHTMLDOM(driver);
			 qutPage.getQuotesImage().click();
			 CreateNewQuotes cNq = new CreateNewQuotes (driver);
			 cNq.createQuotes(SubjecttName, BillingAdd, orgName, contLastNAme, ProductName);
			 //verify quotes
			Quotes_Info qI = new  Quotes_Info (driver);
			String actSuccessfullMsgquotes = qI.getSuccessfullmasage().getText();
			Assert.assertTrue(actSuccessfullMsgquotes.contains(SubjecttName));
			
			//log out 
			
			HomePage.logout();
			//close the browser
			bLib.closeBrowser();
			 
			 
			 
			 
			
			
			
			
			
			
	 }
	 
	 
	
	
	
	
	
	
}
