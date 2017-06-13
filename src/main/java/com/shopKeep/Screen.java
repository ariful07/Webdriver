package com.shopKeep;

import Utilities.SKDriver;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Screen extends SKDriver {

    //method to add a new page to the ipad Screen

    public static void addNewPage(String newPageName){
        //Adding new page to the ipad screen.

        driver.findElement(By.cssSelector("#button-page-name")).clear();
        driver.findElement(By.cssSelector("#button-page-name")).sendKeys(newPageName);
        driver.findElement(By.cssSelector("#add-button-page")).click();
        Wait.sleep(5000);
        //refreshing the page due to stale element when adding a new page
        driver.navigate().refresh();
        Wait.sleep(3000);
        focusOnPage(newPageName);

    }

    //Method to focus on a specific page
    public static void focusOnPage(String pageName){
        List<WebElement> pages = driver.findElements(By.cssSelector(".name"));
        for(int i=0;i<pages.size();i++){
            if(pages.get(i).getText().equals(pageName)){
                pages.get(i).click();
            }
        }
    }
    // Method to search specefic items on the ipad screen.
    public static void searchForItem(String nameoftheitem){
        driver.findElement(By.cssSelector("#item-search-input")).click();
        driver.findElement(By.cssSelector("#item-search-input")).sendKeys(nameoftheitem);
        Wait.sleep(2000);
    }


    // Method to cancel removing the page by clicking on cancel button.
    public static void cancelremovingpagewithcancelbutton(){
        driver.findElement(By.cssSelector("#destroy-button-page")).click();
        driver.findElement(By.cssSelector(".button.default.cancel")).click();
    }
    // Method to remove page from the ipad scdreen.
    public static void removePageFromScreen(){
        driver.findElement(By.cssSelector("#destroy-button-page")).click();
        driver.findElement(By.cssSelector(".button.primary.confirm")).click();
    }
}
