package singlylinkedlist.inventorymanagementsystem;

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Add items
        inventory.addItemAtBeginning("Item1", 1, 10, 5.99);
        inventory.addItemAtEnd("Item2", 2, 20, 15.99);
        inventory.addItemAtEnd("Item3", 3, 5, 8.99);
        inventory.addItemAtPosition(1, "Item4", 4, 8, 12.99);

        // Display all items
        inventory.displayInventory();

        // Update quantity of an item
        inventory.updateQuantityById(3, 10);

        // Remove item by ID
        inventory.removeItemById(2);

        // Search for an item by Item ID
        inventory.searchItemById(1);

        // Search for an item by Item Name
        inventory.searchItemByName("Item3");

        // Calculate total inventory value
        inventory.calculateTotalValue();

        // Sort inventory by Item Name (ascending)
        inventory.sortInventoryByName(true);
        inventory.displayInventory();

        // Sort inventory by Price (descending)
        inventory.sortInventoryByPrice(false);
        inventory.displayInventory();
    }
}
