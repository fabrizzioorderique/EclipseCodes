#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <stdlib.h>
using namespace std;

vector<string> split(const string& s, char delimiter)
{
   vector<string> tokens;
   string token;
   istringstream tokenStream(s);
   while (getline(tokenStream, token, delimiter))
   {
      tokens.push_back(token);
   }
   return tokens;
}

int main(int argc, const char * argv[]) {
    string l;
    getline(cin, l);
    int n = atoi(l.c_str());
    
    int grid[n][n]; // The nxn grid as per the problem.
    
    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        vector<string> parts = split(line, ' ');
        
        for (int j = 0; j < n; j++) {
            grid[i][j] = atoi(parts[j].c_str());
        }
    }
    
    // code to solve the problem.  You can write and call other functions as well.
    
    return 0;
}
