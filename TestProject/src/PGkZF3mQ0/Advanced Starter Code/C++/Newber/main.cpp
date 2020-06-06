#include <iostream>
using namespace std;

int main(int argc, const char * argv[]) {
    char terrain[4][4]; // a 4x4 grid as per the problem.
    string line;
    
    for (int i = 0; i < 4; i++) {
        cin >> line;
        
        for (int j = 0; j < 4; j++) {
            terrain[i][j] = line[j];
        }
    }
    
    // code to solve the problem.  You can write and call other functions as well.
    
    return 0;
}
