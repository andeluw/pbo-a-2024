package supportsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class Responder {
  private HashMap<String, String> responseMap;
  private ArrayList<String> defaultResponses;
  private Random randomGenerator;
  private LevenshteinDistance levenshteinDistance;

  public Responder() {
    responseMap = new HashMap<>();
    defaultResponses = new ArrayList<>();
    fillResponseMap();
    fillDefaultResponses();
    randomGenerator = new Random();
    levenshteinDistance = new LevenshteinDistance();
  }

  private void fillResponseMap() {
    responseMap.put("bantuan", "Silakan ceritakan masalah Anda dengan detail.");
    responseMap.put("error", "Silakan restart aplikasi.");
    responseMap.put("install", "Aplikasi berhasil diinstall.");
    responseMap.put("lag", "Silakan restart device Anda.");
    responseMap.put("update", "Aplikasi sudah dalam versi terbaru.");
    responseMap.put("menu", "Silakan cek menu di aplikasi untuk pilihan makanan terbaru yang kami tawarkan.");
    responseMap.put("diskon",
        "Apakah Anda memiliki kode diskon? Masukkan saat checkout untuk menikmati potongan harga.");
    responseMap.put("waktu", "Estimasi waktu pengiriman biasanya 30-45 menit, tergantung lokasi Anda.");
    responseMap.put("komplain",
        "Kami minta maaf atas ketidaknyamanan yang Anda alami. Silakan berikan detail masalah Anda.");
    responseMap.put("restoran", "Sebutkan nama restoran yang Anda pilih, dan kami akan membantu Anda lebih lanjut.");
    responseMap.put("pengantaran",
        "Pengantaran tidak berhasil? Silakan berikan informasi lebih lanjut untuk membantu kami.");
    responseMap.put("kualitas",
        "Kami berkomitmen untuk memberikan makanan berkualitas. Apakah ada masalah yang ingin Anda laporkan?");
    responseMap.put("hubungi",
        "Jika Anda ingin berbicara langsung dengan customer service, silakan hubungi nomor layanan kami.");
    responseMap.put("aplikasi",
        "Jika Anda mengalami masalah dengan aplikasi, pastikan aplikasi Anda sudah diperbarui ke versi terbaru.");
    responseMap.put("tutup",
        "Restoran yang Anda pilih mungkin sudah tutup. Silakan pilih restoran lain yang masih buka.");
    responseMap.put("dibatalkan",
        "Pesanan Anda telah dibatalkan. Silahkan hubungi customer service kami jika ada pertanyaan lebih lanjut.");
    responseMap.put("terlambat",
        "Kami minta maaf jika pengiriman Anda terlambat. Kami akan mengecek statusnya segera.");
    responseMap.put("nasi",
        "Nasi adalah salah satu pilihan utama kami. Apakah Anda ingin tahu lebih banyak tentang menu nasi?");
    responseMap.put("minuman", "Kami juga menyediakan berbagai minuman. Silakan cek di menu kami!");

  }

  private void fillDefaultResponses() {
    defaultResponses.add("Sepertinya ada masalah. Dapatkah Anda memberikan lebih banyak detail tentang masalah ini?");
    defaultResponses
        .add("Ini belum dilaporkan oleh pelanggan lain. Bisakah Anda spesifik tentang detail pesanan Anda?");
    defaultResponses.add(
        "Ini adalah kekhawatiran yang menarik! Silakan bagikan informasi lebih lanjut agar kami dapat membantu Anda dengan lebih baik.");
    defaultResponses.add("Saya membutuhkan beberapa detail tambahan mengenai permintaan Anda.");
    defaultResponses.add("Apakah Anda sudah memeriksa apakah aplikasi sudah diperbarui ke versi terbaru?");
    defaultResponses.add("Ini biasanya dijelaskan di FAQ kami. Apakah Anda sudah melihatnya?");
    defaultResponses.add("Penjelasan Anda sedikit samar. Dapatkah Anda memberikan lebih banyak spesifikasi?");
    defaultResponses
        .add("Ini terdengar seperti masalah yang bisa kami selesaikan. Silakan berikan konteks lebih lanjut!");
    defaultResponses
        .add("Kami di sini untuk membantu! Silakan bagikan detailnya agar kami dapat membantu Anda dengan efektif.");
  }

  private String pickDefaultResponse() {
    int index = randomGenerator.nextInt(defaultResponses.size());
    return defaultResponses.get(index);
  }

  public String generateResponse(HashSet<String> words) {
    String bestAnswer = null;
    int bestSimilarity = 0;

    for (String word : words) {
      for (String key : responseMap.keySet()) {
        int distance = levenshteinDistance.apply(word, key);
        int length = Math.max(word.length(), key.length());
        int similarity = (int) ((1.0 - (double) distance / length) * 100);

        if (similarity > bestSimilarity) {
          bestSimilarity = similarity;
          bestAnswer = responseMap.get(key);
        }
      }
      if (bestAnswer != null && bestSimilarity >= 65) {
        return bestAnswer;
      }
    }
    return pickDefaultResponse();
  }
}
