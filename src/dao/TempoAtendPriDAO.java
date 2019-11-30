package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TempoAtendPriDAO {

	public TempoAtendPriDAO() {
	}
	
	public boolean tempoAtendPri() {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("tempoAtendimentoPrioridade.txt", true);
			bw = new BufferedWriter(fw);
			bw.write("Tempo Médio Atendimento por Prioridade");
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
