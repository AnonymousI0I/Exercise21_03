package assignments.Exercise21_03;

import java.io.File;
import java.util.*;

public class Exercise21_03 {
    private static final String[] keywordString = {
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
        "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
        "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"
    };

    private static final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise21_03 filename");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist");
            System.exit(2);
        }

        System.out.println("The program is");
        Scanner show = new Scanner(file);
        while (show.hasNextLine()) {
            System.out.println(show.nextLine());
        }

        System.out.println("The number of keywords in the program is " + countKeywords(file));
    }

    public static int countKeywords(File file) throws Exception {
        int count = 0;
        boolean inBlockComment = false;
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            // Remove line comments
            if (!inBlockComment && line.contains("//")) {
                line = line.substring(0, line.indexOf("//"));
            }

            // Handle block comments
            if (!inBlockComment && line.contains("/*")) {
                inBlockComment = true;
                line = line.substring(0, line.indexOf("/*"));
            }

            if (inBlockComment && line.contains("*/")) {
                inBlockComment = false;
                line = line.substring(line.indexOf("*/") + 2);
            }

            if (inBlockComment) continue;

            // Remove string literals
            line = line.replaceAll("\".*?\"", " ");

            // Tokenize and count
            String[] words = line.split("[\\s+{}();\\[\\].,]+");
            for (String word : words) {
                if (keywordSet.contains(word)) {
                    count++;
                }
            }
        }

        return count;
    }
}
