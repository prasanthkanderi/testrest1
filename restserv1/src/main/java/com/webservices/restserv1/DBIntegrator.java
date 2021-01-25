package com.webservices.restserv1;

import java.util.ArrayList;
import java.util.List;

public class DBIntegrator {

	public List<UserVO> usersList = new ArrayList<UserVO>();
	
	public DBIntegrator()
	{
		
		UserVO user1 = new UserVO("prasanth","kanderi", "1111111");
		UserVO user2 = new UserVO("prasanth1","kanderi1", "222222");
		UserVO user3 = new UserVO("prasanth2","kanderi2", "333333");
		UserVO user4 = new UserVO("prasanth3","kanderi3", "44444");
		UserVO user5 = new UserVO("prasanth4","kanderi4", "555555");
//		for(int i=0;i<5;i++)
			this.usersList.add(user1);
			this.usersList.add(user2);
			this.usersList.add(user3);
			this.usersList.add(user4);
			this.usersList.add(user5);
	}
	
	public UserVO setUserMobile(String mobileNumber)
	{
		
		UserVO user1 = new UserVO("prasanth","kanderi", mobileNumber);
//		System.out.println("Mobile number set");
//		System.out.println(user1.toString());
		return user1;
	}
	
	public UserVO setUser(UserVO user)
	{
		UserVO user1 = new UserVO(user.getFirstName(), user.getLastName(), user.getMobileNumber1());
//		System.out.println("Mobile number set");
		System.out.println(user1.toString());
		return user1;
	}
	public UserVO getUserDetails(String firstName)
	{
		UserVO user1=new UserVO();
		for(UserVO user: this.usersList)
			if(user.getFirstName().equalsIgnoreCase(firstName))
				return user;
		return user1;

	}
}
