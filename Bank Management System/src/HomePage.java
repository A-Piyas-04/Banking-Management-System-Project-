import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    JButton depositButton,withdrawButton,fundTransferButton,loanButton,billPaymentButton,viewInfoButton,exitButton,transactionHistoryButton,balanceButton;
    String accountNumber;
    HomePage(String accountNumber){
        super("Home Page");
        this.accountNumber=accountNumber;

        depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Raleway",Font.BOLD, 20));
        depositButton.setBackground(Color.BLACK);
        depositButton.setForeground(Color.ORANGE);
        depositButton.setBounds(70,180,200,40);
        depositButton.addActionListener(this);
        add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Raleway",Font.BOLD, 20));
        withdrawButton.setBackground(Color.BLACK);
        withdrawButton.setForeground(Color.ORANGE);
        withdrawButton.setBounds(70,230,200,40);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        fundTransferButton = new JButton("Fund Transfer");
        fundTransferButton.setFont(new Font("Raleway",Font.BOLD, 20));
        fundTransferButton.setBackground(Color.BLACK);
        fundTransferButton.setForeground(Color.ORANGE);
        fundTransferButton.setBounds(70,280,200,40);
        fundTransferButton.addActionListener(this);
        add(fundTransferButton);


        loanButton = new JButton("Loan");
        loanButton.setFont(new Font("Raleway",Font.BOLD, 20));
        loanButton.setBackground(Color.BLACK);
        loanButton.setForeground(Color.ORANGE);
        loanButton.setBounds(70,390,200,40);
        loanButton.addActionListener(this);
        add(loanButton);


        billPaymentButton = new JButton("Bill Payment");
        billPaymentButton.setFont(new Font("Raleway",Font.BOLD, 20));
        billPaymentButton.setBackground(Color.BLACK);
        billPaymentButton.setForeground(Color.ORANGE);
        billPaymentButton.setBounds(70,440,200,40);
        billPaymentButton.addActionListener(this);
        add(billPaymentButton);


        viewInfoButton = new JButton("View Personal Information");
        viewInfoButton.setFont(new Font("Raleway",Font.BOLD, 17));
        viewInfoButton.setBackground(Color.BLACK);
        viewInfoButton.setForeground(Color.ORANGE);
        viewInfoButton.setBounds(540,220,300,50);
        viewInfoButton.addActionListener(this);
        add(viewInfoButton);

        transactionHistoryButton = new JButton("View Transaction History");
        transactionHistoryButton.setFont(new Font("Raleway",Font.BOLD, 17));
        transactionHistoryButton.setBackground(Color.BLACK);
        transactionHistoryButton.setForeground(Color.ORANGE);
        transactionHistoryButton.setBounds(540,280,300,50);
        transactionHistoryButton.addActionListener(this);
        add(transactionHistoryButton);


        balanceButton = new JButton("Check Balance");
        balanceButton.setFont(new Font("Raleway",Font.BOLD, 17));
        balanceButton.setBackground(Color.BLACK);
        balanceButton.setForeground(Color.ORANGE);
        balanceButton.setBounds(540,340,300,50);
        balanceButton.addActionListener(this);
        add(balanceButton);


        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("DialogInput",Font.BOLD, 20));
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.RED);
        exitButton.setBounds(310,600,180,55);
        exitButton.addActionListener(this);
        add(exitButton);





        JLabel label3 = new JLabel("Account No."+this.accountNumber);
        label3.setFont(new Font("Raleway", Font.BOLD,32));
        label3.setBounds(240,20,600,35);
        add(label3);


        setLayout(null);
        setSize(900,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(176, 170, 143));
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage("324435245");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
