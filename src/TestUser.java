import dao.UserDAO;
import model.User;

public class TestUser {

    public static void main(String[] args) {

        User user = new User();

        user.setUsername("John");
        user.setPassword("12345");
        user.setFullName("John Joshnson");

        UserDAO userDAO = new UserDAO();

        boolean success =
                userDAO.registerUser(user);

        if (success) {
            System.out.println("User Registered Successfully!");
        } else {
            System.out.println("Registration Failed!");
        }
    }
}