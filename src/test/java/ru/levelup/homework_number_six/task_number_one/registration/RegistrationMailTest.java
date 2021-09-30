package ru.levelup.homework_number_six.task_number_one.registration;

import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelup.homework_number_six.task_number_one.registration.page.RegistrationPage;

public class RegistrationMailTest extends RegistrationPage {
      private static final Faker FAKER = new Faker();
      PropertyData testData = new PropertyData();


  @Test
  public void exerciseOneTest() {
      String myTheme = FAKER.name().name();
      String myBody = FAKER.book().title();

      login(testData.getData("login"), testData.getData("password"));
      Assert.assertEquals(checkMailPage(),true);

      createSend(testData.getData("email.to.send"), myTheme,myBody, false);
      openDraft();
      Verify.verify(checkTextAttribute(testData.getData("email.to.send")), "Email не найден");
      Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

      openAndSendLetter(myTheme);
      Verify.verify(!emptyTextAttribute(myTheme), "Письмо не отправлено");

      openSendsForm();
      Verify.verify(checkTextAttribute(testData.getData("email.to.send")), "Email не найден");
      Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

      logout();
  }

  @Test
  public void exerciseTwoTest() {
      String myTheme = FAKER.name().firstName();
      String myBody = FAKER.book().title();

      login(testData.getData("login"), testData.getData("password"));
      Assert.assertEquals(checkMailPage(),true);

      openTestForm();
      int startCount = countLetter();

      createSend(testData.getData("email"), testData.getData("first.word")+myTheme ,"Тест_"+myBody, true);
      openSendsForm();
      Verify.verify(checkTextAttribute(testData.getData("email")), "Email не найден");
      Verify.verify(checkTextAttribute(testData.getData("first.word")+myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute(testData.getData("first.word")+myBody), "Текст письма не найден");

      openTestForm();
      Verify.verify(countLetter()>startCount, "Письмо не добавлено в папку");
      Verify.verify(checkEmailAttribute(testData.getData("first.word")+myTheme,"test_level_up@mail.ru"), "Email не найден");
      Verify.verify(checkTextAttribute(testData.getData("first.word")+myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute(testData.getData("first.word")+myBody), "Текст письма не найден");

      logout();
  }

  @Test
  public void exerciseThreeTest() {
    String myTheme = FAKER.name().firstName();
    String myBody = FAKER.book().title();

    login(testData.getData("login"), testData.getData("password"));
    Assert.assertEquals(checkMailPage(),true);

    int startCount = countLetter();
    openDeleteForm();
    int deleteCount = countLetter();
    createSend(testData.getData("email"), myTheme, myBody, true);

    openInnerLetter();
    Verify.verify(countLetter()>startCount, "Письмо не добавлено в папку");
    Verify.verify(checkEmailAttribute(myTheme,testData.getData("email")), "Email не найден");
    Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
    Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

    openAndDeleteLetter(myTheme);
    Verify.verify(countLetter()>deleteCount, "Письмо не добавлено в папку");
    Verify.verify(checkEmailAttribute(myTheme,testData.getData("email")), "Email не найден");
    Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
    Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

    logout();
  }
}
