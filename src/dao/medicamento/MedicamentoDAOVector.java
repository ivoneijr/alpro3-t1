package dao.medicamento;

import model.Medicamento;
import model.Paciente;
import csv.CSVFile;

public class MedicamentoDAOVector implements MedicamentoDAO {

	private Medicamento[] medicamentos;
	
	public MedicamentoDAOVector(){
		medicamentos = new Medicamento[10];
	}
	
	public MedicamentoDAOVector(int size){
		medicamentos = new Medicamento[size];
	}

	@Override
	public Medicamento getMedicamento(Long codigo) {
		
		Medicamento founded = null;
		for (int i = 0; i < medicamentos.length; i++) {
			if(medicamentos[i].getCodigo().equals(codigo)){
				founded = medicamentos[i]; 
			}
//			return founded = medicamentos[i].getCodigo() == codigo? medicamentos[i]: null;
		}
		return founded;
	}

	@Override
	public void addMedicamento(Medicamento medicamento) {
		for (int i = 0; i < medicamentos.length; i++) {
			if(medicamentos[i] == null){
				medicamentos[i] = medicamento;
				break;
			}
		}
	}

	@Override
	public void removeMedicamento(Long codigo) {
		for (int i = 0; i < medicamentos.length; i++) {
			if(medicamentos[i].getCodigo().equals(codigo)){
				medicamentos[i] = null;
			}
		}
	}

	@Override
	public void loadData(CSVFile file) {
		file.readObject();
	}

	public Medicamento[] getMedicamentos() {
		return medicamentos;
	}
}