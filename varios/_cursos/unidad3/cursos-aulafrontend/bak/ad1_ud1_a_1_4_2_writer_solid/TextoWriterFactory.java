package ad1_ud1_a_1_4_2_writer_solid;



public class TextoWriterFactory {

	public ITextoWriter getTextoWriter(String tipoImplementacionStr) {
		//Obtenemos el enumerado para escoger el tipo de implementacion que queremos utilizar
		TipoImplementacion tipoImplementacion = TipoImplementacion.findByClave(tipoImplementacionStr);
		
		//Ambas implementaciones, comparten la misma interfaz. Obtenemos la implementacion deseada y la guardamos en un objeto de la interfaz ITextoWriter
		ITextoWriter textoWriter = null;
		if (TipoImplementacion.PRINT_WRITER == tipoImplementacion) {
			textoWriter = new TextoPlanoPrintWriter();
		} else if (TipoImplementacion.BUFFERED_WRITER == tipoImplementacion) {
			textoWriter = new TextoPlanoBufferedWriter();
		} else if (TipoImplementacion.STDOUT == tipoImplementacion) {
			textoWriter =  new StdoutWriter();	
		}
		else {
			throw new RuntimeException("Tipo de implementacion no contemplada");
		}
		//Devolvemos el objeto generico interfaz
		return textoWriter;
	}
}
