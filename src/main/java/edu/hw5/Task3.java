package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import static java.util.regex.Pattern.matches;

public class Task3 {
    private Task3() {
    }

    @SuppressWarnings("MagicNumber")
    public static Optional<LocalDate> parseDate(String string) {
        if (string == null) {
            return Optional.empty();
        }

        Optional<LocalDate> ans = Optional.empty();

        final String regexDate1 = "^([1-9][0-9]{3})-([1-9][0-9]?)-([1-9][0-9]?)$";
        final String regexDate2 = "^([1-9][0-9]?)\\/([1-9][0-9]?)\\/([1-9][0-9]{3})$";
        final String regexShortDate2 = "^([1-9][0-9]?)\\/([1-9][0-9]?)\\/([1-9][0-9])$";
        final String regexNextPresPrevDay = "^((tomorrow)|(today)|(yesterday))$";
        final String regexDaysAgo = "(?:(?!(^1 days ago$))(^((1 day ago)|([1-9][0-9]* days ago))$))";

        if (matches(regexDate1, string)) {
            String[] stringDate = string.split("-");
            ans = Optional.of(LocalDate.of(Integer.parseInt(stringDate[0]),
                Integer.parseInt(stringDate[1]),
                Integer.parseInt(stringDate[2])
            ));
        } else if (matches(regexDate2, string)) {
            String[] stringDate = string.split("/");
            ans = Optional.of(LocalDate.of(Integer.parseInt(stringDate[2]),
                Integer.parseInt(stringDate[1]),
                Integer.parseInt(stringDate[0])
            ));
        } else if (matches(regexShortDate2, string)) {
            String[] stringDate = string.split("/");
            ans = Optional.of(LocalDate.of(2000 + Integer.parseInt(stringDate[2]),
                Integer.parseInt(stringDate[1]),
                Integer.parseInt(stringDate[0])
            ));
        } else if (matches(regexNextPresPrevDay, string)) {
            switch (string) {
                case ("tomorrow"):
                    ans = Optional.of(LocalDate.now().plusDays(1));
                    break;
                case ("today"):
                    ans = Optional.of(LocalDate.now());
                    break;
                case ("yesterday"):
                    ans = Optional.of(LocalDate.now().minusDays(1));
                    break;
                default:
                    ans = Optional.empty();
                    break;
            }
        } else if (matches(regexDaysAgo, string)) {
            String[] stringDate = string.split(" ");
            ans = Optional.of(LocalDate.now().minusDays(Integer.parseInt(stringDate[0])));
        }
        return ans;
    }
}
