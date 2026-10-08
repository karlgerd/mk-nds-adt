package mk.nds.adt;

/**
 * Klasse BinTree zur Umsetzung des ADT Binärbaum entsprechend der Vorgaben des
 * KC Informatik für die gymnasiale Oberstufe in Niedersachsen und den
 * ergänzenden Hinweisen (Stand: Juni 2025)
 *
 * @author Carsten Rohe (erstellt für das Landesnetzwerk Informatik Niedersachsen)
 * @version 2025.09.22
 */
public class BinTree {
	private Object item;
	private BinTree left;
	private BinTree right;

	/**
	 * Ein leerer Baum wird erzeugt. Er besitzt keinen Inhalt und keine Teilbäume.
	 */
	public BinTree() {
		this.item = null;
		this.left = null;
		this.right = null;
	}

	/**
	 * Ein Baum wird erzeugt. Die Wurzel erhält den übergebenen Inhalt als Wert. Der
	 * Baum besitzt jeweils einen leeren Baum als linken und rechten Teilbaum.
	 *
	 * @param inhalt Der Inhalt für die Wurzel des neuen Baums.
	 * @throws IllegalArgumentException Wird ausgelöst, wenn der übergebene Inhalt 'null' ist.
	 */
	public BinTree(Object inhalt) {
		if (inhalt == null) {
			throw new IllegalArgumentException(
					"Der Baum kann nicht erzeugt werden. Der übergebene Inhalt darf nicht 'null' sein.");
		}
		this.item = inhalt;
		this.left = new BinTree();
		this.right = new BinTree();
	}

	/**
	 * Prüft, ob der Baum leer ist.
	 *
	 * @return Wenn der Baum ein leerer Baum ist, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
	 */
	public boolean isEmpty() {
		return item == null && left == null && right == null;
	}

	/**
	 * Gibt den Inhaltswert der Wurzel zurück.
	 *
	 * @return Der Inhaltswert der Wurzel.
	 * @throws IllegalStateException Wird ausgelöst, wenn der Baum leer ist.
	 */
	public Object getItem() {
		if (isEmpty()) {
			throw new IllegalStateException("Der Baum ist leer. Es kann kein Inhalt ausgelesen werden.");
		}
		return item;
	}

	/**
	 * Die Wurzel des Baums erhält den übergebenen Inhalt als Wert. Bei einem leeren
	 * Baum wird zusätzlich als linker und rechter Teilbaum jeweils ein leerer Baum
	 * gesetzt.
	 *
	 * @param inhalt Der neue Inhaltswert für die Wurzel.
	 * @throws IllegalArgumentException Wird ausgelöst, wenn der übergebene Inhalt 'null' ist.
	 */
	public void setItem(Object inhalt) {
		if (inhalt == null) {
			throw new IllegalArgumentException(
					"Der Wert kann nicht gesetzt werden. Der übergebene Inhalt darf nicht 'null' sein.");
		}
		if (isEmpty()) {
			this.left = new BinTree();
			this.right = new BinTree();
		}
		this.item = inhalt;
	}

	/**
	 * Prüft, ob der Baum ein Blatt ist.
	 *
	 * @return Wenn der Baum jeweils einen leeren Baum als linken und rechten Teilbaum besitzt, also ein Blatt ist, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
	 * @throws IllegalStateException Wird ausgelöst, wenn der Baum leer ist.
	 */
	public boolean isLeaf() {
		if (isEmpty()) {
			throw new IllegalStateException("Der Baum ist leer. Überprüfung auf 'isLeaf' nicht möglich.");
		}
		return left.isEmpty() && right.isEmpty();
	}

	/**
	 * Gibt den linken Teilbaum zurück.
	 *
	 * @return Der linke Teilbaum.
	 * @throws IllegalStateException Wird ausgelöst, wenn der Baum leer ist.
	 */
	public BinTree getLeft() {
		if (isEmpty()) {
			throw new IllegalStateException("Der Baum ist leer. Es ist kein linker Teilbaum vorhanden.");
		}
		return left;
	}

	/**
	 * Setzt den linken Teilbaum.
	 *
	 * @param b Der Baum, der als linker Teilbaum gesetzt werden soll.
	 * @throws IllegalStateException    Wird ausgelöst, wenn der Baum leer ist.
	 * @throws IllegalArgumentException Wird ausgelöst, wenn der übergebene Wert 'null' ist.
	 */
	public void setLeft(BinTree b) {
		if (isEmpty()) {
			throw new IllegalStateException("Der Baum ist leer. Es kann kein linker Teilbaum gesetzt werden.");
		}
		if (b == null) {
			throw new IllegalArgumentException(
					"Der Wert kann nicht gesetzt werden. Der übergebene Baum darf nicht 'null' sein.");
		}
		this.left = b;
	}

	/**
	 * Gibt den rechten Teilbaum zurück.
	 *
	 * @return Der rechte Teilbaum.
	 * @throws IllegalStateException Wird ausgelöst, wenn der Baum leer ist.
	 */
	public BinTree getRight() {
		if (isEmpty()) {
			throw new IllegalStateException("Der Baum ist leer. Es ist kein rechter Teilbaum vorhanden.");
		}
		return right;
	}

	/**
	 * Setzt den rechten Teilbaum.
	 *
	 * @param b Der Baum, der als rechter Teilbaum gesetzt werden soll.
	 * @throws IllegalStateException    Wird ausgelöst, wenn der Baum leer ist.
	 * @throws IllegalArgumentException Wird ausgelöst, wenn der übergebene Wert 'null' ist.
	 */
	public void setRight(BinTree b) {
		if (isEmpty()) {
			throw new IllegalStateException("Der Baum ist leer. Es kann kein rechter Teilbaum gesetzt werden.");
		}
		if (b == null) {
			throw new IllegalArgumentException(
					"Der Wert kann nicht gesetzt werden. Der übergebene Baum darf nicht 'null' sein.");
		}
		this.right = b;
	}

	/**
	 * Der Baum wird zu einem leeren Baum, d.h. er besitzt keinen Inhalt und keine
	 * Teilbäume.
	 */
	public void setEmpty() {
		this.item = null;
		this.left = null;
		this.right = null;
	}
}
