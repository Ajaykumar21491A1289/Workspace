package com.jocata.filehandling.main;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileHandlineNio {
    public static void main(String[] args) {

        try {
            //Creating the File
            Path path = Paths.get("D:\\Jocata_Internship\\JAVA\\example.txt");
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("FIle Created Successfully");
            }
            else System.out.println("File is Already exist");

            //writing data in to the file
            Files.write(path, "Hello NIO".getBytes());

            //Appending the data in to the file
            Files.write(path, "\nAppended with NIO".getBytes(), StandardOpenOption.APPEND);

            //Read All Lines
            List<String> lines = Files.readAllLines(path);
            for(String data : lines) System.out.println(data);

            //Copying a File
            Path targetPath = Path.of("D:\\Jocata_Internship\\example.txt");
            Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);

            //Moving/Renaming a File
            Files.move(path, targetPath, StandardCopyOption.REPLACE_EXISTING);

            Files.move(targetPath, path, StandardCopyOption.REPLACE_EXISTING);

            //Checking weather the file is exist or not
            System.out.println(Files.exists(path));

            //Checking is file is readable or not
            System.out.println(Files.isReadable(path));

            //Checking is file is writable or not
            System.out.println(Files.isWritable(path));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
