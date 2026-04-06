# RPG-Console-Simulator (Java)
Simulador RPG por consola desarrollado en Java, enfocado en practicar estructuras de control y lógica básica sin uso de funciones ni programación orientada a objetos.

## 🚀 Características.

- 🧩 Creación de personaje (nombre, clase, estadísticas)
- 🔥 Sistema de entrenamiento interactivo
- ⚔️ Simulación de batalla por turnos
- 🎒 Inventario predefinido (uso de foreach)
- 📊 Visualización del estado del personaje
- 🔁 Salir del juego


## 🛠️ Objetivos del proyecto.

- Uso de Scanner
- Estructuras de control:
    - **do-while** (menú principal)
    - **while** (entrenamiento)
    - **for** (entrenamiento)
    - **foreach** (entrenamiento)

- Condicionales **if/else**
- Validación de datos
- Manejo de variables primitivas y arreglos

## 🧱 Estructura del programa

El flujo principal está controlado por un menú repetitivo
```java
do {
    // Mostrar menú
    // Leer opción

    switch(opcion) {
        case 1:
            // Crear personaje
        case 2:
            // Entrenamiento
        case 3:
            // Batalla
        case 4:
            // Inventario
        case 5:
            // Estado del personaje
        case 6:
            // Salir
    }

} while(opcion != 6);
```

## 🧑‍🎭 Creación del personaje.

El usuario debe ingresar:

- Nombre
- Clase (mago, guerrero, arquero)
- Puntos de vida
- Fuerza base

## 🔥Entrenamiento

Sistema interactivo donde el jugador puede mejorar sus estadísticas.

## ⚔️ Batalla

Simulación de combate de 5 turnos usando un **for**.
- Ambos personajes pierden vida en cada turno
- Se muestra el daño y la vida restante
- Puede terminar antes si la vida llega a 0

## 🎒Inventario.

Se utiliza un arreglo:
```java
String[] inventario = {"Poción", "Hierro", "Pergamino", "Llave Antigua"};
```

Mostrado con **foreach**.

## 📊 Estado del personaje.

Se muestran los atributos actuales junto con un estado según la vida.
- 💚 Vida > 80 → Excelente estado
- 🟡 Vida > 40 → Estado moderado
- 🔴 Vida <= 40 → Herido

## ⚠️Validaciones
- No se permiten valores negativos
- Se controlan opciones inválidas
- El programa no debe fallar ante entradas incorrectas

## 🚫Restricciones del proyecto

- ❌ No usar funciones
- ❌ No usar clases personalizadas(POO)
- ✔ Todo en main

## 📁 Estructura del proyecto
```
rpg-menu-simulator/
│
├── RPGMenuSimulator.java
├── README.md
└── .gitignore
```

##▶️ Cómo ejecutar

1. Compilar:
```
javac RPGMenuSimulator.java
```

2. Ejectuar:
```
java RPGMennuSimulator.java
```

## 💡 Integrantes

- Javiera Godoy (menú / creación del personaje)
- Diego Castillo(inventario)
- Renato Campos(entrenamiento)
- Victor Erazo (batalla)
- Matías Celis (readme)
