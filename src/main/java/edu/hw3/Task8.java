package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task8 {
    static class BackwardIterator<T> implements Iterator<T> {
        private final T[] collection;
        private int currentIndex;

        BackwardIterator(Collection<T> collection) {
            this.collection = (T[]) collection.toArray();
            currentIndex = collection.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0 && this.collection[currentIndex] != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return this.collection[currentIndex--];
        }
    }
}
