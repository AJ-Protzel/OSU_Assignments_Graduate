import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Array of data to create Bow objects
        Object[][] bowData = {
            {"Carbon Fiber", "Composite", "Dacron", "Olympic", 45, 7.5, true, true, true},
            {"Wood", "Bamboo", "Dacron", "Traditional", 35, 7.0, false, false, false},
            {"Aluminum", "Fiberglass", "Horse Hair", "Compound", 50, 6.5, true, true, false}
        };

        // Create a list of Bow objects
        List<Bow> bows = new ArrayList<>();
        for (Object[] data : bowData) {
            // Create a new Bow object and add it to the list
            bows.add(new Bow(
                (String) data[0],
                (String) data[1],
                (String) data[2],
                (String) data[3],
                (int) data[4],
                (double) data[5],
                (boolean) data[6],
                (boolean) data[7],
                (boolean) data[8]
            ));
        }

        // Calculate the average weight of the bows
        double averageWeight = calculateAverageWeight(bows);
        System.out.println("Average weight of bows: " + averageWeight);
    }

    public static double calculateAverageWeight(List<Bow> bows) {
        int totalWeight = 0;
        for (Bow bow : bows) {
            totalWeight += bow.getWeight();
        }
        return (double) totalWeight / bows.size();
    }
}
