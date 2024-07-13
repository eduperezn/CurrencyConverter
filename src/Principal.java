import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        System.out.println("Escribe el tipo de moneda");
        var base_code = lectura.nextLine();

        Moneda moneda = consulta.consultaMoneda(base_code);
        System.out.println(moneda);

    }

}
