import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class CreateAccount extends JFrame implements ActionListener {
    JRadioButton optionMale,optionFemale,optionMarried,optionUnMarried;
    JButton next;

    JTextField textName ,textFname, textEmail,textAdd,textcity,textZip;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) +1000L;

    public String getFirst() {
        return first;
    }

    String first = " " + Math.abs(first4);
    CreateAccount(){
        super ("APPLICATION FORM");


        JLabel label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);


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
        

        ButtonGroup genderOptions = new ButtonGroup();
        genderOptions.add(optionMale);
        genderOptions.add(optionFemale);


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



        ButtonGroup marriageOptions = new ButtonGroup();
        marriageOptions.add(optionMarried);
        marriageOptions.add(optionUnMarried);


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
    //====================================================================================================

    @Override
        public void actionPerformed(ActionEvent A) {

        try {
            if (A.getSource() == next) {

                //===============================================================
                if (textName.getText().isEmpty() || textFname.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(this, "All fields must be filled before proceeding.");
                } else {
                    File file = new File("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Created Accounts.txt");
                    BufferedWriter writer;
                    try {

                        String pias = String.valueOf(dateChooser.getDate());


                        writer = new BufferedWriter(new FileWriter(file,true));
                        writer.write("Name: " + textName.getText() + "\n");
                        writer.write("Father's Name: " + textFname.getText() + "\n");
                        writer.write("Date of Birth :"+pias+"\n");

                        if (optionMale.isSelected()){
                            writer.write("Gender: male" + "\n");
                        } else {
                            writer.write("Gender: female" + "\n");
                        }

                        if (optionMarried.isSelected()){
                            writer.write("Maritial Status : Married" + "\n");
                        } else {
                            writer.write("Maritial Status : Unmarried" + "\n");
                        }

                        writer.write("Address : " + textAdd.getText() + "\n");
                        writer.write("City : " + textcity.getText() + "\n");
                        writer.write("Zip Code : " + textZip.getText() + "\n");
                        writer.write("Email : " + textEmail.getText() + "\n");

                        writer.close();

                        new CreateAccountSecondPage(first);
                        dispose();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }


                }
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

            public static void main (String[] args){
                new CreateAccount();
            }
}
