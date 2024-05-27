
// 1.TABLA HASH
// const objeto = {PDX: "Portland", UIO : "Quito"}; 
// n

// Recorrer
// for (let key in objeto) {
    // console.log(key, objeto[key]);
// }

// Buscar // O(1)
// console.log(objeto.PDX); 

//Insertar //O(1)
// objeto["SEA"] = "Seattle";
// console.log(objeto); 

//Borrar O(1)
// delete objeto.PDX
// console.log(objeto);

// Buscar, Insertar, Borrar O(1)

// 2.LISTA

// const lista = [];

// class Lista {
    // length = 0;
// 
    // push(item) {
        // this[this.length] = item;
        // this.length++;
        // return this.length;
    // }
// 
    // pop() {
        // if (this.length == 0) {return undefined};
        // let item = this[this.length - 1];
        // delete this[this.length - 1]
        // this.length--;
        // return item;
    // }
// }
// 
// const lista = new Lista();
// const lista = []
// lista.push("a");
// console.log(lista[0], lista.length);

// lista.push("b");
// console.log(lista[1], lista.length)

// console.log(lista.pop(), lista.length);

//Lista real, no de js
// const lista = ["a", "b", "c"]; // n

//Acceso O(1)
// lista[0];

//Buscar O(n)
// for (let i = 0; i < lista.length; i++) {
//     if (lista[i] === "c") {
//         console.log(lista[i]);
//         break;
//     }
// }

// Insertar O(1)
// Borrar O(n)

//PILA
// class Stack {
//     length = 0;
//     push(item) {
//         this[this.length] = item;
//         this.length++;
//         return this.length;
//     }

//     pop() {
//         if (this.length == 0) {return undefined}
//         const item = this[this.length - 1];
//         this.length--;
//         return item;
//     }

//     peek() {
//         if (this.length == 0) {return undefined}
//         return this[this.length - 1];
//     }
// }

// let pila = new Stack();
// console.log(pila.length);
// pila.push("primero");
// console.log(pila.length);
// console.log(pila.peek());

// pila.push("segundo");
// console.log(pila.length);
// console.log(pila.peek());

// console.log(pila.pop());
// console.log(pila.pop());
// console.log(pila.pop());

// let pila = ["primero", "segundo", "tercero"]; // n

// Acceder O(n)

//Buscar O(n)
// let busco = "primero";
// let ultimo = pila.pop();
// while (ultimo && busco !== ultimo) {
//     ultimo = pila.pop();
// }
// console.log(ultimo);

// // Insertar O(1)
// pila.push("cuarto");

// // Borrar O(1)
// pila.pop();

// class Queue {
//     length = 0;
//     #first = 0;

//     enqueue(item) {
//         this[this.length] = item;
//         this.length++;
//         return this.length;
//     }

//     dequeue() {
//         let size = this.length - this.#first;
//         if (size === 0) {return undefined}
//         const item = this[this.#first];
//         delete this[this.#first];
//         this.#first++;
//         return item;
//     }

//     front() {
//         let size = this.length - this.#first;
//         if (size === 0) {return undefined}
//         return this[this.#first];
//     }

    
// }

// let cola = new Queue();
// console.log(cola.length);

// cola.enqueue("primero");
// console.log(cola.front());
// cola.enqueue("segundo");
// console.log(cola.front());
// cola.enqueue("tercero");
// console.log(cola.front());

// console.log(cola.dequeue());
// console.log(cola.dequeue());
// console.log(cola.dequeue());

// //Con js

// cola.enqueue("primero");
// console.log(cola[0]);
// cola.enqueue("segundo");
// console.log(cola[0]);
// cola.enqueue("tercero");
// console.log(cola[0]);

// console.log(cola.shift());
// console.log(cola.shift());
// console.log(cola.shift());

// LISTA ENLAZADA

// class Node {
//     constructor(value, next = null) {
//         this.value = value;
//         this.next = next;
//     }
// }

// const listaEnlazada = new Node(1, 
//     new Node(2,
//         new Node(3, 
//             new Node(4)
//         )
//     )
// );

// console.log(JSON.stringify(listaEnlazada, null , 2));

// Acceder O(1) O(n)

// class LinkedList {
//     length = 0;
//     head = null;

//     add(value) {
//         let node = new Node(value);
//         if (this.head == null) {
//             this.head = node
//         } else {
//             let curr = this.head;
//             while (curr.next) {
//                 curr = curr.next;
//             }
//             curr.next = node;
//         }
//         this.length++;
//     }
// }

// const listaEnlazadaFormal = new LinkedList();
// listaEnlazadaFormal.add(1);
// listaEnlazadaFormal.add(2);
// listaEnlazadaFormal.add(3);
// listaEnlazadaFormal.add(4);

// console.log(JSON.stringify(listaEnlazadaFormal, null, 2));

// class Node {
    // constructor(value, children = []) {
        // this.value = value;
        // this.children = children;
    // } 
// }
// 
// let raiz = new Node(1, [
    // new Node(2, [
        // new Node(5),
        // new Node(6),
        // new Node(7)
    // ]),
    // new Node(3),
    // new Node(4, [
        // new Node(8)
    // ]),
// ]);

// console.log(JSON.stringify(raiz, null, 2));
// function preOrden(root) {
    // if (!root) return null;
    // console.log(root.value);
    // for (let child of root.children) {
        // preOrden(child);
    // }
// }
// 
// function postOrden(root) {
    // if (!root) return null;
    // for (let child of root.children) {
        // postOrden(child);
    // }
    // console.log(root.value);
// }


// preOrden(raiz);
// postOrden(raiz);
// function bfs(root) {
//     if (!root) return null;
//     let queue = [root];
//     while (queue.length) {
//         let node = queue.shift();
//         console.log(node.value);
//         for (let child of node.children) {
//             queue.push(child);
//         }
//     }
// }

// bfs(raiz);