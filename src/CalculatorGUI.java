import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends Main{
    public CalculatorGUI() {
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
    public static void numbersGUI() {
        //Number Buttons
        btn1.setFocusable(true);
        btn1.setBackground(new Color(82, 76, 87));
        btn1.setForeground(Color.WHITE);
        btn1.setFocusPainted(false); // Remove the focus border
        btn1.setFont(new Font("Arial", Font.BOLD, 14));
        btn1.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
    public static void operatorGUI() {

        //Operator Buttons
        btn.setFocusable(true);
        btn.setBackground(new Color(240,130,60));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false); // Remove the focus border
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}
