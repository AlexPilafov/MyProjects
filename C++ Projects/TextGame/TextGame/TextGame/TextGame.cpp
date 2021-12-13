#include <iostream>

using namespace std;

int answer1, answer3;
string answer2, answer4;

class MainCharacter {

public:
    int pickRace() {//player chooses the race and Returns 1 for invalid input
        switch (answer1) {
        case 1:
            cout << "You've picked a human." << endl;
            return 0;
            break;
        case 2:
            cout << "You've picked an orc." << endl;
            return 0;
            break;
        default:
            cout << "You have to type an answer and click enter to pick your race." << endl;
            cout << "Press 1 for human and 2 for an orc." << endl;
            return 1;
            break;
        }
    }
    int pickWeapon() {//player chooses a weapon and returns 1 for invalid input
        switch (answer3) {
        case 1:
            cout << "You've picked a Greatsword." << endl;
            return 0;
            break;
        case 2:
            cout << "You've picked a Battleaxe." << endl;
            return 0;
            break;
        case 3:
            cout << "You've picked a Warspear." << endl;
            return 0;
            break;
        default:
            cout << "You have to type an answer and click enter to confirm." << endl;
            cout << "Press 1 for greatsword, 2 for a battleaxe or 3 for a warspear." << endl;
            return 1;
            break;
        }
    }
};


int main()
{
    MainCharacter Player;
    //Character Pick
    cout << "Welcome to my TextGame!!" << endl;
    cout << "Do you want to play as a human or an orc?" << endl;
    cout << "1. Human" << endl;
    cout << "2. Orc" << endl;
    do {
        cin >> answer1;
        cout << endl;
    } while (Player.pickRace() != 0);

    //Intro
    if (answer1 == 1) {// IF PICKED HUMAN
        cout << "Once upon a time, there was a beautiful kingdom with a king called: " << endl;
    }
    else {// IF PICKED ORC
        cout << "Once upon a time, there was an orc clan with a chieftain called: " << endl;
    }

    cin >> answer2;
    cout << endl;

    //Story Chapter 1
    if (answer1 == 1) {// IF PICKED HUMAN
        cout << answer2 << " was the greatest king of the west. He claimed that title after he saved the three kingdoms from orc invasions." << endl;
    }
    else {// IF PICKED ORC
        cout << answer2 << " the ruthless, was how they called him. He was a fearsome warrior, forged in the depths of Odgro." << endl;
    }

    //Choose a weapon
    cout << "Choose a weapon:" << endl;
    cout << "1. Greatsword" << endl;
    cout << "2. Battleaxe" << endl;
    cout << "3. Warspear" << endl;
    do {
        cin >> answer3;
        cout << endl;
    } while (Player.pickWeapon() != 0);

    return 0;
}