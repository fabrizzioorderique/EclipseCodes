#include <iostream>
#include <vector>
#include <string>
#include <sstream>
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

int main ()
{
    string input;
    getline(cin, input);
    vector<string> fragments = split(input, ' '); // A vector<string> of fragments.
    
    // code to solve the problem.  You can write and call other functions as well.
    
    return 0;
}
