package zoo.utilit;

public class EnamConvecters {
    public <T extends Enum<T>> String getNamesEnam( Class<T> clazz,String delimeter){
        T[] values= clazz.getEnumConstants();
        String[] commadsConsole = new String[values.length];
        for (int i=0;i<values.length;i++){
            commadsConsole[i]=values[i].name().toLowerCase();
        }
        return String.join(delimeter, commadsConsole);

    }
}
