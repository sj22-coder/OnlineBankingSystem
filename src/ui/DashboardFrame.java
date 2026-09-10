package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Bank Dashboard");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color backgroundColor =
                new Color(15, 23, 42);

        Color cardColor =
                new Color(30, 41, 59);

        Color goldColor =
                new Color(255, 215, 0);

        JPanel mainPanel =
                new JPanel(new GridBagLayout());

        mainPanel.setBackground(backgroundColor);

        JPanel card =
                new JPanel();

        card.setPreferredSize(
                new Dimension(500, 300)
        );

        card.setBackground(cardColor);

        card.setLayout(
                new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(goldColor, 2),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        JLabel title =
                new JLabel("BANK DASHBOARD");

        title.setForeground(goldColor);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel welcome =
                new JLabel(
                        "Welcome to Online Banking"
                );

        welcome.setForeground(Color.WHITE);

        welcome.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JButton depositButton =
                new JButton("Deposit");

        JButton withdrawButton =
                new JButton("Withdraw");

        JButton transferButton =
                new JButton("Transfer");

        JButton transactionButton =
                new JButton("Transactions");

        JButton logoutButton =
                new JButton("Logout");

        JButton[] buttons = {
                depositButton,
                withdrawButton,
                transferButton,
                transactionButton,
                logoutButton
        };

        for(JButton button : buttons) {

            button.setBackground(goldColor);

            button.setForeground(Color.BLACK);

            button.setFocusPainted(false);

            button.setMaximumSize(
                    new Dimension(250, 40)
            );

            button.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );
        }

        card.add(title);
        card.add(Box.createVerticalStrut(10));
        card.add(welcome);
        card.add(Box.createVerticalStrut(25));

        card.add(depositButton);
        card.add(Box.createVerticalStrut(10));

        card.add(withdrawButton);
        card.add(Box.createVerticalStrut(10));

        card.add(transferButton);
        card.add(Box.createVerticalStrut(10));

        card.add(transactionButton);
        card.add(Box.createVerticalStrut(10));

        card.add(logoutButton);

        mainPanel.add(card);

        add(mainPanel);
        mainPanel.add(card);

add(mainPanel);

depositButton.addActionListener(e -> {

    new DepositFrame();

});

withdrawButton.addActionListener(e -> {

    new WithdrawFrame();

});
transferButton.addActionListener(e -> {

    new TransferFrame();

});
transactionButton.addActionListener(e -> {

    new TransactionFrame();

});
logoutButton.addActionListener(e -> {

    dispose();

    new LoginFrame();
});

setVisible(true);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new DashboardFrame();
        });
    }
}