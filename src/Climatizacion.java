public class Climatizacion implements NivelVentilacion,ControlHumedad,Calefaccion {

    //Parte de overrides
    //Metodo de ajustar humedad
    @Override
    public String adjustHum(int level_H){
        //Nota lui:Cambie el nivel de humedad como ta en el documento
        if (level_H == 1) {
            Climatizacion.setHumedad(1);  // Bajo
            return "Humedad ajustada a Bajo.";
        } else if (level_H == 2) {
            Climatizacion.setHumedad(2);  // Medio
            return "Humedad ajustada a Medio.";
        } else if (level_H == 3) {
            Climatizacion.setHumedad(3);  // Alto
            System.out.println("Humedad ajustada a Alto.");
        }  return "No a seleccionado ningun nivel";

    }
    //mostrar la humedad
    @Override
    public int showHum() {
        return Climatizacion.getHumedad();
    }
    //ajustar ventilacion
    @Override
    public String adjustVetn(int level_V){
        switch (level_V) {
            case 1:
                return "Nivel de ventilación ajustado a Bajo.";
            case 2:
                return "Nivel de ventilación ajustado a Medio.";
            case 3:
                return "Nivel de ventilación ajustado a Alto.";
            default:
                return "Selección inválida. Elija entre 1 (Bajo), 2 (Medio), o 3 (Alto).";
        }
    }
    @Override
    public String Ventauto(){
        // Temperatura cómoda definida
        return "Ventilacion automatica activada, Modo Medio a 22°C";
    }
    @Override
    public String VentEspecifica(int level_E){
        if (level_E == 1) {return "Ventilacion hacia los pies";}
        else if (level_E==2) {return "Ventilacion hacia el parabrisas";
        }
        return "No ha seleccionado ningun tipo de ventilacion";
    }
    //ajustar nivel ventilacion
    @Override
    public void adjust(int level){
        //Nota a lui:movi esto de public static void setTempSistema(int tempSistema)
        if (level < 16) {
            Climatizacion.setTempSistema(20);
        } else if (level > 30) {
            Climatizacion.setTempSistema(24);
        } else {
            Climatizacion.setTempSistema(22);
        }
        //escoge una temperatura basado en la temperatura exterior proporcionada
    }
    //modo silencio
    @Override
    public void switchMute() {
        mute = !mute;
    }//Muestra si el modo silencioso esta activado o Desactivado.
    @Override
    public String isonMute(){
        if (Climatizacion.isMute()) {
            return "El modo silencioso está activado.";
        } else {
            return "El modo silencioso está desactivado.";
        }
    }
    //Encender el calentador
    @Override
    public void heatON()
    {
        Climatizacion.setON();
    }

    private static boolean ON = false;
    private static int ventEspecifica = 3;
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

    public static String showMute(){
        if(Climatizacion.mute){ return "ON";}
        else return "OFF";
    }


    public static boolean isFog() {//retorna si el desempanador esta encendido o no
        return fog;
    }
    public static void setFog() {//si esta encendido lo apaga y viceversa
        fog = !fog;
    }

    public static String showFog(){
        if(Climatizacion.fog){ return "Encendido";}
        else return "Apagado";
    }


    public static int getTempSistema() {
        return tempSistema;
    }

    public static void tempUp(){
        tempSistema += 1;
    }
    public static void tempDown(){
        tempSistema -= 1;
    }

    public static void setTempSistema(int tempSistema) {
        if (tempSistema < 16) {
            Climatizacion.tempSistema = 20;
        } else if (tempSistema > 30) {
            Climatizacion.tempSistema = 24;
        } else {
            Climatizacion.tempSistema = 22;
        }

    }

    public static int getventEspecifica() {
        return ventEspecifica;
    }
    public static void setventEspecifica(int ventEspecifica) {
        if (ventEspecifica >= 1 && ventEspecifica <= 3) {
            Climatizacion.ventEspecifica = ventEspecifica;
        }
        else {
            Climatizacion.ventEspecifica = 1;}
    }

    public static String showVentEspecifica(){
        if (Climatizacion.ventEspecifica == 1) { return "Parabrisas";}
        else if (Climatizacion.ventEspecifica == 2) { return "Pies";}
        else if (Climatizacion.ventEspecifica == 3) { return "Frontal";}
        else { return "OFF";}
    }



    public static int getHumedad() {
        return humedad;
    }
    public static void setHumedad(int humedad) {
        if (humedad >= 0 && humedad <= 3) {
            Climatizacion.humedad = humedad;
        } else {
            Climatizacion.humedad = 0;  // Asignamos 0 si no es un valor válido

        }
    }



}
