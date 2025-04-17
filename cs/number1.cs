using System;

class Program
{
    static void StartPosFinder(int m, int n, string s)
    {
        int x = 0;
        int y = 0;
        int rx = 0;
        int lx = 0;
        int uy = 0;
        int dy = 0;

        foreach (char c in s)
        {
            if (c == 'U')
            {
                y--;
                if (y < uy) uy = y;
            }
            else if (c == 'D')
            {
                y++;
                if (y > dy) dy = y;
            }
            else if (c == 'L')
            {
                x--;
                if (x < lx) lx = x;
            }
            else if (c == 'R')
            {
                x++;
                if (x > rx) rx = x;
            }
        }

        if (rx - lx >= m || dy - uy >= n)
        {
            Console.WriteLine("No");
        }
        else
        {
            Console.WriteLine($"{1 - lx} {1 - uy}");
        }
    }

    static void Main()
    {
        string s = "ULDDRRUU";
        StartPosFinder(3, 3, s);
    }
}
