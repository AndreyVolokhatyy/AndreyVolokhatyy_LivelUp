package ru.levelup.homework_number_six.task_number_one.registration;

import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelup.homework_number_six.task_number_one.registration.page.RegistrationPage;

public class RegistrationMailTest extends RegistrationPage {
      private static final Faker FAKER = new Faker();


  @Test
  public void exerciseOneTest() {
      String myTheme = FAKER.name().name();
      String myBody = FAKER.book().title();

      login("test_level_up", "Zxcnbv11");
      Assert.assertEquals(checkMailPage(),true);

      createSend("ftrix@yandex.ru", myTheme,myBody, false);
      openDraft();
      Verify.verify(checkTextAttribute("ftrix@yandex.ru"), "Email не найден");
      Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

      openAndSendLetter(myTheme);
      Verify.verify(!emptyTextAttribute(myTheme), "Письмо не отправлено");

      openSendsForm();
      Verify.verify(checkTextAttribute("ftrix@yandex.ru"), "Email не найден");
      Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

      logout();
  }

  @Test
  public void exerciseTwoTest() {
      String myTheme = FAKER.name().firstName();
      String myBody = FAKER.book().title();

      login("test_level_up@mail.ru", "Zxcnbv11");
      Assert.assertEquals(checkMailPage(),true);

      openTestForm();
      int startCount = countLetter();

      createSend("test_level_up@mail.ru", "Тест_"+myTheme ,"Тест_"+myBody, true);
      openSendsForm();
      Verify.verify(checkTextAttribute("test_level_up@mail.ru"), "Email не найден");
      Verify.verify(checkTextAttribute("Тест_"+myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute("Тест_"+myBody), "Текст письма не найден");

      openTestForm();
      Verify.verify(countLetter()>startCount, "Письмо не добавлено в папку");
      Verify.verify(checkEmailAttribute("Тест_"+myTheme,"test_level_up@mail.ru"), "Email не найден");
      Verify.verify(checkTextAttribute("Тест_"+myTheme), "Тема письма не найдена");
      Verify.verify(checkTextAttribute("Тест_"+myBody), "Текст письма не найден");

      logout();
  }

  @Test
  public void exerciseThreeTest() {
    String myTheme = FAKER.name().firstName();
    String myBody = FAKER.book().title();

    login("test_level_up@mail.ru", "Zxcnbv11");
    Assert.assertEquals(checkMailPage(),true);

    int startCount = countLetter();
    openDeleteForm();
    int deleteCount = countLetter();
    createSend("test_level_up@mail.ru", myTheme, myBody, true);

    openInnerLetter();
    Verify.verify(countLetter()>startCount, "Письмо не добавлено в папку");
    Verify.verify(checkEmailAttribute(myTheme,"test_level_up@mail.ru"), "Email не найден");
    Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
    Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

    openAndDeleteLetter(myTheme);
    Verify.verify(countLetter()>deleteCount, "Письмо не добавлено в папку");
    Verify.verify(checkEmailAttribute(myTheme,"test_level_up@mail.ru"), "Email не найден");
    Verify.verify(checkTextAttribute(myTheme), "Тема письма не найдена");
    Verify.verify(checkTextAttribute(myBody), "Текст письма не найден");

    logout();
  }
}
