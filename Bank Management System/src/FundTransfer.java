import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FundTransfer extends JFrame implements ActionListener {


        Balance balance=new Balance();
        String accountNumber;
        String pin;
        TextField textFieldTransferAmount;
        TextField textFieldAccountNumber;

        JButton transferButton, backButton;
        FundTransfer(String accountNumber,String pin) {
            this.pin = pin;
            this.accountNumber=accountNumber;


            JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO TRANSFER");
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



            JLabel label2 = new JLabel("TO:  (account that will receive the fund)");
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
            String transferAccountNumber=textFieldAccountNumber.getText();
            try {
                String amount = textFieldTransferAmount.getText();
                
                if (e.getSource()==transferButton){
                    if (textFieldTransferAmount.getText().equals("") || textFieldAccountNumber.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please enter the Amount and Account No. to transfer Fund");
                    }else {               
                        String currentBalance = balance.CheckBalance(accountNumber, pin);
                        if (currentBalance == null) {
                            JOptionPane.showMessageDialog(null, "Could not retrieve current balance");
                        } else {
                            try {
                                Double currentBalanceInt = Double.parseDouble(currentBalance);
                                Double amountInt = Double.parseDouble(amount);
                                if (currentBalanceInt < amountInt) {
                                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                                } else {
                                    String newBalance = String.valueOf(currentBalanceInt - amountInt);
                                    balance.updateBalance(accountNumber, pin, newBalance);

                                    LocalDateTime now = LocalDateTime.now();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                    String formatDateTime = now.format(formatter);

                                    String accountNumber = this.accountNumber;
                                    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Transactions\\" + accountNumber + ".txt", true));
                                    writer.write("Transferred: \tTk" + amount + "\t" + formatDateTime + "\t" + newBalance + "\tTransferred to " + transferAccountNumber);
                                    writer.newLine();
                                    writer.close();

                                    String transferAccountBalance = balance.getTransferCurrentBalance(transferAccountNumber);
                                    if (transferAccountBalance == null) {
                                        JOptionPane.showMessageDialog(null, "Could not retrieve transfer account balance");
                                    } else {
                                        Double transferAccountBalanceInt = Double.parseDouble(transferAccountBalance);
                                        String newTransferAccountBalance = String.valueOf(transferAccountBalanceInt + amountInt);
                                        balance.transferBalance(transferAccountNumber, newTransferAccountBalance);

                                        BufferedWriter transferWriter = new BufferedWriter(new FileWriter("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Transactions\\" + transferAccountNumber + ".txt", true));
                                        transferWriter.write("Received: \tTk" + amount + "\t" + formatDateTime + "\t" + newTransferAccountBalance + "\tReceived from " + accountNumber);
                                        transferWriter.newLine();
                                        transferWriter.close();

                                        JOptionPane.showMessageDialog(null, "Amount transferred successfully");
                                        this.setVisible(false);
                                        new HomePage(accountNumber,pin).setVisible(true);
                                    }
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid amount");
                            } catch (Exception ex){
                                ex.printStackTrace();
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
            new FundTransfer("","");
        }

    }



