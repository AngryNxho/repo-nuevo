let a = [1, 2, 3, 5, 5, 5, 6, 4, 7, 7, 7, 9, 2, 5, 3];
let b = ['re', 're', 'fg', 're', 'xa'];

class Solucion {
    removerDuplicados(lista) {
        let map = new Set();
        let nuevaLista = [];
        for (let item of lista) {
            if (!map.has(item)) {
                nuevaLista.push(item);
                map.add(item);
            }
        }
        return nuevaLista;
    }
}

console.log(new Solucion().removerDuplicados(a));