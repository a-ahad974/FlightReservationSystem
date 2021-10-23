package FlightManagSys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Flight {

	String FlightNo;
	String PlaneName;
	String Class;
	String FlightDate;
	String FlightTime;
	String source;
	String destination;
	String TotalSeats;
	int availableSeats;
	String fare;
	
	void SearchSrcDst(String ssrc,String ddst) throws IOException, NoseatAvaialableException{
		
		String line="";String src="";String dst="";boolean check=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader("Flight_Details.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				for(int i=0;i<5;i++)
					t.nextToken();
					src=t.nextToken(); dst=t.nextToken();
				if(src.equals(ssrc) && dst.equals(ddst))	
				{
					//System.out.println("\n====in=====\n");
					System.out.println("FlightNumber Date Time PlaneName Class Source Destination fare TotalSeats AvailableSeats\n");
					System.out.println(line);
					}
			line="";}
			br.close();
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose which flight number you want to book\n");
			int input=sc.nextInt();
			//sc.close();
			addFlight(input);			
			
		
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("File not found");
	}
	
	
	}
	
	void SearchTime(String time) throws IOException, NoseatAvaialableException {
		String line="";String tm="";boolean check=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader("Flight_Details.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				for(int i=0;i<2;i++)
					t.nextToken();
					tm=t.nextToken(); 
				if(time.equals(tm) )	
				{
					//System.out.println("\n====in=====\n");
					System.out.println("FlightNumber Date Time PlaneName Class Source Destination fare TotalSeats AvailableSeats\n");
					System.out.println(line);
					}
			line="";}
			br.close();
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose which flight number you want to book\n");
			int input=sc.nextInt();
			//sc.close();
			addFlight(input);			
			
		
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("File not found");
	}
	
	}
	
	
	void addFlight(int flightno) throws IOException, NoseatAvaialableException {
		String line="";String UpdatedLine="";String fno=Integer.toString(flightno);boolean check=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader("Flight_Details.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				String temp=t.nextToken();
				if(fno.equals(temp))	
				{
					//System.out.println("\n====in=====\n");
					System.out.println(line);
					FlightNo=temp;FlightDate=t.nextToken();FlightTime=t.nextToken();PlaneName=t.nextToken();Class=t.nextToken();
					source=t.nextToken();destination=t.nextToken();fare=t.nextToken();TotalSeats=t.nextToken();
					availableSeats=Integer.parseInt(t.nextToken());
					if(availableSeats==0)
					{throw new NoseatAvaialableException("I am afraid there are no available seats "+ availableSeats);}
					availableSeats--;check=true;
					break;
					}
			line="";}
			
			br.close();
			UpdatedLine+=fno+",";UpdatedLine+=FlightDate+",";UpdatedLine+=FlightTime+",";UpdatedLine+=PlaneName+",";UpdatedLine+=Class+",";
			UpdatedLine+=source+",";UpdatedLine+=destination+",";UpdatedLine+=fare+",";UpdatedLine+=TotalSeats+",";UpdatedLine+=Integer.toString(availableSeats);
			if(!check)
				System.out.println("\nYou entered wrong flight no\n");
			else
			UpdateAvailableSeats(line,UpdatedLine);
			
			
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("File not found");
	
	}
	
	}
	
	void RemoveBooking(String fl) throws NumberFormatException, IOException {
		
		String line="";String UpdatedLine="";boolean check=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader("Flight_Details.txt"));
			while( (line = br.readLine() )!= null) {
				StringTokenizer t=new StringTokenizer(line,",");
				String temp=t.nextToken();
				if(fl.equals(temp))	
				{
					//System.out.println("\n====in=====\n");
					System.out.println(line);
					FlightNo=temp;FlightDate=t.nextToken();FlightTime=t.nextToken();PlaneName=t.nextToken();Class=t.nextToken();
					source=t.nextToken();destination=t.nextToken();fare=t.nextToken();TotalSeats=t.nextToken();
					availableSeats=Integer.parseInt(t.nextToken());availableSeats++;check=true;
					break;
					}
			line="";}
			
			br.close();
			UpdatedLine+=FlightNo+",";UpdatedLine+=FlightDate+",";UpdatedLine+=FlightTime+",";UpdatedLine+=PlaneName+",";UpdatedLine+=Class+",";
			UpdatedLine+=source+",";UpdatedLine+=destination+",";UpdatedLine+=fare+",";UpdatedLine+=TotalSeats+",";UpdatedLine+=Integer.toString(availableSeats);
			System.out.println("Update line : "+UpdatedLine);
			
			if(!check)
				System.out.println("\nYou entered wrong flight no\n");
			else
			UpdateAvailableSeats(line,UpdatedLine);
			
			
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("File not found");
	
	}
		
	}
	
	
	void UpdateAvailableSeats(String oldstr,String newstr) throws IOException {
		
		File filetobemodified=new File("Flight_Details.txt");
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
	
	void Display()
	{
		System.out.println("Flight Number: "+FlightNo+"\n"+"Date: "+FlightDate+"\n"+"Time: "+FlightTime+"\n"+"Plane Name: "+PlaneName+"\n"
				+"Class: "+Class+"\n"+"Source: "+source+"\n"+"Destination: "+destination+"\n"+"fare: "+fare+"\n"+"Total Seats: "+TotalSeats+"\n"+"Available Seats: "+availableSeats+"\n");
		
	}
}
