/**
 * @nombre pila 
 * @inglés stack
 * 
 * @descripción
 * guardan datos ordenados en donde el último sea de mayor importancia
 * usan el método LIFO (last in, first out): último en entrar es el primero en salir
 * 
 * @analogía
 * pila de platos
 * 
 * @ejemplos
 * guardar un historial
 * subrutinas en un programa como el callstack en el motor de javascript
 * 
 * @implementación
 * similar a lista en javascript
 * añadir con método push()
 * sacar con método pop()
 * 
 * @notas
 * se puede usar como una lista en javascript
 */

 class Stack {

    length = 0;

    // ingresa un nuevo elemento
    push(item) {
        this[this.length] = item;
        this.length++;
        return this.length;
    }

    // remueve el elemento superior y lo retorna
    pop() {
        if (this.length == 0) { return undefined; }
        const item = this[this.length - 1];
        delete this[this.length - 1];
        this.length--;
        return item;
    }

    // retorna el elemento superior
    peek() {
        if (this.length == 0) { return undefined; }
        return this[this.length - 1];
    }

}

let pila = new Stack();
console.log(pila.length) // 0

pila.push('primero');
console.log(pila.length) // 1
console.log(pila.peek()) // 'first'

pila.push('segundo');
console.log(pila.length) // 2
console.log(pila.peek()) // 'segundo'

console.log(pila.pop()) // 'segundo'
console.log(pila.pop()) // 'primero'
console.log(pila.pop()) // undefined


/** Big-O */
// Acceder O(1)
// Buscar O(n)
let busco = 'primero';
let ultimo = pila.pop();
while (ultimo && busco !== ultimo) {
    ultimo = pila.pop();
}
console.log(ultimo);
// Insertar O(1)
pila.push('cuarto');
// Borrar O(1)
pila.pop();