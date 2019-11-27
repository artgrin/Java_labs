package lab3;

public class Book implements Comparable<Book>{
	
	private String name, author, edition;
	private int year, pages;
	private long cost;
	
	Book(String name, String author, String edition, int year, int pages, long cost){
		SetAll(name, author, edition, year, pages, cost);
	}
	
	Book(){
		SetAll("NewBook", "Unknown", "Unknown", 0, 0, 0);
	}
	
	public String GetName() {
		return this.name;
	}
	
	public String GetAuthor() {
		return this.author;
	}
	
	public String GetEdition() {
		return this.edition;
	}
	
	public int GetYear() {
		return this.year;
	}
	
	public int GetPages() {
		return this.pages;
	}
	
	public long GetCost() {
		return this.cost;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetAuthor(String author) {
		this.author = author;
	}
	
	public void SetEdition(String edition) {
		this.edition = edition;
	}
	
	public void SetYear(int year) {
		this.year = year;
	}
	
	public void SetPages(int pages) {
		this.pages = pages;
	}
	
	public void SetCost(long cost) {
		this.cost = cost;
	}
	
	public void SetAll(String name, String author, String edition, int year, int pages, long cost)
	{
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.year = year;
		this.pages = pages;
		this.cost = cost;	
	}
	
	@Override
	public String toString()
	{
		return this.name + ", ���: " + this.author + ", ���.: " + this.edition + ", г�: " + String.valueOf(this.year) + ", ����.: " + String.valueOf(this.pages) + ", ֳ��: " + String.valueOf(this.cost);
	}
	
	@Override
	public int compareTo(Book other) {
		return this.name.compareTo(other.GetName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (int) (cost ^ (cost >>> 32));
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pages;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (cost != other.cost)
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pages != other.pages)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}

