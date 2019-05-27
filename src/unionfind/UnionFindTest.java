package unionfind;

import java.util.ArrayList;
import java.util.List;

public class UnionFindTest {
	private static class UnionObject{
		@Override
		public String toString() {
			return "UnionObject [p=" + p + ", q=" + q + "]";
		}
		int p;
		int q;
		boolean result;
		public UnionObject(int p, int q){
			this.p = p;
			this.q = q;
		}
		public UnionObject(int p, int q, boolean result){
			this(p,q);
			this.result = result;
		}
	}
	
	List<UnionObject> listOneUnionTest = new ArrayList<UnionObject>();
	List<UnionObject> listTwoUnionTest = new ArrayList<UnionObject>();
	List<UnionObject> listConnectedTest = new ArrayList<UnionObject>();
	public UnionFindTest(){
		listOneUnionTest.add(new UnionObject(4, 3));
		listOneUnionTest.add(new UnionObject(3, 8));
		listOneUnionTest.add(new UnionObject(6, 5));
		listOneUnionTest.add(new UnionObject(9, 4));
		listTwoUnionTest.add(new UnionObject(2, 1));
		listTwoUnionTest.add(new UnionObject(5, 0));
		listTwoUnionTest.add(new UnionObject(7, 2));
		listTwoUnionTest.add(new UnionObject(6, 1));
		listTwoUnionTest.add(new UnionObject(7, 3));
		
		
		listConnectedTest.add(new UnionObject(8, 9, true));
		listConnectedTest.add(new UnionObject(5, 4, false));
	}
	
	public void test1(UF tester){
		for(UnionObject object : listOneUnionTest){
			if(!tester.connected(object.p, object.q)){
				tester.union(object.p, object.q);
				tester.display();
			}
		}
	}
	
	public void test(UF tester){
		for(UnionObject object : listTwoUnionTest){
			if(!tester.connected(object.p, object.q)){
				tester.union(object.p, object.q);
				tester.display();
			}
		}
	}
	
	public void testConnected(UF tester){
		for(UnionObject object : listConnectedTest){
			System.out.println(tester.connected(object.p, object.q)==object.result?object.toString() + " : Test Passed":object.toString()+" : Test Failed");
		}
	}
	
	
	public static void main(String[] args) {
		QuickFindUF qfUF = new QuickFindUF(10);
		QuickUnionUF quUF = new QuickUnionUF(10);
		QuickUnion qUF = new QuickUnion(10);
		UnionFindTest testCase = new UnionFindTest();
		testCase.test1(qfUF);
		testCase.testConnected(qfUF);
		testCase.test1(quUF);
		testCase.testConnected(quUF);
		testCase.test1(qUF);
		testCase.testConnected(qUF);
	}

}
