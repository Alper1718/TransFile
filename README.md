# File Transformer and Decoder

This project includes two Java programs: a **file transformer** that converts files to a custom `.tekkas` format and a **file decoder** that reads and processes files in the `.tekkas` format.

## File Transformer

The **file transformer** reads an input file, adds a custom file type identifier at the beginning, and saves it with a `.tekkas` extension.

### Usage

1. **Compile the Transformer**:

    ```bash
    javac FileTransformer.java
    ```

2. **Run the Transformer**:

    ```bash
    java FileTransformer <input_filename>
    ```

   Replace `<input_filename>` with the name of the file you want to transform. The output file will be saved as `<input_filename>.tekkas`.

### Example

```bash
java FileTransformer example.txt
```

This command will create a file named `example.tekkas` with the original file extension and content.

## File Decoder

The **file decoder** reads a `.tekkas` file, extracts the original file type from the first line, and prints the rest of the content.

### Usage

1. **Compile the Decoder**:

    ```bash
    javac FileDecoder.java
    ```

2. **Run the Decoder**:

    ```bash
    java FileDecoder <input_filename.tekkas>
    ```

   Replace `<input_filename.tekkas>` with the name of the `.tekkas` file you want to decode.

### Example

```bash
java FileDecoder example.tekkas
```

## Files

- **FileTransformer.java**: Java program to transform files to `.tekkas` format.
- **FileDecoder.java**: Java program to decode `.tekkas` files and print the content.

## Requirements

- Java Development Kit (JDK) 8 or higher.