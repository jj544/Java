/* Time spent on a2:  hh hours and mm minutes.
 * Name:  Jian Jiang, Zhe Nan
 * Netid: jj544, zn45
 * What we thought about this assignment:
 *
 *
 */

/** An instance is a circular doubly linked list. */
public class CircularLinkedList<E> {
    private Node head; // a node of linked list (null if none)
    private int size;  // Number of nodes in linked list.

    /** Constructor: an empty linked list. */
    public CircularLinkedList() {
    }

    /** Return the number of values in this list. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node getFirst() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node getLast() {
        if (head == null)
            return null;
        return head.pred;
    }

    /** If this circular list is empty, return null.
     *  Otherwise, move down the list in circular fashion, so that the
     *  first node becomes the last node, the second becomes the first, ec. */
    public Node moveDown() {
        if (head != null) {
            head= head.succ;
        }
        return head;
    }

    /** Return the value of node e of this list.
     * Precondition: e must be a node of this list; it may not be null. */
    public E valueOf(Node e) {
        assert e != null;
        return e.value;
    }

    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[6, 3, 8]". */
    public String toString() {
        String a = new String();
        a += '[';
        if(head != null) {   
            Node b = head.succ;
            a += head.value;
            moveDown();
            while(head != null  && head.succ != b){
                a += ',';
                a += head.value;
                moveDown();
            }
        }
        a += ']';
        return a.toString();
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[8, 3, 6]".*/
    public String toStringReverse() {
        String a = new String();
        a += '[';
        if(head != null) {   
            Node b = head.pred;
            a += b.value;
            head = head.pred;
            while(head != null  && head.pred != b){
                a += ',';
                a += valueOf(head.pred);
                head = head.pred;
            }
        }
        a += ']';
        return a.toString();
    }

    /** Append value v to the list. */
    public void append(E v) {
        if (head == null) {
            Node a = new Node(null, v ,null);
            a.pred = a;
            a.succ = a;
            head = a;
        } else {
            Node a = new Node(null, v, null);
            a.pred = head.pred;
            a.succ = head;
            head.pred.succ = a;
            head.pred = a;
        }
        size +=1;
    }

    /** Prepend value v to the list. */
  
    public void prepend(E v) {
         if (head == null) {
            Node a = new Node(null, v ,null);
            a.pred = a;
            a.succ = a;
            head = a;
         } else {
            Node a = new Node(null, v, null);
            a.pred = head.pred;
            a.succ = head;
            head.pred.succ = a;
            head.pred = a;
            head = a;
        }
        size +=1;
    }

    /** Insert value v in a new node before node e of this circular list.
     * Precondition: e must be a node of this list, i.e. it may not be null. */
    public void insertBefore(E v, Node e) {
        assert e != null;
        Node a = new Node(null, v, null);
            a.pred = e.pred;
            a.succ = e;
            e.pred.succ = a;
            e.pred = a;
            size += 1;
    }

    /** Insert value v in a new node after node e.
     * Precondition: e must be a node of this list, i.e. it may not be null. */
    public void insertAfter(E v, Node e) {
        assert e != null;
        Node a = new Node(null, v, null);
            a.pred = e;
            a.succ = e.succ;
            e.succ.pred = a;
            e.succ = a;
            size += 1;
    }

    /** Remove node e from this list.
     *  Precondition: e must be a node of this list, i.e. it may not be null. */
    public void remove(Node e) {
        assert e != null;
        if (e == head)
            moveDown();
        if (size == 1)
            head = null;
        else {
        e.pred.succ = e.succ;
        e.succ.pred = e.pred;
        size -= 1;
        }
    } 



    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        /** Predecessor of this node on the list (null if the list is empty). */
        private Node pred;

        /** The value of this element. */
        private E value; 

        /** Successor of this node on the list. (null if the list is empty). */
        private Node succ; 

        /** Constructor: an instance with predecessor p (p can be null),
         * successor s (s can be null), and value v. */
        private Node(Node p, E v, Node s) {
            pred= p;
            value= v;
            succ= s;
        }

        /** Return the value of this node. */
        public E getValue() {
            return value;
        }

        /** Return the predecessor of this node e in the list. */
        public Node predecessor() {
            return pred;
        }

        /** Return the successor of this node in this list. */
        public Node successor() {
            return succ;
        }
    }

}
