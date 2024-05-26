#include<iostream>
using namespace std;

struct Array {
    int A[10];
    int size;
    int length;
};

void display(struct Array arr) {
    cout<<"The array elements are: ";
    for(int i=0; i<arr.length; i++) {
        cout<<arr.A[i]<<" ";
    }
}

void append(struct Array *arr, int x) {
    if(arr->length < arr->size) {
        arr->A[arr->length] = x;
        arr->length++;
    }
}

void insert(struct Array *arr, int index, int x) {
    if(index>=0 && index<arr->length) {
        for(int i=arr->length; i>index; i--) {
            arr->A[i] = arr->A[i-1];
        }
        arr->A[index] = x;
        arr->length++;
    }
}

int main() {
    struct Array arr1 = {{1,2,3,4,5}, 10, 5};
    cout<<"The initial array is: "<<endl;
    display(arr1);
    cout<<endl;

    append(&arr1, 100);
    cout<<"Array after appending 100: "<<endl;
    display(arr1);
    cout<<endl;
    
    insert(&arr1, 4, 200);
    cout<<"Array after inserting 200: "<<endl;
    display(arr1);
    cout<<endl;
    
    return 0;
}