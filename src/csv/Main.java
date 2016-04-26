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
import dao.java.implementation.medicamento.MedicamentoDAOLista;
import dao.java.implementation.medicamento.MedicamentoDAOVector;
import dao.java.implementation.paciente.PacienteDAOLista;
import dao.java.implementation.paciente.PacienteDAOVector;

public class Main {
	
	static Scanner input = new Scanner(System.in); 
	
	static int sortMethod = 0;
	static int findMethod = 0;

	static CSVFile pacientesFile = new CSVFile();
	static CSVFile medicamentosFile = new CSVFile();
	
	static PacienteDAOVector vectorPaciente = new PacienteDAOVector(9826);
	static MedicamentoDAOVector vectorMedicamento = new MedicamentoDAOVector(9871);
	
	static PacienteDAOLista listPaciente = new PacienteDAOLista();
	static MedicamentoDAOLista listMedicamento = new MedicamentoDAOLista();
	
	static boolean sortByVector = false;

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
					sortByVector = true;
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
					System.out.println("Digite um RG para pesquisar: ");
					String rg = input.nextLine();
					if(sortByVector){
						System.out.println("Encontrado Paciente: " + vectorPaciente.getPacienteByRG(rg));
					}else{
						System.out.println("Encontrado Paciente: " + listPaciente.getPacienteByRG(rg));
					}
				break;
				
				case Constants.FIND_PACIENTES_BY_NOME:
				break;
				
				case Constants.FIND_MEDICAMENTOS_BY_CODIGO:
					System.out.println("Digite um Codigo de medicamento para pesquisar: ");
					Long codigo = Long.parseLong(input.nextLine());
					if(sortByVector){
						System.out.println("Encontrado Medicamento: " + vectorMedicamento.getMedicamento(codigo));
					}else{
						System.out.println("Encontrado Medicamento: " + listMedicamento.getMedicamento(codigo));
					}
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
			for (int i = 0; i < vectorPaciente.getPacientes().length; i++) {
				System.out.println(vectorPaciente.getPacientes()[i].toString());
			}
			for (int i = 0; i < vectorMedicamento.getMedicamentos().length; i++) {
				System.out.println(vectorMedicamento.getMedicamentos()[i].toString());
			}
			break;
		
		case LIST:
			for (int i = 0; i < listPaciente.getPacientes().size(); i++) {
				System.out.println(listPaciente.getPacientes().get(i).toString());
			}
			for (int i = 0; i < listMedicamento.getMedicamentos().size(); i++) {
				System.out.println(listMedicamento.getMedicamentos().get(i).toString());
			}
			break;
		}		
	}

	private static void sort(int vector) {
		switch (sortMethod) {
		case VECTOR:
			Utils.doSelectionSort(vectorPaciente.getPacientes());
			Utils.doSelectionSortMedicamento(vectorMedicamento.getMedicamentos());
			break;
		
		case LIST:
			Utils.doInsertionSortPaciente(listPaciente.getPacientes());
			Utils.doInsertionSortMedicamento(listMedicamento.getMedicamentos());
			break;
		}	
	}

	private static void initLists() {
		for (int i = 0; i < 9826; i++) {
			listPaciente.addPaciente((Paciente) pacientesFile.readObject());
		}
		for (int i = 0; i < 9871; i++) {
			listMedicamento.addMedicamento((Medicamento) medicamentosFile.readObject());
		}
	}

	private static void initVectors() {
		for (int i = 0; i < vectorPaciente.getPacientes().length; i++) {
			vectorPaciente.addPaciente((Paciente) pacientesFile.readObject());
		}

		for (int i = 0; i < vectorMedicamento.getMedicamentos().length; i++) {
			vectorMedicamento.addMedicamento((Medicamento) medicamentosFile.readObject());
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