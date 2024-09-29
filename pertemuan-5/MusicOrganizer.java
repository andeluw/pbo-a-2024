import java.util.ArrayList;

public class MusicOrganizer {
  private ArrayList<Song> songs;
  public MusicPlayer player;
  public SongImporter importer;

  public MusicOrganizer() {
    songs = new ArrayList<Song>();
    player = new MusicPlayer();
    importer = new SongImporter();
  }

  public void addSong(String filename, String title, String artist) {
    Song addedSong = new Song(filename, title, artist);
    songs.add(addedSong);
    System.out.println("");
    System.out.print("Song added: ");
    addedSong.printDetails();
  }

  public int getNumberOfSongs() {
    return songs.size();
  }

  public boolean checkIndex(int index) {
    if (index >= 0 && index < songs.size()) {
      return true;
    } else {
      System.out.println("Index out of bounds, please choose between 0 - " + (songs.size() - 1));
      return false;
    }
  }

  public int getIndex(String filename) {
    for (int pos = 0; pos < songs.size(); pos++) {
      if (songs.get(pos).getFilename().equals(filename)) {
        return pos;
      }
    }
    return -1;
  }

  public void getSongAtIndex(int index) {
    if (checkIndex(index)) {
      Song song = songs.get(index);
      song.printDetails();
    }
  }

  public void listAllSongs() {
    if (getNumberOfSongs() > 0) {
      System.out.println("List of songs:");
      for (int pos = 0; pos < songs.size(); pos++) {
        Song song = songs.get(pos);
        System.out.print((pos + 1) + ". ");
        song.printSongArtist();
      }
    } else {
      System.out.println("No songs in the list.");
    }
  }

  public void removeSongAtIndex(int index) {
    if (checkIndex(index)) {
      String fileToRemove = songs.get(index).getFilename();
      songs.remove(index);
      System.out.println("Song at index " + index + " (" + fileToRemove + ") removed from the list.");
    }
  }

  public void removeSongFromFilename(String filename) {
    int index = getIndex(filename);
    if (index != -1) {
      songs.remove(index);
      System.out.println(filename + " removed from the list.");
    } else {
      System.out.println(filename + " is not found in the list.");
    }
  }

  public void searchFileContainingKeyword(String keyword) {
    int count = 0;
    System.out.println("List of files containing \"" + keyword + "\":");
    for (int pos = 0; pos < songs.size(); pos++) {
      keyword = keyword.toLowerCase();
      String checkKeyword = songs.get(pos).getFilename().toLowerCase();
      if (checkKeyword.contains(keyword)) {
        count++;
        System.out.print(count + ". ");
        songs.get(pos).printDetails();
      }
    }
    if (count == 0) {
      System.out.println("No files containing \"" + keyword + "\" found.");
    }
  }

  public void searchTitleContainingKeyword(String keyword) {
    int count = 0;
    System.out.println("List of songs containing \"" + keyword + "\":");
    for (int pos = 0; pos < songs.size(); pos++) {
      keyword = keyword.toLowerCase();
      String checkKeyword = songs.get(pos).getTitle().toLowerCase();
      if (checkKeyword.contains(keyword)) {
        count++;
        System.out.print(count + ". ");
        songs.get(pos).printSongArtist();
      }
    }
    if (count == 0) {
      System.out.println("No songs containing \"" + keyword + "\" found.");
    }
  }

  public void listAllSongsByArtist(String artist) {
    int count = 0;
    System.out.println("List of songs by \"" + artist + "\":");
    for (int pos = 0; pos < songs.size(); pos++) {
      String checkArtist = songs.get(pos).getArtist();
      checkArtist = checkArtist.toLowerCase();
      artist = artist.toLowerCase();
      if (checkArtist.equals(artist)) {
        count++;
        System.out.print(count + ". ");
        songs.get(pos).printSongArtist();
      }
    }

    if (count == 0) {
      System.out.println("No songs by \"" + artist + "\" found.");
    }
  }

  public void startPlayingByFilename(String filename) {
    int count = 0;
    for (int pos = 0; pos < songs.size(); pos++) {
      if (songs.get(pos).getFilename().equals(filename)) {
        count++;
        Song songToPlay = songs.get(pos);
        player.setCurrentSong(songToPlay);
        player.startPlayingTrack();
      }
    }
    if (count == 0) {
      System.out.println("No songs with filename \"" + filename + "\" found.");
    }
  }

  public void startPlayingByTitle(String title) {
    int count = 0;
    for (int pos = 0; pos < songs.size(); pos++) {
      if (songs.get(pos).getTitle().equals(title)) {
        count++;
        Song songToPlay = songs.get(pos);
        player.setCurrentSong(songToPlay);
        player.startPlayingTrack();
      }
    }

    if (count == 0) {
      System.out.println("No songs titled \"" + title + "\" found.");
    }
  }

  public void checkCurrentPlayingTrack() {
    String currentSong = player.getCurrentSongTitle();
    if (currentSong == null) {
      System.out.println("No song is currently selected.");
    } else {
      System.out.println("Currently playing: " + currentSong);
    }
  }

  public void stopPlaying() {
    player.stopPlayingTrack();
  }

  public void importSongsFromFolder(String folderPath) {
    ArrayList<Song> importedSongs = importer.importSongsFromFolder(folderPath);
    if (importedSongs != null) {
      System.out.println(importedSongs.size() + " songs imported.");
      for (int pos = 0; pos < importedSongs.size(); pos++) {
        Song song = importedSongs.get(pos);
        songs.add(song);
        System.out.print((pos + 1) + ". ");
        song.printDetails();
      }
    } else {
      System.out.println("No songs imported.");
    }
  }
}
