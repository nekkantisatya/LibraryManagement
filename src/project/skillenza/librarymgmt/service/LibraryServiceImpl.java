package project.skillenza.librarymgmt.service;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;

import project.skillenza.librarymgmt.model.Book;
import project.skillenza.librarymgmt.model.User;

public class LibraryServiceImpl implements LibraryService {

	private static final LibraryService SERVICE = new LibraryServiceImpl();
	private Set<User> users = null;
	private Set<Book> books = null;
	
	private LibraryServiceImpl(){}
	public static LibraryService getLibraryServiceImpl() 
	{
		return SERVICE;
	}
	
	@Override
	public void addUsers() {
		Console console = System.console();
		String opt = "Y";
		while(!opt.equalsIgnoreCase("N"))
		{
			User user = new User();
			System.out.print("Enter User Id::");
			user.setUserId(console.readLine());
/*			System.out.print("Enter First Name::");
			user.setUserFirstName(console.readLine());
			System.out.print("Enter Last Name::");
			user.setLastName(console.readLine());
			System.out.print("Enter User Address::");
			user.setUserAddress(console.readLine());
			System.out.print("Enter Email Address::");
			user.setEmailAddress(console.readLine());
			System.out.print("Enter Mobile Number::");
			user.setMobileNumber(Long.parseLong(console.readLine()));
*/			
			User usr = findUser(user);
			if( usr !=null )
			{
				System.out.println("Error::User is already exist");
			}
			else
			{
				addUser(user);
			}
			System.out.println("Do you want to add one more User?(Y/N)");
			opt = console.readLine();
		}
	}

	private void addUser(User user) 
	{
		if(users !=null)
		{
			users.add(user);
		}
		else
		{
			users = new HashSet<User>();
			users.add(user);
		}	
	}

	@Override
	public void addBooks() {
		Console console = System.console();
		String opt = "Y";
		while(!opt.equalsIgnoreCase("N"))
		{
			Book book = new Book();
			System.out.print("Enter Book Title::");
			book.setBookTitle(console.readLine());
/*			System.out.print("Enter Book Author::");
			book.setAuthorName(console.readLine()); 
			System.out.print("Enter Book Price::");
			book.setBookprice(Double.valueOf(console.readLine())); 
*/			System.out.print("Enter Number Of Copies::");
			book.setNumberOfCopiesStr(console.readLine()); 
			
			Book bk = findBook(book);
			if( bk !=null )
			{
				bk.setNumberOfCopies(bk.getNumberOfCopies()+book.getNumberOfCopies());
			}
			else
			{
				addBook(book);
			}
			System.out.println("Do you want to add one more Book?(Y/N)");
			opt = console.readLine();
		}
	}

	private Book findBook(Book book) {
		
		if(books !=null)
		{
			for(Book obj: books)
			{
				if(obj.equals(book))
				return obj;
			}
		}
		return null;
	}
	private Book findBookByTitle(String title) {
		
		if(books !=null)
		{
			for(Book obj: books)
			{
				if(obj.getBookTitle().equals(title))
				return obj;
			}
		}
		return null;
	}
	private User findUser(User user) 
	{
		if(users !=null)
		{
			for(User obj: users)
			{
				if(obj.equals(user))
				return obj;
			}
		}
		return null;
	}
	
	private User findUserById(String userId) 
	{
		if(users !=null)
		{
			for(User obj: users)
			{
				if(obj.getUserId().equals(userId))
				return obj;
			}
		}
		return null;
	}
	
	private void addBook(Book book) {
		
		if(books !=null)
		{
			books.add(book);
		}
		else
		{
			books = new HashSet<Book>();
			books.add(book);
		}
	}

	@Override
	public void lendBooks() 
	{
		Console console = System.console();
		String opt = "Y";
		while(!opt.equalsIgnoreCase("N"))
		{
			System.out.println("Enter Book Title");
			String title = console.readLine();
			Book book = findBookByTitle(title);
			if(book == null)
			{
				System.out.println("Error:Book Title is not found");
				break;
			}
			else
			{
				if(book.getNumberOfCopies() <= 0)
				{
					System.out.println("Error:Book is currently not available");
					break;
				}
				else
				{
					System.out.println("Enter User ID for Lending the Book with Title:"+title);
					String userId = console.readLine();
					User user = findUserById(userId);
					if(user == null)
					{
						System.out.println("Error:Book is currently not available");
						break;
					}
					else
					{
						Book bookfound = user.findBookByTitle(book.getBookTitle());
						if(bookfound == null)
						{
							Book cbook = book.clone();
							cbook.setNumberOfCopies(1);
							user.addBook(cbook);
							book.setNumberOfCopies(book.getNumberOfCopies()-1);
							System.out.println("Book "+title+" is successfully issued to "+userId);
						}
						else
						{
							System.out.println("Error:Same Book is already issued to "+userId);
						}
					}
				}
			}
			System.out.println("Do you want to lend one more Book?(Y/N)");
			opt = console.readLine();
		}
		
	}

	@Override
	public void returnBooks() {
		Console console = System.console();
		String opt = "Y";
		while(!opt.equalsIgnoreCase("N"))
		{
			System.out.println("Enter User Id");
			String userId = console.readLine();
			User user = findUserById(userId);
			if(user == null)
			{
				System.out.println("Error:User "+userId+" is not found");
				break;
			}
			else
			{
				
				System.out.println("Enter Book Title that you want to return");
				String bookTitle = console.readLine();
				Book book = user.findBookByTitle(bookTitle);

				if(book == null)
					System.out.println("Error:Book ID does not exist with user "+userId);
				else
				{	
					user.deleteBook(book);
					Book book1 = findBookByTitle(bookTitle);
					book1.setNumberOfCopies(book1.getNumberOfCopies()+1);
					System.out.println("Book with title "+bookTitle+" is returned by user:"+userId);
				}
			}
			System.out.println("Do you want to return one more Book?(Y/N)");
			opt = console.readLine();
		}
	}

	@Override
	public void searchUser() 
	{
		Console console = System.console();
		String opt = console.readLine();
		while(!opt.equalsIgnoreCase("N"))
		{
			System.out.println("Enter User Id that you want to search");
			String userId = console.readLine();
			
			User usr = findUserById(userId);
			if( usr==null )
			{
				System.out.println("Error::User is not exist");
			}
			else
			{
				System.out.println("User is found "+usr);
			}
			System.out.println("Do you want to add one more User?(Y/N)");
			opt = console.readLine();
		}
	}
	@Override
	public void searchBook() 
	{
		System.out.println("Do you want to search Book details?:(Y/N)");
		Console console = System.console();
		String opt = console.readLine();
		while(!opt.equalsIgnoreCase("N"))
		{
			System.out.println("Enter Book title that you want to search");
			String bookTitle = console.readLine();
			
			Book book = findBookByTitle(bookTitle);
			if( book==null )
			{
				System.out.println("Error::Book is not exist");
			}
			else
			{
				System.out.println("Book is found "+book);
			}
			System.out.println("Do you want to add one more User?(Y/N)");
			opt = console.readLine();
		}
		
	}
	@Override
	public void viewBooks() 
	{
		
		if(books !=null)
			for(Book obj: books)
				System.out.println(obj);

		if(users !=null)
			for(User obj: users)
				System.out.println(obj);
	}
}
