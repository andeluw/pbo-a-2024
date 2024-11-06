package salesitem;

import java.util.ArrayList;
import java.util.Iterator;

public class SalesItem {
  private String name;
  private int price; // in cents
  private ArrayList<Comment> comments;

  public SalesItem(String name, int price) {
    this.name = name;
    this.price = price;
    comments = new ArrayList<Comment>();
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public int getNumberOfComments() {
    return comments.size();
  }

  public boolean addComment(String author, String text, int rating) {

    // check if rating is valid (1 to 5). If not, reject the new comment.
    if (ratingInvalid(rating)) {
      return false;
    }

    // Check if the author has already commented. If so, reject the new comment.
    if (findCommentByAuthor(author) != null) {
      return false;
    }
    comments.add(new Comment(author, text, rating));
    return true;
  }

  public void removeComment(int index) {
    if (index >= 0 && index < comments.size()) { // index is valid
      comments.remove(index);
    }
  }

  public void upvoteComment(int index) {
    if (index >= 0 && index < comments.size()) { // index is valid
      comments.get(index).upvote();
    }
  }

  public void downvoteComment(int index) {
    if (index >= 0 && index < comments.size()) { // index is valid
      comments.get(index).downvote();
    }
  }

  public int getVoteCountComments(int index) {
    if (index >= 0 && index < comments.size()) { // index is valid
      return comments.get(index).getVoteCount();
    }
    return 0;
  }

  public void showInfo() {
    System.out.println("*** " + name + " ***");
    System.out.println("Price: " + priceString(price));
    System.out.println();
    System.out.println("Customer comments:");
    for (Comment comment : comments) {
      System.out.println("-----------------------------------");
      System.out.println(comment.getFullDetails());
    }
    System.out.println();
    System.out.println("=====================================");
  }

  /*
   * The most useful comment is the one with the highest vote balance. If there
   * are multiple comments with equal highest balance, return any one of them.
   */
  public Comment findMostHelpfulComment() {
    Iterator<Comment> it = comments.iterator();
    Comment best = it.next();
    while (it.hasNext()) {
      Comment current = it.next();
      if (current.getVoteCount() > best.getVoteCount()) {
        best = current;
      }
    }
    return best;
  }

  private boolean ratingInvalid(int rating) {
    return rating < 0 || rating > 5;
  }

  private Comment findCommentByAuthor(String author) {
    for (Comment comment : comments) {
      if (comment.getAuthor().equals(author)) {
        return comment;
      }
    }
    return null;
  }

  private String priceString(int price) {
    int dollars = price / 100;
    int cents = price - (dollars * 100);
    if (cents <= 9) {
      return "$" + dollars + ".0" + cents;
    } else {
      return "$" + dollars + "." + cents;
    }
  }
}