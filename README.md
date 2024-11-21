# [Nombre del Proyecto: MultiJuegos]

Este proyecto es un **conjunto de juegos que comparten el mismo tablero**, desarrollado como parte de las prácticas finales del **primer año** en el Grado Superior. Su principal objetivo era poner en práctica conceptos avanzados de **Java** con un enfoque en **Programación Orientada a Objetos (OOP)** y la interacción entre clases.

## Propósito del proyecto

- Practicar los fundamentos y conceptos avanzados de **OOP**:
  - Herencia.
  - Polimorfismo.
  - Encapsulación.
  - Relaciones entre objetos.
- Desarrollar juegos que compartan un único tablero, fomentando la reutilización y modularidad del código.
- Implementar lógica de programación que permita la interacción fluida entre múltiples clases.

## Características principales

- **Tablero compartido**: Una única estructura de datos y representación visual utilizada por varios juegos.
- **Múltiples juegos**:
  - Cada juego tiene reglas únicas pero utiliza el mismo tablero.
  - Posibilidad de alternar entre los juegos sin cambiar la base del tablero.
- **Diseño modular**: Separación de responsabilidades en diferentes clases para facilitar el mantenimiento y la escalabilidad.
  
## Tecnologías utilizadas

- **Java**: Lenguaje principal para implementar la lógica y diseño del juego.
- **Paradigma OOP**: Para estructurar el código de forma organizada y eficiente.

## Estructura del código

- **Clases principales**:
  - `Tablero`: Representa la base común utilizada por los diferentes juegos.
  - Juegos específicos como:
    - `Ajedrez`
    - `Damas`
    - `Damas Chinas`
    - `Gatos y Ratón`
    - `Soldados del Rey`
  - Cada clase de juego implementa sus propias reglas y lógica.
