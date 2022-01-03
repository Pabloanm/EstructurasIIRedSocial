# EstructurasIIRedSocial
Red Social - Backend - Algoritmos y Estructura de Datos II - Java


Algoritmos y Estructura de Datos II
Modelo de Trabajo Práctico en Lenguaje JAVA

Requisitos de aprobación del trabajo
- Entrega de código fuente sin errores de compilación o excepciones no capturadas
- Presentación del trabajo y verificación del cumplimiento de los requerimientos solicitados.

Requerimientos mínimos del modelo
Extensibilidad: Es necesario que el modelo pueda extenderse a nuevos tipos de publicaciones, cuentas,
etc.
Gestión de errores: El sistema debe capturar todos los errores posibles en tiempo de ejecución y
clasificarlos según corresponda con una jerarquía de excepciones. (opcional)
Estándar abierto: Considerar que cualquier satélite debe poder conectarse a la red, por lo tanto es
necesario que la implementación relacionada a la conectividad de cada uno esté normalizada.
Mantenibilidad: Hacer uso de los principios de POO para construir un producto que sea de fácil
mantenimiento, por ejemplo evitando la duplicación de código y desacoplando los subsistemas cuando
sea posible.

La Red Social

El objetivo de este trabajo es implementar un modelo basado en el paradigma de la programación
orientada a objetos que represente una red social con las condiciones y enunciados propuestos. La red
social a desarrollar se trata de un conjunto de usuarios que interactúan entre sí a través de publicaciones
publicadas en sus cuentas.
Usuarios y cuentas
Cada usuario tiene asignada una única cuenta, es decir, no existe la posibilidad de que un usuario tenga
asociada más de una cuenta. La diferencia entre usuario y cuenta es simplemente a nivel conceptual, ya
que son dos entidades distitntas.
Un usuario tiene un nombre completo, mail, fecha de nacimiento y un identificador alfanumérico único en
el sistema (id, username, etc).
Una cuenta tiene una pizarra (feed, muro, timeline, etc) de publicaciones publicadas por otros usuarios a
los que sigue la cuenta. Entonces el usuario puede ver en la pizarra de la cuenta que tiene todos las
publicaciones que han publicado las cuentas que sigue ordenados por fecha (primero los más recientes).

También posee una fecha de apertura y un estado (inicialmente tenemos 2 estados: Abierta o
Suspendida). Si la cuenta está Suspendida, no puede hacer publicaciones de ningún tipo, pero sí puede
ver publicaciones de a quienes sigue.
Una cuenta puede ser de uno de estos tres tipos:
● Cuenta normal: El usuario que tiene esta cuenta puede seguir a otras cuentas de cualquier tipo,
pero sólo puede ser seguido por cuentas Normales. Sólo puede hacer publicaciones de tipo de
texto pequeños.
● Cuenta Popular: Destinada a personas famosas, pueden seguir a cuentas de cualquier tipo,
pero no pueden ser seguidas por cuentas Empresa. Pueden hacer publicaciones de cualquier
tipo.
● Cuenta Empresa: Es para entidades comerciales, no pueden seguir a otras cuentas, pero
pueden ser seguidas por cualquier tipo de cuenta. Pueden hacer publicaciones de cualquier tipo.
Tienen asociada información de contacto (mail, teléfono, dirección).
El acceso a visualizar el perfil de una cuenta muestra información asociada a la misma, como así
también los mensajes publicados hasta el momento.
Seguimiento
La acción de seguimiento de una cuenta a otra permite que la originante reciba notificaciones de las
publicaciones en su pizarra (feed) que fueron publicadas por la cuenta seguida. Entonces, cuando una
cuenta publica algo, todas las cuentas que la siguen reciben el mismo en sus respectivas pizarras.
Se deben tener en cuenta las restricciones mencionadas en el punto previo respecto a qué tipo de
cuentas pueden realizar la acción de seguimiento sobre qué otro tipo de cuentas.
Por ejemplo, si un usuario A comienza a seguir la cuenta de otro usuario B, cuando este último usuario B
hace una publicación, ésta será visualizada en la pizarra del usuario A (como así también en la de todas
las otras cuentas de los seguidores de B).
A su vez, aquellos seguidores de una cuenta pueden acceder a su perfil para así visualizar información
asociada y todas las publicaciones publicadas hasta el momento.
Publicaciones
Las publicaciones soportados hasta el momento son sólo de texto, pero eventualmente podrán existir
mensajes multimedia (fotos, videos, animaciones, etc). También pueden incorporar etiquetas que
vinculen a otra cuenta, por ejemplo mencionando a esa cuenta dentro del mensaje con un @ adelante.
En ese caso, la cuenta etiquetada dentro de un mensaje publicado recibirá también la publicación en su
pizarra (sea o no seguidor de esa cuenta autora).
Cada publicación contiene la siguiente información:
● Fecha de publicación
● Autor (cuenta que lo publicó)
● Contenido: En el caso de mensajes de texto, el contenido es exclusivamente texto.

● Etiquetas: Cuentas a las cuales se menciona en el mensaje (utilizando el @ adelante del nombre
del usuario/cuenta)
Dependiendo del tipo de cuenta como se mencionó antes, es posible que puedan generar dos tipos de
publicaciones de texto:
● Publicación de Texto pequeño: permite el contenido de hasta 150 caracteres.
● Publicación de Texto extendido: permite el contenido de hasta 300 caracteres.
● Republicación: incorpora como contenido una publicación original republicable.
Por otra parte, las publicaciones también pueden soportar dos acciones cuando se las publica. La
decisión de qué acciones soporta la realiza el usuario al momento de publicarla (no hay restricción por el
tipo de cuenta que posee). Así que puede elegir que soporte ninguna, una, o más acciones, produciendo
así publicaciones de tipo:
● Likeables: Permiten que los usuarios que reciben esta publicación en sus pizarras puedan
realizar la acción Me Gusta (Like) sobre la misma. En ese caso, se incrementará un contador de
Likes en la publicación y este mismo se mostrará dentro de la información de la misma ya
mencionada.
● Republicables: Permiten que los usuarios puedan republicar esta publicación.
El proceso de Publicar
El proceso de publicar dependerá de qué tipo de cuenta lo realice, ya que se deben cumplir las
restricciones del tipo de publicación que puede hacerse. En general, cuando el usuario decide publicar se
le pedirá que ingrese el tipo de publicación, contenido de la misma (que puede tener
etiquetas/menciones a otros usuarios) y qué acciones soportará (opcional). Se debe validar que el
contenido esté ajustado a la limitación de caracteres.
Al publicar se procede entonces a la propagación de la publicación a las cuentas que tiene como
seguidoras de la cuenta autora, junto también a las cuentas que pudieran aparecer etiquetadas.
El proceso de Republicar
Esta acción sólo se permite hacer en cuentas activas y sobre publicaciones que son republicables. En
ese caso, toda información de la publicación original se agrega como contenido de una nueva
publicación de tipo Republicación y luego continuará el mismo proceso de publicar visto anteriormente,
sólo que no se solicitará al usuario que especifique el tipo y contenido de esta nueva publicación.
Interacción usuario - publicación
Dependiendo del tipo de publicación, los usuarios pueden realizar acciones de Me Gusta o Republicar
sobre las publicaciones que reciben en su pizarra.
Alcance de la cuenta
El concepto de alcance de una cuenta se define como la cantidad de cuentas a las que tiene potencial
llegada. Esta cantidad se computa de la suma de todas las cuentas que la siguen y los alcances de
dichas cuentas. Entonces, la idea es calcular cuantos seguidores tiene una cuenta de forma directa o
indirecta (seguidores de cuentas seguidoras y sus seguidores, etc).

Este alcance no es estático ya que cambiará cada vez que se realiza una nueva acción de seguimiento.
Tener en cuenta que no se deben contar usuarios seguidores repetidos, cada seguidor sea directo o
indirecto cuenta como uno en el alcance.

Escenario de prueba
Este escenario deberá ser preparado para presentar la fecha de entrega. Se solicita que se cumplan
todos los puntos mencionados y luego existirá la posibilidad de realizar nuevas interacciones a través del
menú que se pide a continuación.
La aplicación debe mostrar un menú por consola Java que permita:
1) Listar todas las cuentas de la red
2) Seleccionar una cuenta (submenú)
a) Ver la pizarra: Lista las publicaciones y permite
i) Realizar acción Me Gusta sobre una publicación
ii) Realizar acción Republicar sobre una publicación
b) Ver publicaciones realizadas
c) Publicar
d) Ver información de la cuenta
e) Ver alcance de la cuenta
f) Activar/Suspender la cuenta
3) Salir

Adicionalmente, el trabajo debe implementar en su método main lo siguiente:
1) Instanciar todos los objetos necesarios para representar el escenario de la imagen en la primera
página, donde UserX son cuentas Normales, PopX son cuentas Populares y EmpresaX son
cuentas de Empresa.
La dirección de cada conexión representa la acción de seguimiento, entonces una cuenta origen
sigue a la destino.
2) Las pizarras de todas las cuentas deben estar inicializadas vacías.
3) Empresa1 publica un texto extendido, likeable y republicable con contenido “Hola, soy
Empresa1”.
Resultado esperado: las cuentas seguidoras (Pop1, Pop2, Pop3, User3 y User5) reciben la
publicación.
4) Empresa1 publica un texto extendido y likeable con contenido “Hola, acá de nuevo Empresa1”.
Resultado esperado: las cuentas seguidoras (Pop1, Pop2, Pop3, User3 y User5) reciben la
publicación.
5) Empresa2 publica un texto extendido, likeable y republicable con contenido “Hola, soy
Empresa2”.
Resultado esperado: las cuentas seguidoras (User1, User2, Pop1 y Pop3) reciben la publicación.
6) Empresa2 publica un texto extendido y republicable con contenido “Hola, acá de nuevo
Empresa2”.
Resultado esperado: las cuentas seguidoras (User1, User2, Pop1 y Pop3) reciben la
publicación.
7) Pop1 publica un texto extendido, likeable y republicable con contenido “Hola, soy Pop1 amiga de
@Pop2” (etiqueta a Pop2).
Resultado esperado: las cuentas seguidoras (User2, User y Pop3) y Pop2 reciben la publicación.
8) Pop2 republica la publicación recibida del punto 7.

Resultado esperado: las cuentas seguidoras (User4 y User5) reciben la publicación.
9) User2 publica un texto pequeño y likeable con contenido “Que bueno estar con @User3 y
@User4 viendo a Pop1”.
Resultado esperado: las cuentas seguidoras (User1 y Pop1), User3, User4 y Pop1 reciben la
publicación. Pop1 sólo recibe la publicación una vez (no por duplicado).
10) User1, User3 y User4 accionan Me Gusta en la publicación recibida del punto 9.
Resultado esperado: se incrementa el contador de Likes de la publicación a 3.
11) Mostrar el alcance de Empresa1.
Resultado esperado: se muestra el alcance de la cuenta: 8.
12) User3 acciona Me Gusta en la publicación recibida del punto 9.
Resultado esperado: se ignora la acción porque el User3 ya la hizo sobre esa publicación en el
paso previo.
13) Pop3 acciona Me Gusta en la publicación recibida del punto 6.
Resultado esperado: se muestra error porque esa publicación no acepta esa acción.
14) User5 publica un mensaje extendido.
Resultado esperado: se muestra error porque ese tipo de cuenta no puede publicar mensajes de
ese tipo.
