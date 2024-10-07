import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);

        String lineaTeclado = null;

        String comando = "java -jar c:\\aleatorio.jar";
        Runtime runtime = Runtime.getRuntime();
        Process process = null;

        try {
            process = runtime.exec(comando);
            InputStream is = process.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = process.getOutputStream();

            String linea;
            System.out.println("Introduce lineas de texto (fin para acabar)");
            while (((lineaTeclado = bf.readLine()) != null) && (!lineaTeclado.equals("fin"))) {
                lineaTeclado = lineaTeclado + "\n";
                os.write(lineaTeclado.getBytes());
                os.flush();
                linea = br.readLine();
                System.out.println("El hijo envió: " + linea);
            }
            lineaTeclado = lineaTeclado + "\n";
            os.write(lineaTeclado.getBytes());
            os.flush();
            br.close();

            int exitVal = process.waitFor();
            System.out.println("\nValor de salida: " + exitVal);
            if (exitVal == 0)
                System.out.println("Aplicación finalizada");

        } catch (Exception ex) {
            System.err.println("Se ha producido un error. Su descripcion es: ");
            System.err.println(ex.toString());
        }
    }
}