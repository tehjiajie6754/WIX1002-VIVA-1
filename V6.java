/*
 * WIX1002-VIVA-1 Question 6
 * @author Tay
*/

import java.util.Scanner;

public class V6 {

    // For the sake of readability , we define a helper method

    /**
     * Checks whether a character represents a digit between '2' and '9'.
     * @param character the character to check
     * @return true if the character is a digit from '2' to '9', false otherwise
     * 
     * character comparison is possible because of java using ASCII values
     * '2' to '9' are in consecutive order in ASCII table (50 to 57)
     */
    public static boolean isInt(int character) {
        return (character >= '2' && character <= '9');
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------------------------------------------
        // INPUT PROCESSING
        // -------------------------------------------------------------
        // Reads a single line of input containing:
        //  n  followed by  n  strings separated by spaces.
        // Example:  5 a4b2 log5 4bidden test1ng xy22z
        // The first term (n) indicates the number of subsequent strings.
        // -------------------------------------------------------------
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        int n = Integer.parseInt(parts[0]);

        // Store the next n strings into an array
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parts[i + 1];
        }

        // -------------------------------------------------------------
        // MAIN LOGIC
        // -------------------------------------------------------------
        // For each string in arr:
        // 1. Validate whether it follows the compression rules.
        // 2. If invalid → print "Invalid Log".
        // 3. If valid → compute and print the decompressed length.
        // -------------------------------------------------------------

        for (int i = 0; i < n; i++) {
            int count = 0;         // Accumulator for decompressed length
            boolean invalid = false;

            for (int j = 0; j < arr[i].length(); j++) {

                // -----------------------------------------------------
                // INVALID LOG CONDITIONS
                // -----------------------------------------------------
                if (
                    // Rule A: The first character cannot be a digit.
                    isInt(arr[i].charAt(0))
                    
                    // Rule B: Two consecutive digits are not allowed.
                    || (j < arr[i].length() - 1 &&
                        isInt(arr[i].charAt(j)) &&
                        isInt(arr[i].charAt(j + 1)))
                    
                    // Rule C: '0' and '1' are not valid in the scheme.
                    || arr[i].charAt(j) == '0' || arr[i].charAt(j) == '1'
                ) {
                    System.out.print("Invalid Log ");
                    invalid = true;
                    break;
                }

                // -----------------------------------------------------
                // COUNTING LOGIC (only if valid)
                // -----------------------------------------------------
                char curr = arr[i].charAt(j);
                if (isInt(curr)) {
                    // Digits from 2–9 mean "repeat previous character (digit - 1) times"
                    // We subtract '0' (ascii : 48) to convert char digit to int value
                    count += (curr - '0') - 1;
                } else {
                    // Each letter contributes +1 to decompressed length
                    count++;
                }
            }

            // Skip printing decompressed length for invalid logs
            if (invalid) continue;

            System.out.print(count + " ");
        }

        // Close scanner
        sc.close();
    }
}
