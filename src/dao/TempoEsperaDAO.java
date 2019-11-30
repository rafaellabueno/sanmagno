package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TempoEsperaDAO {

	public TempoEsperaDAO() {

	}

	public boolean tempoEspera() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("TempoMediodeEspera.txt", true);
			bw = new BufferedWriter(fw);

			bw.write("Tempo Médio de Espera");
			bw.newLine();
			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
}
