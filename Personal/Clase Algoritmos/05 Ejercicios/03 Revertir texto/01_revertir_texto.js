const a = 'texto';
const b = 'listas';

class Solucion {

    // revertirTexto(texto) {
    //     return texto.split('').reverse().join('');
    // }

    // revertirTexto(texto) {
    //     let revertido = '';
    //     let i = texto.length;
    //     while (i > 0) {
    //         revertido += texto[i - 1];
    //         i--;
    //     }
    //     return revertido;
    // }

    // revertirTexto(texto) {
    //     let revertido = '';
    //     for (let i = texto.length - 1; i >= 0; i--) {
    //         revertido += texto[i];
    //     }
    //     return revertido;
    // }

    revertirTexto(texto) {
        let lista = texto.split('');
        for (let i = 0; i < lista.length / 2; i++) {
            let ultimoIndice = lista.length - 1 - i;
            let letra = lista[ultimoIndice];
            // esto no sería posible directamente en texto, solo en listas
            // porque en JavaScript string es inmutable 
            lista[ultimoIndice] = lista[i];
            lista[i] = letra;
        }
        return lista.join('');
    }

}

console.log(new Solucion().revertirTexto(a));