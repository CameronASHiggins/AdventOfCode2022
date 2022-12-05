package org.example;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class rearanger {

    static Stack stack1 = new Stack<>();
    static Stack stack2 = new Stack<>();
    static Stack stack3 = new Stack<>();
    static Stack stack4 = new Stack<>();
    static Stack stack5 = new Stack<>();
    static Stack stack6 = new Stack<>();
    static Stack stack7 = new Stack<>();

    static Stack stack8 = new Stack<>();
    static Stack stack9 = new Stack<>();

    static List<String> procedures = new ArrayList<>();


    public static String start(){
        try {
            File myCrates = new File("src/main/resources/stacks");
            Scanner crateReader = new Scanner(myCrates);
            while(crateReader.hasNextLine()){
                String line = crateReader.nextLine();
                if (line.charAt(1) != ' '){
                    stack1.add(0,line.charAt(1));
                }
                if (line.charAt(5) != ' '){
                    stack2.add(0,line.charAt(5));
                }
                if (line.charAt(9) != ' '){
                    stack3.add(0,line.charAt(9));
                }
                if (line.charAt(13) != ' '){
                    stack4.add(0,line.charAt(13));
                }
                if (line.charAt(17) != ' '){
                    stack5.add(0,line.charAt(17));
                }
                if (line.charAt(21) != ' '){
                    stack6.add(0,line.charAt(21));
                }
                if (line.charAt(25) != ' '){
                    stack7.add(0,line.charAt(25));
                }
                if (line.charAt(29) != ' '){
                    stack8.add(0,line.charAt(29));
                }
                if (line.charAt(33) != ' '){
                    stack9.add(0,line.charAt(33));
                }
            }
            crateReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myProcedures = new File("src/main/resources/procedure.txt");

            Scanner myReader = new Scanner(myProcedures);
            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                procedures.add(line);
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(("" + stack1.peek()+stack2.peek()+stack3.peek()+stack4.peek()+stack5.peek()+stack6.peek()+stack7.peek()+stack8.peek()+stack9.peek()));
//        System.out.println(procedures);

        for (String line: procedures) {
            String[] splitLine = line.split(" ");
            int moves = Integer.valueOf(splitLine[1]);
            int fromStackNum = Integer.valueOf(splitLine[3]);
            int toStackNum = Integer.valueOf(splitLine[5]);
            Stack fromStack = null;
            Stack toStack = null;
            switch (fromStackNum){
                case 1:
                    fromStack = stack1;
                    break;
                case 2:
                    fromStack = stack2;
                    break;
                case 3:
                    fromStack = stack3;
                    break;
                case 4:
                    fromStack = stack4;
                    break;
                case 5:
                    fromStack = stack5;
                    break;
                case 6:
                    fromStack = stack6;
                    break;
                case 7:
                    fromStack = stack7;
                    break;
                case 8:
                    fromStack = stack8;
                    break;
                case 9:
                    fromStack = stack9;
                    break;
            }
            switch (toStackNum){
                case 1:
                    toStack = stack1;
                    break;
                case 2:
                    toStack = stack2;
                    break;
                case 3:
                    toStack = stack3;
                    break;
                case 4:
                    toStack = stack4;
                    break;
                case 5:
                    toStack = stack5;
                    break;
                case 6:
                    toStack = stack6;
                    break;
                case 7:
                    toStack = stack7;
                    break;
                case 8:
                    toStack = stack8;
                    break;
                case 9:
                    toStack = stack9;
                    break;
            }

            move(moves,fromStack,toStack);
        }
        if(stack1.isEmpty()){stack1.push(" ");}
        if(stack2.isEmpty()){stack2.push(" ");}
        if(stack3.isEmpty()){stack3.push(" ");}
        if(stack4.isEmpty()){stack4.push(" ");}
        if(stack5.isEmpty()){stack5.push(" ");}
        if(stack6.isEmpty()){stack6.push(" ");}
        if(stack7.isEmpty()){stack7.push(" ");}
        if(stack8.isEmpty()){stack8.push(" ");}
        if(stack9.isEmpty()){stack9.push(" ");}

        return ""+ stack1.peek()+stack2.peek()+stack3.peek()+stack4.peek()+stack5.peek()+stack6.peek()+stack7.peek()+stack8.peek()+stack9.peek();
    }

    public static Stack move(int moveNum, Stack fromStack, Stack toStack) {
        char crate;
        String crates="";

        if (moveNum > 1){
            for (int i = 0; i < moveNum; i++) {
                crates+= fromStack.peek() + ",";
                fromStack.pop();
            }
            List<Character> crateList = new ArrayList<>();
            for(String s : crates.split(",")){
                crateList.add(s.charAt(0));
            }
            Collections.reverse(crateList);
            for (char c: crateList){
                toStack.push(c);
            }
        }

        else{

        for (int i = 0; i < moveNum; i++) {

            if (!(fromStack.isEmpty())) {
                crate = (char) fromStack.peek();
                System.out.println(fromStack);
                System.out.println(toStack);

                fromStack.pop();
                toStack.push(crate);
                System.out.println(fromStack);
                System.out.println(toStack);

            }
        }

        }return toStack;
    }
}
