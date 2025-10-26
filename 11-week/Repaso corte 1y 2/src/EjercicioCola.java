
import java.util.PriorityQueue;

public class EjercicioCola {
    public static void main(String[] args) {
        PriorityQueue<String> colaPrioridad = new PriorityQueue<>(); // CREAMOS UN COLA PARA ALMACENAR LOS DATOS


        colaPrioridad.add("3-Dharyn");
        colaPrioridad.add("1-Carlos");     // AGREGAMOS LOS VALORES A LA COLA, EL PRIMER VALOR INGRESADO QUE SERIA 3-Dharyn
        colaPrioridad.add("2-Juan");        // SERA EL DE PRIORIDAD BAJA Y A 2-Juan COMO ES EL UTLIMO SERA EL NUESTRA PRIORIDAD ALTA


        System.out.println("Cola completa (orden interno): " + colaPrioridad); // IMRPIMIMOS LOS VALORES ALMACENADOS


        System.out.println("Atendiendo a: " + colaPrioridad.poll());// CON .poll LLAMAMOS EN EL ORDEN QUE VAMOS A ATENDER AL CLIENTE QUE TIENE MAYOR PRIORIDAD QUE SERIA
                                                                    // 2-Juan POR EL ORDEN EN EL QUE VA QUEDANDO REGISTRADO EN LA COLA

        System.out.println("Cola restante: " + colaPrioridad); // MOSTRAMOS EL RESTANTE DE LA COLA
    }
}
