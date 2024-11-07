public class PhotoPost extends Post {
  private String filename;
  private String caption;

  public PhotoPost(User author, String filename, String caption) {
    super(author);
    this.filename = filename;
    this.caption = caption;
  }

  public String getFilename() {
    return filename;
  }

  public String getCaption() {
    return caption;
  }

  @Override
  public void display() {
    System.out.println(getAuthor().getUsername() + " posted a photo (" + filename + ") with caption: " + caption);
    System.out.println("Likes: " + getLikesCount());
    System.out.println("Comments: ");
    for (String comment : getComments()) {
      System.out.println(comment);
    }
  }

  @Override
  public void printLike(String username) {
    System.out.println(username + " liked a photo: " + getFilename() + " - " + getCaption());
  }

  @Override
  public void printUnlike(String username) {
    System.out.println(username + " unliked a photo: " + getFilename() + " - " + getCaption());
  }

  @Override
  public void printComment(String username, String author, String comment) {
    System.out.println(username + " commented on a photo by " + author + ": " + comment);
  }
}
