package com.company;

class Element{
    int value; //store the numbers
    Element last = null; //a pointer pointing to its previous element
    Element next = null; //a pointer pointing to its next element

    Element(){
        value = 0;
    }

    Element(int v)
    {
        value = v;
    }
}

public class MyStackLinkedList {
    Element top = null; //a pointer pointing to the last element of the stack
    Element bottom = null; //a pointer pointing to the oldest element in the statck


    //Push e to the top of the stack
    void push(Element e)
    {
        if(top == null)
        {
            top = e;
            bottom = e;
        }
        else
        {
            top.last = e;
            e.next = top;
            top = e;
        }
    }


    //Remove the top element from the stack
    Element pop()
    {
        Element p = top;
        top = top.next;

        if(top != null)
            top.last = null;
        return p;
    }

    //check if the stack is empty
    boolean isEmpty()
    {
        if(top == null)
            return true;
        else
            return false;
    }

    void bubbleSort()
    {
        Element p = top;
        Element q = top;
        while(q.next != null) //counter to record how many iterations (n)
        {
            while(p.next != null) //For each iteration, it carries the largest element to the end
            {
                if(p.value > p.next.value)
                {
                    int temp = p.value;
                    p.value = p.next.value;
                    p.next.value = temp;
                }
                p = p.next;
            }
            p = top;
            q = q.next;

        }
    }

    //Search an element from the stack
    void search(Element e)
    {
        //if find this e in the stack, print out a message telling where it is by
        //giving a number how far it is away from the top


        //else: print out the element does not exist


        int steps = 0;
        Element p = top;

        while(p != null)
        {
            if(p.value == e.value)
            {
                System.out.println("The element is found at " + steps);
                return;
            }
            else
            {
                p = p.next;
                steps++;
            }
        }
        System.out.println("There is no such element.");

    }

    //print out all the element in the order from top to bottom
    void display1()
    {
        System.out.println("display1()");
        Element p = top;
        while(p != null)
        {
            System.out.println(p.value);
            p = p.next;
        }
    }

    //print out all the element in the order from bottom to top
    void display2()
    {
        System.out.println("display2()");
        Element p = bottom;
        while(p != null)
        {
            System.out.println(p.value);
            p = p.last;
        }
    }

    public static void main(String[] args)
    {
        Element e1 = new Element(15);
        Element e2 = new Element(2);
        Element e3 = new Element(4);
        Element e4 = new Element(3);
        Element e5 = new Element(1);
        Element e6 = new Element(8);
        Element e7 = new Element(0);
        Element e8 = new Element(17);

        MyStackLinkedList stack = new MyStackLinkedList();
        stack.push(e1);
        stack.push(e2);
        stack.push(e3);
        stack.push(e4);
        stack.push(e5);
        stack.push(e6);
        stack.push(e7);
        stack.push(e8);
        //stack.pop();
        //stack.pop();
        stack.display1();

        //stack.search(new Element(7));

        stack.bubbleSort();
        stack.display1();
    }


}