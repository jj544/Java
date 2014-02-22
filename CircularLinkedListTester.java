import static org.junit.Assert.*;

import org.junit.Test;


public class CircularLinkedListTester {

	@Test
	public void testConstructor() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();	
		assertEquals("[]", b.toString());	
		assertEquals("[]", b.toStringReverse());	
		assertEquals(0, b.size());
	} 
	
	@Test
	public void testAppend() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();	
		b.append(1);
		assertEquals("[1]", b.toString());	
		assertEquals("[1]", b.toStringReverse());	
		assertEquals(1, b.size());	
		b.append(2);
		assertEquals("[1,2]", b.toString());	
		assertEquals("[2,1]", b.toStringReverse());	
		assertEquals(2, b.size());
		b.append(22);
		assertEquals("[1,2,22]", b.toString());	
		assertEquals("[22,2,1]", b.toStringReverse());	
		assertEquals(3, b.size());
	}

	@Test
	public void testPrepend() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();	
		b.prepend(1);
		assertEquals("[1]", b.toString());	
		assertEquals("[1]", b.toStringReverse());	
		assertEquals(1, b.size());	
		b.prepend(2);
		assertEquals("[2,1]", b.toString());	
		assertEquals("[1,2]", b.toStringReverse());	
		assertEquals(2, b.size());
		b.prepend(22);
		assertEquals("[22,2,1]", b.toString());	
		assertEquals("[1,2,22]", b.toStringReverse());	
		assertEquals(3, b.size());
	}
	
	@Test
	public void testInsertBefore() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();	
		b.append(11);
		b.prepend(1);
		b.prepend(3);
		assertEquals("[3,1,11]", b.toString());	
		assertEquals("[11,1,3]", b.toStringReverse());	
		assertEquals(3, b.size());	
		CircularLinkedList<Integer>.Node a= b.getFirst();	
		b.insertBefore(2, a);
		assertEquals("[2,3,1,11]", b.toString());	
		assertEquals("[11,1,3,2]", b.toStringReverse());	
		assertEquals(4, b.size());
		b.insertBefore(5, a);
		assertEquals("[2,5,3,1,11]", b.toString());	
		assertEquals("[11,1,3,5,2]", b.toStringReverse());	
		assertEquals(5, b.size());
		CircularLinkedList<Integer>.Node c= b.getLast();
		b.insertBefore(4, c);
		assertEquals("[2,5,3,1,4,11]", b.toString());	
		assertEquals("[11,4,1,3,5,2]", b.toStringReverse());	
		assertEquals(6, b.size());
		
	}
	
	@Test
	public void testInsertAfter() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();	
		b.append(11);
		b.prepend(1);
		b.prepend(3);	
		CircularLinkedList<Integer>.Node a= b.getFirst();	
		b.insertAfter(2, a);
		assertEquals("[3,2,1,11]", b.toString());	
		assertEquals("[11,1,2,3]", b.toStringReverse());	
		assertEquals(4, b.size());
		CircularLinkedList<Integer>.Node c= b.getLast();
		b.insertAfter(5, c);
		assertEquals("[3,2,1,11,5]", b.toString());	
		assertEquals("[5,11,1,2,3]", b.toStringReverse());	
		assertEquals(5, b.size());
		b.insertAfter(4, c);
		assertEquals("[3,2,1,11,4,5]", b.toString());	
		assertEquals("[5,4,11,1,2,3]", b.toStringReverse());	
		assertEquals(6, b.size());
	}
	
	@Test
	public void testRemove() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();	
		b.append(11);
		b.prepend(1);
		b.prepend(3);	
		CircularLinkedList<Integer>.Node a= b.getFirst();	
		b.remove(a);
		assertEquals("[1,11]", b.toString());	
		assertEquals("[11,1]", b.toStringReverse());	
		assertEquals(2, b.size());
		CircularLinkedList<Integer>.Node c= b.getLast();
		b.append(4);
		b.remove(c);
		assertEquals("[1,4]", b.toString());	
		assertEquals("[4,1]", b.toStringReverse());	
		assertEquals(2, b.size());
		CircularLinkedList<Integer>.Node d= b.getLast();
		b.remove(d);
		assertEquals("[1]", b.toString());	
		assertEquals("[1]", b.toStringReverse());	
		assertEquals(1, b.size());
		CircularLinkedList<Integer>.Node e= b.getLast();
		b.remove(e);
		assertEquals("[]", b.toString());	
		assertEquals("[]", b.toStringReverse());	
		assertEquals(0, b.size());
	}
	
	
}
