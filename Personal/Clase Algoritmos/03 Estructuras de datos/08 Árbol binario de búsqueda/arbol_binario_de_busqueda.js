/** 
 *     D
 *    / \
 *   B   E
 *  / \
 * A   C
 * **/

class Node {
    constructor(value, left = null, right = null) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

let raiz = new Node('D',
    new Node('B',
        new Node('A'),
        new Node('C')
    ),
    new Node('E')
);

function enOrden(root) {
    if (!root) return null;
    enOrden(root.left);
    console.log(root.value);
    enOrden(root.right);
}
// enOrden(raiz);

function busqueda(root, value) {
    if (!root) return null;
    if (root.value === value) return root;
    if (value < root.value) return busqueda(root.left, value);
    return busqueda(root.right, value);
}
console.log(busqueda(raiz, 'B'));