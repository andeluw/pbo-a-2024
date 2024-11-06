package salesitem;

public class Comment {
  private String author;
  private String text;
  private int rating;
  public int vote;

  public Comment(String author, String text, int rating) {
    this.author = author;
    this.text = text;
    this.rating = rating;
    vote = 0;
  }

  public String getAuthor() {
    return author;
  }

  public String getText() {
    return text;
  }

  public int getRating() {
    return rating;
  }

  public void upvote() {
    vote++;
  }

  public void downvote() {
    vote--;
  }

  public String getFullDetails() {
    return author + " (" + rating + "): " + text;
  }

  public int getVoteCount() {
    return vote;
  }
}
