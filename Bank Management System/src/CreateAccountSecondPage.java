import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CreateAccountSecondPage extends JFrame implements ActionListener {
    JComboBox comboBox,comboBox3,comboBox4,comboBox5;
    JRadioButton savingAccOption,currentAccOption;
    JButton submitButton,cancelButton;
    JTextField textInitialDeposit;
    String formno,accountNumber,pin;

    ButtonGroup accType;
    CreateAccountSecondPage(String formno,String accountNumber,String pin){
        super("APPLICATION FORM");


        this.accountNumber=accountNumber;
        this.pin=pin;
        this.formno = formno;

        JLabel labelReligion = new JLabel("Religion :");
        labelReligion.setFont(new Font("Raleway", Font.BOLD,18));
        labelReligion.setBounds(100,120,100,30);
        add(labelReligion);

        String religion[] = {"Muslim","Hindu","Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(216, 236, 236));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);


        JLabel labelIncome = new JLabel("Income : ");
        labelIncome.setFont(new Font("Raleway", Font.BOLD,18));
        labelIncome.setBounds(100,170,100,30);
        add(labelIncome);

        String income [] = {"Null","<1,50,000","<2,50,000", "5,00,000", "Uptp 10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(216, 236, 236));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,170,320,30);
        add(comboBox3);

        JLabel labelEducation = new JLabel("Educational : ");
        labelEducation.setFont(new Font("Raleway", Font.BOLD,18));
        labelEducation.setBounds(100,220,150,30);
        add(labelEducation);

        String educational [] = {"Non-Graduate","Graduate","Post-Graduate", "Doctrate", "Others"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(216, 236, 236));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,220,320,30);
        add(comboBox4);


        JLabel labelOccupation = new JLabel("Occupation : ");
        labelOccupation.setFont(new Font("Raleway", Font.BOLD,18));
        labelOccupation.setBounds(100,270,150,30);
        add(labelOccupation);

        String Occupation [] = {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox(Occupation);
        comboBox5.setBackground(new Color(216, 236, 236));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350,270,320,30);
        add(comboBox5);


        JLabel labelform = new JLabel("Form No : ");
        labelform.setFont(new Font("Raleway", Font.BOLD,14));
        labelform.setBounds(700,10,100,30);
        add(labelform);

        JLabel labelformText = new JLabel(formno);
        labelformText.setFont(new Font("Raleway", Font.BOLD,14));
        labelformText.setBounds(760,10,60,30);
        add(labelformText);



        JLabel labelAccDetail = new JLabel("Account Details");
        labelAccDetail.setFont(new Font("Raleway",Font.BOLD,22));
        labelAccDetail.setBounds(280,70,400,40);
        add(labelAccDetail);

        JLabel labelAccType = new JLabel("Account Type:");
        labelAccType.setFont(new Font("Raleway",Font.BOLD,18));
        labelAccType.setBounds(100,340,200,30);
        add(labelAccType);

        savingAccOption = new JRadioButton("Saving Account");
        savingAccOption.setFont(new Font("Raleway",Font.BOLD,16));
        savingAccOption.setBackground(new Color(215,252,252));
        savingAccOption.setBounds(100,370,150,30);
        add(savingAccOption);

        currentAccOption = new JRadioButton("Current Account");
        currentAccOption.setFont(new Font("Raleway",Font.BOLD,16));
        currentAccOption.setBackground(new Color(215,252,252));
        currentAccOption.setBounds(350,370,300,30);
        add(currentAccOption);

        accType = new ButtonGroup();
        accType.add(savingAccOption);
        accType.add(currentAccOption);


        JLabel labelCardNum = new JLabel("Card Number:");
        labelCardNum.setFont(new Font("Raleway",Font.BOLD,18));
        labelCardNum.setBounds(100,440,200,30);
        add(labelCardNum);

        JLabel labelCardNumText = new JLabel("XXXX-XXXX-XXXX-"+formno);
        labelCardNumText.setFont(new Font("Raleway",Font.BOLD,18));
        labelCardNumText.setBounds(350,440,250,30);
        add(labelCardNumText);


        JLabel labelPIN = new JLabel("PIN:");
        labelPIN.setFont(new Font("Raleway",Font.BOLD,18));
        labelPIN.setBounds(100,490,200,30);
        add(labelPIN);

        JLabel labelPINtext = new JLabel("XXXX");
        labelPINtext.setFont(new Font("Raleway",Font.BOLD,18));
        labelPINtext.setBounds(350,490,200,30);
        add(labelPINtext);


        JLabel labelInitialDeposit = new JLabel("Initial Deposit : ");
        labelInitialDeposit.setFont(new Font("Raleway", Font.BOLD,18));
        labelInitialDeposit.setBounds(100,540,150,30);
        add(labelInitialDeposit);


        JLabel minDep = new JLabel("( Minimum BDT.500/- ) ");
        minDep.setFont(new Font("Raleway", Font.BOLD,12));
        minDep.setBounds(100,560,150,30);
        add(minDep);


        textInitialDeposit = new JTextField();
        textInitialDeposit.setFont(new Font("Raleway",Font.BOLD, 14));
        textInitialDeposit.setBounds(350,540,200,30);
        add(textInitialDeposit);






        JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowledge.",true);
        c7.setBackground(new Color(215,252,252));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,640,600,20);
        add(c7);



        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Raleway", Font.BOLD,14));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(215,670,100,30);
        submitButton.addActionListener(this);
        add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Raleway", Font.BOLD,14));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(570,670,100,30);
        cancelButton.addActionListener(this);
        add(cancelButton);


        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(85, 188, 194));
        setVisible(true);
    }







    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == cancelButton) {
                //dispose();
                System.exit(0);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        String rel = (String) comboBox.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();


        if (e.getSource() == submitButton) {
           if(accType.getSelection()==null || textInitialDeposit.getText().isEmpty()){
               JOptionPane.showMessageDialog(this, "All fields must be filled");

           }else if(Double.parseDouble(textInitialDeposit.getText())<500){
               JOptionPane.showMessageDialog(this,"Initial Deposite Must be Minimum of 500/-");
           }
           else{
                try {
                    File file = new File("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Created Accounts.txt");
                    BufferedWriter writer;
                    try {

                        writer = new BufferedWriter(new FileWriter(file, true));
                        writer.write("Religion : " + rel + "\n");
                        writer.write("Income : " + inc + "\n");
                        writer.write("Education : " + edu + "\n");
                        writer.write("Occupation : " + occ + "\n");

                        if (savingAccOption.isSelected()) {
                            writer.write("Account Type : Savings" + "\n");
                        } else {
                            writer.write("Account Type : Current" + "\n");
                        }


                        writer.write("PIN Code : " + pin + "\n");
                        writer.write("Balance : " + textInitialDeposit.getText() + "\n");


                        writer.newLine();
                        writer.write("====================================================================");
                        writer.newLine();
                        writer.write("\n");


                        writer.close();
                        JOptionPane.showMessageDialog(null, "Account Number : " + accountNumber + "\nPIN Code : " + pin);
                        dispose();

                        new HomePage(accountNumber, pin);


                    } catch (Exception E) {
                        E.printStackTrace();
                    }


                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) {
        new CreateAccountSecondPage("","","");
    }

}

