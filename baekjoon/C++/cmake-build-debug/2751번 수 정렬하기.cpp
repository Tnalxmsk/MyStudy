#include <iostream>

using namespace std;
int main() {
    int size;
    int temp;
    cin >> size;
    int* a = new int[size];

    for (int i = 0; i < size; i ++) {
        cin >> a[i];
    }

    for (int i = 0; i < size; i ++) {
        for (int j = 0; j < size; j++) {
            if (a[i] < a[j]) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }

    for (int i = 0; i < size; i ++) {
        cout << a[i] << "\n";
    }

    delete[] a;
    a = NULL;

    return 0;
}
