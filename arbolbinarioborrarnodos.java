/*
Escriba un procedimiento que elimine todas las hojas de un árbol binario.

 */
package ArbolBinarioBorrarNodos;
//@myn0r
public class arbolbinarioborrarnodos {

    public static void main(String[] args) {
        Nodo principal = new Nodo(32);
        //inserta los nodos
        principal.Agregar(87);
        principal.Agregar(43);
        principal.Agregar(65);
        principal.Agregar(140);
        principal.Agregar(199);
        principal.Agregar(130);
        principal.Agregar(22);
        principal.Agregar(56);
        principal.Agregar(135);
        principal.Agregar(93);
        System.out.println("ARBOL EN PREORDEN");
        principal.Preorden();
        
        //elimina los nodos requeridos
        principal.borrar(87);
        principal.borrar(199);
        principal.borrar(135);
        System.out.println("\nARBOL CON NODOS BORRADOS");
        principal.Preorden();

    }
}
