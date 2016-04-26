package parsers;

import model.Medicamento;

public class MedicamentoParser implements CSVParser<Medicamento>{

	@Override
	public Medicamento parseObject(String line) {
		String[] split = line.split(";");
		Medicamento paciente = new Medicamento(Long.parseLong(split[0],16),split[1]);
		return paciente;
	}

}
