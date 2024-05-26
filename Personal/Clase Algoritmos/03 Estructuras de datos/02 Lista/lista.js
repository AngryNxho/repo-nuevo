/**
 * @nombre lista | arreglo | vector | formación
 * @inglés list | array | vector | formation
 * 
 * @descripción
 * guardar datos donde el orden es importante
 * son finitas, homogéneas, ordenadas
 * 
 * @analogía
 * orden de cartas
 * 
 * @aplicaciones
 * guardar valores continuos como letras del abecedario
 * guardar numeros en algoritmos como fibonacci
 * se usa para implementar colas y pilas
 * 
 * @implementación
 * usan una porción continua de memoria guardando la direccion del primer elemento
 * el acceso a otros elementos es inmediato conociendo el indice
 * el indice empieza en 0
 * generalmente para aumentar/disminuir su tamaño hay que copiarlas 
 * muchos lenguajes copian la lista con nuevas nuevas casillas vacías o menos casillas
 * eficiente en acceder a elementos por indice pero inieficiente si añadimos elementos al inicio de la lista porque debe reordenar
 *
 * @notas
 * javascript usa listas dinámicas y su implementación es distinta ya que todo es un objeto
 * no usan memoria continua en javascript
 * listas reales en javascript: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Typed_arrays
 */

// const lista = [];

class Lista {

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
        let item = this[this.length - 1];
        delete this[this.length - 1];
        this.length--;
        return item;
    }
}

const lista = new Lista();
lista.push('a');
console.log(lista[0], lista.length);

lista.push('b');
console.log(lista[1], lista.length);

console.log(lista.pop(), lista.length);

/** Big-O */
// Acceder O(1)
lista[0]
// Buscar O(n)
for (let i = 0; i < lista.length; i++) {
    if (lista[i] === 'c') {
        console.log(lista[i]);
        break;
    }
}
// Insertar/Borrar O(n)