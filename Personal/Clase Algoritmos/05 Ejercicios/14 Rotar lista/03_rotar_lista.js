let a = [1, 2, 3, 4, 5, 6];

let b = 9; // [ 4, 5, 6, 1, 2, 3 ]

// 0 [1, 2, 3, 4, 5, 6]
// 1 [ 6, 1, 2, 3, 4, 5 ]
// 2 [ 5, 6, 1, 2, 3, 4 ]
// 5 [ 2, 3, 4, 5, 6, 1 ]
// 6 [ 1, 2, 3, 4, 5, 6 ]

class Solucion {

    // rotarLista(lista, k) {
    //     k = k % lista.length;
    //     for (let i = 0; i < k; i++) {
    //         let last = lista.pop();
    //         lista.unshift(last);
    //     }
    //     return lista;
    // }

    rotarLista(lista, k) {
        k = k % lista.length;
        this.revertir(lista, 0, lista.length - 1);
        this.revertir(lista, 0, k - 1);
        this.revertir(lista, k, lista.length - 1);
        return lista;
    }

    revertir(lista, i, j) {
        while (i < j) {
            let temp = lista[i];
            lista[i] = lista[j];
            lista[j] = temp;
            i++;
            j--;
        }
    }
}

console.log(new Solucion().rotarLista(a, b));