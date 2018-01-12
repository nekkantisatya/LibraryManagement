package project.skillenza.librarymgmt.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User 
{
	private String userId;
	private String userFirstName;
	private String lastName;
	private String userAddress;
	private String emailAddress;
	private long mobileNumber;
	private Set<Book> booksList;
	public User() {}
	public User(String userId, String userFirstName, String lastName, String userAddress, String emailAddress,
			long mobileNumber) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.lastName = lastName;
		this.userAddress = userAddress;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void addBook(Book book)
	{
		if(booksList == null)
		{
			booksList = new HashSet<Book>();
			booksList.add(book);
		}
		else
		{
			booksList.add(book);
		}
	}

	public void deleteBook(Book book)
	{
		if(booksList !=null)
		{
			Iterator<Book> iter = booksList.iterator();
			while(iter.hasNext())
			{
				Book obj = iter.next();
				if(obj.equals(book))
					iter.remove();
			}
		}
	}

	public Book findBookByTitle(String title) 
	{
		if(booksList !=null)
		{
			for(Book obj: booksList)
			{
				if(obj.getBookTitle().equals(title))
				return obj;
			}
		}
		return null;
	}

	
	public boolean equals(User user) {
        if(userId.equals(user.getUserId())) 
        	return true;
        else 
        	return false;
    }

	
	@Override
	public String toString() {
		return "[User Id=" + userId +"  [Book"+booksList+"]]";
	}
}
