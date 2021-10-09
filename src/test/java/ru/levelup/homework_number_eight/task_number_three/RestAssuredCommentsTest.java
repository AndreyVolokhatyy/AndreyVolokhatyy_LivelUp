package ru.levelup.homework_number_eight.task_number_three;

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
import ru.levelup.honework_eight.model.CommentsData;
import ru.levelup.honework_eight.model.CreateCommentsRequest;
import ru.levelup.honework_eight.model.PatchCommentsRequest;

public class RestAssuredCommentsTest extends RestApi {
  private static final Faker FAKER = new Faker();
  PropertyData testData = new PropertyData();

  String name = FAKER.name().title();
  String email = FAKER.internet().emailAddress();
  String body = FAKER.dune().saying();
  Long id;

  @DataProvider
  public Object[][] createCommentDataProvider() {
    return new Object[][] {
        {new CreateCommentsRequest(testData.getData("comments.id"), name, email, body)},
    };
  }

  @DataProvider
  public Object[][] patchCommentDataProvider() {
    name = FAKER.book().title();
    return new Object[][] {
        {new PatchCommentsRequest(name)},
    };
  }

  @Test(dataProvider = "createCommentDataProvider", priority = 1)
  public void createCommentTest(CreateCommentsRequest createCommentsRequest) {
    CommentsData comments  = RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .contentType(ContentType.JSON)
        .body(createCommentsRequest)
        .log().body()
        .when()
        .post(testData.getData("comments"))
        .then()
        .log().body()
        .statusCode(201)
        .body("data.name", Matchers.equalTo(name))
        .body("data.email", Matchers.equalTo(email))
        .body("data.body", Matchers.equalTo(body))
        .extract().response().as(CommentsData.class);
    Assert.assertTrue(comments.getId().toString().matches("\\d+"));
    id = comments.getId();
  }

  @Test(priority = 2)
  @Description("Зависимый тест от создания записи")
  public void getCommentTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("comments")+id)
        .then()
        .statusCode(200)
        .body("data.name", Matchers.equalTo(name))
        .body("data.email", Matchers.equalTo(email))
        .body("data.body", Matchers.equalTo(body));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getCommentsIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("comments"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.name", Matchers.not(Matchers.emptyString()))
        .body("data.email", Matchers.not(Matchers.emptyString()))
        .body("data.body", Matchers.not(Matchers.emptyString()));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getCommentsPageIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("comments")+testData.getData("page"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.name", Matchers.not(Matchers.emptyString()))
        .body("data.body", Matchers.not(Matchers.emptyString()));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getCommentIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("comments")+testData.getData("comments.name"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.name", Matchers.not(Matchers.emptyString()))
        .body("data.body", Matchers.not(Matchers.emptyString()));
  }

  @Test(dataProvider = "patchCommentDataProvider", priority = 3)
  @Description("Зависимый тест от создания записи")
  public void patchCommentTest(PatchCommentsRequest patchCommentsRequest) {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .contentType(ContentType.JSON)
        .log().all()
        .when()
        .body(patchCommentsRequest)
        .log().body()
        .patch(testData.getData("comments")+id)
        .then()
        .statusCode(200)
        .log().body()
        .body("data.name", Matchers.equalTo(name))
        .body("data.body", Matchers.equalTo(body));
  }

  @Test(priority = 4)
  @Description("Зависимый тест от создания записи")
  public void deleteCommentTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .delete(testData.getData("comments")+id)
        .then()
        .statusCode(204);
  }
}
