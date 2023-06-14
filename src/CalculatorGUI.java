//TO-DO
//Fix issue: JFrame doesn't stay in focus
//temp workaround by requesting JFram focus after
//some ActionListener's

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class CalculatorGUI {

    Calculator calculator = new Calculator();
    String operation = "null";
    double firstNumber;
    double secondNumber;

    JFrame frame = new JFrame();
    JTextField textArea = new JTextField();

    JButton clear = new JButton("C");
    JButton clearEntry = new JButton("CE");
    JButton equals = new JButton("=");
    JButton multiply = new JButton("*");
    JButton add = new JButton("+");
    JButton subtract = new JButton("-");
    JButton divide = new JButton("/");
    JButton decimal = new JButton(".");
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

    public CalculatorGUI() {
        setupGUI();
        setupButtons();
        setupButtonListeners();
        textArea.setEditable(false);
    }

    public void setupGUI() {
        frame.setTitle("Trav's Cool Calculator");
        frame.add(textArea);
        frame.setSize(300, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.requestFocus();
        frame.addKeyListener(new frameKeyListener());
        textArea.setBounds(50, 20, 200, 50);
    }

    public void setupButtons() {
        //Clear button
        clear.setBounds(100, 140, 50, 50);

        //CE button
        clearEntry.setBounds(40, 140, 50, 50);

        //equals button
        equals.setBounds(220, 380, 50, 50);

        //multiply button
        multiply.setBounds(220, 200, 50, 50);

        //add button
        add.setBounds(220, 320, 50, 50);

        //subtract button
        subtract.setBounds(220, 260, 50, 50);

        //divide button
        divide.setBounds(220, 140, 50, 50);

        //decimal button
        decimal.setBounds(160, 380, 50, 50);

        //zero button
        zero.setBounds(100, 380, 50, 50);

        //one button
        one.setBounds(40, 320, 50, 50);

        //two button
        two.setBounds(100, 320, 50, 50);

        //three button
        three.setBounds(160, 320, 50, 50);

        //four button
        four.setBounds(40, 260, 50, 50);

        //five button
        five.setBounds(100, 260, 50, 50);

        //six button
        six.setBounds(160, 260, 50, 50);

        //seven button
        seven.setBounds(40, 200, 50, 50);

        //eight button
        eight.setBounds(100, 200, 50, 50);

        //nine button
        nine.setBounds(160, 200, 50, 50);

        //add the buttons to the panel
        for (JButton jButton : Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine, divide, equals, multiply, add, subtract, decimal, clearEntry, clear)) {
            frame.add(jButton);
        }
    }

    public void setupButtonListeners() throws NumberFormatException {
        //setup number and decimal listeners
        ActionListener numberButtonListener = e -> {
            JButton button = (JButton) e.getSource();
            String number = button.getText();
            textArea.setText(textArea.getText() + number);
        };
        //assign number and decimal listeners
        JButton[] numberButtons = {zero, one, two, three, four, five, six, seven, eight, nine, decimal};
        for (JButton button : numberButtons) {
            button.addActionListener(numberButtonListener);
        }
        //clear button listner
        clear.addActionListener(e -> {
            textArea.setText(null);
            firstNumber = 0;
            secondNumber = 0;
            frame.requestFocus();
        });
        //clear entry listener
        clearEntry.addActionListener(e -> {
            textArea.setText(null);
            frame.requestFocus();
        });

        //operator button listeners
        ActionListener multiplyButtonListener = e -> {
            firstNumber = Double.parseDouble(textArea.getText());
            operation = "multiply";
            textArea.setText(null);
        };
        ActionListener addButtonListener = e -> {
            firstNumber = Double.parseDouble(textArea.getText());
            operation = "add";
            textArea.setText(null);
        };
        ActionListener subtractButtonListener = e -> {
            firstNumber = Double.parseDouble(textArea.getText());
            operation = "subtract";
            textArea.setText(null);
        };
        ActionListener divideButtonListener = e -> {
            firstNumber = Double.parseDouble(textArea.getText());
            operation = "divide";
            textArea.setText(null);
        };
        ActionListener equalsButtonListener = e -> {
            switch (operation) {
                case "multiply" -> {
                    secondNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.multiply(firstNumber, secondNumber)));
                    operation = "multiplied";
                    frame.requestFocus();
                }
                case "add" -> {
                    secondNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.add(firstNumber, secondNumber)));
                    operation = "added";
                    frame.requestFocus();
                }
                case "subtract" -> {
                    secondNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.subtract(firstNumber, secondNumber)));
                    operation = "subtracted";
                    frame.requestFocus();
                }
                case "divide" -> {
                    secondNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.divide(firstNumber, secondNumber)));
                    operation = "divided";
                    frame.requestFocus();
                }
                case "multiplied" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.multiply(firstNumber, secondNumber)));
                    frame.requestFocus();
                }
                case "added" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.add(firstNumber, secondNumber)));
                    frame.requestFocus();
                }
                case "subtracted" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.subtract(firstNumber, secondNumber)));
                    frame.requestFocus();
                }
                case "divided" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.divide(firstNumber, secondNumber)));
                    frame.requestFocus();
                }
            }
        };

        //assign listeners to operator buttons
        multiply.addActionListener(multiplyButtonListener);
        add.addActionListener(addButtonListener);
        subtract.addActionListener(subtractButtonListener);
        divide.addActionListener(divideButtonListener);
        equals.addActionListener(equalsButtonListener);
    }

    class frameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();
            switch (c) {
                case 43 -> {
                    add.doClick();
                    e.consume();
                }
                case 45 -> {
                    subtract.doClick();
                    e.consume();
                }
                case 47 -> {
                    divide.doClick();
                    e.consume();
                }
                case 42 -> {
                    multiply.doClick();
                    e.consume();
                }
                case 10 -> {
                    equals.doClick();
                    e.consume();
                }
                case 48 -> zero.doClick();
                case 49 -> {
                    one.doClick();
                    e.consume();
                }
                case 50 -> two.doClick();
                case 51 -> three.doClick();
                case 52 -> four.doClick();
                case 53 -> five.doClick();
                case 54 -> six.doClick();
                case 55 -> seven.doClick();
                case 56 -> eight.doClick();
                case 57 -> nine.doClick();
                case 46 -> decimal.doClick();
            }
        }
    }
}