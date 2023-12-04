
/*
              MOVIE TICKET BOOKING SYSTEM       
              
      UCE2022516  Prajakta Subhash Jadhav 
      UCE2022517  Samiksha Ganesh Jadhav 
      UCE2022522  Diksha Ganesh Jalgaonkar 
      UCE2022523  Srushti Dattatray Jambhale         
  
  
 * */

package dsa_mini;

import java.util.PriorityQueue;
import java.util.Scanner;

class Main1 {                          // class for prioritizing movies in dates

	public static class Movie {            //class for movies details      

		String name;
		int date;
		int month;
		int year;
		int duration;
		String language;

		Movie(String name, int date, int month, int year, int duration, String language) {

			this.name = name;
			this.date = date;
			this.month = month;
			this.year = year;
			this.duration = duration;
			this.language = language;

		}

	}

	
	void movie() {                    //using priority queue 


		Movie m1 = new Movie("KGF:Chapter2", 8, 7, 2023, 120, "Telugu");
		Movie m2 = new Movie("Gadar2", 9, 6, 2023, 150, "Hindi");
		Movie m3 = new Movie("Jawan", 3, 7, 2023, 150, "Hindi");

		PriorityQueue<Movie> q = new PriorityQueue<>((a, b) -> (a.month - b.month < 0) ? (-1) : (a.date - b.date));

		q.add(m1);
		q.add(m3);
		q.add(m2);

		for (int i = 0; i < 3; i++) {

			Movie x = q.remove();
			System.out.println(x.name + " = " + x.date + "/" + x.month + "/" + x.year);
			System.out.println("Language:" + x.language + " Duration:" + x.duration + " minutes");
			System.out.println("");

		}

	}

}


class Ticket {                    //class for ticket info 

	String customerName;
	String movieName;
	int seatnum;
	int prize;
	int ans;
	String seatType;
	String slot;
	
	Ticket next = null;
	Ticket head;

	Ticket(String customerName, String movieName, int prize, int seatnum, String slot, String seatType) {

		this.customerName = customerName;
		this.movieName = movieName;
		this.seatnum = seatnum;
		this.prize = prize;
		this.slot = slot;
		this.seatType = seatType;

	}

}



class Node {                   // class for storing billing information

	String customerName;
	String movieName;
	int seatnum;
	int numTickets;
	int tp;
	float gst;
	float totalp;

	Node next = null;
	Node head1;

	Node(String customerName, String movieName, int seatnum, int tp, float gst, float totalp) {

		this.customerName = customerName;
		this.movieName = movieName;
		this.seatnum = seatnum;
		this.tp = tp;
		this.gst = gst;
		this.totalp = totalp;

	}

}



class MovieTicketBookingSystem {                            //class for booking system 

	Scanner sc = new Scanner(System.in);

	private boolean[][] goldSeats = new boolean[1][10];                //recliner  display
	private boolean[][] platinumSeats = new boolean[8][10];            //prime  display
    private boolean[][] silverSeats = new boolean[2][10];             //classic  display
    
	Main1 obj = new Main1();

	Ticket head;                                           //object of class ticket(ticket info) 
	Ticket next = null;
	
	int ans;
	
	static Node head1;                                       //obj of class node(bill info)  
	

	int avs1 = 100, avsRecliner1 = 10, avsPrime1 = 70, avsClassic1 = 20;        //recliner 10 seats
	int avs2 = 100, avsRecliner2 = 10, avsPrime2 = 70, avsClassic2 = 20;          
	int avs3 = 100, avsRecliner3 = 10, avsPrime3 = 70, avsClassic3 = 20;        //prime 70 seats   
	int avs4 = 100, avsRecliner4 = 10, avsPrime4 = 70, avsClassic4 = 20;      
	int avs5 = 100, avsRecliner5 = 10, avsPrime5 = 70, avsClassic5 = 20;        //classic 20 seats 
	int avs6 = 100, avsRecliner6 = 10, avsPrime6 = 70, avsClassic6 = 20;
	
	int snR1 = 1190, snP1 = 1120, snC1 = 1100;            //gadar2 s1 
	int snR2 = 1290, snP2 = 1220, snC2 = 1200;            //gadar2 s2
	int snR3 = 2190, snP3 = 2120, snC3 = 2100;            //jawan s1
	int snR4 = 2290, snP4 = 2220, snC4 = 2200;            //jawan s2
	int snR5 = 3190, snP5 = 3120, snC5 = 3100;            //kgf s1 
	int snR6 = 3290, snP6 = 3220, snC6 = 3200;            //kgf s2

	boolean isEmpty() {
		return head == null;
	}
	
	void about_movie(String movieName) {                      //method for info of movies 

		System.out.println("About Movie:");

		if (movieName.equalsIgnoreCase("Gadar2")) {
			System.out.println("Gadar 2: A Nation Divided is a compelling drama set in a divided nation. Follow the passionate love story of Aryan and Zara, whose relationship challenges societal norms amid political unrest. Their love becomes a beacon of hope and unity in a turbulent world.");
		}
		else if (movieName.equalsIgnoreCase("jawan")) {
			System.out.println("In this gripping drama, 'Jawan' follows the intense journey of a young man named Jai, who finds himself torn between his duty towards his country and responsibilities towards his family. Amidst high-stakes situations, Jai must make difficult choices to protect both his loved ones and his nation. 'Jawaan' is a thrilling tale of sacrifice, patriotism, and moral dilemmas.");
		}
		else if (movieName.equalsIgnoreCase("KGF:Chapter2")) {
			System.out.println("Rocky successfully rises as the leader and saviour of the people of the kalor Gold fields. But ,in his goal tonfulfil his mother's wishes, Rocky must tackle Adheera,Inayat Khalil and Ramika Sen.");
		}

	}

	static void reviews(String movieName) {                          //method for reviews of movies

		System.out.println("Reviews:");

		if (movieName.equalsIgnoreCase("Gadar2")) {
			System.out.println("*****   4.4");
		}
		else if (movieName.equalsIgnoreCase("Jawan")) {
			System.out.println("****   4.5");
		}
		else if (movieName.equalsIgnoreCase("KGF:Chapter2")) {
			System.out.println("★★★★★");
		}

	}

	void Recliner(String movieName, String slot, int available, int seat) {                //method for recliner seat allotment 

		if (available > 0) {
			System.out.print("Enter your name: ");
			String customerName = sc.next();

			int prize1 = 400;

			System.out.println("Do you want to eat popcorn in the theater? (For Yes=1,No=0)");
			int ans = sc.nextInt();

			if (ans == 1) {
				prize1 = prize1 + 100;
			}

			available--;

			seat = seat + 1;

			String seatType = "Recliner";

			addNode(customerName, movieName, prize1, seat, slot, seatType);                  //calling fn for adding ticket as node

			System.out.println("Tickets booked successfully!!!");

			int p1 = 400;

			MovieTicketBookingSystem.Billing(customerName, movieName, prize1, seat, ans, p1);           //calling fn for tkt bill

		}

		else {

			System.out.println("Sorry, no seats available.");

		}

	}

	void Prime(String movieName, String slot, int available, int seat) {              //method for prime seat allotment 

		if (available > 0) {

			System.out.print("Enter your name: ");
			String customerName = sc.next();

			int prize1 = 250;

			System.out.println("Do you want to eat popcorn in the theater? (For Yes=1,No=0)");
			int ans = sc.nextInt();

			if (ans == 1) {
				prize1 = prize1 + 100;
			}

			available--;

			seat = seat + 1;

			String seatType = "Prime";

			addNode(customerName, movieName, prize1, seat, slot, seatType);

			System.out.println("Tickets booked successfully!");

			int p1 = 250;

			MovieTicketBookingSystem.Billing(customerName, movieName, prize1, seat, ans, p1);

		}

		else {

			System.out.println("Sorry, no seats available.");

		}

	}

	void Classic(String movieName, String slot, int available, int seat) {                //method for classic seat allotment 

		if (available > 0) {

			System.out.print("Enter your name: ");
			String customerName = sc.next();

			int prize1 = 150;

			System.out.println("Do you want to eat popcorn in the theater? (For Yes=1,No=0)");
			ans = sc.nextInt();

			if (ans == 1) {
				prize1 = prize1 + 100;
			}

			available--;

			seat = seat + 1;

			String seatType = "Classic";

			addNode(customerName, movieName, prize1, seat, slot, seatType);

			System.out.println("TICKETS BOOKED SUCCESSFULLY!!!");

			int p1 = 150;

			MovieTicketBookingSystem.Billing(customerName, movieName, prize1, seat, ans, p1);

		}

		else {

			System.out.println("Sorry, no seats available.");

		}

	}

	
	
	void Booking() {                        //main method to use in main class to choose movies,slot,seat type 

		int ch;
		int choice;
		
		Scanner sc = new Scanner(System.in);

		String customerName;
		String slot = null;

		obj.movie();                                      //obj of priority movie class 

		System.out.println("Enter the movie name:");
		String movieName = sc.next();

		if (movieName.equalsIgnoreCase("Gadar2")) {                        //movie 1 
			
			System.out.println("");
			about_movie(movieName);                          //method_call for info of movie
			reviews(movieName);                              //method_call for review of movie
			System.out.println("");
			
			System.out.println("Do you want to book Ticket(For Yes=1/No=0):");
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("The show is available on the following slots:\n1st slot: 9:00am-12:00pm\n2nd slot: 3:00pm-6:00pm");

				System.out.println("Enter the slot:");                     
				int s = sc.nextInt();

				if (s == 1) {                                                   //slot 1
					slot = "9:00am-12:00pm";
					do {

						System.out.println("Representation of Seats:");                 //displaying theater seats using array
						System.out.println();
						
						System.out.println("Recliner Seats:");
						displaySeatStatus(goldSeats, 1, 10);
						System.out.println();

						System.out.println("Prime seats :");
						displaySeatStatus(platinumSeats, 8, 10);
						System.out.println();
						
						System.out.println("classic Seats:");
						displaySeatStatus(silverSeats, 2, 10);
						System.out.println();
						
						System.out.println("-------SCREEN-------");
						System.out.println();

						System.out.println("Available movies in the Theater:");
						System.out.println("Seat types:\n1.Recliner (Prize=400)\n2.Prime (Prize=250)\n3.Classic (Prize=150)\n");

						System.out.println("Enter which type of seat you want to book:");
						int type = sc.nextInt();
                                                                                              //seat type
						if (type == 1) {
							Recliner(movieName, slot, avsRecliner1, snR1);             
							snR1 = snR1 + 1;
						}
						else if (type == 2) {
							Prime(movieName, slot, avsPrime1, snP1);
							snP1 = snP1 + 1;
						}
						else if (type == 3) {
							Classic(movieName, slot, avsClassic1, snC1);
							snC1 = snC1 + 1;
						}
						else {
							System.out.println("Please enter correct seat type!");
						}

						System.out.println("Do you want to book one more ticket? (Yes-1,No-0)");
						ch = sc.nextInt();

					} while (ch != 0);

					if (ch == 0) {
						System.out.println("Thanks for the booking!");
					}
				}

				else if (s == 2) {                                             //slot 2
					slot = "3:00pm-6:00pm";
					do {

						System.out.println("Representation of Seats:");
						System.out.println();

						System.out.println("Representation of Seats:");
						System.out.println();
						
						System.out.println("Recliner Seats:");
						displaySeatStatus(goldSeats, 1, 10);
						System.out.println();

						System.out.println("Prime seats :");
						displaySeatStatus(platinumSeats, 8, 10);
						System.out.println();
						
						System.out.println("classic Seats:");
						displaySeatStatus(silverSeats, 2, 10);
						System.out.println();
						
						System.out.println("-------SCREEN-------");
						System.out.println();
						
						System.out.println("Available movies in the Theater:");

						System.out.println("Seat types:\n1.Recliner (Prize=400)\n2.Prime (Prize=250)\n3.Classic (Prize=150)\n");

						System.out.println("Enter which type of seat you want to book:");
						int type = sc.nextInt();
                                                                                               //seat type
						if (type == 1) {
							Recliner(movieName, slot, avsRecliner2, snR2);
							snR2 = snR2 + 1;
						}
						else if (type == 2) {
							Prime(movieName, slot, avsPrime2, snP2);
							snP2 = snP2 + 1;
						}
						else if (type == 3) {
							Classic(movieName, slot, avsClassic2, snC2);
							snC2 = snC2 + 1;
						}
						else {
							System.out.println("Please enter correct seat type!");
						}

						System.out.println("Do you want to book one more ticket? (yes-1,no-0)");
						ch = sc.nextInt();

					} while (ch != 0);

					if (ch == 0) {
						System.out.println("Thanks for the booking!");
					}
				}

				else {
					System.out.println("Enter the valid time slot!");
				}

			}

			else {
				return;
			}

		}

		else if (movieName.equalsIgnoreCase("jawan")) {                                   //movie 2

			System.out.println("");
			about_movie(movieName);
			reviews(movieName);
			System.out.println("");

			System.out.println("Do you want to book Ticket(for Yes=1/No=0):");
			choice = sc.nextInt();

			if (choice == 1) {

				System.out.println("The show is available on the following slots:\n1st slot: 9:00am-12:00pm\n2nd slot: 3:00pm-6:00pm");

				System.out.println("Enter the slot :");
				int s = sc.nextInt();

				if (s == 1) {                                                  //slot 1
					slot = "9:00am-12:00pm";
					do {

						System.out.println("Representation of Seats:");
						System.out.println();

						System.out.println("Representation of Seats:");
						System.out.println();
						
						System.out.println("Recliner Seats:");
						displaySeatStatus(goldSeats, 1, 10);
						System.out.println();

						System.out.println("Prime seats :");
						displaySeatStatus(platinumSeats, 8, 10);
						System.out.println();
						
						System.out.println("classic Seats:");
						displaySeatStatus(silverSeats, 2, 10);
						System.out.println();
						
						System.out.println("-------SCREEN-------");
						System.out.println();

						System.out.println("Available movies in the Theater:");
						System.out.println("Seat types:\n1.Recliner (Prize=400)\n2.Prime (Prize=250)\n3.Classic (Prize=150)\n");

						System.out.println("Enter which type of seat you want to book:");
						int type = sc.nextInt();
                                                                                                //seat type
						if (type == 1) {
							Recliner(movieName, slot, avsRecliner3, snR3);
							snR3 = snR3 + 1;
						}
						else if (type == 2) {
							Prime(movieName, slot, avsPrime3, snP3);
							snP3 = snP3 + 1;
						}
						else if (type == 3) {
							Classic(movieName, slot, avsClassic3, snC3);
							snC3 = snC3 + 1;
						}
						else {
							System.out.println("Please enter correct seat type!");
						}

						System.out.println("Do you want to book one more ticket? (Yes-1,No-0)");
						ch = sc.nextInt();

					} while (ch != 0);

					if (ch == 0) {
						System.out.println("Thanks for the booking!");
					}

				}

				else if (s == 2) {                                                  //slot 2
					
					slot = "3:00pm-6:00pm";

					do {

						System.out.println("Representation of Seats:");
						System.out.println();

						System.out.println("Representation of Seats:");
						System.out.println();
						
						System.out.println("Recliner Seats:");
						displaySeatStatus(goldSeats, 1, 10);
						System.out.println();

						System.out.println("Prime seats :");
						displaySeatStatus(platinumSeats, 8, 10);
						System.out.println();
						
						System.out.println("classic Seats:");
						displaySeatStatus(silverSeats, 2, 10);
						System.out.println();
						
						System.out.println("-------SCREEN-------");
						System.out.println();

						System.out.println("Available movies in the Theater:");

						System.out.println("Seat types:\n1.Recliner (Prize=400)\n2.Prime (Prize=250)\n3.Classic (Prize=150)\n");

						System.out.println("Enter which type of seat you want to book:");
						int type = sc.nextInt();
                                                                                                //seat type
						if (type == 1) {
							Recliner(movieName, slot, avsRecliner4, snR4);
							snR4 = snR4 + 1;
						}
						else if (type == 2) {
							Prime(movieName, slot, avsPrime4, snP4);
							snP4 = snP4 + 1;
						}
						else if (type == 3) {
							Classic(movieName, slot, avsClassic4, snC4);
							snC4 = snC4 + 1;
						}
						else {
							System.out.println("Please enter correct seat type!");
						}

						System.out.println("Do you want to book one more ticket? (Yes-1,No-0)");
						ch = sc.nextInt();

					} while (ch != 0);

					if (ch == 0) {
						System.out.println("Thanks for the booking!");
					}

				}

				else {
					System.out.println("Please enter the valid time slot!");
				}

			}

			else {
				return;
			}

		}

		else if (movieName.equalsIgnoreCase("KGF:Chapter2")) {                               //movie 3                    

			System.out.println("");
			about_movie(movieName);
			reviews(movieName);
			System.out.println("");

			System.out.println("Do you want to book Ticket(For Yes=1/No=0):");
			choice = sc.nextInt();

			if (choice == 1) {                                                     

				System.out.println("The show is available on the following slots:\n1st slot: 9:00am-12:00pm\n2nd slot: 3:00pm-6:00pm");

				System.out.println("Enter the slot:");
				int s = sc.nextInt();

				if (s == 1) {                                                   //slot 1
					slot = "9:00am-12:00pm";
					do {

						System.out.println("Representation of Seats:");
						System.out.println();

						System.out.println("Representation of Seats:");
						System.out.println();
						
						System.out.println("Recliner Seats:");
						displaySeatStatus(goldSeats, 1, 10);
						System.out.println();

						System.out.println("Prime seats :");
						displaySeatStatus(platinumSeats, 8, 10);
						System.out.println();
						
						System.out.println("classic Seats:");
						displaySeatStatus(silverSeats, 2, 10);
						System.out.println();
						
						System.out.println("-------SCREEN-------");
						System.out.println();

						System.out.println("Available movies in the Theater:");
						System.out.println("Seat types:\n1.Recliner (Prize=400)\n2.Prime (Prize=250)\n3.Classic (Prize=150)\n");

						System.out.println("Enter which type of seat you want to book:");
						int type = sc.nextInt();
                                                                                       //seat type
						if (type == 1) {
							Recliner(movieName, slot, avsRecliner5, snR5);
							snR5 = snR5 + 1;
						}
						else if (type == 2) {
							Prime(movieName, slot, avsPrime5, snP5);
							snP5 = snP5 + 1;
						}
						else if (type == 3) {
							Classic(movieName, slot, avsClassic5, snC5);
							snC5 = snC5 + 1;
						}
						else {
							System.out.println("Please enter correct seat type!");
						}

						System.out.println("Do you want to book one more ticket? (Yes-1,No-0)");
						ch = sc.nextInt();

					} while (ch != 0);

					if (ch == 0) {
						System.out.println("Thanks for the booking!");
					}

				}

				else if (s == 2) {                                               //slot 2
					slot = "3:00pm-6:00pm";
					do {

						System.out.println("Representation of Seats:");
						System.out.println();

						System.out.println("Representation of Seats:");
						System.out.println();
						
						System.out.println("Recliner Seats:");
						displaySeatStatus(goldSeats, 1, 10);
						System.out.println();

						System.out.println("Prime seats :");
						displaySeatStatus(platinumSeats, 8, 10);
						System.out.println();
						
						System.out.println("classic Seats:");
						displaySeatStatus(silverSeats, 2, 10);
						System.out.println();
						
						System.out.println("-------SCREEN-------");
						System.out.println();

						System.out.println("Available movies in the Theater:");

						System.out.println("Seat types:\n1.Recliner (Prize=400)\n2.Prime (Prize=250)\n3.Classic (Prize=150)\n");

						System.out.println("Enter which type of seat you want to book:");
						int type = sc.nextInt();
                                                                                   //seat type
						if (type == 1) {
							Recliner(movieName, slot, avsRecliner6, snR6);
							snR6 = snR6 + 1;
						}
						else if (type == 2) {
							Prime(movieName, slot, avsPrime6, snP6);
							snP6 = snP6 + 1;
						}
						else if (type == 3) {
							Classic(movieName, slot, avsClassic6, snC6);
							snC6 = snC6 + 1;
						}
						else {
							System.out.println("Please enter correct seat type!");
						}

						System.out.println("Do you want to book one more ticket? (yes-1,no-0)");
						ch = sc.nextInt();
						System.out.println();

					} while (ch != 0);

					if (ch == 0) {
						System.out.println("THANK YOU FOR BOOKING !!!!");
						System.out.println();
					}

				}

				else {
					System.out.println("Enter the valid time slot!");
				}

			}

			else {
				return;
			}

		}

		else {
			System.out.println("This movie is not available ! Please enter correct name!");
		}

	}

	
	
	private void displaySeatStatus(boolean[][] seats, int nRows, int nSeatsPerRow) {             //displaying theater seats 

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nSeatsPerRow; j++) {
				if (!seats[i][j]) {
					System.out.print("S ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}

	
	void addNode(String customerName, String movieName, int prize, int seatno, String slot, String seatType) {                      //creating and adding LL of single each tickets 

		Ticket new_node = new Ticket(customerName, movieName, prize, seatno, slot, seatType);

		if (head == null) {
			head = new_node;
		}
		else {

			Ticket currNode = head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = new_node;
		}

	}

	void DisplayTicket() {                                    //displaying the ticket LL  for display function in main

		if (head == null) {
			System.out.println("No Ticket booked.");
		}

		Ticket curNode = head;

		while (curNode != null) {

			System.out.println("+--------------------------------------------+");
			System.out.println("          Details of your ticket            ");
			System.out.println("  Name: "+ curNode.customerName+ " " );
			System.out.println("  Movie: "+ curNode.movieName+" " );
			System.out.println("  Seat type: "+ curNode.seatType+"" );
			System.out.println("  Seatnumber: "+ curNode.seatnum+" " );
			System.out.println("  Slot: "+ curNode.slot+" " );
			System.out.println("+--------------------------------------------+");
			System.out.println();

			curNode = curNode.next;

		}

	}

	
	void DisplayBill() {                                        //billiing option 

		if (head1 == null) {
			System.out.println("No Ticket booked.");
		}

		Node curNode = head1;

		while (curNode != null) {

			System.out.println("+--------------------------------------------+");
			System.out.println("| Details of your ticket:\n");
			System.out.println("| Name: " + curNode.customerName);
			System.out.println("| Movie: " + curNode.movieName);
			System.out.println("| Ticket price: " + curNode.tp);
			System.out.println("| GST (28% GST): " + curNode.gst);

			if (ans == 1) {
				System.out.println("Popcorn charges:100/-");
			}

			System.out.println("| Total price: " + curNode.totalp);
			System.out.println("+--------------------------------------------+");
			System.out.println();

			curNode = curNode.next;

		}

	}

	
	static void Billing(String customerName, String movieName, int prize, int seatnum, int ans, int originalPrize) {                        //immediate billing

		System.out.println(" ");
		System.out.println("*****Your Ticket Bill*****");

		System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: "+seatnum);
		int tp = originalPrize;
		float gst = (float) (originalPrize * 0.28);
		float totalp = tp + gst;

		if (ans == 1) {
			System.out.println("Popcorn charges:100/-");
			totalp = totalp + 100;
		}

		addBill(customerName, movieName, seatnum, tp, gst, totalp);                    //calling bill fn to display bill

		System.out.println("Ticket price: " + tp);
		System.out.println("GST (28% GST): " + gst);
		System.out.println("Total price: " + totalp);
		System.out.println("*****Thank You*****");
		System.out.println();
		

	}

	
	
	static void addBill(String customerName, String movieName, int seatnum, int tp, float gst, float totalp) {                   //method to add node bill wise 

		Node new_node = new Node(customerName, movieName, seatnum, tp, gst, totalp);

		if (head1 == null) {
			head1 = new_node;
		}
		
		else {

			Node currNode = head1;

			while (currNode.next != null) {
				currNode = currNode.next;
			}

			currNode.next = new_node;

		}

	}

	
	
	void delete() {                                                                  //Deleting ticket 

		System.out.println("For cancelling tickets:\nRefund Criteria: 75% refund amount will be deposited in your respected account within 24 hours.");

		System.out.println("Do you want to continue the process? Enter 1 for Yes OR 0 for No.");
		int s = sc.nextInt();

		if (s == 1) {

			System.out.println("Enter the seat number which you want to delete:");
			int seatNum = sc.nextInt();

			Ticket temp = head, prev = null;
			Node temp1 = head1;
			Node prev1 = null;

			if (temp == null && temp1 == null) {                                                //no tickets booked
				System.out.println("There is no Ticket booking present.");
				return;
			}

			else if (temp != null && temp.seatnum == seatNum && temp1 != null && temp1.seatnum == seatNum) {                        //seat at start head (booked recently)
				
				head = temp.next;                                      //deleting from tickets node
				head1 = temp1.next;                                     //deleting from bills nodes

				System.out.println("Ticket of " + seatNum + " canceled successfully!");
				System.out.println("Your refund amount will refund within 24 hours.");

				return;
			}

			else {

				while (temp != null && temp.seatnum != seatNum && temp1 != null && temp1.seatnum != seatNum) {                //seat in middle (booked moderately)

					prev = temp;
					temp = temp.next;
					prev1 = temp1;
					temp1 = temp1.next;

				}

				if (temp == null && temp1 == null) {

					System.out.println("Seat number does not exist.");
					return;

				}

				prev.next = temp.next;
				prev1.next = temp1.next;

				System.out.println("Your Ticket is successfully canceled! Your refund amount will refund within 24 hours.");

			}

		}

		else {
			return;
		}

	}

}





public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MovieTicketBookingSystem obj = new MovieTicketBookingSystem();

		int opt = 0;

		do {

			int width = 50; // Width of the box

			int height = 10; // Height of the box

			String topBorder = "+" + "-".repeat(width - 2) + "+";             // Create the top border

			String side = "|" + " ".repeat(width - 2) + "|";             // Create the sides with spaces in between

		
			String[] lines = {                    // Line to fit inside the box

					"| Welcome to our movie ticket Booking System     |",

					"| Menu:                                          |",

					"| 0.Exit.                                        |",

					"| 1.Book ticket                                  |",

					"| 2.Display your tickets                         |",

					"| 3.Cancel ticket                                |",

					"| 4.Show Bill                                    |",

			};


			System.out.println(topBorder);              // Print the top border

			// Print the sides and text inside the box

			for (int i = 0; i < height - 2; i++) {

				if (i < lines.length) {

					System.out.println(lines[i]);

				} else {

					System.out.println(side);

				}

			}


			System.out.println(topBorder);                  // Print the bottom border

			System.out.println("Enter the choice:");
			int choice = sc.nextInt();

			switch (choice) {

			case 0: {
				System.out.println("Thank you for visiting..!");
				System.exit(0);
				break;
			}

			case 1: {
				obj.Booking();
				break;
			}

			case 2: {
				obj.DisplayTicket();
				break;

			}

			case 3: {
				obj.delete();
				break;
			}

			case 4: {
				obj.DisplayBill();
				break;
			}

			}

			System.out.println("Do you want to continue? (for yes=1, No=0)");
			opt = sc.nextInt();

			if (opt == 0) {
				System.out.println("THANK YOU FOR VISITING !!!!");
				System.out.println("--------------------------------------------------");
			}

		} while (opt != 0);

		sc.close();
		
	}

}









/*
 *       OUTPUT
 * 
 * 
 * +------------------------------------------------+
| Welcome to our movie ticket Booking System     |
| Menu:                                          |
| 0.Exit.                                        |
| 1.Book ticket                                  |
| 2.Display your tickets                         |
| 3.Cancel ticket                                |
| 4.Show Bill                                    |
|                                                |
+------------------------------------------------+
Enter the choice:
1
Gadar2 = 9/6/2023
Language:Hindi Duration:150 minutes

Jawan = 3/7/2023
Language:Hindi Duration:150 minutes

KGF:Chapter2 = 8/7/2023
Language:Telugu Duration:120 minutes

Enter the movie name:
gadar2

About Movie:
Gadar 2: A Nation Divided is a compelling drama set in a divided nation. Follow the passionate love story of Aryan and Zara, whose relationship challenges societal norms amid political unrest. Their love becomes a beacon of hope and unity in a turbulent world.
Reviews:
*****   4.4

Do you want to book Ticket(For Yes=1/No=0):
1
The show is available on the following slots:
1st slot: 9:00am-12:00pm
2nd slot: 3:00pm-6:00pm
Enter the slot:
1
Representation of Seats:

Recliner Seats:
S S S S S S S S S S 

Prime seats :
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 

classic Seats:
S S S S S S S S S S 
S S S S S S S S S S 

-------SCREEN-------

Available movies in the Theater:
Seat types:
1.Recliner (Prize=400)
2.Prime (Prize=250)
3.Classic (Prize=150)

Enter which type of seat you want to book:
1
Enter your name: diksha
Do you want to eat popcorn in the theater? (For Yes=1,No=0)
1
Tickets booked successfully!!!
 
*****Your Ticket Bill*****
Movie Name: gadar2
Seat Number: 1191
Popcorn charges:100/-
Ticket price: 400
GST (28% GST): 112.0
Total price: 612.0
Your ticket will be recieved shortly
*****Thank You*****

Do you want to book one more ticket? (Yes-1,No-0)
1
Representation of Seats:

Recliner Seats:
S S S S S S S S S S 

Prime seats :
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 
S S S S S S S S S S 

classic Seats:
S S S S S S S S S S 
S S S S S S S S S S 

-------SCREEN-------

Available movies in the Theater:
Seat types:
1.Recliner (Prize=400)
2.Prime (Prize=250)
3.Classic (Prize=150)

Enter which type of seat you want to book:
1
Enter your name: diksha
Do you want to eat popcorn in the theater? (For Yes=1,No=0)
0
Tickets booked successfully!!!
 
*****Your Ticket Bill*****
Movie Name: gadar2
Seat Number: 1192
Ticket price: 400
GST (28% GST): 112.0
Total price: 512.0
Your ticket will be recieved shortly
*****Thank You*****

Do you want to book one more ticket? (Yes-1,No-0)
0
Thanks for the booking!
Do you want to continue? (for yes=1, No=0)
1
+------------------------------------------------+
| Welcome to our movie ticket Booking System     |
| Menu:                                          |
| 0.Exit.                                        |
| 1.Book ticket                                  |
| 2.Display your tickets                         |
| 3.Cancel ticket                                |
| 4.Show Bill                                    |
|                                                |
+------------------------------------------------+
Enter the choice:
2
+--------------------------------------------+
          Details of your ticket            
  Name: diksha 
  Movie: gadar2 
  Seat type: Recliner
  Seatnumber: 1191 
  Slot: 9:00am-12:00pm 
+--------------------------------------------+

+--------------------------------------------+
          Details of your ticket            
  Name: diksha 
  Movie: gadar2 
  Seat type: Recliner
  Seatnumber: 1192 
  Slot: 9:00am-12:00pm 
+--------------------------------------------+

Do you want to continue? (for yes=1, No=0)
1
+------------------------------------------------+
| Welcome to our movie ticket Booking System     |
| Menu:                                          |
| 0.Exit.                                        |
| 1.Book ticket                                  |
| 2.Display your tickets                         |
| 3.Cancel ticket                                |
| 4.Show Bill                                    |
|                                                |
+------------------------------------------------+
Enter the choice:
3
For cancelling tickets:
Refund Criteria: 75% refund amount will be deposited in your respected account within 24 hours.
Do you want to continue the process? Enter 1 for Yes OR 0 for No.
1
Enter the seat number which you want to delete:
1192
Your Ticket is successfully canceled! Your refund amount will refund within 24 hours.
Do you want to continue? (for yes=1, No=0)
1
+------------------------------------------------+
| Welcome to our movie ticket Booking System     |
| Menu:                                          |
| 0.Exit.                                        |
| 1.Book ticket                                  |
| 2.Display your tickets                         |
| 3.Cancel ticket                                |
| 4.Show Bill                                    |
|                                                |
+------------------------------------------------+
Enter the choice:
2
+--------------------------------------------+
          Details of your ticket            
  Name: diksha 
  Movie: gadar2 
  Seat type: Recliner
  Seatnumber: 1191 
  Slot: 9:00am-12:00pm 
+--------------------------------------------+

Do you want to continue? (for yes=1, No=0)
1
+------------------------------------------------+
| Welcome to our movie ticket Booking System     |
| Menu:                                          |
| 0.Exit.                                        |
| 1.Book ticket                                  |
| 2.Display your tickets                         |
| 3.Cancel ticket                                |
| 4.Show Bill                                    |
|                                                |
+------------------------------------------------+
Enter the choice:
4
+--------------------------------------------+
| Details of your ticket:

| Name: diksha
| Movie: gadar2
| Ticket price: 400
| GST (28% GST): 112.0
| Total price: 612.0
+--------------------------------------------+

Do you want to continue? (for yes=1, No=0)
1
+------------------------------------------------+
| Welcome to our movie ticket Booking System     |
| Menu:                                          |
| 0.Exit.                                        |
| 1.Book ticket                                  |
| 2.Display your tickets                         |
| 3.Cancel ticket                                |
| 4.Show Bill                                    |
|                                                |
+------------------------------------------------+
Enter the choice:
3
For cancelling tickets:
Refund Criteria: 75% refund amount will be deposited in your respected account within 24 hours.
Do you want to continue the process? Enter 1 for Yes OR 0 for No.
1
Do you want to continue? (for yes=1, No=0)
1
+------------------------------------------------+
| Welcome to our movie ticket Booking System     |
| Menu:                                          |
| 0.Exit.                                        |
| 1.Book ticket                                  |
| 2.Display your tickets                         |
| 3.Cancel ticket                                |
| 4.Show Bill                                    |
|                                                |
+------------------------------------------------+
Enter the choice:
0
Thank you for visiting..!

 * 
 * 
 * */
