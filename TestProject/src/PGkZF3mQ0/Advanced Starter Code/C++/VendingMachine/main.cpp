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
    string start;
    getline(cin, start);
    
    string temp;
    getline(cin, temp);
    int n = atoi(temp.c_str());
    
    string paths[n][2];
    
    for (int i = 0; i < n; i++) {
        string temp1;
        getline(cin, temp1);
        vector<string> parts = split(temp1, ' ');
        paths[i][0] = parts[0];
        paths[i][1] = parts[1];
    }
    
    // code to solve the problem.  You can write and call other functions as well.
    
    return 0;
}

