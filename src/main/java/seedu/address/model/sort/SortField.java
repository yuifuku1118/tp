package seedu.address.model.sort;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

enum SortFieldType {
    DATE, AMOUNT
}

public class SortField {

    public static final String MESSAGE_CONSTRAINTS =
            "Sort field should only be d(ate) or a(mount), and it should not be blank";

    public final SortFieldType value;

    /**
     * Constructs a {@code SortFieldType}.
     *
     * @param field A valid field.
     */
    public SortField(String field) {
        requireNonNull(field);
        checkArgument(isValidSortField(field), MESSAGE_CONSTRAINTS);
        value = getSortFieldType(field);
    }

    /**
     * Returns true if a given string is a valid field.
     */
    public static boolean isValidSortField(String test) {
        String gender = test.toLowerCase();
        return gender.equals("d") || gender.equals("date") || gender.equals("a") || gender.equals("amount");
    }

    private SortFieldType getSortFieldType(String input) {
        String gender = input.toLowerCase();
        if (gender.equals("d") || gender.equals("date")) {
            return SortFieldType.DATE;
        } else if (gender.equals("a") || gender.equals("amount")) {
            return SortFieldType.AMOUNT;
        } else {
            return null;
        }
    }

    public SortFieldType getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.name();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortField // instanceof handles nulls
                && value.name().equals(((SortField) other).value.name())); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
