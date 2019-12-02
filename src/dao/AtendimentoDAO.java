package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.FilaAtendimento;
import model.ListaAtendimentos;
import model.NoAtendimento;
import model.NoFila;

public class AtendimentoDAO {

	public AtendimentoDAO() {

	}

	public boolean relatorioAtendimento(ListaAtendimentos lista) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("atendimentos.txt", true);
			bw = new BufferedWriter(fw);
			for (NoAtendimento aux = lista.primeiro(); aux != null; aux = aux.getProximo()) {
				long data = aux.getAtendimento().getDataC();
				 DateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			     Date result = new Date(data); 
				bw.write(aux.getAtendimento().getPac().getNome() + " # " + aux.getAtendimento().getPac().getCpf()
						+ " # " + aux.getAtendimento().getPac().getDatanasc() + " # " + simple.format(result)
						+ " # " + aux.getAtendimento().getSenha() + " # " + aux.getAtendimento().getDataS() + " "
						+ aux.getAtendimento().getHoraS());
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
