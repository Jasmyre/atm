import javax.swing.*;
import javax.swing.border.AbstractBorder;

import java.awt.*;

public class App {
  public static class HomeGUI {
    HomeGUI() {

    }
  }

  public static class RegisterGUI {
    JFrame frame = new JFrame("Register");
    JLabel registerHeader = new JLabel("<html><h1 style='font-weight; bold;'>Create Account</h1></html>");
    JTextField userInput = new JTextField();
    JPasswordField passInput = new JPasswordField();
    JLabel userPlaceholder = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Name:</h3></html>");
    JLabel passPlaceholder = new JLabel("<html><h3 style='padding: 0; margin: 0; color: #666666;'>Pin:</h3></html>");
    JButton registerBtn = new JButton("Register");
    JPanel header = new JPanel();
    JPanel main = new JPanel();

    GridBagConstraints gbc = new GridBagConstraints();


    RegisterGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        
        header.setLayout(new GridBagLayout());
        main.setLayout(new GridBagLayout());

        gbc.insets = new Insets(0, 0, 0, 0);

        // HEADER
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 24, 0);
        main.add(registerHeader, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = new GridBagConstraints().HORIZONTAL;
        gbc.insets = new Insets(16, 0, 0, 0);
        main.add(userPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        userInput.setColumns(20);
        userInput.setPreferredSize(new Dimension(0, 32));
        userInput.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        main.add(userInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = new GridBagConstraints().HORIZONTAL;
        gbc.insets = new Insets(16, 0, 0, 0);
        main.add(passPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        passInput.setColumns(20);
        passInput.setPreferredSize(new Dimension(0, 32));
        passInput.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        main.add(passInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = new GridBagConstraints().NONE;
        gbc.insets = new Insets(40, 0, 0, 0);
        registerBtn.setFocusable(false);
        main.add(registerBtn, gbc);

        frame.add(header, BorderLayout.NORTH);
        frame.add(main, BorderLayout.CENTER);
        frame.setVisible(true);
    }
  }

  public static void main(String[] args) {
    new RegisterGUI();
    // new HomeGUI();
  }
}
