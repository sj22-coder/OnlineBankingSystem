import dao.AccountDAO;

public class TestWithdraw {

    public static void main(String[] args) {

        AccountDAO dao =
                new AccountDAO();

        boolean success =
                dao.withdrawMoney(
                        "ACC1001",
                        2000
                );

        if(success) {
            System.out.println(
                    "Withdrawal Successful!"
            );
        } else {
            System.out.println(
                    "Insufficient Balance!"
            );
        }
    }
}