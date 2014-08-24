public class RootEntryCheck
{
	String password;
	RootEntryCheck(String password)
	{
		this.password = password;
	}
	
	void checkPassword()
	{
		if(this.password.equals("This is my safe"))
		{
			System.out.println("You are a legitimate user!!");
		}
		else
		{
			System.out.println("You are an illegitimate user!! Please go away");
		}
		
	}
}