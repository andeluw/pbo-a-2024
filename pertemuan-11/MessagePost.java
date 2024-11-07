public class MessagePost extends Post {
  private String message;

  public MessagePost(User author, String message) {
    super(author);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public void display() {
    System.out.println(getAuthor().getUsername() + " posted a message: " + message);
    System.out.println("Likes: " + getLikesCount());
    System.out.println("Comments: ");
    for (String comment : getComments()) {
      System.out.println(comment);
    }
  }

  @Override
  public void printLike(String username) {
    System.out.println(username + " liked a message: " + getMessage());
  }

  @Override
  public void printUnlike(String username) {
    System.out.println(username + " unliked a message: " + getMessage());
  }

  @Override
  public void printComment(String username, String author, String comment) {
    System.out.println(username + " commented on a message by " + author + ": " + comment);
  }
}
