public class EjercicioArbolBinario {
    static class Nodo {
        int valor;
        Nodo izq;
        Nodo der;
//EN ESTA CLASE NODO GUARDAMOS CON INT VALOR EL DATO DEL NODO DENTRO DEL OBJETO NODO CON NODO IZQ Y DER VAMOS A DESPLAZARNOS POR EL NODO

        public Nodo(int valor) {
            this.valor = valor;             // CRAMOS EL CONSTRUCTOR PARA GUARDAR EL VALOR DE NODO  EN THIS.NODO
            this.izq = null;
            this.der = null;
        }
    }

    public static class ArbolBinario {
        Nodo raiz; // AQUI GUARDAMOS EL PRIMERO NODO DEL ARBOL SI ESTUVIERA VACIO DA NULL


        public void insertar(int valor) { // INSERTAMOS UN VALOR EN EL ARBOL
            raiz = insertarRec(raiz, valor); // CREAMOS UN METODO PARA UBICAR EL NODO
        }

        // CREAMOS UN METODO PARA INSERTAR EL RECURSO
        private Nodo insertarRec(Nodo actual, int valor) {
            if (actual == null) {
                return new Nodo(valor); // SI EL LUGAR ESTA VACIO CREAMOS UN NODO ACA
            }
            if (valor < actual.valor) {
                actual.izq = insertarRec(actual.izq, valor); // SI NO GUARDAMOS EL VALOR EN EL LADO IZQUIERDO
            } else {
                actual.der = insertarRec(actual.der, valor); // SI NO GAURDAMOS EN VALOR EN EL LADO DERECHO
            }
            return actual;
        }

        //HACEMOS EL RECORRIDO EN ORDEN IZQUIERDA, RAIZ Y DERECHA
        public void inOrden(Nodo nodo) {
            if (nodo != null) {
                inOrden(nodo.izq);
                System.out.print(nodo.valor + " ");
                inOrden(nodo.der);
            }
        }

        // HACEMOS EL RECORRIDO EN PREORDEN RAIZ, IZQUIERDA Y DERECHA
        public void preOrden(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.valor + " ");
                preOrden(nodo.izq);
                preOrden(nodo.der);
            }
        }

        // HACEMOS EL RECORRIDO POSTORDEN IZQUIERDA, DERECHA Y RAIZ
        public void postOrden(Nodo nodo) {
            if (nodo != null) {
                postOrden(nodo.izq);
                postOrden(nodo.der);
                System.out.print(nodo.valor + " ");
            }
        }

        public static void main(String[] args) {
                ArbolBinario arbol = new ArbolBinario();    //INICIALIZAMOS

                arbol.insertar(50);
                arbol.insertar(30);
                arbol.insertar(70);
                arbol.insertar(20); // INGRESAMOS VALORES
                arbol.insertar(40);
                arbol.insertar(60);
                arbol.insertar(80);

                System.out.print("InOrden: "); //
                arbol.inOrden(arbol.raiz);

                System.out.print("\nPreOrden: ");       // INCIALIZAMOS LOS ORDENES E IMPRIMIMOS LOS RESULTADOS
                arbol.preOrden(arbol.raiz);

                System.out.print("\nPostOrden: ");
                arbol.postOrden(arbol.raiz);
        }

    }
}
