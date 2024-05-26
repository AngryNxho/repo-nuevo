/**
 * @nombre lista enlazada
 * @inglés linked list
 * 
 * @descripción
 * guardar datos ordenados de forma dinámica
 * no requiere memoria contínua como las listas
 * es mas eficiente cuando se elimina un elemento ya que no hay que mover el reto de elementos
 * eficiente en expadir tamaño ya que no tengo que copiar todo un bloque de memoria
 * eficiente en añadir al inicio o al final sin reordenar elementos como en lista, dificil de acceder por indice
 * 
 * @analogía
 * carros de un tren
 * 
 * @aplicaciones
 * colisiones en tabla hash
 * alocación de memoria en blocques libres
 * 
 * @implementación
 * Se basa en otra estructura, un "nodo"
 * 
 * @notas
 * "listas enlazadas circulares" son estructuras de datos similares en donde el último elemento apunta al primero
 * "listas doblemente enlazadas" son estructuras de datos similares en donde un nodo apunta al elemento Nodo previo y al siguiente
 */

class Node {
    constructor(value, next = null) {
        this.value = value
        this.next = next
    }
}

/* Simple solo usando nodos */
const lista_enlazada = new Node(1,
    new Node(2,
        new Node(3,
            new Node(4)
        )
    )
);

console.log(JSON.stringify(lista_enlazada, null, 2))

/* Formalizada */
class LinkedList {

    length = 0;
    head = null;

    add(valor) {
        let nodo = new Node(valor);
        if (this.head == null) {
            this.head = nodo;
        } else {
            let curr = this.head;
            while (curr.next) {
                curr = curr.next;
            }
            curr.next = nodo;
        }
        this.length++;
    }
}

const lista_enlazada_formal = new LinkedList();
lista_enlazada_formal.add(1);
lista_enlazada_formal.add(2);
lista_enlazada_formal.add(3);
lista_enlazada_formal.add(4);

console.log(JSON.stringify(lista_enlazada_formal, null, 2))
