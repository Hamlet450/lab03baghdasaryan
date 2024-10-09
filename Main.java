/** Project: Data Assignment
 * Purpose Details: A Java application to perform CRUD operations on MySQL, MongoDB, and Redis databases,
                  and manage customer data using a simple blockchain implementation.
 * Course:IST 242
 * Author:Hamlet Baghdasaryan
 * Date Developed:10/06/24
 * Last Date Changed:10/08/24
 * Rev:1.0

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Select Database Option:");
            System.out.println("1. MySQL");
            System.out.println("2. MongoDB");
            System.out.println("3. Redis");
            System.out.println("4. Blockchain");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    MysqlCRUD mysql = new MysqlCRUD();
                    mysql.menu();
                    break;
                case 2:
                    MongoCRUD mongo = new MongoCRUD();
                    mongo.menu();
                    break;
                case 3:
                    RedisCRUD redis = new RedisCRUD();
                    redis.menu();
                    break;
                case 4:
                    SimpleBlockchain blockchain = new SimpleBlockchain();
                    blockchain.menu();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
