import java.sql.*;
import java.util.Scanner;

public class Main {
    // Database connection variables
    private static final String URL = "jdbc:mysql://localhost:3306/PROJECT2";
    private static final String USER = "root";
    private static final String PASSWORD = "Diya@16204";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        
        try {
            // Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");

            while (true) {
                // Display Menu
                System.out.println("\nMenu:");
                System.out.println("1. Fetch Mall Data");
                System.out.println("2. Fetch Shop Owners Data");
                System.out.println("3. Fetch Shops Data");
                System.out.println("4. Fetch Suppliers Data");
                System.out.println("5. Fetch Inventory Data");
                System.out.println("6. Fetch Customers Data");
                System.out.println("7. Fetch Employees Data");
                System.out.println("8. Fetch Transactions Data");
                System.out.println("9. Update Shop Rent Amount");
                System.out.println("10. Get Total Sales for Shop");
                System.out.println("11. Get Suppliers by Product Category");
                System.out.println("13. Get Top Selling Products in a Shop");
                System.out.println("14. Get Customers Who Made Purchases Above a Certain Amount");
                System.out.println("12. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        fetchMallData(connection);
                        break;
                    case 2:
                        fetchShopOwnersData(connection);
                        break;
                    case 3:
                        fetchShopsData(connection);
                        break;
                    case 4:
                        fetchSuppliersData(connection);
                        break;
                    case 5:
                        fetchInventoryData(connection);
                        break;
                    case 6:
                        fetchCustomersData(connection);
                        break;
                    case 7:
                        fetchEmployeesData(connection);
                        break;
                    case 8:
                        fetchTransactionsData(connection);
                        break;
                        case 9:
                        updateShopRentAmount(connection, scanner);
                        break;
                    case 10:
                        getTotalSalesForShop(connection, scanner);
                        break;
                    case 11:
                        getSuppliersByCategory(connection, scanner);
                        break;
                    case 12:
                        System.out.println("Exiting the program.");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (scanner != null) {
                    scanner.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fetch Mall data
    private static void fetchMallData(Connection connection) {
        String query = "SELECT * FROM Mall";
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Mall Data:");
            while (resultSet.next()) {
                System.out.println("MallID: " + resultSet.getInt("MallID")
                        + ", Name: " + resultSet.getString("Name")
                        + ", Location: " + resultSet.getString("Location")
                        + ", TotalShops: " + resultSet.getInt("TotalShops")
                        + ", TotalEmployees: " + resultSet.getInt("TotalEmployees")
                        + ", TotalParkingSlots: " + resultSet.getInt("TotalParkingSlots")
                        + ", ContactNumber: " + resultSet.getString("ContactNumber")
                        + ", OperatingHours: " + resultSet.getString("OperatingHours"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Shop Owners data
    private static void fetchShopOwnersData(Connection connection) {
        String query = "SELECT * FROM Shop_Owners";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Shop Owners Data:");
            while (resultSet.next()) {
                System.out.println("OwnerID: " + resultSet.getInt("OwnerID")
                        + ", Name: " + resultSet.getString("Name")
                        + ", ContactNumber: " + resultSet.getString("ContactNumber")
                        + ", Email: " + resultSet.getString("Email")
                        + ", Address: " + resultSet.getString("Address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Shops data
    private static void fetchShopsData(Connection connection) {
        String query = "SELECT * FROM Shops";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Shops Data:");
            while (resultSet.next()) {
                System.out.println("ShopID: " + resultSet.getInt("ShopID")
                        + ", Name: " + resultSet.getString("Name")
                        + ", Category: " + resultSet.getString("Category")
                        + ", FloorNumber: " + resultSet.getInt("FloorNumber")
                        + ", RentAmount: " + resultSet.getDouble("RentAmount")
                        + ", ContactNumber: " + resultSet.getString("ContactNumber")
                        + ", OpeningHours: " + resultSet.getString("OpeningHours")
                        + ", ClosingHours: " + resultSet.getString("ClosingHours")
                        + ", MallID: " + resultSet.getInt("MallID")
                        + ", OwnerID: " + resultSet.getInt("OwnerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Suppliers data
    private static void fetchSuppliersData(Connection connection) {
        String query = "SELECT * FROM Suppliers";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Suppliers Data:");
            while (resultSet.next()) {
                System.out.println("SupplierID: " + resultSet.getInt("SupplierID")
                        + ", Name: " + resultSet.getString("Name")
                        + ", ContactNumber: " + resultSet.getString("ContactNumber")
                        + ", Email: " + resultSet.getString("Email")
                        + ", Address: " + resultSet.getString("Address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Inventory data
    private static void fetchInventoryData(Connection connection) {
        String query = "SELECT * FROM Inventory";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Inventory Data:");
            while (resultSet.next()) {
                System.out.println("ShopID: " + resultSet.getInt("ShopID")
                        + ", ItemID: " + resultSet.getInt("ItemID")
                        + ", ProductName: " + resultSet.getString("ProductName")
                        + ", Category: " + resultSet.getString("Category")
                        + ", QuantityAvailable: " + resultSet.getInt("QuantityAvailable")
                        + ", Price: " + resultSet.getDouble("Price")
                        + ", ReorderLevel: " + resultSet.getInt("ReorderLevel")
                        + ", SupplierID: " + resultSet.getInt("SupplierID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Customers data
    private static void fetchCustomersData(Connection connection) {
        String query = "SELECT * FROM Customers";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Customers Data:");
            while (resultSet.next()) {
                System.out.println("CustomerID: " + resultSet.getInt("CustomerID")
                        + ", Name: " + resultSet.getString("Name")
                        + ", ContactNumber: " + resultSet.getString("ContactNumber")
                        + ", Email: " + resultSet.getString("Email")
                        + ", MembershipStatus: " + resultSet.getString("MembershipStatus")
                        + ", LastPurchaseShopID: " + resultSet.getInt("LastPurchaseShopID")
                        + ", LastPurchaseDate: " + resultSet.getTimestamp("LastPurchaseDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Employees data
    private static void fetchEmployeesData(Connection connection) {
        String query = "SELECT * FROM Employees";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Employees Data:");
            while (resultSet.next()) {
                System.out.println("EmployeeID: " + resultSet.getInt("EmployeeID")
                        + ", ShopID: " + resultSet.getInt("ShopID")
                        + ", Name: " + resultSet.getString("Name")
                        + ", Role: " + resultSet.getString("Role")
                        + ", Salary: " + resultSet.getDouble("Salary")
                        + ", ContactNumber: " + resultSet.getString("ContactNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Transactions data
    private static void fetchTransactionsData(Connection connection) {
        String query = "SELECT * FROM Transactions";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Transactions Data:");
            while (resultSet.next()) {
                System.out.println("TransactionID: " + resultSet.getInt("TransactionID")
                        + ", CustomerID: " + resultSet.getInt("CustomerID")
                        + ", ShopID: " + resultSet.getInt("ShopID")
                        + ", Amount: " + resultSet.getDouble("Amount")
                        + ", PaymentMethod: " + resultSet.getString("PaymentMethod")
                        + ", DateTime: " + resultSet.getTimestamp("DateTime")
                        + ", DiscountApplied: " + resultSet.getDouble("DiscountApplied")
                        + ", InvoiceNumber: " + resultSet.getString("InvoiceNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Shop Rent Amount
    private static void updateShopRentAmount(Connection connection, Scanner scanner) {
        System.out.print("Enter Shop ID to update: ");
        int shopId = scanner.nextInt();
        System.out.print("Enter new Rent Amount: ");
        double newRentAmount = scanner.nextDouble();
        
        String query = "UPDATE Shops SET RentAmount = ? WHERE ShopID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, newRentAmount);
            preparedStatement.setInt(2, shopId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Shop rent amount updated successfully.");
            } else {
                System.out.println("Shop not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get Total Sales for Shop
    private static void getTotalSalesForShop(Connection connection, Scanner scanner) {
        System.out.print("Enter Shop ID to get total sales: ");
        int shopId = scanner.nextInt();

        String query = "SELECT SUM(Amount) AS TotalSales FROM Transactions WHERE ShopID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, shopId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double totalSales = resultSet.getDouble("TotalSales");
                System.out.println("Total Sales for Shop ID " + shopId + ": " + totalSales);
            } else {
                System.out.println("No sales found for the shop.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get Suppliers by Product Category
    private static void getSuppliersByCategory(Connection connection, Scanner scanner) {
        System.out.print("Enter Product Category to find suppliers: ");
        scanner.nextLine();  // Clear the buffer
        String category = scanner.nextLine();

        String query = "SELECT DISTINCT Suppliers.Name, Suppliers.ContactNumber FROM Suppliers " +
                       "JOIN Inventory ON Suppliers.SupplierID = Inventory.SupplierID " +
                       "WHERE Inventory.Category = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Suppliers for category '" + category + "':");
            while (resultSet.next()) {
                System.out.println("Supplier Name: " + resultSet.getString("Name")
                        + ", Contact: " + resultSet.getString("ContactNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}