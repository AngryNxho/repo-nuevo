class Node {
    constructor(value, children = []) {
        this.value = value;
        this.children = children;
    }
}

let g1 = new Node('G1');
let y1 = new Node('Y1', [g1]);
let c1 = new Node('C1', [y1]);
let d1 = new Node('D1');
let b1 = new Node('B1', [c1, d1]);
let z1 = new Node('Z1');
let a1 = new Node('A1', [b1, z1]);
let arbol1 = a1;
// console.log(JSON.stringify(arbol1));

let g2 = new Node('G1`');
let y2 = new Node('Y1`', [g2]);
let c2 = new Node('C1`', [y2]);
let d2 = new Node('D1`');
let b2 = new Node('B1`', [c2, d2]);
let z2 = new Node('Z1`');
let a2 = new Node('A1`', [b2, z2]);
let arbol2 = a2;
// console.log(JSON.stringify(arbol2));

class Solucion {

    nodoEnArbolDuplicado(valor, arbol1, arbol2) {
        let instrucciones = [];
        let nodo = this.encontrarValor(valor, arbol1, instrucciones);
        if (!nodo) return null;
        return this.encontrarNodo(arbol2, instrucciones);
    }

    encontrarValor(valor, nodo, instrucciones) {
        if (!nodo) return null;
        if (nodo.value === valor) return nodo;
        for (let i = 0; i < nodo.children.length; i++) {
            let child = nodo.children[i];
            let result = this.encontrarValor(valor, child, instrucciones);
            if (result) {
                instrucciones.push(i);
                return result;
            };
        }
        return null;
    }

    encontrarNodo(arbol2, instrucciones) {
        let nodo = arbol2;
        while (instrucciones.length) {
            let index = instrucciones.pop();
            nodo = nodo.children[index];
        }
        return nodo;
    }
}

console.log(new Solucion().nodoEnArbolDuplicado('A1', arbol1, arbol2));

