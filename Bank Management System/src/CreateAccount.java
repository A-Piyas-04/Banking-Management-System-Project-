import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CreateAccount extends JFrame implements ActionListener {
    JRadioButton optionMale,optionFemale,optionMarried,optionUnMarried;
    JButton next;

    JTextField textName ,textFname, textEmail,textAdd,textcity,textZip;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);
    CreateAccount(){
        super ("APPLICATION FORM");


        JLabel label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD, 22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(300,190,400,30);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(100,240,200,30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD, 14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        JLabel DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100,290,200,30);
        add(labelG);





        optionMale = new JRadioButton("Male");
        optionMale.setFont(new Font("Raleway", Font.BOLD,14));
        optionMale.setBackground(new Color(222,255,228));
        optionMale.setBounds(300,290,60,30);
        add(optionMale);

        optionFemale = new JRadioButton("Female");
        optionFemale.setBackground(new Color(222,255,228));
        optionFemale.setFont(new Font("Raleway", Font.BOLD,14));
        optionFemale.setBounds(365,290,90,30);
        add(optionFemale);
        

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(optionMale);
        buttonGroup.add(optionFemale);

        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD, 14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);


        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        optionMarried = new JRadioButton("Married");
        optionMarried.setBounds(300,440,100,30);
        optionMarried.setBackground(new Color(222,255,228));
        optionMarried.setFont(new Font("Raleway", Font.BOLD,14));
        add(optionMarried);

        optionUnMarried = new JRadioButton("Unmarried");
        optionUnMarried.setBackground(new Color(222,255,228));
        optionUnMarried.setBounds(450,440,100,30);
        optionUnMarried.setFont(new Font("Raleway", Font.BOLD,14));
        add(optionUnMarried);



        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(optionMarried);
        buttonGroup1.add(optionUnMarried);


        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD, 14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD, 14));
        textcity.setBounds(300,540,400,30);
        add(textcity);

        JLabel labelZip = new JLabel("Zip Code :");
        labelZip.setFont(new Font("Raleway", Font.BOLD, 20));
        labelZip.setBounds(100,590,200,30);
        add(labelZip);

        textZip = new JTextField();
        textZip.setFont(new Font("Raleway",Font.BOLD, 14));
        textZip.setBounds(300,590,400,30);
        add(textZip);
        

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);

    }

    @Override
        public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource()== next){
                new CreateAccountSecondPage(first);
                dispose();
            }
        }catch(Exception E){
            E.printStackTrace();
        }
        /*
        String userChoice = (String) userChoiceInput.getSelectedItem();


        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(optionMale.isSelected()){
            gender = "Male";
        }else if (optionFemale.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital =null;
        if (optionMarried.isSelected()){
            marital = "Married";
        } else if (optionUnMarried.isSelected()) {
            marital = "Unmarried";
        }

        String address = textAdd.getText();
        String city = textcity.getText();
        String Zipcode = textZip.getText();
        String state = textState.getText();

        try{
            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else {
                Connn c = new Connn();
                String q = "insert into CreateNewAccount values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"', '"+address+"', '"+city+"','"+Zipcode+"','"+state+"' )";
                c.statement.executeUpdate(q);
                new CreateNewAccount2(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }*/

    }

    public static void main(String[] args) {
        new CreateAccount();
    }
}

