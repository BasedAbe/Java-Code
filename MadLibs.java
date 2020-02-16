//	Abel Kassa
//	5/21/2019
//	CSE142
//	TA: Daniel He
//	Section:	BE
//	HW	#6: Mad Lib

//	This program asks the user to create a mad lib or view a mad lib
// with the option of qutting if they decide not to play. The program
// prompts the user to create a mad lib from existing mad lib templates
// and if it does not exist it will reprompt users for an existing file. The
// user is also able to view their mad lib by pressing v and typing in
// an existing txt file when prompted and then the madlib will printed
// out onto the console.

import java.io.*;
import java.util.*;

public class MadLibs {
   public static void main (String[]args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      String option = "";
      
      introToMadlib();
      while(!option.equalsIgnoreCase("q")){
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         option = console.next();
         if(option.equalsIgnoreCase("c")){
            createLib(console);
         }
         else if (option.equalsIgnoreCase("v")){
            viewLib(console);
         }
      }
   }
   
   // Prints out welcome intro to MadLibs.
   public static void introToMadlib(){
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.\n");
   }
   
   // Takes in the Scanner console to ask users to input file name until it is
   // found, then once it is found asks the user to input new output file name.
   // After user answers questions, PrintStream newOutput transfers users answers
   // to the new output file that the user named earlier.
   public static void createLib(Scanner console) throws FileNotFoundException {
      System.out.print("Input file name: ");
      String inputFile = console.next();
      File madLib = new File (inputFile);
      while(!madLib.exists()){
         System.out.print("File not found. Try again: ");
         inputFile = console.next();
         madLib = new File(inputFile);
      }
      System.out.print("Output file name: ");
      String outFile = console.next();
      System.out.println();
      PrintStream newOutput = new PrintStream(new File(outFile));
      Scanner input = new Scanner(madLib);
      while (input.hasNextLine()){
         String line = input.nextLine();
         outLines(line, newOutput, console);
      }
      System.out.println("Your mad-lib has been created!\n");
   }
   
   // Takes in the Scanner console to ask users to input the name
   // of the file that they are looking for until an existing file is entered.
   // Once the file is found the method prints out the existing file for the
   // user to view.
   public static void viewLib(Scanner console) throws FileNotFoundException{
      System.out.print("Input file name: ");
      String viewLib = console.next();
      File oldLib = new File(viewLib);
      while (!oldLib.exists()){
         System.out.print("File not found. Try again: ");
         viewLib = console.next();
         oldLib = new File(viewLib);
      }
      Scanner showLib = new Scanner(oldLib);
      while(showLib.hasNextLine()) {
         System.out.println(showLib.nextLine());
      }
      System.out.println();
   }
   
   // Takes in String, PrintStream, and Scanner console. String is used to find
   // parts of text that start and end with angle brackets < >. Then the text is
   // printed to the new lib with Prinstream newOutput. The Scanner console is used
   // as parameter to the method called pleaseType.
   public static void outLines (String line, PrintStream newOutput, Scanner console) {
      String a = " ";
      Scanner lineScan = new Scanner(line);
      while (lineScan.hasNext()){
         a = lineScan.next();
         if(a.startsWith("<") || a.endsWith(">")) {
            a = pleaseType(console, lineScan, a);
         }
         newOutput.print(a + " ");
      }
      newOutput.println();
   }
   
   // Takes in Scanner console, Scanner input, and String. Scanner console
   // is used to print out the questions with the place holder from the old
   // madlib being used in the question. String is used to find the place
   // holders that start with vowels so they can be printed out with a/an.
   // Returns the new mad lib after angle brackets are replaced with user input.
   public static String pleaseType(Scanner console, Scanner input, String token){
      String placeholder = token;
      placeholder = placeholder.replace("<", "").replace("-"," ").replace(">","");
      if (placeholder.startsWith("u") || placeholder.startsWith("i") || placeholder.startsWith("o")
      || placeholder.startsWith("e") || placeholder.startsWith("a")){
         System.out.print("Please type an " + placeholder + ": ");
      } else {
         System.out.print("Please type a " + placeholder + ": ");
      }
      String updatedLib = console.next();
      return updatedLib;
   }
}