import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTransformer {

    private static final String OUTPUT_EXTENSION = ".tekkas";
    private static final String FILE_TYPE_IDENTIFIER = "FileType: ";

    public static void transformFile(String inputFilename) {

        String outputFilename = removeExtension(inputFilename) + OUTPUT_EXTENSION;

        String originalExtension = getFileExtension(inputFilename);

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFilename));
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFilename))) {

            outputStream.write((FILE_TYPE_IDENTIFIER + originalExtension + System.lineSeparator()).getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File transformed to: " + outputFilename);

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    private static String removeExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return filename;
        }
        return filename.substring(0, lastDotIndex);
    }

    private static String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "unknown";
        }
        return filename.substring(lastDotIndex + 1);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileTransformer <input_filename>");
            System.exit(1);
        }

        transformFile(args[0]);
    }
}
