public class ModelObject
{
	String url;
	String username;
	String password;
	String flag; //Should be true for the record which should not exist
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setUrl(String url)
	{
		this.url=url;
	}
	
	public void setFlag(String flag)
	{
		this.flag=flag;
	}
	
	public String getFlag(ModelObject m)
	{
		return m.flag;
	}
	
	public String getUsername(ModelObject m)
	{
		return m.username;
	}
	public String getPassword(ModelObject m)
	{
		return m.password;
	}
	public String getUrl(ModelObject m)
	{
		return m.url;
	}
}