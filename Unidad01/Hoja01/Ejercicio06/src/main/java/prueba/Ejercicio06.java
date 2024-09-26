package prueba;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio06 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process=null;
        String comando = "cmd /c ipconfig";
        try {
            process = runtime.exec(comando);
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            Pattern pattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
            boolean salir = false;
            while ((linea=br.readLine())!=null && !salir)
                if (linea.contains("IPv4")) {
                    Matcher matcher = pattern.matcher(linea);
                    if (matcher.find()) {
                        System.out.println(matcher.group());
                        salir = true;
                    }
                }
            br.close();

        }catch(Exception ex){
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
    }