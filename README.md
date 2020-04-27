# AplicacionProlog
Aplicación realizada en Java implementando un servicio o basado en el estilo arquitectural basado en reglas de negocio

## Integrantes

- Cristian Felipe Patiño Cáceres - 20141020079
- Cristian David Santoyo Parra - 20141020077
- Brian Giovanny Alfonso Rodriguez - 20151020600
- Catalina Hernandez Casas - 20201099034

# Problema

Se necesita determinar si un conjunto de estudiantes aprobaron o no una asignatura teniendo en cuenta sus notas, el número de fallas que acumularon durante el periodo académico y el número de créditos asociados con la asignatura.

# Solución

Se implementa un sistema de reglas y un motor de conocimiento mediante un archivo prolog en el cual se dan los enunciados y predicados necesarios para verificar si un estudiante pasa o no una materia, ademas se hace un enlace con JAVA para manejar dicho archivo desde un programa Java.


# Indicaciones Técnicas

Para establecer la conexión de forma exitosa es necesario crear unas variables de entorno (En Windows).
* Para esto damos click derecho a **Este Equipo** y escogemos la opción **propiedades**:
<div align='center'>
    <img  src='../resources/propiedades.png'>
    <p>Selección de propiedades del equipo</p>
</div>

* Una vez se despliega la pantalla se escoge la opción configuración avanzada del sistema:

<div align='center'>
    <img  src='../resources/configuraciones.png'>
    <p>Se escoge la opción Configuraciones</p>
</div>

* En la ventana que sale se escoge la opción variables de entorno:

<div align='center'>
    <img  src='../resources/variables.png'>
    <p>Se escoge la opción variables de entorno</p>
</div>

* Se selecciona la variable del sistema **path** y se escoge la opción editar:

<div align='center'>
    <img  src='../resources/path.png'>
    <p>Se selecciona la variable path y se edita</p>
</div>

* Una vez dentro se debe escribe las siguientes rutas:
    * C:\Program Files\swipl\bin
    * C:\Program Files\swipl\lib\jpl.jar
    * C:\Program Files\Java\jdk1.8.0_171\bin
    * C:\Program Files\Java\jdk1.8.0_171\lib\tools.jar
    * C:\Program Files\Java\jdk1.8.0_171\lib\rt.jar

***Nota:** El jdk que se inserta es el que se tenga instalado en la maquina en este caso es el jdk1.8.0_171*.

<div align='center'>
    <img  src='../resources/rutas.jpg'>
    <p>Rutas añadidas a la variable path</p>
</div>

Ahora una vez dentro del proyecto se debe ingresar el jar **jpl.jar** en la parte de librerías: 

<div align='center'>
    <img  src='../resources/lib.png'>
    <p>se da click derecho a libraries y se escoge add JAR/Folder</p>
</div>

Se selecciona el archivo **jpl.jar** que se encuentra en **C:\Program Files\swipl\lib\jpl.jar**:

<div align='center'>
    <img  src='../resources/jpl.png'>
    <p>selección de archivo jar</p>
</div>

Con esto el programa puede ejecutarse correctamente.

# Resultado

A continuación se ve una demostración de la aplicación:

<div align='center'>
    <img  src='../resources/demostracion.jpg'>
    <p>Resultado de aplicación corriendo</p>
</div>