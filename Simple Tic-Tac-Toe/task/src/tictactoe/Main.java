package tictactoe;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Empty Game Grid
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print("  ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        //Scanner
        Scanner scanner = new Scanner(System.in);

        //Game Setup
        char[][] twoDimArray = new char[3][3];

        int[] cordinates = new int[2];

        //O or X turn
        boolean Xturn = true;
        boolean Oturn = false;

        boolean EndGame = true;
        
        //Put Elements in Game Grid
        while (scanner.hasNext() && EndGame) {
            cordinates[0] = scanner.nextInt();
            cordinates[1] = scanner.nextInt();


            if (cordinates[0] > 3 || cordinates[0] < 1 || cordinates[1] > 3 || cordinates[1] < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (twoDimArray[cordinates[0] - 1][cordinates[1] - 1] == 'X' || twoDimArray[cordinates[0] - 1][cordinates[1] - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else if (Xturn) {
                twoDimArray[cordinates[0] - 1][cordinates[1] - 1] = 'X';
                Xturn = false;
                Oturn = true;
            } else if (Oturn) {
                twoDimArray[cordinates[0] - 1][cordinates[1] - 1] = 'O';
                Xturn = true;
                Oturn = false;
            }


            //Actual Grid printing
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {

                    if (twoDimArray[i][j] == 0) {
                        twoDimArray[i][j] = ' ';
                    }
                    System.out.print(twoDimArray[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");


            //Game Result Checking
            int[] XXcounter = new int[3];
            int[] XOcounter = new int[3];
            int[] YXcounter = new int[3];
            int[] YOcounter = new int[3];


            boolean XisThree = false;
            boolean OisThree = false;

            boolean emptySpace = false;

            int XcounterGeneral = 0;
            int OcounterGeneral = 0;


            //XO looking
            for (int i = 0; i < 3; i++) {
                int numberOFx = 0;
                int numberOOx = 0;
                for (int j = 0; j < 3; j++) {
                    if (twoDimArray[i][j] == 'X') {
                        numberOFx++;
                        XXcounter[i] = numberOFx;
                        XcounterGeneral++;

                    } else if (twoDimArray[i][j] == 'O') {
                        numberOOx++;
                        XOcounter[i] = numberOOx;
                        OcounterGeneral++;

                    } else if (twoDimArray[i][j] == '_') {
                        emptySpace = true;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                int numberOFx = 0;
                int numberOOx = 0;
                for (int j = 0; j < 3; j++) {
                    if (twoDimArray[j][i] == 'X') {
                        numberOFx++;
                        YXcounter[i] = numberOFx;


                    } else if (twoDimArray[j][i] == 'O') {
                        numberOOx++;
                        YOcounter[i] = numberOOx;


                    }
                }

            }
            for (int i = 0; i < 3; i++) {
                if (XXcounter[i] == 3 || YXcounter[i] == 3) {
                    XisThree = true;
                } else if (XOcounter[i] == 3 || YOcounter[i] == 3) {
                    OisThree = true;
                }
            }

            //Result Printing
            for (int i = 0; i < 3; i++) {
                if (XisThree && OisThree || XcounterGeneral - OcounterGeneral >= 2 || OcounterGeneral - XcounterGeneral >= 2) {
                    System.out.println("Impossible");
                    break;
                } else if (YXcounter[i] == 3 || XXcounter[i] == 3) {
                    System.out.println("X wins");
                    EndGame = false;
                    break;
                } else if ((twoDimArray[0][0] == 'X' && twoDimArray[1][1] == 'X' && twoDimArray[2][2] == 'X') || (twoDimArray[0][2] == 'X' && twoDimArray[1][1] == 'X' && twoDimArray[2][0] == 'X')) {
                    System.out.println("X wins");
                    EndGame = false;
                    break;
                } else if (YOcounter[i] == 3 || XOcounter[i] == 3) {
                    System.out.println("O wins");
                    EndGame = false;
                    break;
                } else if (emptySpace) {
                    System.out.println("Game not finished");
                    break;
                } else if (XcounterGeneral + OcounterGeneral == 9) {
                    System.out.println("Draw");
                    EndGame = false;
                    break;
                }
            }

        }
    }

}