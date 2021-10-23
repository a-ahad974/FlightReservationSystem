package FlightManagSys;

import java.io.IOException;
import java.util.Scanner;

public class MainDriverClass {

	public static void main(String[] args) throws IOException, TicketNoException, NoseatAvaialableException, LoginErrorException {
		// TODO Auto-generated method stub

		
			Passenger p=new Passenger();
			
			
			System.out.println("(1) New Passenger\n"
					+ "(2) Login\n");
			Scanner sc = new Scanner(System.in);
			int option=sc.nextInt();
			if(option==1)
			p.NewPassenger();
			
			if(option==2)
			p.login();
			

			System.out.println("(1) book Flight\n"
					+ "(2) cancel Flight\n");
			
			option=sc.nextInt();
			if(option==1)
			{p.SearchByTime();
			p.Payment();}
			if(option==2)
			p.CancelFlight();
			//p.SearchBySrc_Destionation();
			
	}

}
