import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Balance{

    public String CheckBalance(String accountNumber, String pin) {
        File file = new File("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Created Accounts.txt");
        //String value = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String currentAccountNumber = null;
            String currentPin=null;
            

            while((line = reader.readLine()) != null) {
                String[] parts = line.split(" : ");
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];

                    if (key.equals("Account Number")) {
                        currentAccountNumber = value;
                    } else if (key.equals("PIN Code")) {
                        currentPin = value;
                    } else if (key.equals("Balance") && currentAccountNumber.equals(accountNumber) && currentPin.equals(pin)) {
                        return value;
                    }
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public void updateBalance(String accountNumber, String pin, String newBalance) {
        File file = new File("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Created Accounts.txt");

        try {
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String currentAccountNumber = null;
            String currentpin = null;

            while((line = reader.readLine()) != null) {
                String[] parts = line.split(" : ");
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];

                    if (key.equals("Account Number")) {
                        currentAccountNumber = value;
                    } else if (key.equals("PIN Code")) {
                        currentpin = value;
                    } else if (key.equals("Balance") && currentAccountNumber.equals(accountNumber) && currentpin.equals(pin)) {
                        line = "Balance : " + newBalance;
                    }
                }
                lines.add(line);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String line2 : lines) {
                writer.write(line2 + System.getProperty("line.separator"));
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

