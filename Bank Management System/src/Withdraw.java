import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Withdraw extends JFrame implements ActionListener {

    Balance balance=new Balance();
    String accountNumber;
    String pin;
    TextField textFieldWithdraw;

    JButton withdrawButton, backButton;
    Withdraw(String accountNumber,String pin) {
        this.pin = pin;
        this.accountNumber=accountNumber;


        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(260, 180, 400, 35);
        add(label1);

        textFieldWithdraw = new TextField();
        textFieldWithdraw.setBackground(new Color(65, 125, 128));
        textFieldWithdraw.setForeground(Color.WHITE);
        textFieldWithdraw.setBounds(260, 230, 320, 25);
        textFieldWithdraw.setFont(new Font("Railway", Font.BOLD, 22));
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
            //Date date = new Date();
            if (e.getSource()==withdrawButton){
                if (textFieldWithdraw.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to WITHDRAW");
                }else {
                    String currentBalance = balance.CheckBalance(accountNumber, pin);
                    if (currentBalance == null) {
                        JOptionPane.showMessageDialog(null, "Could not retrieve current balance");
                    } else {
                    try {
                        Double currentBalanceInt = Double.parseDouble(currentBalance);
                        Double amountInt = Double.parseDouble(amount);
                        String newBalance = String.valueOf(currentBalanceInt - amountInt);
                        balance.updateBalance(accountNumber, pin, newBalance);

                        String accountNumber = this.accountNumber;
                        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Transactions\\" + accountNumber + ".txt", true));

                        LocalDateTime now = LocalDateTime.now();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formatDateTime = now.format(formatter);

                        writer.write("Withdraw: \tTk " + amount + "\t" + "("+formatDateTime+")" + "\t" +"Current Balance:"+ newBalance + "\t" );
                        writer.newLine();
                        writer.close();

                        JOptionPane.showMessageDialog(null, "Amount Withdrawn successfully");
                        this.setVisible(false);
                        new HomePage(accountNumber, pin).setVisible(true);
                    } catch (NumberFormatException E) {
                        JOptionPane.showMessageDialog(null, "Invalid number format");
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
                }
            }else if (e.getSource()==backButton){
                new HomePage(accountNumber,pin);
                dispose();
            }
        }catch (Exception E){   
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Withdraw("","");
    }

    }
