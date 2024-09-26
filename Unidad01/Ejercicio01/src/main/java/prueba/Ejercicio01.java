package prueba;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio01 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process=null;
        String comando = "cmd /c ipconfig /all";
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
