import java.util.ArrayList;
import java.util.List;

public class User {
  private String username;
  private List<Post> posts;

  public User(String username) {
    this.username = username;
    this.posts = new ArrayList<Post>();
  }

  public String getUsername() {
    return username;
  }

  public Post addPost(String content) {
    Post post = new MessagePost(this, content);
    posts.add(post);
    System.out.println(username + " posted a message: " + content);
    return post;
  }

  public Post addPost(String filename, String caption) {
    Post post = new PhotoPost(this, filename, caption);
    posts.add(post);
    System.out.println(username + " posted a photo (" + filename + ") with caption: " + caption);
    return post;
  }

  public void likePost(Post post) {
    post.addLike(this);
  }

  public void unlikePost(Post post) {
    post.removeLike(this);
  }

  public void addComment(Post post, String comment) {
    post.addComment(this, comment);
  }

  public List<Post> getPosts() {
    return posts;
  }
}