package ru.levelup.homework_number_six.task_number_one.registration.page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelup.homework_number_six.task_number_one.base.SeleniumBase;

public class RegistrationPage extends SeleniumBase {

  public WebElement loginField() {
    return driver.findElement(By.name("login"));
  }

  public WebElement passwordField() {
    return driver.findElement(By.name("password"));
  }

  public WebElement sendPasswordButton() {
    return driver.findElement(By.cssSelector("button[data-testid=\"enter-password\"]"));
  }

  public WebElement loginButton() {
    return driver.findElement(By.cssSelector("button[data-testid=\"login-to-mail\"]"));
  }

  public WebElement getNameMail() {
    return driver.findElement(
        By.xpath("//div[@id = 'headline']//span[contains(text(),'test_level_up@mail.ru')]"));
  }

  public WebElement createMailButton() {
    return driver.findElement(By.cssSelector("a[title=\"Написать письмо\"]"));
  }

  public WebElement innerButton() {
    return driver.findElement(By.cssSelector("a[title^='Входящие']"));
  }

  public WebElement draftButton() {
    return driver.findElement(By.cssSelector("a[title^='Черновики']"));
  }

  public WebElement sendsButton() {
    return driver.findElement(By.cssSelector("a[title^='Отправленные']"));
  }

  public WebElement deleteFormButton() {
    return driver.findElement(By.cssSelector("a[title^='Корзина']"));
  }

  public WebElement folderTestButton() {
    return driver.findElement(By.cssSelector("a[title^='Тест']"));
  }

  public WebElement fieldWhom() {
    return driver.findElement(By.cssSelector("div[class^=head_container] input"));
  }

  public WebElement fieldTheme() {
    return driver.findElement(By.cssSelector("div[class^=subject__container] input"));
  }

  public WebElement fieldBodyEmail() {
    return driver.findElement(By.cssSelector("div[role=\"textbox\"] div"));
  }

  public WebElement sendButton() {
    return driver.findElement(By.cssSelector("span[title=\"Отправить\"]"));
  }

  public WebElement saveButton() {
    return driver.findElement(By.cssSelector("span[title=\"Сохранить\"]"));
  }

  public WebElement closeButton() {
    return driver.findElement(By.cssSelector("button[title=\"Закрыть\"]"));
  }

  public WebElement deleteButton() {
    return driver.findElement(By.cssSelector(".layout__main-frame span[title=\"Удалить\"] .button2__txt"));
  }

  public boolean checkTextAttribute(String text) {
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text)));
    return driver.findElement(By.partialLinkText(text)).isDisplayed();
  }

  public boolean checkEmailAttribute(String text, String email) {
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text)));
    return driver.findElement(By.xpath("//span[text() = '" + text
            + "']//ancestor::div[@class = 'llc__container']//span[contains(@title,'<" + email + ">')]"))
        .isDisplayed();
  }

  public boolean emptyTextAttribute(String text) {
    try {
      return driver.findElement(By.partialLinkText(text)).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void login(String nameMail, String passwordMail) {
    loginField().sendKeys(nameMail);
    sendPasswordButton().click();
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(passwordField()));
    passwordField().sendKeys(passwordMail);
    loginButton().click();
  }

  public void logout() {
    driver.findElement(
            By.xpath("//div[@id = 'headline']//span[contains(text(),'test_level_up@mail.ru')]"))
        .click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class^=ph-accounts]")));
    driver.findElement(By.cssSelector("div[class^=ph-accounts]"))
        .findElement(By.partialLinkText("Выйти")).click();
  }

  public boolean checkMailPage() {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@id = 'headline']//span[contains(text(),'test_level_up@mail.ru')]")));
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("a[title=\"Написать письмо\"]")));
    return getNameMail().isDisplayed();
  }

  public void createSend(String email, String theme, String text, boolean send) {
    createMailButton().click();
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("div[class^=head_container] input")));
    fieldWhom().sendKeys(email);
    fieldTheme().sendKeys(theme);
    fieldBodyEmail().sendKeys(text);
    if (!send) {
      saveButton().click();
      closeButton().click();
    } else {
      sendButton().click();
      new WebDriverWait(driver, 10).until(
          ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Письмо отправлено")));
      driver.findElement(By.partialLinkText("Письмо отправлено")).click();
    }
  }

  public void openDraft() {
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(draftButton()));
    draftButton().click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dataset-letters")));
  }

  public void openAndSendLetter(String text) {
    driver.findElement(By.partialLinkText(text)).click();
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("div[class^=head_container] input")));
    sendButton().click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Письмо отправлено")));
    driver.findElement(By.partialLinkText("Письмо отправлено")).click();
    openDraft();
  }

  public void openSendsForm() {
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(sendsButton()));
    sendsButton().click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dataset-letters")));
  }

  public void openTestForm() {
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.elementToBeClickable(folderTestButton()));
    folderTestButton().click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dataset-letters")));
  }

  public int countLetter() {
    return driver.findElements(By.cssSelector(".dataset-letters div[class= 'llc__container']"))
        .size();
  }

  public void openInnerLetter() {
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.elementToBeClickable(folderTestButton()));
    innerButton().click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dataset-letters")));
  }

  public void openDeleteForm() {
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.elementToBeClickable(deleteFormButton()));
    deleteFormButton().click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dataset-letters")));
  }

  public void openAndDeleteLetter(String text) {
    driver.findElement(By.partialLinkText(text)).click();
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector(".thread__subject")));
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(deleteButton()));
    deleteButton().click();
    driver.manage().timeouts().implicitlyWait(2000,
        TimeUnit.MILLISECONDS);
    openDeleteForm();
  }

}