package dam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controlador {

    public void Añadir(Modelo persona, String ruta) {
    	File ruta1 = new File(ruta);

        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta1, true))){
            

            escribir.write(persona.getId() + ";"
                    + persona.getNombre() + ";"
                    + persona.getDni());

            escribir.newLine();

            escribir.close();
         

            System.out.println("Usuario añadido correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }

    public void Mostrar(String ruta) {
    	File ruta1 = new File(ruta);

        try (BufferedReader leer = new BufferedReader(new FileReader (ruta1))){
            

            String linea;

            while ((linea = leer.readLine()) != null) {

                String[] datos = linea.split(";");

                
                    System.out.println("----------------------");
                    System.out.println("ID: " + datos[0]);
                    System.out.println("Nombre: " + datos[1]);
                    System.out.println("DNI: " + datos[2]);
                
            }

            leer.close();
           

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public void BuscarDni(String dni, String ruta) {

        File ruta1 = new File(ruta);

        try (BufferedReader leer = new BufferedReader(new FileReader(ruta1))) {

            String linea;
            boolean encontrado = false;

            while ((linea = leer.readLine()) != null) {

                String[] datos = linea.split(";");

                if ( datos[2].equals(dni) ) {

                    System.out.println("----------------------");
                    System.out.println("ID: " + datos[0]);
                    System.out.println("Nombre: " + datos[1]);
                    System.out.println("DNI: " + datos[2]);

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("No se ha encontrado ningún usuario con ese DNI.");
            }

        } catch (IOException e) {
            System.out.println("Error al buscar el usuario: " + e.getMessage());
        }
    }
}

