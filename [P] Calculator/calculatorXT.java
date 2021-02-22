import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculatorXT extends JFrame implements ActionListener
{
    JPanel panel;
    TextField t1;
    JButton btn[] = new JButton[16];
    String str[] = {"7","8","9","-","4","5","6","+","1","2","3","*","C","0","=","/"};
    int i , num1=0 , num2=0 , result=0;
    char op;
    calculatorXT()
    {
        panel = new JPanel();
        add(panel);
        t1 = new TextField(10);
        panel = new JPanel();
        add(t1,"North");
        add(panel,"Center");
        panel.setLayout(new GridLayout(4,4));
        for(i=0;i<16;i++)
        {
            btn[i] = new JButton(str[i]);
            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String str = ae.getActionCommand();
        if(str.equals("+"))
        {
            op = '+';
            num1 = Integer.parseInt(t1.getText());
            t1.setText("");
        }
        else if(str.equals("-"))
        {
            op = '-';
            num1 = Integer.parseInt(t1.getText());
            t1.setText("");
        }
        else if(str.equals("*"))
        {
            op = '*';
            num1 = Integer.parseInt(t1.getText());
            t1.setText("");
        }
        else if(str.equals("/"))
        {
            op = '/';
            num1 = Integer.parseInt(t1.getText());
            t1.setText("");
        }
        else if(str.equals("="))
        {
            num2 = Integer.parseInt(t1.getText());
            switch(op)
            {
                case '+' : 
                {
                    result = num1 + num2;
                    break;
                }
                case '-' :
                {
                    result = num2 - num1;
                    break;
                    
                }
                case '*' :
                {
                    result = num1 * num2;
                    break;
                }
                case '/' :
                {
                    try
                    {
                        result = num1 / num2 ;
                        break ; 
                    }
                    catch(ArithmeticException e)
                    {
                        System.out.println("Error");
                    }
                }
            }
            t1.setText(result + "");
            result=0;
        }
        else if(str.equals("C"))
        {
            t1.setText("");
            num1 = 0;
            num2 = 0; 
        }
        else
        {
            t1.setText(t1.getText() + str);
        }
    }
    public static void main(String[] args) 
    {
        calculatorXT m = new calculatorXT();
        m.setTitle("Calculator");
        m.setSize(400,400);
        m.setVisible(true);
    }
}