import java.util.HashSet;
import java.util.Iterator;

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

    // Test methods
    public static void testPersonClass() {
        Person person1 = new Person("John", "Doe", true, (short) 1990);
        Person person2 = new Person("Jane", "Doe", false, (short) 1985);

        System.out.println(person1.toString());
        System.out.println("Are persons equal? " + person1.equals(person2));
        System.out.println("HashCode of person1: " + person1.hashCode());
        System.out.println("HashCode of person2: " + person2.hashCode());
    }

    public static void testHashSet() {
        HashSet<Person> peopleSet = new HashSet<>();

        // Add 10 random Persons to the set
        peopleSet.add(new Person("Alice", "Smith", true, (short) 1992));
        peopleSet.add(new Person("Bob", "Johnson", false, (short) 1980));
        peopleSet.add(new Person("Charlie", "Williams", true, (short) 1975));
        peopleSet.add(new Person("David", "Brown", true, (short) 1995));
        peopleSet.add(new Person("Eva", "Jones", false, (short) 1999));
        peopleSet.add(new Person("Frank", "Garcia", true, (short) 1965));
        peopleSet.add(new Person("Grace", "Martinez", false, (short) 2000));
        peopleSet.add(new Person("Hank", "Rodriguez", true, (short) 1988));
        peopleSet.add(new Person("Ivy", "Lopez", false, (short) 1991));
        peopleSet.add(new Person("Jack", "Miller", true, (short) 1982));

        // Confirm that all Persons are in the set
        System.out.println("All people added to the set:");

        for (Person person : peopleSet) {
            System.out.println(person);
        }

        // Confirm the set's iterator returns elements in a different order than insertion
        Iterator<Person> iterator = peopleSet.iterator();
        System.out.println("\nIterating over the set:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        testPersonClass();
        testHashSet();
    }
}