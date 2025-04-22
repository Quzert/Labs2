#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <regex>

using namespace std;

bool is_valid_username(const string& username) {
    // Проверка длины имени пользователя
    if (username.length() < 6 || username.length() > 30) {
        return false;
    }

    // Проверка на запрещенные символы
    if (regex_search(username, regex("[&=+<>,_'\\-]"))) {
        return false;
    }

    // Проверка, что имя не начинается и не заканчивается точкой
    if (username.front() == '.' || username.back() == '.') {
        return false;
    }

    // Проверка на две точки подряд
    if (username.find("..") != string::npos) {
        return false;
    }

    // Проверка на допустимые символы
    if (!regex_match(username, regex("^[a-zA-Z0-9.]*$"))) {
        return false;
    }

    return true;
}

int email_count(const vector<string>& email_list) {
    set<string> unique_emails;

    for (const auto& email : email_list) {
        size_t at_pos = email.find('@');
        if (at_pos == string::npos) {
            continue;
        }

        string local = email.substr(0, at_pos);
        string domain = email.substr(at_pos);

        // Удаляем символы после '*' в имени пользователя
        size_t star_pos = local.find('*');
        if (star_pos != string::npos) {
            local = local.substr(0, star_pos);
        }

        // Удаляем точки из имени пользователя
        string cleaned_local;

        if (!is_valid_username(local)) {
            cout << "error" << endl;
            return 0;
        }

        for (size_t i = 0; i < local.length(); ++i) {
            if (local[i] == '.') {
                continue;
            }
            cleaned_local += local[i];
        }


        unique_emails.insert(cleaned_local + domain);
    }

    cout << "Unique emails: " << unique_emails.size() << endl;
    return unique_emails.size();
}

int main() {
    vector<string> addres_list1 = {"mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"};
    vector<string> addres_list2 = {"mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru"};
    vector<string> addres_list3 = {"mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e+@corp.nstu.ru"};

    email_count(addres_list1);
    email_count(addres_list2);
    email_count(addres_list3);

    return 0;
}