package edu.hw5;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import static java.util.regex.Pattern.matches;

public class Task3 {
    private Task3() {}

    public static Optional<LocalDate> parseDate(String string) {
        if (string == null) {
            return Optional.empty();
        }

        final String regexDate1 = "^([1-9][0-9]{3})-([1-9][0-9]?)-([1-9][0-9]?)$";
        final String regexDate2 = "^([1-9][0-9]?)\\/([1-9][0-9]?)\\/([1-9][0-9]{3})$";
        final String regexShortDate2 = "^([1-9][0-9]?)\\/([1-9][0-9]?)\\/([1-9][0-9])$";
        final String regexNextPresPrevDay = "^((tomorrow)|(today)|(yesterday))$";
        final String regexDaysAgo = "(?:(?!(^1 days ago$))(^((1 day ago)|([1-9][0-9]* days ago))$))";

        if (matches(regexDate1, string)) {
            String[] stringDate = string.split("-");
            return Optional.of(LocalDate.of(Integer.parseInt(stringDate[0]), Integer.parseInt(stringDate[1]), Integer.parseInt(stringDate[2])));
        } else if (matches(regexDate2, string)) {
            String[] stringDate = string.split("/");
            return Optional.of(LocalDate.of(Integer.parseInt(stringDate[2]), Integer.parseInt(stringDate[1]), Integer.parseInt(stringDate[0])));
        } else if (matches(regexShortDate2, string)) {
            String[] stringDate = string.split("/");
            return Optional.of(LocalDate.of(2000 + Integer.parseInt(stringDate[2]), Integer.parseInt(stringDate[1]), Integer.parseInt(stringDate[0])));
        } else if (matches(regexNextPresPrevDay, string)) {
            switch (string) {
                case ("tomorrow") :
                    return Optional.of(LocalDate.now().plusDays(1));
                case ("today") :
                    return Optional.of(LocalDate.now());
                case ("yesterday") :
                    return Optional.of(LocalDate.now().minusDays(1));
            }
        } else if (matches(regexDaysAgo, string)) {
            String[] stringDate = string.split(" ");
            return Optional.of(LocalDate.now().minusDays(Integer.parseInt(stringDate[0])));
        }
        return Optional.empty();
    }
}
