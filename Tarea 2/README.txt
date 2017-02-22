Código y nombre del curso: Conceptos avanzados de Ingeniería de SoftWare
Nombre de la tarea: Tarea No. 2 - PSP1
Nombre del estudiante: Ciro Andrés Díaz Rodríguez
Fecha de envío de la tarea: 22 de Febrero de 2017

Instrucciones para ejecutar el programa:

Prerrequisitos:

a. Asegurarse de usar la versión de java 1.8.0_121
b. Descargar la carpeta Tarea 2 - ca.diazr1 desde el repositorio git usando el comando $ git clone https://github.com/cirodiaz/Entregas.git a una carpeta de su elección 
c. Acceder a la carpeta que contiene el directorio "t2_cuentalineas"

Para hacer uso del programa de tarea 1, por favor realizar el siguiente proceso:

1. abrir la línea de comandos
2. navegar hacia la carpeta "t2_cuentalineas" donde hayan descargado desde el git
3. digitar el comando "mvn package"
4. verificar que el archivo compila correctamente.
5. ejecutar el comando maven para ejecutar el proyecto:
java -cp target/t2_cuentalineas-1.0-SNAPSHOT.jar com.cuentalineas.entities.LineCounter "C:\\Workspaceejemplos\\t2_cuentalineas\\docs\\standards.properties" "C:\\Workspaceejemplos\\t2_cuentalineas\\src" java

NOTA: Cambiar parámetros para indicar las carpetas correctas de proyectos, tanto para el archivo de propiedades como para el directorio de proyecto a contar.