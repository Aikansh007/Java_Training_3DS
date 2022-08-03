
import java.time.LocalDate;
import java.util.Scanner;

public class NestedClassesWineSoldEx {

       public static void main(String[] args) {
              // TODO Auto-generated method stub

              Scanner sc = new Scanner(System.in);
              System.out.println("-----------Enter the Beverages Details-----");
              
              System.out.println("Enter Beverage package No");
              int pno = sc.nextInt();
              
              System.out.println("Enter the Beverage Name(Wine,Whishky,Softdrinks,Beer)");
              String btype = sc.next();
              
              System.out.println("Enter the Number of bottles ");
              int botNo = sc.nextInt();
              
              Beverages bev = new Beverages(pno,btype,botNo);
              
              Beverages.BeveragesTransaction bt1 = new Beverages.BeveragesTransaction();
              Beverages.BeveragesTransaction bt2 = new Beverages.BeveragesTransaction();
              Beverages.BeveragesTransaction bt3 = new Beverages.BeveragesTransaction();
              Beverages.BeveragesTransaction bt4 = new Beverages.BeveragesTransaction();
              Beverages.BeveragesTransaction bt5 = new Beverages.BeveragesTransaction();
              
              System.out.println("Enter what you want to do Buy or Sell");
              String trans = sc.next();
              
              if(trans.toLowerCase().equals("sell"))
              {
                     bev.activateSelling(true);
                     System.out.println();
                     System.out.println("Enter no. of bottles you want to sell");
                     int sellno = sc.nextInt();
                     bev.sell(sellno);
                     
                     bt1.setSerialId(1);
                     bt1.setTransactionDate(LocalDate.of(2022, 9, 4));
                     bt1.setTransactionType("Sell");
                     bt1.setsellBuyNo(sellno);
                     bt1.setRemaniningBottles(bev.getnoOfBottles() - sellno);
                     
                     
                     System.out.println("************************");
                     System.out.println("-------Beverages After Selling---------");
                     System.out.println("Serial ID          -: "+bt1.getSerialId());
                     System.out.println("Trans Type         -: "+bt1.getTransactionType());
                     System.out.println("No of bottles sold -: "+bt1.getsellBuyNo());
                     System.out.println("Date               -: "+bt1.getTransactionDate());
                     System.out.println("Remaining Bottles  -: "+bt1.getRemaniningBottles());
                     
                     System.out.println("************************");
                     bev.deActivateSelling(false);
              }
              
              
              bev.sell(200);
              
              
       }

}

class Beverages
{
       private int packageNo;
       private String beveragesType;
       private int noOfBottles;
       
       sellingBuyingPermission sellbuyperm = new sellingBuyingPermission(false, true, true);
       
       
       public Beverages(int packageNo, String beveragesType, int noOfBottles) {
              super();
              this.packageNo = packageNo;
              this.beveragesType = beveragesType;
              this.noOfBottles = noOfBottles;
       }
       public int getnoOfBottles() {
              return noOfBottles;
       }
       public void setnoOfBottles(int noOfBottles) {
              this.noOfBottles = noOfBottles;
       }
       
       void activateSelling(boolean activate)
       {
              System.out.println("Activating the Selling....");
              sellbuyperm.setSell(activate);
       }
       
       void deActivateSelling(boolean deActivate)
       {
              System.out.println("de-Activating the Selling....");
              sellbuyperm.setSell(deActivate);
       }
       
       void sell(int soldBottlesNo) {
              if(sellbuyperm.isSell()==false) {
                     throw new RuntimeException("Selling is not yet allowed...");
              }
              else {
                     
                     noOfBottles = noOfBottles - soldBottlesNo;
                     System.out.println("Selling is done...");
              }
      }
       
       public static class BeveragesTransaction
       {
                    int serialId;
                     LocalDate transactionDate;
                     String transactionType;
                     int sellBuyNo;
                     int remaniningBottles;
                     public int getSerialId() {
                           return serialId;
                     }
                     public void setSerialId(int serialId) {
                           this.serialId = serialId;
                     }
                     public LocalDate getTransactionDate() {
                           return transactionDate;
                     }
                     public void setTransactionDate(LocalDate transactionDate) {
                           this.transactionDate = transactionDate;
                     }
                     public String getTransactionType() {
                           return transactionType;
                     }
                     public void setTransactionType(String transactionType) {
                           this.transactionType = transactionType;
                     }
                     public int getsellBuyNo() {
                           return sellBuyNo;
                     }
                     public void setsellBuyNo(int sellBuyNo) {
                           this.sellBuyNo = sellBuyNo;
                     }
                     public int getRemaniningBottles() {
                           return remaniningBottles;
                     }
                     public void setRemaniningBottles(int remaniningBottles) {
                           this.remaniningBottles = remaniningBottles;
                     }
                     @Override
                     public String toString() {
                           return "BeveragesTransaction [serialId=" + serialId + ", transactionDate=" + transactionDate
                                         + ", transactionType=" + transactionType + ", sellBuyNo=" + sellBuyNo
                                         + ", remaniningBottles=" + remaniningBottles + "]";
                     }                                 
       }
       
        private class sellingBuyingPermission
       {
                    boolean sell; //false
                     boolean buy ;// false;
                     boolean transact; //false
                     
                     public sellingBuyingPermission(boolean sell, boolean buy, boolean transact) {
                           super();
                           this.sell = sell;
                           this.buy = buy;
                           this.transact = transact;
                     }

                     public boolean isSell() {
                           return sell;
                     }

                     public void setSell(boolean sell) {
                           this.sell = sell;
                     }

                     public boolean isBuy() {
                           return buy;
                     }

                     public void setBuy(boolean buy) {
                           this.buy = buy;
                     }

                     public boolean isTransact() {
                           return transact;
                     }

                     public void setTransact(boolean transact) {
                           this.transact = transact;
                     }
                     
                     
       }
       
}
