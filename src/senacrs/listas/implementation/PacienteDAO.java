package senacrs.listas.implementation;

import csv.CSVFile;
import model.Paciente;

public interface PacienteDAO {

	Paciente getPacienteByRG(String rg);
	void addPaciente(Paciente paciente);
	void removePaciente(String rg);
	void loadData(CSVFile file);
	
}
