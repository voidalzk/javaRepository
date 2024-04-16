import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clearButton, decButton;
    private JPanel panel;
    private double num1 = 0, num2 = 0, result = 0;
    private int operator = 0;
    private boolean newEntry = true;

    public Main() {
        createGUI();
    }

  private void createGUI() {
      setTitle("Simple Calculator");
      setSize(400, 500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setLayout(new BorderLayout());

      textField = new JTextField();
      textField.setEditable(false);
      textField.setFont(new Font("Arial", Font.BOLD, 24));
      textField.setHorizontalAlignment(JTextField.RIGHT);
      add(textField, BorderLayout.NORTH);

      panel = new JPanel();
      panel.setLayout(new GridLayout(5, 4));

    panel = new JPanel();
    panel.setLayout(new GridLayout(5, 4));

    addButton = new JButton("+");
    addButton.addActionListener(this);
    panel.add(addButton);

    subButton = new JButton("-");
    subButton.addActionListener(this);
    panel.add(subButton);

    divButton = new JButton("/");
    divButton.addActionListener(this);
    panel.add(divButton);

    clearButton = new JButton("C");
    clearButton.addActionListener(this);
    panel.add(clearButton);

    for (int i = 7; i <= 9; i++) {
        numberButtons[i - 1] = new JButton(String.valueOf(i));
        numberButtons[i - 1].addActionListener(this);
        panel.add(numberButtons[i - 1]);
    }

    mulButton = new JButton("*");
    mulButton.addActionListener(this);
    panel.add(mulButton);

    for (int i = 4; i <= 6; i++) {
        numberButtons[i - 1] = new JButton(String.valueOf(i));
        numberButtons[i - 1].addActionListener(this);
        panel.add(numberButtons[i - 1]);
    }

    decButton = new JButton(".");
    decButton.addActionListener(this);
    panel.add(decButton);

    for (int i = 1; i <= 3; i++) {
        numberButtons[i - 1] = new JButton(String.valueOf(i));
        numberButtons[i - 1].addActionListener(this);
        panel.add(numberButtons[i - 1]);
    }

    eqButton = new JButton("=");
    eqButton.addActionListener(this);
    panel.add(eqButton);

    numberButtons[9] = new JButton("0");
    numberButtons[9].addActionListener(this);
    panel.add(numberButtons[9]);

      add(panel, BorderLayout.CENTER);

      setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == clearButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
            newEntry = true;
        } else if (source == numberButtons[0]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "1");
        } else if (source == numberButtons[1]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "2");
        } else if (source == numberButtons[2]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "3");
        } else if (source == numberButtons[3]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "4");
        } else if (source == numberButtons[4]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "5");
        } else if (source == numberButtons[5]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "6");
        } else if (source == numberButtons[6]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "7");
        } else if (source == numberButtons[7]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "8");
        } else if (source == numberButtons[8]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "9");
        } else if (source == numberButtons[9]) {
            if (newEntry) {
                textField.setText("");
                newEntry = false;
            }
            textField.setText(textField.getText() + "0");
        } else if (source == decButton) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        } else if (source == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 1;
            newEntry = true;
        } else if (source == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 2;
            newEntry = true;
        } else if (source == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 3;
            newEntry = true;
        } else if (source == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 4;
            newEntry = true;
        } else if (source == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            newEntry = true;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
