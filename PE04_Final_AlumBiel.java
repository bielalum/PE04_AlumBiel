package Entregues.PE04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PE04_Final_AlumBiel {

//Declarar variables globals
static String mainMenu,lightsMenu,selectRoom,roomNameLights,washerMenu,selectProgram,washerMode,washingTime,selectRoomTemp,tempMenu,controlSpecificTemp,roomNameTemp,doorsMenu,selectDoor,doorName;
static boolean outProgram,livingRoom,kitchen,restRoom,room1,room2,room3,allLightstatus,outLights,outWasher,washerRunning,outTemp,answerTemp,outDoors,lockDoor,livingRoomDoorLocked,kitchenDoorLocked,restRoomDoorLocked,room1DoorLocked,room2DoorLocked,room3DoorLocked,garageDoorLocked,allDoorsStatus;
static int tempLivingRoom=20,tempKitchen=20,tempRestRoom=20,tempRoom1=20,tempRoom2=20,tempRoom3=20,newTemp,allRoomsTemp,currentHour,currentMinute,currentSecond,lockHour,lockMinute,lockSecond;
    
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

    //Mètode per a controlar la temperatura d'una habitació en específic
    public static int temperatureRoom(String roomNameTemp, int currentTemp, Scanner esc ){
                                  //Nom de l'habitació  //Temperatura actual
        
        boolean exit = false; //Variable que controla quan sortir del menú         

        do{ //Aquest menú amb les diverses opcions es mostra sempre
        System.out.println();
        System.out.println("CONTROL DE TEMPERATURA - " + roomNameTemp);
        System.out.println();
        System.out.println("Selecciona una opció escrivint la seva lletra:");
        System.out.println("a) Temperatura manual");
        System.out.println("b) Augmentar temperatura +1ºC");
        System.out.println("c) Disminuir temperatura -1ºC");
        System.out.println("d) Sortir");
        controlSpecificTemp = esc.next();

            switch (controlSpecificTemp) {
                
                case "a":

                    while (true) {//Bucle que es repeteix fins que el número introduit no doni error
                        
                        try{
                            System.out.println();
                            System.out.println("Temperatura actual: " + currentTemp + "ºC");
                            System.out.println("Introdueix la temperatura desitjada: ");
                            newTemp = esc.nextInt();

                            if (newTemp >=5 && newTemp <= 35) { //Comprova que la temperatura estigui dins del rang admès
                                
                                if (newTemp > currentTemp) { //Si la nova temperatura és superior a la actual s'augmenta
                                    System.out.println();
                                    for (int x = currentTemp; x < newTemp; x ++){ //Bucle per augmentar 1 a 1 la temperatura
                                        System.out.println("Augmentant temperatura a " + (x + 1) + " ºC");
                                        currentTemp = x + 1; //Actualitza la temperatura actual sumant-li 1 cada vegada que es suma
                                    }
                                    System.out.println();
                                    System.out.println("Temperatura actual: " + newTemp + " ºC");
                                }    

                                else if (newTemp < currentTemp){ //Aquest bucle fa el mateix, però a l'inrevés, ja que disminueix -1
                                    System.out.println();
                                    for (int x = currentTemp; x > newTemp; x --){
                                        System.out.println("Disminuint temperatura a " + (x - 1) + " ºC");                                    
                                        currentTemp = x - 1;
                                    }  
                                    System.out.println();
                                    System.out.println("Temperatura actual: " + newTemp + " ºC");                      
                                }

                                else{ //Si no es compleix res de l'anterior, vol dir que la temperatura és la mateixa que ja està posada
                                    System.out.println("La temperatura ja és de " + currentTemp + " ºC");
                                }
                                break; //Surt del bucle i torna al menú anterior

                            }

                            else{ //Si la temperatura no està dins del rang, mostra aquest missatge:
                                System.out.println();
                                System.out.println("ERROR: La temperatura ha d'estar entre 5 i 35 ºC.");
                            }
                        }

                        catch (InputMismatchException e) { //Mostra aquest missatge si s'introdueix un número decimal
                            System.out.println();
                            System.out.println("ERROR: Introdueix un número enter.");
                            esc.nextLine();
                        }

                        catch (Exception e) { //Mostra aquest missatge per a errors no contemplats
                            System.out.println();
                            System.out.println("ERROR: Error desconegut, torna a introduïr el número.");
                            esc.nextLine();
                        }
                    }
                    break; //Surt del bucle i torna al menú anterior
            
                case "b": //Augmentar la temperatura +1

                    while (true) {

                            if (currentTemp == 35) { //Si la temperatura actual és 35, vol dir que està al màxim
                                System.out.println();
                                System.out.println("La temperatura està al màxim, no es pot augmentar més.");
                                answerTemp = false;
                                break;
                            }
                            System.out.println();
                            System.out.println("Vols augmentar la temperatura + 1ºC? (Si = True) / (No = False)");

                            try{

                                answerTemp = esc.nextBoolean(); //Llegeix la resposta    

                                if (answerTemp) { //Si la resposta és true augmenta +1ºC

                                    currentTemp ++;
                                    System.out.println();
                                    System.out.println("Temperatura augmentada a " + currentTemp + " ºC");                            
                                    System.out.println();

                                    if (currentTemp == 35) { //Si arriba a 35 ha arribat al màxim
                                    System.out.println();
                                    System.out.println("La temperatura ha arribat al màxim, no es pot seguir augmentant.");
                                    System.out.println("Tornant al menú...");
                                    break;
                                    }

                                }

                                else { //Si responem false torna al menú
                                    System.out.println();
                                    System.out.println("Tornant al menú...");
                                    System.out.println();
                                    break;
                                }
                            }

                            catch (InputMismatchException e){ //Mostra aquest missatge si no s'escriu true o false
                                System.out.println();
                                System.out.println("ERROR: Escriu true o false.");
                                esc.nextLine();                     

                            }

                            catch (Exception e) { //Mostra aquest missatge per a errors no esperats
                                System.out.println();
                                System.out.println("ERROR: Error desconegut, torna a introduïr el número.");
                                esc.nextLine();
                            }
                    }

                    break;


                case "c":
                    while (true) { //Aquí és el mateix, però diminuir la temperatura -1ºC

                            if (currentTemp == 5) {
                                System.out.println();
                                System.out.println("La temperatura està al mínim, no es pot disminuir més.");
                                answerTemp = false;
                                break;
                            }
                            System.out.println();
                            System.out.println("Vols disminuir la temperatura - 1ºC? (Si = True) / (No = False)");

                            try{

                                answerTemp = esc.nextBoolean();     

                                if (answerTemp) {

                                    currentTemp --;
                                    System.out.println();
                                    System.out.println("Temperatura disminuida a " + currentTemp + " ºC");                            
                                    System.out.println();

                                    if (currentTemp == 5) {
                                    System.out.println();
                                    System.out.println("La temperatura ha arribat al mínim, no es pot seguir disminuint.");
                                    System.out.println("Tornant al menú...");
                                    break;
                                    }

                                }

                                else {
                                    System.out.println();
                                    System.out.println("Tornant al menú...");
                                    System.out.println();
                                    break;
                                }
                            }

                            catch (InputMismatchException e){
                                System.out.println();
                                System.out.println("ERROR: Escriu true o false.");
                                esc.nextLine();                     

                            }

                            catch (Exception e) {
                                System.out.println();
                                System.out.println("ERROR: Error desconegut, torna a introduïr el número.");
                                esc.nextLine();
                            }
                    }

                    break;

                case "d": //Opció per sortir del menú
                    exit = true; //Assigna true a la variable exit per sortir del menú
                    break;      
            }
    
        }while (!exit); //El menú es repeteix mentre exit no sigui true
            return currentTemp; // Retorna la temperatura actualitzada de l'habitació
    }

    //Mètode per seleccionar una porta en específic
    public static boolean controlDoor(String doorName, boolean currentState, Scanner esc){
        while (true) { //Bucle perque torni a fer la pregunta en cas d'error
            try {
                System.out.println();
                System.out.println("CONTROLAR PORTA - " + doorName);
                System.out.println("Vols bloquejar o desbloquejar la porta? (Bloquejar = True) / (Desbloquejar = False)");
                lockDoor = esc.nextBoolean();

                if (lockDoor) { //Si la resposta és true, la porta es bloqueja
                    currentState = true; //S'actualitza l'estat de la porta a bloquejada
                    System.out.println();
                    System.out.println("La porta s'ha bloquejat.");
                    }

                else{ //Si la resposta és false, es desbloqueja
                    currentState = false; //S'actualitza l'estat de la porta a desbloquejada
                    System.out.println();
                    System.out.println("La porta s'ha desbloquejat");
                }

                break; //Surt del bucle quan s'ha respost bé

            }catch (InputMismatchException e){ //Si escrivim una altre cosa en comptes de true o false, mostra aquest missatge
                System.out.println();
                System.out.println("ERROR: Escriu true o false.");
                esc.nextLine(); //Neteja el buffer
            }

            catch (Exception e){ //Altres errors no considerats
                System.out.println();
                System.out.println("ERROR: Error desconegut, torna a introduïr true o false.");
                esc.nextLine();
            }
        }

        return currentState; //Retorna el valor actualitzat de la variable currentState segons el que hem respost
    }

    //Mètode per programar el bloqueig d'una porta
    public static void programLock(Scanner esc) {
        System.out.println();
        //Menú per seleccionar la portar a la que volem programar el bloqueig
        System.out.println("PROGRAMAR BLOQUEIG DE PORTES");
        System.out.println();
        System.out.println("Selecciona a quina porta vols programar el bloqueig escrivint la seva lletra:");
        System.out.println();
        System.out.println("a) Menjador");
        System.out.println("b) Cuina");
        System.out.println("c) Lavabo");
        System.out.println("d) Dormitori 1");
        System.out.println("e) Dormitori 2");
        System.out.println("f) Dormitori 3");     
        System.out.println("g) Garatge");    
        selectDoor = esc.next();

        switch (selectDoor) { 
            case "a": //Si triem la a, és la porta del menjador, i assignem el nom "MENJADOR" a la variable doorName
                doorName = "MENJADOR";
                break;

        //Fem el mateix per la resta d'habitacions:

            case "b":
                doorName = "CUINA";
                break;

            case "c":
                doorName = "LAVABO";
                break;
                
            case "d":
                doorName = "DORMITORI 1";
                break;
                
            case "e":
                doorName = "DORMITORI 2";
                break;
                
            case "f":
                doorName = "DORMITORI 3";
                break;
                
            case "g":
                doorName = "GARATGE";
                break;                
        }

        try {
            //Primer demanem a la hora, els minuts i els segons actuals:
            System.out.println();
            System.out.println("Introdueix l'hora actual (0-23):");
            currentHour = esc.nextInt();

            System.out.println();
            System.out.println("Introdueix els minuts actuals (0-59):");
            currentMinute = esc.nextInt();

            System.out.println();
            System.out.println("Introdueix els segons actuals (0-59):");
            currentSecond = esc.nextInt();            
        
        //Perquè no hi hagi confusions he assignat 23h com a màxim, 59min i 59 segons
        //Si el valor de la hora, els minuts o els segons està fora del rang mostra aquest missatge d'error:
        if (currentHour < 0 || currentHour > 23 || currentMinute <0 || currentMinute > 59 || currentSecond < 0 || currentSecond > 59 ) {
            System.out.println();
            System.out.println("ERROR: L'hora, els minuts o els segons introduits estan fora del rang.");
            System.out.println("Si us plau, introdueix les dades de nou:");
            return; //Si les dades no són vàlides, el mètode acaba i torna a començar, ja que sinó continuaria
        }
            //Ara introduïm la hora, minuts i segons a la que volem que es bloquegi la porta
            System.out.println();
            System.out.println("Introdueix l'hora de bloqueig (0-23):");
            lockHour = esc.nextInt();

            System.out.println();
            System.out.println("Introdueix els minuts de bloqueig (0-59):");
            lockMinute = esc.nextInt();

            System.out.println();
            System.out.println("Introdueix els segons de bloqueig (0-59):");
            lockSecond = esc.nextInt();    

        //Si la hora actual és superior o exactament igual a la hora de bloqueig, mostra aquest missatge d'error
        if ((lockHour < currentHour) || (lockHour == currentHour && lockMinute < currentMinute) || (lockHour == currentHour && lockMinute == currentMinute && lockSecond <= currentSecond)) {
            System.out.println();
            System.out.println("ERROR: L'hora de bloqueig ha de ser posterior a l'hora actual");
            return; //Si les dades no són vàlides, el mètode acaba i torna a començar, ja que sinó continuaria
        }
    
        System.out.println();
        System.out.println("Simulant el pas del temps...");
        for (int hour = 0; hour < 24; hour++){ //Bucle que simula les hores del dia

            for (int minute = 0; minute <60; minute++){ //Bucle que simula els minuts del dia

                for (int second = 0; second <60; second++){ //Bucle que simula els segons del dia

                    //Comprovem si l'hora, minuts i segons actuals coincideixen amb els de bloqueig, si es així mostra el missatge
                    //En aquest cas és una simulació i el temps passa al moment, però en un cas real compararia el temps real amb el de bloqueig fins que coincidissin
                    if (hour == lockHour && minute == lockMinute && second == lockSecond){
                        System.out.println();
                        System.out.println("Ja ha arribat l'hora del bloqueig");

                        switch (selectDoor) {
                            case "a":
                                livingRoomDoorLocked = true; //Assigna true (bloqueja) a la porta triada, en aquest cas la del menjador
                                break;

                        //El mateix amb la resta d'habitacions:

                            case "b":
                                kitchenDoorLocked = true;
                                break;

                            case "c":
                                restRoomDoorLocked = true;
                                break;

                            case "d":
                                room1DoorLocked = true;
                                break;

                            case "e":
                                room2DoorLocked = true;
                                break;

                            case "f":
                                room3DoorLocked = true;
                                break;
                                
                            case "g":
                                garageDoorLocked = true;
                                break;                                
                        }

                        System.out.println("Porta bloquejada");
                        return; //Un cop bloquejada, surt del mètode
                    }
                }
            }
        }
        //Si introduïm un nombre decimal mostra aquest missatge d'error
        }catch (InputMismatchException e){
            System.out.println("ERROR: Introdueix un número enter");
            esc.nextLine();

        //Errors no contemplats
        }catch (Exception e){
            System.out.println("ERROR: Error desconegut, torna a introduïr el número.");
            esc.nextLine();
        }

    }


    public static void main(String[] args) {
    Scanner esc = new Scanner(System.in);

        System.out.println();
        System.out.println("Benvingut a l'aplicació per domotitzar casa teva!");
            
        
        do { //Aquest és el menú inicial i es mostrarà sempre, per això un do
        System.out.println("CASA DOMÒTICA");
        System.out.println();
        System.out.println("Selecciona quina opció vols controlar escrivint la seva lletra:");
        System.out.println("a) Llum"); //Sense bucles
        System.out.println("b) Rentadora"); //Sense bucles
        System.out.println("c) Termòstat"); //Amb bucles
        System.out.println("d) Portes"); //Amb bucles
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
                                        roomNameLights="MENJADOR";  //La variabla roomNameLights contindrà el text "MENJADOR"
                                        livingRoom=controlRoom(roomNameLights, livingRoom, esc);
                                        //Crida al mètode controlRoom que he creat a dalt. Li passa la variable que conté el nom de l'habitació (roomNameLights), la variable booleana que indica si la llum està encesa o apagada (livingRoom) i l'escàner per llegir què escriu l'usuari

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
                                        roomNameLights = "CUINA";
                                        kitchen =  controlRoom(roomNameLights, kitchen, esc);


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
                                        roomNameLights = "LAVABO";
                                        restRoom =  controlRoom(roomNameLights, restRoom, esc);

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
                                        roomNameLights = "DORMITORI 1";
                                        room1 =  controlRoom(roomNameLights, room1, esc);

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
                                        roomNameLights = "DORMITORI 2";
                                        room2 =  controlRoom(roomNameLights, room2, esc);

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
                                        roomNameLights = "DORMITORI 3";
                                        room3 =  controlRoom(roomNameLights, room3, esc);

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

        case "c": //Tercera opció, controlar el termòstat
        do{ //Aquest menú es mostrarà sempre
            System.out.println();
            System.out.println("TERMÒSTAT");
            System.out.println();
            System.out.println("Selecciona una opció escrivint la seva lletra: ");
            System.out.println();
            System.out.println("a) Controlar una habitació");
            System.out.println("b) Controlar totes les habitacions");
            System.out.println("c) Mostrar la temperatura actual");
            System.out.println("d) Sortir");
            tempMenu = esc.next();

            switch (tempMenu) {
                case "a": //Primera opció, controlar una habitació
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
                    selectRoomTemp = esc.next();    

                    switch (selectRoomTemp) {
                        case "a": //Si triem el menjador:
                            roomNameTemp = "MENJADOR"; //Assigna "MENJADOR" a la variable roomNameTemp
                            tempLivingRoom = temperatureRoom(roomNameTemp, tempLivingRoom, esc);
                            //Assigna el mètode temperatureRoom per modificar la temperatura del menjador
                            break;

                        //El mateix amb la resta d'habitacions:

                        case "b":
                            roomNameTemp = "CUINA";
                            tempKitchen = temperatureRoom(roomNameTemp, tempKitchen, esc);
                            break;

                        case "c":
                            roomNameTemp = "LAVABO";
                            tempRestRoom = temperatureRoom(roomNameTemp, tempRestRoom, esc);
                            break;
                            
                        case "d":
                            roomNameTemp = "DORMITORI 1";
                            tempRoom1 = temperatureRoom(roomNameTemp, tempRoom1, esc);
                            break;
                            
                        case "e":
                            roomNameTemp = "DORMITORI 2";
                            tempRoom2 = temperatureRoom(roomNameTemp, tempRoom2, esc);
                            break;
                            
                        case "f":
                            roomNameTemp = "DORMITORI 3";
                            tempRoom3 = temperatureRoom(roomNameTemp, tempRoom3, esc);
                            break;                            
                                                 
                    }

                    break;                        
                   
                    
                case "b":
                    System.out.println();
                    System.out.println("CONTROLAR TOTES LES HABITACIONS");
                while (true) { //Bucle que es repeteix fins que no es cometen errors

                    try {
                        System.out.println();
                        System.out.println("Escriu la temperatura que vols establir per a totes les habitacions: ");
                        allRoomsTemp = esc.nextInt();

                        //Si la temperatura introduïda està entre 5 i 35 (valors correctes):
                        if (allRoomsTemp >= 5 && allRoomsTemp <= 35) {
                        
                        //Assignem aquesta temperatura a una variable per a totes les habitaciosn
                        tempLivingRoom = allRoomsTemp;
                        tempKitchen = allRoomsTemp;
                        tempRestRoom = allRoomsTemp;
                        tempRoom1 = allRoomsTemp;
                        tempRoom2 = allRoomsTemp;
                        tempRoom3 = allRoomsTemp;   

                        System.out.println();
                        System.out.println("La temperatura de totes les habitacions és de: " + allRoomsTemp + " ºC.");                            
                        
                        break;
                    }
                        else { //Si no es compleix la condició, vol dir que el número introduit no està dins el rang
                            System.out.println();
                            System.out.println("ERROR: La temperatura ha de ser entre 5 i 35 ºC.");
                        }


                    } //Si s'introdueix un decimal mostra aquest missatge d'error:
                    catch (InputMismatchException e){
                        System.out.println();
                        System.out.println("ERROR: Introdueix un número enter.");
                        esc.nextLine();
                    }
                    catch (Exception e){ //Errors no considerats
                        System.out.println();
                        System.out.println("ERROR: Error desconegut, torna a introduïr el número.");
                        esc.nextLine();
                    }
                    
                }
                    break;

                case "c": //Mostra la temperatura de cada habitació:
                    System.out.println();
                    System.out.println("TEMPERATURA ACTUAL");
                    System.out.println();        
                    System.out.println("Menjador: " + tempLivingRoom + "ºC");
                    System.out.println("Cuina: " + tempKitchen + "ºC");
                    System.out.println("Lavabo: " + tempRestRoom + "ºC");
                    System.out.println("Dormitori 1: " + tempRoom1 + "ºC");
                    System.out.println("Dormitori 2: " + tempRoom2 + "ºC");
                    System.out.println("Dormitori 3: " + tempRoom3 + "ºC");                            
                    break;

                case "d": //Opció per sortir del menú 
                    outTemp = true; //Assigna true a la variable, sortint així del bucle
                    break;

            }

        } while (!outTemp); //El bucle es repeteix mentre outTemp no sigui true
            break;


        case "d": //Quarta opció, control de portes
            do{ //Aquest és el menú principal i es mostrarà sempre:
                System.out.println();
                System.out.println("CONTROL DE PORTES");
                System.out.println();
                System.out.println("Selecciona una opció escrivint la seva lletra: ");
                System.out.println();
                System.out.println("a) Controlar una porta");
                System.out.println("b) Controlar totes les portes");
                System.out.println("c) Programar bloqueig");
                System.out.println("d) Mostrar estat de les portes");
                System.out.println("e) Sortir");
                doorsMenu = esc.next();

                switch (doorsMenu) { 
                    case "a": //Si triem la primera opció (controlar una porta), apareix aquest menú per triar quina
                        System.out.println();
                        System.out.println("CONTROLAR UNA PORTA");
                        System.out.println();
                        System.out.println("Selecciona una porta a controlar escrivint la seva lletra:");
                        System.out.println();
                        System.out.println("a) Menjador");
                        System.out.println("b) Cuina");
                        System.out.println("c) Lavabo");
                        System.out.println("d) Dormitori 1");
                        System.out.println("e) Dormitori 2");
                        System.out.println("f) Dormitori 3");     
                        System.out.println("g) Garatge");    
                        selectDoor = esc.next();
                        
                        switch (selectDoor) {
                            case "a": //La primera opció és la porta del menjador
                                doorName = "MENJADOR"; //Donem el nom "menjador" a la variable doorname
                                livingRoomDoorLocked = controlDoor(doorName, livingRoomDoorLocked, esc);
                                //Assignem el mètode creat anteriorment a la variable de l'habitació
                                //Aquest mètode, conté el nom de l'habitació, si està bloquejada o no, i la resposta introduida per l'usuari
                                break; //Surt del case a i torna al menú anterior

                        //Repetim el mateix amb la resta d'habitacions:

                            case "b":
                                doorName = "CUINA";
                                kitchenDoorLocked = controlDoor(doorName, kitchenDoorLocked, esc);
                                break;

                            case "c":
                                doorName = "LAVABO";
                                restRoomDoorLocked = controlDoor(doorName, restRoomDoorLocked, esc);
                                break;

                            case "d":
                                doorName = "DORMITORI 1";
                                room1DoorLocked = controlDoor(doorName, room1DoorLocked, esc);
                                break; 
                                
                            case "e":
                                doorName = "DORMITORI 2";
                                room2DoorLocked = controlDoor(doorName, room2DoorLocked, esc);
                                break;  
                                
                            case "f":
                                doorName = "DORMITORI 3";
                                room3DoorLocked = controlDoor(doorName, room3DoorLocked, esc);
                                break;
                                
                            case "g":
                                doorName = "GARATGE";
                                garageDoorLocked = controlDoor(doorName, garageDoorLocked, esc);
                                break;                                
                        }
                        break; //Surt d'aquest menú i torna a l'anterior



                    case "b": //Segona opció per bloquejar o desbloquejar totes les portes alhora

                        while (true) { //Bucle perquè es repeteixi la pregunta si responem malament
                            try {
                                System.out.println();
                                System.out.println("Vols bloquejar o desbloquejar totes les portes? (Bloquejar = True) / (Desbloquejar = False)");
                                allDoorsStatus = esc.nextBoolean();

                                    //Assignem l'estat de cada habitació a la variable allDoorsStatus
                                    livingRoomDoorLocked = allDoorsStatus;
                                    kitchenDoorLocked = allDoorsStatus;
                                    restRoomDoorLocked = allDoorsStatus;
                                    room1DoorLocked = allDoorsStatus;
                                    room2DoorLocked = allDoorsStatus;
                                    room3DoorLocked = allDoorsStatus;
                                    garageDoorLocked = allDoorsStatus;

                                if (allDoorsStatus) { //Si la variable és true, es bloquejen totes les portes
                                    System.out.println();
                                    System.out.println("S'han bloquejat totes les portes");
                                }
                                else{
                                    System.out.println(); //Si la variable és false, es desbloquejen totes les portes
                                    System.out.println("S'han desbloquejat totes les portes");
                                }

                                break; //Surt del menú i torna a l'anterior
                            
                            }
                            catch (InputMismatchException e){ //Mostra un missatge d'error si no escrius true o false
                                System.out.println();
                                System.out.println("ERROR: Escriu true o false");
                                esc.nextLine();
                            }
                            
                        }
                        break; //Surt del menú i torna a l'anterior

                    case "c":
                        programLock(esc); //Mostra el mètode del rellotge creat anteriorment
                        break;

                    case "d": //Aquesta és la quarta opció, mostrar l'estat de les portes
                        System.out.println();
                        System.out.println("ESTAT DE LES PORTES");
                        System.out.println();

                        System.out.print("Menjador: ");
                        if (livingRoomDoorLocked) { //Si la variable de l'estat del menjador és true és que està bloquejat
                            System.out.println("Bloquejada");
                        }
                        else{ //En canvi, sinó, vol dir que està desbloquejada
                            System.out.println("Desbloquejada");
                        }

                        //Repetim el mateix per la resta d'habitacions:

                        System.out.print("Cuina: ");
                        if (kitchenDoorLocked) {
                            System.out.println("Bloquejada");
                        }
                        else{
                            System.out.println("Desbloquejada");
                        }


                        System.out.print("Lavabo: ");
                        if (restRoomDoorLocked) {
                            System.out.println("Bloquejada");
                        }
                        else{
                            System.out.println("Desbloquejada");
                        }             


                        System.out.print("Habitació 1: ");
                        if (room1DoorLocked) {
                            System.out.println("Bloquejada");
                        }
                        else{
                            System.out.println("Desbloquejada");
                        }                   
                        
                        
                        System.out.print("Habitació 2: ");
                        if (room2DoorLocked) {
                            System.out.println("Bloquejada");
                        }
                        else{
                            System.out.println("Desbloquejada");
                        }     
                        
                        
                        System.out.print("Habitació 3: ");
                        if (room3DoorLocked) {
                            System.out.println("Bloquejada");
                        }
                        else{
                            System.out.println("Desbloquejada");
                        }


                        System.out.print("Garatge: ");
                        if (garageDoorLocked) {
                            System.out.println("Bloquejada");
                        }
                        else{
                            System.out.println("Desbloquejada");
                        }
                                          
                        break;

                    case "e": //Última opció, sortir del menú portes
                        outDoors = true; //Assignem true a la variable outDoors, per tant no es compleix el la condició del bucle i sortirà d'aquest
                        break; //Surt del menú portes i torna al principal
                        
                }
            
            } while (!outDoors); //El bucle del menú de portes es repeteix mentre outDoors no sigui true (sigui false)
                break;
        


        case "e":  //Última opció del menú principal del la casa domòtica, sortir del programa i tancar l'escàner
        System.out.println();
        System.out.println("Sortint del programa..."); //Missatge de sortida
        outProgram = true;  // Aquesta opció és per sortir del programa, per tant al assignar "true" a la variable, farà que surti del do
        esc.close();
        break;

    
        }

        } while (!outProgram);   //Es repeteix el bucle mentre la variable outProgram no sigui true
                                         //Només serà certa quan triem l'opció de sortir del programa (case e)
    
        esc.close();
     }
}