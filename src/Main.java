import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static final JFrame frame = new JFrame();
    public static final JPanel panelNumbers = new JPanel();
    public static final JPanel panelOpt = new JPanel();
    public static final JTextField textField = new JTextField();
    private static final String[] numberValues = {"7", "8", "9",
                                                    "4", "5", "6",
                                                    "1", "2","3",
                                                    "0", "00", "."};
    public static String[] operators = {"D", "C", "+", "-", "X", "/", "="};
    private static Double num1 = null;
    private static Double num2 = null;
    private static String opt = null;
//    private static String value = "";
    public static JButton btn;
    public static JButton btn1;
    public static void main(String[] args) {
        //Buttons for Numbers
        for (String numberValue : numberValues) {
            createNumberButton(numberValue);
        }

//		Buttons for Operators
        for (String s : operators) {
            createOperatorButton(s);
        }

        new CalculatorGUI();
    }

    public static void createNumberButton(String value) {
        btn1 = new JButton(value);//creating instance of JButton
        btn1.addActionListener(e -> {
            JButton button = (JButton) e.getSource();
            if (opt == null) {
                String value1 = textField.getText().concat(button.getText());
                textField.setText(value1);
                num1 = Double.parseDouble(value1);
            } else {
                if (num2 == null) {
                    textField.setText("");
                }
                String value1 = textField.getText().concat(button.getText());
                textField.setText(value1);
                num2 = Double.parseDouble(value1);
                System.out.println("number");
                System.out.println("------------");
                System.out.println("num1: " + num1);
                System.out.println("num2: " + num2);
                System.out.println("opt: " + opt);
                System.out.println("------------");
            }
        });
        CalculatorGUI.numbersGUI();
        panelNumbers.add(btn1);//adding button in JFrame
    }
    public static void createOperatorButton(String value) {
        //creating instance of JButton
        btn = new JButton(value);
        btn.addActionListener(e -> {
            String value1 = ((JButton) e.getSource()).getText();
            boolean isOperator = Arrays.stream(operators).toList().contains(value1);

            switch (value1) {
                case "C":
                    num1 = null;
                    num2 = null;
                    opt = null;
                    textField.setText("");
                    return;
                case "D":
                    String v = textField.getText();
                    String newValue;
                    if (v.length() > 1) {
                        newValue = v.substring(0, v.length() - 1);
                        textField.setText(newValue);
                        if(num2 != null) {
                            num2 = Double.parseDouble(newValue);
                        } else {
                            num1 = Double.parseDouble(newValue);
                        }
                    } else {
                        textField.setText("");
                        if(num2 != null) {
                            num2 = 0.0;
                        } else {
                            num1 = 0.0;
                        }
                    }
                    return;
                case "=":
                    if (opt != null && num2 != null && isOperator) {
                        evaluate(opt);
                    }
                    return;
            }

            if (opt != null && num2 != null && isOperator) {
                evaluate(opt);
            }

            opt = value1;

            System.out.println("Operator");
            System.out.println("------------");
            System.out.println("num1: "+num1);
            System.out.println("num2: "+num2);
            System.out.println("opt: "+opt);
            System.out.println("------------");

        });
        CalculatorGUI.operatorGUI();
        panelOpt.add(btn);//adding button in JFrame
    }

    private static void evaluate(String value) {
        double result = 0.0;
        switch (value) {
            case "+":
                result = (num1+num2);
                break;
            case "-":
                result = num1-num2;
                break;
            case "X":
                result = num1*num2;
                break;
            case "/":
                try {
                    result = num1 / num2;
                } catch (Exception e) {
                    result = 0.0;
                }
                break;
            default:
                break;
        }
        textField.setText(""+result);
        num1 = result;
        num2 = null;
        System.out.println("evaluate");
        System.out.println("------------");
        System.out.println("num1: "+num1);
        System.out.println("num2: "+num2);
        System.out.println("opt: "+opt);
        System.out.println("------------");
    }
}