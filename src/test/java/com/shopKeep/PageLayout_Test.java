package com.shopKeep;

import Utilities.SKDriver;
import Utilities.Wait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PageLayout_Test extends SKDriver {

   //Verify that the user is able to add  an inventory item to the ipad screen
    @Test
    public void VerifyAddingInventoryItems()  {
       // Navigate to url
        driver.get(webURL);
        //login
        Inventory.login("test-ai-1","ariful_islam@shopkeep.com","AIpassword123");
        Wait.sleep(5000);

        //add inventory item to screen
        WebElement inventoryItem= driver.findElement(By.cssSelector(".description"));

        WebElement screen=driver.findElement(By.cssSelector("div[id*='button-page-']"));

        int ipadScreenY = screen.getLocation().getY();

        Inventory.addItemToScreen(inventoryItem,0, (300+ipadScreenY));
        Wait.sleep(1000);

        //verify that inventory item has been added to screen
        WebElement AddedItem = driver.findElement(By.cssSelector(".button-name>p"));
        assert(AddedItem.isDisplayed());

    }


    //verify that the user can add  new page to the screen
    @Test
    public void verifyAddNewPage()  {
        driver.get(webURL);

        Inventory.login("test-ai-1", "ariful_islam@shopkeep.com", "AIpassword123");
        Wait.sleep(5000);

        //Add new page to the ipad screen.
        Screen.addNewPage("Test");

        //Verify new page new page was added
        WebElement currentPage = driver.findElement(By.cssSelector(".name"));

        //verify Page was created
        assert(currentPage.getText().equals("Test"));

        //clean up
        //Removing page from the ipad screen.
        Screen.removePageFromScreen();



    }

    //verify that the user can cancel removing a  new page
    @Test
    public void verifyCancelDeleting(){
        driver.get(webURL);

        Inventory.login("test-ai-1", "ariful_islam@shopkeep.com", "AIpassword123");
        Wait.sleep(5000);

        //Add new page to the ipad screen.
        Screen.addNewPage("Test2");

        //Cancel removing the page from the ipad screen by clicking on the cancel button.
        Screen.cancelremovingpagewithcancelbutton();

        //Verify new page new page was added
        WebElement currentPage = driver.findElement(By.cssSelector(".name"));

        //verify Page was created
        assert(currentPage.getText().equals("Test2"));

        //clean up for rerun/next test
        //Removing page from the ipad screen.
        Screen.removePageFromScreen();

    }


    //verify that the user can search the inventory item list for a specific item
    @Test
    public void verifySearchInventory() {
        driver.get(webURL);

        Inventory.login("test-ai-1", "ariful_islam@shopkeep.com", "AIpassword123");
        Wait.sleep(5000);

        Screen.searchForItem("Coffee");

        String result = driver.findElement(By.xpath("html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[2]/span[1]")).getText();
        System.out.print(result);

        assert (result.contains("Coffee"));
    }





}
