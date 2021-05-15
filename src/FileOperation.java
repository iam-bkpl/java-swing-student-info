import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;

public class FileOperation {
    public void writeFile(User user) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("student_data.txt", true));
            String data = user.firstName + " " + user.lastName + " " + user.gender + " " + user.address + " "
                    + user.contact + " " + user.rollNo + " " + user.program + " " + user.javaMarks + " "
                    + user.mathMarks + " " + user.englishMarks + " " + user.macroMarks + "\n";
            bw.write(data);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> readFile() {

        ArrayList<User> list = new ArrayList<User>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("student_data.txt"));
            String line = br.readLine();

            while (line != null) {
                User user = new User();
                String[] arr = line.split(" ");

                user.setFirstName(arr[0]);
                user.setLastName(arr[1]);
                user.setGender(arr[2]);
                user.setAddress(arr[3]);
                user.setContact(arr[4]);
                user.setRollno(arr[5]);
                user.setProgram(arr[6]);
                user.setJavaMarks(arr[7]);
                user.setMathMarks(arr[8]);
                user.setEnglishMarks(arr[9]);
                user.setMacroMarks(arr[10]);

                list.add(user);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
       
    }
}
