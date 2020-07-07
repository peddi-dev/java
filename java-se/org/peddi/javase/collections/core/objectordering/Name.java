package org.peddi.javase.collections.core.objectordering;

import java.util.Objects;

public class Name implements Comparable<Name> {


    private String lastName;
    private String firstName;

    public Name(String fName, String lName) {

        Objects.requireNonNull(fName, "First Name is null");
        Objects.requireNonNull(lName, "Last Name is null");
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int hashCode() {
        int hashCode = 31 * getLastName().hashCode() + getLastName().hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Name)) {
            return false;
        }
        Name n2 = (Name) obj;
        return getLastName().equals(n2.getLastName())
                && getFirstName().equals(n2.getFirstName());
    }

    @Override
    public String toString() {
        return String.format("(firstName = %s, lastName = %s )", firstName, lastName);
    }

    @Override
    public int compareTo(Name o) {

        // check first most significant field first
        int lnc = getLastName().compareTo(o.getLastName());
        // if first most significant fields are equal then compare
        // 2nd most significant fields, otherwise return the first compare result
        // comparing parts by significance makes the comparision efficient
        return (lnc != 0) ? lnc : getFirstName().compareTo(o.getFirstName());
    }
}
