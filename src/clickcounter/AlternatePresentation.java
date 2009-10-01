package clickcounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * An interface whose presentation is built entirely using JBuilder.
 * All commented code was added manually.
 */

public class AlternatePresentation extends JPanel implements Presentation {
  JPanel jPanel1 = new JPanel();
  JButton incrementButton = new JButton();
  JButton resetButton = new JButton();
  JButton decrementButton = new JButton();

  /**
   * The translation object for this application.
   */
  private ClickCounterTranslation translation;
  private GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel2 = new JPanel();
  JLabel valueDisplay = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout2 = new GridLayout();

  /**
   * Constructor with translation object as argument.
   * Only the argument was added manually.
   */
  public AlternatePresentation(ClickCounterTranslation translation) {
    // first hook up the this presentation to the translation
    this.translation = translation;

    // then build the interface the JBuilder way
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    // finally hook up the translation to this presentation
    translation.setVisibleInterface(this);
  }

  private void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    incrementButton.setActionCommand("increment");
    incrementButton.setText("+");
    incrementButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        incrementButton_actionPerformed(e);
      }
    });
    jPanel1.setLayout(gridLayout1);
    resetButton.setForeground(Color.red);
    resetButton.setActionCommand("reset");
    resetButton.setText("0");
    resetButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        resetButton_actionPerformed(e);
      }
    });
    decrementButton.setActionCommand("decrement");
    decrementButton.setText("-");
    decrementButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        decrementButton_actionPerformed(e);
      }
    });
    this.setBackground(Color.green);
    jPanel1.setBackground(Color.red);
    valueDisplay.setFont(new java.awt.Font("Lucida Grande", 0, 120));
    valueDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    valueDisplay.setText("0");
    jPanel2.setLayout(gridLayout2);
    this.add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(incrementButton, null);
    jPanel1.add(resetButton, null);
    jPanel1.add(decrementButton, null);
    this.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(valueDisplay, null);
  }

  /**
   * Forward this event to the translation object.
   */
  void incrementButton_actionPerformed(ActionEvent e) {
    translation.actionPerformed(e);
  }

  /**
   * Forward this event to the translation object.
   */
  void resetButton_actionPerformed(ActionEvent e) {
    translation.actionPerformed(e);
  }
  /**
   * Forward this event to the translation object.
   */
  void decrementButton_actionPerformed(ActionEvent e) {
    translation.actionPerformed(e);
  }

  /**
   * Set the string being displayed.
   */
  public void setValueDisplay(int newValue) {
    valueDisplay.setText(Integer.toString(newValue));
  } // End setValueDisplay.

  /**
   * Make the presentation correspond to the logical minimum state
   * in the translation.
   */
  public void setMinimumState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(false);
    decrementButton.setEnabled(false);
  } // End setMinimumState.

  /**
   * Make the presentation correspond to the logical counting state
   * in the translation.
   */
  public void setCountingState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  } // End setCountingState.

  /**
   * Make the presentation correspond to the logical maximum state
   * in the translation.
   */
  public void setMaximumState() {
    incrementButton.setEnabled(false);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  }

  void inc_actionPerformed(ActionEvent e) {
    translation.actionPerformed(e);
  } // End setMaximumState.
}