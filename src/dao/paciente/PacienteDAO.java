package dao.paciente;

import java.util.List;

import model.Paciente;
import csv.CSVFile;

public interface PacienteDAO {

	Paciente getPacienteByRG(String rg);
	List<Paciente> getPacienteByNome(String nome);
	void addPaciente(Paciente paciente);
	void removePaciente(String rg);
	void loadData(CSVFile file);
	
}
