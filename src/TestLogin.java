import dao.UserDAO;

public class TestLogin {

    public static void main(String[] args) {

        UserDAO userDAO =
                new UserDAO();

        boolean success =
                userDAO.loginUser(
                        "John",
                        "12345"
                );

        if (success) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Credentials!");
        }
    }
}