public class Person {
    private String firstName;
    private String lastName;
    private boolean isUSCitizen;
    private short yearOfBirth;

    // Constructor
    public Person(String firstName, String lastName, boolean isUSCitizen, short yearOfBirth) {
        setFirstName(firstName);
        setLastName(lastName);
        this.isUSCitizen = isUSCitizen;
        setYearOfBirth(yearOfBirth);
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isUSCitizen() {
        return isUSCitizen;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    // Setters with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    public void setYearOfBirth(short yearOfBirth) {
        if (yearOfBirth < 1900 || yearOfBirth > 2024) {
            throw new IllegalArgumentException("Year of birth must be between 1900 and 2024.");
        }
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format("Person[firstName='%s', lastName='%s', isUSCitizen=%b, yearOfBirth=%d]",
                firstName, lastName, isUSCitizen, yearOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (isUSCitizen != person.isUSCitizen) return false;
        if (yearOfBirth != person.yearOfBirth) return false;
        if (!firstName.equals(person.firstName)) return false;
        return lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (isUSCitizen ? 1 : 0);
        result = 31 * result + yearOfBirth;
        return result;
    }
}
