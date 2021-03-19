
/*TAREA: ESCRIBA UN PROCEDIMIENTO QUE IMPRIMA LA INFORMACION
ALMACENADA EN LOS NODOS INTERNOS DE UN ARBOL BINARIO*/

package arbolbinario;
//INIICA LA CLASE ARBOL
//@myn0r
class Arbol {

    private NodoArbol raiz;

//SE INICIA CONSTRUYENDO UN ARBOL VACIO
    public Arbol() {
        raiz = null;
    }

//HACE UNA INSERSIÓN DE UN NODO EN EL ARBOL
    public synchronized void insertarNodo(int valorInsertar) {
        if (raiz == null) {

            //SE CREA EL NODO PADREO O RAZIZ
            raiz = new NodoArbol(valorInsertar);
        } else {

            //INSTANCIA EL METODO INSERTAR
            raiz.insertar(valorInsertar);
        }
    }

//RECORRIDO EN PREORDEN
    public synchronized void recorridoPreorden() {
        ayudantePreorden(raiz);
    }

    //ESTE ES ELMETODO RECURSIVO PARA RECCORRER EN PREORDEN
    private void ayudantePreorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        //MUESTRA LOS DATOS DEL NODO
        System.out.print(nodo.datos + " ");
        //RECORRE EL SUBARBOL IZQUIERDO
        ayudantePreorden(nodo.nodoizquierdo);
        //RECORRE EL SUBARBOL DERECHO
        ayudantePreorden(nodo.nododerecho);
    }

    //RECORRIDO EN INORDEN
    public synchronized void recorridoInorden() {
        ayudanteInorden(raiz);
    }

    // ESTE ES ELMETODO RECURSIVO PARA RECCORRER EN INORDEN
    private void ayudanteInorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        ayudanteInorden(nodo.nodoizquierdo);
        System.out.print(nodo.datos + " ");
        ayudanteInorden(nodo.nododerecho);
    }

    //RECORRIDO EN POSORDEN
    public void recorridoPosorden() {
        ayudantePosorden(raiz);
    }

    //  ESTE ES ELMETODO RECURSIVO PARA RECCORRER EN POSORDEN
    private void ayudantePosorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        ayudantePosorden(nodo.nodoizquierdo);
        ayudantePosorden(nodo.nododerecho);
        System.out.print(nodo.datos + " ");
    }

}//TERMINA LA CLASE ARBOL

//INICIA LA CLASE NODOARBOL
class NodoArbol {

//INTEGRANTES DE LAS ENTRADAS
    NodoArbol nodoizquierdo;
    int datos;
    NodoArbol nododerecho;

//INICIA EL DATO Y HACE QUE ESTE SEA UN NODO HIJO U HOJA.
    public NodoArbol(int datosNodo) {
        datos = datosNodo;
        //ESTE NODO NO TIENE HIJOS U HOJAS
        nodoizquierdo = nododerecho = null;
    }

//HACE UNA BUSQUEDA PARA INSERTAR UN NODO
    public void insertar(int valorInsertar) {

//INSERTA EL NODO EN EL SUBARBOL IZQUIERDO
        if (valorInsertar < datos) {

//INSERTA UN NUEVO NODO ARBOL
            if (nodoizquierdo == null) {
                nodoizquierdo = new NodoArbol(valorInsertar);

                //SIGUE RECORRIENDO EL SUBARBOL IZQUIERDO
            } else {
                nodoizquierdo.insertar(valorInsertar);
            }

        } //INSERTA UN NODO DERECHO
        else if (valorInsertar > datos) {

//INSERTA UN NUEVO NODO ARBOL
            if (nododerecho == null) {
                nododerecho = new NodoArbol(valorInsertar);
                //SIGUE RECORRIENDO EL SUBARBOL DERECHO
            } else //continua recorriendo subarbol derecho
            {
                nododerecho.insertar(valorInsertar);
            }
        }
    } //TERMINA EL METODO INSERTAR

} //TERMINA LA CLASE NODOARBOL

// AQUI TERMINA LA CONSTRUCCION Y EL RECORRIDO DEL ARBOL
//ESTE ES EL METODO PRINCIPAL PARA MOSTRAR Y GENERAR EL ARBOL
public class ArbolBinario {

    public static void main(String args[]) {
        Arbol arbol = new Arbol();
        int valor;

        System.out.println("\nARBOL ORIGINAL");

// ESCRIBE 10 NUMERSO AL AZAR ENTRE 0 Y 99 PARA DARLE VALOR A LOS NODOS
        for (int contador = 1; contador <= 10; contador++) {
            valor = (int) (Math.random() * 100);
            System.out.print(valor + " ");
            arbol.insertarNodo(valor);
        }
        System.out.println("\n-------------------------------");

        //MUESTRA EN PANTALLA LOS RECORRIDOS
        System.out.println("\n\n ARBOL EN PREORDEN");
        arbol.recorridoPreorden();

        System.out.println("\n\n ARBON EN INORDEN");
        arbol.recorridoInorden();

        System.out.println("\n\n ARBOL EN POSORDEN");
        arbol.recorridoPosorden();
    }
}
