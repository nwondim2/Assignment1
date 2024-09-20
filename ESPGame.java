import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {
	public static void main(String[] args) throws FileNotFoundException {
		
		// Variables
		// Final
		final String GREETING = "CMSC203 Assignmnet1: Test your ESP skills!\nEnter the filename: ";
		final String ENDGAME = "Game Over";
		final int COLOR_SIZE = 16;
		
		// Objects
		Scanner inputScan = new Scanner(System.in), scan = null;
		Random rand = new Random();
		
		// Immutable
		String fileName, guess, randColorName = "", finalOutput, userName, userDescription, userDate;
		int randColor, scoreCounter = 0;
		
		// Introduction
		System.out.print(GREETING);
		
		// File Accessing.
		fileName = inputScan.nextLine();
		
		// checking for Errors.
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			inputScan.close();
			return;
		}
		
		System.out.println("");
		
		// Display file Contents
		while(scan.hasNext()) {
			System.out.println(scan.nextLine());
		}
		System.out.println("");
		
		
		
		// Game Rounds
		for(int i = 1; i <= 3; i++) {
			// Reset Reader file.
			scan.close();
			scan = new Scanner(new File(fileName));
			
			
			System.out.println("Round " + i + "\n");
			System.out.println("I am thinking of a color.\nis it one of list of colors above?");
			System.out.println("Enter your guess: ");
			
			// Read user color choice.
			guess = inputScan.nextLine();
			guess.toLowerCase();
			
			// Generate random number.
			randColor = rand.nextInt(COLOR_SIZE) + 1;
			
			// Find Color Randomly.
			String temp;
			for(int j = 1; j <= COLOR_SIZE; j++) {
				temp = scan.nextLine();
				if(j == randColor) {
					randColorName = temp.substring(3);
				}
			}
			
			// Display random Color.
			System.out.println("\nI was thinking of " + randColorName + ".");
			
			// scoreCounter increment check
			if(randColorName.equals(guess)) {
				scoreCounter++;
			}
		}
		
		// Reset Reader file.
		scan.close();
		scan = new Scanner(new File(fileName));
		
		// Display Final Results.
		System.out.println(ENDGAME + "\n");
		System.out.println("You guessed " + scoreCounter + " out of 3 colors correctly.");
		
		
		// Take User Info.
		System.out.print("Enter your name: ");
		userName = inputScan.nextLine();
		finalOutput = "User Name: " + userName + "\n";
				
		System.out.print("Describe yourself: ");
		userDescription = inputScan.nextLine();
		finalOutput += "User Description: " + userDescription + "\n";
		
		System.out.print("Due Date: ");
		userDate = inputScan.nextLine();
		finalOutput += "Date: " + userDate;
		
		
		// Display Final Output
		System.out.println(finalOutput);
		
		
		// Close all Input and Output Manipulator.
		inputScan.close();
		scan.close();
	}
}
