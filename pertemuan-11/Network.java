import java.util.ArrayList;
import java.util.List;

public class Network {
  private List<User> users;
  private List<Post> posts;

  public Network() {
    this.users = new ArrayList<User>();
    this.posts = new ArrayList<Post>();
  }

  public User addUser(String username) {
    User user = new User(username);
    users.add(user);
    System.out.println("User " + username + " has been added to the network.");
    return user;
  }

  public void addPost(User user, String content) {
    Post post = user.addPost(content);
    posts.add(post);
  }

  public void addPost(User user, String filename, String content) {
    Post post = user.addPost(filename, content);
    posts.add(post);
  }

  public void showAllPosts() {
    System.out.println("\n--- All posts ---");
    for (Post post : posts) {
      post.display();
      System.out.println();
    }
  }

  public void showAllUsers() {
    System.out.println("\n--- All users ---");
    for (User user : users) {
      System.out.println(user.getUsername());
    }
  }

  public static void main(String[] args) {
    Network network = new Network();

    User adi = network.addUser("Adi");
    User budi = network.addUser("Budi");

    network.addPost(adi, "Hello this is Adi again!");
    network.addPost(budi, "Hello this is Budi!");

    network.addPost(budi, "cat.jpg", "My cat is so cute!");
    network.addPost(adi, "dog.jpg", "My dog is so cute!");

    adi.likePost(budi.getPosts().get(0));
    budi.likePost(adi.getPosts().get(1));

    adi.addComment(budi.getPosts().get(0), "Hi Budi!");
    budi.addComment(adi.getPosts().get(1), "Nice dog!");

    network.showAllUsers();

    network.showAllPosts();

    System.out.println();
    adi.unlikePost(budi.getPosts().get(0));
    System.out.println("Budi's first post has " + budi.getPosts().get(0).getLikesCount() + " likes.");

  }
}
