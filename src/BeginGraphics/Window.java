package BeginGraphics;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    final int n = 4;

    public Window() {
        setBounds(400, 400, 480, 640);

        setLayout(new BorderLayout());

        JButton[] buttons = new JButton[n * n];
        JPanel panelNumbers = new JPanel(new GridLayout(n + 1, n - 1));
        JPanel panelTexts = new JPanel(new GridLayout(2, 1)); // чисто игрался с разделением полей

        for (int i = 0; i < (n - 1) * (n - 1); i++) { // кнопки с 1 по 9 (да, должно расположение быть другим)
            buttons[i] = new JButton("" + (i + 1));
            panelNumbers.add(buttons[i]);
        }

        JButton btn0 = new JButton("0");
        JButton btnPl = new JButton("+");
        JButton btnMin = new JButton("-");
        JButton btnMult = new JButton("x");
        JButton btnDiv = new JButton("/");
        JButton btnEq = new JButton("=");

        panelNumbers.add(btn0);
        panelNumbers.add(btnPl);
        panelNumbers.add(btnMin);
        panelNumbers.add(btnMult);
        panelNumbers.add(btnDiv);
        panelNumbers.add(btnEq);

        JButton buttonC = new JButton("C"); // кнопка сброса внизу
        add(buttonC, BorderLayout.SOUTH);

        add(panelNumbers, BorderLayout.CENTER);

        TextField textField = new TextField(); // еще не придумал предназначение, но пусть будет
        panelTexts.add(textField);

        TextArea textArea = new TextArea(); // окно с данными
        panelTexts.add(textArea);

        add(panelTexts, BorderLayout.NORTH);

        setVisible(true);
        setTitle("Title");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttons[0].addActionListener(e -> {
            textArea.append("1");
        });
        buttons[1].addActionListener(e -> {
            textArea.append("2");
        });
        buttons[2].addActionListener(e -> {
            textArea.append("3");
        });
        buttons[3].addActionListener(e -> {
            textArea.append("4");
        });
        buttons[4].addActionListener(e -> {
            textArea.append("5");
        });
        buttons[5].addActionListener(e -> {
            textArea.append("6");
        });
        buttons[6].addActionListener(e -> {
            textArea.append("7");
        });
        buttons[7].addActionListener(e -> {
            textArea.append("8");
        });
        buttons[8].addActionListener(e -> {
            textArea.append("9");
        });
        btn0.addActionListener(e -> {
            textArea.append("0");
        });
        btnPl.addActionListener(e -> {
            textArea.append("+");
        });
        btnMin.addActionListener(e -> {
            textArea.append("-");
        });
        btnMult.addActionListener(e -> {
            textArea.append("x");
        });
        btnDiv.addActionListener(e -> {
            textArea.append("/");
        });
        buttonC.addActionListener(e -> {
            textArea.setText("");
        });
        btnEq.addActionListener(e -> { // реализация =
            String str = textArea.getText();
            double result = 0;
            char[] charArr = str.toCharArray();
            for (int i = 0; i < str.length(); i++) { // цикл понимает, какой знак используется
                if (charArr[i] == '+' || charArr[i] == '-' || charArr[i] == 'x' || charArr[i] == '/') {
                    result = plus(charArr, charArr[i]); // и передает его в метод со всем массивом символов
                    break;
                }
            }
            textArea.append(" = " + result);
        });
    }

    double plus(char[] array, char ch) {
        double left = 0; // первое число - до знака
        double right = 0; // второе число - после знака
        int count = 0; // счетчик символов до знака и после знака
        for (int i = 0; i < array.length; i++) { //обход массива слева до знака
            if (array[i] != ch) {
                count++;
            } else {
                String strLeft = new String(array, 0, count);
                left = Double.parseDouble(strLeft);
                break;
            }
        }
        count = 0;
        for (int i = array.length - 1; i >= 0; i--) { //обход массива справа до знака
            if (array[i] != ch) {
                count++;
            } else {
                String strRight = new String(array, array.length - count, count);
                right = Double.parseDouble(strRight);
                break;
            }
        }
        if (ch == '+'){
            return (left + right);
        }
        if (ch == '-'){
            return (left - right);
        }
        if (ch == 'x'){
            return (left * right);
        }
        if (ch == '/'){
            return (left / right);
        }
        return 0;

    }
}
