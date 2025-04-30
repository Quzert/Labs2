#include <iostream>
#include <vector>
#include <string>

using namespace std;

int count_non_decreasing_series(const string& sequence) {
    int cnt = 0;
    int n = sequence.size();
    int i = 0;
    while (i < n - 1) {
        if (static_cast<int>(sequence[i]) <= static_cast<int>(sequence[i + 1])) {
            cnt++;
            while (i < n - 1 && static_cast<int>(sequence[i]) <= static_cast<int>(sequence[i + 1])) {
                i++;
            }
        } else {
            i++;
        }
    }
    return cnt;
}

vector<int> str_to_list(const string& s) {
    vector<int> result;
    for (char c : s) {
        result.push_back(c - '0');
    }
    return result;
}

int main() {
    cout << "Количество неубывающих серий №1: " << count_non_decreasing_series("512325") << endl;

    cout << "Количество неубывающих серий №2: " << count_non_decreasing_series("484756344") << endl;

    cout << "Количество неубывающих серий №3: " << count_non_decreasing_series("12345678998765432123456789987654321") << endl;

    return 0;
}