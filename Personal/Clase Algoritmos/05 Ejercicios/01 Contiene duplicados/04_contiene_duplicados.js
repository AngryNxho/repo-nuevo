let a = ['a', 'b', 'c', 'c', 'c', 'd'];
let b = ['a', 'b', 'c', 'd'];

class Solucion {
    // contieneDuplicados(lista) {
    //     let mapa = {};
    //     for (const elemento of lista) {
    //         if (!mapa[elemento]) {
    //             mapa[elemento] = true;
    //         } else {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    contieneDuplicados(lista) {
        let set = new Set(lista);
        return set.size != lista.length;
    }
}

console.log(new Solucion().contieneDuplicados(a));