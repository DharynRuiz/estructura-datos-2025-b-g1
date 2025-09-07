# BIBLIOTECA U1 

### 1. NECESITA REGISTRAR UN CATALODO DE LIBROS DESCRIMINADOS POR CODIGO, LIBRO, AUTOR
### 2. ADMINSITRAR PRESTAMOS POR USUARO, CODIGO, LIBRO, FECHA Y SI ESTA DISPONIBLE
### 3. UN HISTORIAL DE OPEREACIONES 
### 4. UN SISTEMA DE COSULTAS POR TITULO COGIGO E.T.C

# DESCRIPCION:
### EN ESTE PROGRAMA SE IMPLEMENTO UN SISTEMA DE GESTION PARA UNA BIBLIOTECA EN BASE A LAS ESPECIFICACIONES

# COMO COMPILAR Y EJECUTAR

## estructuras y complejidad :
- Catálogo: array fijo Libro[] catalogo; operaciones de inserción/búsqueda usan
  búsqueda lineal O(n) porque el tamaño es moderado y se exige uso de arrays.
- Disponibilidad por sucursal: int[][] disponibilidad (filas=libros, columnas=sucursales).
  Actualizar y consultar es O(1) dado el índice del libro.
- Préstamos activos: lista enlazada simple (nodos PrestamoNode). Inserción al
  inicio o final O(1) si se mantienen punteros; eliminación requiere recorrido O(n)
  hasta encontrar el préstamo.
- Historial: lista doblemente enlazada (nodos HistorialNode) que permite recorrer
  hacia adelante y atrás en O(n) para recorrer todo el historial.

# COMO COMPILAR Y EJECUTAR

- PRIMERO LLENAMOS LA BASE DE DATOS CON LA INFORMACION QUE QUERRAMOS SUMINISTRAR
- DESPUES EMPEZAMOS A REALIZAR LO QUE ES CARGA DE DATOS, BUSQUEDA, PRESTAMOS, HISTORIAL, DEVOLUCIONES Y STOCK

