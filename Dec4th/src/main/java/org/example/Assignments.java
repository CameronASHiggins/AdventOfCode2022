package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Assignments {

    public void start(){

        List<String> firstElf = new ArrayList<>();
        List<String> secondElf = new ArrayList<>();

        try {
            File myObj = new File("src/main/resources/assignments.txt");

            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] splitLine = line.split(",");
                firstElf.add(splitLine[0]);
                secondElf.add(splitLine[1]);
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int firstElfInt1;
        int firstElfInt2;
        int secondElfInt1;
        int secondElfInt2;
        int total = 0;

        for (int i = 0; i < firstElf.size(); i++) {
            firstElfInt1 = Integer.parseInt(firstElf.get(i).split("-")[0]);
            firstElfInt2 = Integer.parseInt(firstElf.get(i).split("-")[1]);
            secondElfInt1 = Integer.parseInt(secondElf.get(i).split("-")[0]);
            secondElfInt2 = Integer.parseInt(secondElf.get(i).split("-")[1]);
            List<Integer> ass1 = new ArrayList<>();
            List<Integer> ass2 = new ArrayList<>();
            boolean doesOverlap = false;

            for (int j = firstElfInt1; j <= firstElfInt2; j++) {
                ass1.add(j);
            }
            for (int j = secondElfInt1; j <= secondElfInt2; j++) {
                ass2.add(j);
            }
//this is for the second part
            for (int x: ass1) {
                if (ass2.contains(x)) {
                    doesOverlap = true;
                    break;
                }
            }
            if (doesOverlap){
                total ++;
            }
// this is for the first part
//            if(new HashSet<>(ass1).containsAll(ass2) || new HashSet<>(ass2).containsAll(ass1)){
//                total += 1;
//            }
        }

        System.out.println(total);
    }
}
