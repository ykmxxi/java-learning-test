package collection;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleArrayList implements SimpleList {

    private static final int DEFAULT_SIZE = 10;
    private static final int MIN_SIZE = 0;

    private String[] array;
    private int size;

    public SimpleArrayList() {
        this.array = new String[DEFAULT_SIZE];
        this.size = 0;
    }

    public SimpleArrayList(final int initialSize) {
        if (initialSize < MIN_SIZE) {
            throw new IllegalArgumentException("%d 보다 작은 크기의 리스트를 생성할 수 없습니다.".formatted(MIN_SIZE));
        }
        this.array = new String[initialSize];
        this.size = 0;
    }

    @Override
    public boolean add(final String value) {
        if (isEmpty()) {
            this.array = Arrays.copyOf(array, 2);
            array[size++] = value;
            return true;
        }
        if (this.size >= array.length) {
            this.array = grow();
            array[size++] = value;
            return true;
        }
        array[size++] = value;
        return true;
    }

    @Override
    public void add(final int index, final String value) {
        if (size >= array.length) {
            this.array = grow();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    private String[] grow() {
        return Arrays.copyOf(array, size * 2);
    }

    @Override
    public String set(final int index, final String value) {
        return array[index] = value;
    }

    @Override
    public String get(final int index) {
        return array[index];
    }

    @Override
    public boolean contains(final String value) {
        return IntStream.range(0, size)
                .anyMatch(index -> array[index].equals(value));
    }

    @Override
    public int indexOf(final String value) {
        for (int index = 0; index < size; index++) {
            if (array[index].equals(value)) {
                return index;
            }
        }
        return -1;
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
        int removedIndex = indexOf(value);
        remove(removedIndex);
        return true;
    }

    @Override
    public String remove(final int index) {
        String removedValue = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1);
        this.size--;
        return removedValue;
    }

    @Override
    public void clear() {
        IntStream.range(0, size)
                .forEach(index -> array[index] = null);
        this.size = 0;
    }

}
