let a = [8, 2, 9, 4, 0, 1, 3, 5, 7, 6];

function quickSort(lista, inicial = 0, final = lista.length - 1) {
    if (inicial >= final) return lista;

    let indice = particion(lista, inicial, final);
    quickSort(lista, inicial, indice - 1);
    quickSort(lista, indice + 1, final);

    return lista;
}

function particion(lista, inicial, final) {
    const pivote = lista[inicial];
    let i = inicial + 1;
    let j = final;

    while (true) {
        while (i <= j && lista[i] < pivote) i++;
        while (j >= i && lista[j] > pivote) j--;
        if (j < i) break;
        [lista[i], lista[j]] = [lista[j], lista[i]];
        i++;
        j--;
    }
    [lista[inicial], lista[j]] = [lista[j], lista[inicial]];
    return j;
}

console.log(quickSort(a));