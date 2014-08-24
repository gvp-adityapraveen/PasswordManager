import java.util.*;
public class Index
{
	public static void main(String args[])throws Exception
	{
		//The file csv where in we store the passwords etc
		String file = args[0];
		String exitStatus=null;
		int choice;
		System.out.println("Please enter password");
		String password;
		Scanner s = new Scanner(System.in);
		password=s.nextLine();
		RootEntryCheck rt = new RootEntryCheck(password);
		rt.checkPassword();
		do 
		{
		System.out.println("***The following contains url, username, password ***");
		System.out.println("1.Add an account");
		System.out.println("2.Retrieve Password");
		System.out.println("3.Delete account");
		System.out.println("4.Edit Acount");
		System.out.println("Please enter choice");
		choice = s.nextInt();
		if(choice == 1)
		{
			CSVFileWriter writer = new CSVFileWriter(file);
			writer.addAccount();
		}
		
		else if(choice == 2)
		{
			CSVFileWriter reader= new CSVFileWriter(file);
			reader.retrieveUsernamePassword();
		}
		else if(choice == 3)
		{
			CSVFileWriter del = new CSVFileWriter(file);
			del.deleteAccount();
		}
		else if(choice == 4)
		{
			CSVFileWriter edit = new CSVFileWriter(file);
			edit.editAccountPassword();
		}
		System.out.println("Do you want to continue or exit .. Press Exit(Case sensitive) to exit and any thing to continue");
		exitStatus=s.nextLine();
		exitStatus=s.nextLine();
		System.out.println("Exit Status:"+exitStatus);
		}while(!(exitStatus.equals("Exit")));
		
	}
}