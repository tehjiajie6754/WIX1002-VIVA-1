
package viva1;
import java.util.Scanner;
/**
 *
 * @author Hong Han
 */
public class V1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        do{
            System.out.print("Enter number of words to test: ");
            T = sc.nextInt();
        }while (T<=1 || T>=100);
        
        int i = 0;
        String word;
        while (i<T){
            boolean status = true;
            do{
                System.out.print("Enter word in lowercase: ");
                word = sc.next();
            }while(!word.equals(word.toLowerCase()) || (word.length()<=1 || word.length()>=50));
            
            char[]vowels = {'a','e','i','o','u'};
            for (int j =0; j<vowels.length;j++){
                if(word.charAt(word.length()-1)== vowels[j]){
                    System.out.println("Chaos");
                    status = false;
                    break;
                }
            }

            if(status){
                int index1 = -2;
                int index2 = -2;
                for(int k=0; k<word.length();k++){
                    for (int j = 0;j<vowels.length;j++){
                        if(word.charAt(k)==vowels[j]){
                            index1 = index2;
                            index2 = k;
                            break;
                        }
                    }
                    
                    if (index2 -1 == index1){
                        System.out.println("Chaos");
                        status = false;
                        break;
                    }
                } 
                if (status){
                    System.out.println("Harmony");
                }
            }
            i++;
        }
    }
}
