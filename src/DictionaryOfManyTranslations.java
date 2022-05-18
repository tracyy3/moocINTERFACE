import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> wordTranslation;

    public DictionaryOfManyTranslations() {
        this.wordTranslation = new HashMap<>();
    }

    public static void main(String[] args) {
        DictionaryOfManyTranslations dictionary = new DictionaryOfManyTranslations();
        dictionary.add("lie", "maata");
        dictionary.add("lie", "valehdella");

        dictionary.add("bow", "jousi");
        dictionary.add("bow", "kumartaa");

        System.out.println(dictionary.translate("lie"));
        dictionary.remove("bow");
        System.out.println(dictionary.translate("bow"));
    }

    public void add(String word, String translation) {
        this.wordTranslation.putIfAbsent(word, new ArrayList<>());

        ArrayList<String> translationList = this.wordTranslation.get(word);
        translationList.add(translation);
    }

    public ArrayList<String> translate(String word) {
        ArrayList<String> empty = new ArrayList<>();

        if (!wordTranslation.containsKey(word)) {
            wordTranslation.put(word, empty);
        } else if (wordTranslation.containsKey(word)) {
            wordTranslation.values().remove(empty);
            return wordTranslation.get(word);
        }

        return new ArrayList<String>();
    }

    public void remove(String word) {
        if (wordTranslation.containsKey(word)) {
            this.wordTranslation.remove(word);
        }
    }

}