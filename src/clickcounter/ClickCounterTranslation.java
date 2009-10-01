package clickcounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Provides the interface behaviour for the interactive
 * ClickCounter.
 */

public class ClickCounterTranslation implements ActionListener, EventLabels {

  private final int INITIAL_STATE  = 0;
  private final int MINIMUM_STATE  = 1;
  private final int COUNTING_STATE = 2;
  private final int MAXIMUM_STATE  = 3;
  private       int theState       = INITIAL_STATE;

  private ClickCounter theCounter;
  private Presentation visibleInterface;

  /**
   * This method provides this translation with a visible interface
   * (presentation).
   */

  public void setVisibleInterface(Presentation visibleInterface) {
    this.visibleInterface = visibleInterface;
    visibleInterface.setValueDisplay(theCounter.countIs());
    visibleInterface.setMinimumState();
    theState = MINIMUM_STATE;
  } // end init.

  public void setApplication(ClickCounter theCounter) {
    this.theCounter = theCounter;
  }

  public void actionPerformed(ActionEvent event) {
    String buttonPressed = event.getActionCommand();

    if (INCREMENT.equals(buttonPressed)) {
      if (theState == MINIMUM_STATE) {
        visibleInterface.setCountingState();
        theState = COUNTING_STATE;
      } // End if.
      theCounter.count();
      if (theCounter.isAtMaximum()) {
        visibleInterface.setMaximumState();
        theState = MAXIMUM_STATE;
      } // End if.

    } else if (RESET.equals(buttonPressed)) {

      theCounter.reset();
      visibleInterface.setMinimumState();
      theState = MINIMUM_STATE;

    } else if (DECREMENT.equals(buttonPressed)) {

      if (theState == MAXIMUM_STATE) {
        visibleInterface.setCountingState();
        theState = COUNTING_STATE;
      } // End if.
      theCounter.unCount();
      if (theCounter.isAtMinimum()) {
        visibleInterface.setMinimumState();
        theState = MINIMUM_STATE;
      } // End if.
    } // End if.

    visibleInterface.setValueDisplay(theCounter.countIs());
  } // End actionPerformed.

} // end class ClickCounterTranslation.

