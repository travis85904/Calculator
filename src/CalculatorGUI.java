import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI {

    Calculator calculator = new Calculator();
    String operation = "null";
    double firstNumber;
    double secondNumber;

    JFrame frame = new JFrame();
    JTextField textArea = new JTextField();

    JButton clearButton = createButton("C", 100, 140);
    JButton clearEntryButton = createButton("CE", 40, 140);
    JButton equalsButton = createButton("=", 220, 380);
    JButton multiplyButton = createButton("*", 220, 200);
    JButton addButton = createButton("+", 220, 320);
    JButton subtractButton = createButton("-", 220, 260);
    JButton divideButton = createButton("/", 220, 140);
    JButton negativeButton = createButton("+/-", 40, 380);
    JButton modButton = createButton("%", 160, 140);

    JButton decimal = createButton(".", 160, 380);
    JButton zero = createButton("0", 100, 380);
    JButton one = createButton("1", 40, 320);
    JButton two = createButton("2", 100, 320);
    JButton three = createButton("3", 160, 320);
    JButton four = createButton("4", 40, 260);
    JButton five = createButton("5", 100, 260);
    JButton six = createButton("6", 160, 260);
    JButton seven = createButton("7", 40, 200);
    JButton eight = createButton("8", 100, 200);
    JButton nine = createButton("9", 160, 200);

    public CalculatorGUI() {
        setupGUI();
       // setupButtons();
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
        textArea.setFocusable(false);
    }
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 50, 50);
        frame.add(button);
        button.setFocusable(false);
        return button;
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
        //clear button listener
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