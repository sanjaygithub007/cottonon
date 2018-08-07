package com.cottonon.rough;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PhnBook {

			
			public TreeMap<String, Integer> getData()
			{
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				TreeMap<String, Integer> tm=new TreeMap<String, Integer>();
			
				
				System.out.println("Enter how many contacts you have");
				int number=sc.nextInt();
				for(int i=0;i<number;i++)
				{
				System.out.println("Enter the "+(i+1)+"Contact details");

				System.out.println("..............................");
				System.out.println("Enter names for phnbook");
				String name=sc.nextLine();

				System.out.println("Enter the values for mobile number");
				int phno=sc.nextInt();

				tm.put(name,phno);
				}
				return tm;
				
				}
			
			public void displayData(TreeMap<String, Integer> tM)
			{
				Set s=tM.entrySet();
				Iterator iterator=s.iterator();
				
				while(iterator.hasNext())
				{
					Object mobj=iterator.next();
					Map.Entry me=(Map.Entry)mobj;
					Object key=me.getKey();
					Object value=me.getValue();
					System.out.println("Contact_name/t/t/tPhoneNumber");
					System.out.println("contactNmae"+key);
					System.out.println("");
					System.out.println("phnNumber"+value);
					System.out.println("");
					Integer phnNo=(Integer)key;
					
			}
		}
		
			public static void main(String[] args) 
			{
				PhnBook m=new PhnBook();
				TreeMap<String, Integer> tm=m.getData();
				m.displayData(tm);
				
			}


	}


