import java.io.*;


public class main {
    public static void main(String[] args) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"))){
            bw.write("Hom nay troi dep qua");
        } catch (IOException e) {
            System.err.println("Error writing to file");
        }

        System.out.println("Content of input.txt");
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
        }

        try(BufferedReader br = new BufferedReader( new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Moved to output.txt");
        }  catch (IOException e) {
            System.err.println("Error writing to file");
        }

    }
}
