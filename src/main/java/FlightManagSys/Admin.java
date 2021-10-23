package FlightManagSys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Admin {

	String name;
	String adminid;
	Flight fl=new Flight();
	
	
	void newAdmin() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name\n");
		name=sc.nextLine();
		System.out.println("Please enter the ID you want---login next time with that id\n");
		adminid=sc.nextLine();
		
		File file=new File("Admin.txt");
		FileWriter writeonfile=new FileWriter(file,true);
		writeonfile.write(adminid+","+name+"\n");
		writeonfile.close();
	}
	
	void login() throws LoginErrorException, IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter your admin id to login\n");
		int id=sc.nextInt();
		//sc.close();
		String input=Integer.toString(id);
		
		String line="";boolean check=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader("Admin.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				if(input.equals(t.nextToken()))	
				{
					//System.out.println("\n====in=====\n");
					System.out.println(line);
					adminid=input;name=t.nextToken();
					System.out.println("------------Logged In-------------\n");check=true;
					break;
					}
			line="";}
			br.close();
			if(!check)
			{	throw new LoginErrorException("Login Error your account doesnt exist You are not a user ");
			}	
			
		
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("File not found");
	
	}
	
	
	}
		void AddnewFlight() throws IOException{
			
			System.out.println("Enter in the following order\nFlightNumber Date Time PlaneName Class Source Destination fare TotalSeats AvailableSeats\n");
			Scanner sc = new Scanner(System.in);
			String input1=sc.nextLine();String input2=sc.nextLine();String input3=sc.nextLine();String input4=sc.nextLine();String input5=sc.nextLine();
			String input6=sc.nextLine();String input7=sc.nextLine();String input8=sc.nextLine();String input9=sc.nextLine();String input10=sc.nextLine();
			
			File file=new File("Flight_Details.txt");
			FileWriter writeonfile=new FileWriter(file,true);
			writeonfile.write(input1+","+input2+","+input3+","+input4+","+input5+","+input6+","+input7+","+input8+","+input9+","+input10+"\n");
			writeonfile.close();
		}
		
	
}
