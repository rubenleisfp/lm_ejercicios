package ad1_ud1_a_1_4_2_writer_solid;

public interface ITextoWriter {
	/**
	 * 
	 * @param filePath ruta del fichero dónde se realizará un append de una linea
	 * @param line linea que queremos insertar al final del fichero
	 */
	void write(String filePath,String line);
	
	/**
	 * Texto con un Hello + Nombre de la clase
	 * @return
	 */
	String whoAmI();
}
