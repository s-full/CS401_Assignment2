package plants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlantInfoTest {

    PlantInfo tester1;
//    PlantInfo tester2;
//    PlantInfo tester3;
//    PlantInfo tester4;
//    PlantInfo tester5;

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @BeforeEach
    public void init() {
        tester1 = new PlantInfo();
        tester1.addPlant("Dandelion", "Taraxacum", 3, 10, 1);
        tester1.addPlant("Lion's Tail", "Leonotis leonurus",8,11,1);
        tester1.addPlant("Hairy Crabgrass","Digitaria sanguinalis",6,9,1);
        tester1.addPlant("Korean mountain magnolia","Magnolia sieboldii",6,8,0);
    }

    // test if PlantTest is being created
    @Test
    void getPlantTestTest() {
        PlantInfo testPlantInfo = new PlantInfo();
        Assertions.assertNotNull(testPlantInfo);
    }

    @Test
    void addPlantsTest() {
        Assertions.assertTrue(tester1.findName("Dandelion"));
    }

    @Test
    void subStringSearchTest() {
        Assertions.assertTrue((tester1.findName("lion")));
        Assertions.assertTrue((tester1.findName("grass")));
        Assertions.assertTrue((tester1.findName("a")));
    }

    @Test
    void zoneSearchTest() {
        Assertions.assertFalse(tester1.findZone(-1));
        Assertions.assertTrue(tester1.findZone(8));
    }

    @Test
    void typeSearchTest() {
        Assertions.assertFalse(tester1.findType(-1));
        Assertions.assertTrue(tester1.findType(0));
        Assertions.assertTrue(tester1.findType(1));
        Assertions.assertFalse(tester1.findType(2));
    }

    @Test
    void addingGarbage() {
        tester1.addPlant("asdfasdfasdf fadsfa","qerqwerqewr",-100,1000,7);
        Assertions.assertTrue(tester1.findName("asdf"));
    }

}