package com.crm;

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

public class Sampleclass extends Base_test
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

				String orgNamee = eLib.getExcellData(EXCEL_path,"Sheet1",1,2)+ randomNum;
				String orgType = eLib.getExcellData(EXCEL_path,"Sheet1",1,4);
				String orgIndustry = eLib.getExcellData(EXCEL_path,"Sheet1",1,3);
				String orgRating = eLib.getExcellData(EXCEL_path,"Sheet1",1,5);

				String contLastNAme = eLib.getExcellData(EXCEL_path,"Sheet1",1,6) + randomNum;
				
				String ProductName = eLib.getExcellData(EXCEL_path,"Sheet1",1,7) +randomNum;
				String UnitPrice  = eLib.getExcellData(EXCEL_path, "Sheet1",1,8) ;
			
				String SubjecttName = eLib.getExcellData(EXCEL_path,"Sheet1",1,9)+randomNum;
				
				String BillingAdd = eLib.getExcellData(EXCEL_path,"Sheet1", 1,10)+randomNum;
				
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
				
				 CreateOrgPage.Createorganization(orgNamee, orgIndustry, orgType, orgRating);
				 
				 //verify org
				OrgnizationInfo orgInfo = new  OrgnizationInfo(driver);
				String actSuccessfullMsg = orgInfo.getSucessFullMasg().getText();
				 Assert.assertTrue(actSuccessfullMsg.contains(orgNamee));
				 
				 //navi to contact
				 HomePage.getContactLink().click();
				 
				 //create contact
				 Contacts conPage = new Contacts(driver);
				 wLib.waitForHTMLDOM(driver);
				 conPage.getCreateContacts().click();
				 
				CreateContacts newCont = new  CreateContacts (driver);
				newCont.createContact(contLastNAme, orgNamee);
				
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
				 cNq.createQuotes(SubjecttName,BillingAdd,orgNamee,contLastNAme,ProductName);
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
