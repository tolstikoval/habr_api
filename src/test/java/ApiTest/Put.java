package ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postItem.methods.PostMethods;
import postItem.request.PostRequest;
import postItem.response.PostResponse;

import static org.hamcrest.core.IsEqual.equalTo;

public class Put {

  PostMethods postMethods = new PostMethods();
  PostResponse postResponse;
  PostRequest postRequest1;

  @BeforeClass
  public void testData() {
    postRequest1 = new PostRequest().setTitle("123").setBody("123432").setUserId(12l);
  }

  @Test(description = "Проверка метода PutByIdRaw из класса PostMethods: код ответа, соответствие полей")
  public void putByIdTest() {
    Response response = postMethods.putByIdRaw(postRequest1, 5);
    response.then().log().all().statusCode(200)
            .body("userId", equalTo(12),
                    "id", equalTo(5),
                    "title", equalTo("123"),
                    "body", equalTo("123432"));
    postResponse = response.then().extract().as(PostResponse.class);
  }

  @AfterClass
  public void AfterTests() {
    postMethods.deleteById(postResponse.id);
  }
}
