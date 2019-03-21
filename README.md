# HearthstoneDecks
Una web de consulta de mazos, cartas, noticias, etc... sobre el videojuego hearthstone.


# FASE 1

Entidades principales: Mazos, Cartas, Noticias, Anuncios, Reglamento

1. **Mazos**: En esta parte los usuarios registrados pueden subir sus propios mazos, y cualquier usuario registrado o no puede consultarlos.

2. **Cartas**: Se muestran las cartas para consulta a cualquier usuario, es editable solo por los Administradores de la Web.

3. **Noticias**: Se suben noticias relativas al juego. Es visualizable por cualquiera, las noticias son subidas por Administradores. 

4. **Anuncios**: Permite a los usuarios registrados informar de eventos particulares como torneos. Es visualizable por cualquiera y actualizable solo por usuarios registrados.

5. **Reglamento**: Muestra las reglas del juego explicadas de forma sencilla para aprender a jugar. Es visualizable por cualquiera y actualizable solo por Administradores.

6. **Usuario**: Registro, crear mazos, crear anuncios, enviar y recibir mensajes privados.


## *Parte Pública*

Visualización de las listas de mazos, la lista de cartas, las noticias, los anuncios y las reglas.



## *Parte privada*

### Usuarios registrados:
Creación de anuncios y mazos, envío de mensajes privados. 
### Administradores:
Actualización de la página.



## *Sistema Interno*

Envío de avisos de sistema, notificación de novedades


## Integrantes: 
             
             Aitor Matilla Casanova; a.matilla@alumnos.urjc.es; @a-matillac.

             Ignacio Charco Iniesta; i.charco@alumnos.urjc.es; @i-charcoi.
             
             Ana Hernando Jiménez;   a.hernandoj@alumnos.urjc.es; @a-hernandoj.
             
# FASE 2

## Diagrama de navegación
En el siguiente diagrama se puede visualizar la accesibilidad entre las distintas páginas

![Diagrama de navegacion](/Imagenes_README/MapaDeNav.png)

Aunque en esta fase no se han creado las funciones de la parte privada, estas serán las de crear mazos y publicar anuncios nuevos en sus correspondientes páginas de la web.

A continuación se muestran las distintas páginas:

#### Pantalla de inicio:

Es la pagina principal de la web y se compone de una barracon el logo, la función de busqueda, login y register, junto con el menu que lleva a las distintas páginas; estas dos barras forman parte de todas las páginas para mantener un estilo. Debajo de estas se pueden ver las tres últimas noticias o la noticia reciente más relevante en caso de que haya una.

![index](/Imagenes_README/index.jpeg)

#### Noticias

En esta página se pueden leer todas las noticias sobre el juego en orden cronologico.

![noticias](/Imagenes_README/noticias.jpeg)

#### Anuncios

Aqui se pueden leer los anuncios publicados por los usuarios, además en una fase futura se incluira una funcion de la parte privada que permita crear los anuncios.

![anuncios](/Imagenes_README/anuncios.jpeg)

#### Mazos

Esta es la página donde se encuentran los mazos creados por los usuarios, en una futura fase incluiremos el acceso a un creador de mazos para los usuarios registrados.

![mazos](/Imagenes_README/mazos.jpeg)

#### Cartas

La página de cartas muestra todas las cartas disponibles para consultar sus datos y ver la información sobre ellas

![cartas](/Imagenes_README/cartas.jpeg)

#### Reglamento

Por último en la página de reglamento se muestran las reglas del juego y una explicación de las diferentes mecánicas de este para su fácil comprensión y poder aprender a jugar.

![Reglas](/Imagenes_README/reglamento.jpeg)

### Diagrama de Entidad-Relación

En el siguiente diagrama se muestra un modelo de datos donde se muestran las entidades del sistema asi como sus interrelaciones y propiedades.

![Diagrama](/Imagenes_README/DiagramaHSD.png)

### Diagrama UML de entidades

En el siguiente diagrama UML se muestra los distintos atributos de las entidades y como están relacionados entre sí.

![UML](/Imagenes_README/UMLHSD.png)


# FASE 3

## Diagrama de Navegación 
A continuación, se muestra el diagrama de navegación donde podemos visualizar la accesibilidad entre las distintas páginas:
![Diagrama de navegacion](/Imagenes_README/MapNav2.0.png)

Como podemos observar con el diagrama se pueden distinguir varias paginas publicas que son: 

index,cartas,mazos,registro/login,reglamento,anuncios,noticias y cerrar sesion. Además se obvia las paginas como login_correcto,login_incorrecto y deslogeo_correcto pero son publicas.

Como paginas privadas tenemos los formularios de creación de cartas,creacion de anuncios y creacion de noticias. Aqui se distingue dos roles: USER Y ADMIN.

Los usuarios con el rol de USER solo pueden crear mazos y anuncios, mientras que los administradores pueden acceder a estas paginas y,de forma exclusiva, a los formularios de creacion de noticias y cartas.

## Diagrama de Clases
A continuación, se muestra el diagrama de clases actualizado para esta fase:
![Diagrama de clases](/Imagenes_README/diagrama de clases.png)

