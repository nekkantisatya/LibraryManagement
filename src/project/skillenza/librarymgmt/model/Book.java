package project.skillenza.librarymgmt.model;

public class Book implements Cloneable 
{
	private String bookTitle;
	private double bookprice;
	private String authorName;
	private int numberOfCopies;

	public Book(){}
	public Book(String bookTitle,double bookprice,	String authorName, int numberOfCopies) {
		this.bookTitle = bookTitle;
		this.bookprice = bookprice;
		this.authorName = authorName;
		this.numberOfCopies = numberOfCopies;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopiesStr(String numberOfCopies) {
		if(numberOfCopies !=null && numberOfCopies.length() > 0)
		{	
			try {
				this.numberOfCopies = Integer.parseInt(numberOfCopies);
			} catch (NumberFormatException e) 
			{
				this.numberOfCopies = 0;
			}
		}
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	@Override
	public String toString() {
		return "[Book title=" + bookTitle + "  Total Copies Avl=" + numberOfCopies +"]";
	}
	
	public boolean equals(Book book) {
        if(bookTitle.equals(book.getBookTitle())) 
        	return true;
        else 
        	return false;
    }
	
	@Override
	public Book clone() {
		// TODO Auto-generated method stub
		Book book = new Book(bookTitle,bookprice,authorName,numberOfCopies);
		return book;
	}
}
