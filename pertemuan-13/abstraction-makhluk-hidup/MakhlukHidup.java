public abstract class MakhlukHidup {
  protected String name;

  public MakhlukHidup(String name) {
    this.name = name;
  }

  public abstract void grow();

  public void breathe() {
    System.out.println(name + " sedang bernapas.");
  }

  public static void main(String[] args) {
    System.out.println("-- Manusia --");
    Manusia manusia = new Manusia("Budi");
    manusia.breathe();
    manusia.grow();
    manusia.talk("Halo dunia!");

    System.out.println("\n-- Hewan --");
    Hewan hewan = new Hewan("Kucing");
    hewan.breathe();
    hewan.grow();
    hewan.hunt();

    System.out.println("\n-- Tumbuhan --");
    Tumbuhan tumbuhan = new Tumbuhan("Pohon Mangga");
    tumbuhan.breathe();
    tumbuhan.grow();
    tumbuhan.photosynthesize();
  }
}
