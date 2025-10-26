import java.util.Stack;
public class EjercicioPila {
    public static void main(String[] args) {
        Stack<String> Deshacer = new Stack<>();
        Stack<String> Rehacer = new Stack<>();  // CREACION DE PILAS PARA EL ALMACENAMIENTO DEL TEXTO SOLO PARA
        String texto = "";       // VARIABLE VACIA               //ALMACENAR String

            // INGRESAMOS EL TEXTO
        Deshacer.push(texto);
        texto += "Dharyn ";
        Deshacer.push(texto);   // AHORA EN LA PILA YA TENEMOS DOS VALORES GUARDADOS CON LA OPCION DE PUSH LA ENVIAMOS A LA PILA
        texto += "Ruiz";

        System.out.println("Texto actual: " + texto); // IMPRIMIMOS LO QUE TENEMOS GAURDADO

        // DESHACEMOS EL VALOR, EN ESTE CASO COMO MANEJAMOS LIFO EL SERIA EL ULTIMO TEXTO INGRESADO
        Rehacer.push(texto);
        texto = Deshacer.pop();
        System.out.println("Después de deshacer: " + texto); // CON LA OPCION POP IMPRIMIMOS EL VALOR QUE TENEMOS ALMACENADA EN LA PILA

        // REHACEMOS EL VALOR ELIMINADO
        Deshacer.push(texto);
        texto = Rehacer.pop();      // COMO YA TENIAMOS EL TEXTO INICIAL ALMACENADO EN REHACER LO QUE HACEMOS ES LLAMARLO Y CON ESO IMPRIMOS EL TEXTO INICIAL ALMACENADO
        System.out.println("Después de rehacer: " + texto); // IMPRIMIMOS EL VALOR ALMACENADO EN LA PILA
    }
}
