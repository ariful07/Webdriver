package com.shopKeep;

import Utilities.SKDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Inventory extends SKDriver {

//method to login innto shopkeep back end site
    public static void login(String storeId, String email, String password)
    {
        driver.findElement(By.id("store_name")).clear();
        driver.findElement(By.id("store_name")).sendKeys(storeId);
        driver.findElement(By.id("login")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }


    public static void addItemToScreen(WebElement sourceElement, int x, int y)
    {
        (new Actions(driver)).dragAndDropBy(sourceElement,x,y).perform();

    }




}



