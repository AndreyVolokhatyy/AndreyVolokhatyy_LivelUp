package ru.levelup.homework_number_eight.task_number_two;

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
import ru.levelup.honework_eight.model.CreatePostRequest;
import ru.levelup.honework_eight.model.PatchPostRequest;
import ru.levelup.honework_eight.model.PostData;

public class RestAssuredPostsTest extends RestApi {
  private static final Faker FAKER = new Faker();
  PropertyData testData = new PropertyData();
  String title = FAKER.book().title();
  String body = FAKER.harryPotter().book();
  Long id;

  @DataProvider
  public Object[][] createPostDataProvider() {
    return new Object[][] {
        {new CreatePostRequest(testData.getData("post.id"), title, body)},
    };
  }

  @DataProvider
  public Object[][] patchPostDataProvider() {
    title = FAKER.book().title();
    return new Object[][] {
        {new PatchPostRequest(title)},
    };
  }


  @Test(dataProvider = "createPostDataProvider", priority = 1)
  public void createPostTest(CreatePostRequest createPostRequest) {
    PostData post  = RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .contentType(ContentType.JSON)
        .body(createPostRequest)
        .log().body()
        .when()
        .post(testData.getData("post"))
        .then()
        .log().body()
        .statusCode(201)
        .body("data.title", Matchers.equalTo(title))
        .body("data.body", Matchers.equalTo(body))
        .extract().response().as(PostData.class);
    Assert.assertTrue(post.getId().toString().matches("\\d+"));
    id = post.getId();
  }

  @Test(priority = 2)
  @Description("Зависимый тест от создания записи")
  public void getPostTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("post")+id)
        .then()
        .statusCode(200)
        .body("data.title", Matchers.equalTo(title))
        .body("data.body", Matchers.equalTo(body));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getPostsIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("post"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.title", Matchers.not(Matchers.emptyString()))
        .body("data.body", Matchers.not(Matchers.emptyString()));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getPostsPageIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("post")+ testData.getData("page"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.title", Matchers.not(Matchers.emptyString()))
        .body("data.body", Matchers.not(Matchers.emptyString()));
  }

  @Test
  @Description("Независимый тест от создания записи")
  public void getPostIndependenceTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .get(testData.getData("post")+testData.getData("post.title"))
        .then()
        .statusCode(200)
        .log().all()
        .body("data.title", Matchers.not(Matchers.emptyString()))
        .body("data.body", Matchers.not(Matchers.emptyString()));
  }

  @Test(dataProvider = "patchPostDataProvider", priority = 3)
  @Description("Зависимый тест от создания записи")
  public void patchPostTest(PatchPostRequest patchPostRequest) {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .contentType(ContentType.JSON)
        .when()
        .body(patchPostRequest)
        .log().body()
        .patch(testData.getData("post")+id)
        .then()
        .statusCode(200)
        .log().body()
        .body("data.title", Matchers.equalTo(title))
        .body("data.body", Matchers.equalTo(body));
  }

  @Test(priority = 4)
  @Description("Зависимый тест от создания записи")
  public void deletePostTest() {
    RestAssured
        .given()
        .auth()
        .oauth2(testData.getData("token"), OAuthSignature.HEADER)
        .when()
        .delete(testData.getData("post")+id)
        .then()
        .statusCode(204);
  }
}
