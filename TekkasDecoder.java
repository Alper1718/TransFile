import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TekkasDecoder {

    public static void decodeFile(String inputFilename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String firstLine = reader.readLine();
            if (firstLine == null || !firstLine.startsWith("FileType: ")) {
                System.err.println("Invalid file format.");
                return;
            }

            String originalExtension = firstLine.substring("FileType: ".length()).trim();
            String outputFilename = removeExtension(inputFilename) + "." + originalExtension;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("File Decoded to: " + outputFilename);
            }

        } catch (Exception e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }

    private static String removeExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return filename;
        }
        return filename.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java TekkasDecoder <input_filename.tekkas>");
            System.exit(1);
        }

        decodeFile(args[0]);
    }

}
