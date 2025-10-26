import java.util.HashMap;
public class EjercicioHashMap {
    public static void main(String[] args) {

        HashMap<Integer, String> usuarios = new HashMap<>(); // CREAMOS UN HashMap llamado usuarios, aca se va a almacenar cada usuario con su ID
                                                            //ID como Integer y como clave su nombre que seria String este lo guardamos dentro del objeto usuarios

        usuarios.put(1075322719, "Dharyn");
        usuarios.put(1075247526, "Luis"); //AGREGAMOS VALORES AL HASHMAP CON .put
        usuarios.put(1003804256, "Julieta");// PARA GUARDAR LOS DATOS AQUI LA CLAVE SERA EL VALOR NUMERICO Y EL VALOR SERIA EL NOMBRE

        System.out.println("Usuarios registrados: " + usuarios); // IMPRIMIMOS EL HASHMAP COMPLETO

        System.out.println("Usuario con ID 1075322719: " + usuarios.get(1075322719)); // IMPRIMIMOS EL USUARIO QUE QUERAMOS UTILIZAMOS SU ID QUE EN ESTE CASO SERIA EL VALOR NUMERICO
    }
}
