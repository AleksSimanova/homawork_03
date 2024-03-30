package zoo.utilit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public <T extends Enum<T>> boolean checkValuesInEnam(Class<T> enumType,String value){
        for(T val:enumType.getEnumConstants()){
            if(val.name().equals(value)){  
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isStringChars( String str){
        Pattern pattern = Pattern.compile("^\\D+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
    public boolean isAgeNimbers( String str){
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher =pattern.matcher(str);
        return matcher.find();
    }
}