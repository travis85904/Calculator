//TO-DO
//Add key listeners for operator buttons



import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class CalculatorGUI {

    Calculator calculator = new Calculator();
    String operation = "null";
    double firstNumber;
    double secondNumber;
    JFrame window = new JFrame();

    JTextArea numberBox = new JTextArea();
    JButton equals = new JButton("=");
    JButton multiply = new JButton("*");
    JButton add = new JButton("+");
    JButton subtract = new JButton("-");
    JButton divide = new JButton("/");
    JButton zero = new JButton("0");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton decimal = new JButton(".");

    public CalculatorGUI() {
        setupGUI();
        try {
            setupButtonListeners();
        } catch (NumberFormatException e) {
            setupButtonListeners();
        }
    }

    public void setupGUI() {
        window.setTitle("Trav's Cool Calculator");
        numberBox.setBounds(50, 20, 200, 50);
        divide.setBounds(220, 140, 50, 50);
        multiply.setBounds(220, 200, 50, 50);
        subtract.setBounds(220, 260, 50, 50);
        add.setBounds(220, 320, 50, 50);
        equals.setBounds(220, 380, 50, 50);
        decimal.setBounds(160, 380, 50, 50);
        zero.setBounds(100, 380, 50, 50);
        one.setBounds(40, 320, 50, 50);
        two.setBounds(100, 320, 50, 50);
        three.setBounds(160, 320, 50, 50);
        four.setBounds(40, 260, 50, 50);
        five.setBounds(100, 260, 50, 50);
        six.setBounds(160, 260, 50, 50);
        seven.setBounds(40, 200, 50, 50);
        eight.setBounds(100, 200, 50, 50);
        nine.setBounds(160, 200, 50, 50);




        for (JButton jButton : Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine, divide, equals, multiply, add, subtract, decimal)) {
            window.add(jButton);
        }
        window.add(numberBox);

        window.setSize(300, 500);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(3);

    }


    public void setupButtonListeners() throws NumberFormatException {
        ActionListener multiplyButtonListener = e -> {
            firstNumber = Double.parseDouble(numberBox.getText());
            operation = "multiply";
            numberBox.setText(null);
        };
        ActionListener addButtonListener = e -> {
            firstNumber = Double.parseDouble(numberBox.getText());
            operation = "add";
            numberBox.setText(null);
        };
        ActionListener subtractButtonListener = e -> {
            firstNumber = Double.parseDouble(numberBox.getText());
            operation = "subtract";
            numberBox.setText(null);
        };
        ActionListener divideButtonListener = e -> {
            firstNumber = Double.parseDouble(numberBox.getText());
            operation = "divide";
            numberBox.setText(null);
        };
        ActionListener equalsButtonListener = e -> {
            switch (operation) {
                case "multiply" -> {
                    secondNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.multiply(firstNumber, secondNumber)));
                    operation = "multiplied";
                }
                case "add" -> {
                    secondNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.add(firstNumber, secondNumber)));
                    operation = "added";
                }
                case "subtract" -> {
                    secondNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.subtract(firstNumber, secondNumber)));
                    operation = "subtracted";
                }
                case "divide" -> {
                    secondNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.divide(firstNumber, secondNumber)));
                    operation = "divided";
                }
                case "multiplied" -> {
                    firstNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.multiply(firstNumber, secondNumber)));
                }
                case "added" -> {
                    firstNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.add(firstNumber, secondNumber)));
                }
                case "subtracted" -> {
                    firstNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.subtract(firstNumber, secondNumber)));
                }
                case "divided" -> {
                    firstNumber = Double.parseDouble(numberBox.getText());
                    numberBox.setText(Double.toString(calculator.divide(firstNumber, secondNumber)));
                }
            }
        };
        ActionListener zeroButtonListener = e -> numberBox.append("0");
        ActionListener oneButtonListener = e -> numberBox.append("1");
        ActionListener twoButtonListener = e -> numberBox.append("2");
        ActionListener threeButtonListener = e -> numberBox.append("3");
        ActionListener fourButtonListener = e -> numberBox.append("4");
        ActionListener fiveButtonListener = e -> numberBox.append("5");
        ActionListener sixButtonListener = e -> numberBox.append("6");
        ActionListener sevenButtonListener = e -> numberBox.append("7");
        ActionListener eightButtonListener = e -> numberBox.append("8");
        ActionListener nineButtonListener = e -> numberBox.append("9");
        ActionListener decimalButtonListener = e -> numberBox.append(".");

        decimal.addActionListener(decimalButtonListener);
        zero.addActionListener(zeroButtonListener);
        one.addActionListener(oneButtonListener);
        two.addActionListener(twoButtonListener);
        three.addActionListener(threeButtonListener);
        four.addActionListener(fourButtonListener);
        five.addActionListener(fiveButtonListener);
        six.addActionListener(sixButtonListener);
        seven.addActionListener(sevenButtonListener);
        eight.addActionListener(eightButtonListener);
        nine.addActionListener(nineButtonListener);
        multiply.addActionListener(multiplyButtonListener);

        add.addActionListener(addButtonListener);
        subtract.addActionListener(subtractButtonListener);
        divide.addActionListener(divideButtonListener);
        equals.addActionListener(equalsButtonListener);

    }


}