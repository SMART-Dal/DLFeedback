package org.example;

import com.google.common.collect.Lists;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    private static int NB = 0;

    private static int NA = 0;

    private static int CMATT = 0;
    private static int CMAFT = 0;
    private static int CMATF = 0;
    private static int CMAFF = 0;
    private static int CMBTT = 0;
    private static int CMBTF = 0;
    private static int CMBFT = 0;
    private static int CMBFF = 0;
    private static int LMATT = 0;
    private static int LMATF = 0;
    private static int LMAFT = 0;
    private static int LMAFF = 0;
    private static int LMBTT = 0;
    private static int LMBFT = 0;
    private static int LMBTF = 0;
    private static int LMBFF = 0;
    private static int MUATT = 0;
    private static int MUATF = 11;
    private static int MUAFT = 0;
    private static int MUAFF = 0;
    private static int MUBTT = 0;
    private static int MUBTF = 14;
    private static int MUBFT = 0;
    private static int MUBFF = 0;
    private static HashMap<String, List<EntryModel>> entries = new HashMap<>();

    public static void main(String[] args) throws IOException {

        logger.info("Starting parse");
        File folder = new File("C:\\Users\\Himesh\\Downloads\\results-experiment\\results");

        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Himesh\\Downloads\\results-experiment\\results"), 1)) {
            List<String> result = walk
                    .filter(p -> !Files.isDirectory(p))   // not a directory
                    .map(p -> p.toString().toLowerCase()) // convert path to string
                    .filter(f -> f.endsWith("csv")).toList();        // collect all matched to a List

            System.out.println("List size:" + result.size());
            result.forEach(file -> {
                try {

                    //Splitting files into before and after i.e Round 1 and Round 2
                    //splitFile(file);


                    //RQ - 3: generating same files annotated by at least 2 users.
                    // After getting before and after, run cappa matrix class.

                    //for 'before' files i.e round 1
                    //handleFile(file, true);

                    //for 'after' files i.e round 2
                    handleFile(file, false);

                    // compileAfterFiles(file);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            // printFTMetrics();
            //for 'before' files i.e round 1
            //printMetrics(true);
            //for 'after' files i.e round 2
            printMetrics(false);

        }
    }

    private static void printFTMetrics() {
        CMBTT += NB / 3;
        CMATT += NA / 3;
        LMBTT += NB / 3;
        LMATT += NA / 3;
        MUBTT += NB / 3;
        MUATT += NA / 3;

        float CMBPr = ((float) CMBTT / ((float) CMBTT + (float) CMBTF));
        float CMBRe = ((float) CMBTT / ((float) CMBTT + (float) CMBFT));

        float CMAPr = ((float) CMATT / ((float) CMATT + (float) CMATF));
        float CMARe = ((float) CMATT / ((float) CMATT + (float) CMAFT));

        float f1B = 2 * (CMBPr * CMBRe) / (CMBPr + CMBPr);
        float f1A = 2 * (CMAPr * CMARe) / (CMAPr + CMAPr);

        System.out.println("------------------------------------");
        System.out.println("Complex Method");
        System.out.println("----Before---------------");
        System.out.println("TT : " + CMBTT + " Tf : " + CMBTF + " FT : " + CMBFT + " FF : " + CMBFF);
        System.out.println("Precision : " + ((float) CMBTT / ((float) CMBTT + (float) CMBTF)));
        System.out.println("Recall : " + ((float) CMBTT / ((float) CMBTT + (float) CMBFT)));
        System.out.println("----After---------------");
        System.out.println("TT : " + CMATT + " Tf : " + CMATF + " FT : " + CMAFT + " FF : " + CMAFF);
        System.out.println("Precision : " + ((float) CMATT / ((float) CMATT + (float) CMATF)));
        System.out.println("Recall : " + ((float) CMATT / ((float) CMATT + (float) CMAFT)));
        System.out.println("F1 before: " + f1B);
        System.out.println("F1 after: " + f1A);
        float LMBPr = ((float) LMBTT / ((float) LMBTT + (float) LMBTF));
        float LMBRe = ((float) LMBTT / ((float) LMBTT + (float) LMBFT));

        float LMAPr = ((float) CMATT / ((float) CMATT + (float) CMATF));
        float LMARe = ((float) CMATT / ((float) CMATT + (float) CMAFT));

        float Lf1B = 2 * (LMBPr * LMBRe) / (LMBPr + LMBPr);
        float Lf1A = 2 * (LMAPr * LMARe) / (LMAPr + LMAPr);

        System.out.println("------------------------------------");
        System.out.println("Long Method");
        System.out.println("----Before---------------");
        System.out.println("TT : " + LMBTT + " Tf : " + LMBTF + " FT : " + LMBFT + " FF : " + LMBFF);
        System.out.println("Precision : " + ((float) LMBTT / ((float) LMBTT + (float) LMBTF)));
        System.out.println("Recall : " + ((float) LMBTT / ((float) LMBTT + (float) LMBFT)));
        System.out.println("F1 before: " + Lf1B);
        System.out.println("F1 after: " + Lf1A);

        System.out.println("----After---------------");
        System.out.println("TT : " + LMATT + " Tf : " + LMATF + " FT : " + LMAFT + " FF : " + LMAFF);
        System.out.println("Precision : " + ((float) LMATT / ((float) LMATT + (float) LMATF)));
        System.out.println("Recall : " + ((float) LMATT / ((float) LMATT + (float) LMAFT)));

        System.out.println("------------------------------------");
        System.out.println("Multifaceted");
        System.out.println("----Before---------------");
        System.out.println("TT : " + MUBTT + " Tf : " + MUBTF + " FT : " + MUBFT + " FF : " + MUBFF);
        System.out.println("Precision : " + ((float) MUBTT / ((float) MUBTT + (float) MUBTF)));
        System.out.println("Recall : " + ((float) MUBTT / ((float) MUBTT + (float) MUBFT)));

        System.out.println("----After---------------");
        System.out.println("TT : " + MUATT + " Tf : " + MUATF + " FT : " + MUAFT + " FF : " + MUAFF);
        System.out.println("Precision : " + ((float) MUATT / ((float) MUATT + (float) MUATF)));
        System.out.println("Recall : " + ((float) MUATT / ((float) MUATT + (float) MUAFT)));

        System.out.println("None");
        System.out.println("----Before---------------");
        System.out.println("NB" + NB);
        System.out.println("----After---------------");
        System.out.println("NA" + NA);
    }

    private static void compileAfterFiles(String file) throws IOException {
        if (!file.contains("_"))
            return;
        System.out.println("File name" + file);

        List<String> lines = Files.readAllLines(Paths.get(file));

        for (String line : lines) {
            String[] lineSpl = line.split(",");
            if (lineSpl.length < 4)
                return;
            if (Pattern.compile(".*after").matcher(file).find()) {

                handleTFCase(lineSpl[1], lineSpl[2], lineSpl[3], false);
            } else {
                handleTFCase(lineSpl[1], lineSpl[2], lineSpl[3], true);
            }
        }
    }


    private static void splitFile(String fileStr) throws IOException {

        System.out.println("Working with file: " + fileStr);
        File file = new File(fileStr);
        String fileName = file.getName().substring(0, file.getName().indexOf('.'));
        List<String> lines = Files.readAllLines(file.toPath());
        int mean = lines.size() / 2;
        int count = 0;
        List<List<String>> splitLines = Lists.partition(lines, mean);


        // FileWriter fw = new FileWriter(file.getParent()+"\\"+fileName+"_before.csv");
        Path filePath = Paths.get(file.getParent() + "\\" + fileName + "_before.csv");
        Files.deleteIfExists(filePath);
        Files.createFile(filePath);
        for (String str : splitLines.get(0)) {
            Files.writeString(filePath, str + System.lineSeparator(),
                    StandardOpenOption.APPEND);
        }


        Path filePathSec = Paths.get(file.getParent() + "\\" + fileName + "_after.csv");
        Files.deleteIfExists(filePathSec);
        Files.createFile(filePathSec);
        for (String str : splitLines.get(1)) {
            Files.writeString(filePathSec, str + System.lineSeparator(),
                    StandardOpenOption.APPEND);
        }
    }

    private static void printMetrics(boolean before) throws IOException {
        String[] smells = {"ComplexMethod", "LongMethod", "Multifaceted"};
        File outputFile;
        BufferedWriter writer;
        if (before) {
            outputFile = new File("output_before.csv");
            writer = new BufferedWriter(new FileWriter("output_before.csv"));
        } else {
            outputFile = new File("output_after.csv");
            writer = new BufferedWriter(new FileWriter("output_after.csv"));
        }
        outputFile.createNewFile();
        // BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
        writer.write("File,UserId,Smell,ModelPrediction,UserAnnotation\n");
        for (Map.Entry<String, List<EntryModel>> stringListEntry : entries.entrySet()) {
            for (EntryModel val : stringListEntry.getValue()) {
                if (val.getSmell().equals("none"))
                    continue;
                System.out.println(stringListEntry.getKey() + "," + val.getUser() + "," + val.getSmell() + "," + val.isModelPrediction() + "," + val.isUserAnnotation());
                writer.write(stringListEntry.getKey() + "," + val.getUser() + "," + val.getSmell() + "," + val.isModelPrediction() + "," + val.isUserAnnotation() + "\n");
            }
        }
        writer.flush();
        writer.close();
        for (String smell : smells) {
            System.out.println("-------For smell : " + smell + "----------------");
            List<Map.Entry<String, List<EntryModel>>> selected = entries.entrySet().stream().filter(set -> set.getValue().size() > 0).filter(set -> set.getValue().get(0).getSmell().equalsIgnoreCase(smell)).collect(Collectors.toList());
            System.out.println("Number of entries found (more than 1 annotations) : " + selected.size());
//            selected.forEach(entry -> {
//
//                System.out.println("For entry:" + entry.getKey());
//                List<EntryModel> users = entry.getValue();
//                users.forEach(user -> {
//                    System.out.println("For User " + user.getUser() + " we said " + user.isModelPrediction() + " and user said : " + user.isUserAnnotation());
//                });
//
//            });

        }
        entries.forEach((key, value) -> {
            if (value.size() > 1) {
                if (!value.get(0).getSmell().equalsIgnoreCase("none"))
                    System.out.println(("For file : " + key + " with smell " + value.get(0).getSmell() + ", number of entries : " + value.size()));
            }
        });

    }

    private static void handleFile(String fileStr, boolean before) throws IOException {
        System.out.println("Working with file: " + fileStr);
        if (before) {
            if (!(Pattern.compile(".*before").matcher(fileStr).find()))
                return;
        } else {
            if (!(Pattern.compile(".*after").matcher(fileStr).find()))
                return;
        }
        System.out.println("File considered.");
        File file = new File(fileStr);
        String fileName = file.getName().substring(0, file.getName().indexOf('.'));
        List<String> lines = Files.readAllLines(file.toPath());
        int mean = lines.size() / 2;
        int count = 0;
        for (String line : lines) {
//            if (count < mean) {
//                count++;
//                continue;
//            }
//            count++;
            String[] lineSplit = line.split(",");
            String id = lineSplit[0];
            if (id == null || id.isEmpty() || id.equals("break") || id.equals("train"))
                continue;
            File tokenFile = new File(file.getParentFile().getAbsolutePath() + "\\" + fileName.substring(0, fileName.indexOf("_")) + "\\" + id + ".txt");
            ByteSource byteSource = com.google.common.io.Files.asByteSource(tokenFile);
            HashCode hc = byteSource.hash(Hashing.md5());
            String checksum = hc.toString();
            EntryModel entryModel = new EntryModel();
            entryModel.setId(id);
            entryModel.setUser(fileName.substring(0, fileName.indexOf("_")));
            entryModel.setSmell(lineSplit[1]);
            entryModel.setModelPrediction(lineSplit[2].equalsIgnoreCase("true") ? true : false);
            entryModel.setUserAnnotation(lineSplit[3].equalsIgnoreCase("true") ? true : false);
            if (entries.containsKey(checksum)) {
                List<EntryModel> listOfEntries = entries.get(checksum);
                listOfEntries.add(entryModel);
                entries.put(checksum, listOfEntries);
            } else {
                List<EntryModel> listOfEntries = new ArrayList<>();
                listOfEntries.add(entryModel);
                entries.put(checksum, listOfEntries);
            }

        }
    }

    private static void handleTFCase(String smell, String smellPred, String userResponded, boolean before) {
        boolean smellBool = smellPred.equalsIgnoreCase("true");
        boolean userBool = userResponded.equalsIgnoreCase("true");
        if (before) {
            switch (smell) {
                case "ComplexMethod":
                    if (smellBool && userBool)
                        CMBTT++;
                    else if (smellBool && !userBool)
                        CMBTF++;
                    else if (!smellBool && userBool)
                        CMBFT++;
                    else
                        CMBFF++;
                    break;
                case "LongMethod":
                    if (smellBool && userBool)
                        LMBTT++;
                    else if (smellBool && !userBool)
                        LMBTF++;
                    else if (!smellBool && userBool)
                        LMBFT++;
                    else
                        LMBFF++;
                    break;
                case "MultiFaceted":
                    if (smellBool && userBool)
                        MUBTT++;
                    else if (smellBool && !userBool)
                        MUBTF++;
                    else if (!smellBool && userBool)
                        MUBFT++;
                    else
                        MUBFF++;
                    break;
                case "none":
                    NB++;
            }

        } else {
            switch (smell) {
                case "ComplexMethod":
                    if (smellBool && userBool)
                        CMATT++;
                    else if (smellBool && !userBool)
                        CMATF++;
                    else if (!smellBool && userBool)
                        CMAFT++;
                    else
                        CMAFF++;
                    break;
                case "LongMethod":
                    if (smellBool && userBool)
                        LMATT++;
                    else if (smellBool && !userBool)
                        LMATF++;
                    else if (!smellBool && userBool)
                        LMAFT++;
                    else
                        LMAFF++;
                    break;
                case "MultiFaceted":
                    if (smellBool && userBool)
                        MUATT++;
                    else if (smellBool && !userBool)
                        MUATF++;
                    else if (!smellBool && userBool)
                        MUAFT++;
                    else
                        MUAFF++;
                    break;
                case "none":
                    NA++;
            }
        }
    }
}