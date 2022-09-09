package plants;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PlantInfo {

    final private List<Plant> plantList;
    public PlantInfo(){
        // initialize new list
        plantList = new ArrayList<>();

    }

    public void run() {
        // display curr version
        System.out.println("Plants, v 0.1");

        String user_command;
        Scanner sc = new Scanner(System.in);
        do{
            displayCommands();
            user_command = getUserInput(sc);
            handleCommand(user_command, sc);
        }
        while(!(user_command.equals("0")));
    }

    public void printList() {
        for (Plant plant : plantList) {
            plant.printPlant();
            System.out.println(", ");
        }
    }

    /*
    Displays the commands for the PlantInfo list:
    0 to quit
    1 to add new plant
    2 to lookup type
    3 to lookup zone
    4 to lookup by string or substring.
    Loops while 0 is not entered.
     */

    private void displayCommands() {
        System.out.println("\nEnter command:");
        System.out.println("0 to Quit");
        System.out.println("1 to Add");
        System.out.println("2 to Find by type");
        System.out.println("3 to Find by zone");
        System.out.println("4 to Find by name");
    }

    private String getUserInput(Scanner sc) {
        return sc.next();
    }

    private void handleCommand(String cmd, Scanner sc) {

        switch (cmd) {

            case "0":
                System.out.println("Exiting program ...");
                break;
            case "1":
                addPlant(sc);
                break;
            case "2":
                findType(sc);
                break;
            case "3":
                findZone(sc);
                break;
            case "4":
                findName(sc);
                break;
            default:
                System.out.println("Command not recognized. Try Again");
                break;
        }
    }

    private void findSciName(Scanner sc) {
        System.out.println("Enter one or two parts of the plant's scientific name (ie: Sequoia sempervirens -> S seq");
        String sciStub = sc.next();
    }

    /*
    Prompts user for new Plant characteristics.
    Using those characteristics, creates new plant and adds it to plantList.
     */
    private void addPlant(Scanner sc) {
        sc.useDelimiter("\n");
        System.out.print("\nEnter the common name of the plant: ");
        String commonName = sc.next();
        System.out.print("Enter the scientific name of the plant: ");
        String scientificName = sc.next();
        System.out.print("Enter the minimum planting zone of the plant: ");
        int minGrowZone = sc.nextInt();
        System.out.print("Enter the maximum planting zone of the plant: ");
        int maxGrowZone = sc.nextInt();
        System.out.print("Enter the type of the plant -- 0 for tree, 1 for perennial: ");
        int plantType = sc.nextInt();

        plantList.add(new Plant(commonName, scientificName, minGrowZone, maxGrowZone, plantType));
    }

    /*
    Public version of addPlant for testing
     */
    public void addPlant(String c_name,String s_name, int min, int max, int type) {
        plantList.add(new Plant(c_name,s_name,min,max,type));
    }

    /*
    Prompts user to enter plant type.
    Program goes through list and prints out plants with that type.
     */
    private void findType(Scanner sc) {
        System.out.print("Enter the type to match: (0 - TREE or 1 - PERENNIAL) ");
        int typeToFind = sc.nextInt();
        boolean plantsFound = false;
        System.out.println("Plants that might interest you: ");
        for (Plant plant : plantList) {
            if (plant.getPlantType() == typeToFind)
            {
                plantsFound = true;
                plant.printPlant();
            }
        }
        if (!plantsFound) {
            System.out.println("No plants like that found!");
        }
    }

    /*
    Public version of findType used for testing
     */
    public boolean findType(int typeToFind) {
        boolean plantsFound = false;
        for (Plant plant : plantList) {
            if (plant.getPlantType() == typeToFind)
            {
                plantsFound = true;
                plant.printPlant();
            }
        }
        if (!plantsFound) {
            System.out.println("No plants like that found!");
        }
        return plantsFound;
    }
    private void findZone(Scanner sc) {
        System.out.print("Enter zone to find: ");
        int zoneToFind = sc.nextInt();
        boolean plantsFound = false;
        System.out.println("Plants that might interest you: ");
        for (Plant plant : plantList) {
            if (plant.getMaxGrowZone() >= zoneToFind ||
                plant.getMinGrowZone() <= zoneToFind) {

                plantsFound = true;
                plant.printPlant();
            }
        }
        if (!plantsFound) {
            System.out.println("No plants like that found!");
        }
    }

    // Public version of findZone used for testing
    public boolean findZone(int zoneToFind) {
        boolean plantsFound = false;
        System.out.println("Plants that might interest you: ");
        for (Plant plant : plantList) {
            if (plant.getMaxGrowZone() >= zoneToFind &&
                    plant.getMinGrowZone() <= zoneToFind) {

                plantsFound = true;
                plant.printPlant();
            }
        }
        if (!plantsFound) {
            System.out.println("No plants like that found!");
        }
        return plantsFound;
    }
    private void findName(Scanner sc) {
        System.out.print("Enter the string to match: ");
        String searchName = sc.next();
        boolean plantsFound = false;

        System.out.println("Plants that might interest you: ");
        for (Plant plant : plantList) {

            // check is inputted search is found as substring with plant names, lowercase because contains is case-sens
            if ( (plant.getCommonName().toLowerCase().contains(searchName.toLowerCase())) ||
                    (plant.getScientificName().toLowerCase().contains(searchName.toLowerCase()))) {
                plantsFound = true;
                plant.printPlant();
            }
        }
        if (!plantsFound) {
            System.out.println("No plants like that found!");
        }
    }

    // Public version of findName
    public boolean findName(String searchName) {
        boolean plantsFound = false;

        System.out.println("Plants that might interest you: ");
        for (Plant plant : plantList) {

            // check is inputted search is found as substring with plant names, lowercase because contains is case-sens
            if ( (plant.getCommonName().toLowerCase().contains(searchName.toLowerCase())) ||
                    (plant.getScientificName().toLowerCase().contains(searchName.toLowerCase()))) {
                plantsFound = true;
                plant.printPlant();
            }
        }
        if (!plantsFound) {
            System.out.println("No plants like that found!");
        }
        return plantsFound;
    }
}