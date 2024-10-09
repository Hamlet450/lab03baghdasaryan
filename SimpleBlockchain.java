import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBlockchain {
    private ArrayList<Block> blockchain = new ArrayList<>();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Customer to Blockchain");
        System.out.println("2. View Blockchain");
        System.out.println("3. Mine Blockchain");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addCustomerToBlockchain(scanner);
                break;
            case 2:
                viewBlockchain();
                break;
            case 3:
                mineBlockchain();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addCustomerToBlockchain(Scanner scanner) {
        System.out.println("Enter Customer ID:");
        int id = scanner.nextInt();
        System.out.println("Enter Customer Name:");
        String name = scanner.next();
        System.out.println("Enter Customer Email:");
        String email = scanner.next();

        Customer customer = new Customer(id, name, email);
        Block block = new Block(blockchain.size(), customer.toString());
        blockchain.add(block);
        System.out.println("Customer added to blockchain.");
    }

    private void viewBlockchain() {
        for (Block block : blockchain) {
            System.out.println(block);
        }
    }

    private void mineBlockchain() {
        for (Block block : blockchain) {
            block.mineBlock();
        }
        System.out.println("Blockchain mined.");
    }
}

