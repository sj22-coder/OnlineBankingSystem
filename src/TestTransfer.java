import dao.AccountDAO;

public class TestTransfer {

    public static void main(String[] args) {

        AccountDAO dao =
                new AccountDAO();

        boolean success =
                dao.transferMoney(
                        "ACC1001",
                        "ACC1002",
                        1000
                );

        if(success) {
            System.out.println(
                    "Transfer Successful!"
            );
        } else {
            System.out.println(
                    "Transfer Failed!"
            );
        }
    }
}