package com.company;

import javax.sound.sampled.AudioFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {

    private static List<Card> Cards = new ArrayList<>();
    private static List<Card> Races = new ArrayList<>();
    private static List<Card> Animals = new ArrayList<>();

    public static void main(String[] args) {
        beolvasas();
        feladat03();
        feladat04();
        feladat05();
        feladat06();
        feladat07();
        feladat08();
        feladat09();
    }

    public static void beolvasas() {
        try {
            FileReader fr = new FileReader("fantasycard.csv");
            BufferedReader br = new BufferedReader(fr);
            String first_line = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                Cards.add(new Card(
                        Integer.parseInt(split[0]),
                        split[1],
                        split[2],
                        split[3],
                        split[4]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void feladat03() {
        for (Card item : Cards) {
            if (item.getName().equals("Leeroy")) {
                System.out.println("3. Feladat: " + item.getRace() + " " + item.getCardClass() + "\n");
            }
        }
    }

    public static void feladat04() {
        Card legkisebb = Cards.get(0);
        Card legnagyobb = Cards.get(0);
        for (Card item : Cards) {
            if (item.getPower() > legnagyobb.getPower()) {
                legnagyobb = item;
            }
            if (item.getPower() < legkisebb.getPower()) {
                legkisebb = item;
            }
        }
        System.out.println("4. Feladat:");
        System.out.println(legkisebb.getPower() + ": " + legkisebb.getName());
        System.out.println(legnagyobb.getPower() + ": " + legnagyobb.getName() + "\n");
    }

    public static void feladat05() {
        for (Card item : Cards) {
            if (item.getRace().equals("Dwarf") && item.getPower() == 4000) {
                System.out.println("5. Feladat: " + item.getName() + "\n");
            }
        }
    }

    public static void feladat06() {
        System.out.println("6. Feladat: ");
        for (Card item : Cards) {
            if (item.getRace().equals("Orc") && item.getPower() > 4500 && item.getFaction().equals("Laughing Skull")) {
                System.out.println(item.getPower() + ": " + item.getName() + " " + item.getRace() + " " + item.getCardClass());
            }
        }
        System.out.println("\n");
    }

    public static void feladat07() {
        int human = 0, orc = 0, elf = 0, dwarf = 0;
        for (Card item : Cards) {
            switch (item.getRace()) {
                case "Human":
                    human++;
                    break;
                case "Orc":
                    orc++;
                    break;
                case "Elf":
                    elf++;
                    break;
                case "Dwarf":
                    dwarf++;
                    break;
            }
        }
        System.out.println("7. Feladat:");
        System.out.println("Human " + human + " db");
        System.out.println("Orc " + orc + " db");
        System.out.println("Elf " + elf + " db");
        System.out.println("Dwarf " + dwarf + " db\n");
    }

    public static void feladat08() {
        System.out.println("8. Feladat:");
        for (Card item : Cards) {
            Races.add(item);

            Iterator<Card> i = Races.iterator();
            while (i.hasNext()) {
                Card seged = i.next();
                if ((item.getPower() < seged.getPower()) && (item.getRace().equals(seged.getRace()))) {
                    i.remove();
                }

            }
        }
        for (Card item : Races) {
            System.out.println("Név: " + item.getName() + " Faj: " + item.getRace() + " Erő: " + item.getPower());
        }
    }

    public static void feladat09()
    {
        for (Card item: Cards)
        {
            if (item.getFaction().equals("Animal"))
            {
                Animals.add(item);
            }
        }
        Card seged;
        for (int i = 0; i < Animals.size(); i++) {
            for (int j = 0; j < Animals.size(); j++) {
                if (Animals.get(i).getPower() < Animals.get(j).getPower())
                {
                   seged = Animals.get(i);
                   Animals.set(i, Animals.get(j));
                   Animals.set(j,seged);

                }
            }
        }
        try
        {
            FileWriter writer = new FileWriter("animal.txt");
            for (Card item:Animals)
            {
                writer.write(item.getPower()+":"+item.getName()+":"+item.getRace()+":"+item.getCardClass()+"\n");
            }
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
