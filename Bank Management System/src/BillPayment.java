import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class BillPayment extends JFrame implements ActionListener{




    String pin;
    String accountNumber;
    TextField textFieldWithdraw;

    JButton gasBillPayButton,electricityPayButton, waterBillPayButton,backButton;
    BillPayment(String accountNumber,String pin) {
        this.pin = pin;
        this.accountNumber=accountNumber;


        JLabel label1 = new JLabel("ENETR AMOUNT YOU WANT TO PAY");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(30, 80, 400, 35);
        add(label1);

        textFieldWithdraw = new TextField();
        textFieldWithdraw.setBackground(new Color(65, 125, 128));
        textFieldWithdraw.setForeground(Color.WHITE);
        textFieldWithdraw.setBounds(30, 130, 320, 25);
        textFieldWithdraw.setFont(new Font("Raleway", Font.BOLD, 22));
        add(textFieldWithdraw);

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
            String amount = textFieldWithdraw.getText();
            Date date = new Date();
            if (e.getSource()==gasBillPayButton){
                if (textFieldWithdraw.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Pay");
                }else {/*
                    Connn c = new Connn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Withdraw', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawn Successfully");
                    setVisible(false);
                    new main_Class(pin);*/
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