import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    String accountNumber;
    HomePage(String accountNumber){
        super("Home Page");
        this.accountNumber=accountNumber;


        JLabel label3 = new JLabel("Account No."+this.accountNumber);
        label3.setFont(new Font("Raleway", Font.BOLD,22));
        label3.setBounds(200,50,600,30);
        add(label3);


        setLayout(null);
        setSize(900,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(53, 129, 76));
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage("324435245");
    }
}
