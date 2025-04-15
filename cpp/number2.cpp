#include <iostream>
#include <vector>
#include <string>
#include <set>

using namespace std;

vector<string> addres_list1 = {"mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"};
vector<string> addres_list2 = {"mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"};
vector<string> addres_list3 = {"mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"};


int email_count(const vector<string>& email_list) {
    set <string> unique_emails;
    for (auto addres : email_list)
    {
        char resAdd[100];
        int i = 0;
        int j = 0;
        while (addres[i] != '\0')
        {
            if (addres[i] == '.')
            {
                i++;
                continue;
            }if (addres[i] == '+')
            {
                while (addres[i] != '@')
                {
                    i++;
                }
                continue;
            }if (addres[i] == '@')
            {
                while (addres[i] != '\0')
                {
                    resAdd[j++] = addres[i];
                    i++;
                }
                resAdd[j] = '\0';
                break;
            }
            resAdd[j++] = addres[i];
            i++;
        }
        unique_emails.insert(resAdd);

    }
    cout << "Unique emails: " << unique_emails.size() << endl;
}


int main() {
    email_count(addres_list3);
    return 0;
}