package lab8_progra1_josebendana;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab8_Progra1_JoseBendana {

    public static void main(String[] args) {
        int cual=1;
        while ((cual==1)||(cual==2)){
            Scanner menu = new Scanner(System.in);
            System.out.println("1.  Pocket Monsters");
            System.out.println("2.  DC vrs Marvel");
            System.out.println("3 u Otro numero para salir");
            System.out.print("Ingrese el ejercicio a evaluar[1], [2]: ");
            cual = menu.nextInt();
            switch(cual){
                case 1:
                    agregar();
                    break;
                case 2:
                    duro();
                    break;
                default:
                    System.out.println("Saliendo.....");
                    System.out.println("Salio exitosamente!!!");
                    break;
            }
        }
    }
    public static void agregar (){
        Scanner addname = new Scanner(System.in);
        Scanner addnum = new Scanner (System.in);
        ArrayList<Pokemon> player1 = new ArrayList();
        ArrayList<Pokemon> player2 = new ArrayList();
        int cont=0;
        int cont2=0;
        int cantidad1 = 0;
        int cantidad2 = 0;
        do{
            System.out.print("Ingrese cuantos Pokemones se utilizaran (Jugador 1): ");
            cantidad1 = addnum.nextInt();
            if ((cantidad1>0)&&(cantidad1<=3)) {
                break;
            }else if(cantidad1<=0){
                System.out.println("Debe haber minimo 1 Pokemon");
            }else if(cantidad1>3){
                System.out.println("Solo se pueden 1 a 3 Pokemones");
            }
        }while((cantidad1<=0)||(cantidad1>3));
        do{
            System.out.print("Ingrese el nombre del Pokemon: ");
            String nombre1 = addname.nextLine();
            int vida1=0;
            do{
                System.out.print("Ingrese la vida del Pokemon: ");
                vida1 = addnum.nextInt();
                if ((vida1>300)||(vida1<=0)) {
                    System.out.println("No se puede mas de 300 ni menos de 1");
                }else if(vida1<=300){
                    break;
                }
            }while((vida1>300)||(vida1<=0));
            int ataque1=0;
            do{
                System.out.print("Ingrese los puntos de ataque del Pokemon: ");
                ataque1 = addnum.nextInt();
                if (ataque1>0) {
                    break;
                }else{
                    System.out.println("No se puede un ataque negativo o de 0");
                }
            }while(ataque1<=0);
            //puse que fuera minimo uno por que si se pone 0 y el otro 0 hay un ciclo infinito
            int luck1 = luck();
            Pokemon pok = new Pokemon(nombre1, vida1, ataque1, luck1);
            player1.add(pok);
            cont++;
        }while(cont<cantidad1);
        Scanner addname2 = new Scanner(System.in);
        Scanner addnum2 = new Scanner (System.in);
        do{
            System.out.print("Ingrese cuantos Pokemones se utilizaran (Jugador 2): ");
            cantidad2 = addnum2.nextInt();
            if ((cantidad2>0)&&(cantidad2<=3)) {
                break;
            }else if (cantidad2<=0){
                System.out.println("Debe haber minimo 1 Pokemon");
            }else if(cantidad2>3){
                System.out.println("Solo se pueden 1 a 3 Pokemones");
            }
        }while((cantidad2<=0)||(cantidad2>3));
        do {
            System.out.print("Ingrese el nombre del Pokemon: ");
            String nombre2 = addname2.nextLine();
            int vida2=0;
            do{
                System.out.print("Ingrese la vida del Pokemon: ");
                vida2 = addnum2.nextInt();
                if ((vida2>300)||(vida2<=0)) {
                    System.out.println("No se puede mas de 300 ni menos de 1");
                }else if(vida2<=300){
                    break;
                }
            }while((vida2>300)||(vida2<=0));
            int ataque2 = 0;
            do{
                System.out.print("Ingrese los puntos de ataque del Pokemon: ");
                ataque2 = addnum2.nextInt();
                if (ataque2>0) {
                    break;
                }else{
                    System.out.println("No se puede un ataque negativo o de 0");
                }
            }while(ataque2<=0);
            int luck2 = luck();
            Pokemon pok2 = new Pokemon(nombre2, vida2, ataque2, luck2);
            player2.add(pok2);
            cont2++;
        } while (cont2 < cantidad2);
        int contador1=player1.size();
        int contador2=player2.size();
        do {
            boolean quien = pelea(player1, player2);
            if (quien==true) {
                contador1--;
            }else if(quien==false){
                contador2--;
            }
        } while ((contador1>0)&&(contador2>0));
        if (contador1==0) {
            System.out.println("JUGADOR 1 YA NO PUEDE JUGAR");
        }else if(contador2==0){
            System.out.println("JUGADOR 2 YA NO PUEDE JUGAR");
        }
//        for (Pokemon pokemon : player1) {
//            System.out.println(pokemon);
//        }
//        for (Pokemon pokemon2 : player2) {
//            System.out.println(pokemon2);
//        }
        
    }
    
    public static int luck() {
        //new Random().nextInt((max - min) + 1) + min
        int num = new Random().nextInt((5 - 1) + 1) + 1;
        return num;
    }
    
    public static boolean pelea(ArrayList<Pokemon> player1, ArrayList<Pokemon> player2){
        int contpoks1=player1.size();
        int contpoks2=player2.size();
        int vida1;
        int vida2;
        do {
            int suerte1 = player1.get(0).getLuck();
            int suerte2 = player2.get(0).getLuck();
//            System.out.println(suerte1+""+suerte2);
            if (suerte1>=suerte2){
                int ronda =1;
                do{
                    System.out.println("-----------------------------------Ronda "+ronda+"-----------------------------------");
                    ronda++;
                    System.out.println(player1.get(0).getNombre()+" Ataca Primero, Tiene : "+player1.get(0).getVida()+" Puntos de vida y "+player1.get(0).getLuck()+" de suerte");
                    System.out.println(player2.get(0).getNombre()+" Ataca Segundo : "+player2.get(0).getVida()+" puntos de vida y "+player2.get(0).getLuck()+" de suerte");
                    System.out.println("** PUNTOS RESTANTES **");
                    int poder1 = player1.get(0).getPegar();
                    int poder2 = player2.get(0).getPegar();
                    vida1 = player1.get(0).getVida();
                    vida2 = player2.get(0).getVida();
                    vida1-=poder2;
                    vida2-=poder1;
                    player1.get(0).setVida(vida1);
                    player2.get(0).setVida(vida2);
                    System.out.println(player1.get(0).getNombre()+" Tiene "+player1.get(0).getVida()+" restantes");
                    System.out.println(player2.get(0).getNombre()+" Tiene "+player2.get(0).getVida()+" restantes");
                    if (vida1<=0){
                        System.out.println("---RESULTADOS:---");
                        System.out.println(player2.get(0).getNombre()+" ES EL GANADOR");
                        contpoks1--;
                        player1.remove(0);
                        return true;
                    }else if(vida2<=0){
                        System.out.println("---RESULTADOS:---");
                        System.out.println(player1.get(0).getNombre()+" ES EL GANADOR");
                        contpoks2--;
                        player2.remove(0);
                        return false;
                    }
                }while((vida1>0)&&(vida2>0));
            }else{
                int ronda=1;
                do{
                    System.out.println("-----------------------------------Ronda "+ronda+"-----------------------------------");
                    ronda++;
                    System.out.println(player2.get(0).getNombre()+" Ataca Primero, Tiene : "+player2.get(0).getVida()+" Puntos de vida y "+player2.get(0).getLuck()+" de suerte");
                    System.out.println(player1.get(0).getNombre()+" Ataca Segundo : "+player1.get(0).getVida()+" puntos de vida y "+player1.get(0).getLuck()+" de suerte");
                    System.out.println("** PUNTOS RESTANTES **");
                    int poder1 = player1.get(0).getPegar();
                    int poder2 = player2.get(0).getPegar();
                    vida1 = player1.get(0).getVida();
                    vida2 = player2.get(0).getVida();
                    vida1-=poder2;
                    vida2-=poder1;
                    player1.get(0).setVida(vida1);
                    player2.get(0).setVida(vida2);
                    System.out.println(player2.get(0).getNombre()+" Tiene "+player2.get(0).getVida()+" restantes");
                    System.out.println(player1.get(0).getNombre()+" Tiene "+player1.get(0).getVida()+" restantes");
                    if (vida1<=0){
                        System.out.println("---RESULTADOS:---");
                        System.out.println(player2.get(0).getNombre()+" ES EL GANADOR");
                        contpoks1--;
                        player1.remove(0);
                        return true;
                    }else if(vida2<=0){
                        System.out.println("---RESULTADOS:---");
                        System.out.println(player1.get(0).getNombre()+" ES EL GANADOR");
                        contpoks2--;
                        player2.remove(0);
                        return false;
                    }
                }while((vida1>0)&&(vida2>0));
            }
        } while ((contpoks1>0)&&(contpoks2>0));
        return false;
    }
    
    public static void duro(){
        Scanner heroes = new Scanner (System.in);
        ArrayList<Superheroe> marvel = new ArrayList();
        ArrayList<Superheroe> dc = new ArrayList();
        marvel.add(new Superheroe("Spiderman", "Peter Parker", "Nueva York", "Marvel"));
        marvel.add(new Superheroe("Ironman","Anthony Stark", "Nueva York", "Marvel"));
        marvel.add(new Superheroe("Capitan America","Steven Rogers", "Nueva York", "Marvel"));
        marvel.add(new Superheroe("Black Widow","Natasha Romanoff", "Stalingrado", "Marvel"));
        marvel.add(new Superheroe("Dr. Strange","Stephen Strange", "Nueva York", "Marvel"));
        marvel.add(new Superheroe("Pantera Negra","Rey T´Challa", "Wakanda", "Marvel"));
        marvel.add(new Superheroe("Magneto","Erik Lehnsherr", "Núremberg", "Marvel"));
        marvel.add(new Superheroe("Deadpool","Wade Wilson", "Saskatchewan", "Marvel"));
        marvel.add(new Superheroe("Hulk","Bruce Banner", "Dayton", "Marvel"));
        marvel.add(new Superheroe("Hawkeye","Clint Barton", "Nueva York", "Marvel"));
        
        dc.add(new Superheroe("Linterna verde","Harold Jordan", "Detroit", "DC"));
        dc.add(new Superheroe("Aquaman","Arthur Curry", "Atlantis", "DC"));
        dc.add(new Superheroe("Wonder Woman","Diana Prince", "Washington", "DC"));
        dc.add(new Superheroe("Flash","Barry Allen", "Central City", "DC"));
        dc.add(new Superheroe("Flecha Verde", "Oliver Queen", "Star City", "DC"));
        dc.add(new Superheroe("Batman","Bruce Wayne", "Gotham City", "DC"));
        dc.add(new Superheroe("Robin","Damian Wayne", "Ciudad gótica", "DC"));
        dc.add(new Superheroe("Shazam","Joseph Batson", "Roca de la Eternidad", "DC"));
        dc.add(new Superheroe("Superman","Clark Kent", "Krypton", "DC"));
        dc.add(new Superheroe("Batgirl","Barbara Gordon", "Gotham City", "DC"));
        
        System.out.print("Buscar[1] o Agregar[2]: ");
        int opcion = heroes.nextInt();
        switch(opcion){
            case 1:
                buscar(marvel,dc);
                break;
            case 2:
                agregar(marvel,dc);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
    
    public static void buscar(ArrayList<Superheroe> marvel, ArrayList<Superheroe> dc){
        Scanner buscar = new Scanner (System.in);
        System.out.print("Ingrese el nombre que quiere buscar: ");
        String nombre = buscar.nextLine();
        String nombrelow = nombre.toLowerCase();
        int bandera=0; 
        for (int i = 0; i < marvel.size(); i++) {
            String herolow = marvel.get(i).getHeroe().toLowerCase();
            String reallow = marvel.get(i).getReal().toLowerCase();
            String herolowdc = dc.get(i).getHeroe().toLowerCase();
            String reallowdc = dc.get(i).getReal().toLowerCase();
            if ((nombrelow.equals(herolow))||(nombrelow.equals(reallow))){
                System.out.println(marvel.get(i).toString());
                bandera=0;
                break;
            }else if ((nombrelow.equals(herolowdc))||(nombrelow.equals(reallowdc))){
                System.out.println(dc.get(i).toString());
                bandera=0;
                break;
            }else{
                bandera=1;
            }
        }
        if (bandera==1){
            System.out.println("Superheroe no encontrado");
        }
    }
    
    public static void agregar(ArrayList<Superheroe> marvel, ArrayList<Superheroe> dc){
        Scanner meter = new Scanner (System.in);
        System.out.print("Ingrese el nombre del heroe: ");
        String heroe = meter.nextLine();
        System.out.print("Ingrese el nombre verdadero: ");
        String real = meter.nextLine();
        String franquicia = "";
        String fran = "";
        do{
            System.out.print("Ingrese la franquicia: ");
            fran = meter.nextLine();
            franquicia = fran.toLowerCase();
            if (("marvel".equals(franquicia))||("dc".equals(franquicia))) {
                break;
            }else if((!"marvel".equals(franquicia))||(!"dc".equals(franquicia))){
                System.out.println("Franquicia no valida, solo se puede Marvel o DC");
            }
        }while((!"marvel".equals(franquicia))||(!"dc".equals(franquicia)));
        
        System.out.print("Ingrese la ciudad de Origen: ");
        String city = meter.nextLine();
        if ("dc".equals(franquicia)){
            dc.add(new Superheroe(heroe, real, city, fran));
            System.out.println("¡Se ha añadido correctamente a "+heroe+" a la lista de DC!");
        }else if("marvel".equals(franquicia)){
            marvel.add(new Superheroe(heroe, real, city, fran));
            System.out.println("¡Se ha añadido correctamente a "+heroe+" a la lista de Marvel!");
        }
    }
}
