using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        var sequence1 = new List<int> { 5, 1, 2, 3, 2, 5 };
        Console.WriteLine($"Количество неубывающих серий №1: {CountNonDecreasingSeries(sequence1)}");

        var sequence2 = StrToList("484756344");
        Console.WriteLine($"Количество неубывающих серий №2: {CountNonDecreasingSeries(sequence2)}");

        var sequence3 = StrToList("12345678998765432123456789987654321");
        Console.WriteLine($"Количество неубывающих серий №3: {CountNonDecreasingSeries(sequence3)}");
    }

    static int CountNonDecreasingSeries(List<int> sequence)
    {
        int count = 0;
        int n = sequence.Count;
        int i = 0;

        while (i < n - 1)
        {
            if (sequence[i] <= sequence[i + 1])
            {
                count++;
                while (i < n - 1 && sequence[i] <= sequence[i + 1])
                {
                    i++;
                }
            }
            else
            {
                i++;
            }
        }

        return count;
    }

    static List<int> StrToList(string s)
    {
        var result = new List<int>();
        foreach (char c in s)
        {
            result.Add(c - '0');
        }
        return result;
    }
}