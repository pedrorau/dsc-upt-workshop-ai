# Chat AI

Estamos desarrollando una App para crear una lista de eventos utilizando gemini en Android Studio.

Para ello, el usuario inicialmente vera un lista de eventos que incluiran un nombre, una ciudad, una direccion, y un tipo de evento (presencial o remoto) un horario de inicio y un horario de fin.

Simula la respuesta de la API de gemini con un Json (mockeado) con el listado de eventos (cada eventos debera tener un id unico) con los campos anteriores.

Una vez se muestre la lista de eventos, podre hacer tap en uno de ellos y se mostrará una nueva pantalla con el detalle del evento. De momento muestra la misma información que en la lista de eventos.

## Tecnologías

Estas son las tecnologías que vamos a utilizar para cada una de las funcionalidades

- Jetpack Compose como sistema de interfaces.
- Material 3 como sistema de diseño.
- Kotlin como lenguaje de programación.
- Los ViewModels de Architecture Components para la comunicación entre la UI y la capa de datos.
- Hilt como inyector de dependencias.

## Arquitectura
Vamos a usar una arquitectura sencilla, donde tendremos:
- La UI en Compose
- Comunicación con la capa de datos mediante MVVM
- La capa de datos estará formada por repositorios, que ocultarán qué librerías concretas se están utilizando.

## Reglas extra

- Siempre que termines de generar un código, compílalo para ver que no hay problemas. Para ello, utiliza compileDebugKotlin
- Aunque pienses que los build.gradle.kts están incorrectos, los que tienes ahora mismo en el contexto son válidos. Si tienes que modificar el libs.versions o los ficheros gradle, simplemente añade lo nuevo que necesites, y no modifiques lo que ya existe.
- No incluyas comentarios solo para explicar lo que ya hace el código. Solo en caso de que haya alguna parte que se quede así porque en el futuro haya que añadir nueva funcionalidad.