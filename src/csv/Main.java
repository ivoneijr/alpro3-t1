package csv;

import static contants.Constants.LIST;
import static contants.Constants.VECTOR;
import static contants.Constants.FIND_MEDICAMENTOS_BY_CODIGO;
import static contants.Constants.FIND_MEDICAMENTOS_BY_NOME;
import static contants.Constants.FIND_PACIENTES_BY_NOME;
import static contants.Constants.FIND_PACIENTES_BY_RG;
import static contants.Constants.MEDICAMENTOS_CSV;
import static contants.Constants.PACIENTES_CSV;

import java.util.NoSuchElementException;
import java.util.Scanner;

import contants.Constants;
import model.Medicamento;
import model.Paciente;
import parsers.MedicamentoParser;
import parsers.PacienteParser;
import utils.Utils;
import dao.medicamento.MedicamentoDAOLista;
import dao.medicamento.MedicamentoDAOVector;
import dao.paciente.PacienteDAOLista;
import dao.paciente.PacienteDAOVector;

public class Main {
	
	static Scanner input = new Scanner(System.in); 
	
	static int sortMethod = 0;
	static int findMethod = 0;

	static CSVFile pacientesFile = new CSVFile();
	static CSVFile medicamentosFile = new CSVFile();
	
	static PacienteDAOVector pacienteVector = new PacienteDAOVector(9826);
	static MedicamentoDAOVector medicamentoVector = new MedicamentoDAOVector(9826);
	
	static PacienteDAOLista pacienteList = new PacienteDAOLista();
	static MedicamentoDAOLista medicamentoList = new MedicamentoDAOLista();

	public static void main(String[] args) {
		try {
		
			initFiles();

//			SORT METHOD
			Utils.printSortMethodMenu();
			sortMethod = Integer.parseInt(input.nextLine());
			
			switch(sortMethod){
				case VECTOR:
					initVectors();
					sort(VECTOR);
					print(VECTOR);
				break;
				
				case LIST:
					initLists();
					sort(LIST);
					print(LIST);
				break;
			}		
			
//			FIND
			Utils.printFindMenu();
			int criteria = Integer.parseInt(input.nextLine());
			
			switch(criteria) {
				case Constants.FIND_PACIENTES_BY_RG:
				break;
				
				case Constants.FIND_PACIENTES_BY_NOME:
				break;
				
				case Constants.FIND_MEDICAMENTOS_BY_CODIGO:
				break;
				
				case Constants.FIND_MEDICAMENTOS_BY_NOME:
				break;
			}
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			closeFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void print(int list) {
		switch (sortMethod) {
		case VECTOR:
			for (int i = 0; i < pacienteVector.getPacientes().length; i++) {
				System.out.println(pacienteVector.getPacientes()[i].toString());
			}
			for (int i = 0; i < medicamentoVector.getMedicamentos().length; i++) {
				System.out.println(medicamentoVector.getMedicamentos()[i].toString());
			}
			break;
		
		case LIST:
			for (int i = 0; i < pacienteList.getPacientes().size(); i++) {
				System.out.println(pacienteList.getPacientes().get(i).toString());
			}
			for (int i = 0; i < medicamentoList.getMedicamentos().size(); i++) {
				System.out.println(medicamentoList.getMedicamentos().get(i).toString());
			}
			break;
		}		
	}

	private static void sort(int vector) {
		switch (sortMethod) {
		case VECTOR:
			Utils.doSelectionSort(pacienteVector.getPacientes());
			Utils.doSelectionSort(medicamentoVector.getMedicamentos());
			break;
		
		case LIST:
			Utils.doInsertionSortPaciente(pacienteList.getPacientes());
			Utils.doInsertionSortMedicamento(medicamentoList.getMedicamentos());
			break;
		}	
	}

	private static void initLists() {
		for (int i = 0; i < 9826; i++) {
			pacienteList.addPaciente((Paciente) pacientesFile.readObject());
		}
		for (int i = 0; i < 9871; i++) {
			medicamentoList.addMedicamento((Medicamento) medicamentosFile.readObject());
		}
	}

	private static void initVectors() {
		for (int i = 0; i < pacienteVector.getPacientes().length; i++) {
			pacienteVector.addPaciente((Paciente) pacientesFile.readObject());
		}

		for (int i = 0; i < medicamentoVector.getMedicamentos().length; i++) {
			medicamentoVector.addMedicamento((Medicamento) medicamentosFile.readObject());
		}
	}

	private static void initFiles() {
		pacientesFile.setParser(new PacienteParser());
		pacientesFile.open(PACIENTES_CSV);

		medicamentosFile.setParser(new MedicamentoParser());
		medicamentosFile.open(MEDICAMENTOS_CSV);
	}

	private static void closeFiles() {
		pacientesFile.close();
		medicamentosFile.close();
	}
}