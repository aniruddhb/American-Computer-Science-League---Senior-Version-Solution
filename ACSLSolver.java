import java.util.Scanner;

public class ACSLSenior{
    static Scanner in = new Scanner(System.in);
    static boolean skipA, skipB, skipC = false;
    static int posA, posB, posC = 0;
    static String input;
    static int valueOfRoll = 0;
    static int turn = 0;
    static int i = 0;
    static int count = 1;

    public ACSLSenior(){
    }
    
    static void lab(){
        while (Integer.parseInt(input.substring(i, i+1)) != 0){
            if (turn == 3){
                turn = 0;
            }
            if (turn == 0){
                if (input.charAt(i) == '6'){
                    skipA = true;
                } else if (skipA == true){
                    skipA = false;
                    i--;
                } else {
                    switchA(input.charAt(i));
                    posA += valueOfRoll;
                    if (posA < 0){
                        posA = 0;
                    }
                    if (posA == posB){
                        posB = 0;
                    }
                    if (posA == posC){
                        posC = 0;
                    }
                    if (posA >= 30){
                        break;
                    }
                }
            }
            if (turn == 1){
                if (input.charAt(i) == '6'){
                    skipB = true;
                } else if (skipB == true){
                    skipB = false;
                    i--;
                } else {
                    switchB(input.charAt(i));
                    posB += valueOfRoll;
                    if (posB < 0){
                        posB = 0;
                    }
                    if (posB == posA){
                        posA = 0;
                    }
                    if (posB == posC){
                        posC = 0;
                    }
                    if (posB >= 30){
                        break;
                    }
                }
            }
            if (turn == 2){
                if (input.charAt(i) == '6'){
                    skipC = true;
                } else if (skipC == true){
                    skipC = false;
                    i--;
                } else {
                    switchC(input.charAt(i));
                    posC += valueOfRoll;
                    if (posC < 0){
                        posC = 0;
                    }
                    if (posC == posA){
                        posA = 0;
                    }
                    if (posC == posB){
                        posB = 0;
                    }
                    if (posC >= 30){
                        break;
                    }
                }
            }
            i++;
            turn++;
        }
    }

    static void printInfo(){
        System.out.print("Output #" + count + ":  ");
        if (posA == 0){
            System.out.print("A-START, ");
        } else if (posA > 29){
            System.out.print("A-END, ");
        } else {
            System.out.print("A-" + posA + ", ");
        }
        if (posB == 0){
            System.out.print("B-START, ");
        } else if (posB > 29){
            System.out.print("B-END, ");
        } else {
            System.out.print("B-" + posB + ", ");
        }
        if (posC == 0){
            System.out.print("C-START");
        } else if (posC > 29){
            System.out.print("C-END");
        } else {
            System.out.print("C-" + posC);
        }
    }
    
    static void switchA(char ch){
        switch (ch){
            case '1': valueOfRoll = 1; break;
            case '2': valueOfRoll = 2; break;
            case '3': valueOfRoll = 3; break;
            case '4': valueOfRoll = -4; break;
            case '5': valueOfRoll = 5; break;
            case '7': valueOfRoll = 7; break;
            case '8': valueOfRoll = 8; break;
        }
    }
    
    static void switchB(char ch){
        switch (ch){
            case '1': valueOfRoll = 1; break;
            case '2': valueOfRoll = 2; break;
            case '3': valueOfRoll = 3; break;
            case '4': valueOfRoll = -4; break;
            case '5': valueOfRoll = 5; break;
            case '7': valueOfRoll = 7; break;
            case '8': valueOfRoll = 8; break;
        }
    }
    
    static void switchC(char ch){
        switch (ch){
            case '1': valueOfRoll = 1; break;
            case '2': valueOfRoll = 2; break;
            case '3': valueOfRoll = 3; break;
            case '4': valueOfRoll = -4; break;
            case '5': valueOfRoll = 5; break;
            case '7': valueOfRoll = 7; break;
            case '8': valueOfRoll = 8; break;
        }
    }
    
    static void play(){
        for (int z = 0; z < 5; z++){
            System.out.print("Line #" + count + ":  ");
            input = (in.nextLine()).replaceAll("[,]", "");
            lab();
            printInfo();
            resetVariables();
            count++;
            System.out.println("\n");
        }
    }
    
    static void resetVariables(){
        skipA = false;
        skipB = false;
        skipC = false;
        posA = 0;
        posB = 0;
        posC = 0;
        input = "";
        valueOfRoll = 0;
        turn = 0;
        i = 0;
    }
    
    public static void main(String[] args){
        for (int v = 0; v < 100; v++){
            play();
            System.out.print("Would you like to play again? <Y/N> ");
            if ((in.nextLine()).toLowerCase().equals("y")){
                resetVariables();
            } else {
                System.out.print("\n" + "Goodbye Dave.");
                System.exit(0);
                break;
            }
        }
    }
}
