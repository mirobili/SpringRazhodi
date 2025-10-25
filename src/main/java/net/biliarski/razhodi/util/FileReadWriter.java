package net.biliarski.razhodi.util;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReadWriter {



    public void fileWriteContents(String file, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String fileReadContents(String file){
        StringBuilder out = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                out.append(line);
            }
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
