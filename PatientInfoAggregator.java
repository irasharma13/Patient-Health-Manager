import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
import java.io.File;




public class PatientInfoAggregator{
    public static void main(String[] args){
        class PatientInfo{
            int id;
            String name;
            int examId;
            HashMap<Integer, Integer> PatientInfo = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> Exams = new HashMap<Integer, Integer>();
            

            public PatientInfo(int id, String name){
                this.id = id;
                this.name = name;
            }
            public void Exams(int id, int examId){
                this.id = id;
                this.examId = examId;
            }
            public int getId(){
                return this.id;
            }
            public String getName(){
                return this.name;
            }

            
        }

        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);
        
        while(scanner.hasNextLine()){
            String info = scanner.nextLine();

            String[] words = info.split("");

            if(words[0].equals("ADD")){
                if(words[1].equals("PATIENT")){
                    int id = Integer.parseInt(words[2]);
                    String name = "";
                    for(int i = 3; i<words.length; i++){
                        name += words[3];
                    }
                    System.out.println("Id:"+id+"::Name:"+name);
                }
            }

        }
    }
}
