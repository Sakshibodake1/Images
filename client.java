import java.rmi.Naming;	
import java.util.Scanner;

public class client
{
    public client()
    {}
        public static void main(String args[]) throws Exception
        {
            int radius;
            Scanner sc=new Scanner(System.in);
            System.out.println("|-|-|-|-|-|-|-|-|-|-|");
            System.out.print("Enter The Radius Of The Circle : ");
            radius=sc.nextInt();
            circleInterface c=(circleInterface)Naming.lookup("rmi://localhost:2000/circle");
            System.out.println("The Area of Circle is : "+c.area(radius));
            System.out.println("The Circumference of Circle is : "+c.perimeter(radius));   
            System.out.println("|-|-|-|-|-|-|-|-|-|-|");
        }
}
