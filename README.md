
<title>El programa posee dos botones:</title>

 <red>-Cargar:</red> La unica funcion que posee este boton es la de guardar el texto escrito en el input
del JtextArea en un archivo "codigo.txt". ATENCION este boton sobrescribe lo que tengamos
guardado en ese archivo, por lo tanto si el archivo estaba con otro contenido este se perdera.


<red>-Analizar:</red> Este boton se encargara de llamar a las funciones del analizador lexico, por lo tanto utilizara el archivo "codigo.txt". Es posible acceder a este boton sin haber utilizado el boton de cargar, ya que se puede generar un archivo "codigo.txt" por fuera del programa y situarlo en la misma carpeta donde se esta ejecutando el programa. Las salidas de la funcion
analizar seran de dos maneras:
	.Un archivo tabla de simbolos, "ts.txt" 
	.Un pantalla que retornara todo lo relacionado al analizador lexico.
