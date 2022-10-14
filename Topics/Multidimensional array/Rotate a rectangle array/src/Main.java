import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int l = scanner.nextInt();

        int[][] twoDimArray = new int[w][l];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < l; j++) {
                twoDimArray[i][j] = scanner.nextInt();
            }
        }

        int[][] twoDimArraySecond = new int[l][w];
        int w2 = w - 1;
        for (int i = 0; i <= l - 1; i++) {
            for (int j = 0; j <= w - 1; j++) {
                twoDimArraySecond[i][w2 - j] = twoDimArray[j][i];
            }
        }

        for (int i = 0; i < twoDimArraySecond.length; i++) {
            for (int j = 0; j < twoDimArraySecond[i].length; j++) {
                System.out.print(twoDimArraySecond[i][j] + " ");
            }
            System.out.println();
        }
    }


}