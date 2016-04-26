package senacrs.listas.implementation;

import java.util.Iterator;

import csv.CSVFile;
import model.Paciente;
import senacrs.listas.datastructures.ListaEncadeada;

public class PacienteDAOLista implements PacienteDAO {

	private ListaEncadeada<Paciente> pacientes;
	
	public PacienteDAOLista(){
		pacientes = new ListaEncadeada<Paciente>();
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
	public void addPaciente(Paciente paciente) {
		pacientes.append(paciente);
	}

	@Override
	public void removePaciente(String rg) {
		Iterator<Paciente> iterator = pacientes.iterator();
		while(iterator.hasNext()){
			Paciente paciente = iterator.next();
			if(paciente.getRg().equals(rg)){
				iterator.remove();
			}
		}
	}

	@Override
	public void loadData(CSVFile file) {
		file.readObject();
	}

	public ListaEncadeada<Paciente> getPacientes() {
		return pacientes;
	}

}
