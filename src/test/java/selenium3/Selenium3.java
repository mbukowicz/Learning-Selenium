package selenium3;

import com.google.common.base.Charsets;
import java.io.File;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.common.io.Resources;
import com.thoughtworks.selenium.Selenium;
import java.io.IOException;
import java.net.URL;

public class Selenium3 {

    @Test
    public void selenium3() throws IOException {
        WebDriver driver = new FirefoxDriver();

        String htmlPath = this.createPathToHtml("selenium3.html");
        System.out.println(String.format("Will open browser at '%s'", htmlPath));
        driver.get(htmlPath);
        
        this.waitForAwhile();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // load jQuery dynamically
        URL jqueryUrl = Resources.getResource("jquery.min.js");
        String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
        js.executeScript(jqueryText);
        
        // pure JQuery
        String jQuerySelector = "#users tr:has(td:contains('Bob')) button:contains('Remove')";
        js.executeScript("$(\"" + jQuerySelector + "\").click();");
        
        // the same with clicking on the Selenium side
        //WebElement removeButton = (WebElement) js.executeScript("return $(\"" + jQuerySelector + "\").get(0);");
        //removeButton.click();
        
        // the same but with Selenium object
        //Selenium selenium = new WebDriverBackedSelenium(driver, htmlPath);
        //selenium.click("css=#users tr:has(td:contains('Bob')) button:contains('Remove')");
        
        this.waitForAwhile();
        
        driver.quit();
    }

    private String createPathToHtml(String htmlFilename) {
        char sc = File.separatorChar;
        String currentDir = System.getProperty("user.dir");
        String resourcesPath = currentDir + sc + "src" + sc + "test" + sc + "resources";
        String htmlPath = resourcesPath + sc + htmlFilename;
        return htmlPath;
    }

    private void waitForAwhile() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException ex) {
            // for simplicity we don't care
        }
    }
}
