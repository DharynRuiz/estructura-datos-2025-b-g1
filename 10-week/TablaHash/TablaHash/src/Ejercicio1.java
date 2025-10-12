import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashTable<String, String> usuarios = new HashTable<>(5); // PARA ESTE EJERCICIO CREAMOS UNA TABLA Y LE ASIGNAMOS UNA CAPACIAD DE 5 BUCKETS LAS CLAVES
        Scanner sc = new Scanner(System.in);                                // QUE SON LOS NOMBRES LOS DECLARAMOS EN STRING AL IGUAL QUE LOS VALORES QUE SON LOS ROLES
        int opcion;

        do {
            System.out.println("\n DICCIONARIO USUARIO");       // SE CREA UN PEQUEÑO MENU PARA PEDIR LA INFORMACION
            System.out.println("1. Agregar usuario");
            System.out.println("2. Consultar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Mostrar todos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Usuario: ");                          // MEDIANTE ESTOS CASE LE ASIGNAMOS LAS FUNCIONES A CADA CASO QUE SELECCIONE EL USUARIO EN ESTE CASO
                    String user = sc.nextLine();                            //PARA ELC ASO 1 ASIGNAMOS EL NOMBRE Y EL USUARIO, PARA EL CASO 2 CONSUTLARLOS, APRA EL CASO 3 ELIMINARLOS Y APRA EL CASO
                    System.out.print("Rol: ");                              // 4 IMPRIMOS LOQ UE TENEMOS GAURDADO Y BUENO EL CASO 5 SE ASIGNO LA SALIDA DEL MENU
                    String rol = sc.nextLine();
                    usuarios.put(user, rol);
                    break;
                case 2:
                    System.out.print("Usuario: ");
                    user = sc.nextLine();
                    System.out.println("Rol: " + usuarios.get(user));
                    break;
                case 3:
                    System.out.print("Usuario a eliminar: ");
                    user = sc.nextLine();
                    usuarios.remove(user);
                    break;
                case 4:
                        usuarios.imprimirTabla();
                    break;

            }
        } while (opcion!=5);
        sc.close();
    }
}
