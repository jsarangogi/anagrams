import java.util.*;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("First word: ");
        final String a = scanner.nextLine();
        System.out.print("Second word: ");
        final String b = scanner.nextLine();
        if(areAnagram(a,b))
            System.out.println("Anagrams");
        else
            System.out.printf("Not Anagrams");
    }

    private static boolean areAnagram(final String a, final String b) {
        final Map<String,Integer> freqA = getFrequencies(a);
        System.out.println("Frequencies of '" + a + "': " + freqA);
        final Map<String,Integer> freqB = getFrequencies(b);
        System.out.println("Frequencies of '" + b + "': " + freqB);
        return freqA.equals(freqB);
    }

    private static Map<String,Integer> getFrequencies(final String str) {
        final Map<String,Integer> frequencies = new HashMap<>();
        final List<String> characters = convertToStringList(str.toLowerCase().toCharArray());
        Set<String> distinct = new HashSet<>(characters);
        for(String c : distinct)
            frequencies.put(c,Collections.frequency(characters, c));
        return frequencies;
    }

    private static List<String> convertToStringList(final char[] array) {
        final List<String> characters = new ArrayList<>();
        for (char c : array)
            characters.add(Character.toString(c));
        return characters;
    }
}