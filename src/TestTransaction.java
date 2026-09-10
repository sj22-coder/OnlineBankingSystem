import dao.TransactionDAO;

public class TestTransaction {

    public static void main(String[] args) {

        TransactionDAO dao =
                new TransactionDAO();

        boolean success =
                dao.addTransaction(
                        1,
                        "DEPOSIT",
                        5000
                );

        if(success) {
            System.out.println(
                    "Transaction Recorded!"
            );
        } else {
            System.out.println(
                    "Failed!"
            );
        }
    }
}