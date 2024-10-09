import com.mongodb.client.*;
import org.bson.Document;
import java.util.Scanner;

public class MongoCRUD {
    private MongoClient connect() {
        return MongoClients.create("mongodb://localhost:27017");
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
        try (MongoClient client = connect()) {
            MongoDatabase db = client.getDatabase("yourdb");
            MongoCollection<Document> collection = db.getCollection("customers");

            System.out.println("Enter Customer ID:");
            int id = scanner.nextInt();
            System.out.println("Enter Customer Name:");
            String name = scanner.next();
            System.out.println("Enter Customer Email:");
            String email = scanner.next();

            Document doc = new Document("id", id)
                    .append("name", name)
                    .append("email", email);

            collection.insertOne(doc);
            System.out.println("Customer added successfully.");
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
