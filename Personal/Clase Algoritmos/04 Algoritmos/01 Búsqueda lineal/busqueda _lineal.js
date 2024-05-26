let a = ['z','m','f','h','j','k','s','n'];

function busquedaLineal(lista, valor) {
    for (let i = 0; i < lista.length; i++) {
        if (lista[i] === valor) {
            return i;
        }
    }
    return -1;
}

console.log(busquedaLineal(a,'n'));