package ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postItem.methods.PostMethods;
import postItem.request.PostRequest;
import postItem.response.PostResponse;

import static org.hamcrest.core.IsEqual.equalTo;


public class PostTests {
  PostMethods postMethods = new PostMethods();
  PostResponse postResponse;
  PostRequest postRequest1;

  @BeforeClass
  public void testData() {
    postRequest1 = new PostRequest().setTitle("123").setBody("123432").setUserId(12l);
  }


  @Test(description = "Проверка метода PostRaw из класса PostMethods: код ответа, соответствие полей")
  public void postRawTest() {
    Response response = postMethods.postRaw(postRequest1);
    response.then().log().all().statusCode(201)
            .body("userId", equalTo(12),
                    "title", equalTo("123"),
                    "body", equalTo("123432"));
    postResponse = response.then().extract().as(PostResponse.class);
  }


  @AfterClass
  public void AfterTests() {
    postMethods.deleteById(postResponse.id);
  }


}

