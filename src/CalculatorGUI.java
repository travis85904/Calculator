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

    JButton clearButton = new JButton("C");
    JButton clearEntryButton = new JButton("CE");
    JButton equalsButton = new JButton("=");
    JButton multiplyButton = new JButton("*");
    JButton addButton = new JButton("+");
    JButton subtractButton = new JButton("-");
    JButton divideButton = new JButton("/");
    JButton negativeButton = new JButton("+/-");
    JButton modButton = new JButton("%");


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
        clearButton.setBounds(100, 140, 50, 50);

        //CE button
        clearEntryButton.setBounds(40, 140, 50, 50);

        //equals button
        equalsButton.setBounds(220, 380, 50, 50);

        //multiply button
        multiplyButton.setBounds(220, 200, 50, 50);

        //add button
        addButton.setBounds(220, 320, 50, 50);

        //subtract button
        subtractButton.setBounds(220, 260, 50, 50);

        //divide button
        divideButton.setBounds(220, 140, 50, 50);

        //negative button
        negativeButton.setBounds(40, 380, 50, 50);

        //mod button
        modButton.setBounds(160, 140, 50, 50);

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
        for (JButton jButton : Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine, divideButton, equalsButton, multiplyButton, addButton, subtractButton, decimal, clearEntryButton, clearButton, negativeButton, modButton)) {
            frame.add(jButton);
            jButton.setFocusable(false);
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
        clearButton.addActionListener(e -> {
            textArea.setText(null);
            firstNumber = 0;
            secondNumber = 0;
        });
        //clear entry listener
        clearEntryButton.addActionListener(e -> textArea.setText(null));

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
        ActionListener modButtonListener = e -> {
            firstNumber = Double.parseDouble(textArea.getText());
            operation = "mod";
            textArea.setText(null);
        };
        ActionListener negativeButtonListener = e -> {
            double number = Double.parseDouble(textArea.getText());
            String newNumber = Double.toString(calculator.invertValue(number));
            textArea.setText(newNumber);
        };
        ActionListener equalsButtonListener = e -> {
            switch (operation) {
                case "multiply", "add", "subtract", "divide", "mod" -> {
                    secondNumber = Double.parseDouble(textArea.getText());
                    switch (operation) {
                        case "multiply" ->
                                textArea.setText(Double.toString(calculator.multiply(firstNumber, secondNumber)));
                        case "add" -> textArea.setText(Double.toString(calculator.add(firstNumber, secondNumber)));
                        case "subtract" ->
                                textArea.setText(Double.toString(calculator.subtract(firstNumber, secondNumber)));
                        case "divide" ->
                                textArea.setText(Double.toString(calculator.divide(firstNumber, secondNumber)));
                        case "mod" -> textArea.setText(Double.toString(calculator.modulus(firstNumber, secondNumber)));
                    }
                    operation += "Again";
                }
                case "multiplyAgain" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.multiply(firstNumber, secondNumber)));
                }
                case "addAgain" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.add(firstNumber, secondNumber)));
                }
                case "subtractAgain" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.subtract(firstNumber, secondNumber)));
                }
                case "divideAgain" -> {
                    firstNumber = Double.parseDouble(textArea.getText());
                    textArea.setText(Double.toString(calculator.divide(firstNumber, secondNumber)));
                }

            }
        };

        //assign listeners to operator buttons
        multiplyButton.addActionListener(multiplyButtonListener);
        addButton.addActionListener(addButtonListener);
        subtractButton.addActionListener(subtractButtonListener);
        divideButton.addActionListener(divideButtonListener);
        equalsButton.addActionListener(equalsButtonListener);
        modButton.addActionListener(modButtonListener);
        negativeButton.addActionListener(negativeButtonListener);
    }

    //key handler for keyboard presses
    class frameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();
            switch (c) {
                case 43 -> addButton.doClick();
                case 45 -> subtractButton.doClick();
                case 47 -> divideButton.doClick();
                case 42 -> multiplyButton.doClick();
                case 10 -> equalsButton.doClick();
                case 48 -> zero.doClick();
                case 49 -> one.doClick();
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