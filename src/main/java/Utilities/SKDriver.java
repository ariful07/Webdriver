package Utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SKDriver extends Environment{

protected static WebDriver driver;

    @Before
    public void setUp() {
        if (browser.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\\\SeleniumDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\\\SeleniumDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();

        }
    }




    @After
    public void tearDown(){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        driver.quit();
    }

}
