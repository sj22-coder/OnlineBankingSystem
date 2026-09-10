package ui;

import dao.AccountDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransferFrame extends JFrame {

    public TransferFrame() {

        setTitle("Transfer Money");
        setSize(600, 420);
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
                new Dimension(450, 300)
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
                new JLabel("TRANSFER MONEY");

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

        JLabel senderLabel =
                new JLabel("From Account:");

        senderLabel.setForeground(Color.WHITE);

        senderLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JTextField senderField =
                new JTextField();

        senderField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        35
                )
        );

        JLabel receiverLabel =
                new JLabel("To Account:");

        receiverLabel.setForeground(Color.WHITE);

        receiverLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JTextField receiverField =
                new JTextField();

        receiverField.setMaximumSize(
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

        JButton transferButton =
                new JButton("TRANSFER");

        transferButton.setBackground(
                goldColor
        );

        transferButton.setForeground(
                Color.BLACK
        );

        transferButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        transferButton.setFocusPainted(false);

        transferButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(title);
        card.add(Box.createVerticalStrut(20));

        card.add(senderLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(senderField);

        card.add(Box.createVerticalStrut(15));

        card.add(receiverLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(receiverField);

        card.add(Box.createVerticalStrut(15));

        card.add(amountLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(amountField);

        card.add(Box.createVerticalStrut(25));

        card.add(transferButton);

        mainPanel.add(card);

        add(mainPanel);

        transferButton.addActionListener(e -> {

            try {

                String sender =
                        senderField.getText().trim();

                String receiver =
                        receiverField.getText().trim();

                double amount =
                        Double.parseDouble(
                                amountField.getText()
                        );

                AccountDAO dao =
                        new AccountDAO();

                boolean success =
                        dao.transferMoney(
                                sender,
                                receiver,
                                amount
                        );

                if(success) {

                    JOptionPane.showMessageDialog(
                            this,
                            "₹" + amount +
                            " transferred successfully!"
                    );

                    senderField.setText("");
                    receiverField.setText("");
                    amountField.setText("");

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Transfer Failed!"
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