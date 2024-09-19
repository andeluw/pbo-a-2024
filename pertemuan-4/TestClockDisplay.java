import java.util.Calendar;

public class TestClockDisplay {
  public static void main(String[] args) {
    ClockDisplay clock = new ClockDisplay();
    Calendar currTime = Calendar.getInstance();
    clock.setTime(currTime.get(Calendar.HOUR_OF_DAY), currTime.get(Calendar.MINUTE),
        currTime.get(Calendar.SECOND));
  }
}