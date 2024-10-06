package uk.ac.tees.linkedlistica;



/**
 * Represents a singly linked list.
 *
 * @author Your Name (X0000000@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class SinglyLinkedList {

    /**
     * Stores the first node in the list.
     */
    public ListNode head;

    /**
     * Creates a new singly linked list from an existing array.
     *
     * @param data the array to create the new linked list from
     */
    public SinglyLinkedList(int[] data) {

        // DO NOT MODIFY THIS CONSTRUCTOR.
        // Populate list.
        for (int i = data.length - 1; i >= 0; i--) {
            head = new ListNode(data[i], head);
        }
    }

    /**
     * Creates a new, empty singly linked list.
     */
    public SinglyLinkedList() {

        // DO NOT MODIFY THIS CONSTRUCTOR.
        this(new int[]{});
    }

    /**
     * Gets the length of the doubly linked list.
     *
     * @return the length
     */
    public int getSize() {
        if (head == null) {
            return 0;
        }

        int counter = 0; // Initialize a counter to count the nodes
        ListNode current = head; // Create a temporary pointer to iterate through the list

        // Iterate through the list until reaching the last node
        while (current != null) {
            counter++; // Increment the counter to count the current node
            current = current.next; // Move to the next node
        }

        return counter; // Return the total number of nodes counted
    }

    /**
     * @return the second item of the list. / * or -999 if there is only one
     * item
     */
    public int getSecond() {
        if (head == null || head.next == null) {
            return -999; // Return -999 if the list is empty or has only one node
        } else {
            ListNode secondNode = head.next; // Get the second node
            return secondNode.data; // Return the data of the second node
        }
    }

    /**
     * Gets the item at the specified index in the list.
     *
     * @param index the index
     * @return the item, or -999 if not found
     */
    public int getAtPos(int index) {
        if (head == null) {
            return -1; // Return -1 if the list is empty
        }

        ListNode current = head; // Start from the head of the list
        int counter = 0; // Initialize a counter to track the current position

        // Traverse the list until reaching the desired position (index)
        while (current != null && counter < index) {
            current = current.next; // Move to the next node
            counter++; // Increment the counter
        }

        // Check if the index is out of bounds or if the current node is null
        if (current == null) {
            return -1; // Return -1 if the index is out of bounds or if the current node is null
        }

        return current.data; // Return the data value of the node at the specified index
    }

    /**
     * Adds an item after a specified index in the list.
     *
     * @param obj the item to add
     * @param index the index
     * @return true if successful, otherwise false
     */
    public boolean addAfterPos(int obj, int index) {
        // Create a new node with the given data
        ListNode newNode = new ListNode();
        newNode.data = obj;

        // Check if the index is negative
        if (index < 0) {
            System.out.println("Invalid index.");
            return false;
        }

        // Traverse the list to find the node at the specified index
        ListNode current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        // If current is null, the index is out of bounds
        if (current == null) {
            System.out.println("Index out of bound.");
            return false;
        }

        // Insert the new node after the node at the specified index
        newNode.next = current.next; // Set the next pointer of newNode to current's next
        current.next = newNode; // Set current's next pointer to newNode

        return true;
    }

    /**
     * Reverses the order of this linked list.
     */
    public void reverseOrderLinkedList() {
        if (head == null || head.next == null) {
            return; // No need to reverse if the list is empty or has only one node
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode nextNode;

        // Traverse the list and reverse the pointers
        while (current != null) {
            nextNode = current.next; // Store the next node
            current.next = previous; // Reverse the pointer
            previous = current; // Move previous to the current node
            current = nextNode; // Move current to the next node
        }

        head = previous; // Update the head to point to the last node (previous)
    }

}
