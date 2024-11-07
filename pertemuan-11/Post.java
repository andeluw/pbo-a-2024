import java.util.ArrayList;
import java.util.List;

abstract class Post {
  private User author;
  private String content;
  private List<User> likes;
  private List<String> comments;

  public Post(User author) {
    this.author = author;
    this.likes = new ArrayList<>();
    this.comments = new ArrayList<>();
  }

  public String getContent() {
    return content;
  }

  public User getAuthor() {
    return author;
  }

  public List<User> getLikes() {
    return likes;
  }

  public abstract void printLike(String username);

  public void addLike(User user) {
    if (!likes.contains(user)) {
      likes.add(user);
      printLike(user.getUsername());
    }
  }

  public abstract void printUnlike(String username);

  public void removeLike(User user) {
    if (likes.contains(user)) {
      likes.remove(user);
      printUnlike(user.getUsername());
    }
  }

  public int getLikesCount() {
    return likes.size();
  }

  public List<String> getComments() {
    return comments;
  }

  public abstract void printComment(String username, String author, String comment);

  public void addComment(User user, String comment) {
    comments.add(user.getUsername() + ": " + comment);
    printComment(user.getUsername(), author.getUsername(), comment);
  }

  public abstract void display();
}
