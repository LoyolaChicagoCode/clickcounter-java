package clickcounter;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JComponent;

/**
 * Provides the interface behaviour for the interactive ClickCounter.
 */

public class ClickCounterMain extends JApplet {

  public void init() {
    // create a translation independently from the presentation
    ClickCounterTranslation translation = new ClickCounterTranslation();
    // create an application independently from the translation
    ClickCounter application = new ClickCounter(0, 5);
    // tell the translation about the application
    translation.setApplication(application);
    // decide here which presentation to use
    // (this decision used to be hidden in the translation class)
    JComponent visibleInterface = new ClickCounterPresentation(translation);
//    JComponent visibleInterface = new AlternatePresentation(translation);
    // add the presentation to this applet
    this.setContentPane(visibleInterface);
  } // end init.

  public static void main(String args[]) {
    // create a frame around the applet
    JFrame frame = new JFrame("Click Counter Demo");
    ClickCounterMain theInterface = new ClickCounterMain();
    // invoke the applet's lifecycle methods manually
    theInterface.init();
    // put the applet into the frame
    frame.setContentPane(theInterface);
    // bring the close button to life
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // lay out components in the frame
    frame.pack();
    // make the GUI visible
    frame.setVisible(true);
  } // end main.
} // end class ClickCounterTranslation.

