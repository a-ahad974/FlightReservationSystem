package FlightManagSys;

import java.io.IOException;
import java.util.Scanner;

public class MainDriverClass {

	public static void main(String[] args) throws IOException, TicketNoException, NoseatAvaialableException, LoginErrorException {
		// TODO Auto-generated method stub

		
			Passenger p=new Passenger();
			Admin a=new Admin();
			
			System.out.println("(1) New Passenger\n"
					+ "(2) Login Passenger\n"+"(3) NEw Admin\n"+"(4) Login Admin\n");
			Scanner sc = new Scanner(System.in);
			int option=sc.nextInt();
			if(option==1)
			p.NewPassenger();
			
			if(option==2)
			p.login();
			if(option==3)
				a.newAdmin();;
			if(option==4)
				a.login();

			if(option==1 || option == 2)
			System.out.println("(1) book Flight\n"
					+ "(2) cancel Flight\n");
			else
				System.out.println("(3) add Flight to the system\n");
			option=sc.nextInt();
			if(option==1)
			{p.SearchByTime();
			p.Payment();}
			if(option==2)
			p.CancelFlight();
			if(option==3)
				a.AddnewFlight();;
			//p.SearchBySrc_Destionation();
			
	}

}
