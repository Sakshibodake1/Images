import java.util.Date;	
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class berkeley 
{
    public static void berkeleyAlgo(String mastertime, String time1, String time2, String time3) 
    {
    	System.out.println("---------------------------------- Berkeley Algorithm -----------------------------------------------");
        System.out.println("Master Computer Clock Time :  " + mastertime);
        System.out.println("1st Slave Computer Time :   " + time1);
        System.out.println("2nd Slave Computer Time :  " + time2);
        System.out.println("3rd Slave Computer Time :  " + time3);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        try 
        {
            /* Conversion of time for mathematical calculation */
            long org_master = sdf.parse(mastertime).getTime();
            long org_slave_1 = sdf.parse(time1).getTime();
            long org_slave_2 = sdf.parse(time2).getTime();
            long org_slave_3 = sdf.parse(time3).getTime();
            System.out.println("---------------------------------------------------------------------------------");
         
            /* Calculating Tolerance */
            long slave1_difference = org_slave_1 - org_master;
            System.out.println("Differ in time between master and Slave 1 :"+ slave1_difference/1000);
            long slave2_difference = org_slave_2 - org_master;
            System.out.println("Differ in time between master and Slave 2 :"+ slave2_difference/1000);
            long slave3_difference = org_slave_3 - org_master;
            System.out.println("Differ in time between master and Slave 3 :"+ slave3_difference/1000);
            System.out.println("---------------------------------------------------------------------------------");
           
            /* Average Fault tolerant */
            long average = (slave1_difference + slave2_difference + slave3_difference + 0) / 4;
            System.out.println("Avearge Fault Tolerence : "+ average/1000);
            System.out.println("---------------------------------------------------------------------------------");
            
            long adjust_master = average+org_master;
            long adjust_slave_1 = average-slave1_difference;
            long adjust_slave_2 = average-slave2_difference;
            long adjust_slave_3 = average-slave3_difference;
            System.out.println("Adjustment for slave 1 : "+ adjust_slave_1/1000);
            System.out.println("Adjustment for slave 2 : "+ adjust_slave_2/1000);
            System.out.println("Adjustment for slave 3 : "+ adjust_slave_3/1000);
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("");
          
            /* Synchronization of  clock */
            System.out.println("*********** Synchronized Master Clock : "+sdf.format(new Date(adjust_master))+ " *********** ");
            System.out.println("*********** Synchronized Slave Clock 1 : "+sdf.format(new Date(org_slave_1+adjust_slave_1))+ " *********** ");
            System.out.println("*********** Synchronized Slave Clock 2 : "+sdf.format(new Date(org_slave_2+adjust_slave_2))+ " *********** ");
            System.out.println("*********** Synchronized Slave Clock 3 : "+sdf.format(new Date(org_slave_3+adjust_slave_3))+ " *********** ");
            System.out.println("");
            System.out.println("---------------------------------------------------------------------------------");
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
    	/* Clock Times */
    	 /* Scanner input = new Scanner(System.in);
    	 System.out.print("Enter a master clock time : ");
    	 String mastertime=input.next();
    	 System.out.print("Enter a slave1 clock time : ");
    	 String slave1=input.next();
    	 System.out.print("Enter a slave2 clock time : ");
    	 String slave2=input.next();
    	 System.out.print("Enter a slave3 clock time : ");
    	 String slave3=input.next();
    	 berkeleyAlgo(mastertime, slave1, slave2, slave3); */
    	 
    	 /* Hard Coded */
    	 berkeleyAlgo("3:00", "3:10", "2:50", "3:20");
    }
}