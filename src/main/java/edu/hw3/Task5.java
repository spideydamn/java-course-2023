package edu.hw3;

public class Task5 {
    private Task5() {}

    private static void sortContactsASC(Contact[] contacts, int l, int r) {
        int i = l;
        int j = r;
        Contact pivot = contacts[(l + r + 1) / 2];
        Contact temp;

        while (i < j) {

            while (contacts[i].getComparedValue().compareTo(pivot.getComparedValue()) < 0) {
                ++i;
            }
            while (contacts[j].getComparedValue().compareTo(pivot.getComparedValue()) > 0) {
                --j;
            }
            if (i <= j) {
                temp = contacts[i];
                contacts[i] = contacts[j];
                contacts[j] = temp;
                ++i;
                --j;
            }
        }
        if (l < j) {
            sortContactsASC(contacts, l, j);
        }
        if (r > j) {
            sortContactsASC(contacts, i, r);
        }
    }

    private static void sortContactsDESC(Contact[] contacts, int l, int r) {
        sortContactsASC(contacts, l, r);
        Contact temp;
        int contactsLen = contacts.length;
        for (int i = 0; i < contactsLen / 2; ++i) {
            temp = contacts[i];
            contacts[i] = contacts[contactsLen - 1 - i];
            contacts[contactsLen - 1 - i] = temp;
        }
    }

    public static Contact[] parseContacts(String[] names, String sortMode) {
        if (names == null) {
            return new Contact[]{};
        }

        int numberOfContacts = names.length;

        if (numberOfContacts == 0) {
            return new Contact[]{};
        }

        Contact[] contacts = new Contact[numberOfContacts];

        for (int i = 0; i < numberOfContacts; ++i) {
            String[] splitting = names[i].split(" ");

            if (splitting.length == 1) {
                contacts[i] = new Contact(splitting[0]);
            } else {
                contacts[i] = new Contact(splitting[0], splitting[1]);
            }
        }

        if (sortMode.equals("ASC")) {
            sortContactsASC(contacts, 0, numberOfContacts - 1);
        } else {
            sortContactsDESC(contacts, 0, numberOfContacts - 1);
        }

        return contacts;
    }

    public static class Contact {
        private final String firstName;
        private final String lastName;

        public Contact(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Contact(String firstName) {
            this.firstName = firstName;
            this.lastName = null;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getComparedValue() {
            if (this.lastName == null) {
                return this.firstName;
            }
            return this.lastName;
        }
    }
}
