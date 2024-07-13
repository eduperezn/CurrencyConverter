import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        OperacionesMoneda operaciones = new OperacionesMoneda();

        String baseCurrency = "";
        String targetCurrency = "";
        int opcion = 0;
        double monto;

        while (opcion != 7) {
            System.out.println("***********BIENVENIDO A ESTE CONVERSOR DE MONEDAS***********");
            System.out.println("**********Elija la opcion de conversion que desea***********");
            System.out.println("""
                    1) USD =>> MXN
                    2) MXN =>> USD
                    3) EUR =>> MXN
                    4) MXN =>> EUR
                    5) BRL =>> USD
                    6) USD =>> BRL
                    7) Salir
                    Opción: """);

            try {
                opcion = lectura.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                lectura.nextLine(); // Limpiar el buffer del scanner
                continue;
            }

            switch (opcion) {
                case 1:
                    baseCurrency = "USD";
                    targetCurrency = "MXN";
                    break;
                case 2:
                    baseCurrency = "MXN";
                    targetCurrency = "USD";
                    break;
                case 3:
                    baseCurrency = "EUR";
                    targetCurrency = "MXN";
                    break;
                case 4:
                    baseCurrency = "MXN";
                    targetCurrency = "EUR";
                    break;
                case 5:
                    baseCurrency = "BRL";
                    targetCurrency = "USD";
                    break;
                case 6:
                    baseCurrency = "USD";
                    targetCurrency = "BRL";
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Elige una opción valida");
                    continue;
            }

            if (opcion != 7){

                try {
                    System.out.println("Ingrese el monto a convertir:");
                    monto = lectura.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un valor numérico válido.");
                    lectura.nextLine(); // Limpiar el buffer del scanner
                    continue;
                }

                Moneda moneda = consulta.consultaMoneda(baseCurrency, targetCurrency);
                double montoConvertido = operaciones.convertirMoneda(monto, moneda.conversion_rate());

                System.out.println("\nResultado de la conversión:");
                System.out.printf("%.2f %s = %.2f %s%n\n",
                        monto, baseCurrency, montoConvertido, targetCurrency);

            }else {
                break;
            }

        }

    }

}
