import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FundTransfer extends JFrame implements ActionListener {



        String pin;
        TextField textFieldTransferAmount;
        TextField textFieldAccountNumber;

        JButton transferButton, backButton;
        FundTransfer(String pin) {
            this.pin = pin;


            JLabel label1 = new JLabel("ENETR AMOUNT YOU WANT TO TRANSFER");
            label1.setForeground(Color.BLACK);
            label1.setFont(new Font("System", Font.BOLD, 16));
            label1.setBounds(260, 180, 400, 35);
            add(label1);

            textFieldTransferAmount = new TextField();
            textFieldTransferAmount.setBackground(new Color(65, 125, 128));
            textFieldTransferAmount.setForeground(Color.WHITE);
            textFieldTransferAmount.setBounds(260, 230, 320, 25);
            textFieldTransferAmount.setFont(new Font("Raleway", Font.BOLD, 22));
            add(textFieldTransferAmount);



            JLabel label2 = new JLabel("TO:  (account that will recieve the fund)");
            label2.setForeground(Color.BLACK);
            label2.setFont(new Font("System", Font.BOLD, 16));
            label2.setBounds(260, 270, 400, 35);
            add(label2);

            textFieldAccountNumber = new TextField();
            textFieldAccountNumber.setBackground(new Color(65, 125, 128));
            textFieldAccountNumber.setForeground(Color.WHITE);
            textFieldAccountNumber.setBounds(260, 310, 320, 25);
            textFieldAccountNumber.setFont(new Font("Raleway", Font.BOLD, 22));
            add(textFieldAccountNumber);



            transferButton = new JButton("Transfer");
            transferButton.setBounds(500, 460, 150, 35);
            transferButton.setBackground(new Color(65, 125, 128));
            transferButton.setForeground(Color.WHITE);
            transferButton.addActionListener(this);
            add(transferButton);

            backButton = new JButton("BACK");
            backButton.setBounds(500, 510, 150, 35);
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
                String amount = textFieldTransferAmount.getText();
                Date date = new Date();
                if (e.getSource()==transferButton){
                    if (textFieldTransferAmount.getText().equals("")){
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
            new FundTransfer("");
        }

    }



