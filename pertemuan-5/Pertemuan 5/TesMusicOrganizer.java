import java.util.Scanner;

public class TesMusicOrganizer {
  public static void main(String args[]) {
    MusicOrganizer myMusic = new MusicOrganizer();
    System.out.println("");

    Scanner input = new Scanner(System.in);

    int choice = 0;
    do {
      System.out.println("Menu");
      System.out.println("----");
      System.out.println("1. Import songs from folder");
      System.out.println("2. Add a song");
      System.out.println("3. List all songs");
      System.out.println("4. Play a song by filename");
      System.out.println("5. Play a song by title");
      System.out.println("6. Stop playing");
      System.out.println("7. Get current song title");
      System.out.println("8. Get song at index");
      System.out.println("9. Remove song at index");
      System.out.println("10. Remove song by filename");
      System.out.println("11. Get index of song by filename");
      System.out.println("12. Search file containing keyword");
      System.out.println("13. Search song containing keyword");
      System.out.println("14. List all songs by artist");
      System.out.println("15. Exit");
      System.out.println("");
      System.out.print("Enter your choice: ");
      choice = input.nextInt();
      input.nextLine();
      System.out.println("");

      switch (choice) {
        case 1:
          System.out.print("Enter folder name: ");
          String folderName = input.nextLine();
          myMusic.importSongsFromFolder(folderName);
          break;
        case 2:
          System.out.println(
              "Please rename your file to [Artist-Title.mp3] or [Artist-Title.wav] to get the correct artist and title. For example, LANY-Cause_You_Have_To.mp3");
          System.out.print("Enter filename: ");

          String filename, title, artist;
          filename = input.nextLine();

          String extractedString[];
          if (filename.contains(".mp3")) {
            extractedString = filename.replace(".mp3", "").split("-");
          } else {
            extractedString = filename.replace(".wav", "").split("-");
          }

          artist = extractedString[0].trim();
          title = extractedString[1].trim();
          title = title.replace("_", " ");

          myMusic.addSong(filename, title, artist);
          break;
        case 3:
          myMusic.listAllSongs();
          break;
        case 4:
          System.out.print("Enter filename: ");
          filename = input.nextLine();
          myMusic.startPlayingByFilename(filename);
          break;
        case 5:
          System.out.print("Enter title: ");
          title = input.nextLine();
          myMusic.startPlayingByTitle(title);
          break;
        case 6:
          myMusic.stopPlaying();
          break;
        case 7:
          myMusic.checkCurrentPlayingTrack();
          break;
        case 8:
          System.out.print("Enter index (zero-indexed): ");
          int index = input.nextInt();
          myMusic.getSongAtIndex(index);
          break;
        case 9:
          System.out.print("Enter index (zero-indexed): ");
          index = input.nextInt();
          myMusic.removeSongAtIndex(index);
          break;
        case 10:
          System.out.print("Enter filename: ");

          filename = input.nextLine();
          myMusic.removeSongFromFilename(filename);
          break;
        case 11:
          System.out.print("Enter filename: ");

          filename = input.nextLine();
          index = myMusic.getIndex(filename);
          if (index != -1) {
            System.out.println("Index of " + filename + " is " + index);
          } else {
            System.out.println("Song not found.");
          }
          break;
        case 12:
          System.out.print("Enter keyword: ");
          String keyword = input.nextLine();
          myMusic.searchFileContainingKeyword(keyword);
          break;
        case 13:
          System.out.print("Enter keyword: ");
          keyword = input.nextLine();
          myMusic.searchTitleContainingKeyword(keyword);
          break;
        case 14:
          System.out.print("Enter artist: ");
          artist = input.nextLine();
          myMusic.listAllSongsByArtist(artist);
          break;
        case 15:
          input.close();
          System.out.println("Exited successfully!");
          break;
        default:
          System.out.println("Invalid choice.");
          break;
      }
      System.out.println("");
    } while (choice != 15);
  }
}
