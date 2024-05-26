let a = [2,5,4,2,3,8,1,0,9];

function mergeSort(lista) {
    if (lista.length <= 1) return lista;

    let mitad = Math.ceil(lista.length/2);
    let izquierda = lista.splice(0,mitad);
    let derecha = lista.splice(-mitad);

    mergeSort(izquierda);
    mergeSort(derecha);

    let [i,j,k] = [0,0,0];

    while (i < izquierda.length && j < derecha.length) {
        if (izquierda[i] < derecha[j]) {
            lista[k] = izquierda[i];
            i++;
        } else {
            lista[k] = derecha[j];
            j++;
        }
        k++;
    }

    while (i < izquierda.length) {
        lista[k] = izquierda[i];
        i++;
        k++;
    }
    
    while (j < derecha.length) {
        lista[k] = derecha[j];
        j++;
        k++;
    }

    return lista;
}

console.log(mergeSort(a))