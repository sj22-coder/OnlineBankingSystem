package ui;

import dao.TransactionDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class TransactionFrame extends JFrame {

    public TransactionFrame() {

        setTitle("Transaction History");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color backgroundColor =
                new Color(15, 23, 42);

        Color cardColor =
                new Color(30, 41, 59);

        Color goldColor =
                new Color(255, 215, 0);

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(backgroundColor);

        JPanel card =
                new JPanel(new BorderLayout());

        card.setBackground(cardColor);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(goldColor, 2),
                        new EmptyBorder(15, 15, 15, 15)
                )
        );

        JLabel title =
                new JLabel(
                        "TRANSACTION HISTORY",
                        SwingConstants.CENTER
                );

        title.setForeground(goldColor);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        String[] columns = {
                "ID",
                "Account ID",
                "Type",
                "Amount",
                "Date"
        };

        DefaultTableModel model =
                new DefaultTableModel(
                        columns,
                        0
                );

        JTable table =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        try {

            TransactionDAO dao =
                    new TransactionDAO();

            ResultSet rs =
                    dao.getTransactions();

            while(rs.next()) {

                model.addRow(
                        new Object[] {
                                rs.getInt("transaction_id"),
                                rs.getInt("account_id"),
                                rs.getString("transaction_type"),
                                rs.getDouble("amount"),
                                rs.getTimestamp("transaction_date")
                        }
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        card.add(title,
                BorderLayout.NORTH);

        card.add(scrollPane,
                BorderLayout.CENTER);

        mainPanel.add(card,
                BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }
}