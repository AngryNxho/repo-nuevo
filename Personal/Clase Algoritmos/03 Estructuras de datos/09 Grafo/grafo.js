/**
 * @nombre grafo
 * @inglés graph
 * 
 * @descripción
 * estructura formada de nodos
 * 
 * @analogía
 * ciudades unidas por carreteras entre si
 * 
 * @aplicaciones
 * conecciones de amistades en redes sociales, cada persona es un nodo
 * el internet, cada computador es un nodo conectado por cables o wifi
 * 
 * @implementación
 * se basa en nodos
 * se puede representar como matriz de adyacencia
 * - operaciones de añadir, remover, o buscar son bastante eficientes O(1)
 * - mayor ventaja es que permite operaciones de matrices
 * - aplicaciones increiblemente eficientes para gráficos (GPU)
 * - usa mucha memoria
 * se puede representar como lista de adyacencia
 * - mas util para mayoria de situaciones
 * - eficiente memoria para millones de nodos que solo guarda informacion de aristas. 
 * - encontrar los nodos puede ser ineficiente porque estan en listas
 * 
 * @notas
 * puede ser dirigido, no dirigido, o mixto
 * https://es.wikipedia.org/wiki/Grafo
 * 
 */

/**           Matrix de adyacencia      Lista de adyacencia
 * A---B        A B C D E               A => D B
 * |  /|      A 0 1 0 1 0               B => A C E
 * | C |      B 1 0 1 0 1               C => B D
 * |/  |      C 0 1 0 1 0               D => A C E
 * D---E      D 1 0 1 0 1               E => B D
 *            E 0 1 0 1 0
 * */


class MatrixGraph {
    constructor(nodos) {
        this.nodos = {};
        this.matrix = [];
        nodos.forEach((nodo, i) => {
            this.nodos[nodo] = i
            this.matrix[i] = new Array(nodos.length).fill(0);
        });
    }

    crearAristas(node1, node2) {
        let i = this.nodos[node1];
        let j = this.nodos[node2];
        this.matrix[j][i] = 1;
        this.matrix[i][j] = 1;
    }

}

let matriz = new MatrixGraph(["A", "B", "C", "D", "E"]);

matriz.crearAristas("A", "D");
matriz.crearAristas("A", "B");
matriz.crearAristas("B", "C");
matriz.crearAristas("B", "E");
matriz.crearAristas("C", "D");
matriz.crearAristas("D", "E");

console.log(matriz);

class ListGraph {
    constructor() {
        this.nodes = [];
        this.adjacencyList = {};
    }

    crearNodo(node) {
        this.nodes.push(node);
        this.adjacencyList[node] = [];
    }

    crearAristas(node1, node2) {
        this.adjacencyList[node1].push(node2);
        this.adjacencyList[node2].push(node1);
    }
}

let grafo = new ListGraph();
grafo.crearNodo("A");
grafo.crearNodo("B");
grafo.crearNodo("C");
grafo.crearNodo("D");
grafo.crearNodo("E");

grafo.crearAristas("A", "D");
grafo.crearAristas("A", "B");
grafo.crearAristas("B", "C");
grafo.crearAristas("B", "E");
grafo.crearAristas("C", "D");
grafo.crearAristas("D", "E");

console.log(grafo)