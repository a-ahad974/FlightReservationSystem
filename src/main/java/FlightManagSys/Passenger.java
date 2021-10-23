package FlightManagSys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Passenger {

	String name;
	String gender;
	String address;
	String passport_no;
	String ticketNo;
	String seatNo;
	Flight fl=new Flight();
	
	
	void NewPassenger() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name\n");
		name=sc.nextLine();
		System.out.println("Please enter your address\n");
		address=sc.nextLine();
		System.out.println("Please specify your gender\n");
		gender=sc.nextLine();
		System.out.println("Please enter your passport number\n");
		passport_no=sc.nextLine();
		System.out.println("Please enter your ticket no\n");
		ticketNo=sc.nextLine();
		//sc.close();
		
		System.out.println("\n\nYour ID has been created\nLogin with your Ticket Number next Time\n\n");
		
		
		
		File file=new File("Passenger.txt");
		FileWriter writeonfile=new FileWriter(file,true);
		writeonfile.write(ticketNo+","+name+","+address+","
		+gender+","+passport_no+",");
		writeonfile.close();	
	}

	void login() throws IOException, TicketNoException, LoginErrorException {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter your ticket number to login\n");
		int tickno=sc.nextInt();
		//sc.close();
		String input=Integer.toString(tickno);
		if(tickno<0)
		{
			throw new TicketNoException("Ticket Number cannot be a negative number "+ tickno);
		}
		String line="";boolean check=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader("Passenger.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				if(input.equals(t.nextToken()))	
				{
					//System.out.println("\n====in=====\n");
					System.out.println(line);
					ticketNo=input;name=t.nextToken();address=t.nextToken();gender=t.nextToken();
					passport_no=t.nextToken();fl.FlightNo=t.nextToken();
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
	
	
	void SearchBySrc_Destionation() throws IOException, NoseatAvaialableException {
		
		String src;String dst;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your source\n");
		src=sc.nextLine();
		System.out.println("Please enter your destination\n");
		dst=sc.nextLine();
		System.out.println("------------------Searching---------------------\n");
		//sc.close();
		fl.SearchSrcDst(src,dst);
		
		System.out.println("Please enter your desired Seat No\n");
		seatNo=sc.nextLine();
		
		File file=new File("Passenger.txt");
		FileWriter writeonfile=new FileWriter(file,true);
		writeonfile.write(seatNo+","+fl.FlightNo+"\n");
		writeonfile.close();	
		
	}
	
	void SearchByTime() throws IOException, NoseatAvaialableException
	{
		String time;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter time of flight\n");
		time=sc.nextLine();
		System.out.println("------------------Searching---------------------\n");
		//sc.close();
		fl.SearchTime(time);
		
		System.out.println("Please enter your desired Seat No\n");
		seatNo=sc.nextLine();
		
		File file=new File("Passenger.txt");
		FileWriter writeonfile=new FileWriter(file,true);
		writeonfile.write(seatNo+","+fl.FlightNo+"\n");
		writeonfile.close();	
		
		
	}
	
	
	void CancelFlight() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your flight number\n");
		String input=sc.nextLine();
		
		fl.RemoveBooking(input);
		String line="";String UpdatedLine="";boolean check=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader("Passenger.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				String temp=t.nextToken();
				if(ticketNo.equals(temp))	
				{
					//System.out.println("\n====in=====\n");
					System.out.println(line);
					check=true;
					break;
					}
			line="";}
			
			br.close();
			UpdatedLine+=ticketNo+",";UpdatedLine+=name+",";UpdatedLine+=address+",";UpdatedLine+=gender+",";
			UpdatedLine+=passport_no+",";
			if(!check)
				System.out.println("\nYou entered wrong flight no\n");
			else
				RemoveFlightNo(line,UpdatedLine);
		}	
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
			
			}
		
	}
void RemoveFlightNo(String oldstr,String newstr) throws IOException {
		
		File filetobemodified=new File("Passenger.txt");
		String oldcontent="";
		BufferedReader br=null;FileWriter fr=null;
		try {
			br=new BufferedReader(new FileReader(filetobemodified));
			String line=br.readLine();
			
			while(line!=null)
			{
				oldcontent=oldcontent + line + System.lineSeparator();
				line=br.readLine();
			}br.close();
			String newContent=oldcontent.replaceAll(oldstr, newstr);
		
			fr=new FileWriter(filetobemodified);
			fr.write(newContent);
			fr.close();
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		
		}
	}


	void Payment() {
		System.out.println("How would you like to pay for your ticket\nCash or Card\n");
		Scanner sc = new Scanner(System.in);
		String input=sc.nextLine();
		if(input.equals("Card") || input.equals("card")) {
			System.out.println("Enter card details\n");
			System.out.println("Enter card Number\n");
			String cn=sc.nextLine();
			System.out.println("Enter card Security Code\n");
			String scode=sc.nextLine();
			System.out.println("Enter Expiry date\n");
			String ep=sc.nextLine();
		}
		else 
			System.out.println("------------Commencing Payment--------------\nPayment Verfied.\nHere is your ticket");
			
		if(input.equals("Card") || input.equals("card"))
			{
				Random rand=new Random();
				int Eticketcode=rand.nextInt(10000);
				System.out.println("-------Payment Done through card\n-----");
				System.out.println("Your E-ticket Code is: "+ Eticketcode );
				
			}
			else
				System.out.println("-------Payment Done through cash\n-----");
			Display();
			fl.Display();
			
		
	}
	
	void Display()
	{
		System.out.println("Name: "+name+"\n"+"Gender: "+gender+"\n"+"Address: "+address+"\n"+"Passport Number: "+passport_no+"\n"
				+"Ticket Number: "+ticketNo+"\n"+"Seat Number: "+seatNo+"\n");
		
	}
	
	
}
