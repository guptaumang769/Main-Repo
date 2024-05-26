//Basic Arrays Functions

#include<iostream>
using namespace std;

struct Array {
    int A[10];
    int size;
    int length;
};

void display(struct Array arr) {
    for(int i=0; i<arr.length; i++) {
        cout<<arr.A[i]<<" ";
    }
    cout<<endl;
}

// Write more functions for swap, get, set, max, min, sum, avg
void swap(int *x, int *y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}

int get(struct Array arr, int index) {
    if(index>=0 && index<arr.length) {
        return arr.A[index];
    }   
    else {
        return -1;
    }
}

void set(struct Array *arr, int index, int x) {
    if(index>=0 && index<arr->length) {
        arr->A[index] = x;
    }
}

int max(struct Array arr) {
    int max = arr.A[0];
    for(int i=0; i<arr.length; i++) {
        if(arr.A[i]>max) {
            max = arr.A[i];
        }
    }
    return max;
}

int min(struct Array arr) {
    int min = arr.A[0];
    for(int i=0; i<arr.length; i++) {
        if(arr.A[i]<min) {
            min = arr.A[i];
        }
    }
    return min;
}

int sum(struct Array arr) {
    int s = 0;
    for(int i=0; i<arr.length; i++) {
        s = s + arr.A[i];
    }
    return s;
}

float avg(struct Array arr) {
    return (float)sum(arr)/arr.length;
}

int main() {
    struct Array arr = {{1,2,3,4,5}, 5, 5};
    cout<<"The given array is: ";
    display(arr);
    cout<<"The element at given index is: "<<get(arr, 2)<<endl;
    set(&arr, 1, 100);
    cout<<"The array after set operation is: ";
    display(arr);
    cout<<"Max value: "<<max(arr)<<endl;
    cout<<"Min value: "<<min(arr)<<endl;
    cout<<"Sum of all values: "<<sum(arr)<<endl;
    cout<<"Avg of all value: "<<avg(arr)<<endl;

    return 0;
}