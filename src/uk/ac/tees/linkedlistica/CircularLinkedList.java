package uk.ac.tees.linkedlistica;

/**
 * Represents a circular linked list.
 *
 * @author Your Name (X0000000@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class CircularLinkedList {

    /**
     * Stores the first node in the list. Should always be a sentinel node.
     */
    public ListNode head;

    /**
     * Creates a new circular linked list from an existing array.
     *
     * @param data the array to create the new linked list from
     */
    public CircularLinkedList(int[] data) {

        // DO NOT MODIFY THIS CONSTRUCTOR.
        // The head is a sentinel node.
        head = new ListNode(-999, null);
        head.next = head; // Complete the circle.

        // Populate list.
        ListNode n = head; // The last item in the circle.
        for (int i = 0; i < data.length; i++) {
            n.next = new ListNode(data[i], head);
            n = n.next;
        }
    }

    /**
     * Gets the length of the circular linked list.
     *
     * @return the length
     */
    public int getSize() {
        // Check if the list is empty
        if (head.next == head) {
            return 0; // If the list is empty, return 0
        }

        ListNode c = head.next; // Start from the first node
        int counter = 1; // Initialize a counter to count the nodes

        // Iterate through the list until reaching the head node
        while (c.next != head) {
            counter++; // Increment the counter to count the current node
            c = c.next; // Move to the next node
        }

        return counter; // Return the total number of nodes counted
    }

    /**
     * Gets the last item in the circular linked list, or -999 if not found.
     *
     * @return the last item, or -999 if empty
     */
    public int getLast() {
        // Check if the list is empty
        if (head.next == head) {
            return -999; // Return a default value if the list is empty
        }

        ListNode c = head.next; // Start from the first node
        while (c.next != head) {
            c = c.next; // Move to the next node until reaching the last node
        }

        return c.data; // Return the data value of the last node
    }

    /**
     * Deletes all nodes with the given value, returning the number of nodes
     * deleted.
     *
     * @param obj the value
     * @return the number of nodes deleted
     */
    public int deleteAllNodesWithValue(int obj) {
        ListNode current = head.next; // Start from the first node
        int count = 0; // Initialize a counter to count the number of nodes deleted

        // Iterate through the list until reaching the head node
        while (current != head) {
            // Check if the data value of the current node matches the specified object
            if (current.data == obj) {
                ListNode previous = head; // Initialize a pointer to the head node

                // Traverse the list to find the previous node of the current node
                while (previous.next != current) {
                    previous = previous.next; // Move to the next node
                }

                previous.next = current.next; // Bypass the current node
                current.next = null; // Disconnect the current node from the list
                current = previous.next; // Move to the next node
                count++; // Increment the counter to indicate deletion
            } else {
                current = current.next; // Move to the next node
            }
        }

        // Check if the first node has the specified value
        if (head.data == obj) {
            head = head.next; // Move head to the next node, effectively deleting the first node
            count++; // Increment the counter to indicate deletion
        }

        return count; // Return the total count of nodes deleted
    }

    /**
     * Deletes the node in the list at the specified index.
     *
     * @param index the index
     * @return true if successful, otherwise false
     */
    public boolean deleteAtPos(int index) {
        // Check if the index is negative
        if (index < 0) {
            System.out.println("Invalid index.");
            return false; // Return false because the index is invalid
        }

        // Check if the list is empty
        if (head.next == head) {
            System.out.println("List is empty.");
            return false; // Return false because the list is empty
        }

        int count = 0; // Initialize a counter to keep track of the current position
        ListNode current = head.next; // Start traversing from the first node
        ListNode previous = head; // Initialize a pointer to keep track of the previous node

        // Traverse the list
        while (current != head) {
            // Check if the current position matches the index
            if (count == index) {
                // Update the pointers to remove the node at the current position
                previous.next = current.next; // Update the next pointer of the previous node
                current.next = null; // Disconnect the current node from the list
                return true; // Return true to indicate successful deletion
            }
            // Move to the next node
            previous = current; // Update the previous pointer
            current = current.next; // Move to the next node
            count++; // Increment the counter
        }

        // If the loop completes without finding the index, the index is out of bounds
        System.out.println("Index out of bound.");
        return false; // Return false because the index is out of bounds
    }

    /**
     * Returns the sum of all integers in the list.
     *
     * @return the sum
     */
    public int sum() {
        int sum = 0; // Initialize a variable to store the sum of data values

        // Check if the list is empty
        if (head.next == head) {
            return sum; // If the list is empty, return 0
        }

        ListNode current = head.next; // Start from the first node
        do {
            sum += current.data; // Add the data value of the current node to the sum
            current = current.next; // Move to the next node
        } while (current != head); // Continue until the current node is the head (end of the circular list)

        return sum; // Return the total sum of data values in the nodes
    }

}
