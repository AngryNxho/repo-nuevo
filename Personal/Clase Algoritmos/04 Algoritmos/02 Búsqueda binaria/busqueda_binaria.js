const a = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'];

function busquedaBinaria(lista, valor, menor = 0, mayor = lista.length - 1) {
    if (mayor < menor) return -1;
    let medio = Math.floor((menor + mayor) / 2);
    if (lista[medio] === valor) return medio;
    if (lista[medio] > valor) return busquedaBinaria(lista, valor, menor, medio - 1);
    return busquedaBinaria(lista, valor,  medio + 1, mayor);
}

console.log(busquedaBinaria(a, 'z'))