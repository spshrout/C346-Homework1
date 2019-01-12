package ius;



public class MyLinkedList<T> implements ILinkedList<T> {
        T value;
        ILinkedList<T> next = null;

    @Override
    public ILinkedList<T> next() {
        return next;
    }

    @Override
    public ILinkedList<T> last() {
        ILinkedList<T> current = this;
        while (current.next() != null)
            current = current.next();

        return current;
    }

    @Override
    public ILinkedList<T> after(int n) {
        ILinkedList<T> current = this;
        for(int i = 0; i < n; i++) {
            if (current.next() == null)
                throw new IllegalArgumentException("The requested element does not exist.");
            else
                current = current.next();

        }
        return current;
    }

    @Override
    public ILinkedList<T> detach() {
        if (next == null)
            throw new IllegalStateException("The next element does not exist.");
        else
        {
        ILinkedList<T> nextItem = next();
        next = null;
        return nextItem;
        }

    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public void set(T value) {
        this.value = value;
    }

    @Override
    public void setNext(ILinkedList<T> next) {
        this.next = next;
    }

    @Override
    public void append(ILinkedList<T> next) {
        ILinkedList<T> current = this;
        while (current.next() != null)
            current = current.next();
        current.setNext(next);
    }

    @Override
    public void insert(ILinkedList<T> newFirst) {
        if (newFirst == null)
            throw new IllegalArgumentException("An inserted element cannot be null.");
            else {
            newFirst.setNext(next);
            next = newFirst;
        }
    }
}
