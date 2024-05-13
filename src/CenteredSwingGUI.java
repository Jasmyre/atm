import javax.swing.*;
import java.awt.*;

public class CenteredSwingGUI extends JFrame {
    public CenteredSwingGUI() {
        setTitle("Document");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Adjust size as needed

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for flexibility
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel logoLabel = new JLabel("Register");
        logoLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0); // Bottom padding
        mainPanel.add(logoLabel, gbc);

        JTextField idField = new JTextField(20);
        idField.setBorder(BorderFactory.createTitledBorder("ID"));
        gbc.gridy = 1;
        mainPanel.add(idField, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        gbc.gridy = 2;
        mainPanel.add(passwordField, gbc);

        JButton continueButton = new JButton("Continue");
        gbc.gridy = 3;
        mainPanel.add(continueButton, gbc);

        // Center the mainPanel vertically within the JFrame
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.fill = GridBagConstraints.VERTICAL;
        getContentPane().add(mainPanel, frameGbc);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CenteredSwingGUI());
    }
}
