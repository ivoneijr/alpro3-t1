package parsers;

public interface CSVParser<T> {

	T parseObject(String dados);
}
