package edu.hw3;

import java.io.Serializable;
import java.util.Comparator;

public class Task7 {
    private Task7() {}

    static final class NullComparator<T> implements Comparator<T>, Serializable {
        private final Comparator<T> real;

        NullComparator() {
            this.real = (Comparator<T>) Comparator.naturalOrder();
        }

        @Override
        public int compare(T a, T b) {
            if (a == null) {
                return (b == null) ? 0 : -1;
            } else if (b == null) {
                return 1;
            } else {
                return (real == null) ? 0 : real.compare(a, b);
            }
        }
    }
}
