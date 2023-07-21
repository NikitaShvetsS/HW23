package org.example;

import org.json.JSONObject;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileConverter {

    public static String convertJsonToYaml(File inputFile, File outputDir) throws IOException {
        String fileName = inputFile.getName();
        String newFileName = fileName.replace(".json", ".yaml");

        List<String> jsonLines = Files.readAllLines(Paths.get(inputFile.getAbsolutePath()));
        JSONObject jsonObject = new JSONObject(String.join("", jsonLines));
        Yaml yaml = new Yaml(getDumperOptions());
        String yamlString = yaml.dump(jsonObject.toMap());

        Files.write(Paths.get(outputDir.getAbsolutePath(), newFileName), yamlString.getBytes());

        return newFileName;
    }

    public static String convertYamlToJson(File inputFile, File outputDir) throws IOException {
        String fileName = inputFile.getName();
        String newFileName = fileName.replace(".yaml", ".json").replace(".yml", ".json");

        List<String> yamlLines = Files.readAllLines(Paths.get(inputFile.getAbsolutePath()));
        Yaml yaml = new Yaml();
        Map<String, Object> yamlMap = yaml.load(String.join("\n", yamlLines));
        JSONObject jsonObject = new JSONObject(yamlMap);

        String jsonString = jsonObject.toString(2);
        Files.write(Paths.get(outputDir.getAbsolutePath(), newFileName), jsonString.getBytes());

        return newFileName;
    }
    private static DumperOptions getDumperOptions() {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        return options;
    }
}
