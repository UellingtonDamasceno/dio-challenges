package sunday.morning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Uellington Damasceno
 */
public class Solution{
	
    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
    		String[] relogio = line.split(":");
    		int hora = Integer.parseInt(relogio[0]);
    		int min = Integer.parseInt(relogio[1]);
    		switch (hora) {
    			case(7): System.out.println("Atraso maximo: " + min); break;
    			case(8): System.out.println("Atraso maximo: " + (min+60)); break;
    			case(9): System.out.println("Atraso maximo: " + 120); break;
    			default: System.out.println("Atraso maximo: 0");
    		}
            }
         }
    }
}