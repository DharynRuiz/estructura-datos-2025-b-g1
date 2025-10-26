public class EjercicioArbolesBalanceados {

    class NodoAVL {
        int dato, altura;
        NodoAVL izquierda, derecha;

        public NodoAVL(int d) {
            dato = d;
            altura = 1;
        }
    }                       // DEFINIMOS COMO ES CADA NODO DEL ARBOL, DATO ES EL NUMERO QUE GUARDAMOS EN ESE NODO
                            // IZQUIERDA Y DERECHA APUNTAN A LOS HIJOS DEL NODO,ALTURA=1 CADA NUEVO NODO EMPIEZA CON UNA ALTURA 1


    class ArbolAVL {
        NodoAVL raiz;
                                // ESTA CLASE CONTIENE TODO LO NECESATRIO PARA MANEJAR EL ARBOL COMPLETO, DONDE LA RAIZ SERA EL PRIMER NODO DEL ARBOL

        int altura(NodoAVL N) {
            if (N == null) return 0;
            return N.altura;
        } // DEVUELVE LA ALTURA DEL NODO, SI EL NODO NO EXISTE ES NULL Y SU ALTURA ES 0

        int max(int a, int b) {
            return (a > b) ? a : b;
        }

        int obtenerBalance(NodoAVL N) {
            if (N == null) return 0;
            return altura(N.izquierda) - altura(N.derecha);
        } // CON ESTO CALCULAMOS SI UN NODO ESTA BALANCEADO, DONDE BLANCE = ALTURA (IZQUIERDA)-ALTURA (DERECHA)
        // SI EL RESULTADO ES MAYOR A1 O MENOR -1 HAY QUE ROTAR EL ARBOL


        NodoAVL rotacionDerecha(NodoAVL y) {
            NodoAVL x = y.izquierda;
            NodoAVL T2 = x.derecha;

            x.derecha = y;
            y.izquierda = T2;

            y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;
            x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;

            return x;
        } // CUANDO EL ARBOL ESTA INCLINADO A LA IZQUIERDA, GIRAMOS HACIA LA DERECHA APRA BALANCEARLO DONDE X SUBE Y YA BAJA
        //T2 ES EL HIJO QUE NO SE PIERDA SI NO QUE SE REACOMODA
        NodoAVL rotacionIzquierda(NodoAVL x) {
            NodoAVL y = x.derecha;
            NodoAVL T2 = y.izquierda;

            y.izquierda = x;
            x.derecha = T2;

            x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;
            y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;

            return y;
        } //USAMOS EL MISMO METODO PERO INVERTIMOS LA DIRECCION DE LA ROTACION


        NodoAVL insertarNodo(NodoAVL nodo, int clave) {
            if (nodo == null) return new NodoAVL(clave);

            if (clave < nodo.dato)
                nodo.izquierda = insertarNodo(nodo.izquierda, clave);
            else if (clave > nodo.dato)
                nodo.derecha = insertarNodo(nodo.derecha, clave);
            else
                return nodo;// CON ESTE METODO INSERTAMOS NODOS AL ARBOL BINARIO LUEGO ACTUALIZMAOS LAS ALTURAS Y VERIFICAMOS EL BALANCE

            nodo.altura = 1 + max(altura(nodo.izquierda), altura(nodo.derecha));

            int balance = obtenerBalance(nodo);

            if (balance > 1 && clave < nodo.izquierda.dato)
                return rotacionDerecha(nodo);
            if (balance < -1 && clave > nodo.derecha.dato)
                return rotacionIzquierda(nodo);
            if (balance > 1 && clave > nodo.izquierda.dato) {
                nodo.izquierda = rotacionIzquierda(nodo.izquierda);
                return rotacionDerecha(nodo);
            }
            if (balance < -1 && clave < nodo.derecha.dato) {
                nodo.derecha = rotacionDerecha(nodo.derecha);
                return rotacionIzquierda(nodo);
            }

            return nodo;
        }// SI EL ARBOL ESTA MUY CARGADO A UN LADO ROTAMOS PARA BALANCEAR

        public void insertar(int clave) {
            raiz = insertarNodo(raiz, clave);
        }

        public void preOrden(NodoAVL nodo) {
            if (nodo != null) {
                System.out.print(nodo.dato + " ");
                preOrden(nodo.izquierda);
                preOrden(nodo.derecha);
            } // CON ESTE METODO IMPRIMIMOS PRIMERO EL NODO ACTUAL LUEGO EL IZQUIERDO Y LUEGO EL DERECHO, VAMOS A VER COMO ESTA EL ARBOL

        }
    }

    // EJECUCION DEL CODIGO
    public static void main(String[] args) {
        EjercicioArbolesBalanceados programa = new EjercicioArbolesBalanceados();
        ArbolAVL arbol = programa.new ArbolAVL();

        int[] valores = {30, 20, 10, 25, 40, 50};

        for (int v : valores) {
            System.out.println("\nInsertando: " + v);
            arbol.insertar(v);
            System.out.print("PreOrden actual: ");
            arbol.preOrden(arbol.raiz);
            System.out.println();
        }

        System.out.println("\nÁrbol final (Recorrido PreOrden): ");
        arbol.preOrden(arbol.raiz);
    } // CRAMOS EL ARBOL, INSERTAMOS LO VALORES UNO POR UNO Y MOSTASMO COMO VA QUEDANDO EL ARBOL
}