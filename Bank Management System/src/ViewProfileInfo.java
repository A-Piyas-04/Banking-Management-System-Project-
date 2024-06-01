import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewProfileInfo extends JFrame {

    JButton backButton;
    String accountNumber, pin;


    ViewProfileInfo(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;

        setTitle("View Personal Information");

        setLayout(new GridLayout(0, 1));

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Created Accounts.txt"));
            String line;
            boolean accountFound = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Account Number : " + accountNumber)) {
                    accountFound = true;
                }

                if (accountFound) {
                    String[] parts = line.split(" : ");
                    if (parts.length >= 2) {
                        String attribute = parts[0];
                        String value = parts[1];

                        JLabel label = new JLabel(attribute + " : " + value);
                        label.setFont(new Font("Monospaced Plain", Font.BOLD, 17));
                        add(label);
                    }
                }

                if (accountFound && line.isEmpty()) {
                    break;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    backButton.doClick();
                }
            }
        });

        backButton = new JButton("backButton");
        backButton.setFont(new Font("DialogInput", Font.BOLD, 19));
        backButton.setBounds(300, 400, 150, 35);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this::performAction);
        add(backButton);

        setSize(1080, 720);
        setLocation(220, 40);
        setVisible(true);
    }

    public void performAction(java.awt.event.ActionEvent ae) {
        if (ae.getActionCommand().equals("backButton")) {
            new HomePage(accountNumber, pin).setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new ViewProfileInfo("1409963064786751-null","916");
    }

}