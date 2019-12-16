package com.company;

public class MyQueue {
    int data[];
    int size = 2;
    int front = -1; //point to the first element
    int end = 0; //point to the next available
    int total = 0; //the total stored elements

    MyQueue()
    {
        data = new int[size];
    }

    MyQueue(int s)
    {
        size = s;
        data = new int[size];
    }

    public void enqueue(int num)
    {

        if(end != front)
        {
            //it is not full
            data[end] = num;

            //update the associated variables
            total++;
            end++;

            //if the queue has only one number
            if(front == -1)
                front = 0;

            if(end == size)
            {
                end = 0;
            }

        }
        else { //if it is full
            size *= 2;
            int new_data[] = new int[size];

            int idx = 0;
            for(int i = front; i < size/2; i++) //copy the part from front to size-1
            {
                new_data[idx] = data[i];
                idx++;
            }
            for(int i = 0; i < end; i++) //copy the part from 0 to end
            {
                new_data[idx] = data[i];
                idx++;
            }

            data = new_data;

            //insert the new data into the end
            data[size/2] = num;
            total++;
            front = 0;
            end = size/2 + 1;



        }
    }

    //remove one element
    void dequeue()
    {
        //if the queue is empty
        if(front == -1 || front == end)
            return;
        else
        {
            if(front == size - 1)
                front = 0;
            else
                front++;

            total--;

            //if the size is less than half, reduce the queue to half:
            if(total < size/2)
            {

                int new_data[] = new int[size / 2];

                int idx = 0;

                if(end >= front)
                {
                    for(int i = front; i < end; i++)
                    {
                        new_data[idx] = data[i];
                        idx++;
                    }
                }
                else
                {
                    for(int i = front; i < size; i++)
                    {
                        new_data[idx] = data[i];
                        idx++;
                    }
                    for(int i = 0; i < end; i++)
                    {
                        new_data[idx] = data[i];
                        idx++;
                    }
                }


            }


        }

    }

    //print out all the data
    void display()
    {
        System.out.println("The queue size: " + size + ", total: " + total
                + ", front: " + front + ", end: " + end);
        System.out.println("The queue is: ");

        if(front < end)
        {
            for(int i = front; i < end; i++)
            {
                System.out.println(data[i]);
            }
        }
        else
        {
            //from front to size
            for(int i = front; i < size; i++)
            {
                System.out.println(data[i]);
            }
            for(int i = 0; i < end; i++)
            {
                System.out.println(data[i]);
            }


        }
    }



    public static void main(String[] args)
    {
        MyQueue q = new MyQueue(4);

        q.enqueue(5);
        q.enqueue(2);
        q.dequeue();

        q.enqueue(100);
        q.dequeue();
        q.enqueue(10);

        q.display();

        q.enqueue(3);

        q.display();


    }



}