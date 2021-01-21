package ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import postItem.methods.PostMethods;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PostTests {
  @Test
  public void getByIdRawTest() {
    PostMethods postMethods = new PostMethods();
    postMethods.getByIdRaw(2);

    assertThat(postMethods.getByIdRaw(2).statusCode(), is(equalTo(200)));
  }

}
