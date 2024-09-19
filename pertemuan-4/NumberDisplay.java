class NumberDisplay {
  private int curr;
  private int max;

  public NumberDisplay(int limit) {
    curr = 0;
    max = limit;
  }

  public void setValue(int newValue) {
    if (newValue >= 0 && newValue < max) {
      curr = newValue;
    }
  }

  public int getValue() {
    return curr;
  }

  public String getDisplayValue() {
    if (curr < 10) {
      return "0" + curr;
    } else {
      return "" + curr;
    }
  }

  public void increment() {
    curr = (curr + 1) % max;
  }
}
