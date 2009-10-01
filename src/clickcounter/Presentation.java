package clickcounter;

/**
 * An interface for ClickCounter presentation classes.
 */

public interface Presentation {

  void setValueDisplay(int newValue);
  void setMinimumState();
  void setCountingState();
  void setMaximumState();

} // end class Presentation.
