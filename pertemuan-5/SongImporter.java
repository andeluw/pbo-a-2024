import java.io.File;
import java.util.ArrayList;

public class SongImporter {
  private ArrayList<Song> importedSongs;

  public SongImporter() {
    importedSongs = new ArrayList<Song>();
  }

  public ArrayList<Song> importSongsFromFolder(String folderPath) {
    File folder = new File(folderPath);

    if (folder.exists() && folder.isDirectory()) {
      File[] files = folder
          .listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav"));

      if (files != null) {
        for (File file : files) {
          String filename = file.getName();
          String title, artist;
          String extractedString[];
          if (filename.contains(".mp3")) {
            extractedString = filename.replace(".mp3", "").split("-");
          } else {
            extractedString = filename.replace(".wav", "").split("-");
          }

          artist = extractedString[0].trim();
          title = extractedString[1].trim();
          title = title.replace("_", " ");
          Song addedSong = new Song(filename, title, artist);
          importedSongs.add(addedSong);
        }
      }
      return importedSongs;
    } else {
      System.out.println("Folder does not exist or is not a directory.");
      return null;
    }
  }
}
