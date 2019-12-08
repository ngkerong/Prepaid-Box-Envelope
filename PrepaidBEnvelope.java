import java.util.Scanner;

public class PrepaidBEnvelope{

   public static void main(String[] args){
   
      Scanner input = new Scanner(System.in);
      
      String[] typeDelivery = new String [20];
      String delivery,
      format1 = "%-15s%-20s%-20s%-25s%-25s%-25s\n",
      format2 = "%-30s%-10s\n",
      format3 = "%-4s%-3s%-6.2f%-2s%-15d%-10.2f\n",
      format4 = "%-30s%-10.2f";
      double[] price = new double[20];
      double[] totalPrice= new double[20];
      double weight, grandPrice = 0;
      int[] numberDelivery = new int [20];
      int number,follow;
      byte i = 0;
      
      /*Display Menu of Perpaid Box & Envelope*/
      System.out.printf("%80s\n\n","Menu of Prepaid Box & Envelope"); 
      System.out.printf(format1,"Jenis","Envelope S (ES)","Envelope L (EL)","Prepaid Box S (PBS)","Prepaid Box M (PBM)","Prepaid Box L (PBL)");
      System.out.printf(format1,"Saiz","280mm x 200mm","380mm x 320mm","380mm x 250mm x 80mm","340mm x 250mm x 150mm","380mm x 320mm x 200mm");
      System.out.printf(format1,"Berat Max","0 - 0.50Kg","0.51 - 1.00Kg","1.01 - 2.00Kg","2.01 - 5Kg","5.01 - 10Kg");
      System.out.printf(format1,"Harga","RM 7.31","RM 10.49","RM 13.78","RM 21.20","RM 31.80");
      
      /*Prompt the useer to order*/
      System.out.printf("\nDo you want to order(1 to order, 2 to close)\t\t\t:");
      follow = input.nextInt();
      
      while(follow != 2){
         do{
            /*Input weight for Delivery*/
            System.out.printf("\nEnter the Weight of Delivery\t\t\t\t\t\t\t\t:");
            weight = input.nextDouble();
         }while(weight > 10.00 | weight < 0);
      
         /*Call Method*/
         delivery = WeightofDelivery(weight);

         /*Call Method*/
         price[i] = FindPrice(delivery);    
         typeDelivery[i] = delivery;

         /*Input the number of delivery*/
         System.out.printf("Enter the number of deivery you want\t\t\t\t\t:");
         number = input.nextInt();
         numberDelivery[i] = number;
         
         /*Call Method*/
         price[i] = FindPrice(delivery);
         
         /*Calculate the total price*/
         totalPrice[i] = price[i] * numberDelivery[i];
         totalPrice[i] = Math.round(totalPrice[i] * 100.0) / 100.0;
         
         /*Display Price and Total Price*/
         System.out.println("The Price of Perpaid Box & Envelope \t\t\t\t\t:RM" +price[i]);
         System.out.println("The Total Price of Perpaid Box & Envelope \t\t\t:RM" +totalPrice[i]);     
         System.out.printf("Do you still want to buy?(1 to order, 2 to close)\t:");      
         follow = input.nextInt();
         input.nextLine();
         
         /*Calculate the grand price*/
         grandPrice += totalPrice[i];
         i++;
         }
         
         /*Display Receipt*/
         System.out.printf("%30s\n","Receipt");
         System.out.printf(format2,"Prepaid Box & Envelope","Total Price(RM)");
         i =0;
         while(price[i] != 0){
               System.out.printf(format3,typeDelivery[i], "-", price[i], "x", numberDelivery[i],totalPrice[i]);
               i++;
         }
         System.out.printf(format4,"Grand Total Price is",grandPrice);
         
      input.close();
      }

   public static String WeightofDelivery (double weight){
   
      String jenis;
      
      if (weight <= 0.50){
         jenis = "ES";
      }else if (weight > 0.50 & weight <= 1.00){
                jenis = "EL";
            }else if (weight > 1.00 & weight <= 2.00){
                      jenis = "PBS";
                  }else if (weight > 2.00 & weight <= 5.00){
                            jenis = "PBM";
                        }else{
                              jenis = "PBL";
                         }

      return jenis;
      }

    public static double FindPrice(String jenis){
      
         double harga;
         
         switch (jenis){
         
            case "ES":
               harga = 7.31;
               break;
            
            case "EL":
               harga = 10.49;
               break;

            case "PBS":
               harga = 13.78;
               break;
               
            case "PBM":
               harga = 21.20;
               break;
               
            default:
               harga = 31.80;
               break;
         }

      return harga;
      }
}
