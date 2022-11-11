# TP Algo3

## Etapa 2

La implementacion actual permite jugar por consola con una matriz de caracteres, recolectar minerales, gastar combustible y perder vida. Ademas de interactuar con las multiples tiendas. En cuanto a mecanicas de juego faltaria implementar poder volar y que no solo signifique no caer mientras se aprete la tecla para subir. Asi como tambien que taladrar no sea instanteaneo y que lleve mantener una tecla apretada.

[Link a un notion con documentacion y diagramas de clase](https://motherloadalgo3.notion.site/TP-Algo3-4a0bf823f279422789fe4196a86b369a)

## Intro
**Integrantes:** Clara Ruano Frugoli, Francisco Ezequiel Martínez.

El juego a implementar sera *Motherload*.
 - Video: https://www.youtube.com/watch?v=QCMbRe8ij5g
 - Juego: https://www.1001juegos.com/juego/motherload

**Patrones**:

- **Factory**: Para crear los bloques de terreno de distinto tipo.
- **State**: Para controlar los estados del personaje (volando, andando, cavando hacia abajo, cavando de costado).
- **Flyweight**: Para crear las distintas instancias del terreno, que tienen poca variedad y se repiten mucho.
- **Command**: Para gestionar los movimientos del personaje.
