package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * A = Rock
 * B = Paper
 * C = Scissors
 * Y = Paper
 * X = Rock
 * Z = Scissors
 * */

public class CalcScore {

    public void start(){
        List<String> eachLine = new ArrayList<String>();
        try {
            File myObj = new File("src/main/resources/strats.txt");

            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                eachLine.add(myReader.nextLine());
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(getScore(eachLine));
    }

    public int getScore(List<String> guide){
        int total = 0;
        for(String s : guide){
            String[] chars = s.split(" ");
            String opp = chars[0];
            String you = chars[1];
            total += calcScore2(opp,you);
        }
        return total;
    }

    private int calcScore(String opp, String you) {
        int score = 0;
        int rock = 1;
        int paper = 2;
        int scicors = 3;
        int win = 6;
        int draw = 3;
        int loss = 0;
        System.out.println(opp);
        if (opp.equals("A") && you.equals("X")){ //Rock against Rock Draw
            score = rock + draw;
        }
        else if (opp.equals("A") && you.equals("Y")){
            score = paper + win;
        }
        else if (opp.equals("A") && you.equals("Z")){
            score = scicors + loss;
        }
        else if (opp.equals("B") && you.equals("X")){
            score = rock + loss;
        }
        else if (opp.equals("B") && you.equals("Y")){
            score = paper + draw;
        }
        else if (opp.equals("B")&& you.equals("Z")){
            score = scicors + win;
        }
        else if (opp.equals("C")&& you.equals("X")){
            score = rock + win;
        }
        else if (opp.equals("C")&& you.equals("Y")){
            score = paper + loss;
        }
        else if (opp.equals("C")&& you.equals("Z")){
            score = scicors + draw;
        }
        return score;
        }

    /*
     * A = Rock = 1
     * B = Paper = 2
     * C = Scissors = 3
     * X = Lose = 0
     * Y = Draw = 3
     * Z = Win = 6
     * */

        public int calcScore2(String opp, String you){
        int score = 0;
            int rock = 1;
            int paper = 2;
            int scicors = 3;
            int win = 6;
            int draw = 3;
            int loss = 0;
            System.out.println(opp);
            if (opp.equals("A") && you.equals("X")){ //Rock against Rock Draw
                score = scicors + loss;
            }
            else if (opp.equals("A") && you.equals("Y")){
                score = rock + draw;
            }
            else if (opp.equals("A") && you.equals("Z")){
                score = paper + win;
            }
            else if (opp.equals("B") && you.equals("X")){
                score = rock + loss;
            }
            else if (opp.equals("B") && you.equals("Y")){
                score = paper + draw;
            }
            else if (opp.equals("B")&& you.equals("Z")){
                score = scicors + win;
            }
            else if (opp.equals("C")&& you.equals("X")){
                score = paper + loss;
            }
            else if (opp.equals("C")&& you.equals("Y")){
                score = scicors + draw;
            }
            else if (opp.equals("C")&& you.equals("Z")){
                score = rock + win;
            }
            return score;
        }
}

