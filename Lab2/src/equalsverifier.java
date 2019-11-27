//import org.junit.Assert;
import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.*;

class equalsverifier {

	@Test
	void test() {
		/*
		Person p1 = new Person("Aida", "Jester", "17.04.2000");
        Person p2 = new Person("Aida", "Jester", "17.04.2000");
        Person p3 = new Person("Artem", "Grinko", "06.10.1999");
        
        Assert.assertTrue(p1.equals(p1));
        
        Assert.assertTrue(p1.equals(p2));
        Assert.assertTrue(p2.equals(p1));
        
        Assert.assertFalse(p1.equals(p3));*/
		
		EqualsVerifier.forClass(Person.class).verify();
        
	}

}
