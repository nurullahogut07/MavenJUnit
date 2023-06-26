package Deneme;

import org.junit.Assert;

import java.util.Scanner;
public class Kata {
public static int sum(int[] numbers) {
        int toplam = 0;
        for (int num : numbers) {
        toplam += num;
        }
        return toplam;
        }
        public void BasicTests() {
                int[] array = {6, 2, 1, 8, 10};
                int expectedSum = 27;

                int actualSum = Kata.sum(array);

               Assert.assertEquals(expectedSum, actualSum);
        }
}






