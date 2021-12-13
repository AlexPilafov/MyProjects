#include <iostream>
using namespace std;

int main()
{
    double balance;
    cout << "Enter your balance: ";
    cin >> balance;
    double x;
    cout << "Enter the interest rate: ";
    cin >> x;
    double rate = x / 100;
    double interest = balance * rate;
    double total;
    cout << "With a starting balance of " << balance << " and interest rate of " << rate * 100 << "%. "
         << "Your additional earnings will be = " << interest << " per month." << endl;
    for (int i = 1; i <= 20; i++)
    {
        total = balance + interest * i;
        cout << "Your balance after year " << i << " will be: " << total << endl;
    }
    return 0;
}
