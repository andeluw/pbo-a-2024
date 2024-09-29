public class Song {
  private String filename;
  private String title;
  private String artist;

  public Song(String filename, String title, String artist) {
    this.filename = filename;
    this.title = title;
    this.artist = artist;
  }

  public String getFilename() {
    return filename;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public void printDetails() {
    System.out.println(filename + " - " + title + " by " + artist);
  }

  public void printSongArtist() {
    System.out.println(title + " by " + artist);
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setTitle(String newTitle) {
    title = newTitle;
  }

  public void setArtist(String newArtist) {
    artist = newArtist;
  }
}
