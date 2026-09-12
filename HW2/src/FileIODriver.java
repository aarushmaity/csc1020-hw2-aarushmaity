import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileIODriver {
    private static final int WHOLE_NUMBER = 57;
    private static final double FRACTION = 4.876;
    private static final String WORDS = "I am Mr. Data";

    public static void main(String[] args){
        Path textPath = Paths.get("data","data.txt");
        Path binPath = Paths.get("data","data.bin");
        Path objPath = Paths.get("data", "object.bin");

        // Write Files.
        try(PrintWriter pw = new PrintWriter(textPath.toFile());
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream(binPath.toFile()));
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(objPath.toFile()));){


        writeText(pw);
        writeBinary(dos);
        writeObject(oos);
        }catch(IOException e){
            System.out.println("Fix your code");
        }

       // Read Files.
        try(Scanner in = new Scanner(textPath);
            DataInputStream dis = new DataInputStream(
                    new FileInputStream(binPath.toFile()));
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(objPath.toFile()));){

            readText(in);
            readBinary(dis);
            readObject(ois);

        }catch(IOException e){
            System.out.println("Fix your code: Season 2");
        }catch(ClassNotFoundException e){
            System.out.println("Fix your code extra episode: Object error");
        }

    }

    public static void writeText(PrintWriter writer){
        writer.print(WHOLE_NUMBER+" ");
        writer.print(FRACTION+" ");
        writer.print(WORDS);
    }

    public static void writeBinary(DataOutputStream dos) throws IOException{
        dos.writeInt(WHOLE_NUMBER);
        dos.writeDouble(FRACTION);
        dos.writeUTF(WORDS);
    }

    public static void writeObject(ObjectOutputStream oos) throws IOException{
        oos.writeObject(new MyObject(WHOLE_NUMBER,FRACTION,WORDS));
    }

    public static void readText(Scanner reader){
        System.out.println(reader.nextLine());
    }

    public static void readBinary(DataInputStream dis) throws IOException{
        System.out.println(dis.readInt()+" "+dis.readDouble()+" "+dis.readUTF());
    }

    public static void readObject(ObjectInputStream ois)
            throws IOException, ClassNotFoundException{
        System.out.println(ois.readObject());
    }
}
