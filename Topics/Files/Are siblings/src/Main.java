import java.io.File;
import java.util.Scanner;

class Siblings {


    public static boolean areSiblings(File f1, File f2) {
        // implement me
        return f1.getParent().equals(f2.getParent());
    }
}