// Java Program to Illustrate books class
// To Do all the Operations related to Books such as
// add, check-in, check-out,Valid books,Update books

// Importing required classes
import java.util.Scanner;

// CLass
public class books {

	// Class data members
	book theBooks[] = new book[50];
	public static int count;

	Scanner input = new Scanner(System.in);

	// Method 1
	// To compare books
	public int compareBookObjects(book b1, book b2)
	{

		// If book name matches
		if (b1.bookName.equalsIgnoreCase(b2.bookName)) {

			// Printing book exists
			System.out.println(
				"Book of this Name Already Exists.");
			return 0;
		}

		
		return 1;
	}

	// Method 2
	// To add book and remove
	public void addBook(book b)
	{

		for (int i = 0; i < count; i++) {

			if (this.compareBookObjects(b, this.theBooks[i])== 0)
				return;
		}

		if (count < 50) {

			theBooks[count] = b;
			count++;
		}
		else {

			System.out.println(
				"No Space to Add More Books.");
		}
	}
    // to remove
    public void RemoveBook(){
        System.out.println("\t\t\t\tSEARCH BY Book'S NAME");
        String deletedB = input.nextLine();
        
        for (int i = 0; i < count; i++) {
            if (!theBooks[i].bookName.equals(deletedB)) {
                for(int j = i; j < theBooks.length -1; j++){
                    theBooks[j] = theBooks[j + 1];
                  }
            }
        }
    }

	// Method 3
	// To search book by Name book
	public void searchByName()
	{

		// Display message
		System.out.println(
			"\t\t\t\tSEARCH BY SERIAL NUMBER\n");

		// Class data members
		System.out.println("Enter Serial No of Book:");
		String bookname = input.nextLine();

		int flag = 0;
		System.out.println(
			"S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {
			if (bookname.equalsIgnoreCase(theBooks[i].bookName)) {
				System.out.println(
					 theBooks[i].bookName + "\t\t"
					+ theBooks[i].authorName + "\t\t"
					+ theBooks[i].bookQtyCopy + "\t\t"
					+ theBooks[i].bookQty);
				flag++;
				return;
			}
		}
		if (flag == 0)
			System.out.println("No Book for Serial No "
							+ bookname + " Found.");
	}

	// Method 4
	// To search author by name
	public void searchByAuthorName()
	{

		// Display message
		System.out.println(
			"\t\t\t\tSEARCH BY AUTHOR'S NAME");

		input.nextLine();

		System.out.println("Enter Author Name:");
		String authorName = input.nextLine();

		int flag = 0;

		System.out.println(
			"S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {

			// if author matches any of its book
			if (authorName.equalsIgnoreCase(
					theBooks[i].authorName)) {

				// Print below corresponding credentials
				System.out.println(
					theBooks[i].bookName + "\t\t"
					+ theBooks[i].authorName + "\t\t"
					+ theBooks[i].bookQtyCopy + "\t\t"
					+ theBooks[i].bookQty);
				flag++;
			}
		}

		// Else no book matches for author
		if (flag == 0)
			System.out.println("No Books of " + authorName
							+ " Found.");
	}

	// Method 5
	// To display all books
	public void showAllBooks()
	{

		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println(
			"Name\t\tAuthor\t\tAvailable Qty\t\t");

		for (int i = 0; i < count; i++) {

			System.out.println(
				 theBooks[i].bookName + "\t\t"
				+ theBooks[i].authorName + "\t\t"
				+ theBooks[i].bookQtyCopy + "\t\t");
		}
	}


	// Method 7
	// To create menu
	public void dispMenu()
	{

		// Displaying menu
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("Press 1 to Add new Book.");
		System.out.println("Press 2 to Search a Book.");
		System.out.println("Press 3 to remove a Book.");
		System.out.println("Press 4 to Show All Books.");
		System.out.println("Press 5 to Register Reader.");
		System.out.println("Press 6 to Show All Registered Readers.");
		System.out.println("Press 7 to Check Out Book. ");
		System.out.println("Press 8 to Check In Book");
		System.out.println("Press 0 to Exit Application.");
		System.out.println("-------------------------------------------------------------------------------------------------------");
	}

	// Method 8
	// To search the library
	public int isAvailable(String sNo){

		for (int i = 0; i < count; i++) {
			if (sNo == theBooks[i].bookName) {
				if (theBooks[i].bookQtyCopy > 0) {

					System.out.println(
						"Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}

		System.out.println("No Book of Serial Number "
						+ " Available in Library.");
		return -1;
	}

	// Method 9
	// To remove the book from the library
	public book checkOutBook()
	{

		System.out.println(
			"Enter Serial No of Book to be Checked Out.");
		String sNo = input.next();

		int bookIndex = isAvailable(sNo);

		if (bookIndex != -1) {
			theBooks[bookIndex].bookQtyCopy--;
			return theBooks[bookIndex];
		}
		return null;
	}

	// Method 10
	// To add the Book to the Library
	public void checkInBook(book b)
	{
		for (int i = 0; i < count; i++) {
			if (b.equals(theBooks[i])) {
				theBooks[i].bookQtyCopy++;
				return;
			}
		}
	}
}
