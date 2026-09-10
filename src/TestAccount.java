import dao.AccountDAO;

public class TestAccount {

    public static void main(String[] args) {

        AccountDAO dao =
                new AccountDAO();

        boolean success =
                dao.createAccount(
                        1,
                        "ACC1001"
                );

        if(success) {
            System.out.println(
                    "Account Created Successfully!"
            );
        } else {
            System.out.println(
                    "Account Creation Failed!"
            );
        }
    }
}