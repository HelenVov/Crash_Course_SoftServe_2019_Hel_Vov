package OOP_Cat_Lec10;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HomeCat homeCat = new HomeCat("Piti", "Maine Coon");
        WildCat wildCatOne = new WildCat("Niki", "Lion");
        WildCat wildCatTwo = new WildCat("Oni", "Panther");
        homeCat.playBall();
        homeCat.layOnSofa();
        homeCat.spoilShoes();
        wildCatOne.playBall();
        wildCatOne.hatePeople();
        ArrayList<Cat> listCat = new ArrayList<Cat>();
        listCat.add(homeCat);
        listCat.add(wildCatOne);
        listCat.add(wildCatTwo);
        for (Cat item : listCat) {
            item.display();
        }
    }
}
