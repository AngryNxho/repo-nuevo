/**
 * @nombre tabla hash | mapa hash | objeto | diccionario | listas asociativas
 * @inglés hash table | hash map | object | dictionary | associative array
 * 
 * @descripción
 * acceso rápido a un valor si tengo una llave/propiedad
 * tienen un tiempo constante de inserción, búsqueda, actialización, y supresión
 * 
 * @analogía
 * indice en un diccionario
 * 
 * @aplicaciones
 * caching
 * optimizar iteraciones
 * detectar duplicados
 * contar elementos
 * marcar elementos vistos
 * 
 * @implementación
 * A través de la función hash, traducen la clave a un hash que apunta a la celda de memoria (usando módulo % muchas veces)
 * Cuando llega al limite de celdas (eg 16 inicialmete), se duplica
 * Cuando hay colisiones (mismo hash) crea una lista enlazada, tabla hash anidada, o un árbol de búsqueda binaria
 * 
 * @notas
 * En el peor de los casos, la complejidad del tiempo es O(n) debido al recorrido de celdas cuando hay colisiones
 */ 

const objeto = {};

/** Big-O */
// Buscar O(1) - O(n)
console.log(objeto.PDX);

// Insertar O(1) - O(n)
objeto['SEA'] = 'Seattle';
console.log(objeto); 

// Borrar O(1) - O(n)
delete objeto.PDX;
console.log(objeto);