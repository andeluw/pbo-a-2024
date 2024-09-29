public class MusicPlayer {
  private Song currentSong;

  public MusicPlayer() {
    currentSong = null;
  }

  public String getCurrentSongTitle() {
    if (currentSong != null)
      return currentSong.getTitle();
    else
      return null;
  }

  public void setCurrentSong(Song song) {
    currentSong = song;
  }

  public void startPlayingTrack() {
    if (currentSong != null) {
      System.out.println("Currently playing: " + currentSong.getTitle() + " by " + currentSong.getArtist());
    } else {
      System.out.println("No track is currently selected.");
    }
  }

  public void stopPlayingTrack() {
    currentSong = null;
    System.out.println("Music has been stopped.");
  }
}
