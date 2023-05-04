// Java Program to Illustrate Application CLass
// To Create The Menu For the Program

// Importing required classes
import java.util.Scanner;
import java.time.LocalDate;


// Class
public class Library {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of Scanner class
		// to take input from user
		Scanner input = new Scanner(System.in);

		// Displaying menu
		System.out.println("******************** Welcome to the Library Management System !********************");

		System.out.println("Login user: ");
		String username = input.nextLine();

		System.out.println("Password: ");
		String Password = input.nextLine();
		if(username.equals("admin")&& Password.equals("123")){
		System.out.println("				 Welcome Admin ");
		LocalDate dt = LocalDate.now();
				 dt = LocalDate.now();
		System.out.println("				 Date:	" + dt );
		System.out.println();
		System.out.println("				 Select From The Following Options:			 ");
		System.out.println();
		System.out.println("**********************************************************************");

		// Creating object of book class
		books ob = new books();
		// Creating object of students class
		Readers obReader = new Readers();

		int choice;
		int searchChoice;

		// Creating menu
		// using do-while loop
		do {

			ob.dispMenu();
			choice = input.nextInt();

			// Switch case
			switch (choice) {

			case 1:
				book b = new book();
				ob.addBook(b);
				break;

			// Case
			case 2:

				System.out.println(
					" press 1 to Search with Book Serial No.");
				System.out.println(
					" Press 2 to Search with Book's Author Name.");
				searchChoice = input.nextInt();

				// Nested switch
				switch (searchChoice) {

					// Case
				case 1:
					ob.searchByName();
					break;

					// Case
				case 2:
					ob.searchByAuthorName();
				}
				break;

				// Case
			case 3:
				ob.RemoveBook();
				break;
			case 4:
				ob.showAllBooks();
				break;
				// Case
			case 5:
				Reader s = new Reader("mo","123");
				obReader.addReader(s);
				break;

				// Case
			case 6:
				obReader.showAllReaders();
				break;

				// Case
			case 7:
				obReader.checkOutBook(ob);
				break;

				// Case
			case 8:
				obReader.checkInBook(ob);
				break;

			default:
				System.out.println("Quit system");
			}

		}

		while (choice != 0);
	}
		}
		
}
