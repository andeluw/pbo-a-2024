import java.util.HashSet;

public class SupportSystem {
  private InputReader reader;
  private Responder responder;

  public SupportSystem() {
    reader = new InputReader();
    responder = new Responder();
  }

  public void welcomeMessage() {
    System.out.println("Selamat datang di Support System EatsExpress!");
    System.out.println("Kami di sini untuk membantu Anda dengan setiap langkah pengalaman delivery makanan Anda.");
    System.out.println(
        "Silakan ceritakan masalah atau pertanyaan Anda, dan kami siap memberikan solusi yang cepat dan efektif.");
    System.out
        .println("Untuk keluar dari sistem kami, cukup ketik 'bye'. Mari kita mulai perjalanan kuliner Anda bersama!");
  }

  public void endMessage() {
    System.out.println("Terima kasih telah menggunakan Support System EatsExpress kami!");
    System.out.println("Kami berharap pengalaman Anda bersama kami menyenangkan.");
    System.out.println("Jangan ragu untuk kembali jika Anda memiliki pertanyaan atau butuh bantuan di masa mendatang.");
    System.out.println("Sampai jumpa dan selamat menikmati makanan Anda!");
  }

  public void start() {
    boolean end = false;
    welcomeMessage();

    while (!end) {
      HashSet<String> input = reader.getInput();

      if (input.contains("bye")) {
        end = true;
      } else {
        String response = responder.generateResponse(input);
        System.out.println(response);
      }
    }

    endMessage();
  }
}