import java.util.Locale;

public class TestStrings1 {

    public static int wordCount(String paragraph, String word) {
        int count = 0;
        int word_length = word.length();
        for (int i = 0; i <= paragraph.length() - word.length(); i += 1) {
            String substring = paragraph.substring(i, i + word_length);
            if (substring.equals(word)) {
                count += 1;
            }
        }
        return count;
    }

    public static int vowelCount(String paragraph){
        String vowels = "aeiou";
        String lowerParagraph = paragraph.toLowerCase(Locale.ROOT);
        int vowel_count = 0;

        for (int i = 0; i < paragraph.length(); i += 1){
            char letter = lowerParagraph.charAt(i);
            if (vowels.contains(String.valueOf(letter))) {
                vowel_count += 1;
            }
        }
        return vowel_count;
    }
    public static void main(String[] args){
        String paragraph = "Sai Ram Sai Guruvay Namah: Sabaka Maalik ek hai Sai Devayya Nam Shirdi devai nam";
        String word = "Sai";
        int word_count = wordCount(paragraph,word);
        int vowel_count = vowelCount(paragraph);
        System.out.println("Word count: " + word_count);
        System.out.println("Vowel count: " + vowel_count);
        }
}