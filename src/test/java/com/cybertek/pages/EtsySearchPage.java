package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearchPage {

    public EtsySearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;
}