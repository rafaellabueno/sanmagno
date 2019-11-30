package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;

import model.ListaPaciente;
import model.No;

public class PacienteDAO {

	public PacienteDAO() {

	}

	public boolean relatorioPaciente(ListaPaciente lp) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("pacientes.txt", true);
			bw = new BufferedWriter(fw);
			for (No aux = lp.primeiro(); aux != null; aux = aux.getProximo()) {
				bw.write(aux.getPaciente().getNome() + " # " + aux.getPaciente().getCpf() + " # "
						+ aux.getPaciente().getDatanasc());
				bw.newLine();
				bw.flush();
			}

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
