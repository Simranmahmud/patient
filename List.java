
public class List {

	private class ListNode {
	
	private Patient p;
	private ListNode next;
	
	public ListNode(Patient p, ListNode next) {
		this.p = p;
		this.next = next;
	}
	
	}	
private int size;
private ListNode head;
private ListNode tail;
private ListNode current;

public List() {
	head = null;
	tail = null;
	current = null;
	size = 0;
}
public boolean hasNext () {
	return current.next != null;
}
public void getNext() {
	current = current.next;
}
public void reset() {
	current = head;
}

public int size() {
	return size;
}

private ListNode get (String b) {
	while (hasNext() && !current.p.getPatientIdNum().equals(b) && current != tail) {
		getNext();
	}
	if (current.p.getPatientIdNum().equals(b)) {
		return current;
	}
	reset();
	return null;
}
public Patient getCurrent() {
	return current.p;	
}

public Patient find (String b) {
	return get(b).p;
}

public boolean contains(String b) {
	if (get(b) != null) 
		return true;
	return false;
}
public boolean add(Patient p) {
	if (size != 0 && contains(p.getPatientIdNum())) 
		return false;
	else if (head == null) {
		head = new ListNode (p, null);
		tail = head;
		current = head;
		size++;
		return true;
	}
	else {
		ListNode node = new ListNode (p, null);
		tail.next = node;
		if (size == 1) head.next = node;
		tail = node;
		size ++;
		return true;
	}
}
		public boolean remove(String b) {
			if (!contains (b))
				return false;
			ListNode node = head;
			if (get(b) == head) 
				head = head.next; 
			else if (get(b) == tail) {
				while (node != tail) 
					node = node.next;
				tail = node;
			}
			else {
			while (node != get(b))
				node = node.next;
		node.next = node.next.next; 
		node.next.next = null;
			}
		size --;
		return true;
		}
			
			
		public String toString() {
			reset();
			String result = "";
			while (current != tail) {
				result += current.p.getName() + ", " + current.p.getPatientIdNum() + "\n";
				getNext();
			}
			if (tail != null) result += tail.p.getName() + ", " + tail.p.getPatientIdNum();
			return result;
		}
}


