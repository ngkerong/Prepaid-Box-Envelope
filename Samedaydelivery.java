import java.util.Scanner;
public class Samedaydelivery
{
static double grandLocal = 0;
static double grandCross = 0;
static double grandBoth;

public static void main(String args[])
{
	
	 String format1 = "%-10s%35s%50s%n";
	 String format2 = "%30s%14s%16s%25s%16s%14s%n";
	 String format3 = "%-10s%18s%10s%20s%20s%18s%17s%n";
	 String format4 = "%100s%n";
	 System.out.println("2. Same-Day Delivery");
	 System.out.println("For this service, your shipment will arrive on the same day in the same town area. The table below shows the payment rates by weight and town-type.\n");
	 System.out.printf(format1,"Weight","Local Town","Cross Town");
	 System.out.printf(format2,"Domestic Charge","Surcharge","Total","Domestic Charge","Surcharge","Total");
	 System.out.printf(format3,"Below  500gm","4.90","6.00","10.90","5.40","7.50","12.90");
	 System.out.printf(format3,"500gm- 750gm","5.70","6.00","11.70","6.40","7.50","13.90");
	 System.out.printf(format3,"750gm-   1kg","6.50","6.00","12.50","7.40","7.50","14.90");
	 System.out.printf(format4,"All charges in RM");
	

double wt=0;

while (true)
{
wt=calculateweight();

if (wt<0) {
System.out.println("exiting program");
break;
}
else
{
	System.out.println("Enter 1 for local town, 2 for cross town");
	
	Scanner sc = new Scanner(System.in);
    String a;
    a = sc.nextLine();
    System.out.println("The entered integer is " + a);
    
    
    if ("1".equals(a)){
        System.out.println("Call calculate local town");
        calculateLocalTownCharge(wt);
        printLocalTownReceipt(wt);
      }
      else if ("2".equals(a)){
        System.out.println("Call calculate cross town");
        calculateCrossTownCharge(wt);
        printCrossTownReceipt(wt);
      }
      else
        System.out.println("Invalid try again"); 
    
   
   }
}
/*Calculate Grand Total of both town*/
grandBoth = grandLocal + grandCross;
grandBoth = Math.round(grandBoth * 100.0) / 100.0;

/*Display Grand Total for Both town*/
System.out.printf("%25s\n","Receipt");
System.out.println("Grand Total of Local Town\t:" +grandLocal);
System.out.println("Grand Total of Cross Town\t:" +grandCross);
System.out.println("Grand Total of both town\t:" +grandBoth);

System.out.println("\n\n1.\t\t\tBack to Main Menu.");
System.out.println("2.\t\t\tExit.");
int menu;
Scanner input=new Scanner(System.in);



do{
System.out.printf("Enter your chose you want\t\t\t:");
menu = input.nextInt();
}while(menu != 1 & menu != 2);

//input.close();



if ( menu==1 )
{
      MainMenu.main(args);
}
else
{
   Exit.main(args);
}
}


private static void printLocalTownReceipt(double wt) {
	System.out.printf("Local Town Deliver Charge");
	System.out.println("Local Town weight is "+wt);
	
	
	double domesticCharge=0;
	double surcharge=0;
	double total = 0;
	if((wt>=0)&&(wt<500)){
		 domesticCharge=4.90;
		 surcharge=6.90;
		 total=10.90;
	}


	else if((wt>=500)&&(wt<=750)){
	 domesticCharge=5.70;
	 surcharge=6.00;
	 total=11.70;
	}


	else if((wt>=750)&&(wt<=1000)){
	 domesticCharge=6.50;
	 surcharge=6.00;
	 total=12.50;
	}


	else{
	System.out.println("No rates available");

	}
	System.out.println("Local Town domestic charge is "+ domesticCharge);
	System.out.println("Local Town surcharge is "+surcharge);
	System.out.println("Local Town total is "+total);
   grandLocal += total;
	System.out.println("Grant Total Price is " +grandLocal);
	}
	
	
	

private static void printCrossTownReceipt(double wt) {
	System.out.printf("Cross Town Deliver Charge");
	System.out.println("Cross Town weight is "+wt);
	
	
	double domesticCharge=0;
	double surcharge=0;
	double total = 0;
	if((wt>=0)&&(wt<500)){
		 domesticCharge=5.40;
		 surcharge=7.50;
		 total=12.90;
	}


	else if((wt>=500)&&(wt<=750)){
	 domesticCharge=6.40;
	 surcharge=7.50;
	 total=13.90;
	}


	else if((wt>=750)&&(wt<=1000)){
	 domesticCharge=7.40;
	 surcharge=7.50;
	 total=14.90;
	}


	else{
	System.out.println("No rates available");

	}
	System.out.println("Cross Town domestic charge is "+ domesticCharge);
	System.out.println("Cross Town surcharge is "+surcharge);
	System.out.println("Cross Town total is "+total);
   grandCross += total;
	System.out.println("Grant Total Price is " +grandCross);
	}
	


static double calculateweight()
{

System.out.println("enter number amount of weight. Enter negative weight to exit.");

Scanner sc=new Scanner(System.in);

double weight = sc.nextDouble();

System.out.println("Weigth : " + weight);
//sc.close();

return weight;

}

static void calculateLocalTownCharge(double weight1)
{
double charge=0;

if((weight1>=0)&&(weight1<500)){
double domesticCharge=4.90;
double surcharge=6.90;
System.out.println(domesticCharge+ surcharge);
}


else if((weight1>=500)&&(weight1<=750)){
double domesticCharge=5.70;
double surcharge=6.00;
System.out.println(domesticCharge+ surcharge);
}


else if((weight1>=750)&&(weight1<=1000)){
double domesticCharge=6.50;
double surcharge=6.00;
System.out.println(domesticCharge+ surcharge);
}


else{
System.out.println("No rates available");

}
}

static void calculateCrossTownCharge(double weight1)
{
double charge=0;

if((weight1>=0)&&(weight1<500)){
double domesticCharge=5.40;
double surcharge=7.50;
System.out.println(domesticCharge+ surcharge);
}


else if((weight1>=500)&&(weight1<=750)){
double domesticCharge=6.40;
double surcharge=7.50;
System.out.println(domesticCharge+ surcharge);
}


else if((weight1>=750)&&(weight1<=1000)){
double domesticCharge=7.40;
double surcharge=7.50;
System.out.println(domesticCharge+ surcharge);
}


else{
System.out.println("No rates available");

}



}
}