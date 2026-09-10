package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import dao.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {

        setTitle("Online Banking System");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color backgroundColor = new Color(15, 23, 42);
        Color cardColor = new Color(30, 41, 59);
        Color goldColor = new Color(255, 215, 0);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(500, 280));
        card.setBackground(cardColor);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(goldColor, 2),
                        new EmptyBorder(25, 30, 25, 30)
                )
        );

        JLabel title = new JLabel("ONLINE BANKING SYSTEM");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(goldColor);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel subtitle = new JLabel("Premium Secure Banking");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));

        card.add(title);
        card.add(Box.createVerticalStrut(5));
        card.add(subtitle);
        card.add(Box.createVerticalStrut(30));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(250, 30));

        JPanel userPanel = new JPanel(new BorderLayout(15, 0));
        userPanel.setBackground(cardColor);
        userPanel.add(userLabel, BorderLayout.WEST);
        userPanel.add(usernameField, BorderLayout.CENTER);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250, 30));

        JPanel passPanel = new JPanel(new BorderLayout(15, 0));
        passPanel.setBackground(cardColor);
        passPanel.add(passLabel, BorderLayout.WEST);
        passPanel.add(passwordField, BorderLayout.CENTER);

        loginButton = new JButton("LOGIN");
        loginButton.setBackground(goldColor);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(userPanel);
        card.add(Box.createVerticalStrut(20));
        card.add(passPanel);
        card.add(Box.createVerticalStrut(30));
        card.add(loginButton);
        card.add(Box.createVerticalStrut(20));

        JLabel footer = new JLabel("Secure • Reliable • Trusted");
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);
        footer.setForeground(Color.GRAY);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));

        card.add(footer);

        mainPanel.add(card);

        add(mainPanel);

        setVisible(true);
        loginButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        String username =
                usernameField.getText();

        String password =
                new String(
                        passwordField.getPassword()
                );

        UserDAO dao =
                new UserDAO();

        boolean success =
                dao.loginUser(
                        username,
                        password
                );

        if(success) {

        new DashboardFrame();

        dispose();

        } else {

            JOptionPane.showMessageDialog(
                    LoginFrame.this,
                    "Invalid Username or Password!"
            );
        }
    }
});
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}