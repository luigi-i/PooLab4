import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Climatizacion clima=new Climatizacion();
        Scanner sc = new Scanner(System.in);
        boolean seguir = false; //Seguir con el menu principa;;
        int opcion = 0; //opcion para encender el sistema
        int opcion2 = 0; //opcion elegida del menu
        String Msg = ""; //String asignado para mostrar los mensajes

        LocalDate today = LocalDate.now();//Sirve para llevar registro de los mantenimientos
        String case8Cal = "---";//Registro del mantenimiento de la calefaccion, era necesario declararlo aqui para que no se borrase dentro del loop

        System.out.println("\033c"); //limpia la terminal
        while (opcion != 1) { //mientras no se encienda el sistema se repite este while
            System.out.println("Presione 1 para encender");
            try {
                opcion = sc.nextInt();
                if (opcion == 1) {
                    seguir = true;
                    Climatizacion.setON(); //enciende la climatizacion
                }
            } catch (Exception e) {
                System.out.println("Por favor, para encender presione 1");
            }
            sc.nextLine();
            System.out.println("\033c");
        }


        while(seguir) {

            System.out.println("\033c");

            System.out.println("------------------------\nClimatizador\n");
            System.out.println("------------------------");
            System.out.println("---" + Climatizacion.showON() + "---");
            System.out.print("Temp: " + Climatizacion.getTempSistema() + "  ///  ");
            System.out.print("Direccion: " + Climatizacion.showVentEspecifica() + "\n");
            System.out.print("Modo silencioso: Apagado    ///  ");
            System.out.println("Mute: " + Climatizacion.showMute());
            System.out.print("Desempañador: " + Climatizacion.showFog() +"    ///  ");
            System.out.println("Humedad: " + Climatizacion.getHumedad());
            System.out.println("------------------------");
            System.out.println("\n" + Msg + "\n");



            System.out.println("------------------------");
            //primera interfaz solo encender

            //ya encendido el programa dar las demas interfazes
            //al seleccionar otra opcion mostrar la interfaz segun la opcion que escoja

            System.out.println("1.Ajustar grado de temperatura Grado a grado");
            System.out.println("2.Ajustar temperatura Segun el clima externo");
            System.out.println("3.Nivel de ventilacion");
            System.out.println("4.Modo calefaccion");
            System.out.println("5.Distribucion de aire");
            System.out.println("6.Desempañador");
            System.out.println("7.Control de humedad");
            System.out.println("8.Mantenimiento");
            System.out.println("9. Salir");

            try {
                opcion2 = sc.nextInt();
            } catch (Exception e) {opcion2 = 0 ;}

            sc.nextLine();
            switch (opcion2) {

                    case 1:
                        int case1 = 0;
                        System.out.println("0.Bajar un grado");
                        System.out.println("1.Subir un grado");

                        try {
                            case1 = sc.nextInt();
                            if (case1 == 0) {Msg = "Temperatura disminuida";}
                            else {Msg = "Temperatura aumentada";}

                        }catch (Exception e) {
                            case1 = 2;
                            Msg = "Ingrese 0 o 1 para cambiar la temperatura";
                        }

                        if(case1 == 0) { Climatizacion.tempDown();}
                        else if (case1 == 1) { Climatizacion.tempUp();}

                        break;
                    case 2:
                        System.out.println("Ingresar temperatura del clima externo");
                        int level = sc.nextInt();
                        clima.adjustVetn(level);
                        System.out.println("La temperatura acutal es de :" + Climatizacion.getTempSistema());
                        break;
                    case 3:
                        System.out.println("Ventilacion");
                        System.out.println("1.Modos:1.Bajo,2.Medio,3.Alto");
                        System.out.println("2.Ventilacion Automatica");
                        System.out.println("3.Ventilacion en Sona especifica");
                        System.out.println("4.Modo Silencioso");
                        int opcion3 = sc.nextInt();
                        switch(opcion3){
                            case 1:
                                System.out.println("Escoja un modo:1.Bajo,2.Medio,3.Alto");
                                int level_V = sc.nextInt();
                                clima.adjustVetn(level_V);
                                System.out.println("Ventilacion en :"+clima.adjustVetn(level_V));
                                break;
                            case 2:
                                System.out.println("Ventilacion Automatica" + clima.Ventauto());
                                break;
                            case 3:
                                System.out.println("Ventilacion en Sona especifica: 1.Ventilacion hacia los pies,2.Ventilacion hacia el parabrisas");
                                int level_E= sc.nextInt();
                                clima.VentEspecifica(level_E);
                                System.out.println("La ventilacion esta en:"+clima.VentEspecifica(level_E));
                                break;
                            case 4:
                                System.out.println("Modo Silencioso");
                                clima.switchMute();
                                System.out.println(clima.isonMute());
                                break;

                    }

                        break;
                    case 4:
                        System.out.println("1.Calefaccion rapida");
                        break;
                    case 5:
                        System.out.println("Ingrese hacia donde desea dirigir el aire");
                        System.out.println("1.Parabrisas --- 2.Pies --- 3.Frontal");
                        int case5 = 0;
                        try{
                            case5 = sc.nextInt();
                            Climatizacion.setventEspecifica(case5);
                            Msg = "Direccion del aire actualizada";
                        }catch (Exception e) { Msg = "Ingrese un numero entre 1 o 3 para cambiar la direccion";}

                        sc.nextLine();

                        break;
                    case 6:
                        Climatizacion.setFog();
                        Msg = "Se ha cambiado la configuracion del desempañador a: " + Climatizacion.showFog();

                        break;
                    case 7:
                        int case7 = 0;

                        System.out.println("Ingrese el nivel de humedad que desea: 0. Apagado 1.Bajo,2.Medio,3.Alto");

                        try {
                            case7 = sc.nextInt();
                            Climatizacion.setHumedad(case7);
                            Msg = "Humedad actualizada";
                        }catch (Exception e){
                            Msg = "Por favor ingrese un numero entre 0 y 3";
                        }

                        break;
                case 8:

                    int case8;
                    int case8CalInt = 0;

                    System.out.println("\033c");

                    System.out.println("------------------------");
                    System.out.println("--- Calendario de mantenimientos ---");
                    System.out.println("------------------------\n");
                    System.out.println("-Cambio de filtro: " + today.plusMonths(12));
                    System.out.println("-Revision de mangueras: " + today.plusMonths(3).plusDays(15));
                    System.out.println("-Limpieza del compresor: " + today.plusMonths(4));
                    System.out.println("-Revision del nivel de refrigerante: " + today.plusMonths(2));
                    System.out.println("------------------------\n");

                    System.out.println("Presione 1 para programar la fecha de mantenimiento para la calefaccion");
                    System.out.println("Presione cualquier letra para regresar al menu principal");
                    try {
                        case8 = sc.nextInt();
                        if (case8 == 1){
                            System.out.println("\033c");
                            System.out.println("Mantenimiento de la calefaccion programado dentro de: " + case8Cal);
                            System.out.println("Ingrese el numero de semanas a programar el mantenimiento");
                            System.out.println("Presione cualquier letra para salir");
                            try {
                                case8CalInt = sc.nextInt();
                                case8Cal = case8CalInt + " semanas";
                                Msg = "Mantenimiento de la calefaccion programado para dentro de " + case8Cal;

                            }catch (Exception e){Msg = "Si desea programar el mantenimiento de la calefaccion, presione: 8 -> 1" ;}
                        }

                    }catch (Exception e){Msg = "Si desea programar el mantenimiento de la calefaccion, presione: 8 -> 1" ;}
                    break;
                case 9:
                    System.out.println("\033c");
                    System.out.println("Saliendo...");
                    seguir = false;


                }
        }
    }
}