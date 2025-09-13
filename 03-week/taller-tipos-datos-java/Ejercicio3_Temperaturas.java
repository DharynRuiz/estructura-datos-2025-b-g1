public class Ejercicio3_Temperaturas {
public static void main(String[] args) {
        // ingresamos valores separados por comas
        String datos = "23.4,21.8,22.1,24.0,26.5";

        // Separamos los datos en un arreglo de string y split
        String[] partes = datos.split(",");

        // ingresamos lo valores
        double suma = 0.0;
        double min = Double.MAX_VALUE;   // empieza con un valor muy grande
        double max = Double.MIN_VALUE;   // empieza con un valor muy pequeño
        int n = 0;                       // contador para valores válidos

        //  calcular suma, min y max
        for (String p : partes) {
            p = p.trim(); // elimina espacios
            if (p.isEmpty()) continue; // ignorar entradas vacías

            double valor = Double.parseDouble(p);
            suma += valor;
            if (valor < min) min = valor;
            if (valor > max) max = valor;
            n++;
        }

        // Calcular promedio
        double promedio = suma / n;

        // Segundo recorrido: calcular varianza
        double varianza = 0.0;
        for (String p : partes) {
            p = p.trim();
            if (p.isEmpty()) continue;

            double valor = Double.parseDouble(p);
            varianza += Math.pow(valor - promedio, 2);
        }
        varianza = varianza / n;

        // Desviación estándar
        double desviacion = Math.sqrt(varianza);

        // Mostrar resultados
        System.out.println("Temperaturas: " + datos);
        System.out.println("Cantidad de datos: " + n);
        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);
        System.out.println("Promedio: " + promedio);
        System.out.println("Desviación estándar: " + desviacion);
    }
}
