package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainCappaMatrix {
    //For before 
    static File mainCSVBefore = new File("output_before.csv");
    static File mainCSVAfter = new File("output_after.csv");

    static HashMap<String, TreeMap<Integer,String>> finaLHM = new HashMap<>();

    public static void main(String[] args) throws IOException {

        // Do not run Before and after together. WILL NOT WORK.

        //For round 1 - before
        //generateMatrixFile(true);

        //For round 2 - after
       //generateMatrixFile(false);

        // To generate Files for python kappa runner. After this, go to python script.

        //For round 1 - before
        //generateFilesForKappa(true);

        generateFilesForKappa(false);
    }

    private static void generateFilesForKappa(boolean before) throws IOException {

        File folderPath ;
        File inputFile;

        if(before){
            folderPath = new File("C:\\Users\\author\\Documents\\thesis\\plugin\\code\\TagcoderDataTransformer\\FilesForKappaPython\\Before\\");
            inputFile = new File("matrix-output-before.csv");
        }
        else {
            folderPath = new File("C:\\Users\\author\\Documents\\thesis\\plugin\\code\\TagcoderDataTransformer\\FilesForKappaPython\\After\\");
            inputFile = new File("matrix-output-after.csv");
        }

        List<String> lines = Files.readAllLines(inputFile.toPath());

        for(int i = 1; i<=14;i++) {
            for(int j = i+1; j<=14;j++) {
                boolean header = true;
                FileWriter fw = new FileWriter(folderPath+"\\"+String.valueOf(i)+String.valueOf(j)+".csv");
                String firstLine = "[";
                String secondLine = "[";
                for (String line : lines) {
                    if(header){
                        header = false;
                        continue;
                    }
                    String[] lineSt = line.split(",");
                    if(lineSt[i].equals("-") || lineSt[j].equals("-"))
                        continue;
                    firstLine+=lineSt[i]+",";
                    secondLine+=lineSt[j]+",";

                    //fw.write(lineSt[0]+","+lineSt[i]+","+lineSt[j]+"\n");

                }
                if(firstLine.length() >3) {
                    firstLine.substring(0, firstLine.length() - 2);
                    secondLine.substring(0, secondLine.length() - 2);
                }
                firstLine+="]";
                secondLine+="]";
                fw.write(firstLine+'\n');
                fw.write(secondLine);
                fw.flush();
                fw.close();
            }
        }
    }

    private static void generateMatrixFile(boolean before) throws IOException {

        List<String> lines = before? Files.readAllLines(mainCSVBefore.toPath()):Files.readAllLines(mainCSVAfter.toPath());
        boolean header = true;
        for(String line: lines){
            if(header){
                header = false;
                continue;
            }
            System.out.println(line);
            String[] lineSplits = line.split(",");

            if(finaLHM.containsKey(lineSplits[0])){
                TreeMap<Integer, String> userMap = finaLHM.get(lineSplits[0]);
                userMap.put(Integer.parseInt(lineSplits[1]),lineSplits[4].equalsIgnoreCase("true")?"T":"F");
                finaLHM.put(lineSplits[0],userMap);
            }
            else{
                TreeMap<Integer, String> userMap = new TreeMap<>();
                userMap.put(Integer.parseInt(lineSplits[1]),lineSplits[4].equalsIgnoreCase("true")?"T":"F");
                finaLHM.put(lineSplits[0],userMap);

            }
        }

        System.out.println("----------------------------------------------------------------------");

        FileWriter fw = before?new FileWriter("matrix-output-before.csv"):new FileWriter("matrix-output-after.csv");
        fw.write("fileName,u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14\n");
        for (Map.Entry<String, TreeMap<Integer, String>> stringTreeMapEntry : finaLHM.entrySet()) {
            try {
                fw.write(stringTreeMapEntry.getKey() + ",");
                TreeMap<Integer, String> userMapp = stringTreeMapEntry.getValue();
                for (int i = 1; i<=13;i++){

                    if (userMapp.containsKey(i))
                            fw.write(userMapp.get(i)+",");
                    else
                        fw.write("-,");
                }
                if (userMapp.containsKey(14))
                    fw.write(userMapp.get(14));

                else
                    fw.write("-");

                fw.write("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        fw.flush();
        fw.close();
    }

}
