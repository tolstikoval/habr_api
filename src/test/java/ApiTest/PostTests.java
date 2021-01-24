package ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postItem.methods.PostMethods;
import postItem.request.PostRequest;
import postItem.response.PostResponse;

import java.util.Arrays;
import java.util.OptionalInt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class PostTests {
  PostMethods postMethods = new PostMethods();
  PostResponse postResponse;

  @BeforeClass
  public void testData() {

  }

  @Test(description = "Проверка метода getAllRaw из класса PostMethods: код ответа, количество записей, ссответствие id")
  public void getAllTest() {

    Response response = postMethods.getAllRaw();
    response.then().log().all().statusCode(200)
            .body("[3].id", equalTo(4),
                    "[3].userId", equalTo(1),
                    "[3].title", equalTo("eum et est occaecati"),
                    "[3].body", equalTo("ullam et saepe reiciendis voluptatem adipisci\n" +
                            "sit amet autem assumenda provident rerum culpa\n" +
                            "quis hic commodi nesciunt rem tenetur doloremque ipsam iure\n" +
                            "quis sunt voluptatem rerum illo velit"),
                    "size()", equalTo(100));

   // PostResponse[] listPost = postMethods.getObject(4);

    //  Map<String, ?> map = get(EndPoints.anyendpoint).path("rootelement.find { it.title =~ 'anythingRegExp'}");
//listPost.length
    //postResponse = response.then().extract().as(PostResponse.class);
  }

  @Test(description = "Проверка метода getByIdRaw из класса PostMethods: код ответа, соответствие полей")
  public void getByIdRawTest() {

    Response response1 = postMethods.getByIdRaw(10);
    response1.then().log().all().statusCode(200)
            .body("userId", equalTo(1),
                    "id", equalTo(10),
                    "title", equalTo("optio molestias id quia eum"),
                    "body", equalTo("quo et expedita modi cum officia vel magni\ndoloribus qui "
                            + "repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"));

    postResponse = response1.then().extract().as(PostResponse.class);
  }

  @AfterTest
  public void getByIdRawAfterTest() {
    postMethods.deleteById(postResponse.id);
  }

  @Test(description = "Проверка метода PostRaw из класса PostMethods: код ответа, соответствие полей")
  public void postRawTest() {
    PostRequest postRequest1;
    postRequest1 = new PostRequest().setTitle("123").setBody("123432").setUserId(12l);
    Response response = postMethods.postRaw(postRequest1);
    response.then().log().all().statusCode(201)
            .body("userId", equalTo(12),
                    "title", equalTo("123"),
                    "body", equalTo("123432"));
    postResponse = response.then().extract().as(PostResponse.class);
  }

  @AfterTest
  public void postAfterTest() {
    postMethods.deleteById(postResponse.id);
  }

  @Test(description = "Проверка метода PutByIdRaw из класса PostMethods: код ответа, соответствие полей")
  public void putByIdTest() {
    PostRequest postRequest1;
    postRequest1 = new PostRequest().setTitle("123").setBody("123432").setUserId(12l);
    Response response = postMethods.putByIdRaw(postRequest1, 5);
    response.then().log().all().statusCode(200)
            .body("userId", equalTo(12),
                    "id", equalTo(5),
                    "title", equalTo("123"),
                    "body", equalTo("123432"));
    postResponse = response.then().extract().as(PostResponse.class);
  }

  @AfterTest
  public void putByIdAfterTest() {
    postMethods.deleteById(postResponse.id);
  }

}

