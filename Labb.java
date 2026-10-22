import java.util.Scanner;

public class Labb {
    CrewMembers[] crewMembers = {new Mechanic(), new Scout(), new Scientist()};

    SpaceStation spaceStation = new SpaceStation();

    boolean isOnFire = true;

    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();

    void enter() {
        System.out.println("Ni har kommit till labbet och ni märker av att det finns en eld som är ganska intensiv och om den inte släks så kommer all syre att ta slut.");

        int crewIndex = -1;
        while (crewIndex < 0 || crewIndex > 2) {
            System.out.println("Välj vem som ska lösa problemet i detta rummet. \n1. Mechanic \n2. Scout \n3. Scientist");
            switch (input.nextInt()) {
                case 1:
                    crewIndex = 0;
                    break;
                    
                case 2:
                    crewIndex = 1;
                    break;
                    
                case 3:
                    crewIndex = 2;
                    break;

                default:
                    System.out.println("Du valde fel, testa igen.");
            }        
        }

        while (isOnFire == true) {
            int option = 0;

            if (crewIndex != 2)
            {
                System.out.println(crewMembers[crewIndex].role + " ska försöka att släka elden, vilket sätt kommer de att försöka släka elden? \n1. använda brandsläkare \n2. använda brandfilt");
                option = input.nextInt();
            }
            else if (crewIndex == 2) {
                System.out.println(crewMembers[crewIndex].role + " ska försöka att släka elden, vilket sätt kommer de att försöka släka elden? \n1. använda brandsläkare \n2. använda brandfilt \n3. använda en av kemikalierna");
                option = input.nextInt();
            }

            if (option == 1) {
                System.out.println("Du försökte använda brandsläkaren men det gjorde så att elden exploderade och att alla av er dog! \nGAME OVER");
                break;
            }
            else if (option == 2) {
                System.out.println("Du försökte kväva elden med en eld filt men det gjorde bara elden starkare vilket gjorde att syret gick helt och hållet bort och att ni kvädes av syrebristen och koldioxiden! \nGAME OVER");
                break;
            }
            else if (option == 3 && crewIndex == 2) {
                System.out.println(crewMembers[crewIndex].role + " kolla på kemikale hyllan och ser 4 kemikalier dessa är: ");
                for (Chemicals chemicals : Chemicals.values()) {
                    System.out.print(chemicals + " ");
                }
                System.out.println("");
                System.out.println("Välje en av kemiklierna för att förska släka elden");
                String options = input.next().toUpperCase();

                try {
                    Chemicals chemicals = Chemicals.valueOf(options);
    
                    switch (chemicals) {
                        case DRYPOWDER:
                                System.out.println("Du tog DRYPOWDER och kasstade över elden vilket gjorde att elden sloknade");
                                isOnFire = false;
                            break;
    
                        case MAGNESIUM: 
                                System.out.println("Du tog MAGNESIUM och kasstade över elden detta gjorde elden starkare och dra mer syre, försök igen");
                                spaceStation.oxygenBurnPerTurn(30);
                            break;
    
                        case POTASSIUM:
                                System.out.println("Du tog POTASSIUM och kasstade över elden detta gjorde elden starkare och dra mer syre, försök igen");
                                spaceStation.oxygenBurnPerTurn(30);
                                System.out.println(spaceStation.oxygenLevel);
                            break;
    
                        case TITANIUM:
                                System.out.println("Du tog TITANIUM och kasstade över elden detta gjorde elden starkare och dra mer syre, försök igen");
                                spaceStation.oxygenBurnPerTurn(30);
                                System.out.println(spaceStation.oxygenLevel);
                            break;
                    
                        default:
                                System.out.println("Det är inget alternativ försök igen");
                                spaceStation.oxygenBurnPerTurn(20);
                                System.out.println(spaceStation.oxygenLevel);
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Detta är ingen av alternativen");
                }
            }
            else {
                System.out.println("Du har valt ett icke valbart alternativ");
            }
        }

        // behövs sättas i en while om spelet inte blir GAME OVER!
        System.out.println("Elden har sloknat och syre nivån är stabil, det finns fortfarande kemikalier på golvet skulle du vilja tårka upp det? (ja/ nej)");

        String yesorNo = input.next().toLowerCase();

        if (yesorNo.equals("ja")) {
            System.out.println("Du städar upp kemikalierna");
        }
        else if (yesorNo.equals("nej")) {
            System.out.println("Du städade inte upp kemiklierna och detta kan ha konsikvenser senare");
        }
        else {
            System.out.println("Du har valt ett icke valbart alternativ");
        }
    }
}