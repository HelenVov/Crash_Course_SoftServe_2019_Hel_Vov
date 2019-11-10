package OOP_Cat_Lec10;

public class HomeCat extends Cat implements Playable {
    private String master;
    String name = super.getName();
    String breed = super.getBreed();

    public HomeCat(String name, String breed) {
        super(name, breed);
    }

    public void display() {
        System.out.printf("Home cat: \n name: %s \n bree: %s\n", name, breed);
        master = "11.11.2019 - cat inspection\n";
        System.out.printf(master);
    }

    public void layOnSofa() {
        System.out.printf("Home cat %s lay on sofa\n", name, breed);
    }

    public void spoilShoes() {
        System.out.printf("Home cat %s spoil shoes\n", name, breed);
    }

    public void playBall() {
        System.out.printf("Home cat %s plays ball\n", name);
    }
}
