package test;

import java.io.Serializable;

public class UserBean implements Serializable
{
	//private variable
	private String uName,pWord,fName,lName,addr,mId;
	private long phNo;
	
	//Constructor
	public UserBean() {}
	
	public void setuName(String uName)
	{
		this.uName=uName;
	}
	public String getuName()
	{
		return uName;
	}
	
	public void setpWord(String pWord)
	{
		this.pWord=pWord;
	}
	public String getpWord()
	{
		return pWord;
	}
	
	public void setfName(String fName)
	{
		this.fName=fName;
	}
	public String getfName()
	{
		return fName;
	}
	
	public void setlName(String lName)
	{
		this.lName=lName;
	}
	public String getlName()
	{
		return lName;
	}
	
	public void setAddr(String addr)
	{
		this.addr=addr;
	}
	public String getAddr()
	{
		return addr;
	}
	
	public void setPhNo(long phNo)
	{
		this.phNo=phNo;
	}
	public long getPhNo()
	{
		return phNo;
	}
	
	public void setmId(String mId)
	{
		this.mId=mId;
	}
	public String getmId()
	{
		return mId;
	}
	
	
}
