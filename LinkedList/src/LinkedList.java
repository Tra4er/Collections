import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedList {
    private Node head;

    public void append(int newValue) {
        if (head == null) {
            head = new Node(newValue);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(newValue);
    }

    public void prepend(int newValue) {
        Node newHead = new Node(newValue);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int value) {
        if (head == null) {
            return;
        }
        if (head.value == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean isLoop() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean fixLoop() {
        Set<Node> nodes = new HashSet<>();
        Node current = head;
        nodes.add(head);
        while (current != null) {
            if (nodes.contains(current.next)) {
                current.next = null;
            }
            nodes.add(current);
            current = current.next;
        }
        return false;
    }

    public void makeLoop() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head.next;
    }
    @Override
    public String toString() {
        String result = "";
        Node current = head;
        while (current.next != null) {
            result += current.value;
            current = current.next;
        }
        result += current.value;
        return result;
    }
}
