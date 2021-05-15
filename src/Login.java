import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Login {
    String defalutUsername = "admin";
    String defaultPassword = "admin";

    // Frame to store everything
    JFrame frame = null;

    // empty space where user can write text
    JTextField textUsername = null;
    JPasswordField psdPassword = null;

    // Buttons
    JButton buttonLogin = null;
    JButton buttonSignup = null;

    Login() {
        // panel to add components
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();
        JPanel panelMain = new JPanel();

        JLabel labelUsername = new JLabel();
        JLabel labelPassword = new JLabel();

        // name of the frame
        frame = new JFrame("Login");
        // size of the frame in px

        // text that a user can see
        labelUsername = new JLabel("Username :");
        labelPassword = new JLabel("Password :");

        // space to enter user data
        textUsername = new JTextField(10);
        psdPassword = new JPasswordField(10);

        // Buttons
        buttonLogin = new JButton("Login");

        // GridLayout gl = new GridLayout(2, 2, 10, 10);

        // adding components in panelTop where the top part are stored
        panelTop.add(labelUsername);
        panelTop.add(textUsername);
        panelTop.add(labelPassword);
        panelTop.add(psdPassword);

        // adding buttons in panelBottom
        panelBottom.add(buttonLogin);
        // panelBottom.add(buttonSignup);

        // panelTop.setLayout(gl);
        panelTop.setLayout(new GridLayout(2, 2, 10, 10));

        panelMain.add(panelTop);
        panelMain.add(panelBottom);
        // adding components in jframe
        frame.setSize(300, 150);
        frame.add(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // When the login button is clicked it will Trigger this

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = textUsername.getText().toString();

                String password = new String(psdPassword.getPassword()).toString();

                if ((defalutUsername.equals(username)) && (defaultPassword.equals(password))) {
                    // JOptionPane.showMessageDialog(frame, "Login Successful", "Login",
                    // JOptionPane.INFORMATION_MESSAGE);
                    // try {
                        UserMenu userMenu = new UserMenu();
                    // }catch (IOException e) {
                    //     e.printStackTrace();
                    // }
                } else {
                    JOptionPane.showMessageDialog(frame, "No ID found with the data you provided! Better sign up",
                            "Login", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }
}