package parsers;

import utils.Utils;
import model.Paciente;

public class PacienteParser implements CSVParser<Paciente>{

	@Override
	public Paciente parseObject(String line) {
		String[] split = line.split(";");
		Paciente paciente = new Paciente(split[0],Utils.leftPaddingWithZeros(split[1]),split[2]);
		return paciente;
	}

}
