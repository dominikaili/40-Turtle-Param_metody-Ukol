package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {
    Turtle donatello;

    public void main(String[] args) {

        donatello = new Turtle();

        Color ciernaFarba = new Color(0, 0, 0);
        Color fialovaFarba = new Color(69, 12, 71);
        Color zltaFarba = new Color(255, 255, 0);
        Color cervenaFarba = new Color(255, 0, 0);
        Color modraFarba = new Color(65, 105, 225);


        donatello.setLocation(100, 400);
        donatello.turnLeft(180);

        nakresliRovnoramennyTrojuholnik(200, 40, fialovaFarba);

        donatello.turnRight(90);
        donatello.move(8);
        donatello.turnRight(90);
        donatello.move(10);
        nakresliKruh(4, zltaFarba);

        donatello.setLocation(420, 400);
        donatello.turnRight(90);
        nakresliKruh(6, ciernaFarba);
        donatello.turnLeft(180);
        nakresliKruh(4, ciernaFarba);
        pohybPoKruhu(4, 60);
        donatello.turnLeft(180);
        nakresliKruh(2, ciernaFarba);
        donatello.turnLeft(90);
        pohybPoKruhu(4, 30);
        donatello.turnLeft(90);
        nakresliKruh(1, ciernaFarba);
        donatello.turnRight(180);
        pohybPoKruhu(4, 60);
        donatello.turnRight(180);
        nakresliKruh(1, ciernaFarba);

        donatello.setLocation(820, 400);
        donatello.turnRight(180);

        nakresliObdlznik(120, 240, cervenaFarba);

        donatello.turnLeft(90);
        donatello.move(390);
        donatello.turnRight(90);
        donatello.move(120);
        donatello.turnRight(180);


        nakresliObdlznik(250, 150, cervenaFarba);

        donatello.turnRight(180);
        nakresliKruh(4, ciernaFarba);

        donatello.turnRight(90);
        donatello.move(230);
        donatello.turnRight(180);
        nakresliKruh(2, ciernaFarba);
        donatello.turnRight(180);
        donatello.move(100);
        donatello.turnRight(180);
        nakresliKruh(2, ciernaFarba);
        donatello.turnRight(180);
        donatello.move(60);
        donatello.turnLeft(90);
        donatello.move(40);
        donatello.turnRight(90);
        donatello.move(120);
        donatello.turnLeft(135);

        nakresliRovnoramennyTrojuholnik(120, 90, modraFarba);

        donatello.move(170);


    }

    public void nakresliObdlznik(double dlzkaStranyA, double dlzkaStranyB, Color farba) {
        Color povodnaFarba = donatello.getPenColor();
        donatello.setPenColor(farba);
        donatello.penDown();
        for (int i = 0; i < 2; i++) {
            donatello.move(dlzkaStranyA);
            donatello.turnLeft(90);
            donatello.move(dlzkaStranyB);
            donatello.turnLeft(90);
        }
        donatello.setPenColor(povodnaFarba);
        donatello.penUp();
    }

    public void nakresliKruh(double primer, Color farba) {
        Color povodnaFarba = donatello.getPenColor();
        donatello.setPenColor(farba);
        donatello.penDown();
        for (int i = 0; i < 120; i++) {
            donatello.move(primer);
            donatello.turnRight(3);
        }
        donatello.setPenColor(povodnaFarba);
        donatello.penUp();
    }

    public void pohybPoKruhu(double primer, int usek) {
        donatello.penUp();
        for (int i = 0; i < usek; i++) {
            donatello.move(primer);
            donatello.turnRight(3);
        }
        donatello.penDown();
    }


    public double vypocitajDlzkuTretejStrany(double dlzkaRamena, double uholMedziRamenami) {
        double tretiaStrana;
        tretiaStrana = Math.abs((dlzkaRamena
                * Math.sin((uholMedziRamenami * Math.PI / 180) / 2.0))
                * 2.0);
        return tretiaStrana;
    }

    public void nakresliRovnoramennyTrojuholnik(double dlzkaRamena, double uholMedziRamenami, Color farba) {
        Color povodnaFarba = donatello.getPenColor();
        donatello.setPenColor(farba);
        donatello.penDown();
        double vnutornyUholMedziZakladnouARamenom = (180 - uholMedziRamenami) / 2;

        donatello.turnLeft(90 - vnutornyUholMedziZakladnouARamenom);
        donatello.move(dlzkaRamena);
        donatello.turnLeft(180 - uholMedziRamenami);
        donatello.move(dlzkaRamena);
        donatello.turnLeft(180 - vnutornyUholMedziZakladnouARamenom);

        double dlzkaZakladne = vypocitajDlzkuTretejStrany(dlzkaRamena, uholMedziRamenami);
        donatello.move(dlzkaZakladne);
        donatello.turnLeft(90);

        donatello.setPenColor(povodnaFarba);
        donatello.penUp();
    }

}
