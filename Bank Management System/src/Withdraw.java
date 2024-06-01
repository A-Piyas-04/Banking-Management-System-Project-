import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {



    String pin;
    TextField textFieldWithdraw;

    JButton withdrawButton, backButton;
    Withdraw(String pin) {
        this.pin = pin;


        JLabel label1 = new JLabel("ENETR AMOUNT YOU WANT TO WITHDRAW");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(260, 180, 400, 35);
        add(label1);

        textFieldWithdraw = new TextField();
        textFieldWithdraw.setBackground(new Color(65, 125, 128));
        textFieldWithdraw.setForeground(Color.WHITE);
        textFieldWithdraw.setBounds(260, 230, 320, 25);
        textFieldWithdraw.setFont(new Font("Raleway", Font.BOLD, 22));
        add(textFieldWithdraw);

        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setBounds(500, 362, 150, 35);
        withdrawButton.setBackground(new Color(65, 125, 128));
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        backButton = new JButton("BACK");
        backButton.setBounds(500, 406, 150, 35);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);


        setLayout(null);
        setSize(900, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(129, 156, 135));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textFieldWithdraw.getText();
            Date date = new Date();
            if (e.getSource()==withdrawButton){
                if (textFieldWithdraw.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to WITHDRAW");
                }else {/*
                    Connn c = new Connn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Withdraw', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawn Successfully");
                    setVisible(false);
                    new main_Class(pin);*/
                }
            }else if (e.getSource()==backButton){
                /*setVisible(false);
                new main_Class(pin);*/
            }
        }catch (Exception E){   
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Withdraw("");
    }

    }
