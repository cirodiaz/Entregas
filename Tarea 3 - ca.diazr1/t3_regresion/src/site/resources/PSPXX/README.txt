C�digo y nombre del curso: Conceptos avanzados de Ingenier�a de SoftWare
Nombre de la tarea: Tarea No. 3 - PSP2
Nombre del estudiante: Ciro Andr�s D�az Rodr�guez
Fecha de env�o de la tarea: 8 de Marzo de 2017

Instrucciones para ejecutar el programa:

Prerrequisitos:

a. Asegurarse de usar la versi�n de java 1.8.0_121
b. Crear el archivo "archivoin.txt" en la carpeta "C:\tarea3" (el valor es fijo), y a�adirle l�neas con un par de  n�meros, separados por ";" (caracter punto y coma) en cada l�nea;
los n�meros son de tipo "float". Si se ingresan valores diferentes a n�meros, el programa fallar�. Si se a�aden menos de tres l�neas con pares de n�meros, los resultados
podr�an no ser los esperados.
c. Descargar la carpeta Tarea 3 - ca.diazr1 desde el repositorio git usando el comando $ git clone https://github.com/cirodiaz/Entregas.git a una carpeta de su elecci�n 

Para hacer uso del programa de tarea 3, por favor realizar el siguiente proceso:

1. abrir la l�nea de comandos
2. navegar hacia la carpeta "t3_regresi�n" donde hayan descargado desde el git
3. digitar el comando "mvn package"
4. verificar que el archivo compila correctamente.
5. ejecutar el comando maven para ejecutar el proyecto:
mvn exec:java -Dexec.mainClass="com.estadisticas.entities.Calculator"
6. Seguir las instrucciones del programa.

* Alternativamente, se puede ejecutar el programa standalone por l�nea de comandos, navegando hasta la carpeta test/ExecutableStandalone/ del zip entregable
y ejecutando: 
java -jar regresion.jar com.estadisticas.entities.Calculator
Seguir las instrucciones del programa. 


