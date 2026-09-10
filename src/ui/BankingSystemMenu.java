package ui;
import dao.UserDAO;
import model.User;
import java.util.Scanner;
import dao.AccountDAO;
import dao.UserDAO;
import model.User;
import dao.TransactionDAO;
public class BankingSystemMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n====== ONLINE BANKING SYSTEM ======");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Create Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Transfer Money");
            System.out.println("7. View Transactions");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

    sc.nextLine();

    System.out.print("Enter Username: ");
    String username = sc.nextLine();

    System.out.print("Enter Password: ");
    String password = sc.nextLine();

    System.out.print("Enter Full Name: ");
    String fullName = sc.nextLine();

    User user = new User();

    user.setUsername(username);
    user.setPassword(password);
    user.setFullName(fullName);

    UserDAO userDAO = new UserDAO();

    if(userDAO.registerUser(user)) {
        System.out.println("User Registered Successfully!");
    } else {
        System.out.println("Registration Failed!");
    }

    break;

                case 2:

    sc.nextLine();

    System.out.print("Enter Username: ");
    String loginUsername = sc.nextLine();

    System.out.print("Enter Password: ");
    String loginPassword = sc.nextLine();

    UserDAO loginDAO = new UserDAO();

    boolean success =
            loginDAO.loginUser(
                    loginUsername,
                    loginPassword
            );

    if(success) {
        System.out.println("Login Successful!");
    } else {
        System.out.println("Invalid Credentials!");
    }

    break;

               case 3:

    System.out.print("Enter User ID: ");
    int userId = sc.nextInt();

    sc.nextLine();

    System.out.print("Enter Account Number: ");
    String accountNumber = sc.nextLine();

    AccountDAO accountDAO = new AccountDAO();

    boolean accountCreated =
            accountDAO.createAccount(
                    userId,
                    accountNumber
            );

    if(accountCreated) {
        System.out.println(
                "Account Created Successfully!"
        );
    } else {
        System.out.println(
                "Account Creation Failed!"
        );
    }

    break;

                case 4:

    sc.nextLine();

    System.out.print("Enter Account Number: ");
    String depositAccount = sc.nextLine();

    System.out.print("Enter Amount: ");
    double depositAmount = sc.nextDouble();

    AccountDAO depositDAO = new AccountDAO();

    boolean depositSuccess =
            depositDAO.depositMoney(
                    depositAccount,
                    depositAmount
            );

    if(depositSuccess) {
        System.out.println(
                "Deposit Successful!"
        );
    } else {
        System.out.println(
                "Deposit Failed!"
        );
    }

    break;

                case 5:

    sc.nextLine();

    System.out.print("Enter Account Number: ");
    String withdrawAccount = sc.nextLine();

    System.out.print("Enter Amount: ");
    double withdrawAmount = sc.nextDouble();

    AccountDAO withdrawDAO = new AccountDAO();

    boolean withdrawSuccess =
            withdrawDAO.withdrawMoney(
                    withdrawAccount,
                    withdrawAmount
            );

    if(withdrawSuccess) {
        System.out.println(
                "Withdrawal Successful!"
        );
    } else {
        System.out.println(
                "Insufficient Balance or Invalid Account!"
        );
    }

    break;

                case 6:

    sc.nextLine();

    System.out.print("Sender Account Number: ");
    String sender = sc.nextLine();

    System.out.print("Receiver Account Number: ");
    String receiver = sc.nextLine();

    System.out.print("Amount: ");
    double transferAmount = sc.nextDouble();

    AccountDAO transferDAO = new AccountDAO();

    boolean transferSuccess =
            transferDAO.transferMoney(
                    sender,
                    receiver,
                    transferAmount
            );

    if(transferSuccess) {
        System.out.println(
                "Transfer Successful!"
        );
    } else {
        System.out.println(
                "Transfer Failed!"
        );
    }

    break;

                case 7:

    TransactionDAO transactionDAO =
            new TransactionDAO();

    transactionDAO.viewTransactions();

    break;

                case 8:
                    System.out.println("Thank you for using Online Banking System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}