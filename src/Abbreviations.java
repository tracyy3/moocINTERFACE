import java.util.HashMap;

public class Abbreviations {
    private static HashMap<String, String> abbreviationMap = new HashMap<>();

    public static void main(String[] args) {
        Abbreviations abbreviations = new Abbreviations();
        abbreviations.addAbbreviation("e.g.", "for example");
        abbreviations.addAbbreviation("etc.", "and so on");
        abbreviations.addAbbreviation("i.e.", "more precisely");

        String text = "e.g. i.e. etc. lol";

        for (String part : text.split(" ")) {
            if (abbreviations.hasAbbreviation(part)) {
                part = abbreviations.findExplanationFor(part);
            }

            System.out.print(part);
            System.out.print(" ");
        }

        System.out.println();
    }

    public Abbreviations() {
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviationMap.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return abbreviationMap.get(abbreviation) != null;
    }

    public String findExplanationFor(String abbreviation) {
        return abbreviationMap.get(abbreviation);
    }
}
