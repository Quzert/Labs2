#include <iostream>
#include <vector>
#include <string>
#include  <vector>

using namespace std;

int cnt_non_dec_series() {
    int len_series = 0;
    int cnt = 0;

    int len = 0;
    cin >> len;

    int num1 = 0;
    cin >> num1;
    int num2 = 0;
    for (int i = 1; i < len;i++) {
        cin >> num2;
        if (num2 >= num1) {
            len_series++;
            num1 = num2;
        } else if( len_series != 0) {
            cnt ++;
            len_series = 0;
        }
    }
    if (len_series != 0) {
        cnt++;
    }
    return cnt;
}



int main() {
    cout << "Ведите кол-во чисел: " << cnt_non_dec_series() << endl;
    return 0;
}