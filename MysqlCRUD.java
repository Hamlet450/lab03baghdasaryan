import java.sql.*;
import java.util.Scanner;

public class MysqlCRUD {
    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/yourdb";
        String user = "root";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Customer");
        System.out.println("2. Read Customer");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addCustomer(scanner);
                break;
            case 2:
                readCustomer(scanner);
                break;
            case 3:
                updateCustomer(scanner);
                break;
            case 4:
                deleteCustomer(scanner);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addCustomer(Scanner scanner) {
        try (Connection conn = connect()) {
            System.out.println("Enter Customer ID:");
            int id = scanner.nextInt();
            System.out.println("Enter Customer Name:");
            String name = scanner.next();
            System.out.println("Enter Customer Email:");
            String email = scanner.next();

            String sql = "INSERT INTO customers (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void readCustomer(Scanner scanner) {
        // Implement the read operation
    }

    private void updateCustomer(Scanner scanner) {
        // Implement the update operation
    }

    private void deleteCustomer(Scanner scanner) {
        // Implement the delete operation
    }
}
