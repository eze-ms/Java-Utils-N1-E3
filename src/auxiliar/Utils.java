package auxiliar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class Utils {

    //! Convierte un array de cadenas en una única cadena separada por espacios.
    public static String argsToString(String[] args) {
        return String.join(" ", args); // Variante simplificada de for.
    }

    //! Valida la ruta proporcionada por el usuario y crea un directorio si no existe.
    public static Path validatePath(String pathString) {
        if (pathString == null || pathString.isEmpty()) {
            // Si no se proporciona una ruta, crear TestFolder en la raíz del programa
            pathString = "TestFolder";
        }

        try {
            Path path;

            if (pathString.startsWith("/")) {
                // Si la ruta es absoluta, usarla directamente
                path = Paths.get(pathString).toAbsolutePath();
            } else {
                // Si la ruta no es absoluta, colocarla en la raíz del programa
                path = Paths.get(System.getProperty("user.dir"), pathString).toAbsolutePath();
            }

            if (!Files.exists(path)) {
                Files.createDirectories(path);
                System.out.println("Directory created at: " + path.toAbsolutePath());
            }

            if (!Files.isDirectory(path)) {
                System.out.println("The provided path is not a directory.");
                return null;
            }

            return path; // Devuelve la ruta validada
        } catch (InvalidPathException | IOException e) {
            System.out.println("Invalid path: " + e.getMessage());
            return null;
        }
    }


    //! Formatea la fecha de la última modificación de un archivo/directorio.
    public static String formatLastModified(long lastModified) {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(lastModified);
    }
}
