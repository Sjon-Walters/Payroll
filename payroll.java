//Sjon Walters
// Homework #7 
// CIT 111
// Usage: Payroll System to calculate wages

import java.util.Scanner;
public class Payroll{
   public static void main(String[] args){
   //Seting up arrays, variables, and a scanner object for use within the main program.
   int[] employeeID = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
   int[] hours = {0, 0, 0, 0, 0, 0, 0};//Initializing the arrays to the apporate value.
   double [] payRate = {0, 0, 0, 0, 0, 0, 0};
   double[] wages = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
   Scanner user = new Scanner(System.in);//The Scanner object that handles user input.
   String userInput = "";//This is to hold the user input till it can be converted to the input code for use within the switch statement.
   char userInputCode = 'A';
   int userInputedID = 0;
   int employeePostion = 0; 
   int hoursWorked = 0;
   double employeePay = 0.0;
   double totalEmployeePay = 0.0;
   double hourlyRate = 0.0;
   double grossWages = 0.0;
   boolean inputCheck = false;//This is used to check to make sure that the input is valid.
   boolean proceed = true;//This is used to put the program in infinte loop till the user ends the program by selecting option D.
  
  do{//This loops put the program in infinte loop. 
  do{//This loops controls when a user return to the main menu after they input their data.
  
   System.out.println();//Space for readability
   System.out.println("Please enter the letter that corresponds with your choice.");//Displaying the menu options.
   System.out.println("A: Set employee hours worked.");
   System.out.println("B: Calculate employee wages.");
   System.out.println("C: Display employee information."); 
   System.out.println("D: Exit program.");
   userInput = user.next();
   
    
   do{//This loop checks for valid input.
   
   if(userInput.equalsIgnoreCase("A") != true && userInput.equalsIgnoreCase("B") != true && userInput.equalsIgnoreCase("C") != true && userInput.equalsIgnoreCase("D") != true){
      System.out.println("Please enter a valid letter");
      userInput = user.next();
   }else if(userInput.equalsIgnoreCase("A") || userInput.equalsIgnoreCase("B") || userInput.equalsIgnoreCase("C") || userInput.equalsIgnoreCase("D"))
      inputCheck = true;
      
      
      
   }while(inputCheck == false);
       inputCheck = false;

       System.out.println("Please enter employee ID. Note: IDs must be exact.");//Prompting the user to enter in an employee ID.
       userInputedID = user.nextInt();
   
     
      for(int i = 0; i < employeeID.length; i++){//Searching for the employee ID.
         if(userInputedID == employeeID[i]){
         inputCheck = true;
         employeePostion = i;
         i = employeeID.length;//This is used to end the loop once the ID has been found.
         
         }
         }
         if(inputCheck == false)//displaying an error message if the employee ID isn't found.
         System.out.println("Employee not found. Note: IDs must be exact.");
         
      
      }while(inputCheck == false);   
      
   
   if(userInput.equalsIgnoreCase("A"))//Converting the string menu choice into the appropriate input code to be used within the switch statement. 
      userInputCode = 'a';
   else if(userInput.equalsIgnoreCase("B"))
      userInputCode = 'b';
   else if(userInput.equalsIgnoreCase("C"))
      userInputCode = 'c';
   else if(userInput.equalsIgnoreCase("D"))
      userInputCode = 'd';
   
   
   
   
   
   switch(userInputCode){//Performing the menu choice based on what the user selected.
      case 'a':   System.out.println("Please enter the number of hours the selected employee worked: ");//Allowing the user to enter the hours that an employee worked.
                  hoursWorked = user.nextInt();
                  hours[employeePostion] = hoursWorked;      
                  break;

      case 'b':   System.out.println("Please enter the pay per hour of the selected employee: ");//Performing the necessary calculation to get the gross wages for the employee.
                  employeePay = user.nextDouble();
                  payRate[employeePostion] = employeePay;
                  wages[employeePostion] = payRate[employeePostion] * hours[employeePostion];/
                  break;
                  
      case 'c':   hourlyRate =  payRate[employeePostion];//Displaying the employee information.
                  System.out.println("Employee ID Number: " + employeeID[employeePostion] + " Hourly rate: $" + hourlyRate + " Gross wages: $" + wages[employeePostion]);
                  break;

      case 'd':   for(int index = 0; index < wages.length; index++)//Adding all the wages, displayng the result,  outputing the result, and then terminating the program. 
                     grossWages = grossWages + wages[index];
                           
                  System.out.println("Gross Wages are: $" + grossWages);
                  System.exit(0);
                  break;
              
   
   }
}while(proceed == true);
  
   }
}