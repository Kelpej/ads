package pr9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JLabel header;
    private JPanel mainPanel;
    private JTextField loginField;
    private JTextField passwordField;
    private JLabel status;
    private JButton loginButton;

    private String login;
    private String password;

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";


    public LoginForm() {
        setTitle("Practice 9");
        setContentPane(mainPanel);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = loginField.getText();
                password = passwordField.getText();
                if (login.equals(LOGIN) && password.equals(PASSWORD))
                    JOptionPane.showMessageDialog(mainPanel, "Authorized successful.");
                else
                    JOptionPane.showMessageDialog(mainPanel, "Authorization failed!");
            }
        });
    }

    public static void main(String[] args) {
        new LoginForm();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
