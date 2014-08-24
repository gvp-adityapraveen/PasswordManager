import java.io.*;
import java.util.Scanner;
public class CSVFileWriter
{
	String file;
	CSVFileWriter (String file)
	{
		this.file=file;
		
	}
	
	void addAccount() throws IOException
	{
		String url,username,password,flag="true";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter url");
		url = s.nextLine();
		System.out.println("Enter username");
		username=s.nextLine();
		System.out.println("Enter Password");
		password = s.nextLine();
		System.out.println("Url:"+url);
		System.out.println("Username:"+username);
		System.out.println("Password:"+password);
		FileWriter fw = new FileWriter(this.file,true);
		fw.append(url);
		fw.append(",");
		fw.append(username);
		fw.append(",");
		fw.append(password);
		fw.append(",");
		fw.append(flag);
		fw.append("\r\n");
		fw.flush();
		fw.close();
		System.out.println("The account is added");
	}
	void retrieveUsernamePassword() throws IOException
	{
		String url;
		String line = "";
		String username=null;
		String password=null;
		BufferedReader br = null;
		String verify=null;
		String cvsSplitBy = ",";
		String endflag=null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter url");
		url = s.nextLine();
		try {
		 br = new BufferedReader(new FileReader(this.file));
			while ((line = br.readLine()) != null) 
			{
				// use comma as separator
				String[] Object = line.split(cvsSplitBy);
				if((Object[0].equals(url))&& ((Object[3].equals("false"))||(Object[3].equals("true"))))
				{
					username=Object[1];
					password=Object[2];
					endflag=Object[3]; //assignment potential error
				}
			}
			if(endflag.equals("true"))
					{
				System.out.println("Username:"+username+" and password:"+password);				
					}
			else
			{
				System.out.println("There is no account with the given url!!");
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	void deleteAccount() throws IOException
	{
		String url;
		String line = "";
		String putData;
		BufferedReader br = null;
		BufferedWriter bw=null;
		String verify=null;
		String cvsSplitBy = ",";
		String endflag=null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter url");
		url = s.nextLine();
		try {
			bw = new BufferedWriter(new FileWriter(this.file,true)); 
			br = new BufferedReader(new FileReader(this.file));
			while ((line = br.readLine()) != null) 
			{
				// use comma as separator
				String[] Object = line.split(cvsSplitBy);
				if((Object[0].equals(url))&& ((Object[3].equals("false"))||(Object[3].equals("true"))))
				{
					verify=line; //potential problem
					endflag=Object[3]; //assignment potential error
				}
			}
			if(endflag.equals("true"))
					{
				putData=verify.replaceAll("true", "false");//potential problem
				bw.write(putData+"\r\n");
				bw.flush();
				bw.close();
				br.close();
				System.out.println("The account with given url is deleted");
				}
			else
			{
				System.out.println("There is no account with the given url!!");
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	void editAccountPassword()throws IOException
	{
		String url;
		String line = "";
		String putData;
		BufferedReader br = null;
		BufferedWriter bw=null;
		String verify=null;
		String cvsSplitBy = ",";
		String endflag=null;
		String password=null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter url");
		url = s.nextLine();
		try {
			bw = new BufferedWriter(new FileWriter(this.file,true)); 
			br = new BufferedReader(new FileReader(this.file));
			while ((line = br.readLine()) != null) 
			{
				// use comma as separator
				String[] Object = line.split(cvsSplitBy);
				if((Object[0].equals(url))&& ((Object[3].equals("false"))||(Object[3].equals("true"))))
				{
					verify=line; //potential problem
					endflag=Object[3]; //assignment potential error
					password=Object[2];
				}
			}
			if(endflag.equals("true"))
					{
				String password_new;
				System.out.println("Enter password");
				password_new=s.nextLine();
				putData=verify.replaceAll(password, password_new);//potential problem
				bw.write(putData+"\r\n");
				bw.flush();
				bw.close();
				br.close();
				System.out.println("The account with given url is edited!!!");
				}
			else
			{
				System.out.println("There is no account with the given url to edit!!");
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
}