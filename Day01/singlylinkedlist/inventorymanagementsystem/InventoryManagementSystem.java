package singlylinkedlist.inventorymanagementsystem;

class InventoryManagementSystem {
    private InventoryNode head;

    // Constructor
    public InventoryManagementSystem() {
        this.head = null;
    }

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryNode newItem = new InventoryNode(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryNode newItem = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            InventoryNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
        } else {
            InventoryNode newItem = new InventoryNode(itemName, itemId, quantity, price);
            InventoryNode temp = head;
            int count = 0;
            while (count < position - 1 && temp != null) {
                temp = temp.next;
                count++;
            }
            if (temp != null) {
                newItem.next = temp.next;
                temp.next = newItem;
            } else {
                System.out.println("Position out of bounds.");
            }
        }
    }

    // Remove an item by Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        InventoryNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity of item with ID " + itemId + " updated to " + newQuantity);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchItemById(int itemId) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchItemByName(String itemName) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        InventoryNode temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total value of inventory: " + totalValue);
    }

    // Sort the inventory based on Item Name (Ascending or Descending)
    public void sortInventoryByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
    }

    // Sort the inventory based on Price (Ascending or Descending)
    public void sortInventoryByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
    }

    // Merge Sort for sorting by Item Name
    private InventoryNode mergeSortByName(InventoryNode head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        InventoryNode middle = getMiddle(head);
        InventoryNode nextOfMiddle = middle.next;

        middle.next = null;

        InventoryNode left = mergeSortByName(head, ascending);
        InventoryNode right = mergeSortByName(nextOfMiddle, ascending);

        return mergeByName(left, right, ascending);
    }

    // Merge two sorted lists by Item Name
    private InventoryNode mergeByName(InventoryNode left, InventoryNode right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        if ((ascending && left.itemName.compareTo(right.itemName) <= 0) ||
                (!ascending && left.itemName.compareTo(right.itemName) > 0)) {
            left.next = mergeByName(left.next, right, ascending);
            return left;
        } else {
            right.next = mergeByName(left, right.next, ascending);
            return right;
        }
    }

    // Merge Sort for sorting by Price
    private InventoryNode mergeSortByPrice(InventoryNode head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        InventoryNode middle = getMiddle(head);
        InventoryNode nextOfMiddle = middle.next;

        middle.next = null;

        InventoryNode left = mergeSortByPrice(head, ascending);
        InventoryNode right = mergeSortByPrice(nextOfMiddle, ascending);

        return mergeByPrice(left, right, ascending);
    }

    // Merge two sorted lists by Price
    private InventoryNode mergeByPrice(InventoryNode left, InventoryNode right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        if ((ascending && left.price <= right.price) ||
                (!ascending && left.price > right.price)) {
            left.next = mergeByPrice(left.next, right, ascending);
            return left;
        } else {
            right.next = mergeByPrice(left, right.next, ascending);
            return right;
        }
    }

    // Get the middle of the list
    private InventoryNode getMiddle(InventoryNode head) {
        if (head == null) return null;

        InventoryNode slow = head;
        InventoryNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items in the inventory
    public void displayInventory() {
        InventoryNode temp = head;
        if (temp == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Inventory:");
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}