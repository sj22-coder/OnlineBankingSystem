package ui;

import dao.AccountDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DepositFrame extends JFrame {

    public DepositFrame() {

        setTitle("Deposit Money");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
                new Dimension(450, 220)
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
                new JLabel("DEPOSIT MONEY");

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

        JLabel accountLabel =
                new JLabel("Account Number:");

        accountLabel.setForeground(Color.WHITE);

        accountLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JTextField accountField =
                new JTextField();

        accountField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        35
                )
        );

        JLabel amountLabel =
                new JLabel("Amount:");

        amountLabel.setForeground(Color.WHITE);

        amountLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JTextField amountField =
                new JTextField();

        amountField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        35
                )
        );

        JButton depositButton =
                new JButton("DEPOSIT");

        depositButton.setBackground(
                goldColor
        );

        depositButton.setForeground(
                Color.BLACK
        );

        depositButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        depositButton.setFocusPainted(false);

        depositButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(title);
        card.add(Box.createVerticalStrut(20));

        card.add(accountLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(accountField);

        card.add(Box.createVerticalStrut(15));

        card.add(amountLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(amountField);

        card.add(Box.createVerticalStrut(25));

        card.add(depositButton);

        mainPanel.add(card);

        add(mainPanel);

        depositButton.addActionListener(e -> {

            try {

                String accountNumber =
                        accountField.getText().trim();

                double amount =
                        Double.parseDouble(
                                amountField.getText()
                        );

                AccountDAO dao =
                        new AccountDAO();

                boolean success =
                        dao.depositMoney(
                                accountNumber,
                                amount
                        );

                if(success) {

                    JOptionPane.showMessageDialog(
                            this,
                            "₹" + amount +
                            " deposited successfully!"
                    );

                    accountField.setText("");
                    amountField.setText("");

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Deposit Failed!"
                    );
                }

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid details!"
                );
            }
        });

        setVisible(true);
    }
}