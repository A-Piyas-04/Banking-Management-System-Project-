import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TransactionHistory extends JFrame {
    String accountNumber, pin;
    JButton backButton;
    TransactionHistory(String accountNumber, String pin){
        this.accountNumber = accountNumber;
        this.pin = pin;

        setTitle("Transaction History");

        setLayout(new BorderLayout());

        JTextArea transaction= new JTextArea();
        transaction.setBounds(0, 0, 1000, 720);
        transaction.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transaction);
        add(scrollPane, BorderLayout.CENTER);

        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/Transaction_History/" + accountNumber + ".txt"));
            String line = reader.readLine();
            while (line != null){
                transaction.append(line + "\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        getContentPane().setBackground(new java.awt.Color(81, 117, 101));

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);


        backButton = new JButton("backButton");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Oswarld", Font.BOLD, 20));
        backButton.setBounds(600, 450, 250, 50);
        backButton.addActionListener(this::performAction);
        add(backButton, BorderLayout.SOUTH);

        revalidate();
        repaint();

    }

    public void performAction(java.awt.event.ActionEvent ae){
        if(ae.getSource() == backButton){
            new HomePage(accountNumber, pin).setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new TransactionHistory("", "");
    }
}
