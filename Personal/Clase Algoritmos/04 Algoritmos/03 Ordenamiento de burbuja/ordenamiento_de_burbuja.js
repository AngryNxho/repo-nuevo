let a = [8, 2, 9, 4, 0, 1, 3,  5, 7, 6];

function bubbleSort(lista) {
    for (let i = 0; i < lista.length; i++) {
        for (let j = 0; j < lista.length; j++) {
            if (lista[j] > lista[j + 1]) {
                let temp = lista[j];
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
            }
        }
    }
    return lista;
}

console.log(bubbleSort(a));