/**
 * @nombre árbol
 * @inglés tree
 * 
 * @descripción
 * tiene una raiz y varios hijos y sus hijos pueden tener varios hijos
 * 
 * @analogía
 * nodo en un árbol real con ramas
 * 
 * @aplicaciones
 * el DOM, representación de HTML en los navegadores
 * 
 * @implementación
 * se basa en nodos
 *
 * @notas
 * profundidad o altura de un arbol es la distancia desde la raiz al nodo mas lejano
 * niveles in cluye doso los nodos en la misma profundidad 
 * hoja es un nodo sin hijos
 * se puede recorrer por profundidad y por altura
 * al recorrer por profundidad se puede hcerlo en preorden y postorden
 * son comunes en entrevistas técnicas de BIG TECH
 * dan miedo pero no son tan dificiles una vez que los conoces
 * normalmente son en una dirección pero pueden tener dirección el hido al padre también
 * https://es.wikipedia.org/wiki/%C3%81rbol_(inform%C3%A1tica)
 * Otras estructuras similares son: '
 * - árbol binario: https://es.wikipedia.org/wiki/%C3%81rbol_binario
 * - árbol-B: https://es.wikipedia.org/wiki/%C3%81rbol-B
 * - ábol rojo-negro: https://es.wikipedia.org/wiki/%C3%81rbol_rojo-negro
 * - árbol AVL: https://es.wikipedia.org/wiki/%C3%81rbol_AVL
 * - árbol k-ario: https://es.wikipedia.org/wiki/%C3%81rbol_k-ario
 * - trie: https://es.wikipedia.org/wiki/Trie
 */


class Node {
    constructor(value, children = []) {
        this.value = value;
        this.children = children;
    }
}

/** 
 *     1
 *    /|\
 *   2 3 4
 *  /|\  |
 * 5 6 7 8
 * **/

let raiz = new Node(1, [
    new Node(2, [
        new Node(5),
        new Node(6),
        new Node(7)
    ]
    ),
    new Node(3),
    new Node(4, [
        new Node(8)
    ])
]);

// Depth First Search (DFS)
// Recorrido de Profundidad Primero

function preOrden(root) {
    if (!root) return null;
    console.log(root.value);
    for (let child of root.children) {
        preOrden(child);
    }
}
// preOrden(raiz);

function postOrden(root) {
    if (!root) return null;
    for (let child of root.children) {
        postOrden(child);
    }
    console.log(root.value);
}
postOrden(raiz);

// Breadth First Search (BFS)
// Recorrido de Anchura Primero
function bfs(root) {
    if (!root) return null;
    let queue = [root];
    while (queue.length) {
        let nodo = queue.shift();
        console.log(nodo.value);
        for (let child of nodo.children) {
            queue.push(child);
        }
    }
}
// bfs(raiz);
