package dao.paciente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Paciente;
import csv.CSVFile;

public class PacienteDAOLista implements PacienteDAO {

	private ArrayList<Paciente> pacientes;
	
	public PacienteDAOLista(){
		pacientes = new ArrayList<Paciente>();
	}
	
	@Override
	public Paciente getPacienteByRG(String rg) {
		Paciente founded = null;
		
		Iterator<Paciente> iterator = pacientes.iterator();
		while(iterator.hasNext()){
			Paciente paciente = iterator.next();
			if(paciente.getRg().equals(rg)){
				founded = paciente;
			}
		}
		return founded;
	}

	@Override
	public List<Paciente> getPacienteByNome(String nome) {
		List<Paciente> list = new ArrayList<Paciente>();
		
		Iterator<Paciente> iterator = pacientes.iterator();
		while(iterator.hasNext()){
			Paciente paciente = iterator.next();
			if(paciente.getNome().matches(".*"+nome+".*")){
				list.add(paciente);
			}
		}
		return list;
	}

	@Override
	public void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

	@Override
	public void removePaciente(String rg) {
		Iterator<Paciente> iterator = pacientes.iterator();
		while(iterator.hasNext()){
			Paciente paciente = iterator.next();
			if(paciente.getRg().equals(rg)){
				pacientes.remove(paciente);
			}
		}
	}

	@Override
	public void loadData(CSVFile file) {
		file.readObject();
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

}
