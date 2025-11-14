/*
 * WIX1002-VIVA-1 Question 4
 * @author Tay
 */

import java.util.Scanner;

public class V4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // -------------------------------------------------------------
        // INPUT PROCESSING
        // -------------------------------------------------------------
        // Reads two lines of input containing:
        //  a string followed by an integer k separated by a space.
        // Example:  "Satayisverysedap \n 3"
        // --------------------------------------------------------------
        String input = sc.nextLine();

        input = input.toLowerCase(); // Convert the entire string to lowercase

        int k = sc.nextInt();

        // -------------------------------------------------------------
        // ARRAY INITIALIZATION
        // -------------------------------------------------------------

         

        // -------------------------------------------------------------
        // VARIANT 1: Using String.substring()
        // -------------------------------------------------------------
        
        String [] list = new String[input.length() - k + 1];

        // This loop still iterates through all possible STARTING indices
        for (int i = 0; i < list.length; i++) {
            
            // Instead of an inner loop, grab the whole substring at once.
            // i = starting index (inclusive)
            // i + k = ending index (exclusive)
            list[i] = input.substring(i, i + k);
        }

        
        
        /*
         * -------------------------------------------------------------
         * VARIANT 2: Using nested loops and String.charAt()
         * -------------------------------------------------------------
         
        String [] list = new String[input.length()-k+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = "" ; // To get rid of null value

            for (int j = 0; j < k; j++) {
                list[i] += input.charAt(i+j) ;
                
            }
            
        }

        */

        // -------------------------------------------------------------
        // Variable Initialization for Main Logic
        // -------------------------------------------------------------

        // We assume the first element (list[0]) is the smallest/largest/highest sum
        String firstWhisper = list[0]; 
        String LastEcho = list[0]; 
        String coreValue = list[0]; 

        // sumCore will store the highest ASCII sum found so far (initially for coreValue).
        // sumCur is a temporary variable to calculate the sum of the *current* string.
        int sumCore = 0;
        int sumCur = 0;

        // Calculate the ASCII sum for the first string
        // This gives us the first max sum to compare against
        for (int i = 0; i < k; i++) { 
            sumCore += (int)coreValue.charAt(i);
        }

        // -------------------------------------------------------------
        // MAIN LOGIC
        // -------------------------------------------------------------
        // For each string in list (starting from index 1 since index 0 is initialized
        // above):
        // 1. Check and update firstWhisper (lexicographically smallest).
        // 2. Check and update LastEcho (lexicographically largest).
        // 3. Calculate ASCII sum and update coreValue if current sum is higher.
        // -------------------------------------------------------------
        for (int i = 0 ; i < list.length-1; i++) {

            if ( list[i+1].compareTo(firstWhisper) < 0 ) {
                firstWhisper = list[i+1];
            } else if ( list[i+1].compareTo(LastEcho) > 0 ) {
                LastEcho = list[i+1];
            }   
            for (int j = 0; j < k; j++) { 
                sumCur += (int)list[i+1].charAt(j);
            }

            if (
                sumCur > sumCore
            ) {
                coreValue = list[i+1];
                sumCore = sumCur;
            }
            
            // Reset the temporary sum to 0 for the next iteration
            sumCur = 0;
        }

        // -------------------------------------------------------------
        // OUTPUT
        // -------------------------------------------------------------
        System.out.println(firstWhisper);
        System.out.println(LastEcho);  
        System.out.println(coreValue);
    }
}
