using System;

class Program
{
    static int CountNonDecreasingSeries(string sequence)
    {
        int count = 0;
        int n = sequence.Length;
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

    static void Main()
    {
        string sequence1 = "512325";
        Console.WriteLine($"Количество неубывающих серий №1: {CountNonDecreasingSeries(sequence1)}");

        string sequence2 = "484756344";
        Console.WriteLine($"Количество неубывающих серий №2: {CountNonDecreasingSeries(sequence2)}");

        string sequence3 = "12345678998765432123456789987654321";
        Console.WriteLine($"Количество неубывающих серий №3: {CountNonDecreasingSeries(sequence3)}");
    }
}