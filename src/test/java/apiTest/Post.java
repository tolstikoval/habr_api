package apiTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import postItem.response.PostResponse;

import static org.hamcrest.core.IsEqual.equalTo;

public class Post extends TestBase {

  @Test(description = "Проверка метода PostRaw из класса PostMethods: код ответа, соответствие полей")
  public void postRawTest() {
    Response response = postMethods.postRaw(postRequest1);
    response.then().log().all().statusCode(201)
            .body("userId", equalTo(12),
                    "title", equalTo("123"),
                    "body", equalTo("123432"));
    postResponse = response.then().extract().as(PostResponse.class);
  }

}

