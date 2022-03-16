package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.admin.nopCommerce.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.nopCommerce.user.BasePageUI;

public  class BasePage extends BasePageUI {

    public static BasePage getBasePageObject() {
      return    new BasePage();
    }


    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);

    }


    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();

    }

    public void refeshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresent(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, LongTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());  // hàm trả về 1 alert, và hàm alertIsPresent nó đã switch qua alert roi
    }

    public void accepptAlert(WebDriver driver) {
        waitForAlertPresent(driver).accept();

    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresent(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitForAlertPresent(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String textValue) {
        waitForAlertPresent(driver).sendKeys(textValue);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    private  By getByXpath(String xpathLocator) {
        return	By.xpath(xpathLocator);
    }
    
    // locatorType: id= / css=/ xpath=/ class =
    // locatorType: ID=/ CSS=/ XPATH=/ NAME=/ CLASS=
    // locatorType: Id=/ Css=/ XPath=/ Name=/ Class=
    private By getByLocator(String locatorType) {
    	By by = null;
    	if (locatorType.startsWith("id=")|| locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
    		
    		by = By.id(locatorType.substring(3));
		}
    	else if(locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
    		by = By.className(locatorType.substring(6));
    	}
    	else if(locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
    		by = By.name(locatorType.substring(5));
    	}
     	else if(locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("css=")) {
    		by = By.cssSelector(locatorType.substring(4));
    	}
    	else if(locatorType.startsWith("xpath=")) {
    		by = By.xpath(locatorType.substring(6));
    	}
    	else {
    		throw new RuntimeException("Locator type is not supported!");
    	}
    	
    	
    	
    	
    	return by;
    }

    private WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }

    private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
        return  driver.findElements(getByXpath(xpathLocator));

    }

    public void clickToElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }



    public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        select.selectByValue(textItem);

    }

    public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropDownMultiple(WebDriver driver, String xpathLocator, String textItem) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItem) {
        getWebElement(driver, parentXpath).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver,LongTimeout);



        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }


    }



    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return 	getWebElement(driver,xpathLocator).getAttribute(attributeName);

    }

    public String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText();
    }

    public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver,xpathLocator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(WebDriver driver, String xpathLocator) {
        return 	getListWebElement(driver,xpathLocator).size();

    }

    public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver,xpathLocator);
        if(!element.isSelected()) {
            element.click();
        }

    }

    public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver,xpathLocator);
        if(element.isSelected()) {
            element.click();
        }

    }

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        return 	getWebElement(driver,xpathLocator).isDisplayed();
    }

    public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
        return 	getWebElement(driver,xpathLocator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return 	getWebElement(driver,xpathLocator).isSelected();
    }

    public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
        driver.switchTo().frame(getWebElement(driver,xpathLocator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver,xpathLocator)).perform();
    }



    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }



    public void highlightElement(WebDriver driver, String xpathLocator) {
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
    }

    public void scrollToElement(WebDriver driver, String xpathLocator) {
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }



    public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait	explicitWait = new WebDriverWait(driver, LongTimeout);
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
        if (status) {
            return true;
        } else {
            return false;
        }

    }


    public void waitForElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver,LongTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver,LongTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }

    public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver,LongTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver,LongTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver,LongTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
    }
    
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
		
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver,  BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		
	}
	
	public UserRewardPointPageObject openRewardPoint(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver,  BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
		
	}
	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver,  BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
		
	}
	
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver,  BasePageUI.LOGOUT_LINK_AT_USER);
		// logout quay ve trang UserHomePage
		return PageGeneratorManager.getUserHomePage(driver);
		
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		//logout quay ve trag AdminLoginPage
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
    private long LongTimeout = 30;

}
