# TP Algo3

**Integrantes:** Clara Ruano Frugoli, Francisco Ezequiel Martínez.

El juego a implementar sera *Motherload*.
 - Video: https://www.youtube.com/watch?v=QCMbRe8ij5g
 - Juego: https://www.1001juegos.com/juego/motherload

**Patrones**:

- **Factory/Abstract Factory/Prototype**: Para crear los bloques de terreno de distinto tipo.
- **State**: Para controlar los estados del personaje (volando, andando, cavando hacia abajo, cavando de costado).
- **Flyweight**: Para crear las distintas instancias del terreno, que tienen poca variedad y se repiten mucho.
- **Command**: Para gestionar los movimientos del personaje.
