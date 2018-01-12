package project.skillenza.librarymgmt.service;


public interface LibraryService {

	public static final byte BOOKS_BORROW_LIMIT=3;
	
	public abstract void addUsers();
	public abstract void addBooks();
	public abstract void lendBooks();
	public abstract void returnBooks();
	public abstract void searchUser();
	public abstract void searchBook();
	public abstract void viewBooks();
}
