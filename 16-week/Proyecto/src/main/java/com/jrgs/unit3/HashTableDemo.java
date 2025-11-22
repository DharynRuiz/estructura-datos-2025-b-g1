package com.jrgs.unit3;

import javax.swing.*;
import java.util.Hashtable;

public class HashTableDemo {

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "DEMO DE HASHTABLE:\n" +
                        "- Guarda pares clave → valor.\n" +
                        "- Puedes agregar, buscar y eliminar.");

        Hashtable<String, String> tabla = new Hashtable<>();

        while (true) {

            String opcion = JOptionPane.showInputDialog(
                    "¿Qué deseas hacer?\n" +
                            "1. Insertar (put)\n" +
                            "2. Buscar (get)\n" +
                            "3. Eliminar (remove)\n" +
                            "4. Ver tabla\n" +
                            "5. Salir");

            if (opcion == null) return;

            switch (opcion) {

                case "1":
                    String key = JOptionPane.showInputDialog("Clave:");
                    String value = JOptionPane.showInputDialog("Valor:");
                    tabla.put(key, value);
                    break;

                case "2":
                    String k = JOptionPane.showInputDialog("Clave a buscar:");
                    String result = tabla.get(k);
                    JOptionPane.showMessageDialog(null,
                            (result != null ? "Valor: " + result : "No existe esa clave."));
                    break;

                case "3":
                    String eliminar = JOptionPane.showInputDialog("Clave a eliminar:");
                    tabla.remove(eliminar);
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, "Contenido actual:\n" + tabla);
                    break;

                case "5":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}

