package prueba;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio03 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process=null;
        String comando = args[0];
        System.out.println("Comando a ejecutar: "+comando);
        try {
            process = runtime.exec(comando);
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea=br.readLine())!=null)
                System.out.println(linea);
            br.close();

        }catch(Exception ex){
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}