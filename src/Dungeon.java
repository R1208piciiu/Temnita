import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dungeon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //variabile de jucator
        int sanatate = 100;
        int atacDeterioare = 50;
        int nrpotiuni = 3;
        int valoareRegenerarePotiune = 30;
        int sansaPotiune = 50; // procentaj

        //variabile inamic
        String[] inamici = {"Zombie", "Skeleton", "Warrior", "Assasin"};
        int maxSanatateInamic = 75;
        int inamicAtacDeteriorare = 25;

        boolean running = true;
        System.out.println("Bine ai venit in temnita!");

        GAME:
        while(running) {
            System.out.println("______________________________________________");

            int sanataeInamic = rand.nextInt(maxSanatateInamic);
            String inamic = inamici[rand.nextInt(inamici.length)];

            System.out.println(" \t # " + inamic + " a aparut! # ");

            while (sanataeInamic > 0) {
                System.out.println("\tSanatatea ta este: " + sanatate);
                System.out.println("\tSanatatea inamicului " + inamic + " este: " + sanataeInamic);
                System.out.println("\t\n Ce ai vrea sa faci ?");
                System.out.println("\t1. Ataca ");
                System.out.println("\t2. Bea potiune ");
                System.out.println("\t3. Fugi ");

                String input = in.nextLine();
                if (input.equals("1")) {
                    // cod pentru actiunea de a ataca
                    int deterioareProdusa = rand.nextInt(atacDeterioare);
                    int deterioarePrimita = rand.nextInt(inamicAtacDeteriorare);

                    sanataeInamic -= deterioareProdusa;
                    sanatate -= deterioarePrimita;
                    System.out.println("\tL-ai lovit pe " + inamic + " cu " + deterioareProdusa + " deteriorare.");
                    System.out.println("\tAi primit " + deterioarePrimita + " deteriorare");

                    if (sanatate < 1) {
                        System.out.println("\tAi fost lovit prea tare, esti prea slabit sa continui.");
                        break;
                    }

                } else if (input.equals("2")) {
                    // cod pentru actiunea de a bea potiune
                    if (nrpotiuni > 0) {
                        sanatate += valoareRegenerarePotiune;
                        nrpotiuni--;
                        System.out.println(" \tAi baut o potiune, te-ai vindecat cu " + valoareRegenerarePotiune +
                                "\n\tAcum ai " + sanatate + " sanatate. " +
                                "\n\tTi-au ramas " + nrpotiuni + " potiuni. ");
                    } else {
                        System.out.println("\tNu mai ai potiuni! Invinge un inamic ca sa mai castigi potiuni. \n");
                    }
                } else if (input.equals("3")) {
                    // cod pentru actiunea de a fugi
                    System.out.println("\tAi fugit de " + inamic);
                    continue GAME;
                } else {
                    // cod pentru actiunea invalida
                    System.out.println("\tComanada invalida! ");
                }

            }

            if (sanatate < 1) {
                System.out.println("Te-au batut crunt in Temnita, esti prea slab. ");
                break;
            }

            System.out.println("________________________________________________");
            System.out.println(" # " + inamic + " a fost invins! # ");
            System.out.println(" # Ai " + sanatate + " sanatate. # ");

            if (rand.nextInt(100) < sansaPotiune) {
                nrpotiuni++;
                System.out.println(" # Ai castigay o potiune in urma infrangerii lui " + inamic + " ! # ");
                System.out.println(" # Mai ai potiuni" + nrpotiuni + " potiuni. # ");
            }

            System.out.println(" Ce ai vrea sa faci in continuare? ");
            System.out.println("1. Continui lupta ");
            System.out.println("2. Termina jocul ");
            String input = in.nextLine();

            while (! input.equals("1") && !input.equals("2")) {
                System.out.println("Comanda invalida! ");
                input = in.nextLine();
            }
            switch (input) {
                case "1": {
                    System.out.println(" Continui cu aventura! ");
                    break;
                }
                case "2" : {
                    System.out.println("\nAi ales sa iesi din Temnita. Drum bun! ");
                    break GAME;
                }
            }
        }
        System.out.println("###################################");
        System.out.println(" # Multumim de joc! # ");
        System.out.println("###################################");
    }
}