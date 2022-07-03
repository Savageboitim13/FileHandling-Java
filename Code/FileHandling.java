import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Main {
    private final String PATH = "C:\\Users\\Samuil\\IdeaProjects\\Test Projekt\\src\\Storages in Java";

    public static void main(String[] args) {
        new Main().Run();
    }

    public void Run() {
        new FileHandling().GetFileInfo(PATH);
    }
}

class FileHandling {
    public void CreateFile(String Path) {
        try {
            File File = new File(Path);
            if (File.createNewFile()) {
                System.out.println("File created: " + File.getName());
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void OverwriteFile(String Path, String Content) {
        try {
            FileWriter Writer = new FileWriter(Path);
            Writer.write(Content);
            Writer.close();
            System.out.println("Successfully overwrote the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void ReadFile(String Path) {
        try {
            File File = new File(Path);
            Scanner Reader = new Scanner(File);
            while (Reader.hasNextLine()) {
                String Data = Reader.nextLine();
                System.out.println(Data);
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void GetFileInfo(String Path) {
        File File = new File(Path);
        if (File.exists()) {
            System.out.println("File name: " + File.getName());
            System.out.println("Absolute path: " + File.getAbsolutePath());
            System.out.println("Writeable: " + File.canWrite());
            System.out.println("Readable: " + File.canRead());
            System.out.println("File size(bytes): " + File.length());
            System.out.println("Executable: " + File.canExecute());
        } else {
            System.out.println("File doesn't exist.");
        }
    }

    public void DeleteFileOrFolder(String Path) {
        File File = new File(Path);
        if (File.delete()) {
            if (File.isFile()) {
                System.out.println("Deleted the file: " + File.getName());
            } else if (File.isDirectory()) {
                System.out.println("Dleted the directory: " + File.getName());
            } else {
                System.out.println("Delete unknown type: " + File.getName());
            }
        } else if (File.isFile()){
            System.out.println("Failed to delete the file.");
        } else if (File.isDirectory()) {
            System.out.println("Failed to delete the folder.");
        } else {
            System.out.println("Filed to delete unknown type.");
        }
    }

}
