package utils;

import model.Medicamento;
import model.Paciente;

public class Constants {
	public static final int VECTOR = 1;
	public static final int LIST = 2;

	public static final int FIND_PACIENTES_BY_RG = 1;
	public static final int FIND_PACIENTES_BY_NOME = 2;
	public static final int FIND_MEDICAMENTOS_BY_CODIGO = 3;
	public static final int FIND_MEDICAMENTOS_BY_NOME = 4;

	public static final int SYSTEM_EXIT = 9;

	public static final String PACIENTES_CSV = "pacientes.csv";
	public static final String MEDICAMENTOS_CSV = "medicamentos.csv";

	public static final Paciente PACIENTE_TYPE = new Paciente();
	public static final Medicamento MEDICAMENTO_TYPE = new Medicamento();
	
}
