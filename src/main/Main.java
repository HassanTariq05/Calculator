package main;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class Main {
    private static final JFrame frame = new JFrame();
    private static final JPanel panelNumbers = new JPanel();
    private static final JPanel panelOpt = new JPanel();
    private static final JTextField textField = new JTextField();
    private static final String[] numberValues = {"7", "8", "9",
            "4", "5", "6",
            "1", "2","3",
            "0", "00", "."};
    private static final String[] operators = {"D", "C", "+", "-", "X", "/", "="};
    private static Double num1 = null;
    private static Double num2 = null;
    private static String opt = null;

    public static void main(String[] args) {
        //Frame
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\Calculator\\Resource\\calculatorIcon.png");
        frame.setIconImage(icon);
        frame.getContentPane().setBackground(new Color(70, 70, 70));

        //Panel for Buttons
        frame.add(panelNumbers, BorderLayout.CENTER);
        frame.add(panelOpt, BorderLayout.CENTER);

        //Output textField
        textField.setBounds(50, 25, 330, 50);
        textField.setEditable(false);
        textField.setForeground(Color.white);
        textField.setBackground(new Color(97,97,97));
        textField.setCaretColor(new Color(97,97,97));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        //Buttons for Numbers
        for (String numberValue : numberValues) {
            createNumberButton(numberValue);
        }

//		Buttons for Operators
        for (String s : operators) {
            createOperatorButton(s);
        }

        panelNumbers.setBounds(50, 100, 200, 200);
        panelNumbers.setLayout(new GridLayout(4, 4, 8, 8));
        panelNumbers.setBackground(new Color(70, 70, 70));
        panelOpt.setBounds(258, 100, 120, 200);
        panelOpt.setLayout(new GridLayout(4, 2, 8, 8));
        panelOpt.setBackground(new Color(70, 70, 70));

        frame.add(textField);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void createNumberButton(String value) {
        JButton btn = new JButton(value);//creating instance of JButton
        btn.addActionListener(e -> {
            JButton button = (JButton) e.getSource();
            if(opt == null) {
                String value1 = textField.getText().concat(button.getText());
                textField.setText(value1);
                num1 = Double.parseDouble(value1);
            } else {
                if(num2 == null) {
                    textField.setText("");
                }
                String value1 = textField.getText().concat(button.getText());
                textField.setText(value1);
                num2 = Double.parseDouble(value1);
                System.out.println("number");
                System.out.println("------------");
                System.out.println("num1: "+num1);
                System.out.println("num2: "+num2);
                System.out.println("opt: "+opt);
                System.out.println("------------");
            }
        });
        btn.setFocusable(false);
        btn.setBackground(new Color(82,76,87));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false); // Remove the focus border
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelNumbers.add(btn);//adding button in JFrame
    }

    public static void createOperatorButton(String value) {
        JButton btn = new JButton(value);//creating instance of JButton
        btn.setFocusable(false);
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
        btn.setBackground(new Color(240,130,60));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false); // Remove the focus border
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
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