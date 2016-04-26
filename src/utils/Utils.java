package utils;

import java.util.ArrayList;

import model.Medicamento;
import model.Paciente;

public class Utils {

	private final static String CPF_PATTERN = "00000000000";

	
	public static void printSortMethodMenu() {
		System.out.println("==== Selecione o método de armazenamento ===="); 
		System.out.println("=                                           ="); 
		System.out.println("=             1 - Vetor                     ="); 
		System.out.println("=             2 - Lista                     ="); 
		System.out.println("=                                           ="); 
		System.out.println("============================================="); 
	}
	
	public static void printFindMenu(){
		System.out.println("====   Selecione o critério de pesquisa   ===="); 
		System.out.println("=                                           ="); 
		System.out.println("=         1 - Paciente (por RG)             ="); 
//		System.out.println("=         2 - Paciente (por nome)           ="); 
		System.out.println("=         3 - Medicamento (por codigo)      ="); 
//		System.out.println("=         4 - Medicamento (por nome)        ="); 
		System.out.println("=                                           ="); 
		System.out.println("============================================="); 
	}
	
	public static String leftPaddingWithZeros(String s){
		return s.length() <= 10 ? CPF_PATTERN.substring(s.length()) + s : s;
	}
	
	public static Paciente[] doSelectionSort(Paciente[] arr) {
		for (int i = 0; i < arr.length - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j].getRg().compareTo(arr[minIndex].getRg()) < 0) {
					minIndex = j;
				}
			}
			Paciente temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}
	
	public static ArrayList<Paciente> doInsertionSortPaciente(ArrayList<Paciente> pacientes) {
	    int i,j;
	    for (i = 1; i < pacientes.size(); i++) {
	    	Paciente key = new Paciente(pacientes.get(i).getNome(),pacientes.get(i).getRg(),pacientes.get(i).getData());
	        j = i;
	        while((j>0) && (pacientes.get(j-1).getRg().compareTo(key.getRg()) > 0 )) {
	            pacientes.set(j,pacientes.get(j-1));
	            j--;
	        }
	        pacientes.set(j,key);
	    }
	    return pacientes;
	}
	public static Medicamento[] doSelectionSort(Medicamento[] arr) {
		for (int i = 0; i < arr.length - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j].getCodigo().compareTo(arr[minIndex].getCodigo()) < 0) {
					minIndex = j;
				}
			}
			Medicamento temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}
	
	public static ArrayList<Medicamento> doInsertionSortMedicamento(ArrayList<Medicamento> medicamentos) {
		int i,j;
		for (i = 1; i < medicamentos.size(); i++) {
			Medicamento key = new Medicamento(medicamentos.get(i).getCodigo(),medicamentos.get(i).getNome());
			j = i;
			while((j>0) && (medicamentos.get(j-1).getCodigo().compareTo(key.getCodigo()) > 0 )) {
				medicamentos.set(j,medicamentos.get(j-1));
				j--;
			}
			medicamentos.set(j,key);
		}
		return medicamentos;
	}
}
