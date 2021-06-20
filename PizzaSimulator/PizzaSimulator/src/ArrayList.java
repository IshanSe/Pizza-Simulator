
public class ArrayList<TBA extends Comparable> {
	// instance vars
	private Object[] arrayList = new Object[1000]; // arrayList to hold all objects
	private int numElements = 0; // numElements to store number of elements in array

	public Object[] resize(int index) {
		Object[] temp = new Object[index];
		// create a temporary array with new size that's larger than previous
		for (int i = 0; i < arrayList.length; i++) { // goes for the length of data
			temp[i] = arrayList[i];
			// copy over elements
		}
		return temp;
		// return the object array
	}

	public int compareTo(Object o) {
		// null check and instanceof check
		// if fail, throw exception & break
		if (o == null || !(o instanceof ArrayList)) {
			throw new RuntimeException("BAD params ):");
		}
		// if true, cast input param to ArrayList type
		ArrayList that = (ArrayList) o;

		// compareto checking equivalence
		if (this.numElements == that.numElements) {
			return 0;

		} else if (that.numElements < this.numElements) {
			return 1;

		} else {
			return -1;
		}
	}

	public void insert(TBA in, int spot) {
		TBA inputValue = in;
		// store the input TBA ("object") as a variable

		// null check and if negative index
		if (in == null || spot < 0) {
			throw new PizzaException("Bad params");
		}
		// if the highest spot is out of bounds, RESIZE the array!!!
		if (spot >= arrayList.length) {
			arrayList = resize(spot + 1);
		}

		if (arrayList[spot] == null) {
			arrayList[spot] = inputValue;

		} else {
			if (numElements + 1 >= arrayList.length) {
				arrayList = resize(arrayList.length + 1);
			}
			shiftRight(spot); // shifting right at the param index
			arrayList[spot] = inputValue;
			numElements++; // updates the highest point
		}

		if (spot > numElements) {
			numElements = spot;
		}
		// if param is larger, change numElements to the new highest spot

	}

	public TBA remove(int index) {
		if (arrayList[index] == null || index < 0) { // null check for objectat index and if negative index
			throw new PizzaException("bad params");
		}

		TBA retVal = (TBA) arrayList[index]; // cast the input to a TBA type

		shiftLeft(index);
		// shift left at index
		arrayList[numElements] = null;
		// sets last spot in list to null
		numElements--;
		// subtract one from number of elements
		return retVal;
	}

	private void shiftLeft(int start) {
		// iterate over array
		for (int first = start; first < numElements; first++) {
			arrayList[first] = (TBA) arrayList[first + 1];
			// shift left

		}
	}

	private void shiftRight(int start) {
		// iterate over array
		for (int last = numElements; last >= start; last--) {
			arrayList[last + 1] = arrayList[last];
			// shift right
		}
	}

	public int size() {
		int count = 0;
		// iterate over array
		for (int i = 0; i <= numElements; i++) {
			// if it's not null
			if (arrayList[i] != null) {
				// add a counter
				count++;
			}
		}
		return count; // return size
	}

	public String toString() {
		String retVal = "";
		// declare a return value String type

		for (int i = 0; i < arrayList.length; i++) {
			// iterate over array
			if ((TBA) arrayList[i] == null) {
				// null check
				continue;
			} else {
				retVal += (TBA) arrayList[i] + "\n ";
				// if not null add this to return value
			}
		}
		return retVal; // return string
	}

	public boolean isEmpty() {
		for (int first = 0; first < numElements; first++)
			// iterate over aray

			if ((TBA) arrayList[first] != null) {
				// check null
				return false;
			}
		return true; // else case
	}

	public void swap(int idx1, int idx2) {
		TBA temp = (TBA) arrayList[idx1];
		// sets a temp variable to first object

		arrayList[idx1] = arrayList[idx2];
		// swap
		arrayList[idx2] = temp;
	}

	public boolean equals(Object o) {

		if ((TBA) o != null && (TBA) o instanceof ArrayList == true) {
			ArrayList newAL = (ArrayList) (TBA) o;
			if (this.size() == (newAL.size())) {
				for (int i = 0; i <= size(); i++) {
					// iterate over array
					if ((TBA) this.arrayList[i] != (TBA) newAL.arrayList[i]) {
						return false;
					}
					return true;
				}
			}
		}
		return false;
	}

	public int indexOf(Object value) {
		// null check
		if ((TBA) value == null) {
			throw new PizzaException();
		}
		// iterate over the array
		for (int i = 0; i < numElements; i++) {

			if (arrayList[i].equals(value)) {

				return i;
			}
		}
		return -1;
		// else case
	}

	public Object objectAt(int index) {
		if (index > numElements) { // if index is more than number of the elements, error
			throw new IllegalArgumentException();
		}
		// return the object at index if in bounds
		return arrayList[index];
	}
}