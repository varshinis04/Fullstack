import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://v1.training-support.net/selenium/tables");

        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the first table
        WebElement table = driver.findElement(By.xpath("//table[1]"));

        // Find the number of rows and columns in the table and print them
        List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
        List<WebElement> columns = table.findElements(By.xpath("./thead/tr/th"));
        System.out.println("Number of rows: " + rows.size());
        System.out.println("Number of columns: " + columns.size());

        // Find and print all the cell values in the third row of the table
        List<WebElement> thirdRowCells = rows.get(2).findElements(By.xpath("./td"));
        for (WebElement cell : thirdRowCells) {
            System.out.println("Cell value: " + cell.getText());
        }

        // Find and print the cell value at the second row second column
        WebElement secondRowSecondColumnCell = rows.get(1).findElement(By.xpath("./td[2]"));
        System.out.println("Cell value: " + secondRowSecondColumnCell.getText());

        // Close the browser
        driver.close();
    }
}