package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Logger {
    public static void logResults(File logFile, List<ConversionResult> results) throws IOException {
        try (FileWriter writer = new FileWriter(logFile)) {
            for (ConversionResult result : results) {
                writer.write(result.toString());
                writer.write(System.lineSeparator());
            }
        }
    }
}
