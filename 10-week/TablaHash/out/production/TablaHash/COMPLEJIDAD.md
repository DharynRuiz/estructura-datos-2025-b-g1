# *ANALISIS DE COMPLEJIDAD*

## *OBJETIVO DEL TALLER*

que el estudiante construya una tabla hash sencilla, entendiendo su función de
dispersión y cómo se resuelven las colisiones con encadenamiento.

# TABLA DE COMPLEJIDAD GENERARL
| Operación    | Complejidad promedio | Explicación                                                                                 |
| ------------ | ---------------- | ------------------------------------------------------------------------------------------- |
| **Insertar** | **O(1)**         | La función hash calcula el índice y se inserta directamente en la posición correspondiente. |
| **Buscar**   | **O(1)**         | Se accede directamente al índice; en promedio, se recorre muy poca o ninguna lista.         |
| **Eliminar** | **O(1)**         | Se calcula el índice y se elimina la entrada de la lista enlazada si existe.                |

# TABLA DE COMPLEJIDAD INDIVIDIAL POR EJERCICIO

| Operación    | Peor caso    | Explicación                                                                                           |
| ------------ |--------------| ----------------------------------------------------------------------------------------------------- |
| **Insertar** | **O(n)**     | Si todas las claves caen en el mismo bucket (muchas colisiones), se debe recorrer una lista completa. |
| **Buscar**   | **O(n)**     | Si todas las claves están encadenadas en la misma posición, hay que revisar toda la lista.            |
| **Eliminar** | **O(n)**     | Igual que buscar: se recorre toda la lista para encontrar el elemento a eliminar.                     |
    
# CONCLUSION DEL TALLER

 En resumen una tabla hash es muy rapida para acceder directamente al dato que se busca si tener que recorrer todos los elementos
por eso insertar, buscar o eliminar algo maneja un tiempo constante.

pero si muchas claves caen en el mismo lugar osea las colisiones la tabla empieza a comportarse como una lista normal
donde debe recorrer varios elementos para encontrar el que se indica