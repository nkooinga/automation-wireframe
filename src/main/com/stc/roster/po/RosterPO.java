package com.stc.roster.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by nkooinga on 5/30/2017.
 */
public class RosterPO {

    WebDriver driver;
    public RosterPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

//    WebDriverWait wait = new WebDriverWait(driver, 10);


    @FindBy(id = "listBox2")
    private WebElement rosterGradeFilter;

    public WebElement getRosterGradeFilter() {
        return rosterGradeFilter;
    }

    @FindBy(id = "listBox3")
    private WebElement sortBy;

    public WebElement getSortBy() {
        return sortBy;
    }

    @FindBy(className = "Add New Student")
    private WebElement addNewStudentBtn;

    public WebElement getAddNewStudentBtn() {
        return addNewStudentBtn;
    }

    @FindBy(className = "Update Roster")
    private WebElement updateRosterBtn;

    public WebElement getUpdateRosterBtn() {
        return updateRosterBtn;
    }
//Student Specific Elements
    @FindBy(className = "glyphicon-pencil")
    private WebElement studentDemo;

    public WebElement getStudentDemo() {
        return studentDemo;
    }

    @FindBy(className = "hNZDpO")
    private WebElement patientStatus;

    public WebElement getPatientStatus() {
        return patientStatus;
    }

    @FindBy(linkText = "vaccination")
    private WebElement vaccSummaryPage;

    public WebElement getVaccSummaryPage() {
        return vaccSummaryPage;
    }

    @FindBy(linkText = "form")
    private WebElement cisForm;

    public WebElement getCisForm() {
        return cisForm;
    }

    @FindBy(id = "grade")
    private WebElement gradeLevel;

    public WebElement getGradeLevel() {
        return gradeLevel;
    }

    @FindBy(id = "forecastStatus")
    private WebElement forecastStatus;

    public WebElement getForecastStatus() {
        return forecastStatus;
    }

    public void anyStatusSelect() throws InterruptedException {
        Thread.sleep(2000);
        getStatusFilter().click();
        Thread.sleep(1000);
        getAnyStatus().click();
    }

    public void dueNowStatusSelect() throws InterruptedException {
        Thread.sleep(2000);
        getStatusFilter().click();
        Thread.sleep(1000);
        getDueNowStatus().click();
//        Assert.assertEquals("Due Now", getPatientStatus());
    }

    public void pastDueStatusSelect() throws InterruptedException {
        Thread.sleep(2000);
        getStatusFilter().click();
        Thread.sleep(1000);
        getPastDueStatus().click();
//        Assert.assertEquals("Past Due", getPatientStatus());
    }

    public void upToDateStatusSelect() throws InterruptedException {
        Thread.sleep(2000);
        getStatusFilter().click();
        Thread.sleep(1000);
        getUpToDateStatus().click();
//        Assert.assertEquals("Up to Date", getPatientStatus());
    }

    public void optionalStatusSelect() throws InterruptedException {
        Thread.sleep(2000);
        getStatusFilter().click();
        Thread.sleep(1000);
        getOptionalStatus().click();
//        Assert.assertEquals("Optional", getPatientStatus());
    }
}
