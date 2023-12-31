// Напишите функцию printPrimeNums, которая выведет на экран все простые числа в
// промежутке от 1 до 1000, каждое на новой строке.
// Напишите свой код в методе printPrimeNums класса Answer.
package homeworks.hw1;

import java.util.Arrays;
import java.util.List;

public class task2 {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(printPrimeNums(100).toArray()));
        printPrimeNums();
    }

    public static void printPrimeNums() {
        boolean[] isPrime = new boolean[100];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < 100; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < 100; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 1; i < 100; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
