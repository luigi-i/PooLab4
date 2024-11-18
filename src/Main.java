import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Climatizacion clima=new Climatizacion();
        Scanner sc = new Scanner(System.in);

        System.out.println("\nClimatizador\n\n");
        System.out.println("------------------------");
        System.out.print("---"+ Climatizacion.showON() + "---" );
        System.out.println("------------------------");
        //primera interfaz solo encender
        System.out.println("Encender?");
        System.out.println("1.Si / 2.No");
        int opcion = sc.nextInt();
        //ya encendido el programa dar las demas interfazes
        //al seleccionar otra opcion mostrar la interfaz segun la opcion que escoja
        if( opcion == 1 ) {
            System.out.println("1.Ajustar grado de temperatura Grado a grado");
            System.out.println("2.Ajustar temperatura Segun el clima externo");
            System.out.println("3.Nivel de ventilacion");
            System.out.println("4.Modo calefaccion");
            System.out.println("5.Distribucion de aire");
            System.out.println("6.Desempañador");
            System.out.println("7.Control de humedad");
            System.out.println("8.Mantenimiento");
            int opcion2 = sc.nextInt();
            switch(opcion2) {
                case 1:
                    System.out.println("1.Subir un grado");
                    System.out.println("2.Bajar un grado");
                    break;
                case 2:
                    System.out.println("Ingresar temperatura del clima externo");
                    int level = sc.nextInt();
                    clima.adjustVetn(level);
                    System.out.println("La temperatura acutal es de"+Climatizacion.getTempSistema());
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
                    System.out.println("1.Frontal");
                    System.out.println("2.Parabrisas");
                    System.out.println("3.Pies");
                    break;
                case 6:
                    System.out.println("1.Activar");
                    System.out.println("2.Desactivar");
                    break;
                case 7:
                    System.out.println("1.Nivel de Humedad:1.Bajo,2.Medio,3.Alto");
                    System.out.println("2.Indicador visual de humedad");
            }


        }

        System.out.println("");
        System.out.println("3.");

        System.out.print("Temp: xx  ///  ");
        System.out.println("Direccion: ---  ///  \n");
        System.out.print("Mute: OFF  ///  ");
        System.out.print("Fog: OFF  ///  ");
        System.out.println("Humedad: x");
        System.out.println("------------------------");
        System.out.println("\nEspacio para mostrar mensajes de error\n");

    }
}