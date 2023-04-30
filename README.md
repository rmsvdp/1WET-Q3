# 1WET-Q3
En este respositorio, encontrarás contenidos para el Q3 del ciclo DAW, en concreto :
* Gestión de la información
* Sistemas de archivos y manejo de ficheros
* Gestión de bases de datos
* Información miscelánea:
    * *Ejercicios anteriores*
    * *Liberías y clases para reutilizar*
    * *Proyectos y ejemplos varios*

**IMPORTANTE** algunos directorios sólo contienen fuentes, deberás generar un proyecto e incorporarlos
para probarlos.

## Metodología :+1:

La información que se proporciona, sirve sólo de guía para buscar y adquirir el conocimiento.
Cada sección contiene un pequeño resumen y enlaces, así como fragmentos de códigos de ejemplo
La mecánica recomendada es :
* acceder a los enlaces , leer con atención y reproducir los ejemplos (si es un tutorial)
* Buscar otros enlaces de referencia y repetir el proceso
* Revisar ejemplos o realizar ejercicios

Para que esto sea realmente productivo, aprovecha la potencia del trabajo en equipo, forma grupos con 
tus compañeros y entre todo id construyendo 

## En capítulos anteriores :alien:

En mi cuenta de gitHub hay proyectos operativos sobre ejemplos, ejercicios y utilidades, puedes usarlos libremente.

## Gestión de la información (ud9-gi) :rocket: 

Al final, cualquier aplicación relevante maneja información de forma persistente, es decir, la información se crea, modifica y elimina 
durante la ejecución de la aplicaicón, pero cuando esta termina, debe quedar almacenada de alguna forma.

En tiempo de ejecución , podemos adpotar una estrategia común a casi cualquier programa al que nos 
enfrentemos:

1. Inicializar el sistema y al información base
2. Recuperar la información 
3. Trabajar con ella en memoria con estructura de datos : arrays y colecciones (ArrayList, HashMap, Queue, Tree)
4. Salvar la información de forma periódica
5. Terminar la aplicación

Hasta que no veamos lectura y escritura en ficheros,pasaremos por alto los puntos 2 y 4 

### Trabajar en memoria con la información

Se trata de implementar un conjunto de métodos básicos para gestionar la información:
- Insertar nuevos elementos
- Modificar existentes
- Eliminar un determinado elementos
- Listar/Buscar uno o varios elementos


Como concepto una buena solución sería el crear un **interfaz** con los elementos básicos y luego para
cada clase, realizar la implementación. Por ejemplo

```java8

public interface DAO{
    public void addCoche(Coche c);		// Añadidmos un coche nuevo
    public void updateCoche(Coche _old, Coche _new); // actualizamos los datos de un coche con los de otro
    public boolean deleteCoche(Coche c); // Elimino un coche
    public Coche findCoche(String clave); // Recupero un coche a partir de su matrícula
    public ArrayList<Coche> getCoches(); // REcupero todos los coches almacenados
}
```
La idea es que las operaciones de añadir, eliminar y actualizar sean sobre un único objeto.
La operación de obtener todos, nos servirá para cargar completamente una colección en memoria y 
recorrerla y manipularla a nuestro gusto.

**En la carpeta ud9-gi se encuentra un ejemplo de lo expuesto (sólo archivos java)**

Aplica este concepto a diseños anteriores (electrodomésticos y biblioteca digital), todavía quedará más claro el programa principal!!

## Sistemas de archivos y manejo de ficheros (ud9-sa) :rocket:

Desde una aplicación java se puede acceder a cualquier sistema de archivos windows/linux/mac
La clase principal para recorrer un sistema de archivos es FILE, y proporciona los siguientes servicios:
1. Recorrer árbol de directorios y listar su contenido
2. Obtener información sobre un archivo concreto
3. Operaciones básicas de creación, lectura y escritura de archivos
### Enlaces de interés

* [JavaDoc Oficial](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html)
* [Tutorial 1](https://www.baeldung.com/java-io-file)
* [Tutorial 2](https://www.geeksforgeeks.org/file-class-in-java/)

## Lectura y escritura de ficheros (ud9-fi) :rocket:

Un fichero en general almacena una secuencia de bytes, en función de su organización , se podrá 
interpretar como texto, datos numéricos y/o estructuras de datos complejas.
Los archivos que se pueden 'leer' se conocen como archivos de texto, contienen esencialmente caracteres del alfabeto,
símbolos de puntuación,números y caracteres especiales.
Los archivos que no se pueden 'leer', se conocen como binarios, son secuencias de bytes que responden a una estructura
que debemos conocer para trabajar con ellos. Por ejemplo una imagen jpg tiene una determinada estructura, que
interpretada por un programa de dibujo o un navegador nos permite mostrarla en pantalla.

### Archivos de texto

Java dispone de una serie de clases para este cometido, que partiendo de la clase FILE , nos exponen métodos
para leer escribir.

El proceso siempre es el mismo:

1. Creamos un objeto FILE sobre un archivo, mediante el método open
2. Sobre es objeto leemos/escribimos
3. Cerramos el objeto FILE

Las reglas básicas para operar son estas:

* Recubrir el código con sentencias try - catch para gestionar las excepciones
* En un bucle : leer hasta que se termine el archivo o escribir hasta que agotemos los datos que queremos almacenar

### Lectura de archivos de texto
Java, junto con otros lenguajes de programación, diferencia entre dos tipos de archivos según cómo se representan los valores almacenados en un archivo. En los ficheros de texto, los datos se representan como una secuencia de cadenas de texto, donde cada valor se diferencia del otro usando un delimitador. En cambio, en los ficheros binarios, los datos se representan directamente de acuerdo a su formato en binario, sin ninguna separación.
Vamos a centrarnos en el procesamiento de ficheros orientados a carácter.
Un fichero orientado a carácter no es más que un documento de texto, como el que podría generar con cualquier editor de texto simple. 
Para poder leer un fichero en Java, lo primero es importar las librerías que vamos a utilizar para ello:
```java8
	Import java.io.BufferedReader;
	import java.io.FileReader;
```
Todas las operaciones que se realicen sobre ficheros deberán estar incluidas en un bloque try-catch. Esto nos permitirá mostrar mensajes de error y terminar el programa de una forma ordenada en caso de que se produzca algún fallo - el fichero no existe, no tenemos permiso para acceder a él, etc.
El bloque try-catch tiene el siguiente formato:
```java8
	try {
		Operaciones_con_fichero
	} catch (tipo_de_error  nombre_de_variable) {
		Mensaje_de_error
	}
```	
Tanto para leer como para escribir utilizamos lo que en programación se llama un “manejador de fichero”. Es algo así como una variable que hace referencia al fichero con el que queremos trabajar.
```java8
	BufferedReader bf = new BufferedReader(new FileReader("nombres.txt"));
```
El contenido del archivo, normalmente estará separado en líneas. Un línea queda definida por el carácter terminador de línea ‘\n’.
Para leer una línea se utiliza el método **readLine()**. Devolverá todos los caracteres de la línea o  el valor null si hemos llegado al final del fichero.
Siempre que se termina de trabajar con un archivo es necesario cerrarlo con el método **.close()**

La ventaja de manejar un archivo de texto es que podemos guardar en el números y luego , tras leerlos como si fueran String, usar los métodos de conversión (parseInt, parseDouble, etc..)

### Escritura de archivos

Para poder escribir un fichero en Java, lo primero es importar las librerías que vamos a utilizar para ello:
```java8
	Import java.io.BufferedWriter;
	import java.io.FileWriter;
```
Después instanciamos un manejador para escribir
```java8
	BufferedWriter bfw = new BufferedWriter(new FileWriter("nombres.txt"));
```
Todas las operaciones que se realicen sobre ficheros deberán estar incluidas en un bloque try-catch.
Esto nos permitirá mostrar mensajes de error y terminar el programa de una forma ordenada en caso de que se produzca algún fallo (el fichero no existe, no tenemos permiso para acceder a él, etc.).
El bloque try-catch tiene el siguiente formato:
```java8
	try {
		Operaciones_con_fichero
		bfw.write("valor\n") // escribe una linea 
	} catch (tipo_de_error  nombre_de_variable) {
```
Recordar que al final , debemos cerrar el archivo con el método **.close()**
**IMPORTANTE:**
- Si instanciamos el manejador con  Filewriter(ruta_fichero) , si no existe el archivo lo creará y si ya existía, lo borrará y lo abrirá vacío.
- Si lo que deseamos es que no se borre lo que ya contiene el fichero, sino añadir nueva información, tendremos que abrir el fichero en modo “append”, instanciando de la siguiente manera: Filewriter(ruta_fichero,true).

#### Procesamiento específico, con formato
Al igual que ocurre con los archivos binarios, podemos decidir una estructura para la información que guardamos.
Imaginemos que nuestra clase coche posee un método toString y otro método recupera :

```java8

public String toString(){
	return  this.matricula + ";" + this.modelo + ";" this.color
}

public void recupera(String linea){
	String campos[] = linea.split(";");
	this.matricula = campos[0];
	this.modelo = campos[1];
	this.color = campos[2];
}

```
Si escribimos un línea en un archivo con el resultado de aplicar **toString** a un objecto, podríamos posteriormente
abrir el archivo, leer la linea y con el resultado obtenido aplicar **recupera** para restaurar el valor del objeto.

**El formato lo decide el programador**, lo documenta y se respeta a lo largo de la aplicación.
Este método tiene la ventaja de su simplicidad, sólo hay que cuidarse de que el caracter separador de atributos nunca
aparezca dentro los rangos de valores de los mismos.


Revisa el directorio (ud9-fi),  hay un proyecto ejemplo para ilustrar lo explicado.


### Enlaces de interés

La jerarquía de clases de Java es enorme, sólo se enlaza la más práctica para el
nivel de este módulo. Los tutoriales sobrepasan con creces los objetivos del módulo, pero son una buena referencia
para profundizar.

* [JavaDoc Oficial Lectura](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)
* [JavaDoc Oficial Escritura](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html)
* [Lectura de ficheros](https://www.baeldung.com/reading-file-in-java)
* [Escritura en ficheros](https://www.baeldung.com/java-write-to-file)

### Cuestiones para practicar

En la carpeta de ejercicios, hay una lista de ejercicios  para practicar y coger soltura en 
el manejo de ficheros.

Algo más elaborado es lo que se expone a continuación:
Tomando como referencia lo expuesto en anteriores secciones, ahora ya podemos almacenar todo el contenido
de nuestra aplicación, generando un archivo de texto y escribiendo todos los datos antes de terminar la aplicación.
De igual forma, podemos recuperar lo almacenado, si justo al principio de la aplicación abrimos el archivo
y cargamos todos su datos (líneas) en nuestra estructura de objetos.

1. Revisa tu código de biblioteca digital y crea dos métodos nuevos
* Uno para volcar todo el array list de publicaciones en un archivo
* Otro para leer del archivo al inicio de la aplicación y rellenar el array list
2. Con el interfaz que diseñamos para los coches, en vez de hacer una implementación en memoria, ahora podríamos:
* Añadir una línea nueva al archivo con los datos del coche que queremos añadir
* Buscar un coche, leyendo línea a linea y comparando campos hasta encontrarle.
* Las operaciones de actualizar y eliminar quedarían en memoria hasta que terminásemos la aplicación, momento en el que generaríamos un archivo nuevo con los datos de la sesión. 