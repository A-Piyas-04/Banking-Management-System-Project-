import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loan extends JFrame implements ActionListener {


    Balance balance=new Balance();
    String pin;
    String accountNumber;
    TextField textFieldLoanAmount;
    JRadioButton for6monthsButton,for12monthsButton;

    JButton getLoanButton, backButton;
    Loan(String accountNumber,String pin) {
        this.accountNumber=accountNumber;
        this.pin = pin;





        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO TAKE LOAN");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 27));
        label1.setBounds(170, 100, 700, 55);
        add(label1);

        textFieldLoanAmount = new TextField();
        textFieldLoanAmount.setBackground(new Color(208, 218, 218));
        textFieldLoanAmount.setForeground(Color.BLACK);
        textFieldLoanAmount.setBounds(272, 150, 320, 45);
        textFieldLoanAmount.setFont(new Font("Raleway", Font.BOLD, 25));
        add(textFieldLoanAmount);

        for6monthsButton = new JRadioButton("For 6 months (5% interest)");
        for6monthsButton.setFont(new Font("Raleway", Font.BOLD,14));
        for6monthsButton.setBackground(new Color(129, 156, 135));
        for6monthsButton.setBounds(200,290,250,30);
        add(for6monthsButton);

        for12monthsButton = new JRadioButton("For 12 months (10% interest)");
        for12monthsButton.setBackground(new Color(129, 156, 135));
        for12monthsButton.setFont(new Font("Raleway", Font.BOLD,14));
        for12monthsButton.setBounds(500,290,250,30);
        add(for12monthsButton);


        ButtonGroup genderOptions = new ButtonGroup();
        genderOptions.add(for6monthsButton);
        genderOptions.add(for12monthsButton);

        getLoanButton = new JButton("GET LOAN");
        getLoanButton.setBounds(355, 362, 150, 35);
        getLoanButton.setBackground(new Color(65, 125, 128));
        getLoanButton.setForeground(Color.WHITE);
        getLoanButton.addActionListener(this);
        add(getLoanButton);

        backButton = new JButton("BACK");
        backButton.setBounds(355, 406, 150, 35);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setLayout(null);
        setSize(900, 630);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(129, 156, 135));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textFieldLoanAmount.getText();
            //Date date = new Date();
            if (e.getSource()==getLoanButton){
                if (textFieldLoanAmount.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to WITHDRAW");
                }else {
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

                            writer.write("Loan: \tTk " + amount + "\t" + "("+formatDateTime+")" + "\t" +"Current Balance:"+ newBalance + "\t" );
                            writer.newLine();
                            writer.close();

                            JOptionPane.showMessageDialog(null, "Loan Taken successfully");
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
        new Loan("","");
    }

}
