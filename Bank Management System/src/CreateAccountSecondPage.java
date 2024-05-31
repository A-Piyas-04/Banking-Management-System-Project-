import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountSecondPage extends JFrame implements ActionListener {
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textPan,textAadhar;
    JRadioButton r1,r2, e1,e2;
    JButton next,s,c;
    String formno;
    CreateAccountSecondPage(String formno){
        super("APPLICATION FORM");


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


        this.formno = formno;

        JLabel labelAccDetail = new JLabel("Account Details");
        labelAccDetail.setFont(new Font("Raleway",Font.BOLD,22));
        labelAccDetail.setBounds(280,70,400,40);
        add(labelAccDetail);

        JLabel labelAccType = new JLabel("Account Type:");
        labelAccType.setFont(new Font("Raleway",Font.BOLD,18));
        labelAccType.setBounds(100,340,200,30);
        add(labelAccType);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(new Color(215,252,252));
        r1.setBounds(100,370,150,30);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(new Color(215,252,252));
        r2.setBounds(350,370,300,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);


        JLabel labelCardNum = new JLabel("Card Number:");
        labelCardNum.setFont(new Font("Raleway",Font.BOLD,18));
        labelCardNum.setBounds(100,440,200,30);
        add(labelCardNum);

        JLabel labelCardNumText = new JLabel("XXXX-XXXX-XXXX-"+formno);
        labelCardNumText.setFont(new Font("Raleway",Font.BOLD,18));
        labelCardNumText.setBounds(330,440,250,30);
        add(labelCardNumText);


        JLabel labelPIN = new JLabel("PIN:");
        labelPIN.setFont(new Font("Raleway",Font.BOLD,18));
        labelPIN.setBounds(100,490,200,30);
        add(labelPIN);

        JLabel labelPINtext = new JLabel("XXXX");
        labelPINtext.setFont(new Font("Raleway",Font.BOLD,18));
        labelPINtext.setBounds(330,490,200,30);
        add(labelPINtext);


        JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowledge.",true);
        c7.setBackground(new Color(215,252,252));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,640,600,20);
        add(c7);



        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD,14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(215,670,100,30);
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD,14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(570,670,100,30);
        c.addActionListener(this);
        add(c);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(85, 188, 194));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource()== c){
                //dispose();
                System.exit(0);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();




        try{
            if (textPan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else {/*
                Connn c = new Connn();
                String q = "insert into Signuptwo values('"+formno+"', '"+rel+"', '"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+addhar+"','"+scitizen+"','"+eAccount+"')";
                c.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);*/
            }


        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new CreateAccountSecondPage("");
    }
}

