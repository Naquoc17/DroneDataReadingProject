package app;

import java.io.FileNotFoundException;

public class MissingEnvFileException extends FileNotFoundException {
    public MissingEnvFileException(){
        super("The .env file was not found. Please make sure the file has been created and configured correctly.");
    }
}
