import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    JFrame frame;
    JTextField field;
    JButton[] numbers=new JButton[10];
    JButton[] actions=new JButton[8];
    JButton add, sub, mul, div, dec, equ, del, clr;
    JPanel panel;
    Font font=new Font("Times New Roman", Font.BOLD, 30);
    double num1=0, num2=0, result=0;
    char operator;
    Main() {
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        field=new JTextField();
        field.setBounds(50, 25, 300, 50);
        field.setFont(font);
        field.setEditable(false);
        frame.add(field);

        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        clr=new JButton("clr");
        del=new JButton("del");
        dec=new JButton(".");
        equ=new JButton("=");

        actions[0]=add;
        actions[1]=sub;
        actions[2]=mul;
        actions[3]=div;
        actions[4]=dec;
        actions[5]=equ;
        actions[6]=del;
        actions[7]=clr;

        for (JButton j:actions) {
            j.addActionListener(this);
            j.setFont(font);
            j.setFocusable(false);
        }
        for (int i=0;i<10;i++) {
            numbers[i]=new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }
        panel=new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.BLUE);

        panel.add(numbers[0]);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);

        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mul);

        panel.add(numbers[0]);
        panel.add(dec);
        panel.add(equ);
        panel.add(div);

        panel.add(clr);
        panel.add(del);


        del.setBounds(50,430,145,50);
        clr.setBounds(205,430,145,50);
        frame.add(del);
        frame.add(clr);
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Main calc=new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<10; i++) {
            if (e.getSource()==numbers[i]) {
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==dec) {
            field.setText(field.getText().concat("."));
        }
        if (e.getSource()==add) {
            num1=Double.parseDouble(field.getText());
            operator='+';
            field.setText("");
        }
        if (e.getSource()==sub) {
            num1=Double.parseDouble(field.getText());
            operator='-';
            field.setText("");
        }
        if (e.getSource()==mul) {
            num1=Double.parseDouble(field.getText());
            operator='*';
            field.setText("");
        }
        if (e.getSource()==div) {
            num1=Double.parseDouble(field.getText());
            operator='/';
            field.setText("");
        }
        if (e.getSource()==equ) {
            num2=Double.parseDouble(field.getText());
            switch(operator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;

            }
            field.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource()==clr) {
            field.setText("");
        }
    }
}
