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
## Inicio
Esta es la pagina de inicio donde nos muestra dos botones que son los de logeo y de registro:
![index](/Imagenes_README/index.png)
## Formulario de registro
Cuando accedemos al boton de register nos aparece el siguiente formulario donde debemos introducir Nombre,Apellidos,nick, correo,contraseña, fecha de nacimiento y pais. 
![formulario de registro](/Imagenes_README/register.png)
## Formulario de logeo
Cuando se da al formulario de logeo nos aparece dos cuadros de texto donde se introducen el nick y el usuario:
![login](/Imagenes_README/login.png)
En el caso que no se introduzca correctamente el usuario y la contraseña dara error redireccionando nuevamente al login:
![error](/Imagenes_README/error.png)
## Noticias
Al estar logeado como administrador sale el siguiente boton para publicar las noticias:
![notocia](/Imagenes_README/noticia.png)
Al clicar el boton de publicar aparece el siguiente formulario a rellenar:
![formulario](/Imagenes_README/formnoti.png)
Nos redireccionaria nuevamente a noticias.
## Cartas 
Tiene el mismo comportamiento que noticias, si estas logeado como admin saldra el siguiente boton y al pulsarlo el siguiente formulario:
![cartas](/Imagenes_README/cartas.png)
![formcarta](/Imagenes_README/formcartas.png)
## Mazos
Si se esta logeado como usuario saldra el boton de crear mazo con su respectivo formulario:
![mazo](/Imagenes_README/mazo.png)
![fmazo](/Imagenes_README/formmazo.png)
## Anuncios
Si se esta logeado como usuario saldra el siguiente boton de publicar y al pulsarlo sale el siguiente formulario:
![anuncio](/Imagenes_README/anuncios.png)
![fanuncio](/Imagenes_README/formanuncio.png)

## Mensaje de deslogeo
Cuando se pulsa a cerrar sesion en el index aparece la siguiente pagina que redirecciona al index cuando se deslogea:
![deslog](/Imagenes_README/deslog.png)


## Diagrama de Clases
A continuación, se muestra el diagrama de clases actualizado para esta fase:
![Diagrama de clases](/Imagenes_README/diagramadeclases.png)

## DEspliegue de la maquina virtual

Para realizar el despliegue de la maquina virtual se necesita los siguientes software: 

1. Eclipse STS 4.
2. Java 8.
3. MySQL Server.
4. MySQL Workbench 8.0.
5. VirtualBox.
6. Vagrant.

En un primer lugar, generamos los .jar de la aplicacion y el servicio interno de la siguiente manera:
                    
                    Click derecho en el proyecto>Run as...>Maven build...>Goals>clean package>Run

Tras tener previamente instalado Vagrant y VirtualBox, iniciamos el cdm de Windows para poder generar la maquina virtual en una carpeta con el nombre "vagrant/spring":
                    
                    cd C:\Users\Usuario\Desktop\vagrant\spring

Dentro de esta carpeta ejecutamos el siguiente mandato para la instalacion de ubuntu:
                    
                    vagrant init ubuntu/trusty64

Seguidamente, dentro de la carpeta "spring" se encuentra el archivo Vagrantfile el cual hay que modificar las siguientes lineas y descomentarlas:
                    
                    config.vm.network "private_network", ip: "192.168.33.10"
                    config.vm.network "forwarded_port", guest: 8443, host: 8443, host_ip: "127.0.0.1"
                    config.vm.network "forwarded_port", guest: 5555, host: 5555, host_ip: "127.0.0.1"

Estas modificaciones se realizan para que la maquina ejecute en un puerto la aplicacion y en otro el servicio interno.
Ya hecha esta modificacion, en el cmd ejecutamos los siguientes comandos:
                     
                     vagrant up
                     vagrant ssh
Con estos comandos se prepara la maquina y se la ejecuta.

Instalamos dentro de la maquina virtual java:
                     
                     sudo add-apt-repository ppa:webupd8team/java -y
                     sudo apt-get update
                     sudo apt-get install oracle-java8-installer

Despues, se instala mysql:
                     
                     sudo apt-get install mysql-server
                     sudo apt-get install mysql-workbench

Tras meter la contraseña podemos crear una base de datos de la siguiente forma:
                     
                     mysql -u root -p
                     CREATE DATABASE prueba;

Ya realizados estos pasos, nos situamos en la carpeta vagrant que se encuentra dentro de la maquina:
                     
                     cd /vagrant

Desde aqui solo hace falta ejecutar los jar siguiendo la siguiente estructura de comando:
                    
                    java -jar nombre_ejecutable.jar
              
# Fase 4
[![Vídeo tutorial](https://img.youtube.com/vi/P3FJT4PsR1w/0.jpg)](https://www.youtube.com/watch?v=P3FJT4PsR1w)
