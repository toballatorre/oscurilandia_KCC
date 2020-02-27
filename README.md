# OSCURILANDIA

## 1.-Caso: “Consecuencias”

Hace unos meses, la “Cámara Secreta” de **Oscurilandia** decidió implementar un nuevo sistema de votación para sus leyes, dado el aumento en la cantidad de representantes. Esto generó vicios en el proceso, ya que muchos representantes, a fin de evitar aprobar una ley que no fuera de su gusto, se restaban de la votación, aumentando la cantidad en el universo de votos y dificultando con ello obtener el margen de aprobación necesario.

Esto generó molestia en los ciudadanos de **Oscurilandia**, y están considerando seriamente invadir la “Cámara Secreta”, gracias a la ayuda de un grupo de superhéroes anónimos autodenominados “FirstLine”.

En razón a la contingencia actual, los representantes han llamado a su grupo de acción, la élite de seguridad PKS, para restaurar el orden. Este grupo cuenta con tres tipos de vehículos para realizar operaciones:

**-Kromis:**  Tienen  un  largo  de  tres  metros  cada  una,  y  son  utilizadas  para  transportar efectivos de la PKS.

**-Caguanos:** Cada uno mide dos metros de largo, y su misión es lanzar confetis y dulces a quienes protestan.

**-Trupallas:** Corresponden  a  efectivos  cibernéticos  con  tecnología  de  punta,  cada  uno ocupando en total un metro cuadrado de espacio, preparados para hacer entrar en razón a los manifestantes con la fuerza de sus ideas.

Como  respuesta  a  las  acciones  de  la  PKS,  el  comando  FirstLine  solicita  que  se  desarrolle  un programa que los ayude a simular las posiciones de los efectivos alrededor de la Cámara Secreta, y de esta forma coordinar las acciones previas a la invasión.

## 2.-PROBLEMA

Desarrolle un programa que realice lo siguiente:
 -Para efectos de simulación, el lugar de acción se simularácomo una matriz compuesta de caracteres con 15 filas y 15 columnas, en los que se dispondrán de forma aleatoria:
 o  3 Kromis, donde cada una utiliza tres celdas de la matriz y se ubican siempre de forma  vertical.  Cada  celda  ocupada por  un  vehículo  de  este  tipo  se  define  con una letra “K”.
 
 o  5  Caguanos,  ubicados  siempre  horizontalmente  en  la  matriz,  definidos  en  ésta con una letra “C” y haciendo uso de dos espacios.
 
 o  10 Trupallas, los cuales se representan como una celda en la matriz con la letra “T”.
 
-El programa debe situar de forma aleatoria la cantidad de vehículos antes indicados. Se recomienda hacerlo en el orden antes mencionado, pero no es obligación. Considere que cada tipo de vehículo ocupará una determinada cantidad de celdas en la matriz, y que no pueden existir vehículos encima de otros.
 
-Por cada vehículo ingresado, entonces, se debe hacer lo siguiente:oEl programa calcula una fila y columna de forma aleatoria (el número debe estar en el rango definido).
 o  Si  está  agregando  una  Kromi,  debe  escribir  tres celdas  hacia  abajo  contando desde la celda obtenida, si es un Caguano debe rellenar dos celdas hacia el lado (de izquierda a derecha), mientras que,si el vehículo a registrar es un Trupalla, se debe agregar en la coordenada obtenida ya que solo usa una celda.
 
 o  Antes  de  agregar  un  vehículo,  se  debe  validar  que  no  exista  ningún  otro  en algunas  de  las  posiciones  que  se  considerará.  De  no  ser  así,  se  debe  obtener nuevamente otro par de coordenadas de forma aleatoria hasta que sea posible ubicar el vehículo en cuestión sin inconvenientes.
 o  Además, recuerde que todo vehículo debe quedar siempre situado dentro de la matriz, lo cual también se debe validar. Si las coordenadas obtenidas provocan que  el  vehículo  no  cumpla  con  esta  condición,  se  debe  solicitar  otra  filay columna.
 o  Un ejemplo de matriz generada de forma posterior a este proceso es la que se muestra a continuación:
 

