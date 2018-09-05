package com.teamsankya.employeemanagement.util;

import com.teamsankya.employeemanagement.dao.EmployeeManagementDAO;
import com.teamsankya.employeemanagement.dto.EmployeeBean;

public class IdGenerator {

	static String finalId;
	static int id ;
	static int c1;
	static int c2 ;

	static int end = 100;
	
	static int beginOnes;
	static int beginTens ;
	static int beginHnd ;

	private static String concatinate() {
		
		int c11 = c1+65;
		int c22 = c2+65;
		char c111 = (char) c11;
		char c222 = (char) c22;
		return end+""+c111+""+c222+""+beginHnd+""+beginTens+""+beginOnes;

	}

	private static String generateId() {
		if (beginOnes<9) 
		{
			beginOnes++;
			return finalId = concatinate();
			
			}
		else {
			beginOnes=0;
			if (beginTens<9) 
			{
				beginTens++;
				return finalId = concatinate();
			}
			else {
				beginTens = 0;
				if (beginHnd<9) 
				{
					beginHnd++;
					return finalId = concatinate();
				}
				else {
					beginHnd=0;
					if ((c1+65)<90)
					{
						c1++;
						return finalId = concatinate();
					}
					else {
						c1=0;
						if( (c2+65)<90) {
							c2++;
							return finalId = concatinate();
						}
						else {
							end++;
							return finalId = concatinate();
						}
						
					}
				}
			}
			
		}



		
	}
	
	
	public static String uniqueId() {
		
		String id = generateId();
				EmployeeManagementDAO dao = EmployeeServiceManager
				.getInstence()
				.daoGenarater();
		EmployeeBean bean = dao.getEmployee(id);
		if(bean!=null)
		{
			uniqueId();
			}
		else
		{
			return id;
		}
		return id;
		
		
		
		
	}
}
