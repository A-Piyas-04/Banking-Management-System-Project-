import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {


    JButton depositButton,withdrawButton,fundTransferButton,loanButton,billPaymentButton,viewInfoButton,
    transactionHistoryButton,balanceButton,deleteButton,logOutButton;
    String accountNumber;
    String pin;
    HomePage(String accountNumber,String pin){
        super("Home Page");
        this.accountNumber=accountNumber;
        this.pin=pin;

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



        logOutButton = new JButton("Logout");
        logOutButton.setFont(new Font("DialogInput",Font.BOLD, 20));
        logOutButton.setBackground(Color.BLACK);
        logOutButton.setForeground(Color.RED);
        logOutButton.setBounds(0,655,180,55);
        logOutButton.addActionListener(this);
        add(logOutButton);


        deleteButton = new JButton("Delete Account");
        deleteButton.setFont(new Font("DialogInput",Font.BOLD, 20));
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.RED);
        deleteButton.setBounds(680,655,210,55);
        deleteButton.addActionListener(this);
        add(deleteButton);






        JLabel labelAccNum = new JLabel("Account No."+this.accountNumber);
        labelAccNum.setFont(new Font("Raleway", Font.BOLD,32));
        labelAccNum.setBounds(240,20,600,35);
        add(labelAccNum);


        setLayout(null);
        setSize(900,750);
        setLocation(450,75);
        getContentPane().setBackground(new Color(176, 170, 143));
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==depositButton){
            new Deposit(accountNumber,pin);
            dispose();
        }else if(e.getSource()==withdrawButton){
            new Withdraw(accountNumber,pin);
            dispose();
        }else if(e.getSource()==fundTransferButton){
            new FundTransfer(accountNumber,pin);
            dispose();
        }else if(e.getSource()==billPaymentButton){
            new BillPayment(accountNumber,pin);
            dispose();
        }else if(e.getSource()==viewInfoButton){
            new ViewProfileInfo(accountNumber,pin);
            dispose();
        }else if(e.getSource()==transactionHistoryButton){
            new TransactionHistory(accountNumber,pin);
            dispose();
        }else if(e.getSource()==logOutButton){
            new login();
            dispose();
        }else if(e.getSource()==loanButton){
            new Loan(accountNumber,pin);
            dispose();
        }else if(e.getSource()==balanceButton){
            Balance balance = new Balance();
            String currentBalance=balance.CheckBalance(accountNumber,pin);
            JOptionPane.showMessageDialog(null,"Your Current Balance : "+currentBalance);

        }else if(e.getSource()==deleteButton){
            new Deletion(accountNumber);
            JOptionPane.showMessageDialog(null,"Account Deleted Successfully");
            dispose();
            new login();
        }
    }
    public static void main(String[] args) {
       new HomePage("","");
    }


}
