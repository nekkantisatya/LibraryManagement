
package project.skillenza.librarymgmt;

import java.io.Console;

import project.skillenza.librarymgmt.service.LibraryServiceImpl;

public class LibraryManagementSystem 
{
	public static void main(String[] args) 
	{
		Console console = System.console();
		String option="0";
		System.out.println("****Welcome To Library Management System****");

		while(!option.equals("6"))
		{
			System.out.println("\n\n     	Enter your choice(1-8)			 ");
			System.out.println("              1 - Add Books                  ");
			System.out.println("              2 - Add Users                  ");
			System.out.println("              3 - Lending Books              ");
			System.out.println("              4 - Return Books               ");
			System.out.println("              5 - Search Books               ");
			System.out.println("              6 - Search User                ");
			System.out.println("              7 - View Library Detail        ");
			System.out.println("              8 - Exit				         ");
			option = console.readLine();
			switch(option)
			{
				case "1": 
							LibraryServiceImpl.getLibraryServiceImpl().addBooks();
							break;
				case "2": 
							LibraryServiceImpl.getLibraryServiceImpl().addUsers();
				  		  	break;
				case "3": 
							LibraryServiceImpl.getLibraryServiceImpl().lendBooks();
				  		  	break;
				case "4": 
							LibraryServiceImpl.getLibraryServiceImpl().returnBooks();
							break;
				case "5": 
							LibraryServiceImpl.getLibraryServiceImpl().searchBook();
				  		  	break;
				case "6": 
							LibraryServiceImpl.getLibraryServiceImpl().searchUser();
				  		  	break;
				case "7": 
							LibraryServiceImpl.getLibraryServiceImpl().viewBooks();
							break;
				case "8": 	System.exit(0);
			}
		}
	}
}
