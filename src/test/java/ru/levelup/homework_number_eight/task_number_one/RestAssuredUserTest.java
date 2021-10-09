package ru.levelup.homework_number_eight.task_number_one;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.homework_number_eight.RestApi;
import ru.levelup.homework_number_six.task_number_one.registration.PropertyData;
import ru.levelup.honework_eight.model.CreateUserRequest;
import ru.levelup.honework_eight.model.PatchUserRequest;
import ru.levelup.honework_eight.model.UserData;

public class RestAssuredUserTest extends RestApi {
  private static final Faker FAKER = new Faker();
  PropertyData testData = new PropertyData();

  String name = FAKER.name().name();
  String email = FAKER.internet().emailAddress();
  Long id;

  @DataProvider
  public Object[][] createUserDataProvider() {
    return new Object[][] {
        {new CreateUserRequest(name, email,testData.getData("user.gender"),testData.getData("user.active"))},
    };
  }

  @DataProvider
  public Object[][] patchUserDataProvider() {
    name = FAKER.name().lastName();
    return new Object[][] {
        {new PatchUserRequest(name)},
    };
  }


  @Test(dataProvider = "createUserDataProvider", priority = 1)
  public void createUserTest(CreateUserRequest createUserRequest) {
    UserData users  = RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .contentType(ContentType.JSON)
        .body(createUserRequest)
        .when()
        .post(testData.getData("user"))
        .then()
        .log().all()
        .statusCode(201)
        .body("data.name", Matchers.equalTo(name))
        .body("data.email", Matchers.equalTo(email))
        .body("data.gender", Matchers.equalTo(testData.getData("user.gender")))
        .body("data.status", Matchers.equalTo(testData.getData("user.active")))
        .extract().response().as(UserData.class);
    Assert.assertTrue(users.getId().toString().matches("\\d+"));
    id = users.getId();
  }

  @Test(priority = 2)
  @Description("Зависимый тест от создания записи")
  public void getUserTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("user")+id)
        .then()
        .statusCode(200)
        .body("data.name", Matchers.equalTo(name))
        .body("data.email", Matchers.equalTo(email))
        .body("data.gender", Matchers.equalTo(testData.getData("user.gender")))
        .body("data.status", Matchers.equalTo(testData.getData("user.active")));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getUsersIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("user"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.name", Matchers.not(Matchers.emptyString()))
        .body("data.email", Matchers.not(Matchers.emptyString()))
        .body("data.gender", Matchers.not(Matchers.emptyString()))
        .body("data.status", Matchers.not(Matchers.emptyString()));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getUsersPageIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("user")+testData.getData("page"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.name", Matchers.not(Matchers.emptyString()))
        .body("data.email", Matchers.not(Matchers.emptyString()))
        .body("data.gender", Matchers.not(Matchers.emptyString()))
        .body("data.status", Matchers.not(Matchers.emptyString()));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getUserIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("user")+testData.getData("user.name"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.name", Matchers.not(Matchers.emptyString()))
        .body("data.email", Matchers.not(Matchers.emptyString()))
        .body("data.gender", Matchers.not(Matchers.emptyString()))
        .body("data.status", Matchers.not(Matchers.emptyString()));
  }

  @Test(dataProvider = "patchUserDataProvider", priority = 3)
  @Description("Зависимый тест от создания записи")
  public void patchUserTest(PatchUserRequest patchUserRequest) {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .contentType(ContentType.JSON)
        .when()
        .body(patchUserRequest)
        .log().body()
        .patch(testData.getData("user")+id)
        .then()
        .statusCode(200)
        .log().body()
        .body("data.name", Matchers.equalTo(name))
        .body("data.email", Matchers.equalTo(email))
        .body("data.gender", Matchers.equalTo(testData.getData("user.gender")))
        .body("data.status", Matchers.equalTo(testData.getData("user.active")));
  }

  @Test(priority = 4)
  @Description("Зависимый тест от создания записи")
  public void deleteUsersTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .delete(testData.getData("user")+id)
        .then()
        .statusCode(204);
  }
}
