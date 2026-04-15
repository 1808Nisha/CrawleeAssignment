package pagepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import generic.BaseTest;

public class Crawlee extends BaseTest {

    @FindBy(xpath = "//li[@class='sidebarItem__DBe']//a")
    private List<WebElement> header_Links;

    @FindBy(xpath = "//h1[@class='title_xvU1']")
    private WebElement title;

    // REMOVED: The constructor with WebDriver argument.
    // ADDED: A method or logic to initialize PageFactory.

    // public Crawlee(){
    //     PageFactory.initElements(driver,this);
    // }

   @Test
public void validating_Menu_Item_Label_Match_To_Title() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    PageFactory.initElements(driver, this);
    Actions actions = new Actions(driver);
    

    int size=header_Links.size();
    System.out.println(size);

    
    for (int i = 0; i < size; i++) {
        // 1. Refresh all element references in the class
        PageFactory.initElements(driver, this);

        // 2. Grab the i-th element from the FRESHLY initialized list
        WebElement header = header_Links.get(i);

        // 3. Perform actions
        wait.until(ExpectedConditions.visibilityOf(header));
        String headerText = header.getText();
        System.out.println("Processing: " + headerText);
        actions.scrollToElement(header).perform();

        ((org.openqa.selenium.JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView({block: 'center'});", header);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(header)).click();
        
        // 4. Wait for the title to update before next loop
        wait.until(ExpectedConditions.visibilityOf(title));
        String title_Text=title.getText();


        report(
        headerText.equals(title_Text), 
        "Check header Text "+headerText+" is same as title "+title_Text, 
        "Header and title Matched", 
        "Header and title are not matched"
    );
        

    
        // Note: If clicking the link takes you to a different page 
        // and the sidebar disappears, you MUST add:
        // driver.navigate().back(); 
    }
    
   
        
}
}