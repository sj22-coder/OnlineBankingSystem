import dao.TransactionDAO;

public class TestHistory {

    public static void main(String[] args) {

        TransactionDAO dao =
                new TransactionDAO();

        dao.viewTransactions();
    }
}