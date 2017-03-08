Código y nombre del curso: Conceptos avanzados de Ingeniería de SoftWare
Nombre de la tarea: Tarea No. 3 - PSP2
Nombre del estudiante: Ciro Andrés Díaz Rodríguez
Fecha de envío de la tarea: 8 de Marzo de 2017

Instrucciones para ejecutar el programa:

Prerrequisitos:

a. Asegurarse de usar la versión de java 1.8.0_121
b. Crear el archivo "archivoin.txt" en la carpeta "C:\tarea3" (el valor es fijo), y añadirle líneas con un par de  números, separados por ";" (caracter punto y coma) en cada línea;
los números son de tipo "float". Si se ingresan valores diferentes a números, el programa fallará. Si se añaden menos de tres líneas con pares de números, los resultados
podrían no ser los esperados.
c. Descargar la carpeta Tarea 3 - ca.diazr1 desde el repositorio git usando el comando $ git clone https://github.com/cirodiaz/Entregas.git a una carpeta de su elección 

Para hacer uso del programa de tarea 3, por favor realizar el siguiente proceso:

1. abrir la línea de comandos
2. navegar hacia la carpeta "t3_regresión" donde hayan descargado desde el git
3. digitar el comando "mvn package"
4. verificar que el archivo compila correctamente.
5. ejecutar el comando maven para ejecutar el proyecto:
mvn exec:java -Dexec.mainClass="com.estadisticas.entities.Calculator"
6. Seguir las instrucciones del programa.

* Alternativamente, se puede ejecutar el programa standalone por línea de comandos, navegando hasta la carpeta test/ExecutableStandalone/ del zip entregable
y ejecutando: 
java -jar regresion.jar com.estadisticas.entities.Calculator
Seguir las instrucciones del programa. 


