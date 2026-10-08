package mk.nds.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Klasse DynArray zur Umsetzung des ADT Dynamische Reihung entsprechend der
 * Vorgaben des KC Informatik für die gymnasiale Oberstufe in Niedersachsen und
 * den ergänzenden Hinweisen (Stand: Juni 2025)
 *
 * @author Carsten Rohe (erstellt für das Landesnetzwerk Informatik Niedersachsen)
 * @version 2025.09.22
 */
public class DynArray implements Iterable<Object> {
	private int length;
	private Element head;

	/**
	 * Eine leere dynamische Reihung wird angelegt.
	 */
	public DynArray() {
		length = 0;
		head = null;
	}

	/**
	 * Es wird geprüft, ob die dynamische Reihung leer ist.
	 *
	 * @return Wenn die dynamische Reihung kein Element enthält, wird der Wert true zurückgegeben, sonst der Wert false.
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Der Inhalt des Elements an der Position index wird ausgelesen. Das Element
	 * wird dabei nicht aus der dynamischen Reihung entfernt.
	 *
	 * @param index Die Position des auszulesenden Elements.
	 * @return Der Inhalt des Elements an der Position index.
	 * @throws IndexOutOfBoundsException Wird ausgelöst, wenn der Index außerhalb des gültigen Bereichs liegt.
	 */
	public Object getItem(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index " + index + " ist außerhalb des gültigen Bereichs.");
		}
		Element current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Ein neues Element mit dem übergebenen Inhalt wird am Ende an die dynamische
	 * Reihung angefügt.
	 *
	 * @param data Der Inhalt für das neue Element.
	 * @throws IllegalArgumentException Wird ausgelöst, wenn das übergebene Element 'null' ist.
	 */
	public void append(Object data) {
		if (data == null) {
			throw new IllegalArgumentException("Das Element darf nicht 'null' sein.");
		}
		if (!isEmpty()) {
			getElement(length - 1).next = new Element(data);
		} else {
			head = new Element(data);
		}
		length++;
	}

	/**
	 * Ein neues Element mit dem übergebenen Inhalt wird der Position index in die
	 * dynamische Reihung eingefügt. Das Element, das sich vorher an dieser befunden
	 * hat, und alle nachfolgenden Elemente werden nach hinten verschoben.
	 * Entspricht der Wert von index der Länge der dynamischen Reihung, so wird ein
	 * neues Element am Ende der dynamischen Reihung angefügt.
	 *
	 * @param index Die Position für das neue Element.
	 * @param data  Der Inhalt für das neue Element.
	 * @throws IndexOutOfBoundsException Wird ausgelöst, wenn index außerhalb des gültigen Bereichs liegt.
	 */
	public void insertAt(int index, Object data) {
		if (index < 0 || index > length) {
			throw new IndexOutOfBoundsException("Index " + index + " ist außerhalb des gültigen Bereichs.");
		}
		if (data == null) {
			throw new IllegalArgumentException("Das Element darf nicht 'null' sein.");
		}
		if (index < length && index > 0) { // Es wird mittig eingefügt.
			Element n = new Element(data);
			Element temp = getElement(index);
			getElement(index - 1).next = n;
			n.next = temp;
			length++;
		} else if (index == 0 && !isEmpty()) { // Es wird vorne eingefügt.
			Element temp = head;
			head = new Element(data);
			head.next = temp;
			length++;
		} else if (index == length) { // Es wird am Ende hinzugefügt.
			append(data);
		}
	}

	/**
	 * Der Inhalt des Elements an der Position index wird durch den übergebenen
	 * Inhalt ersetzt.
	 *
	 * @param index Die Position für das Ersetzen.
	 * @param data  Der neue Inhalt.
	 * @throws IndexOutOfBoundsException Wird ausgelöst, wenn index außerhalb des gültigen Bereichs liegt.
	 */
	public void setItem(int index, Object data) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index " + index + " ist außerhalb des gültigen Bereichs.");
		}
		if (data == null) {
			throw new IllegalArgumentException("Das Element darf nicht 'null' sein.");
		}
		getElement(index).data = data;
	}

	/**
	 * Das Element an der Position index wird gelöscht. Alle folgenden Elemente
	 * werden um eine Position nach vorne geschoben.
	 *
	 * @param index Die Position des zu löschenden Elements.
	 * @throws IndexOutOfBoundsException Wird ausgelöst, wenn index außerhalb des gültigen Bereichs liegt.
	 */
	public void delete(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index " + index + " ist außerhalb des gültigen Bereichs.");
		}
		if (index == 0 && length > 0) { // Es wird das erste Element gelöscht.
			head = head.next;
			length--;
		} else if (index > 0 && index < length) { // Es wird nicht vorne gelöscht.
			getElement(index - 1).next = getElement(index - 1).next.next;
			length--;
		}
	}

	/**
	 * Die Anzahl der Elemente der dynamischen Reihung wird zurückgegeben.
	 *
	 * @return Anzahl der enthaltenen Elemente
	 */
	public int getLength() {
		return length;
	}

	private Element getElement(int index) {
		// Interne Hilfsoperation zum vereinfachten Zugriff auf die Elemente der
		// dynamischen Reihung.
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index " + index + " ist außerhalb des gültigen Bereichs.");
		}
		Element current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	@Override
	public Iterator<Object> iterator() {
		return new DynArrayIterator();
	}

	private class DynArrayIterator implements Iterator<Object> {
		private Element current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Object data = current.data;
			current = current.next;
			return data;
		}
	}

	// Klasse Element zur internen Verwaltung der einzelnen Elemente der dynamischen
	// Reihung
	private static class Element {
		/**
		 * Der im Element gespeicherte Inhalt.
		 */
		private Object data;
		/**
		 * Das nächste Element der Reihung.
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
} // Ende der Klasse DynArray
