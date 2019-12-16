package com.company;

class Data{
    int value;
    double size;

    Data(){}

    Data(int v, double s)
    {
        value = v;
        size = s;
    }


    //Store the address of the following Data
    Data next;
}

public class LinkedList {
    Data head; //head is just a pointer pointing to the start of the Data list

    void display()
    {
        Data p = head;
        while(p != null)
        {
            System.out.println("(" + p.value + ", " + p.size + ")");
            p = p.next;
        }
    }

    //Traverse the list to find any elment whose value is "v", if you find it, print out
    //the corresponding size value; if not find such element, just print out
    //a message that there is no such element
    void findbyValue(int v)
    {
        Data p = head;

        while(p != null)
        {
            if(p.value == v)
            {
                System.out.println("The value " + v + " is found, its size is "
                        + p.size);
                break;
            }
            p = p.next;
        }

        if(p == null)
        {
            System.out.println("No such element is found");
        }
    }

    //insert the new data in the right position
    void insert(Data data)
    {

    }

    //attach the data at the end
    void add(Data data)
    {
        if(head == null)
            head = data; //let the head pointer pointing to this data
        else {
            Data p = head;

            while(p.next != null)
            {
                p = p.next;
            }

            //after quit the loop, p is pointing to the last element
            p.next = data;
        }

    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        Data d1 = new Data(5, 30);
        list.add(d1);



        Data d2 = new Data(6, 32);
        list.add(d2);



        Data d3 = new Data(10, 1);
        list.add(d3);

        Data d4 = new Data(100, 200);
        list.add(d4);

        list.display();

        list.findbyValue(10);

        Data d5 = new Data(7, 100);
        list.insert(d5);
        list.display();

//		System.out.println("d2: " + d2.value);
//		d2.value = 27;
//		System.out.println("d2: " + d2.value);
//
//		Data d3 = d2;
//		d3.value = 35;
//		System.out.println("d2: " + d2.value);
//
//		Data d4 = d3;
//		d4.value = 100;
//		System.out.println("d2: " + d2.value);
//
    }
}