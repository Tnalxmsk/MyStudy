#include <iostream>
#include <string>
using namespace std;

int main() {
    string a;
    int sum = 0;
    int x = 0;
    int y = 0;
    int count = 0;
    getline(cin,a);
    int len = a.length();
    if (len > 1)
        count++;
    for (int i = 0; i < len; i++) {
        x += (int)(a[i] - '0');
    }
    while (true) {
        if (x >= 10) {
            sum = 0;
            while (true) {
                y = x % 10;
                sum += y;
                x = x / 10;
                if (x == 0) {
                    x = sum;
                    break;
                }
            }
            count++;
        }
        if (x < 10) {
            if (x % 3 == 0) {
                cout << count << endl;
                cout << "YES";
                break;
            }
            else {
                cout << count << endl;
                cout << "NO";
                break;
                }
            }
    }
    return 0;
}
