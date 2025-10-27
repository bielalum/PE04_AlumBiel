package Entregues.PE04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PE04_AlumBiel {

//Declarar variables globals
static String mainMenu,lightsMenu,selectRoom,roomName,washerMenu,selectProgram,washerMode,washingTime;
static boolean outProgram,livingRoom,kitchen,room1,room2,room3,restRoom,allLightstatus,outLights,outWasher,washerRunning;
    
    //Mètode per controlar les llums d'una habitació en concret (opció 1)
    public static boolean controlRoom (String nameRoom, boolean currentState, Scanner esc) {
                                      //Nom habitació     //Estat actual de la llum (true encesa, false apagada)
        while (true) { //Bucle fins que l'usuari introdueixi un valor correcte
        
            try {
            System.out.println();
            System.out.println(nameRoom);
            System.out.println("Encendre les llums (true) / Apagar les llums (false)");
            currentState = esc.nextBoolean();
            break;  //Si l'usuari ha introduït true o false surt del bucle i continua

            
            } catch (InputMismatchException e) {  //Si l'usuari escriu alguna cosa diferent surt error
                System.out.println();
                System.out.println("ERROR: si us plau, introdueix true o false");
                esc.nextLine();
            }
        }
                return currentState;  //Retorna el nou estat de la llum (encesa o apagada), depenent del que ha respost l'usuari

    }

    //Mètode per seleccionar el tipus de programa de la rentadora
    public static void startWasher(Scanner esc){

        System.out.println();
        System.out.println("Selecciona el programa que vols iniciar escrivint la seva lletra:");
        System.out.println();
        System.out.println("a) Standard");
        System.out.println("b) Eco");
        System.out.println("c) Turbo");
        selectProgram = esc.next();

            switch (selectProgram) {
                case "a":
                    washerMode = "standard";  //Mode o programa triat, que el guardo en una variable
                    washerRunning = true;  //Si la rentadora ha iniciat un programa, aquesta variable serà true (està en marxa)
                    washingTime = "90 min";  //Variable que indica el temps esperat
                    break;
                        
                 case "b":
                    washerMode = "eco";
                    washerRunning = true;
                    washingTime = "120 min";
                    break;

                case "c":
                    washerMode = "turbo";
                    washerRunning = true;
                    washingTime = "45 min";
                    break;
                                
            }
//Missatge que es mostra a l'usuari un cop triat un dels 3 modes
        System.out.println("Programa " + washerMode + " iniciat correctament");
    }                                   //Mode triat



    public static void main(String[] args) {
    Scanner esc = new Scanner(System.in);

        System.out.println();
        System.out.println("Benvingut a l'aplicació per domotitzar casa teva!");
            
        
        do { //Aquest és el menú inicial i es mostrarà sempre, per això un do
        System.out.println();
        System.out.println("Selecciona quina opció vols controlar escrivint la seva lletra:");
        System.out.println("a) Llum");
        System.out.println("b) Rentadora");
        System.out.println("c) Termòstat");
        System.out.println("d) Portes");
        System.out.println("e) Sortir");
        mainMenu = esc.next();
        
            
        switch (mainMenu) {

            case "a":  //Opció 1: Llums

                    do { //Al seleccionar controlar les  llums sempre es mostrarà aquest menú
                        System.out.println();
                        System.out.println("CONTROL DE LLUMS");
                        System.out.println();
                        System.out.println("Selecciona una opció escrivint la seva lletra:");
                        System.out.println();
                        System.out.println("a) Controlar una habitació");
                        System.out.println("b) Controlar totes les habitacions");
                        System.out.println("c) Mostrar l'estat de les llums");
                        System.out.println("d) Sortir");
                        lightsMenu = esc.next();

                        switch (lightsMenu) { //Creo un switch per poder triar ente les diferents opcions del menú de llums

                            case "a": //L'opció a és controlar una habitació en concret, i mostro les opcions:
                                System.out.println();
                                System.out.println("CONTROLAR UNA HABITACIÓ");
                                System.out.println();
                                System.out.println("Tria una habitació escrivint la seva lletra:");
                                System.out.println();
                                System.out.println("a) Menjador");
                                System.out.println("b) Cuina");
                                System.out.println("c) Lavabo");
                                System.out.println("d) Dormitori 1");
                                System.out.println("e) Dormitori 2");
                                System.out.println("f) Dormitori 3");
                                selectRoom = esc.next();
                                
                                switch (selectRoom) { //Creo un altre switch per tenir diferents opcions segons l'habitació triada 
                                    case "a":
                                        roomName="MENJADOR";  //La variabla roomName contindrà el text "MENJADOR"
                                        livingRoom=controlRoom(roomName, livingRoom, esc);
                                        //Crida al mètode controlRoom que he creat a dalt. Li passa la variable que conté el nom de l'habitació (roomName), la variable booleana que indica si la llum està encesa o apagada (livingRoom) i l'escàner per llegir què escriu l'usuari

                                        if (livingRoom) { //Si el menjador és true, té les llums enceses
                                        System.out.println();
                                        System.out.println("S'han encès les llums del menjador");
                                        System.out.println();
                                        }

                                        else{ //Sinó, estan apagades
                                        System.out.println();
                                        System.out.println("S'han apagat les llums del menjador");
                                        System.out.println();
                                        }

                                        break;
                                    

                                    //A partir d'aquí, fem el mateix amb la resta d'habitacions
                                    case "b":
                                        roomName = "CUINA";
                                        kitchen =  controlRoom(roomName, kitchen, esc);


                                        if (kitchen) {
                                        System.out.println();
                                        System.out.println("S'han encès les llums de la cuina");
                                        System.out.println();
                                        }

                                        else{
                                        System.out.println();
                                        System.out.println("S'han apagat les llums de la cuina");
                                        System.out.println();
                                        }

                                        break;

                                    case "c":
                                        roomName = "LAVABO";
                                        restRoom =  controlRoom(roomName, restRoom, esc);

                                        if (restRoom) {
                                        System.out.println();
                                        System.out.println("S'han encès les llums del lavabo");
                                        System.out.println();
                                        }

                                        else{
                                        System.out.println();
                                        System.out.println("S'han apagat les llums del lavabo");
                                        System.out.println();
                                        }                        
                                        break;

                                    case "d":
                                        roomName = "DORMITORI 1";
                                        room1 =  controlRoom(roomName, room1, esc);

                                        if (room1) {
                                        System.out.println();
                                        System.out.println("S'han encès les llums del dormitori 1");
                                        System.out.println();
                                        }

                                        else{
                                        System.out.println();
                                        System.out.println("S'han apagat les llums del dormitori 1");
                                        System.out.println();
                                        }                        
                                        break;

                                    case "e":
                                        roomName = "DORMITORI 2";
                                        room2 =  controlRoom(roomName, room2, esc);

                                        if (room2) {
                                        System.out.println();
                                        System.out.println("S'han encès les llums del dormitori 2");
                                        System.out.println();
                                        }

                                        else{
                                        System.out.println();
                                        System.out.println("S'han apagat les llums del dormitori 2");
                                        System.out.println();
                                        }                        
                                        break;

                                    case "f":
                                        roomName = "DORMITORI 3";
                                        room3 =  controlRoom(roomName, room3, esc);

                                        if (room3) {
                                        System.out.println();
                                        System.out.println("S'han encès les llums del dormitori 3");
                                        System.out.println();
                                        }

                                        else{
                                        System.out.println();
                                        System.out.println("S'han apagat les llums del dormitori 3");
                                        System.out.println();
                                        }                        
                                        break;
                                }

                                break; //Sortim del case a i tornem al menú principal de les llums
                        
                            case "b": //Segona opció, controlar totes les habitacions alhora
                            while (true) { //Bucle que repeteix la pregunta en cas que l'usuari escrigui un valor incorrecte
                                
                            try{ 
                                System.out.println();
                                System.out.println("CONTROLAR TOTES LES HABITACIONS");
                                System.out.println("");
                                System.out.println("Encendre totes les llums (true) / Apagar totes les llums (false)");
                                allLightstatus = esc.nextBoolean();  //Aquesta variable booleana pren la resposta de l'usuari (true o false)

                                //Assignem la resposta de l'usuari (true o false) a cada habitació, igualant amb la variable
                                livingRoom = allLightstatus;
                                kitchen = allLightstatus;
                                restRoom = allLightstatus;
                                room1 = allLightstatus;
                                room2 = allLightstatus;
                                room3 = allLightstatus;

                                if (allLightstatus) {
                                    System.out.println(); //Si la variable allLightstatus és true s'han encès totes les llums
                                    System.out.println("S'han encès totes les llums");
                                    System.out.println();

                                }
                                else{ //Sinó, s'han apagat
                                    System.out.println();
                                    System.out.println("S'han apagat totes les llums");
                                    System.out.println();
                                }

                                break; //Sortim de case b i tornem al menú principal de les llums
                            }
                            catch(InputMismatchException e){ //Si l'usuari escriu un valor que no es ni true ni false, mostra el següent missatge d'error i torna a començar el bucle
                                System.out.println();
                                System.out.println("ERROR: si us plau, introdueix true o false");
                                esc.nextLine();
                            }
                            
                        } break;

                            case "c":  //Tercera opció, mostrar l'estat de les llums
            
                            System.out.println();
                            System.out.println("ESTAT DE LES LLUMS");
                            System.out.println();
                            System.out.println("Menjador: " + (livingRoom ? "Enceses" : "Apagades")); //Si livingroom és true mostrarà "Enceses", i si és false mostrarà "Apagades"
                            System.out.println("Cuina: " + (kitchen ? "Enceses" : "Apagades"));       //Per defecte, com que les variables de les habitacions són booleanes, seràn false (Apagades)
                            System.out.println("Lavabo: " + (restRoom ? "Enceses" : "Apagades"));
                            System.out.println("Habitació 1: " + (room1 ? "Enceses" : "Apagades"));
                            System.out.println("Habitació 2: " + (room2 ? "Enceses" : "Apagades"));
                            System.out.println("Habitació 3: " + (room3 ? "Enceses" : "Apagades"));

                                break; //Sortim del case c i tornem al menú de llums

                            case "d": //Quarta opció, sortir del menú de llums
                                outLights = true; //Al assignar "true" a la variable, i posar un break, farà que surti del do i torni al menú principal de la casa domòtica
                                break;
                        

                        }
                    } while (outLights == false);   //Es repeteix el bucle (estem dins del menú de llums) mentre la variable outLights sigui falsa
                        break;                      //Només serà certa quan triem l'opció de sortir (case d)
                                                
            

        case "b":  //Segona opció, rentadora

            do{ //Aquest és el menú principal amb les opcions de la rentadora i es mostrarà sempre
                System.out.println();
                System.out.println("RENTADORA");
                System.out.println();
                System.out.println("Selecciona una opció escrivint la seva lletra");
                System.out.println("a) Iniciar un programa");
                System.out.println("b) Mostrar estat");
                System.out.println("c) Cancel·lar programa");
                System.out.println("d) Sortir");
                washerMenu = esc.next();


                switch (washerMenu) {
                    case "a": //La primera opció, iniciar un programa, pren el mètode startWasher creat anteriorment
                        startWasher(esc);

                    break; //Surt de case a i torna al menú

                    case "b": //La segona opció, mostra l'estat de la rentadora
                        System.out.println("La rentadora està " + (washerRunning ? "en funcionament" : "apagada")); //Si la variable booleana washerRunnin és true, vol dir que està en funcionament, sinó, està apagada
                        if (washerRunning) { //Si és true (està en funcionament) 
                            System.out.println("Programa: " + washerMode); //Mostra el mode o programa triat
                            System.out.println("Duració: " + washingTime); //Mostra la duració del programa

                        } else{} //Si washerRunning és false (està apagada), no mostra res

                    break; //Surt de case b i torna al menú


                    case "c": //La tercera opció, serveix per cancel·lar el programa
                        
                        washerRunning = false; //Al triar aquesta opció, la variable washerRunning passa a ser false (rentadora apagada)
                        System.out.println("Programa " + washerMode + " cancel·lat"); //Mostra el missatge del programa que s'ha cancel·lat
                        break; //Surt de case c i torna al menú
                
              
                    case "d": //La quarta opció, sortir al menú principal de la casa domòtica
                        outWasher = true; //Funciona igual que en les llums
                        break;

                }

            } while (outWasher == false); //Mateix funcionament que en les llums

                break;


        case "e":  //Última opció del menú principal del la casa domòtica, sortir del programa i tancar l'escàner
        System.out.println();
        System.out.println("Sortint del programa..."); //Missatge de sortida
        outProgram = true;  // Aquesta opció és per sortir del programa, per tant al assignar "true" a la variable, farà que surti del do
        esc.close();
        break;

    
        }

        } while (outProgram == false);   //Es repeteix el bucle mentre la variable outProgram sigui falsa
                                         //Només serà certa quan triem l'opció de sortir del programa (case e)
    }

}