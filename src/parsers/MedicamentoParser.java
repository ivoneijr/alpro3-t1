package parsers;

import utils.Utils;
import model.Medicamento;

public class MedicamentoParser implements CSVParser<Medicamento>{

	@Override
	public Medicamento parseObject(String line) {
		String[] split = line.split(";");
		Medicamento medicamento = new Medicamento(Utils.hexaToLongDecimal(split[0]),split[1]);
		return medicamento;
	}

}
