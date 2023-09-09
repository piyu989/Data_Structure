package HeapORPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StoringObject {
	
	static class Student implements Comparable<Student>{
		String name;
		int rank;
		public Student(String name,int rank) {
			this.name=name;
			this.rank=rank;
		}
		@Override
		public int compareTo(Student s) {
			return this.rank-s.rank;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Student>q=new PriorityQueue<>(Comparator.reverseOrder());
		Student s1=new Student("piyush",1);
		Student s22=new Student("rishab",22);
		Student s223=new Student("naman",23);
		Student s3=new Student("aman",34);
		Student s2=new Student("udit",2);
		q.add(s2);
		q.add(s3);
		q.add(s223);
		q.add(s22);
		q.add(s1);
		
		while(!q.isEmpty()) {
			System.out.println(q.peek().name+"->"+q.peek().rank);
			q.remove();
		}
	}

}
