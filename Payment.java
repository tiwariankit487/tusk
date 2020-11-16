import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Payment {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to gateway system");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Type 1 for login and 2 for signup");
		int x=sc.nextInt();
		if(x==1) {
			System.out.println("enter your username");
			String username=sc.next();
			String pass=sc.next();
			
			String res= login(username,pass);
			
			System.out.println("select option 1 for credit , 2 for debit, 3 for walletamount");
			int input1=sc.nextInt();
			if(input1==1) {
				cred();
			}
			else
			if(input1==2) {
				debit();
			}
			else
			if(input1==3) {
				System.out.println(walletamt(username));
			}
			
			//System.out.print(res);
		}
		else if(x==2) {
			String username=sc.next();
			String name=sc.next();
			String pass=sc.next();
			String s=register(username,name,pass);
			System.out.println(s);
			
		}
		else
			System.out.println("please enter valid number");
		
	}

	private static void cred() {
		
		
	}

	private static void debit() {
		
		
	}

	private static double walletamt(String username) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("wallet.csv"));  
		//sc.useDelimiter(",");   //sets the delimiter pattern 
		double d=0.0;
		while (sc.hasNext())  //returns a boolean value  
		{  
			String[] s=sc.next().split(",");
		
			if(username.equals(s[0]) )
				{
				d= Double.parseDouble(s[1]);
			break;
				}
		}
		return d;
	}

	private static String register(String username,String name,String pass) {
	//File file=new File("users.csv");
	try {
		FileWriter mywriter=new FileWriter("users.csv");
		mywriter.write(username+",");
		mywriter.write(name+",");
		mywriter.write(pass);
		FileWriter mywriter1=new FileWriter("wallet.csv");
		mywriter1.write(username+",");
		mywriter1.write("0.0");
		mywriter.close();
		mywriter1.close();
		System.out.println("user registered successfully");
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
		return null;
	}

	private static String login(String username,String pass) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("users.csv"));  
		//sc.useDelimiter(",");   //sets the delimiter pattern  
		int count=0;
		while (sc.hasNext())  //returns a boolean value  
		{  
			String[] s=sc.next().split(",");
		
			if(username.equals(s[0]) && pass.equals(s[2]))
				{
				System.out.println("user logged in successfully");
				
				count=1;
				break;
				}
				
			else
				{
				
				continue;
				}
			
			
			//System.out.println(Arrays.toString(s));
		}  
		if(count==0)
			System.out.println("user not found");
		sc.close();
		
		return null;
	}
}
