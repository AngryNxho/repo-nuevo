class Node {
    constructor(value, next = null) {
        this.value = value;
        this.next = next;
    }
}

let a = new Node(1, new Node(2, new Node(3, new Node(4))));

class Solucion {
    revertir(head) {
        let curr = head;
        let prev = null;
        while (curr) {
            let temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

console.log(JSON.stringify(new Solucion().revertir(a)));
