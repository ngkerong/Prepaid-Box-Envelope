import java.util.Scanner;
public class Poslaju{
   
   public static void main(String[]args){
      Scanner sc=new Scanner(System.in);
   
      int menu;
      String format1 = "%35s%50s%n";
      String format2 = "%20s%25s%25s%25s%n";
      String format3 = "%-10s%7s%23s%26s%22s%n";
      String format4 = "%95s%n";
      int i = 0;
      
      /*Display Menu*/
      System.out.println("1. NEXT-DAY DELIVERY");
      System.out.println("The service promises the delivery of goods or mails the next day. \nThe table below shows the payment rates by zone, weight and package type.\n");
      System.out.printf(format1,"Document(below 2kg)","Parcel(above 2kg)");
      System.out.printf(format2,"First 500gm","Subsequent 250gm","2.001-2.5kg","Subsequent 500gm");
      System.out.printf(format3,"Zone 1","4.90","0.80","10.50","0.50");
      System.out.printf(format3,"Zone 2","5.40","1.00","16.00","2.00");
      System.out.printf(format3,"Zone 3","6.90","1.50","21.00","3.00");
      System.out.printf(format3,"Zone 4","7.40","1.50","26.00","3.50");
      System.out.printf(format3,"Zone 5","7.90","2.00","31.00","4.00");
      System.out.printf(format4,"All charges in RM");
      System.out.println("Category each zone:");
      System.out.println("Zone 1: City");
      System.out.println("Zone 2: In Peninsular Malaysia, Sarawak and Sabah");
      System.out.println("Zone 3: Between Sabah and Sarawak");
      System.out.println("Zone 4: Between Peninsular Malaysia and Sarawak");
      System.out.println("Zone 5: Between Peninsular Malaysia and Sabah");
      do{
      System.out.println("\nDo you want to place your order?\nIf YES, press number 1.\nIf NO, press number 2.");
      int number= sc.nextInt();
      }while(number != 1 & number != 2);
      
      double[] total_price = new double [30];
      double[] each_weight = new double [30];
      int[] each_zone = new int[30];
      double weight_rate,weight_remainder,total_additional_price,grand_total = 0,quantity;
      double additional_weight=0,total_price_zone_1=0,total_price_zone_2=0,total_price_zone_3=0,total_price_zone_4=0,total_price_zone_5=0;
   
      while(number!=2){
         String[] goods = new String [30];
         int zone;
         double weight;
         
         do{
         System.out.println("\nPlease enter zone =");
         zone= sc.nextInt();
         }while(zone != 1 & zone != 2 & zone != 3 & zone != 4 & zone != 5);
         
         do{
         System.out.println("\nPlease enter the weight of goods(gm) =");
         weight= sc.nextDouble();
         }while(weight < 0);
         
         /*Call Method*/
         goods[i] = typeOfGoods(weight);
         
         System.out.println("Your Type of Goods Recommended is " +goods[i]);
         
         System.out.println("\nPlease enter the quantity =");
         quantity=sc.nextDouble();
      
      
      /*Calculation Price For Zone 1*/
         double weight_first=500;
         double subsequent_weight=250;
         double additional_price=0.80;
         double price=4.90;
      
      
         if(zone==1&&weight<=500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            
            total_price[i] = price * quantity;
         }
         else if(zone==1&&weight>500&&weight<2000){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_1=(total_additional_price+weight_remainder+price);
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_1);
            System.out.println("Total Price= RM " +total_price_zone_1*quantity);
            total_price[i] = total_price_zone_1 * quantity;
         } 
      
         weight_first=2500;
         subsequent_weight=500;
         additional_price=0.50;
         price=10.50;
      
         if(zone==1&&weight>=2000&&weight<=2500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==1&&weight>2500){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_1=(total_additional_price+weight_remainder+price)*quantity;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_1);
            System.out.println("Total Price= RM " +total_price_zone_1*quantity);
            total_price[i] = total_price_zone_1 * quantity;
         }
      
      /*Calculation Price For Zone 2*/
         weight_first=500;
         subsequent_weight=250;
         additional_price=1.00;
         price=5.40;
      
         if(zone==2&&weight<=500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==2&&weight>500&&weight<2000){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_2=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_2);
            System.out.println("Total Price= RM " +total_price_zone_2*quantity);
            total_price[i] = total_price_zone_2 * quantity;
         }
      
         weight_first=2500;
         subsequent_weight=500;
         additional_price=2.00;
         price=16.00;
      
         if(zone==2&&weight>=2000&&weight<=2500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==2&&weight>2500){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_2=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_2);
            System.out.println("Total Price= RM " +total_price_zone_2*quantity);
            total_price[i] = total_price_zone_2 * quantity;
         }
      
      /*Calculation Price For Zone 3*/
         weight_first=500;
         subsequent_weight=250;
         additional_price=1.50;
         price=6.90;
      
         if(zone==3&&weight<=500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==3&&weight>500&&weight<2000){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_3=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_3);
            System.out.println("Total Price= RM " +total_price_zone_3*quantity);
            total_price[i] = total_price_zone_3 * quantity;
         }
      
         weight_first=2500;
         subsequent_weight=500;
         additional_price=3.00;
         price=21.00;
      
         if(zone==3&&weight>=2000&&weight<=2500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==3&&weight>2500){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_3=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_3);
            System.out.println("Total Price= RM " +total_price_zone_3*quantity);
            total_price[i] = total_price_zone_3 * quantity;
         }
      
      /*Calculation Price For Zone 4*/
         weight_first=500;
         subsequent_weight=250;
         additional_price=1.50;
         price=7.40;
      
         if(zone==4&&weight<=500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==4&&weight>500&&weight<2000){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_4=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_4);
            System.out.println("Total Price= RM " +total_price_zone_4*quantity);
            total_price[i] = total_price_zone_4 * quantity;
         }
      
         weight_first=2500;
         subsequent_weight=500;
         additional_price=3.50;
         price=26.00;
      
         if(zone==4&&weight>=2000&&weight<=2500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==4&&weight>2500){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_4=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_4);
            System.out.println("Total Price= RM " +total_price_zone_4*quantity);
            total_price[i] = total_price_zone_4 * quantity;
         }
      
      /*Calculation Price For Zone 5*/
         weight_first=500;
         subsequent_weight=250;
         additional_price=2.00;
         price=7.90;
      
         if(zone==5&&weight<=500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==5&&weight>500&&weight<2000){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_5=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_5);
            System.out.println("Total Price= RM " +total_price_zone_5*quantity);
            total_price[i] = total_price_zone_5 * quantity;
         }
      
         weight_first=2500;
         subsequent_weight=500;
         additional_price=4.00;
         price=31.00;
      
         if(zone==5&&weight>=2000&&weight<=2500){
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +price);
            System.out.println("Total Price= RM " +price*quantity);
            total_price[i] = price * quantity;
         }
         else if(zone==5&&weight>2500){
            additional_weight= weight-weight_first;
            weight_rate=(additional_weight/subsequent_weight);
            weight_remainder=(additional_weight%subsequent_weight);
         
            if(weight_remainder>0){
               weight_remainder=additional_price;
            }
            total_additional_price=Math.round((int)weight_rate)*additional_price;
            total_price_zone_5=total_additional_price+weight_remainder+price;
            System.out.println("Type of goods= " +goods[i]);
            System.out.println("Quantity= "+quantity);
            System.out.println("Price of each goods= RM " +total_price_zone_5);
            System.out.println("Total Price= RM " +total_price_zone_5*quantity);
            total_price[i] = total_price_zone_5 * quantity;
         }
         
         each_zone[i] = zone;
         each_weight[i] = weight;
          
         do{
         System.out.println("\nDo you want to place your order?\nIf YES, press number 1.\nIf NO, press number 2.\n");
         number= sc.nextInt();
         }while(number != 1 & number != 2);
         
         i++;
      }
               
   /*Display grand total receipt*/
   String format5 = "%-30s%-10s\n",
   format6 = "%-3d%-13s%-4s%-2d%3s%10.2f\n",
   format7 = "%-30s%-10.2f";
   
   System.out.printf("%30s\n","Receipt");
   System.out.printf(format5,"Next-Day Delivery","Total Price(RM)");
   i =0;
   int j =1;
   
   while(total_price[i] != 0){
         if(each_weight[i] < 2000){
            System.out.printf(format6,j,"Document for ","Zone",each_zone[i],"-",total_price[i]);
         }else{
            System.out.printf(format6,j,"Parcel for ", "Zone",each_zone[i],"-",total_price[i]);
         }
         grand_total += total_price[i];
         i++;
         j++;
   }
   System.out.printf(format7,"Grand Total Price is",grand_total);
   
   
   /*Prompt the user to make seletion*/
      System.out.println("\n\n1.\t\t\tBack to Main Menu.");
      System.out.println("2.\t\t\tExit.");
      do{
         System.out.printf("Enter your chose you want\t\t\t:");
         menu = sc.nextInt();
      }while(menu != 1 & menu != 2);
   
      switch (menu){
      
         case 1:
            MainMenu.main(args);
            break;
      
         default:
            Exit.main(args);
            break;
      }
   
   }
   
   public static String typeOfGoods(double weight){
   
      String goods;
      
      if (weight < 2000 ){
          goods = "Doceument";
      }else{
          goods = "Parcel";
      }
      
      return goods;
    }
}