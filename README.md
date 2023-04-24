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

La información que se proporciona, sirve sólo de guía para buscar y adquirir el conocimient.
Cada sección contiene un pequeño resumen y enlaces, así como fragmentos de códigos de ejemplo
La mecánica recomendada es :
* acceder a los enlaces , leer con atención e reproducir los ejemplos (si es un tutorial)
* Buscar otros enlaces de referencia y repetir el proceso
* Revisar ejemplos o realizar ejercicios

Para que esto sea realmente productivo, aprovecha la potencia del trabajo en equipo, forma grupos con 
tus compañeros y entre todo id construyendo 


## Gestión de la información (ud9-gi) :rocket: 

Al final, cualquier aplicación relevante maneja información de forma persistente, es decir, la información se crear, modifica y elimina 
durante la ejecución de la aplicaicón, pero cuando esta termina, queda almacenada de alguna forma.

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


Como concepto una buena solución sería el crear un **interfaz** con los elementos básicos, y luego para
cada clase realizar la implementación. Por ejemplo

```java8

public interface DAO{
    public void addCoche(Coche c);		// Añadidmos un coche nuevo
    public void updateCoche(Coche _old, Coche _new); // actualizamos los datos de un coche con los de otro
    public boolean deleteCoche(Coche c); // Elimino un coche
    public Coche findCoche(String clave); // Recupero un coche a partir de su matrícula
    public ArrayList<Coche> getCoches(); // REcupero todos los coches almacenados
}
```
La idea es que las operaciones de añadir, eliminar y actualizar sean sobre un único objeto, para ello
debemos utilizar un atributo (clave) que identifique de forma únivoca al objeto
La operación de obtener todos, nos servirá para cargar completamente una colección en memoria y 
recorrerla y manipularla a nuestro gusto.

**En la carpeta ud9-gi se encuentra un ejemplo de lo expuesto (sólo archivos java)**

Aplica este concepto a diseños anteriores (electrodomésticos y bibliotecadigital), todavía quedará más claro el programa principal!!

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
