package senacrs.listas.examples;

import model.Paciente;
import senacrs.listas.datastructures.Iterador;
import senacrs.listas.datastructures.ListaEncadeada;

public class ExemploListaEncadeada {

	public static void main(String[] args) {
		ListaEncadeada<Paciente> lista = new ListaEncadeada<>();
		
		Paciente p1 = new Paciente("Ivonei","1102317334","03/05/1990");
		Paciente p2 = new Paciente("Arianne","1202317334","03/05/1990");
		Paciente p3 = new Paciente("Ana","1302317334","03/05/1990");
		Paciente p4 = new Paciente("Camila","1402317334","03/05/1990");
		
		lista.append(p1);
		lista.prepend(p2);	
		imprimeLista(lista);
		Iterador<Paciente> iterador = lista.iterator();
		iterador.next();
		iterador.insert(p3);
		imprimeLista(lista);
		iterador.next();
		iterador.insert(p4);
		imprimeLista(lista);
		iterador.previous();
		iterador.remove();
		imprimeLista(lista);
	}

	private static <T> void imprimeLista(ListaEncadeada<T> lista) {
		for (T dado : lista)
			System.out.println(dado);
		System.out.println("\n");
	}

}
