import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class Display {
    JFrame displayFrame = null;
    JTable table = null;
    DefaultTableModel model = null;

    public void Display() {
        displayFrame = new JFrame(" *** Student's Data *** ");
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        table.setSize(800, 800);

        displayFrame.add(sp);
        displayFrame.setSize(800, 600);
        displayFrame.setLocation(450, 0);

        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Gender");
        model.addColumn("Address");
        model.addColumn("Contact");
        model.addColumn("Roll No");
        model.addColumn("Program");
        model.addColumn("Java Marks");
        model.addColumn("Math Marks");
        model.addColumn("English Marks");
        model.addColumn("Macro Marks");

        // working with files
        ArrayList<User> list = new ArrayList<User>();
        FileOperation fo = new FileOperation();

        list = fo.readFile();
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(displayFrame, "File is empty Please add some data to display", "Empty File",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            table = new JTable(model);

            for (int i = 0; i < list.size(); i++) {
                User user = new User();
                user = list.get(i);
                model.addRow(new Object[] { user.getFirstName(), user.getLastName(), user.getGender(),
                        user.getAddress(), user.getContact(), user.getRollNo(), user.getProgram(), user.getJavaMarks(),
                        user.getMathMarks(), user.getEnglishMarks(), user.getMacroMarks()

                });

            }
            displayFrame.setVisible(true);
        }
    }
}
