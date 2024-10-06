package uk.ac.tees.linkedlistica;

/**
 * Represents a singly linked list.
 *
 * @author Your Name (X0000000@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class DoublyLinkedList {

    /**
     * Stores the first node in the list.
     */
    public DoublyLinkedListNode head;

    /**
     * Creates a new doubly linked list from an existing array.
     *
     * @param data the array to create the new linked list from
     */
    public DoublyLinkedList(int[] data) {

        // DO NOT MODIFY THIS CONSTRUCTOR.
        for (int i = data.length - 1; i >= 0; i--) {
            DoublyLinkedListNode n = new DoublyLinkedListNode(data[i], head,
                    null);
            if (head != null) {
                head.prev = n;
            }
            head = n;
        }
    }

    /**
     * Gets whether or not the list is empty.
     *
     * @return true if list is empty, otherwise false
     */
    public boolean isEmpty() {
        //Check if the head of the list is  null
        //If the head  is null, it means that the list is empty
        return head == null;
    }

    /**
     * Returns the list as a string of the form "{item1, item2, ...}"
     *
     * @return the resulting string in the format {item1, item2, ...}
     */
    @Override
    public String toString() {
        DoublyLinkedListNode current = head; // Start from the head of the list
        if (current == null) {
            return "{}"; // Return empty string representation if the list is empty
        }
        String string = ""; // Initialize an empty string to store the result

        // Traverse the list and construct the string representation
        while (current != null) {
            if (current.prev == null) {
                string += "{"; // Add opening curly brace if it's the first node
            }
            string += current.data; // Add the data of the current node
            if (current.next == null) {
                string += "}"; // Add closing curly brace if it's the last node
            } else {
                string += ","; // Add comma if there are more nodes
            }
            current = current.next; // Move to the next node
        }
        return string; // Return the string representation of the list
    }

    /**
     * Count all nodes with the given value, returning the number of nodes.
     *
     * @param obj the value
     * @return the number of nodes with value obj
     */
    public int countNodesWithValue(int obj) {
        DoublyLinkedListNode current = head; // Start from the head of the list
        int count = 0; // Initialize a counter to count occurrences of the value

        // Traverse the list and count occurrences of the value
        while (current != null) {
            if (current.data == obj) {
                count++; // Increment the counter if the current node's data matches the value
            }
            current = current.next; // Move to the next node
        }
        return count; // Return the total count of nodes with the specified value
    }

    /**
     * Adds an item after a specified index in the list.
     *
     * @param obj the item to add
     * @param index the index
     * @return true if successful, otherwise false
     */
    public boolean addAtPos(int obj, int index) {
        // Create a new node with the given data
        DoublyLinkedListNode newNode = new DoublyLinkedListNode();
        newNode.data = obj;

        // Check if the index is negative
        if (index < 0) {
            System.out.println("Invalid index.");
            return false;
        }

        DoublyLinkedListNode current = head;
        DoublyLinkedListNode previous = null;
        int count = 0;

        // Traverse the list to find the node at the specified index
        while (current != null && count < index) {
            previous = current;
            current = current.next;
            count++;
        }

        // If current is null, the index is out of bounds
        if (current == null) {
            System.out.println("Index out of bound.");
            return false;
        }

        // Insert the new node before the current node
        newNode.next = current;
        newNode.prev = previous;
        if (previous != null) {
            previous.next = newNode;
        } else {
            head = newNode; // Update head if the new node is inserted at the beginning
        }
        if (current != null) {
            current.prev = newNode;
        }

        return true;
    }

    /**
     * Deletes any node containing a value that is a multiple of three.
     *
     * @return
     */
    public int deleteMultiplesOfThree() {
        DoublyLinkedListNode current = head;
        int counter = 0;
        while (current != null) {
            if (current.data % 3 == 0) {
                DoublyLinkedListNode nextNode = current.next; // Store the next node
                DoublyLinkedListNode prevNode = current.prev; // Store the previous node

                // Update the previous node's next pointer
                if (prevNode != null) {
                    prevNode.next = nextNode;
                } else {
                    head = nextNode; // Update head if the current node is the first node
                }

                // Update the next node's previous pointer
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                // Remove references from the current node
                current.next = null;
                current.prev = null;

                // Move to the next node
                current = nextNode;

                // Increment the counter
                counter++;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
        return counter;
    }

}
