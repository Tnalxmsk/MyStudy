#include <iostream>
#include <algorithm>

using namespace std;
int main() {
    ios_base::sync_with_stdio;
    int size;
    cin >> size;
    int* a = new int[size];

    for (int i = 0; i < size; i ++) {
        cin >> a[i];
    }
    sort(a, a+size);

    for (int i = 0; i < size; i ++) {
        cout << a[i] << "\n";
    }

    return 0;
}