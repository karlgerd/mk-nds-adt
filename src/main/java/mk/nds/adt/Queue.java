package mk.nds.adt;

/**
 * Klasse Queue zur Umsetzung des ADT Schlange entsprechend der Vorgaben des KC
 * Informatik für die gymnasiale Oberstufe in Niedersachsen und den ergänzenden
 * Hinweisen (Stand: Juni 2025)
 *
 * @author Landesnetzwerk Informatik Niedersachsen, Carsten Rohe
 * @version 2025.09.22
 */
public class Queue {
	private int length;
	private Element head;

	/**
	 * Eine leere Schlange wird angelegt.
	 */
	public Queue() {
		length = 0;
		head = null;
	}

	/**
	 * Es wird geprüft, ob die Schlange leer ist.
	 *
	 * @return Wenn die Schlange kein Element enthält, wird der Wert true zurückgegeben, sonst der Wert false.
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Der Inhalt des ersten Elements der Schlange wird ausgelesen. Das Element wird
	 * dabei aber nicht aus der Schlange entfernt.
	 *
	 * @return Der Inhalt des ersten Elements der Schlange.
	 * @throws IllegalStateException Wird ausgelöst, wenn die Schlange leer ist.
	 */
	public Object head() {
		if (isEmpty()) {
			throw new IllegalStateException("Die Schlange ist leer. Es kann kein Wert ausgelesen werden.");
		}
		return head.data;
	}

	/**
	 * Ein neues Element mit dem übergebenen Inhalt wird an die Schlange angehängt.
	 *
	 * @param data Der Inhalt für das neue Element.
	 * @throws IllegalArgumentException Wird ausgelöst, wenn der übergebene Inhalt 'null' ist.
	 */
	public void enqueue(Object data) {
		if (data == null) {
			throw new IllegalArgumentException("Der übergebene Inhalt darf nicht 'null' sein.");
		}
		if (!isEmpty()) {
			getElement(length - 1).next = new Element(data);
		} else {
			head = new Element(data);
		}
		length++;
	}

	/**
	 * Das erste Element der Schlange wird entnommen und dessen Inhalt
	 * zurückgegeben.
	 *
	 * @return Der Inhalt des entnommenen Elements.
	 * @throws IllegalStateException Wird ausgelöst, wenn die Schlange leer ist.
	 */
	public Object dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Die Schlange ist leer. Es kann kein Wert entnommen werden.");
		}
		Element temp = head;
		head = head.next;
		length--;
		return temp.data;
	}

	private Element getElement(int index) {
		// Interne Hilfsoperation zum vereinfachten Zugriff auf die Elemente der Reihung
		// durch die öffentlichen Operationen
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index " + index + " ist außerhalb des gültigen Bereichs.");
		}
		Element current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	// Klasse Element zur internen Verwaltung der einzelnen Elemente der Schlange
	private static class Element {
		/**
		 * Der im Element gespeicherte Inhalt.
		 */
		private Object data;
		/**
		 * Das nächste Element der Schlange.
		 */
		private Element next;

		/**
		 * Erzeugt ein Element mit dem angegebenen Inhalt.
		 *
		 * @param d der Inhalt des Elements
		 */
		private Element(Object d) {
			if (d == null) {
				throw new IllegalArgumentException("Das Element darf nicht 'null' sein.");
			}
			data = d;
			next = null;
		}
	} // Ende der Klasse Element
} // Ende der Klasse Queue
