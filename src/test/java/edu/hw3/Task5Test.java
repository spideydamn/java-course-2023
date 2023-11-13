package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    void compareContacts(Task5.Contact[] expected, Task5.Contact[] actually) {
        assertEquals(expected.length, actually.length);
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i].getFirstName(), actually[i].getFirstName());
            assertEquals(expected[i].getLastName(), actually[i].getLastName());
        }
    }

    @Test
    @DisplayName("Проверка общих случаев")
    void checkGeneralCases() {
        //given
        String[] names1 = new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        int names1Len = names1.length;
        String[] names2 = new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        int names2Len = names2.length;

        Task5.Contact[] ansContacts1 = new Task5.Contact[names1Len];
        ansContacts1[0] = new Task5.Contact("Thomas", "Aquinas");
        ansContacts1[1] = new Task5.Contact("Rene", "Descartes");
        ansContacts1[2] = new Task5.Contact("David", "Hume");
        ansContacts1[3] = new Task5.Contact("John", "Locke");

        Task5.Contact[] ansContacts1Reversed = new Task5.Contact[names1Len];
        for (int i = 0; i < names1Len; ++i) {
            ansContacts1Reversed[i] = ansContacts1[names1Len - 1 - i];
        }

        Task5.Contact[] ansContacts2 = new Task5.Contact[names2Len];
        ansContacts2[0] = new Task5.Contact("Paul", "Erdos");
        ansContacts2[1] = new Task5.Contact("Leonhard", "Euler");
        ansContacts2[2] = new Task5.Contact("Carl", "Gauss");

        Task5.Contact[] ansContacts2Reversed = new Task5.Contact[names2Len];
        for (int i = 0; i < names2Len; ++i) {
            ansContacts2Reversed[i] = ansContacts2[names2Len - 1 - i];
        }


        //when
        Task5.Contact[] contacts1ASC = Task5.parseContacts(names1, "ASC");
        Task5.Contact[] contacts1DESC = Task5.parseContacts(names1, "DESC");
        Task5.Contact[] contacts2ASC = Task5.parseContacts(names2, "ASC");
        Task5.Contact[] contacts2DESC = Task5.parseContacts(names2, "DESC");

        //then
        compareContacts(ansContacts1, contacts1ASC);
        compareContacts(ansContacts1Reversed, contacts1DESC);
        compareContacts(ansContacts2, contacts2ASC);
        compareContacts(ansContacts2Reversed, contacts2DESC);
    }

    @Test
    @DisplayName("Проверка с отсутствием фамилли")
    void checkNoLastNameCases() {
        //given
        String[] names1 = new String[]{"John Locke", "Thomas", "David Hume", "Rene"};
        int names1Len = names1.length;
        String[] names2 = new String[]{"Paul Erdos", "Leonhard", "Carl Gauss"};
        int names2Len = names2.length;

        Task5.Contact[] ansContacts1 = new Task5.Contact[names1Len];
        ansContacts1[0] = new Task5.Contact("David", "Hume");
        ansContacts1[1] = new Task5.Contact("John", "Locke");
        ansContacts1[2] = new Task5.Contact("Rene");
        ansContacts1[3] = new Task5.Contact("Thomas");

        Task5.Contact[] ansContacts1Reversed = new Task5.Contact[names1Len];
        for (int i = 0; i < names1Len; ++i) {
            ansContacts1Reversed[i] = ansContacts1[names1Len - 1 - i];
        }

        Task5.Contact[] ansContacts2 = new Task5.Contact[names2Len];
        ansContacts2[0] = new Task5.Contact("Paul", "Erdos");
        ansContacts2[1] = new Task5.Contact("Carl", "Gauss");
        ansContacts2[2] = new Task5.Contact("Leonhard");

        Task5.Contact[] ansContacts2Reversed = new Task5.Contact[names2Len];
        for (int i = 0; i < names2Len; ++i) {
            ansContacts2Reversed[i] = ansContacts2[names2Len - 1 - i];
        }


        //when
        Task5.Contact[] contacts1ASC = Task5.parseContacts(names1, "ASC");
        Task5.Contact[] contacts1DESC = Task5.parseContacts(names1, "DESC");
        Task5.Contact[] contacts2ASC = Task5.parseContacts(names2, "ASC");
        Task5.Contact[] contacts2DESC = Task5.parseContacts(names2, "DESC");

        //then
        compareContacts(ansContacts1, contacts1ASC);
        compareContacts(ansContacts1Reversed, contacts1DESC);
        compareContacts(ansContacts2, contacts2ASC);
        compareContacts(ansContacts2Reversed, contacts2DESC);
    }
    @Test
    @DisplayName("Проверка крайних случаев")
    void checkEdgeCases() {
        //given
        String[] names1 = new String[]{};
        int names1Len = names1.length;
        String[] names2 = new String[]{"Paul Erdos"};
        int names2Len = names2.length;

        Task5.Contact[] ansContacts1 = new Task5.Contact[names1Len];

        Task5.Contact[] ansContacts1Reversed = new Task5.Contact[names1Len];

        Task5.Contact[] ansContacts2 = new Task5.Contact[names2Len];
        ansContacts2[0] = new Task5.Contact("Paul", "Erdos");

        Task5.Contact[] ansContacts2Reversed = ansContacts2;

        //when
        Task5.Contact[] contacts1ASC = Task5.parseContacts(names1, "ASC");
        Task5.Contact[] contacts1DESC = Task5.parseContacts(names1, "DESC");
        Task5.Contact[] contacts2ASC = Task5.parseContacts(names2, "ASC");
        Task5.Contact[] contacts2DESC = Task5.parseContacts(names2, "DESC");

        //then
        compareContacts(ansContacts1, contacts1ASC);
        compareContacts(ansContacts1Reversed, contacts1DESC);
        compareContacts(ansContacts2, contacts2ASC);
        compareContacts(ansContacts2Reversed, contacts2DESC);
    }

    @Test
    @DisplayName("Проверка null")
    void checkNullCase() {
        //given
        String[] names1 = null;
        Task5.Contact[] ansContacts1 = new Task5.Contact[]{};
        Task5.Contact[] ansContacts1Reversed = ansContacts1;

        //when
        Task5.Contact[] contacts1ASC = Task5.parseContacts(names1, "ASC");
        Task5.Contact[] contacts1DESC = Task5.parseContacts(names1, "DESC");

        //then
        compareContacts(ansContacts1, contacts1ASC);
        compareContacts(ansContacts1Reversed, contacts1DESC);
    }
}
