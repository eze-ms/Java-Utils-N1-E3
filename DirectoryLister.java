import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import auxiliar.Utils;

public class DirectoryLister {

    //! Punto de inicio del programa.
    static void init(String[] args) {
        String defaultDirectory = "TestFolder";

        String directoryPath = (args.length < 1) ? defaultDirectory : Utils.argsToString(args);
        Path path = Utils.validatePath(directoryPath);

        if (path != null) {
            // Crear archivos y subdirectorios si el directorio está vacío
            if (isDirectoryEmpty(path)) {
                createDefaultFiles(path);
            }

            // Guardar el árbol de directorios en un archivo TXT
            saveDirectoryTreeToFile(path, "directoryTree.txt");
        }
    }

    //! Guarda el árbol de directorios en un archivo TXT.
    public static void saveDirectoryTreeToFile(Path path, String fileName) {
        Path outputFile = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            listDirectoryTreeRecursive(path, 0, writer);
            System.out.println("Directory tree saved to: " + outputFile.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    //! Método recursivo para listar un árbol de directorios y guardar en un archivo.
    public static void listDirectoryTreeRecursive(Path path, int level, BufferedWriter writer) {
        try (Stream<Path> pathStream = Files.list(path).sorted()) {
            List<Path> sortedPaths = pathStream.toList();

            for (Path file : sortedPaths) {
                String type = Files.isDirectory(file) ? "D" : "F";
                String date = Utils.formatLastModified(file.toFile().lastModified());
                String output = "  ".repeat(level) + "[" + type + "] " + file.getFileName() + " (Last Modified: " + date + ")\n";

                // Escribir en el archivo
                writer.write(output);

                // Si es un directorio, llamar recursivamente
                if (Files.isDirectory(file)) {
                    listDirectoryTreeRecursive(file, level + 1, writer);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the directory: " + e.getMessage());
        }
    }

    //! Comprueba si un directorio está vacío.
    private static boolean isDirectoryEmpty(Path path) {
        try (Stream<Path> stream = Files.list(path)) {
            boolean isEmpty = stream.findAny().isEmpty();
            return isEmpty;
        } catch (IOException e) {
            System.out.println("Error checking directory: " + e.getMessage());
            return false;
        }
    }

    //! Crea archivos y subdirectorios por defecto en la ruta dada.
    private static void createDefaultFiles(Path path) {
        try {
            System.out.println("Creating default files and subdirectory...");
            Files.createFile(path.resolve("file1.txt"));
            Files.createFile(path.resolve("file2.txt"));
            Files.createDirectory(path.resolve("subdir"));
            System.out.println("Default files and subdirectory created.");
        } catch (IOException e) {
            System.out.println("Error creating default files: " + e.getMessage());
        }
    }
}
