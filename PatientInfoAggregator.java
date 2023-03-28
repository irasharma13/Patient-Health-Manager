import java.util.Scanner;
import java.util.HashMap;
import java.io.*;


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

        File inputFile = new File(pathname:"input.txt");
        Scanner scanner = new Scanner(inputFile);
    }
}
