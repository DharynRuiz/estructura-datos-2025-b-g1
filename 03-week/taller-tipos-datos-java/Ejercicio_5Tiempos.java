    public class Ejercicio_5Tiempos {
    public static void main(String[] args) {
        // Lista de tiempos de ejemplo (formato HH:MM:SS)
        String[] tiempos = {
            "00:10:33",
            "00:08:17",
            "00:08:50"
        };

        // Llamamos al método que hace todo el cálculo
        procesarTiempos(tiempos);
    }

    public static void procesarTiempos(String[] tiempos) {
        // 1. Convertimos cada tiempo a segundos para que sea más fácil trabajar
        long[] enSegundos = new long[tiempos.length];
        long total = 0;
        long max = Long.MIN_VALUE; // el tramo más largo
        int indiceMax = -1;        // para guardar dónde estuvo el máximo

        for (int i = 0; i < tiempos.length; i++) {
            String[] partes = tiempos[i].split(":"); // separa en HH, MM y SS
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            int segundos = Integer.parseInt(partes[2]);

            // Pasamos todo a segundos
            long seg = horas * 3600 + minutos * 60 + segundos;
            enSegundos[i] = seg;

            // Sumamos al total
            total += seg;

            // Revisamos si este tramo fue el más largo
            if (seg > max) {
                max = seg;
                indiceMax = i;
            }
        }

        // 2. Calculamos el promedio
        double promedio = (double) total / tiempos.length;

        // 3. Imprimimos resultados
        System.out.println("⏱ Tiempo total: " + formatearSegundos(total));
        System.out.println("📊 Promedio: " + formatearSegundos((long) promedio));
        System.out.println("🏆 Tramo más largo: " + tiempos[indiceMax] + " (posición " + indiceMax + ")");

        // 4. Calculamos porcentaje de cada tramo respecto al total
        System.out.println("📌 Porcentaje de cada tramo respecto al total:");
        for (int i = 0; i < enSegundos.length; i++) {
            double porcentaje = ((double) enSegundos[i] / total) * 100;
            System.out.printf("   - %s → %.2f%% %n", tiempos[i], porcentaje);
        }
    }

    // Método para convertir segundos de nuevo al formato HH:MM:SS
    private static String formatearSegundos(long segundos) {
        long h = segundos / 3600;
        long m = (segundos % 3600) / 60;
        long s = segundos % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}