
import java.io.*;
import java.util.*;

class CandidateCode  
{ 
    public static void main(String[] args)  
    { 
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<Integer>();
        while (scanner.hasNextInt()){
            arr.add(scanner.nextInt());
        }
          
        int[] numbers = arr.stream().mapToInt(i->i).toArray();

        int temp = 0;
        for (int i=0; i < numbers.length; ++i) {
            for (int j=1; j < (numbers.length - i); ++j) {
                if (numbers[j-1] > numbers[j]) {
                    temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        int numDup = 0, dupCount = 0;
        int previous = -1;
        for (int i=0; i < numbers.length; ++i) {
            if (numbers[i] == previous) {
                ++numDup;
                if (numDup == 1) {
                    ++dupCount;
                }
            }
            else {
                previous = numbers[i];
                numDup = 0;
            }
        }
        System.out.println(dupCount);
    } 
} 