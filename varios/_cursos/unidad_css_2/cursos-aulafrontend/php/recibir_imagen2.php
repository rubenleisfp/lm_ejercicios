<!doctype html>
    <html>
    <head>
    <meta charset="utf-8">
    <title>Recibir datos </title>
    </head>

<body>
    <h3>Recibir datos del formulario.</h3>
    <p>
    <?php
    $alfanum = "/^[a-zA-Z\s]+$/";
    $numeros = "/^[[:digit:]]+$/";
    if (isset($_POST["nombre"])) {
      if  (!preg_match($alfanum, $_POST["nombre"])) {
          print "<p>Debes escribir tu nombre solo con letras.</p>";
      } 
      else { // nombre correcto 
        if  (!preg_match($numeros, $_POST["imagen_x"])) {
          print "<p>imagen_x erroneo: </p>";
        }
       else
         if  (!preg_match($numeros, $_POST["imagen_y"]))  {
            print "<p>imagen_y erroneo: </p>";
       }
       else {
          $x=$_POST['imagen_x'];
          $y=$_POST['imagen_y'];
          if ($x <= 0 || $y <= 0) {
            echo "Haz clic en la imagen.";
          }
         else {
             echo $_POST['nombre'];
             echo " has hecho clic ";
            if ($x < 30) {
               echo "en el ratón.";
            }
           else
              if ($x < 75) {
                 echo "en el sombrero.";
              } else  
                  if ($y < 30) {
                     echo "en la palabra <b>aula</b>.";
                  }
                  else {
                       echo "en la palabra <b>Clic</b>.";
                  }
                  echo "<br/><br/> Coordenadas $x, $y"; 
               }
            }
         }
    }
    ?>
  </p>
  <p><button type="button" onclick="location='../form_imagen2.html'">Volver</button></p>
  </body>
 </html>