/**
 * @nombre cola 
 * @inglés queue
 * 
 * @descripción
 * guardan datos ordenados en donde el primero sea de mayor importancia
 * usan el método FIFO (first in, first out): primero en entrar es el primero en salir
 * 
 * @analogía
 * cola de personas
 * 
 * @ejemplos
 * recorrer árboles por nivel
 * servir pedidos en orden
 * cola de eventos en el motor de javascript
 * 
 * @implementación
 * similar a lista en javascript
 * añadir con método push()
 * sacar con método shift()
 * 
 * @notas
 * se puede usar a partir de una lista en javascript
 * "cola de prioridad" es otra estructura de datos similar que al añadir el elemento hay que indicar una prioridad y se ordena de acuerdo a esta
 */

class Queue {

    length = 0;
    #first = 0;

    // ingresa un nuevo elemento
    enqueue(item) {
        this[this.length] = item;
        this.length++;
        return this.length;
    }

    // remueve el elemento superior y lo retorna
    dequeue() {
        let size = this.length - this.#first;
        if (size === 0) { return undefined; }
        const item = this[this.#first];
        delete this[this.#first];
        this.#first++;
        return item;
    }

    // retorna el elemento superior
    front() {
        let size = this.length - this.#first;
        if (size === 0) { return undefined; }
        return this[this.#first];
    }

}

let cola = new Queue();
console.log(cola.length) // 0

cola.enqueue('primero');
console.log(cola.length) // 1
console.log(cola.front()) // 'primero'

cola.enqueue('segundo');
console.log(cola.length) // 2
console.log(cola.front()) // 'primero'

console.log(cola.dequeue()) // 'primero'
console.log(cola.dequeue()) // first
console.log(cola.dequeue()) // undefined

/* Big-O */
// Acceder O(1)
// Buscar O(n)
let busco = 'tres';
let primer = cola.shift();
while (primer && busco !== primer) {
    primer = cola.shift();
}
console.log(primer);
// Insertar O(1)
cola.push('cuatro');
// Borrar O(1)
cola.shift();