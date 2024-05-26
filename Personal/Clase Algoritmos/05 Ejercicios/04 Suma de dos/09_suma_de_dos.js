const a = [1, 3, 8, 11, 6, 21];
const b = 33;

class Solucion {

    // sumaDeDos(lista, x) {
    //     for (let i = 0; i < lista.length; i++) {
    //         let v = lista[i];
    //         for (let j = 0; j < lista.length; j++) {
    //             let w = lista[j];
    //             if (j <= i) {
    //                 continue;
    //             }
    //             if (v + w === x) {
    //                 return [i, j];
    //             }
    //         }
    //     }
    //     return [];
    // }

    sumaDeDos(lista, x) {
        let mapa = {};
        for (let i = 0; i < lista.length; i++) {
            let v = lista[i];
            let diferencia = x - v;
            if (mapa.hasOwnProperty(diferencia)) {
                return [mapa[diferencia], i];
            } else {
                mapa[v] = i;
            }
        }
        return [];
    }
}

console.log(new Solucion().sumaDeDos(a, b));