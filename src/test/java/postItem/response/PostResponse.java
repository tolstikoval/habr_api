package postItem.response;

public class PostResponse {
  public String title;
  public String body;
  public long userId;
  public long id;

  public String getBody() {
    return body;
  }

  public long getUserId() {
    return userId;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
}
