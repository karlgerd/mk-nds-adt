package mk.nds.adt;

/**
 * Klasse Stack zur Umsetzung des ADT Stapel entsprechend der Vorgaben des KC
 * Informatik für die gymnasiale Oberstufe in Niedersachsen und den ergänzenden
 * Hinweisen (Stand: Juni 2025)
 *
 * @author Landesnetzwerk Informatik Niedersachsen, Carsten Rohe
 * @version 2025.09.22
 */
public class Stack {
	private int length;
	private Element bottom;

	/**
	 * Ein leerer Stapel wird angelegt.
	 */
	public Stack() {
		length = 0;
		bottom = null;
	}

	/**
	 * Es wird geprüft, ob der Stapel leer ist.
	 *
	 * @return Wenn der Stapel kein Element enthält, wird der Wert true zurückgegeben, sonst der Wert false.
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Der Inhalt des obersten Elements des Stapels wird ausgelesen. Das Element
	 * wird dabei nicht aus dem Stapel entfernt.
	 *
	 * @return Der Inhalt des obersten Elements des Stapels.
	 * @throws IllegalStateException Wird ausgelöst, wenn der Stapel leer ist.
	 */
	public Object top() {
		if (isEmpty()) {
			throw new IllegalStateException("Der Stapel ist leer. Es kann kein Wert ausgelesen werden.");
		}
		return getElement(length - 1).data;
	}

	/**
	 * Ein neues Element mit dem übergebenen Inhalt wird auf dem Stapel abgelegt.
	 *
	 * @param data Der Inhalt für das neue Element.
	 * @throws IllegalArgumentException Wird ausgelöst, wenn der übergebene Inhalt 'null' ist.
	 */
	public void push(Object data) {
		if (data == null) {
			throw new IllegalArgumentException("Der übergebene Inhalt darf nicht 'null' sein.");
		}
		if (!isEmpty()) {
			getElement(length - 1).next = new Element(data);
		} else {
			bottom = new Element(data);
		}
		length++;
	}

	/**
	 * Das oberste Element des Stapels wird entnommen und dessen Inhalt
	 * zurückgegeben.
	 *
	 * @return Der Inhalt des entnommenen Elements.
	 * @throws IllegalStateException Wird ausgelöst, wenn der Stapel leer ist.
	 */
	public Object pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Der Stapel ist leer. Es kann kein Wert entnommen werden.");
		}
		Element temp = getElement(length - 1);
		if (length > 1) {
			getElement(length - 2).next = null;
		} else {
			bottom = null;
		}
		length--;
		return temp.data;
	}

	private Element getElement(int index) {
		// Interne Hilfsoperation zum vereinfachten Zugriff auf die Elemente des Stapels
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index " + index + " ist außerhalb des gültigen Bereichs.");
		}
		Element current = bottom;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	// Klasse Element zur internen Verwaltung der einzelnen Elemente des Stapels
	private static class Element {
		/**
		 * The Data.
		 */
		public Object data;
		/**
		 * The Next.
		 */
		public Element next;

		/**
		 * Instantiates a new Element.
		 *
		 * @param d the d
		 */
		public Element(Object d) {
			if (d == null) {
				throw new IllegalArgumentException("Das Element darf nicht 'null' sein.");
			}
			data = d;
			next = null;
		}
	} // Ende der Klasse Element
} // Ende der Klasse Stack
