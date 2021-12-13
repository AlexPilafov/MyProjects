
#include <iostream>
using namespace std;

int main() {
    int A, B, r;
    cout << "Enter the first number:";
    cin >> A;
    cout << "Enter the second number:";
    cin >> B;
    r = A % B;

    while (r > 0)
    {
        A = B;
        B = r;
        r = A % B;
    }

    cout << B << endl;
    return 0;
}