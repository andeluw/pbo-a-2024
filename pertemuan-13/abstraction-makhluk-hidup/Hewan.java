public class Hewan extends MakhlukHidup {
  public Hewan(String name) {
    super(name);
  }

  @Override
  public void grow() {
    System.out.println(name + " tumbuh dengan mengonsumsi makanan dan membangun tubuhnya.");
  }

  public void hunt() {
    System.out.println(name + " sedang berburu mangsa.");
  }
}
