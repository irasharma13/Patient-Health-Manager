import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;





public class PatientInfoAggregator{

        public static void main(String[] args){
            HashMap<Integer, String> patientInfo = new HashMap<Integer, String>();
            HashMap<Integer, List<Integer>> exams = new HashMap<Integer, List<Integer>>();
        // class PatientInfo{
        //     int id;
        //     String name;
        //     int examId;
           
            

        //     public PatientInfo(int id, String name){
        //         this.id = id;
        //         this.name = name;
        //     }
        //     public void Exams(int id, int examId){
        //         this.id = id;
        //         this.examId = examId;
        //     }
        //     public int getId(){
        //         return this.id;
        //     }
        //     public String getName(){
        //         return this.name;
        //     }

            
        // }
        try{
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            while(scanner.hasNextLine()){
                

                String info = scanner.nextLine();

                String[] words = info.split(" ");
                //System.out.println(info);
                if(words[0].equals("ADD")){
                    if(words[1].equals("PATIENT")){
                        int id = Integer.parseInt(words[2]);
                        String name = "";
                        for(int i = 3; i<words.length; i++){
                            name += words[i] + " ";
                        }
                        //System.out.println("Id:"+id+"::Name:"+name);
                        if(!patientInfo.containsKey(id)){
                            patientInfo.put(id, name);
                        }
                    }
                    else if(words[1].equals("EXAM")){
                        int id = Integer.parseInt(words[2]);
                        int examId = Integer.parseInt(words[3]);
                        if(patientInfo.containsKey(id)){
                            if(exams.containsKey(id)){
                                exams.get(id).add(examId);
                            }
                            else{
                                List<Integer> examList = new ArrayList<Integer>();
                                examList.add(examId);
                                exams.put(id, examList);
                            }
                        }
                        else{
                            System.out.println("Patient "+id+" doesn't exist");
                        }
                    }

                }


                if(words[0].equals("DEL")){
                    if(words[1].equals("PATIENT")){
                        int id = Integer.parseInt(words[2]);
                        if(patientInfo.containsKey(id)){
                            patientInfo.remove(id);
                            exams.remove(id);
                        }
                        else{
                            System.out.println("Patient "+id+" doesn't exist");
                        }
                    }
                    else if(words[1].equals("EXAM")){
                        int id = Integer.parseInt(words[2]);
                        int examId = Integer.parseInt(words[3]);
                        if(exams.containsKey(id)){
                            List<Integer> examList = exams.get(id);
                            if(examList.contains(examId)){
                                examList.remove(examList.indexOf(examId));
                            }
                            else{
                                System.out.println("Exam "+examId+" for patient "+id+" doesn't exist");
                            }
                        }
                        else{
                            System.out.println("Patient "+id+" doesn't exist");
                        }
                    }
                    
                }


            }
        scanner.close();

        File outputFile = new File("output.txt");
        FileWriter writer = new FileWriter(outputFile);
        
        for(Integer id: patientInfo.keySet()){
            String name = patientInfo.get(id);
            List<Integer> examList = exams.get(id);
            int examCount = 0;
            if(examList == null){
                examCount = 0;
            }
            else{
                examCount = examList.size();
            }

            String output = "Name: "+ name +", Id: "+ id +", Exam Count: " + examCount + "\n";
            writer.write(output);
        }

        writer.close();

        } 
        catch (IOException e){
            System.out.println("IOException");
        }

    }
}
