package selenium1;


import java.io.File;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Selenium1 {

    @Test
    public void selenium1() {
        WebDriver driver = new FirefoxDriver();

        String htmlPath = this.createPathToHtml("selenium1.html");
        System.out.println(String.format("Will open browser at '%s'", htmlPath));
        driver.get(htmlPath);

        WebElement user = driver.findElement(By.name("user"));
        user.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("HackMe!");

        WebElement login = driver.findElement(By.id("login"));
        login.click();

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
