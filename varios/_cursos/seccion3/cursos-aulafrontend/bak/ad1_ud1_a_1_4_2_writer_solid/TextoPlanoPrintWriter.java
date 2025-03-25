package ad1_ud1_a_1_4_2_writer_solid;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextoPlanoPrintWriter implements ITextoWriter {

	public void write(String filePath, String line) {
		// mediante try resources evitamos tener que cerrar los recursos
		try (FileWriter fileWriter = new FileWriter(filePath, true); PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.println(line);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String whoAmI() {
		return "I am TextoPlanoPrintWriter";
	}
	
}
