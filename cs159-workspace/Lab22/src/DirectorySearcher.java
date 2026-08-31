import java.io.File;

/**
 * This is a utility class that provides some of the functionality of the Unix ls and find commands.
 * 
 * @author Cameron Sateri
 * @version 4/19/23
 */
public class DirectorySearcher {

    private final File start;

    /**
     * Construct a DirectorySearcher to search (or list files) inside a particular directory.
     * 
     * @param path the name of the directory that will be searched
     */
    public DirectorySearcher(String path) {
        this.start = new File(path);
    }

    /**
     * List the contents of the start directory (but not subdirectories).
     */
    public void listDirectory() {
        File[] files = start.listFiles();
        for (File curFile : files) {
            System.out.print(curFile.getName());
            if (curFile.isDirectory()) {
                System.out.print("\t(Directory)");
            }
            System.out.println();
        }
    }

    /**
     * Recursively list the contents of the start directory and all of the directories it contains.
     */
    public void listDirectories() {
        System.out.println(start.getName() + "/");
        File[] files = start.listFiles();
        for (File curFile : files) {
            System.out.print("    " + curFile.getName());
            if (curFile.isDirectory()) {
                System.out.println("/");
                subDirectories(2, curFile);
            } else {
                System.out.println();
            }
        }
    }

    /**
     * Finds the subdirectories based on a file.
     * 
     * @param indent The amount of times it should be indented.
     * @param file The flie to find the subdirectories of.
     */
    private void subDirectories(int indent, File file) {
        String indents = "";
        for (int i = 0; i < indent; i++) {
            indents += "    ";
        }
        File[] files = file.listFiles();
        for (File curFile : files) {
            System.out.print(indents + curFile.getName());
            if (curFile.isDirectory()) {
                System.out.println("/");
                subDirectories(indent + 1, curFile);
            } else {
                System.out.println();
            }
        }
    }

    /**
     * Recursively search the start directory and all of the directories it contains. This method will print out only
     * the file and directory names that contain the search string.
     * 
     * For example if the string is "txt", the files "hello.txt" and "blatxt.doc" would both match, but "text.doc" would
     * not.
     * 
     * @param searchString the pattern to search for
     */
    public void searchDirectories(String searchString) {
        File[] files = start.listFiles();
        for (File curFile : files) {
            if (curFile.getName().contains(searchString)) {
                System.out.println(curFile);
            }
            if (curFile.isDirectory()) {
                findFile(curFile, searchString);
            }
        }
    }

    /**
     * Finds the file in a directory.
     * 
     * @param file The file to search.
     * @param searchString The primary string to search for.
     */
    private void findFile(File file, String searchString) {
        File[] files = file.listFiles();
        for (File curFile : files) {
            if (curFile.getName().contains(searchString)) {
                System.out.println(curFile);
            }
            if (curFile.isDirectory()) {
                findFile(curFile, searchString);
            }
        }
    }

}
