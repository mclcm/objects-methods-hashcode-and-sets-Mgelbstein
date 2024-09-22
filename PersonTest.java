import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class PersonTest {
    // Test methods
    @Test
    public void testPersonClass() {
        Person person1 = new Person("John", "Doe", true, (short) 1990);
        Person person2 = new Person("Jane", "Doe", false, (short) 1985);

        System.out.println(person1.toString());
        System.out.println("Are persons equal? " + person1.equals(person2));
        System.out.println("HashCode of person1: " + person1.hashCode());
        System.out.println("HashCode of person2: " + person2.hashCode());
    }
    @Test
    public void testHashSet() {
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
}
