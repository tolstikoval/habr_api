package apiTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import postItem.methods.PostMethods;
import postItem.request.PostRequest;
import postItem.response.PostResponse;

public class TestBase {

  PostMethods postMethods = new PostMethods();
  PostResponse postResponse;
  PostRequest postRequest1;

  @BeforeClass
  public void testData() {
    postRequest1 = new PostRequest().setTitle("123").setBody("123432").setUserId(12l);
  }

  @AfterClass
  public void afterTests() {
    postMethods.deleteById(postResponse.id);
  }
}
