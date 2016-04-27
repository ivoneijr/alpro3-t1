package main;

/**
 * @author 631310131 - Ivonei Marques Junior
 */
import static utils.Constants.FIND_MEDICAMENTOS_BY_CODIGO;
import static utils.Constants.FIND_MEDICAMENTOS_BY_NOME;
import static utils.Constants.FIND_PACIENTES_BY_NOME;
import static utils.Constants.FIND_PACIENTES_BY_RG;
import static utils.Constants.LIST;
import static utils.Constants.MEDICAMENTOS_CSV;
import static utils.Constants.MEDICAMENTO_TYPE;
import static utils.Constants.PACIENTES_CSV;
import static utils.Constants.PACIENTE_TYPE;
import static utils.Constants.SYSTEM_EXIT;
import static utils.Constants.VECTOR;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Medicamento;
import model.Paciente;
import parsers.MedicamentoParser;
import parsers.PacienteParser;
import utils.Utils;
import csv.CSVFile;
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
	
	static PacienteDAOVector vectorPaciente = new PacienteDAOVector(9826);
	static MedicamentoDAOVector vectorMedicamento = new MedicamentoDAOVector(9871);
	
	static PacienteDAOLista listPaciente = new PacienteDAOLista();
	static MedicamentoDAOLista listMedicamento = new MedicamentoDAOLista();
	
	static boolean sortByVector = false;

	public static void main(String[] args) {
		try {
		
			initFiles();

//			SELECT SORT METHOD
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
			
			int criteria = 999;
			while(criteria != SYSTEM_EXIT){
				Utils.printFindMenu();
				criteria = Integer.parseInt(input.nextLine());
			
				switch(criteria) {
					case FIND_PACIENTES_BY_RG:
						System.out.println("\n\n Digite um RG para pesquisar: ");
						findById(input.nextLine(),PACIENTE_TYPE);
					break;

					case FIND_MEDICAMENTOS_BY_CODIGO:
						System.out.println("\n\n Digite um Codigo de medicamento para pesquisar: ");
						findById(input.nextLine(),MEDICAMENTO_TYPE);
					break;

					case FIND_PACIENTES_BY_NOME:
						System.out.println("\n\n Digite um nome para pesquisar: ");
						findByNome(input.nextLine(), PACIENTE_TYPE);
					break;
						
					case FIND_MEDICAMENTOS_BY_NOME:
						System.out.println("\n\n Digite um nome para pesquisar: ");
						findByNome(input.nextLine(), MEDICAMENTO_TYPE);
					break;
				}
			}
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			closeFiles();
		} catch (Exception e) {
			e.printStackTrace();
			closeFiles();
		}
	}

	private static void findById(String nextLine, Object obj) {
		if(obj instanceof Paciente){
			String rg = nextLine;
			Paciente pacienteByRG = sortByVector? vectorPaciente.getPacienteByRG(rg) : listPaciente.getPacienteByRG(rg);
			System.out.println("\n Encontrado " + pacienteByRG);
		
		}else if(obj instanceof Medicamento){
			Long codigo = Long.parseLong(nextLine);
			Medicamento medicamentoByCodigo = sortByVector? vectorMedicamento.getMedicamento(codigo) : listMedicamento.getMedicamento(codigo); 
			System.out.println("\n Encontrado " + medicamentoByCodigo);
		}
	}

	private static void findByNome(String nome, Object obj) {
		
		if(obj instanceof Paciente){
			List<Paciente> pacientes;
			pacientes = sortByVector? vectorPaciente.getPacienteByNome(nome) :  listPaciente.getPacienteByNome(nome); 
			
			for (Paciente paciente : pacientes) {
				System.out.println("\n Encontrado " + paciente);
			}
			
		}else if(obj instanceof Medicamento){
			List<Medicamento> medicamentos;
			medicamentos = sortByVector? vectorMedicamento.getMedicamentoByNome(nome) :  listMedicamento.getMedicamentoByNome(nome); 
			
			for (Medicamento medicamento : medicamentos) {
				System.out.println("\n Encontrado " + medicamento);
			}
		}
		
	}

	private static void print(int list) {
		System.out.println("\n\n");
		
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