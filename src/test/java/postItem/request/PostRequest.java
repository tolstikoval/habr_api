package postItem.request;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import postItem.methods.PostMethods;
import postItem.response.PostResponse;

import static io.restassured.RestAssured.*;

public class PostRequest {
  String body;
  long userId;
  String title;

  public String getBody() {
    return body;
  }

  public PostRequest setBody(String body) {
    this.body = body;
    return this;
  }

  public long getUserId() {
    return userId;
  }

  public PostRequest setUserId(long userId) {
    this.userId = userId;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public PostRequest setTitle(String title) {
    this.title = title;
    return this;
  }

  public PostRequest buildPostRequest() {
    PostRequest postRequest = new PostRequest();
    postRequest
            .setTitle("title for test " + generateTitle(6))
            .setBody("foo")
            .setUserId(1l);
    return postRequest;
  }

  private String generateTitle(int n) {
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
    StringBuilder sb = new StringBuilder(n);

    for (int i = 0; i < n; i++) {
      int index = (int) (AlphaNumericString.length() * Math.random());
      sb.append(AlphaNumericString.charAt(index));
    }
    return sb.toString();
  }


  public static void main(String[] args) {
 /* PostRequest postRequest = new PostRequest();
    postRequest = postRequest.buildPostRequest();
    System.out.println(postRequest.title);
    System.out.println(postRequest.body);
    System.out.println(postRequest.userId);*/
   PostMethods postMethods = new PostMethods();
  // postMethods.deleteRaw();
//   PostRequest postRequest, postRequest1;
//     postRequest = new PostRequest().buildPostRequest();
//    postRequest1 = new PostRequest().setTitle("123").setBody("123432").setUserId(12l);
//      postMethods.putById(postRequest1, 3);
//    postMethods.post(postRequest);
//    postMethods.post(postRequest1);
//    PostResponse postResponse;
  //   postMethods.deleteById(7);
//    postResponse = postMethods.getById(1);
    String p;
p =postMethods.getObject(4);
   /* System.out.println(p.getId());
    System.out.println(p.getTitle());
    System.out.println(p.getUserId());
    System.out.println(p.getBody());*/

  // postMethods.getAll();
   /*    postMethods.post();
    postMethods.putById();
    postMethods.delete();*/
  }
}
