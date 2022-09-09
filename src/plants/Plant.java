package plants;

public class Plant {
    final private String commonName;
    final private String scientificName;
    final private int plantType;
    final private int minGrowZone;
    final private int maxGrowZone;

    public Plant(String _commonName, String _scientificName, int _minGrowZone, int _maxGrowZone, int _plantType ) {
        commonName = _commonName;
        scientificName = _scientificName;
        minGrowZone = _minGrowZone;
        maxGrowZone = _maxGrowZone;
        plantType = _plantType;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public int getPlantType() {
         return plantType;
    }

    public int getMinGrowZone() {
        return minGrowZone;
    }

    public int getMaxGrowZone() {
        return maxGrowZone;
    }

    public void printPlant(){
        System.out.println(getCommonName() +" (" + getScientificName() + ") : " +
                (plantType == 0 ? "TREE" : "PERENNIAL") + ", zones " + getMinGrowZone() + "-" +
                getMaxGrowZone());
    }
}
