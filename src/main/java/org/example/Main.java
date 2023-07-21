package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File inputDir = new File(args.length > 0 ? args[0] : ".");

        if (!inputDir.exists() || !inputDir.isDirectory()) {
            System.out.println("Invalid directory path: " + inputDir.getAbsolutePath());
            return;
        }

        File convertedDir = new File(inputDir, "converted");
        if (!convertedDir.exists()) {
            convertedDir.mkdirs();
        }

        FileConverter fileConverter = new FileConverter();

        try {
            for (File inputFile : inputDir.listFiles()) {
                if (inputFile.isFile() && (inputFile.getName().endsWith(".json")
                        || inputFile.getName().endsWith(".yaml")
                        || inputFile.getName().endsWith(".yml"))) {
                    if (inputFile.getName().endsWith(".json")) {
                        fileConverter.convertJsonToYaml(inputFile, convertedDir);
                    } else {
                        fileConverter.convertYamlToJson(inputFile, convertedDir);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error converting files: " + e.getMessage());
        }
    }
}

