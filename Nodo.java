
/*
Escriba un procedimiento que elimine todas las hojas de un árbol binario.
PRIMERO HAY QUE CREAR EL ARBOL PARA ELIMINAR LOS NODOS QUE TENDRIA
 */
package ArbolBinarioBorrarNodos;
//myn0r
import java.util.Objects;
import java.util.Optional;

public class Nodo {

    private Integer valor;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void ajustarValor(Integer valor) {
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierda(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecha() {
        return derecho;
    }

    public void setDerecha(Nodo derecho) {
        this.derecho = derecho;
    }

    public void Agregar(Integer valor) {
        if (valor < this.valor) {
            if (izquierdo != null) {
                izquierdo.Agregar(valor);
            } else {
                izquierdo = new Nodo(valor);
            }
        } else {
            if (derecho != null) {
                derecho.Agregar(valor);
            } else {
                derecho = new Nodo(valor);
            }
        }
    }

    public Optional<Nodo> buscar(Integer valor) {
        if (Objects.equals(valor, this.valor)) {
            return Optional.of(this);
        } else if (valor < this.valor) {
            if (this.izquierdo != null) {
                return this.izquierdo.buscar(valor);
            } else {
                return Optional.empty();
            }
        } else {
            if (this.derecho != null) {
                return this.derecho.buscar(valor);
            } else {
                return Optional.empty();
            }
        }
    }

    public void Inorden() {
        if (izquierdo != null) {
            izquierdo.Inorden();
        }
        System.out.println(valor);
        if (derecho != null) {
            derecho.Inorden();
        }
    }

    public void Preorden() {
        System.out.println(valor);
        if (izquierdo != null) {
            izquierdo.Preorden();
        }
        if (derecho != null) {
            derecho.Preorden();
        }
    }

    public void PosOrden() {
        if (izquierdo != null) {
            izquierdo.Preorden();
        }
        if (derecho != null) {
            derecho.Preorden();
        }
        System.out.println(valor);
    }

    public Nodo buscarPredesesor() {
        if (this.getDerecha() == null) {
            return this;
        } else {
            return this.getDerecha().buscarPredesesor();
        }
    }

    public Nodo buscarSusesor() {
        if (this.getIzquierdo() == null) {
            return this;
        } else {
            return this.getIzquierdo().buscarSusesor();
        }
    }

//PROCEDIMIENTO PARA BORRAR LOS NODOS DE UN ARBOL
    public Nodo borrar(Integer valor) {
        Nodo respuesta = this;
        if (valor < this.valor) {
            this.izquierdo = this.izquierdo.borrar(valor);
        } else if (valor > this.valor) {
            this.derecho = this.derecho.borrar(valor);
        } else {
            if (this.izquierdo != null && this.derecho != null) {
                Nodo temporal = this;
                Nodo maxDeLaDerecha = this.izquierdo.buscarPredesesor();
                this.valor = maxDeLaDerecha.getValor();
                temporal.izquierdo = temporal.izquierdo.borrar(maxDeLaDerecha.getValor());
            } else if (this.izquierdo != null) {
                respuesta = this.izquierdo;
            } else if (this.derecho != null) {
                respuesta = this.derecho;
            } else {
                respuesta = null;
            }
        }
        return respuesta;
    }
}
