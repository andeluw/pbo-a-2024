public class Tumbuhan extends MakhlukHidup {
  public Tumbuhan(String name) {
    super(name);
  }

  @Override
  public void grow() {
    System.out.println(name + " tumbuh dengan menghasilkan energi melalui fotosintesis.");
  }

  public void photosynthesize() {
    System.out.println(name + " sedang melakukan fotosintesis.");
  }
}
