package TestObjectClassMethods;

// Interface
interface CharSeq{

    String reverse();
    char charAt(int ind);
    int length();
    String subSequence(int start_ind, int end_int);

}

// CharSequence class
class CharSequence implements CharSeq{

    // Private variable
    private String sentence;

    // Getter
    public String getSentence() {
        return sentence;
    }

    // Constructor
    public CharSequence(String sentence) {
        this.sentence = sentence;
    }

    // 4 methods
    public int length(){
        return sentence.length();
    }

    public char charAt(int ind){
        return sentence.charAt(ind);
    }

    public String subSequence(int start_ind, int end_ind){
        return (String) sentence.subSequence(start_ind,end_ind);
    }

    public String reverse(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length()-1; i >= 0; i -= 1){
            stringBuilder.append(charAt(i));
        }
        return stringBuilder.toString();
    }

}

public class TestInterface {

    public static void main(String[] args){
        String sentence = "If the char value specified by the index is a surrogate, the surrogate value is returned.";
        CharSequence charSequence = new CharSequence(sentence);
        System.out.println("Sentence: " + sentence);
        System.out.println("Reversed sentence: " + charSequence.reverse());
        System.out.println("Length of sentence: " + charSequence.length());
        System.out.println("Subsequence from range 0 to 5: " + charSequence.subSequence(0,5));
        System.out.println("Character at index 5: " + charSequence.charAt(5));
    }

}
