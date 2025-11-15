> ## EJERCICIO 1 Red Social
| Operación     | Descripción                            | Pasos aproximados | Complejidad  |
| ------------- | -------------------------------------- | ----------------- | ------------ |
| `addVertex()` | Agregar usuario (vértice)              | 1 paso            | **O(1)**     |
| `addEdge()`   | Crear amistad (conexión bidireccional) | 1 paso            | **O(1)**     |
| `bfs("Ana")`  | Recorrido desde un usuario inicial     | V + E pasos       | **O(V + E)** |
> ## EJERCICIO 2 Mapa Ciudades
| Operación       | Descripción                              | Pasos aproximados | Complejidad  |
| --------------- | ---------------------------------------- | ----------------- | ------------ |
| `addVertex()`   | Agregar ciudad                           | 1 paso            | **O(1)**     |
| `addEdge()`     | Crear carretera entre ciudades           | 1 paso            | **O(1)**     |
| `bfs("Bogotá")` | Recorrer el mapa desde una ciudad origen | V + E pasos       | **O(V + E)** |

> ## EJERCICIO 3 Componentes Conexos
| Operación     | Descripción                                | Pasos aproximados | Complejidad    |
| ------------- | ------------------------------------------ | ----------------- | -------------- |
| `addVertex()` | Agregar vértice aislado                    | 1 paso            | **O(1)**       |
| `addEdge()`   | Conectar dos nodos dentro de un componente | 1 paso            | **O(1)**       |
| `bfs("A")`    | Recorrer un componente                     | V₁ + E₁ pasos     | **O(V₁ + E₁)** |

> ## EJERCICIO 4 Comparacion BFS vs DFS
| Algoritmo  | Descripción                                     | Pasos aproximados | Complejidad  |
| ---------- | ----------------------------------------------- | ----------------- | ------------ |
| `bfs("A")` | Recorrido por niveles (anchura)                 | V + E pasos       | **O(V + E)** |
| `dfs("A")` | Recorrido en profundidad (usa recursión o pila) | V + E pasos       | **O(V + E)** |
