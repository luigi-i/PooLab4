public class Climatizacion {

    private static boolean ON = false;
    private static int ventEspecifica = 0;
    private static boolean mute = false;
    private static int tempSistema = 20;
    private static boolean fog = false;
    private static int humedad = 0;

    public static boolean isON() { //retorna si el aire esta encendido o no
        return ON;
    }
    public static void setON() { //si esta encendido lo apaga y viceversa
        ON = !ON;
    }

    public static String showON(){
        if (Climatizacion.ON ){
            return "ON";
        }
        else return "OFF";
    }


    public static boolean isMute() {//retorna si el modo silencioso esta encendido o no
        return mute;
    }
    public static void setMute() {//si esta encendido lo apaga y viceversa
        mute = !mute;
    }

    public static boolean isFog() {//retorna si el desempanador esta encendido o no
        return fog;
    }
    public static void setFog() {//si esta encendido lo apaga y viceversa
        fog = !fog;
    }

    public static int getTempSistema() {
        return tempSistema;
    }
    public static void setTempSistema(int tempSistema) {

        if (tempSistema < 16) {
            Climatizacion.tempSistema = 20;
        } else if (tempSistema > 30) {
            Climatizacion.tempSistema = 24;
        }
        else {
            Climatizacion.tempSistema = 22;}
        //escoge una temperatura basado en la temperatura exterior proporcionada
    }

    public static int getventEspecifica() {
        return ventEspecifica;
    }
    public static void setventEspecifica(int ventEspecifica) {
        if (ventEspecifica >= 0 && ventEspecifica <= 3) {
            Climatizacion.ventEspecifica = ventEspecifica;
        }
        else {
            Climatizacion.ventEspecifica = 0;}
    }

    public static int getHumedad() {
        return humedad;
    }
    public static void setHumedad(int humedad) {
        if (humedad >= 0 && humedad <= 3) {
            Climatizacion.humedad = humedad;
        }
        else {
            Climatizacion.ventEspecifica = 0;}
    }

}
