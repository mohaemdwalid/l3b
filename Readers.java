import java.util.Scanner;

// Class
public class Readers {

	// Creating objects of Scanner and students class
	Scanner input = new Scanner(System.in);
	Reader theStudents[] = new Reader[50];

	public static int count = 0;

	// Method 1
	// To add books
	public void addReader(Reader s){
		for (int i = 0; i < count; i++) {

			if (s.regNum.equalsIgnoreCase(
					theStudents[i].regNum)) {

				// Print statement
				System.out.println(
					"Student of Reg Num " + s.regNum+ " is Already Registered.");
				return;
			}
		}

		if (count <= 50) {
			theStudents[count] = s;
			count++;
		}
	}

	// Method 2
	// Displaying all students
	public void showAllReaders()
	{
		// Printing student name and
		// corresponding registered number
		System.out.println("FirstName\t\tLastName\t\tId\t\tPassword\t\ttype\t\tCellPhone\t\tAddress\t\tEmail");
		for (int i = 0; i < count; i++) {
			System.out.println(theStudents[i].FirstName+ "\t\t"+ theStudents[i].LastName + "\t\t" + theStudents[i].id  + "\t\t" + theStudents[i].Password  +
			 "\t\t"+theStudents[i].type + "\t\t"+ theStudents[i].CellPhone +
			 "\t\t" + theStudents[i].Address+ "\t\t" + theStudents[i].Email);
		}
	}

	// Method 3
	// To check the Student
	public int isStudent()
	{
		// Display message only
		System.out.println("Enter Registered Number:");

		String regNum = input.nextLine();

		for (int i = 0; i < count; i++) {

			if (theStudents[i].regNum.equalsIgnoreCase(
					regNum)) {
				return i;
			}
		}

		// Print statements
		System.out.println("Student is not Registered.");
		System.out.println("Get Registered First.");

		return -1;
	}

	// Method 4
	// To remove the book
	public void checkOutBook(books book){
		int studentIndex = this.isStudent();

		if (studentIndex != -1) {
			System.out.println("checking out");

			book.showAllBooks();
			book b = book.checkOutBook();

			System.out.println("checking out");
			if (b != null) {

				if (theStudents[studentIndex].booksCount
					<= 3) {

					System.out.println("adding book");
					theStudents[studentIndex].borrowedBooks
						[theStudents[studentIndex].booksCount]= b;
					theStudents[studentIndex].booksCount++;

					return;
				}
				else {

					System.out.println(
						"Student Can not Borrow more than 3 Books.");
					return;
				}
			}
			System.out.println("Book is not Available.");
		}
	}

	// Method 5
	// To add the book
	public void checkInBook(books book)
	{
		int studentIndex = this.isStudent();
		if (studentIndex != -1) {

			// Printing credentials corresponding to student
			System.out.println(
				"S.No\t\t\tBook Name\t\t\tAuthor Name");

			Reader s = theStudents[studentIndex];

			for (int i = 0; i < s.booksCount; i++) {

				System.out.println(
				
					 s.borrowedBooks[i].bookName + "\t\t\t"
					+ s.borrowedBooks[i].authorName);
			}

			// Display message only
			System.out.println(
				"Enter Serial Number of Book to be Checked In:");

			String sNo = input.next();

			for (int i = 0; i < s.booksCount; i++) {
				if (sNo == s.borrowedBooks[i].bookName) {
					book.checkInBook(s.borrowedBooks[i]);
					s.borrowedBooks[i] = null;

					return;
				}
			}

			System.out.println("Book of Serial No " + sNo
							+ "not Found");
		}
	}
}
