import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Climatizacion clima=new Climatizacion();
        Scanner sc = new Scanner(System.in);
        boolean seguir = false; //Seguir con el menu principa;;
        int opcion = 0; //opcion para encender el sistema
        int opcion2 = 0; //opcion elegida del menu
        String Msg = ""; //String asignado para mostrar los mensajes

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


            Msg = "---"; //vuelve a resetear el mensaje de error
            System.out.println("------------------------");
            //primera interfaz solo encender

            //ya encendido el programa dar las demas interfazes
            //al seleccionar otra opcion mostrar la interfaz segun la opcion que escoja

                System.out.println("1.Ajustar grado de temperatura Grado a grado");
                System.out.println("2.Ajustar temperatura Segun el clima externo"); //pendiente de interfaz
                System.out.println("3.Nivel de ventilacion"); //pendiente de interfaz
                System.out.println("4.Modo calefaccion");
                System.out.println("5.Distribucion de aire");
                System.out.println("6.Desempañador");
                System.out.println("7.Control de humedad");
                System.out.println("8.Mantenimiento");
                System.out.println("9.Apagar");
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
                        System.out.println("La temperatura acutal es de" + Climatizacion.getTempSistema());
                        break;
                    case 3:
                        System.out.println("Ventilacion");
                        System.out.println("1.Modos:1.Bajo,2.Medio,3.Alto");
                        System.out.println("2.Ventilacion Automatica");
                        System.out.println("3.Ventilacion en Sona especifica");
                        System.out.println("4.Modo Silencioso");
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
                }
        }
    }
}