/**
 * @nombre árbol binario
 * @inglés binary tree
 * 
 * @descripción
 * tiene una raiz y 2 hijos y sus hijos pueden tener 2 hijos
 * 
 * @analogía
 * similar a un árbol pero solo tiene 2 ramas
 * 
 * @aplicaciones
 * tablas de entrutamiento con IPs
 * evaluación de expresiones
 * compresión de datos
 * 
 * @implementación
 * se basa en nodos
 * 
 * @notas
 * se puede recorrer por profundidad y por altura
 * al recorrer por profundidad se puede hcerlo en preorden, enorden, y postorden
 * árboles balanceados y no balanceados
 * recorrido en árboles no balanceados va a ser O(n)
 * Otras estructuras similares son:
 * - árbol binario de busqueda: https://es.wikipedia.org/wiki/%C3%81rbol_binario_de_b%C3%BAsqueda
 * -- la búsqueda en un árbol binario de búsqueda es logarítmico. 
 * -- en cada nivel los nodos son el doble
 * -- la altura es log2(15) = 3
 */


class Node {
    constructor(value, left = null, right = null) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

/** 
 *     2
 *    / \
 *   5   7
 *  / \
 * 3   4
 * **/

let raiz = new Node(2,
    new Node(5,
        new Node(3),
        new Node(4)
    ),
    new Node(7)
);

// Depth First Search (DFS)
// Recorrido de Profundidad Primero
function preOrden(root) {
    if (!root) return null;
    console.log(root.value);
    root.left && preOrden(root.left);
    root.right && preOrden(root.right)
}
// preOrden(raiz);

function enOrden(root) {
    if (!root) return null;
    root.left && enOrden(root.left);
    console.log(root.value);
    root.right && enOrden(root.right)
}
// enOrden(raiz);

function postOrden(root) {
    if (!root) return null;
    root.left && postOrden(root.left);
    root.right && postOrden(root.right)
    console.log(root.value);
}
// postOrden(raiz);

function preOrdenIter(root) {
    if (!root) return null;
    let stack = [root];
    while (stack.length) {
        let nodo = stack.pop();
        console.log(nodo.value);
        nodo.right && stack.push(nodo.right); // alter order
        nodo.left && stack.push(nodo.left);
    }
}
// preOrdenIter(raiz);

function enOrdenIter(root) {
    if (!root) return null;
    let stack = [];
    let nodo = root;
    while (nodo || stack.length) {
        while (nodo) {
            stack.push(nodo);
            nodo = nodo.left;
        }
        nodo = stack.pop();
        console.log(nodo.value);
        nodo = nodo.right;
    }
}
// enOrdenIter(raiz);

function postOrdenIter(root) {
    if (!root) return null;
    let stack = [];
    let orden = [];
    let nodo = root;
    while (nodo || stack.length) {
        if (nodo) {
            stack.push(nodo);
            orden.unshift(nodo.value);
            nodo = nodo.right;
        } else {
            nodo = stack.pop();
            nodo = nodo.left;
        }
    }
    while (orden.length) {
        console.log(orden.shift())
    }
}
postOrdenIter(raiz);

// Breadth First Search (BFS)
// Recorrido de Anchura Primero
function bfs(root) {
    if (!root) return null;
    let queue = [root];
    while (queue.length) {
        let nodo = queue.shift();
        console.log(nodo.value);
        nodo.left && queue.push(nodo.left);
        nodo.right && queue.push(nodo.right);
    }
}
bfs(raiz);