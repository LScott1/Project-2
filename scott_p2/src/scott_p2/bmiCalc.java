package scott_p2;

import java.util.Scanner;
public class bmiCalc {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in); 
		int bmi = 0;
		int weight = 0;
		int height = 0;
		int type;
		int i;
		int j;
		int heightStart;
		int heightEnd;
		int bmiStart;
		int bmiEnd;
		double tableResult;
		String tableText;
				
				
		System.out.println("Enter 1 for inches & pounds, 2 for meters and kilograms");
		type = scnr.nextInt();
				
		System.out.print("What is your weight?");
		if (type == 1)
			System.out.println("[pounds]");
		else if (type == 2)
			System.out.println("[kilograms]");
		weight = scnr.nextInt();
		
		System.out.print("What is your height?");
		if (type == 1)
			System.out.println("[inches]");
		else if (type == 2)
			System.out.println("[meters]");
		height = scnr.nextInt();
		
		
		if (type == 1) {//inches, pounds
			bmi = (703 * (weight)/(height * height));
		}
		else if (type == 2) {//meters, kilograms
			bmi = ((weight)/(height * height));
		}
		//output bmi
		System.out.println("Your BMI is: " + bmi);
		
		System.out.println("BMI: ");
		
		System.out.print("| ");
		for(i = bmi-5; i < bmi + 5; i++)
			System.out.print(" " + i +" | ");
		System.out.println("");
		System.out.print("VVV Height------------VVV Body Weight (pounds) VVV------------------");
		System.out.println("");
		
		//System.out.println("Enter the starting and ending heights for the table");
		heightStart = height - 8;
		heightEnd = height + 8;
		
		//System.out.println("Enter the starting and ending weights for table");
		bmiStart = bmi -5;
		bmiEnd = bmi + 5;
		
		//for when type=1
		for(i=heightStart; i < heightEnd; i++){//height, inches, row
			System.out.print("|");
			for(j=bmiStart; j < bmiEnd; j++) {
				tableResult = ((j * i * i)/(703));
				tableText = String.format ("%5.1f", tableResult); 
				
				System.out.print(tableText + "|");
				
			}//end row for
			System.out.println("");//move to next row
		}//end table for
	}
}
