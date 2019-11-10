package OOP_Cat_Lec10;

public class WildCat extends Cat implements Playable {
    String name = super.getName();
    String breed = super.getBreed();

    public WildCat(String name, String breed) {
        super(name, breed);
    }

    public void display() {
        System.out.printf("Wild cat: \n name: %s \n bree: %s\n", name, breed);
    }

    public void hatePeople() {
        System.out.printf("Wild cat %s - hate people. \n", name);
    }

    public void playBall() {
        System.out.printf("Wild cat %s plays ball.\n", name);
    }
}
