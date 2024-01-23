public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int consecutiveRepeats = 0;
        int currentRepeats = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (!dna.substring(i, Math.min(i+3, dna.length())).equals("CAG")) {
                currentRepeats = 0;
                continue;
            }
            currentRepeats++;
            if (currentRepeats > consecutiveRepeats) consecutiveRepeats = currentRepeats;  
            i += 2;          
        }
        return consecutiveRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        return s.replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 180) return "not human";
        if (maxRepeats <= 35) return "normal";
        if (maxRepeats <= 39) return "high risk";
        return "Huntington's";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In scanner = new In(args[0]);
        String dna = removeWhitespace(scanner.readAll());
        int repeats = maxRepeats(dna);
        System.out.println("max repeats = " + repeats);
        System.out.println(diagnose(repeats));
    }

}