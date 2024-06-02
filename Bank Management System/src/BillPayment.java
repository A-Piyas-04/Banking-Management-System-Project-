import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BillPayment extends JFrame implements ActionListener{



    Balance balance=new Balance();
    String pin;
    String accountNumber;
    TextField textFieldPaymentAmount;

    JButton gasBillPayButton,electricityPayButton, waterBillPayButton,backButton;
    BillPayment(String accountNumber,String pin) {
        this.pin = pin;
        this.accountNumber=accountNumber;


        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO PAY");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(30, 80, 400, 35);
        add(label1);

        textFieldPaymentAmount = new TextField();
        textFieldPaymentAmount.setBackground(new Color(65, 125, 128));
        textFieldPaymentAmount.setForeground(Color.WHITE);
        textFieldPaymentAmount.setBounds(30, 130, 320, 25);
        textFieldPaymentAmount.setFont(new Font("Raleway", Font.BOLD, 22));
        add(textFieldPaymentAmount);

        electricityPayButton = new JButton("Pay Electricity Bill");
        electricityPayButton.setBounds(415, 105, 200, 40);
        electricityPayButton.setBackground(new Color(65, 125, 128));
        electricityPayButton.setForeground(Color.WHITE);
        electricityPayButton.addActionListener(this);
        add(electricityPayButton);


        waterBillPayButton = new JButton("Pay Water Bill");
        waterBillPayButton.setBounds(415, 155, 200, 40);
        waterBillPayButton.setBackground(new Color(65, 125, 128));
        waterBillPayButton.setForeground(Color.WHITE);
        waterBillPayButton.addActionListener(this);
        add(waterBillPayButton);

        gasBillPayButton = new JButton("Pay Gas Bill");
        gasBillPayButton.setBounds(415, 205, 200, 40);
        gasBillPayButton.setBackground(new Color(65, 125, 128));
        gasBillPayButton.setForeground(Color.WHITE);
        gasBillPayButton.addActionListener(this);
        add(gasBillPayButton);



        backButton = new JButton("BACK");
        backButton.setBounds(80, 350, 150, 35);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);


        setLayout(null);
        setSize(700, 450);
        setLocation(450, 80);
        getContentPane().setBackground(new Color(107, 197, 181));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {



        try {
            String amount = textFieldPaymentAmount.getText();
            //Date date = new Date();
            if (e.getSource()==gasBillPayButton || e.getSource()==electricityPayButton|| e.getSource()==waterBillPayButton){
                if (textFieldPaymentAmount.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Pay");
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

                            if(e.getSource()==electricityPayButton){
                                writer.write("Electricity Bill: \tTk " + amount + "\t" + "("+formatDateTime+")" + "\t" +"Current Balance:"+ newBalance + "\t" );
                            }else if(e.getSource()==gasBillPayButton){
                                writer.write("Gas Bill: \tTk " + amount + "\t" + "("+formatDateTime+")" + "\t" +"Current Balance:"+ newBalance + "\t" );
                            }else if(e.getSource()==waterBillPayButton){
                                writer.write("Water Bill: \tTk " + amount + "\t" + "("+formatDateTime+")" + "\t" +"Current Balance:"+ newBalance + "\t" );
                            }

                            writer.newLine();
                            writer.close();

                            JOptionPane.showMessageDialog(null, "Bill Paid successfully!!");
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
        new BillPayment("","");
    }

}