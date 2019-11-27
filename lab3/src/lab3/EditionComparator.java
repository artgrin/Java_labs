package lab3;

import java.util.Comparator;

public class EditionComparator implements Comparator<Book>{
	public int compare(Book b1, Book b2) {
		return b1.GetEdition().compareTo(b2.GetEdition());
    }
}