package tpu.company.com;

import tpu.company.Node;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public void addToEnd(T object) {
        Node<T> newObject = new Node<>();
        newObject.setData(object);
        if (tail == null) {
            head = newObject;
        } else {
            tail.setNext(newObject);
        }
        tail = newObject;
        size++;
    }

    public void deleteByIndex(int position) {
        if (head == null)
            return;
        Node<T> temp = head;
        if (position == 0) {
            head = temp.getNext();
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.getNext();
        if (temp == null || temp.getNext() == null)
            return;
        Node<T> next = temp.getNext().getNext();
        temp.setNext(next);
    }

    public int indexOf(T data) {
        int index = 0;
        if (data == null) {
            for (Node<T> x = head; x != null; x = x.getNext()) {
                if (x.getData() == null)
                    return index;
                index++;
            }
        } else {
            for (Node<T> x = head; x != null; x = x.getNext()) {
                if (data.equals(x.getData())) return index;
                else index++;
            }
        }
        return -1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.getNext();
        }
        return result.getData();
    }
    public int getSize() {
        return size;
    }
}