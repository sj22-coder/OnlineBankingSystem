import dao.AccountDAO;

public class TestDeposit {

    public static void main(String[] args) {

        AccountDAO dao =
                new AccountDAO();

        boolean success =
                dao.depositMoney(
                        "ACC1001",
                        5000
                );

        if(success) {
            System.out.println(
                    "Deposit Successful!"
            );
        } else {
            System.out.println(
                    "Deposit Failed!"
            );
        }
    }
}