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
    cout<<endl;
}

int BinarySearch(struct Array arr, int key) {
    int l, mid, h;
    l=0;
    h=arr.length-1;
    
    while(l<=h) {
        mid = (l+h)/2;
        if(key == arr.A[mid]) {
            return mid;
        }
        else if(key < arr.A[mid]) {
            h = mid-1;
        }
        else {
            l = mid+1;
        }
    }
    return -1;
}

int main() {
    struct Array arr = {{10,20,30,40,50}, 5, 5};
    cout<<"The index of the element is: "<<BinarySearch(arr, 20);
    return 0;
}