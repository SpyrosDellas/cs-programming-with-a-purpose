/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     21/03/2020
 *
 * Huntingtons.java analyzes a DNA string for Huntington’s disease and produces
 * a diagnosis.
 *
 * Huntington’s disease:
 * Huntington’s disease is an inherited and fatal neurological disorder.
 * Although there is currently no cure, in 1993 scientists discovered a very
 * accurate genetic test. The gene that causes Huntington’s disease is located
 * on chromosome 4 and has a variable number of (consecutive) repeats of the
 * CAG trinucleotide. The normal range of CAG repeats is between 10 and 35.
 * Individuals with Huntington’s disease have between 36 and 180 repeats.
 * Doctors can use a PCR-based DNA test; count the maximum number of repeats;
 * and use the following table to generate a diagnosis:
 *      REPEATS     DIAGNOSIS
 *        0–9       not human
 *        0–35        normal
 *        36–39      high risk
 *       40–180    Huntington’s
 *        181+       not human
 *
 * Performance requirement:
 * The maxRepeats() and removeWhitespace() methods must take time linear in the
 * length of the string.
 *
 * Input format:
 * The file format is a sequence of nucleotides (A, C, G, and T), with arbitrary
 * amounts of whitespace separating the nucleotides. The data files dna4.txt,
 * dna64.txt, chromosome4-hd.txt, and chromosome4-healthy.txt, are in the
 * specified format.
 *
 **************************************************************************** */

public class Huntingtons {

    public static int maxRepeats(String dna) {
        /* Returns the maximum number of consecutive repeats of CAG in the DNA
        string.
         */
        int maxRepeats = 0;
        int repeats = 0;
        int index = 0;
        String seq = "CAG";
        while (index < dna.length() - 2) {
            if (dna.charAt(index) == seq.charAt(0)) {
                boolean match = true;
                for (int i = 1; i <= 2; i++) {
                    index++;
                    if (dna.charAt(index) != seq.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    index++;
                    repeats++;
                    if (repeats > maxRepeats) maxRepeats = repeats;
                }
                else repeats = 0;
            }
            else {
                index++;
                repeats = 0;
            }

        }
        return maxRepeats;
    }


    public static String removeWhitespace(String s) {
        /* Returns a copy of s, with all whitespace (spaces, tabs, and newlines)
        removed.
         */
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!Character.isWhitespace(letter)) {
                result.append(letter);
            }
        }
        return result.toString();
    }


    public static String diagnose(int maxRepeats) {
        /* Returns one of these diagnoses corresponding to the maximum number
        of repeats: "not human", "normal", "high risk", or "Huntington's".
         */
        String diagnosis;
        if (maxRepeats < 10 || maxRepeats > 180) {
            diagnosis = "not human";
        }
        else if (maxRepeats <= 35) {
            diagnosis = "normal";
        }
        else if (maxRepeats < 40) {
            diagnosis = "high risk";
        }
        else {
            diagnosis = "Huntington's";
        }
        return diagnosis;
    }


    public static void main(String[] args) {
        String fileName = args[0];
        In file = new In(fileName);
        String dna = file.readAll();
        dna = removeWhitespace(dna);
        int repeats = maxRepeats(dna);
        System.out.println("max repeats = " + repeats);
        System.out.println(diagnose(repeats));
    }
}
