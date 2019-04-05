/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pedrcabu
 */
public class ValidadorDeFormularios {
    
    private static final String EMAIL_REGEX = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\."
			+ "[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    
    public static Boolean esDatoNumerico(String campo){
      return (campo.replaceAll("\\s", "").chars().allMatch(Character::isDigit));
    }
    
    public static Boolean esCorreoValido(String campo ){
     
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		      Matcher matcher = pattern.matcher(campo);
		return matcher.matches(); 
    }
    
}
