#include <iostream>

using namespace std;

void startPosFinder(int m, int n, const char* s){
  int x = 0;
  int y = 0;
  int rx = 0;
  int lx = 0;
  int uy = 0;
  int dy = 0;
  for(int i = 0; s[i] != '\0'; i++){
    if(s[i] == 'U'){
      y--;
      if (y < uy){
        uy = y;
      }
    }else if(s[i] == 'D'){
      y++;
      if (y > dy){
        dy = y;
      }
    }else if(s[i] == 'L'){
      x--;
      if (x < lx){
        lx = x;
      }
    }else if(s[i] == 'R'){
      x++;
      if (x > rx){
        rx = x;
      }
    }
  }
  if (rx - lx >= m || dy - uy >= n)
  {
    printf("No");
  }else
  {
    printf("%d %d", 1 - lx, 1 - uy);
  }
}

int main(){
  const char* s = "ULDDRRUU";
  startPosFinder(3, 3, s);
  return 0;
}