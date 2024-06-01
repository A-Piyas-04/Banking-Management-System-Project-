import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1,button2,button3;
    login(){
        super("Bank Management System");


        label1 = new JLabel("WELCOME TO GOOGLY BANK");
        label1.setForeground(Color.CYAN);
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 38));
        label1.setBounds(150,25,650,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button1 = new JButton("LOG IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(390,310,100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(390,348,100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Create New Account");
        button3.setFont(new Font("Railway", Font.BOLD, 14));
        button3.setForeground(Color.orange);
        button3.setBackground(Color.BLACK);
        button3.setBounds(600,415,230, 30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon backbg1 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.jpg"));
        Image backbg2 = backbg1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon backbg3 = new ImageIcon(backbg2);
        JLabel backbgimage = new JLabel(backbg3);
        backbgimage.setBounds(0,0,850,480);
        add(backbgimage);


        setLayout(null);
        setSize(850,520);
        setLocation(450,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()== button3){
                new CreateAccount();
                dispose();

            } else if (e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new login();
    }

}