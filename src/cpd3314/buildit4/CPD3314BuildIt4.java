/*
 * Copyright 2014 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cpd3314.buildit4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class CPD3314BuildIt4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Initialize Input Variables
        Scanner kb = new Scanner(System.in);
        int choice = 0;

        // Begin Loop for Main Menu
        do {
            // Output Sample Descriptions
            String[] samples = {
                "Output 1-10 in Order",
                "Output Multiples of 7 under 100",
                "Guessing Game",
                "Calculate Average 1-1000",
                "Mimic Program with Sentinel Value",
                "Madlibs with File Input/Output",
                "100 Random Printable Characters to File"
            };
            int i = 1;
            System.out.println("====================");
            for (String sample : samples) {
                System.out.println(i++ + ". " + sample);
            }

            // Perform Input and Validation
            do {
                try {
                    System.out.println("Which sample would you like to run (0 to quit)?");
                    choice = kb.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("That is not a valid choice.");
                }
            } while (choice < 0 || choice > samples.length);

            // Switch Off to Subroutines
            switch (choice) {
                case 1:
                    doExercise1();
                    break;
                case 2:
                    doExercise2();
                    break;
                case 3:
                    doExercise3();
                    break;
                case 4:
                    doExercise4();
                    break;
                case 5:
                    doExercise5();
                    break;
                case 6:
                    doExercise6();
                    break;
                case 7:
                    doExercise7();
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("That is not a valid choice.");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * Output 1-10 in Order
     */
    private static void doExercise1() {
        int x = 1;
        while (x <= 10) {
            System.out.println(x);
            x++;
        }
    }

    /**
     * Output Multiples of 7 under 100
     */
    private static void doExercise2() {
        int x = 7;
        while (x <= 100) {
            System.out.println(x);
            x += 7;
        }
    }

    /**
     * Guessing Game
     */
    private static void doExercise3() {
        Scanner kb = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Guess my number between 1-10:");
            choice = kb.nextInt();
            if (choice < 1 || choice > 10) {
                System.out.println("The number must be between 1-10.");
            }
        } while (choice != 3);
        System.out.println("Congratulations!");
    }

    /**
     * Calculate Average 1-1000
     */
    private static void doExercise4() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        double average = sum / 1000.0;
        System.out.println("Average of all whole numbers 1-1000 is " + average);
    }

    /**
     * Mimic Program with Sentinel Value
     */
    private static void doExercise5() {
        Scanner kb = new Scanner(System.in);
        String input;
        do {
            System.out.print("Input ('exit' to exit): ");
            input = kb.nextLine();
            System.out.println("> " + input);
        } while (!input.equals("exit"));
        System.out.println("Thank you.");
    }

    /**
     * Madlibs with File Input/Output
     */
    private static void doExercise6() throws IOException {
        PrintWriter output = new PrintWriter("ex6output.txt");
        File file = new File("ex6input.txt");
        Scanner input = new Scanner(file);
        
        String name = input.nextLine();
        String age = input.nextLine();
        String city = input.nextLine();
        String college = input.nextLine();
        String profession = input.nextLine();
        String animal = input.nextLine();
        String pet = input.nextLine();
        
        output.printf("There once was a person named %s who lived in %s. At "
                + "the age of %s, %s went to college at %s. %s graduated and "
                + "went to work as a %s. Then, %s adopted a(n) %s named %s. "
                + "They both lived happily ever after!", name, city, age, name,
                college, name, profession, name, animal, pet);
        
        System.out.println("Output to file.");
        input.close();
        output.close();
    }

    /**
     * 100 Random Printable Characters to File
     */
    private static void doExercise7() throws IOException {
        PrintWriter output = new PrintWriter("ex7output.txt");
        Random rng = new Random();
        for (int i = 0; i < 100; i++) { 
            int charNum = rng.nextInt(126-32) + 32;
            /* The following line forces an integer (-2.4b to 2.4b) into a
             * unicode character range (0-65535). This is called "casting".
             */
            char character = (char) charNum;
            output.print(character);
        }
        System.out.println("Output to file.");
        output.close();
    }

}
