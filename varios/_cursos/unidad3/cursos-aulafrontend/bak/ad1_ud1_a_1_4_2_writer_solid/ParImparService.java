package ad1_ud1_a_1_4_2_writer_solid;


/**
 * Capa de servicio, contiene la logica de negocio de nuestra aplicacion
 * 
 * Se encarga de escibir en un fichero si un numero es para o impar
 * 
 * Alta cohesion, solo tiene funcionalidades de su ambito.
 * Sabe interpretar si un numero es par o impar.
 * Conoce el mensaje a escribir, 
 * No sabe nada de escribir a fichero, eso pertenece a otro ambito o clase. Para eso hay un componente que lo recibe en el constructor que
 * se encarga de esa funcionalidad de escritura
 *
 */
public class ParImparService {
	
	public ITextoWriter textoWriter;
	
	//TODO descomentar este constructor para admitir la interfaz
	public ParImparService(ITextoWriter textoWriter) {
		this.textoWriter = textoWriter;
	}
	
	public ParImparService(TextoPlanoBufferedWriter textoWriter) {
		this.textoWriter = textoWriter;
	}
	
	public void writeToFile(String filePath, int numLineas) {
		System.out.println("Who am I:" + textoWriter.whoAmI());
		for (int numLinea = 0; numLinea <= numLineas; numLinea++) {
			textoWriter.write(filePath, getMessageLine(numLinea));
		}
	}
	
	/**
	 * Mensaje que mostraremos en el fichero de salida
	 * @param i
	 * @return
	 */
	private String getMessageLine(int i) {
		return String.valueOf(i) + " " +getMensajeEsPar(i);
	}

	public boolean esPar(int i) {
		return i%2 == 0;
	}
	
	public String getMensajeEsPar(int i) {
		String mensaje = "";
		if (esPar(i)) {
			mensaje = "es par";
		} else {
			mensaje="es impar";
		}
		return mensaje;
	}
}
