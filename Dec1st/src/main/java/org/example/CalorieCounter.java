package org.example;

import java.io.*;
import java.util.*;

public class CalorieCounter {
    public void countCalories() {

        List<String> eachLine = new ArrayList();
        List<Integer> eachElf = new ArrayList<>();
        //eachLine.add("4601");
        try {
            File myObj = new File("src/main/resources/Calories.txt");

            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
               eachLine.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int total=0;
        for(int i = 0; i<eachLine.size();i++){
            if (eachLine.get(i) != ""){
                total += Integer.parseInt(eachLine.get(i));
            }else if(eachLine.get(i) == ""){
                eachElf.add(total);
                total = 0;
            }
        }

        HashMap keyedElves = new HashMap();
        int counter = 1;
        for(int i : eachElf){
            keyedElves.put(i, counter);
            counter++;
        }

        Collections.sort(eachElf);
        total = 0;
        total += eachElf.get(eachElf.size()-1);
        total += eachElf.get(eachElf.size()-2);
        total += eachElf.get(eachElf.size()-3);
        System.out.println(total);

    }
}
