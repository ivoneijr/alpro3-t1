package senacrs.listas.datastructures;

import model.Paciente;

public class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> previous;

	/**
	 * Inicializa um novo no com um dado fornecido.
	 * 
	 * @param data
	 *            O dado a ser armazenado no novo no.
	 */
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	/**
	 * Retorna o objeto atualmente armazenado no no'.
	 * 
	 * @return O objeto armazenado.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Retorna o proximo no apontado por esse no, ou null caso nao exista um no
	 * posterior.
	 * 
	 * @return O proximo no, ou null.
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Retorna o no anterior ao no atual, ou null caso nao exista.
	 * 
	 * @return O no anterior, ou null.
	 */
	public Node<T> getPrevious() {
		return previous;
	}

	/**
	 * Define o no que sera o no anterior a esse no.
	 * 
	 * @param prev
	 *            O no que sera o no anterior.
	 */
	public void setPrevious(Node<T> prev) {
		this.previous = prev;
	}

	/**
	 * Define o no que sera o proximo no a esse no.
	 * 
	 * @param next
	 *            O proximo no.
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * Insere um elemento antes do atual. Este metodo so deve ser utilizado
	 * quando o no nao for o inicial ou final da lista.
	 * 
	 * @param dado
	 *            O dado a ser inserido na lista.
	 */
	public void insertBefore(T dado) {
		Node<T> novo = new Node<T>(dado);
		Node<T> previous = this.getPrevious();
		novo.setPrevious(previous);
		novo.setNext(this);
		this.setPrevious(novo);
		previous.setNext(novo);
	}
	
	public int compareTo(T object) {
	  if (object instanceof Paciente) {
	   Paciente p1 = (Paciente) object;
	   Paciente p2 = (Paciente) this.data;
	   if (Integer.parseInt(p1.getRg()) >= Integer.parseInt(p2.getRg())) return -1;   
	  }
	  return 0;
	 }

}