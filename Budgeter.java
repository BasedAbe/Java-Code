// Abel Kassa
// 4/27/2019
// CSE142
// TA: Daniel He
// Section: BE
// HW #4: Budgeter

// This program takes a users income and expenses to calculate whether 
// they are a big spender, big saver, spender, or saver.
import java.util.*;

public class Budgeter {
   public static final int DAYS = 31;
   public static void main(String[]args){
      Scanner input =  new Scanner(System.in);
      
      intro();
      double incomeResults = incomeReport(input);
      double expenseResults = expenseReport(input);
      totalResults(input, incomeResults, expenseResults);     
   }
   
   // Prints out an intro to the program 
   public static void intro() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   // Reads input by user and computes total income 
   public static double incomeReport (Scanner input) {
      System.out.print("How many categories of income? ");
      int howManyIncomes = input.nextInt();
      
      double sumInc = 0.0;
      //Prints out "Next income..." as many times as the input to howManyIncomes
      for(int i=0; i<howManyIncomes; i++){ 
         System.out.print("    Next income amount? $");
         double incomeAmounts = input.nextDouble();
         sumInc += incomeAmounts;
      }
      return sumInc;
   }
   
   // Reads input by user and computes total expenses 
   public static double expenseReport (Scanner input) {
      System.out.println();
      System.out.print("Enter 1) monthly or 2) daily expenses? "); //Prompts user for 
      int monthlyOrDaily = input.nextInt();                       // monthly or daily input
      System.out.print("How many categories of expense? ");
      int expenses = input.nextInt();
      double sumExp = 0.0;
      for(int i=0; i<expenses; i++){
         System.out.print("    Next expense amount? $");
         double expenseAmounts = input.nextDouble();
         sumExp += expenseAmounts;  
      }
      if (monthlyOrDaily > 1){
         sumExp = (sumExp)*DAYS;
      }
      return sumExp;
   }
   
   // Reads input by user and computes the income and expenses with daily amount included
   public static void totalResults (Scanner input, double sumInc, double sumExp){  
      System.out.println();
      System.out.println("Total income = $" + round2(sumInc) + " ($" + round2(sumInc/DAYS) + "/day)");
      System.out.println("Total expenses = $" + round2(sumExp) + " ($" + round2(sumExp/DAYS) + "/day)");
      System.out.println();
      double totalResults;
      String moreSpent = " more than you spent this month.";
      String moreEarned = " more than you earned this month.";
            
      if (sumInc > sumExp){
         System.out.println("You earned $" + round2(sumInc - sumExp) + moreSpent);
      }else {
         System.out.println("You spent $" + round2(sumExp - sumInc) + moreEarned);
      }
      if(sumInc - sumExp > 250) {
         System.out.println("You're a big saver.\nYou rich now!!!");
      }
      if(sumInc - sumExp <= -250){
         System.out.println("You're a big spender.\nAKA you're broke STOP SPENDING!!");
      }
      if (sumInc - sumExp > 0 && sumInc - sumExp <= 250){
         System.out.println("You're a saver.\nKeep stacking chips pleighboi;)");
      }
      if (sumInc - sumExp > -250 && sumInc - sumExp <=0){
         System.out.println("You're a spender.\nSlow down or you gonna be broke!");
      } 
   }
   
   // Rounds off sums to the hundredth
   public static double round2(double num) {
      return Math.round(num * 100.0) / 100.0;
   }
}