import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class Login {
  String username = "admin";
  char[] password = "password".toCharArray();
  String message = " ";

  JTextField inputUsername;
  JPasswordField inputPassword;

  public void setupPanel() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    JLabel labelUsername = new JLabel("Username: ");
    JLabel labelPassword = new JLabel("Password:");
    inputUsername = new JTextField(20);
    inputPassword = new JPasswordField(20);

    JButton loginButton = new JButton("Login");
    loginButton.addActionListener(new LoginListener());

    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new CancelListener());

    panel.add(labelUsername);
    panel.add(inputUsername);
    panel.add(labelPassword);
    panel.add(inputPassword);
    panel.add(loginButton);
    panel.add(cancelButton);

    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  public class LoginListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (username.equals(inputUsername.getText()) && Arrays.equals(password, inputPassword.getPassword())) {
        message = "Login successful!";
      } else {
        message = "Login failed!";
      }
      JOptionPane.showMessageDialog(null, message);
    }
  }

  public class CancelListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      inputUsername.setText("");
      inputPassword.setText("");
      inputUsername.requestFocus();
    }
  }

  public static void main(String[] args) {
    Login login = new Login();
    login.setupPanel();
  }
}