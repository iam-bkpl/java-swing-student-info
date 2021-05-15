import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class UserMenu {
    JFrame frame = new JFrame();
    // pannel's to add components

    // Getting user data in text
    JTextField textFirstName = null;
    JTextField textLastName = null;
    JTextField textAddress = null;
    JTextField textContact = null;
    JTextField textRollno = null;
    JTextField textJava = null;
    JTextField textMath = null;
    JTextField textEnglish = null;
    JTextField textMacro = null;

    // getting user data in radiobuttons
    JRadioButton btnMale = null;
    JRadioButton btnFemale = null;
    // To make one button work at a time
    ButtonGroup btnGender = null;
    // store miltiple data with select one feature
    JComboBox comboProgram = null;

    // Buttons
    JButton btnAdd = null;
    JButton btnDisplay = null;
    JButton btnReset = null;
    JButton btnCancel = null;

    UserMenu() throws IOException {
        frame = new JFrame("User Menu");
        // panels
        JPanel panelTop = new JPanel();
        JPanel panelGender = new JPanel();
        JPanel panelProgram = new JPanel();
        JPanel panelMain = new JPanel();
        JPanel panelButton = new JPanel();

        // labels
        JLabel lblFirstName = new JLabel("First Name :");
        JLabel lblLastName = new JLabel("Last Name :");
        JLabel lblGender = new JLabel("Gender :");

        JLabel lblAddress = new JLabel("Address :");
        JLabel lblContact = new JLabel("Contact :");
        JLabel lblRollno = new JLabel("Rollno :");
        JLabel lblProgram = new JLabel("Program :");

        // Marks
        JLabel lblJava = new JLabel("Java Mark :");
        JLabel lblMath = new JLabel("Math Mark :");
        JLabel lblEnglish = new JLabel("English Mark :");
        JLabel lblMacro = new JLabel("Macro Mark :");

        // text fields
        textFirstName = new JTextField(10);
        textLastName = new JTextField(10);
        textRollno = new JTextField(10);
        textAddress = new JTextField(10);
        textContact = new JTextField(10);
        // text for programs
        textJava = new JTextField(5);
        textMath = new JTextField(5);
        textEnglish = new JTextField(5);
        textMacro = new JTextField(5);

        // Gender
        btnGender = new ButtonGroup();
        btnMale = new JRadioButton("Male");
        btnFemale = new JRadioButton("Female");
        btnGender.add(btnMale);
        btnGender.add(btnFemale);

        // Program
        String[] programs = { "BCIS", "BCA", "BIT", "BSCIT", "BIM" };

        comboProgram = new JComboBox(programs);

        // setting size for panels
        panelGender.add(btnMale);
        panelGender.add(btnFemale);
        panelTop.setLayout(new GridLayout(12, 2, 10, 10));
        // panelGender.setLayout();
        panelProgram.setLayout(new GridLayout(4, 2, 10, 10));
        panelButton.setLayout(new FlowLayout());

        // buttons
        btnAdd = new JButton("Add");
        btnReset = new JButton("Reset");
        btnDisplay = new JButton("Display");
        btnCancel = new JButton("Cancel");

        // adding components to the panels
        panelTop.add(lblFirstName);
        panelTop.add(textFirstName);

        panelTop.add(lblLastName);
        panelTop.add(textLastName);

        // gender
        panelTop.add(lblGender);
        panelTop.add(panelGender);

        panelTop.add(lblAddress);
        panelTop.add(textAddress);

        panelTop.add(lblContact);
        panelTop.add(textContact);

        panelTop.add(lblRollno);
        panelTop.add(textRollno);

        panelTop.add(lblProgram);
        panelTop.add(comboProgram);

        // panelProgram.add(lblJava);
        // panelProgram.add(textJava);
        // panelProgram.add(lblMath);
        // panelProgram.add(textMath);
        // panelProgram.add(lblEnglish);
        // panelProgram.add(textEnglish);
        // panelProgram.add(lblMacro);
        // panelProgram.add(textMacro);

        panelTop.add(lblJava);
        panelTop.add(textJava);

        panelTop.add(lblMath);
        panelTop.add(textMath);

        panelTop.add(lblEnglish);
        panelTop.add(textEnglish);

        panelTop.add(lblMacro);
        panelTop.add(textMacro);

        panelMain.add(panelTop);
        panelMain.add(panelProgram);

        // adding buttons
        panelButton.add(btnAdd);
        panelButton.add(btnReset);
        panelButton.add(btnDisplay);
        panelButton.add(btnCancel);

        panelMain.add(panelButton);

        frame.add(panelMain);
        frame.setSize(400, 600);
        frame.setVisible(true);

        // adding action Listener to buttons
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // variables to store data that is entered in dashboard
                String firstName = textFirstName.getText().toString();
                String lastName = textLastName.getText().toString();
                String gender = "";
                String address = textAddress.getText().toString();
                String contact = textContact.getText().toString();
                String rollNo = textRollno.getText().toString();
                String program = comboProgram.getSelectedItem().toString();

                // marks
                String javaMarks = textJava.getText().toString();
                String mathMarks = textMath.getText().toString();
                String englishMarks = textEnglish.getText().toString();
                String macroMarks = textMacro.getText().toString();
                // Finding gender
                if (btnMale.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                // creating user object
                User user = new User();
                FileOperation fo = new FileOperation();

                // passing data entred in dashboard to the user object
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setGender(gender);
                user.setAddress(address);
                user.setContact(contact);
                user.setRollno(rollNo);
                user.setProgram(program);
                // marks
                user.setJavaMarks(javaMarks);
                user.setMathMarks(mathMarks);
                user.setEnglishMarks(englishMarks);
                user.setMacroMarks(macroMarks);
                try {
                    fo.writeFile(user);

                } catch (Exception io) {
                    io.printStackTrace();
                } finally {
                    JOptionPane.showMessageDialog(frame, "Added to the file", "Add", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        });

        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Display display = new Display();
                // JOptionPane.showMessageDialog(frame, "Data", "Display",
                // JOptionPane.INFORMATION_MESSAGE);

            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFirstName.setText("");
                textLastName.setText("");
                textRollno.setText("");
                textAddress.setText("");
                textContact.setText("");
                // text for programs
                textJava.setText("");
                textMath.setText("");
                textEnglish.setText("");
                textMacro.setText("");

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Are you sure want to cancel ?", "Cancel",
                        JOptionPane.OK_CANCEL_OPTION);
                new Login();
            }
        });

    }

    public static void main(String[] args) throws IOException {
        try {
            UserMenu userMenu = new UserMenu();

        } catch (NullPointerException e) {

            e.printStackTrace();
        }
    }
}