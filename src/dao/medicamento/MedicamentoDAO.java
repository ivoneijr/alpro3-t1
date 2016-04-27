package dao.medicamento;

import java.util.List;

import model.Medicamento;
import csv.CSVFile;

public interface MedicamentoDAO {

	Medicamento getMedicamento(Long codigo);
	List<Medicamento> getMedicamentoByNome(String nome);
	void addMedicamento(Medicamento medicamento);
	void removeMedicamento(Long codigo);
	void loadData(CSVFile file);
	
}
 