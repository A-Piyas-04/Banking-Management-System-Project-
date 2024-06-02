import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    Balance balance=new Balance();

    String accountNumber;
    String pin;
    TextField textField;

    JButton depositButton, backButton;

    Deposit(String accountNumber, String pin) {
        this.pin = pin;
        this.accountNumber = accountNumber;


        JLabel label1 = new JLabel("ENETR AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(260, 180, 400, 35);
        add(label1);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(260, 230, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        add(textField);

        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(500, 362, 150, 35);
        depositButton.setBackground(new Color(65, 125, 128));
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(this);
        add(depositButton);

        backButton = new JButton("BACK");
        backButton.setBounds(500, 406, 150, 35);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);


        setLayout(null);
        setSize(900, 750);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(53, 129, 76));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource() == depositButton) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                } else {
                    String currentBalance = balance.CheckBalance(accountNumber, pin);
                    if (currentBalance == null) {
                        JOptionPane.showMessageDialog(null, "Could not retrieve current balance");
                    } else {
                        try {
                            Double currentBalanceInt = Double.parseDouble(currentBalance);
                            Double amountInt = Double.parseDouble(amount);
                            String newBalance = String.valueOf(currentBalanceInt + amountInt);
                            balance.updateBalance(accountNumber, pin, newBalance);

                            String accountNumber = this.accountNumber;
                            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Transactions\\" + accountNumber + ".txt", true));

                            LocalDateTime now = LocalDateTime.now();

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formatDateTime = now.format(formatter);

                            writer.write("Deposit: \tTk " + amount + "\t" + "("+formatDateTime+")" + "\t" +"Current Balance:"+ newBalance + "\t" );
                            writer.newLine();
                            writer.close();

                            JOptionPane.showMessageDialog(null, "Amount deposited successfully");
                            this.setVisible(false);
                            new HomePage(accountNumber, pin).setVisible(true);
                        } catch (NumberFormatException E) {
                            JOptionPane.showMessageDialog(null, "Invalid number format");
                        } catch (Exception E) {
                            E.printStackTrace();
                        }
                    }
                }
            }
        else if (e.getSource() == backButton) {
            new HomePage(accountNumber, pin);
            dispose();
        }
    }catch(
    Exception E)

    {
        E.printStackTrace();
    }

}


    public static void main(String[] args) {

        new Deposit("","");
    }
}
