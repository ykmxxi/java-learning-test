package collection;

public class SimpleLinkedList<T> implements SimpleList<T> {

    private Node<T> head;
    private int size;

    public SimpleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean add(final T value) {
        if (this.size == 0) {
            head = new Node<>(value);
            size++;
            return true;
        }
        int currentIndex = 0;
        Node<T> prev = head;
        while (++currentIndex < size) {
            prev = prev.next;
        }
        prev.next = new Node<>(value);
        size++;
        return true;
    }

    @Override
    public void add(final int index, final T value) {
        Node<T> beforeNode = head;
        Node<T> originNode = null;
        for (int i = 0; i < index - 1; i++) {
            beforeNode = beforeNode.next;
            originNode = beforeNode.next;
        }
        Node<T> newNode = new Node<>(value);
        beforeNode.next = newNode;
        newNode.next = originNode;
    }

    @Override
    public T set(final int index, final T value) {
        int currentIndex = 0;
        Node<T> targetNode = head;
        while (currentIndex < size) {
            targetNode = targetNode.next;
            currentIndex++;
        }
        targetNode.value = value;
        return value;
    }

    @Override
    public T get(final int index) {
        int currentIndex = 0;
        Node<T> targetNode = head;
        while (currentIndex < index) {
            targetNode = targetNode.next;
            currentIndex++;
        }
        return targetNode.value;
    }

    @Override
    public boolean contains(final T value) {
        Node<T> iter = head;
        while (iter.next != null) {
            if (iter.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(final T value) {
        Node<T> iter = head;
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
    public boolean remove(final T value) {
        Node<T> iterBefore = null;
        Node<T> iter = head;
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
    public T remove(final int index) {
        int currentIndex = 0;
        Node<T> prevTargetNode = null;
        Node<T> targetNode = head;
        while (currentIndex < size) {
            prevTargetNode = targetNode;
            targetNode = targetNode.next;
            currentIndex++;
        }
        if (prevTargetNode == null) {
            T removedValue = head.value;
            head = targetNode.next;
            return removedValue;
        }
        T removedValue = targetNode.value;
        prevTargetNode.next = targetNode.next;
        targetNode = null;
        return removedValue;
    }

    @Override
    public void clear() {
        head = null;
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;

        public Node(final T value) {
            this.value = value;
            this.next = null;
        }

    }

}
