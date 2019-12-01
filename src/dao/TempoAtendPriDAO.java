package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TempoAtendPriDAO {

	public TempoAtendPriDAO() {
	}
	
	public boolean tempoAtendPri(String tempo1, String tempo2, String tempo3, String tempo4, String tempo5) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("tempoAtendimentoPrioridade.txt");
			bw = new BufferedWriter(fw);
			bw.write("Tempo Médio Atendimento por Prioridade:");
			bw.write("Prioridade 1: "+ tempo1);
			bw.newLine();
			bw.write("Prioridade 2: "+ tempo2);
			bw.newLine();
			bw.write("Prioridade 3: "+ tempo3);
			bw.newLine();
			bw.write("Prioridade 4: "+ tempo4);
			bw.newLine();
			bw.write("Prioridade 5: "+ tempo5);
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
