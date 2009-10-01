package clickcounter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * An interactive interface for the ClickCounter class.
 */

public class ClickCounterPresentation
    extends JPanel
    implements Presentation, EventLabels {

  private JButton         incrementButton;
  private JButton         resetButton;
  private JButton         decrementButton;
  private JLabel          valueDisplay;
  private JPanel valuePanel   = new JPanel();
  private JPanel controlPanel = new JPanel();

  private ClickCounterTranslation translation;

  private DecimalFormat format = new DecimalFormat("000");
  GridLayout gridLayout1 = new GridLayout();
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();

  public ClickCounterPresentation(ClickCounterTranslation translation) {
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
  } // end ClickCounterPresentation constructor.

  private void jbInit() throws Exception {

    // make layout and other general decisions here

    setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    this.setLayout(borderLayout1);

    // build the visible interface

    valueDisplay = new JLabel();

    valueDisplay.setFont(new java.awt.Font("Lucida Grande", 0, 72));
    valueDisplay.setPreferredSize(new Dimension(116, 73));
    valueDisplay.setVerifyInputWhenFocusTarget(true);
    valueDisplay.setHorizontalAlignment(SwingConstants.CENTER);
    valueDisplay.setText("abc");
    valueDisplay.setVerticalAlignment(SwingConstants.CENTER);
    controlPanel.setLayout(gridLayout1);
    valuePanel.setLayout(borderLayout2);
    valuePanel.add(valueDisplay,  BorderLayout.CENTER);
    this.add(valuePanel, BorderLayout.CENTER);

    incrementButton = new JButton("+");
    incrementButton.setActionCommand(INCREMENT);
    incrementButton.addActionListener(translation);

    resetButton = new JButton("0");
    resetButton.setActionCommand(RESET);
    resetButton.addActionListener(translation);

    decrementButton = new JButton("-");
    decrementButton.setActionCommand(DECREMENT);
    decrementButton.addActionListener(translation);

    controlPanel.add(incrementButton);
    controlPanel.add(decrementButton);
    controlPanel.add(resetButton);
    this.add(controlPanel,  BorderLayout.SOUTH);
  } // end ClickCounterPresentation constructor.


  public void setValueDisplay(int newValue) {
    valueDisplay.setText(format.format(newValue));
  } // End setValueDisplay.

  public void setMinimumState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(false);
    decrementButton.setEnabled(false);
  } // End setMinimumState.

  public void setCountingState() {
    incrementButton.setEnabled(true);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  } // End setCountingState.

  public void setMaximumState() {
    incrementButton.setEnabled(false);
    resetButton.setEnabled(true);
    decrementButton.setEnabled(true);
  } // End setMaximumState.

} // end class ClickCounterPresentation.
