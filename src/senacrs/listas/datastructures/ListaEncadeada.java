package senacrs.listas.datastructures;

public class ListaEncadeada<T> implements java.lang.Iterable<T> {

	private Node<T> head;
	private Node<T> tail;

	public IteradorListaEncadeada<T> iterator() {
		return new IteradorListaEncadeada<T>(this);
	}

	Node<T> getHead() {
		return head;
	}

	public void append(T dado) {
		Node<T> novo = new Node<T>(dado);
		if (tail == null) {
			head = novo;
		} else {
			novo.setPrevious(tail);
			tail.setNext(novo);
		}
		tail = novo;
	}

	public void prepend(T dado) {
		Node<T> novo = new Node<T>(dado);
		if (head == null) {
			tail = novo;
		} else {
			novo.setNext(head);
			head.setPrevious(novo);
		}
		head = novo;
	}

	void remove(Node<T> iter) {
		if (iter == null) return;
		if (iter == tail) {
			tail = tail.getPrevious();
			tail.setNext(null);
		} else if (iter == head) {
			head = head.getNext();
			head.setPrevious(null);
		} else {
			Node<T> previous = iter.getPrevious();
			Node<T> next = iter.getNext();
			next.setPrevious(previous);
			previous.setNext(next);
		}
	}

	public Object get(int index) {
		if (index <= 0) return null;
		Node<T> node = null;
		if (head != null) {
			node = getHead();
			for (int i = 0; i < index; i++) {
				if (node.getNext() == null) return null;
				node = node.getNext();
			}
			return node.getData();
		}
		return node;
	}

	public void insertionSort() {
		Node<T> current = head;
		while (current != null) {
			for (Node<T> prev = current; prev.getPrevious() != null; prev = (prev.getPrevious() != null ? prev.getPrevious() : prev)) {
				if (prev.compareTo(prev.getPrevious().getData()) < 0) {
					if (prev == current) current = prev.getPrevious();
					swap(prev, prev.getPrevious());
				}
			}
			current = current.getNext();
		}
	}

	public void swap(Node<T> nd1, Node<T> nd2) {
		if (nd1 == null || nd2 == null) return;
		if (nd1 == nd2) return;

		if (nd1.getPrevious() == nd2) {
			Node<T> temp = nd2;
			nd2 = nd1;
			nd1 = temp;
		}

		Node<T> nd1Prev = nd1.getPrevious();
		Node<T> nd1Next = nd1.getNext();
		Node<T> nd2Prev = nd2.getPrevious();
		Node<T> nd2Next = nd2.getNext();

		nd1.setNext(nd2Next);
		if (nd2Next != null) nd2Next.setPrevious(nd1);

		nd2.setPrevious(nd1Prev);
		if (nd1Prev != null) nd1Prev.setNext(nd2);

		if (nd1 == nd2Prev) {
			nd1.setPrevious(nd2);
			nd2.setNext(nd1);
		} else {
			nd1.setPrevious(nd2Prev);
			if (nd2Prev != null) nd2Prev.setNext(nd1);

			nd2.setNext(nd1Next);
			if (nd1Next != null) nd1Next.setPrevious(nd2);
		}

		if (nd1 == head) head = (Node<T>) nd2;
		else if (nd2 == head) head = (Node<T>) nd1;
	}
}