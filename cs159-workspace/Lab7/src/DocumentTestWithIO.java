import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Unit tests for the CS159 File IO Lab.
 * 
 * @author CS 159 Instructors
 * @version 3/10/21
 */
public class DocumentTestWithIO {
    private Document docEmpty;
    private Document docFull;
    private String docFullString;

    @BeforeEach
    public void setUp() {
        docEmpty = new Document();
        docFull = new Document();

        File n = new File("tmp1.txt");
        n.delete();

        docFull.appendLine("Hello There");
        docFull.appendLine("This is cool.");
        docFullString = "Hello There\nThis is cool.\n";
    }

    @AfterEach
    public void tearDown() throws Exception {
        File n = new File("tmp1.txt");
        n.delete();
    }

    @Test
    public void testToStringFull() {
        assertEquals(docFullString, docFull.toString());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("", docEmpty.toString());
    }

    @Test
    public void testDeleteLine() {
        docFull.deleteLine(0);
        assertEquals("This is cool.\n", docFull.toString());
    }

    @Test
    public void testCharacterCountFull() {
        assertEquals(24, docFull.characterCount());
    }

    @Test
    public void testCharacterCountEmpty() {
        assertEquals(0, docEmpty.characterCount());
    }

    @Test
    public void testLongestSingle() {
        docEmpty.appendLine("aaaa");
        assertEquals("aaaa", docEmpty.longestLine());
    }

    @Test
    public void testLongestFirst() {
        docEmpty.appendLine("aaaa");
        docEmpty.appendLine("aaa");
        docEmpty.appendLine("aa");
        assertEquals("aaaa", docEmpty.longestLine());
    }

    @Test
    public void testLongestMiddle() {
        docEmpty.appendLine("aaa");
        docEmpty.appendLine("aaaa");
        docEmpty.appendLine("aa");
        assertEquals("aaaa", docEmpty.longestLine());
    }

    @Test
    public void testLongestLast() {
        docEmpty.appendLine("aaa");
        docEmpty.appendLine("aa");
        docEmpty.appendLine("aaaa");
        assertEquals("aaaa", docEmpty.longestLine());
    }

    @Test
    public void testLongestNull() {
        assertEquals(null, docEmpty.longestLine());
    }

    @Test
    public void testSave() throws FileNotFoundException {
        docFull.save("tmp1.txt");
        assertEquals(null, docEmpty.longestLine());
        Scanner sc = new Scanner(new FileInputStream("tmp1.txt"));
        sc.useDelimiter("\\z");
        assertEquals(docFullString, sc.next());
        sc.close();
    }
    
    @Test
    public void testSaveThrowsException()  {
      
        assertThrows(FileNotFoundException.class, () -> {
            docFull.save("");
        });
    }

    @Test
    public void testLoad() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("tmp1.txt");
        pw.print(docFullString);
        pw.close();
        Document loaded = new Document("tmp1.txt");
        assertEquals(docFullString, loaded.toString());
    }
    
    @Test
    public void testLoadThrowsException()  {
        assertThrows(FileNotFoundException.class, () -> {
            new Document("THISISNOTAFILE.txt");
        });
    }

    @Test
    public void testLoadCorrectLongestLine() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("tmp1.txt");
        pw.print(docFullString);
        pw.close();
        Document loaded = new Document("tmp1.txt");
        assertEquals("This is cool.", loaded.longestLine());
    }

}
