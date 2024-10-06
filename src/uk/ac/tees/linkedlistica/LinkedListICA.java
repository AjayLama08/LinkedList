package uk.ac.tees.linkedlistica;

/**
 * The project main class (intentionally empty).
 *
 * @author Your Name (X0000000@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class LinkedListICA {

    /**
     * The entry point for your program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* This main method is intentionally left blank. You should test your
         * code using the unit tests provided, and/or write your own if you're
         * feeling up to it. You may also write code here to test your ADTs.
         */
        int[] a = {1, 2, 3, 4, 5, 6};
        SinglyLinkedList sl = new SinglyLinkedList(a);
//        System.out.println(sl.getSize());
//        System.out.println(sl.getSecond());
//        System.out.println(sl.getAtPos(5));
//        System.out.println(sl.addAfterPos(6, 4));
//        sl.reverseOrderLinkedList();

        DoublyLinkedList dl = new DoublyLinkedList(a);
//        System.out.println(dl.isEmpty());
//        System.out.println(dl.toString());
//        System.out.println(dl.countNodesWithValue(6));
//        System.out.println(dl.addAtPos(8, 0));
//        System.out.println(dl.deleteMultiplesOfThree()); 

        CircularLinkedList cl = new CircularLinkedList(a);
//        System.out.println(cl.getSize());
//        System.out.println(cl.getLast());
//        System.out.println(cl.deleteAllNodesWithValue(8));
//        System.out.println(cl.deleteAtPos(2));
//        System.out.println(cl.sum());
    }

}
