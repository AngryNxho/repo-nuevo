let a = [0, 1, 2, 2, 3]; // [4, [0, 1, 2, 3, 3]]
let b = []; // [0, []],
let c = [0, 0, 1, 2, 3, 4, 4, 4, 4, 4, 5]; // [6, [0, 1, 2, 3, 4, 5, any, any, any, any, any]]

class Solucion {
    removerDuplicadosDeListaOrdenanda(lista) {
        if (lista.length == 0) return [0, []];
        let i = 0;
        for (let j = 1; j < lista.length; j++) {
            if (lista[j] != lista[i]) {
                i++;
                lista[i] = lista[j];
            }
        }
        return [i + 1, lista];
    }
}

console.log(new Solucion().removerDuplicadosDeListaOrdenanda(a));

