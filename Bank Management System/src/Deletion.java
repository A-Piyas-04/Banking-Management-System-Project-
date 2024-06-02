import java.io.*;

public class Deletion {
    private String accountNumber;

    Deletion(String accountNumber){
        this.accountNumber = accountNumber;
        deleteAccount();
    }

    private void deleteAccount() {
        File signupFile = new File("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Create Account.txt");
        File tempFile = new File("D:\\OOP Project-Mark1\\Banking-Management-System-Project-\\Bank Management System\\src\\Temp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(signupFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean isDeleting = false;

            while((currentLine = reader.readLine()) != null) {
                if(currentLine.contains("Account Number: " + accountNumber)) {
                    isDeleting = true;
                }
                if(currentLine.trim().isEmpty()) {
                    isDeleting = false;
                }
                if(!isDeleting) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

            if (!signupFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(signupFile)) {
                System.out.println("Could not rename file");
            }

            File accountManagerFile = new File("src/bankManagement/accountManager" + accountNumber + ".txt");
            if (!accountManagerFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deletion("");
    }
}