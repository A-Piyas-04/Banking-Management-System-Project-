import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    JLabel label1, labelCard, labelPin;
    JTextField accNumField;
    JPasswordField pinTextField;

    JButton logInButton,clearButton,createAccButton;
    login(){
        super("Bank Management System");


        label1 = new JLabel("WELCOME TO GOOGLY BANK");
        label1.setForeground(Color.CYAN);
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 38));
        label1.setBounds(150,25,650,40);
        add(label1);

        labelCard = new JLabel("Card No:");
        labelCard.setFont(new Font("Ralway", Font.BOLD, 28));
        labelCard.setForeground(Color.WHITE);
        labelCard.setBounds(150,190,375,30);
        add(labelCard);

        accNumField = new JTextField(15);
        accNumField.setBounds(325,190,230,30);
        accNumField.setFont(new Font("Arial", Font.BOLD,14));
        add(accNumField);

        labelPin = new JLabel("PIN: ");
        labelPin.setFont(new Font("Ralway", Font.BOLD, 28));
        labelPin.setForeground(Color.WHITE);
        labelPin.setBounds(150,250,375,30);
        add(labelPin);

        pinTextField = new JPasswordField(15);
        pinTextField.setBounds(325,250,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        logInButton = new JButton("LOG IN");
        logInButton.setFont(new Font("Arial", Font.BOLD, 14));
        logInButton.setForeground(Color.WHITE);
        logInButton.setBackground(Color.BLACK);
        logInButton.setBounds(390,310,100, 30);
        logInButton.addActionListener(this);
        add(logInButton);

        clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLACK);
        clearButton.setBounds(390,348,100, 30);
        clearButton.addActionListener(this);
        add(clearButton);

        createAccButton = new JButton("Create New Account");
        createAccButton.setFont(new Font("Railway", Font.BOLD, 14));
        createAccButton.setForeground(Color.orange);
        createAccButton.setBackground(Color.BLACK);
        createAccButton.setBounds(600,415,230, 30);
        createAccButton.addActionListener(this);
        add(createAccButton);

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
            if(e.getSource()== createAccButton){
                new CreateAccount();
                dispose();

            } else if (e.getSource() == clearButton){
                accNumField.setText("");
                pinTextField.setText("");
            }else if (e.getSource() == logInButton){

                if(accNumField.getText().isEmpty() || pinTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please Enter your Card and Pin no.");
                }else{
                    new HomePage(accNumField.getText(),pinTextField.getText());
                    dispose();
                }
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new login();
    }

}