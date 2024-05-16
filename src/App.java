import java.util.Scanner;

public class App {

    public static Scanner leer = new Scanner(System.in);
    int Distancia;
    public static double cantidadactualizada = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("Realicemos un viaje");
        System.out.println("Introduzca la información del primer auto:");
        System.out.print("Marca del vehiculo: ");
        String MarcaV1 = leer.nextLine();
        System.out.print("Placa: ");
        String PlacaV1 = leer.nextLine();
        System.out.print("Capacidad de combustible: ");
        double CapacidadV1 = leer.nextDouble();
        System.out.print("Nivel Actual del tanque: ");
        double NivelActualV1 = leer.nextDouble();
        System.out.print("Redimiento (km/galón): ");
        double RendimientoV1 = leer.nextDouble();
        System.out.println("¿De cuanto es la distancia a recorrer (en Km)? ");
        int Distancia = leer.nextInt();

        Rellenarcombustible(0,NivelActualV1, CapacidadV1);

        conducir(Distancia, RendimientoV1, cantidadactualizada);

        System.out.println("Provemos el viaje con otro vehiculo.");

        System.out.println("Introduzca la información del primer auto:");
        System.out.print("Marca del vehiculo: ");
        leer.nextLine();
        String MarcaV2 = leer.nextLine();
        System.out.print("Placa: ");
        String PlacaV2 = leer.nextLine();
        System.out.print("Capacidad de combustible: ");
        double CapacidadV2 = leer.nextDouble();
        System.out.print("Nivel Actual del tanque: ");
        double NivelActualV2 = leer.nextDouble();
        System.out.print("Redimiento (km/galón): ");
        double RendimientoV2 = leer.nextDouble();
        System.out.println("¿De cuanto es la distancia a recorrer (en Km)? ");
        int Distancia2 = leer.nextInt();

        Rellenarcombustible(0,NivelActualV2, CapacidadV2);

        conducir(Distancia2, RendimientoV2, cantidadactualizada);


    }

    public static double Rellenarcombustible(double cantidadcombustible, double niveltanque, double capacidad) {
        boolean rellenar = true;
    
        while (rellenar) {
            System.out.println("¿Desea rellenar el tanque? Escriba 1 para rellenar, de lo contrario escriba 0");
            int respuesta = leer.nextInt();
    
            switch (respuesta) {
                case 1:
                    System.out.print("Ingrese la cantidad con la que desea rellenar: ");
                    cantidadcombustible = leer.nextDouble();
                    cantidadactualizada = cantidadcombustible + niveltanque;
                    if (cantidadactualizada <= capacidad) {
                        System.out.println("Combustible rellenado");
                        System.out.println("El nivel del tanque es: "+cantidadactualizada);
                        return cantidadactualizada;
                    } else {
                        System.out.println("La cantidad no es posible de ingresar");
                        break;
                    }
                case 0:
                    rellenar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    
        return niveltanque; // Retorna el nivel actual si no se rellena combustible
    }

    public static boolean Verificarconducción (int Distancia, double rendimiento, double cantidadactualizada) {

        double combustiblenecesario = Distancia/rendimiento;

        return combustiblenecesario <= cantidadactualizada;

    }

    public static void conducir (int Distancia, double rendimiento, double cantidadactualizada) {

        double combustiblenecesario = Distancia/rendimiento;

        if (Verificarconducción(Distancia, rendimiento, cantidadactualizada)) {
            
            System.out.println("Realizando el viaje");
            System.out.println("El tanque de combustible ahora posee: "+(cantidadactualizada-combustiblenecesario));

        } else {
            System.out.println("Mejor me quedo en casa, esta  caro el combustible");
        }

    }

}

