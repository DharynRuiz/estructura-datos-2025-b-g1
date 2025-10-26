public class EjercicioArbolBst {

    class Nodo {
        int valor;
        EjercicioArbolBst.Nodo izq, der;

        public Nodo(int valor) {
            this.valor = valor;
            izq = der = null;
        }
    }
    //EN ESTA CLASE REPRESENTAMOS CADA DATO ALMACENADO EN EL ARBOL DONDE INT VALOR ES EL NUMERO QUE TENDRA EL NODO, NODO IZQ Y DER
    // SON LAS FLECHAS QUE APUNTAN AL HIJO SEA IZQUIERDO O DERECHO, CON EL METODO CONSTRUCTOR CREAMOS UN NUEVO NODO LE ASIGANAMOS UN VALOR
    // Y CANCELAMOS LA DIRECCION PORQ UE AUN NO TIENE HIJOS

    EjercicioArbolBst.Nodo raiz;

    // CREMODS LA RAIZ DEL ARBOL

    public EjercicioArbolBst.Nodo insertar(EjercicioArbolBst.Nodo nodo, int valor) {
        if (nodo == null) {
            return new EjercicioArbolBst.Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izq = insertar(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = insertar(nodo.der, valor);
        }
        return nodo;
    }
// METODO PARA LA INSERSION DE NODOS DONDE NOS APOYAMOS CON IF PARA QUE SI LLEGAMOS DONDE NO HAY NODO SIGNIFICA QUE ENCONTRAMSO UN LUGAR
    //CORRECTO PARA INSERTAR EL NUEVO NODO, SI EL VALOR QUE QUERMOS INSERTAR ES MENOR QUE EL ACTUAL ALMACENAMOS A LA IZQUIERDA YA QUE A ESE LADO VAN LOS QUE SON MENORES
    //PERO AL CONTRARIO SI EL VALOR ES MAYO LO ALMACENAMOS A LA DERECHA, RETORNAMOS EL NODO ACTUAL PARA QUE LA ESTRUCTURA DEL ARBOL SE MANTENGA CONECTADA

    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    public boolean buscar(EjercicioArbolBst.Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (nodo.valor == valor) return true;
        return valor < nodo.valor ? buscar(nodo.izq, valor) : buscar(nodo.der, valor);
    }
    // CON ESTE METODO RECORREMOS EL ARBOL BUSCANDO UN NUMERO ESPECIFICO DONDE EL IF NODO = NULL SI LLEGAMOS AUN NODO VACIO Y EL VALOR NO EXISTE
    // SI IF NODO.VALOR = VALOR SI ENCONTRAMOS EL VALOR EXACTO DEVOLVEMOS UN VALOR DE TRUE
    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    // CON ESTE METODO ENCONTRAMOS UN VALOR MINIMO DE UN NODO HACIA LA IZQUIERDA
    public EjercicioArbolBst.Nodo minimoValor(EjercicioArbolBst.Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }


    public EjercicioArbolBst.Nodo eliminar(EjercicioArbolBst.Nodo nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.valor) {
            nodo.izq = eliminar(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = eliminar(nodo.der, valor);
        } else {
            // CASO 1 NODO SIN HIJOS
            if (nodo.izq == null && nodo.der == null) {
                return null;
            }
            // CASO 2 NODO CON 1 HIJO
            else if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            }
            // CASO 3 NODO CON DOS HIJOS
            EjercicioArbolBst.Nodo temp = minimoValor(nodo.der);
            nodo.valor = temp.valor;
            nodo.der = eliminar(nodo.der, temp.valor);
        }
        return nodo;
    }
    // MEDIANTE ESTE METODO ELIMINAMOS UN NODO MEDIANTE 3 POSIBLES CASOS, EL NODO NO TIENE HIJOS SE ELIMINA SIMPLEMENTE RETORNANDO UN NULL
    // SI EL NODO SOLO TINEE UN SOLO HIJO SE REMPLAZA POR SU UNICO HIJO SEA IZQUIERDA O DERECHA
    //EL NODO TIENE DOS HIJOS SE BUSCA EL MENOR VALOR DEL SUBARBOL DERECHO SE COPIA ESE VALOR EN EL NODO ACTUAL UY LUEGO SE ELIMINA ESE VALOR DUPLICADO EN EL SUBARBOL DERECHO
    public void eliminar(int valor) {
        raiz = eliminar(raiz, valor);
    }

    // MOSTRAR ARBOO INORDEN (izq - raíz - der)
    public void inOrden(EjercicioArbolBst.Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izq);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.der);
        }
    }

    // LLAMDA PUBLICA PARA MOSTRAR in-orden
    public void mostrar() {
        inOrden(raiz);
        System.out.println();
    }

    // INICIALIZACION DEL EJERCICIO
    public static void main(String[] args) {
        EjercicioArbolBst arbol = new EjercicioArbolBst();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Árbol In-Orden:");
        arbol.mostrar();

        System.out.println("Buscar 40: " + arbol.buscar(40));
        System.out.println("Eliminar 50");
        arbol.eliminar(50);
        arbol.mostrar();
    }
}
