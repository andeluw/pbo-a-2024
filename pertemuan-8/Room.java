public class Room {
  public String desc;
  public Room northExit, westExit, eastExit, southExit;

  public Room(String desc) {
    this.desc = desc;
  }

  public void setExitRooms(Room northRoom, Room eastRoom, Room southRoom, Room westRoom) {
    if (northRoom != null)
      northExit = northRoom;
    if (eastRoom != null)
      eastExit = eastRoom;
    if (southRoom != null)
      southExit = southRoom;
    if (westRoom != null)
      westExit = westRoom;
  }

  public String getDesc() {
    return desc;
  }
}
