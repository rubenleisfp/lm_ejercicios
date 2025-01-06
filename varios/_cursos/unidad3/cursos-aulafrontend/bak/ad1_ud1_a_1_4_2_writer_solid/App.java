package ad1_ud1_a_1_4_2_writer_solid;

import java.util.Scanner;



/**
 * App que se encarga de escribir en un fichero si un numero es par/impar
 * 
 */
public class App {

	
	private static final String filePath = "hola_mundo.txt";
	TextoWriterFactory textoWriterFactory = new TextoWriterFactory();
			
	public static void main(String[] args) {
		App app = new App();
		app.parImpar(args);
	}
	
	private void parImpar(String[] args) {
		//Recogemos los datos de entrada
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("¿Hasta que número quiere escribir si es par o impar?");
			Integer numLineas = s.nextInt();
			
			System.out.println("¿Que implementacion quieres usar?:");
			String tipoImplementacionStr = s.next();
						
			//ParImparService ahora mismo funciona siempre con BufferedWriter, pero queremos poder
			//utilizar cualqiuera de las implementaciones
			//TODO borrar lineas 38 y 39
			//TextoPlanoBufferedWriter textoPlanoBufferedWriter = new TextoPlanoBufferedWriter();
			//ParImparService parImparService = new ParImparService(textoPlanoBufferedWriter);
			
			//TODO descomentar estas lineas de codigo
			//Escogemos una de las implementacion que cumplen la firma de la interfaz ITextoWriter
			ITextoWriter textoWriter = textoWriterFactory.getTextoWriter(tipoImplementacionStr);
			//Inyectamos el objeto textoWriter en ParImparService. Le pasamos una instancia concreta
			ParImparService parImparService = new ParImparService(textoWriter);
			parImparService.writeToFile(filePath, numLineas);
		}
	}

}
