import java.util.Scanner;

// Class
public class Reader extends User {
    public String type;
    public String FirstName;
    public String LastName;
    public String Address;
    public String CellPhone;
    public String Email;
    public String isBlocked;
	String regNum;

	book borrowedBooks[] = new book[3];
	public int booksCount = 0;


	Scanner input = new Scanner(System.in);

	// Constructor
	public Reader(String id, String Password){
		super(id, Password);

		System.out.println("Enter First Name:");
		this.FirstName = input.nextLine();

		System.out.println("Enter Last Name:");
		this.LastName = input.nextLine();

		System.out.println("Enter Id:");
		this.id = input.nextLine();

		System.out.println("Enter Password:");
		this.Password = input.nextLine();

		System.out.println("Select type");
		this.type = input.nextLine();

		System.out.println("Enter CellPhone:");
		this.CellPhone = input.nextLine();
		
		System.out.println("Enter Address:");
		this.Address = input.nextLine();

		System.out.println("Enter Email");
		this.Email = input.nextLine();

		System.out.println("Enter Registration Number:");
		this.regNum = input.nextLine();
	}
}
