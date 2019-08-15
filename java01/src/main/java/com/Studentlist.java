package com;
import vo.Student;

import java.util.Iterator;

public class Studentlist implements Iterable<Student>{
    Student[] stu=new Student[10];
    int index=0;

    public void add(Student stu){
        if(index>this.stu.length){
            throw new IndexOutOfBoundsException ("下标越界");
        }
        this.stu[index++]=stu;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements Iterator<Student>{

        private int innerIndex=0;
        @Override
        public boolean hasNext() {
            return index>0 && innerIndex<index;
        }

        @Override
        public Student next() {
            return stu[innerIndex++];
        }
    }
}
