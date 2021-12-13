#include <iostream>

using namespace std;

int answer1;
string answer2,answer3,answer4;
int Answer1(){
        switch(answer1){
        case 1:
            cout << "You've picked a human." << endl << endl;
            return 0;
            break;
        case 2:
            cout << "You've picked an orc." << endl << endl;
            return 0;
            break;
        default:
            cout << "You have to type 1 or 2 and click enter to pick your race." << endl;
            return 1;
            break;}
    }
int main()
{
    //Character Pick
    cout << "Welcome to my TextGame!!" << endl;
    cout << "Do you want to play as a human or an orc?" << endl;
    cout << "Press 1 for human and 2 for orc." << endl;
    do {
        cin >> answer1;
    }
    while (Answer1() != 0);
    //Intro
    if(answer1 == 1){// IF PICKED HUMAN
        cout << "Once upon a time, there was a beautiful kingdom with a king called: " << endl;
    }else{// IF PICKED ORC
        cout << "Once upon a time, there was an orc clan with a chieftain called: " << endl;
    }
    cin >> answer2;
    //Story Chapter 1
    if(answer1 == 1){// IF PICKED HUMAN
        cout << answer2 << " was the greatest king of the west. He claimed that title after he saved the kingdom from the orc siege." << endl;
    }else{// IF PICKED ORC
        cout << answer2 << " the ruthless, is how they call him. He is a fearsome warrior forged in the depths of Odgro." << endl;
    }

    return 0;

}
