package dam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Debes indicar la ruta del fichero.");
            sc.close();
            return;
        }

        String ruta = args[0];

        int opcion = 0;

        do {

            System.out.println("\n------ MODELO ------");
            System.out.println("1. Añadir usuarios");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Buscar por DNI.");
            System.out.println("4. Salir");
            System.out.print("Introduce una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Introduce un número.");
                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    AñadirUsuario(sc, ruta);
                    break;

                case 2:
                    MostrarUsuario(ruta);
                    break;
                    
                case 3:
                	BuscarPorID(sc, ruta);
                	break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }

    private static void BuscarPorID(Scanner sc, String ruta) {
		// TODO Auto-generated method stub
    	
    	System.out.println("Introduce el DNI a buscar: ");
    	String dni = sc.nextLine();
    	Controlador c = new Controlador();
    	c.BuscarDni(dni, ruta);
		
	}

	private static void AñadirUsuario(Scanner sc, String ruta) {

        int id = 0;
        boolean correcto = false;

        while (!correcto) {

            try {
                System.out.print("Introduce el ID del usuario: ");

                id = Integer.parseInt(sc.nextLine());

                correcto = true;

            } catch (NumberFormatException e) {

                System.out.println("El ID debe ser un número.");
            }
        }

        System.out.print("Añade el nombre del usuario: ");
        String nombre = sc.nextLine();

        System.out.print("Añade el DNI: ");
        String dni = sc.nextLine();

        Modelo persona = new Modelo(id, nombre, dni);

        Controlador c = new Controlador();

        c.Añadir(persona, ruta);
    }

    private static void MostrarUsuario(String ruta) {

        Controlador c = new Controlador();

        c.Mostrar(ruta);
    }
}

