public class Manusia extends MakhlukHidup {
  public Manusia(String name) {
    super(name);
  }

  @Override
  public void grow() {
    System.out.println(name + " tumbuh melalui pertumbuhan fisik dan pembelajaran.");
  }

  public void talk(String dialogue) {
    System.out.println(name + " berkata: " + dialogue);
  }
}
