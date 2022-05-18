import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> hashmap;

    public StorageFacility() {
        this.hashmap = new HashMap<>();
    }

    public static void main(String[] args) {

        StorageFacility facility = new StorageFacility();
        facility.add("a14", "ice skates");
        facility.add("a14", "ice hockey stick");
        facility.add("a14", "ice skates");

        facility.add("f156", "rollerblades");
        facility.add("f156", "rollerblades");

        facility.add("g63", "six");
        facility.add("g63", "pi");

        facility.remove("f156", "rollerblades");

        System.out.println(facility.contents("f156"));

        facility.remove("f156", "rollerblades");

        System.out.println(facility.storageUnits());
    }

    public void add(String unit, String item) {
        this.hashmap.putIfAbsent(unit, new ArrayList<>());

        ArrayList<String> items = this.hashmap.get(unit);
        items.add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        ArrayList<String> empty = new ArrayList<>();
        empty.add("");
        if (!hashmap.containsKey(storageUnit)) {
            return empty;
        }

        else if (hashmap.containsKey(storageUnit)) {
            return hashmap.get(storageUnit);
        }

        return null;
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> removeList = this.hashmap.get(storageUnit);
        removeList.remove(item);
        hashmap.put(storageUnit, removeList);
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> listOfUnits = new ArrayList<>();

        for (String keys : hashmap.keySet()) {

            if (hashmap.get(keys).size() != 0) {
                listOfUnits.add(keys);
            }
        }

        return listOfUnits;
    }
}
