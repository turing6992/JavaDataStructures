package com.company;

public class MyStack {
    int[] data; //hold the actual data
    int total = 0; //the total number the stack is currently holding
    int size = 0; //the capacity of the stack



    //by default the array is initialized with size 2
    MyStack(){
        data = new int[2];
        size = 2;
    }

    //using the input size to allocate the array
    MyStack(int size)
    {
        data = new int[size];
        this.size = size;
    }


    //add "num" into the stack
    void push(int num)
    {
        //1. You need to find where to put num (the index of the end)
        //2. If the current stack is full, you need to allocate more space
        //   by double the current capacity

        //if the stack is not full
        if(total < size)
        {
            data[total] = num;
            total++;
        }
        else
        {
            int[] newData = new int[size * 2];

            //copy the current data from data[] into newData[]
            for(int i = 0; i < size; i++)
            {
                newData[i] = data[i];
            }
            data = newData;
            data[total] = num; //fill in num to the data[]
            size *= 2; //update the size to double of it
            total++; //increase the total

        }

    }


    int pop()
    {
        if(total == 0)
        {
            System.out.println("The stack is already empty");
            return 0;
        }
        else if(total < size/2)
        {
            int[] newData = new int[size / 2];

            //copy the current data from data[] into newData[]
            for(int i = 0; i < total; i++)
            {
                newData[i] = data[i];
            }
            data = newData;

            size /= 2; //update the size to half of it
            total--; //decrease the total
            return 0;
        }
        else
        {
            total--;
        }




        return 0;
    }


    //bubble sort to make the stack sorted
    void bubbleSort()
    {
        for(int j = total - 1; j > 1; j--)
        {
            for(int i = 0; i < j; i++)
            {
                if(data[i] > data[i+1])
                {
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                }
            }
            display();
        }
    }

    //print out the stack values so far
    void display()
    {
        System.out.println("current stack: ");
        for(int i = 0; i < total; i++)
        {
            System.out.println(data[i]);
        }
    }


    public static void main(String[] args)
    {
        MyStack stack = new MyStack();
        stack.push(15);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.display();
        stack.push(7);
        stack.push(1);
        stack.push(0);
        stack.push(12);
        stack.push(8);
        stack.display();
        System.out.println("size: " + stack.size);

        stack.bubbleSort();
        stack.display();

        System.out.println("total: " + stack.total);
    }
}