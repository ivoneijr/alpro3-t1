package dao.java.implementation.medicamento;

import csv.CSVFile;
import model.Medicamento;

public interface MedicamentoDAO {

	Medicamento getMedicamento(Long codigo);
	void addMedicamento(Medicamento medicamento);
	void removeMedicamento(Long codigo);
	void loadData(CSVFile file);
	
}
 