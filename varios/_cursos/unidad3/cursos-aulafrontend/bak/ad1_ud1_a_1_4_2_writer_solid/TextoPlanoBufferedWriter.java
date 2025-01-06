package ad1_ud1_a_1_4_2_writer_solid;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextoPlanoBufferedWriter implements ITextoWriter {

	public void write(String filePath, String line) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));) {
			writer.append(line + "\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String whoAmI() {
		return "I am TextoPlanoBufferedWriter";
	}

}
