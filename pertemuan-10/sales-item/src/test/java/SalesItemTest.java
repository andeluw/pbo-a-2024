import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import salesitem.Comment;
import salesitem.SalesItem;

import static org.junit.jupiter.api.Assertions.*;

class SalesItemTest {

  private SalesItem item;

  @BeforeEach
  void init() {
    item = new SalesItem("Laptop", 1000);
  }

  @Test
  public void testGetName() {
    assertEquals("Laptop", item.getName());
  }

  @Test
  public void testGetPrice() {
    assertEquals(1000, item.getPrice());
  }

  @Test
  public void testAddValidComment() {
    assertTrue(item.addComment("Adi", "Nice", 5));
    assertEquals(1, item.getNumberOfComments());
  }

  @Test
  public void testAddCommentWithInvalidRating() {
    assertFalse(item.addComment("Budi", "Wow", 10));
    assertFalse(item.addComment("Budi", "Bad quality", -100));
    assertEquals(0, item.getNumberOfComments());
  }

  @Test
  public void testAddCommentWithExistingAuthor() {
    item.addComment("Adi", "Nice", 5);
    assertFalse(item.addComment("Adi", "Nice", 5));
    assertEquals(1, item.getNumberOfComments());
  }

  @Test
  public void testRemoveComment() {
    item.addComment("Adi", "Nice", 5);
    item.addComment("Budi", "Wow", 4);
    item.removeComment(0);
    assertEquals(1, item.getNumberOfComments());
  }

  @Test
  public void testUpvoteComment() {
    item.addComment("Adi", "Nice", 5);
    item.upvoteComment(0);
    item.upvoteComment(0);
    assertEquals(2, item.getVoteCountComments(0));
  }

  @Test
  public void testDownvoteComment() {
    item.addComment("Adi", "Nice", 5);
    item.downvoteComment(0);
    item.downvoteComment(0);
    assertEquals(-2, item.getVoteCountComments(0));
  }

  public void testFindMostHelpfulComment() {
    item.addComment("Adi", "Nice", 5);
    item.addComment("Budi", "Wow", 4);
    item.upvoteComment(0);
    item.upvoteComment(0);
    item.upvoteComment(1);
    assertEquals("Adi (5): Nice", item.findMostHelpfulComment().getFullDetails());
  }

  @Test
  public void testFindMostHelpfulCommentWithNoUpvote() {
    item.addComment("Adi", "Nice", 5);
    item.addComment("Budi", "Wow", 4);
    String expected1 = "Adi (5): Nice";
    String expected2 = "Budi (4): Wow";

    assertTrue(
        item.findMostHelpfulComment().getFullDetails().equals(expected1) ||
            item.findMostHelpfulComment().getFullDetails().equals(expected2));
  }

  @Test
  public void testFindMostHelpfulCommentWithMultipleCommentsWithEqualUpvote() {
    item.addComment("Adi", "Nice", 5);
    item.addComment("Budi", "Wow", 4);
    item.upvoteComment(0);
    item.upvoteComment(1);
    String expected1 = "Adi (5): Nice";
    String expected2 = "Budi (4): Wow";

    assertTrue(
        item.findMostHelpfulComment().getFullDetails().equals(expected1) ||
            item.findMostHelpfulComment().getFullDetails().equals(expected2));
  }
}
