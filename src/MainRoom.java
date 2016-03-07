import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class MainRoom {
	static Scanner darkly = new Scanner(System.in);
	static Random rnd = new Random();
	static NumberFormat currency = NumberFormat.getCurrencyInstance();

	static boolean secretRoomFound = false;
	static boolean[] roomVisitedFlag = {false, false, false, false, false, false, false, false};
	static boolean exiting = false;
	//all flags initialized to false
	static int steps = 0;
	static double moneyCollected = 0.00;
	static String thingsSeen = "";

	//File IO
	static File file = new File("zork");
	static PrintWriter pw;
	static {
		try
		{
			pw = new PrintWriter(file);
		}
		catch (IOException e)
		{
			System.out.println("Error writing to file.");
		}
	}

	private static void roomDescribe(String where, String[] stuff, String directions)
	{
		System.out.println("\nYou have " + currency.format(moneyCollected));

		System.out.println("You are in " + where);
		for (String thing : stuff) {
			System.out.println("You see " + thing);
		}
		System.out.println("You can go " + directions);
	}

	public static void room1()
	{
		String place = "the Foyer";
		String[] things = new String[1];
		things[0] = "a dead scorpion";
		String direct = "to the north (n) or the south (s)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[0])
		{
			roomVisitedFlag[0] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) 
			{
				room2();
			}
			else if (choice.equals("s"))
			{
				exit();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room2()
	{
		String place = "the Front Room";
		String[] things = new String[1];
		things[0] = "a phone";
		String direct = "to the east (e), the south (s) or the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[1])
		{
			roomVisitedFlag[1] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("s")) 
			{
				room1();
			}
			else if (choice.equals("e")) 
			{
				room4();
			}
			else if (choice.equals("w")) 
			{
				room3();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room3()
	{
		String place = "the Library";
		String[] things = new String[1];
		things[0] = "spiders";
		String direct = "to the north (n) or the east (e)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[2])
		{
			roomVisitedFlag[2] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) 
			{
				room5();
			}
			else if (choice.equals("e")) 
			{
				room2();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room4()
	{
		String place = "the Kitchen";
		String[] things = new String[1];
		things[0] = "bats";
		String direct = "to the north (n) or the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[3])
		{
			roomVisitedFlag[3] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) 
			{
				room7();
			}
			else if (choice.equals("w")) 
			{
				room2();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room5()
	{
		String place = "the Dining Room";
		String[] things = new String[2];
		things[0] = "dust";
		things[1] = "an empty box";
		String direct = "to the south (s)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[4])
		{
			roomVisitedFlag[4] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("s")) 
			{
				room3();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room6()
	{
		String place = "the Vault";
		String[] things = new String[1];
		things[0] = "3 walking skeletons";
		String direct = "to the east (e)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[5])
		{
			roomVisitedFlag[5] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		if(!secretRoomFound)
		{
			int discoverRoom = rnd.nextInt(4);
			if(discoverRoom == 0)
			{
				secretRoomFound = true;
			}
		}
		else
		{
			direct += " or to the secret room to the east (x)";
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("e")) 
			{
				room7();
			}
			else if(secretRoomFound && choice.equals("x"))
			{
				room8();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room7()
	{
		String place = "the Parlor";
		String[] things = new String[1];
		things[0] = "a treasure chest";
		String direct = "to the south (s) or the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[6])
		{
			roomVisitedFlag[6] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("s")) 
			{
				room4();
			}
			else if (choice.equals("w")) 
			{
				room6();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room8()
	{
		String place = "the Secret Room";
		String[] things = new String[1];
		things[0] = "piles of gold";
		String direct = "to the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[7])
		{
			roomVisitedFlag[7] = true;
			collectMoney();
			noteThingsSeen(things);
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("w")) 
			{
				room6();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void exit()
	{
		String place = "the Exit";
		String[] things = new String[1];
		things[0] = "nothing";
		String direct = "nowhere";

		roomDescribe(place, things, direct);

		int roomsVisited = 0;
		for(int i = 0; i < roomVisitedFlag.length; i++)
		{
			if(roomVisitedFlag[i])
			{
				roomsVisited++;
			}
		}
		System.out.printf("%nYou took %d steps%n", steps);
		System.out.printf("You visited %d rooms%n", roomsVisited);
		System.out.printf("You saw: %n%s", thingsSeen);

		int followed = rnd.nextInt(4);
		if(followed == 0)
		{
			System.out.println("The ghost of Zork has followed you out.");
		}
		else
		{
			System.out.println("You were not followed.");
		}
		exiting = true;
	}

	public static void collectMoney()
	{
		double moneyInRoom = (double)rnd.nextInt(100000) / 100;
		//Using random integer from 0-100000 divided by 100 to give exactly two decimal places
		System.out.println("You found " + currency.format(moneyInRoom));
		moneyCollected += moneyInRoom;

		pw.println("You found " + currency.format(moneyInRoom));
	}

	public static void noteThingsSeen(String[] stuff)
	{
		for (String thing : stuff) {
			thingsSeen += "\t" + thing + "\n";
			pw.println("You saw " + thing);
		}
	}

	public static void displayHistory()
	{
		displayMap();
		pw.flush();
		String line;
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			System.out.println();
			while ( (line = br.readLine())!= null)
			{
				System.out.println(line);
			}
			System.out.println();
		}
		catch (IOException e)
		{
			System.out.println("Error reading history.");
		}
	}

	public static void displayMap()
	{
		for(int i = 0; i < 7; i++)
		{
			//Dining Room
			if(roomVisitedFlag[4])
			{
				switch(i)
				{
				case 0: 
				case 6: System.out.print("*****************");
				break;
				case 1: System.out.print("*Dining Room\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Vault
			if(roomVisitedFlag[5])
			{
				switch(i)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Vault\t\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Parlor
			if(roomVisitedFlag[6])
			{
				//Secret Room
				if(roomVisitedFlag[7])
				{
					switch(i)
					{
					case 0: 
					case 6: System.out.print("****************");
					break;
					case 1: System.out.print("*Parlor\t*");
					break;
					case 3: System.out.print("********\t*");
					break;
					case 4: System.out.print("*Secret*\t*");
					break;
					case 5: System.out.print("*      *\t*");
					break;
					default: System.out.print("*\t\t*");
					break;
					}
				}
				else
				{
					switch(i)
					{
					case 0: 
					case 6: System.out.print("****************");
					break;
					case 1: System.out.print("*Parlor\t*");
					break;
					default: System.out.print("*\t\t*");
					break;
					}
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}
			System.out.println();
		}

		for(int j = 0; j < 7; j++)
		{
			//Library
			if(roomVisitedFlag[2])
			{
				switch(j)
				{
				case 0: 
				case 6: System.out.print("*****************");
				break;
				case 1: System.out.print("*Library\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Front Room
			if(roomVisitedFlag[1])
			{
				switch(j)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Front Room\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Kitchen
			if(roomVisitedFlag[3])
			{
				switch(j)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Kitchen\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}
			System.out.println();
		}

		for(int k = 0; k < 7; k++)
		{
			System.out.print(" \t\t ");
			//Foyer
			if(roomVisitedFlag[0])
			{
				switch(k)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Foyer\t\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}
			System.out.print(" \t\t ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the House of Fun.");
		System.out.println("At any time, type \'history\' to view history or \'map\' to display a map.\n");
		room1();
		darkly.close();
		pw.close();
	}

}