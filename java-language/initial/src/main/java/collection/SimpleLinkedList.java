package collection;

public class SimpleLinkedList implements SimpleList {

    private Node head;
    private int size;

    public SimpleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean add(final String value) {
        if (this.size == 0) {
            head = new Node(value);
            size++;
        }
        return true;
    }

    @Override
    public void add(final int index, final String value) {
        Node beforeNode = head;
        Node originNode = null;
        for (int i = 0; i < index - 1; i++) {
            beforeNode = beforeNode.next;
            originNode = beforeNode.next;
        }
        Node newNode = new Node(value);
        beforeNode.next = newNode;
        newNode.next = originNode;
    }

    @Override
    public String set(final int index, final String value) {
        int currentIndex = 0;
        Node targetNode = head;
        while (currentIndex < size) {
            targetNode = head.next;
            currentIndex++;
        }
        targetNode.value = value;
        return value;
    }

    @Override
    public String get(final int index) {
        int currentIndex = 0;
        Node targetNode = head;
        while (currentIndex < size) {
            targetNode = head.next;
            currentIndex++;
        }
        return targetNode.value;
    }

    @Override
    public boolean contains(final String value) {
        Node iter = head;
        while (iter.next != null) {
            if (iter.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(final String value) {
        Node iter = head;
        int currentIndex = 0;
        while (iter.next != null) {
            if (iter.value.equals(value)) {
                break;
            }
            currentIndex++;
        }
        return currentIndex;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean remove(final String value) {
        Node iterBefore = null;
        Node iter = head;
        while (iter != null) {
            if (iter.value.equals(value)) {
                if (iter == head) {
                    head = iter.next;
                    break;
                }
                iterBefore.next = iter.next;
            }
            iterBefore = iter;
            iter = iter.next;
        }
        return false;
    }

    @Override
    public String remove(final int index) {
        int currentIndex = 0;
        Node prevTargetNode = null;
        Node targetNode = head;
        while (currentIndex < size) {
            prevTargetNode = targetNode;
            targetNode = targetNode.next;
            currentIndex++;
        }
        if (prevTargetNode == null) {
            String removedValue = head.value;
            head = targetNode.next;
            return removedValue;
        }
        String removedValue = targetNode.value;
        prevTargetNode.next = targetNode.next;
        targetNode = null;
        return removedValue;
    }

    @Override
    public void clear() {
        head = null;
    }

    private static class Node {

        private String value;
        private Node next;

        public Node(final String value) {
            this.value = value;
            this.next = null;
        }

    }

}
