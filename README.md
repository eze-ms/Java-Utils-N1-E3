# Directory Lister 📁

## 📄 Description
This Java project recursively lists the contents of a directory, showing files and folders in alphabetical order. It indicates whether each item is a file (F) or a directory (D) and displays the last modified date. The result is saved into a TXT file.

---

### **Functionality**

#### **Core Features**:
1. **Alphabetical Listing**:
    - The contents are listed in alphabetical order within each level.

2. **Recursive Directory Tree**:
    - Lists files and directories starting from a given path.
    - Displays:
        - **[D]**: Indicates a directory.
        - **[F]**: Indicates a file.
        - Last modified date.

3. **Output to File:**:
    - If no arguments are provided:
        - Creates and lists a directory called `TestFolder` in the **project root**.
    - If an argument is provided:
        - Creates and lists the directory in the **specified path** (e.g., Desktop).

4. **Default Files**:
    - Automatically adds:
        - `file1.txt`
        - `file2.txt`
        - Subdirectory `subdir`

5. **Custom Path**
    - Accepts a directory path as an argument and generates the output for that path.

---

## 💻 Technologies Used
- Java 17
- IntelliJ IDEA as the development environment

---

## 📋 Requirements
- **Java Development Kit (JDK)**: Version 17 or higher.
- **IDE**: IntelliJ IDEA or any compatible Java IDE.
- **Operating Systems**: macOS, Windows, Linux.

---

## 🚀 Execution

### **Compile the Project**
1. Compile the program from the project root:
   ```bash
   javac -d out -sourcepath src src/Main.java

2. Run the program, providing the directory path as an argument:
    - If the directory does not exist, it is created automatically.
    - You can provide a relative or absolute path.
    - Relative path (in the project root):
       ```bash
         java -cp out Main TestFolder

    - Absolute path (for example, on the desktop):
   ```bash
    java -cp out Main /Users/ezequielmacchi_1/Desktop/TestFolder

### Without Arguments:
1. Run the program without arguments:
    - If no arguments are provided, the program automatically
        - Creates a folder called TestFolder in the project root (if it doesn't already exist).
        - Adds file1.txt, file2.txt y el subdirectorio subdir.
    ```bash
    java -cp out Main

### Example Output:
#### With Argument:
- Directory created at: /ruta/proporcionada/MiCarpeta
- Default files and subdirectory created.
- Contents of /ruta/proporcionada/TestFolder:
    - file1.txt
    - file2.txt
    - subdir

#### Without Argument:
- Directory created at: /ruta/a/TuProyecto/TestFolder
- Default files and subdirectory created.
- Contents of /ruta/a/TuProyecto/TestFolder:
    - file1.txt
    - file2.txt
    - subdir

#### Recursive Output (New Feature):
If the directory contains nested subdirectories:
- [D] MiCarpeta (Last Modified: 17-12-2024 19:05:08)
    - [F] file1.txt (Last Modified: 17-12-2024 19:05:08)
    - [F] file2.txt (Last Modified: 17-12-2024 19:05:08)
    - [D] subdir (Last Modified: 17-12-2024 19:05:08)
        - [F] nestedFile.txt (Last Modified: 17-12-2024 19:06:00)


---

## 🛠️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/eze-ms/Java-Utils-N1-E3
