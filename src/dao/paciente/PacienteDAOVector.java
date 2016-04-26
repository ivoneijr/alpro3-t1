package dao.paciente;

import model.Paciente;
import utils.Utils;
import csv.CSVFile;

public class PacienteDAOVector implements PacienteDAO {

	private Paciente[] pacientes;
	
	public PacienteDAOVector(){
		pacientes = new Paciente[10];
	}
	
	public PacienteDAOVector(int size){
		pacientes = new Paciente[size];
	}

	@Override
	public Paciente getPacienteByRG(String rg) {
		Paciente founded = null;
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i].getRg().equals(rg)){
				founded = pacientes[i];
			}
//			return founded = pacientes[i].getRg().equals(rg)? pacientes[i]: null;
		}
		return founded;
	}

	@Override
	public void addPaciente(Paciente paciente) {
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i] == null){
				pacientes[i] = paciente;
				break;
			}
		}
	}

	@Override
	public void removePaciente(String rg) {
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i].getRg().equals(rg)){
				pacientes[i] = null;
			}
		}
	}

	@Override
	public void loadData(CSVFile file) {
		file.readObject();
	}

	public Paciente[] getPacientes() {
		return pacientes;
	}
}