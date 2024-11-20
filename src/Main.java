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
        int fogCount = 0; //Cuenta cuanto lleva encendido el desempañador
        boolean fogAlarm = false;

        LocalDate today = LocalDate.now();//Sirve para llevar registro de los mantenimientos
        String case9Cal = "---";//Registro del mantenimiento de la calefaccion, era necesario declararlo aqui para que no se borrase dentro del loop

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
            System.out.print("Direccion: " + Climatizacion.showVentEspecifica() + "  ///  " );
            System.out.print("Humedad: " + Climatizacion.getHumedad() + "\n");
            System.out.print("Modo silencioso: Apagado    ///  ");
            System.out.print("Mute: " + Climatizacion.showMute() + "  ///  ");
            System.out.print("Desempañador ECO: " + Climatizacion.showECO() + "\n" );
            System.out.print("Desempañador frontal: " + Climatizacion.showFog() +"    ///  ");
            System.out.println("Desempañador lateral: " + Climatizacion.showFog2() + "\n" );

            System.out.println("------------------------");

            //alarma fog
            if (fogAlarm){
                fogCount += 1;
            }
            if (fogCount > 5){
                Msg += "\nEl desempañador lleva bastante tiempo encendido, se recomienda apagarlo o activar el modo ECO para ahorrar energia";
            }
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
            System.out.println("7.Desempañador modo ECO");
            System.out.println("8.Control de humedad");
            System.out.println("9.Mantenimiento");
            System.out.println("10. Salir");

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
                         case1 = 2;//pone otro numero cualquiera para que no se cumplan los if
                         Msg = "Ingrese 0 o 1 para cambiar la temperatura";
                     }
                      if(case1 == 0) { Climatizacion.tempDown();} //depende de la opcion elegida llama un metodo u otro
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
                            Climatizacion.setventEspecifica(case5); //llama al metodo segun el input
                            Msg = "Direccion del aire actualizada";
                        }catch (Exception e) { Msg = "Ingrese un numero entre 1 o 3 para cambiar la direccion";}
                        //mensaje de error

                        sc.nextLine();//limpia el buffer

                        break;

                    case 6:
                        int case6 = 0;

                        if(Climatizacion.getFog()){ //Si frontal esta encendido apaga ambas
                            Climatizacion.setFog(); //true -> false
                            Climatizacion.setFog2(false);
                            Climatizacion.setECO(false);
                            fogCount = 0; //resetea el contador de alerta para el desempañador
                            fogAlarm = false;
                            Msg = "Sistema desempañador apagado";
                        }
                        else {//Si esta apagado
                            Climatizacion.setFog(); //Enciende el frontal
                            fogAlarm = true;
                            try{
                                System.out.println("Desea encender tambien el desempañador lateral?");
                                System.out.println("Presione 1 para confirmar, cualquier otra si no.");
                                case6 = sc.nextInt();
                                if (case6 == 1) { //si marco 1, enciende ambas
                                    Climatizacion.setFog2(true);
                                    Msg = "Se han encendido ambos desempañadores ";
                                } else {Msg = "Desempañador frontal activado";}
                            }catch (Exception e) {
                                //si se marco otro numero o una letra
                                Msg = "desempañador frontal activado";
                            }
                        }

                        break;

                case 7:
                    if (!Climatizacion.getFog()){ //si el desempañador esta apagado no hace nada
                        Msg = "Por favor encienda el desempañador antes de activar el modo eco";
                    }else{//si el desempañador esta encendido
                        Climatizacion.switchECO(); //Alterna el modo ECO
                        Msg = "Modo ECO cambiado a: " + Climatizacion.showECO();

                        if(Climatizacion.getECO()){ //Encender el ECO tambien resetea la alerta
                            fogCount = 0; //resetea el contador de alerta para el desempañador
                            fogAlarm = false;
                        }

                    }
                    break;

                    case 8:
                        int case8 = 0;

                        System.out.println("Ingrese el nivel de humedad que desea: 0. Apagado 1.Bajo,2.Medio,3.Alto");

                        try {
                            case8 = sc.nextInt();
                            Climatizacion.setHumedad(case8);
                            Msg = "Humedad actualizada";
                        }catch (Exception e){
                            Msg = "Por favor ingrese un numero entre 0 y 3";
                        }

                        break;

                case 9:

                    int case9;
                    int case9CalInt = 0;

                    System.out.println("\033c");

                    System.out.println("------------------------");
                    System.out.println("--- Calendario de mantenimientos ---");
                    System.out.println("------------------------\n"); //Aqui se suma un numero cualquiera de meses y dias al actual para marcar una fecha
                    System.out.println("-Cambio de filtro: " + today.plusMonths(12));
                    System.out.println("-Revision de mangueras: " + today.plusMonths(3).plusDays(15));
                    System.out.println("-Limpieza del compresor: " + today.plusMonths(4));
                    System.out.println("-Revision del nivel de refrigerante: " + today.plusMonths(2));
                    System.out.println("------------------------\n");

                    System.out.println("Presione 1 para programar la fecha de mantenimiento para la calefaccion");
                    System.out.println("Presione cualquier letra para regresar al menu principal");
                    try {
                        case9 = sc.nextInt();
                        if (case9 == 1){
                            System.out.println("\033c");
                            System.out.println("Mantenimiento de la calefaccion programado dentro de: " + case9Cal); //case9cal empieza como "---"
                            System.out.println("Ingrese el numero de semanas a programar el mantenimiento");
                            System.out.println("Presione cualquier letra para salir");
                            try {
                                case9CalInt = sc.nextInt(); //recibe el numero de semanas para mantenimiento
                                case9Cal = case9CalInt + " semanas"; //le agrega la palabra semanas en un String para mostrar al usuario
                                Msg = "Mantenimiento de la calefaccion programado para dentro de " + case9Cal;

                            }catch (Exception e){Msg = "Si desea programar el mantenimiento de la calefaccion, presione: 8 -> 1" ;}
                        }

                    }catch (Exception e){Msg = "Si desea programar el mantenimiento de la calefaccion, presione: 8 -> 1" ;}
                    break;

                case 10:
                    System.out.println("\033c");
                    System.out.println("Saliendo...");
                    seguir = false;
                    break;
                }
        }
    }
}