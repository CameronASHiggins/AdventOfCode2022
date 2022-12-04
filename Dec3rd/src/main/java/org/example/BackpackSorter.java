package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BackpackSorter {

    public void start(){
        List<String> eachBackpack = new ArrayList<String>();
//        List<String> comp1s = new ArrayList<String>();
//        List<String> comp2s = new ArrayList<String>();
        HashMap priorities = HashMap.newHashMap(52);

        priorities.put('a',1);priorities.put('b',2);priorities.put('c',3);priorities.put('d',4);priorities.put('e',5);priorities.put('f',6);
        priorities.put('g',7);priorities.put('h',8);priorities.put('i',9);priorities.put('j',10);priorities.put('k',11);priorities.put('l',12);
        priorities.put('m',13);priorities.put('n',14);priorities.put('o',15);priorities.put('p',16);priorities.put('q',17);priorities.put('r',18);
        priorities.put('s',19);priorities.put('t',20);priorities.put('u',21);priorities.put('v',22);priorities.put('w',23);priorities.put('x',24);
        priorities.put('y',25);priorities.put('z',26);
        priorities.put('A',27);priorities.put('B',28);priorities.put('C',29);priorities.put('D',30);priorities.put('E',31);priorities.put('F',32);
        priorities.put('G',33);priorities.put('H',34);priorities.put('I',35);priorities.put('J',36);priorities.put('K',37);priorities.put('L',38);
        priorities.put('M',39);priorities.put('N',40);priorities.put('O',41);priorities.put('P',42);priorities.put('Q',43);priorities.put('R',44);
        priorities.put('S',45);priorities.put('T',46);priorities.put('U',47);priorities.put('V',48);priorities.put('W',49);priorities.put('X',50);
        priorities.put('Y',51);priorities.put('Z',52);

        try {
            File myObj = new File("src/main/resources/Backpack.txt");

            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                eachBackpack.add(myReader.nextLine());
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        for (String bpcontent : eachBackpack) {
//            int halfway = bpcontent.length()/2;
//            comp1s.add(bpcontent.substring(0,halfway));
//            comp2s.add(bpcontent.substring(halfway));
//        }


        int total = 0;

        List<String> Elf1 = new ArrayList<>();
        List<String> Elf2 = new ArrayList<>();
        List<String> Elf3 = new ArrayList<>();

        for (int i = 0; i < eachBackpack.size(); i++) {
            if(i%3 == 0){
                Elf1.add(eachBackpack.get(i));
            } else if(i%3 == 1){
                Elf2.add(eachBackpack.get(i));
            } else if(i%3 == 2){
                Elf3.add(eachBackpack.get(i));
            } else{
                System.out.println("Something seriously wrong has happened");
            }
        }

        for(int i = 0; i < eachBackpack.size()/3; i++){
            char[] elf1Char = Elf1.get(i).toCharArray();
            char[] elf2Char = Elf2.get(i).toCharArray();
            char[] elf3Char = Elf3.get(i).toCharArray();

            boolean isCommon = false;
            for (char c : elf1Char) {
                for (char c2 : elf2Char){
                    if(c == c2){
                        for (char c3:elf3Char) {
                            if(c2 == c3){
                                if(isCommon == false){
                                    isCommon = true;
                                    total += (int) priorities.get(c);
                                }
                            }
                        }
                    }
                }

            }
        }

        System.out.println(total);

        }
    }
