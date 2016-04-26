package dao.medicamento;

import java.util.ArrayList;
import java.util.Iterator;

import model.Medicamento;
import csv.CSVFile;

public class MedicamentoDAOLista implements MedicamentoDAO {

	private ArrayList<Medicamento> medicamentos;
	
	public MedicamentoDAOLista(){
		medicamentos = new ArrayList<Medicamento>();
	}
	
	@Override
	public Medicamento getMedicamento(Long codigo) {
		Medicamento founded = null;
		
		Iterator<Medicamento> iterator = medicamentos.iterator();
		while(iterator.hasNext()){
			Medicamento medicamento = iterator.next();
			if(medicamento.getCodigo().equals(codigo)){
				founded = medicamento;
			}
		}
		return founded;
	}

	@Override
	public void addMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}

	@Override
	public void removeMedicamento(Long codigo) {
		Iterator<Medicamento> iterator = medicamentos.iterator();
		while(iterator.hasNext()){
			Medicamento medicamento = iterator.next();
			if(medicamento.getCodigo().equals(codigo)){
				medicamentos.remove(medicamento);
			}
		}
	}

	@Override
	public void loadData(CSVFile file) {
		file.readObject();
	}

	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}
}
