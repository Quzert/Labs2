#include <iostream>
#include <vector>
#include <string>

using namespace std;

int count_non_decreasing_series(const vector<int>& sequence) {
    int cnt = 0;
    int n = sequence.size();
    int i = 0;
    while (i < n - 1) {
        if (sequence[i] <= sequence[i + 1]) {
            cnt++;
            while (i < n - 1 && sequence[i] <= sequence[i + 1]) {
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
    vector<int> sequence1 = {5, 1, 2, 3, 2, 5};
    cout << "Количество неубывающих серий №1: " << count_non_decreasing_series(sequence1) << endl;

    vector<int> sequence2 = str_to_list("484756344");
    cout << "Количество неубывающих серий №2: " << count_non_decreasing_series(sequence2) << endl;

    vector<int> sequence3 = str_to_list("12345678998765432123456789987654321");
    cout << "Количество неубывающих серий №3: " << count_non_decreasing_series(sequence3) << endl;

    return 0;
}