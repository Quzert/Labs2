using System;

public class CountSeriesFuncNoComments
{
    public static int CntNonDecSeries()
    {
        int len_series = 0;
        int cnt = 0;

        int len = int.Parse(Console.ReadLine());

        if (len > 0)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = 0;

            for (int i = 1; i < len; i++)
            {
                num2 = int.Parse(Console.ReadLine());
                if (num2 >= num1)
                {
                    len_series++;
                }
                else if (len_series != 0)
                {
                    cnt++;
                    len_series = 0;
                }
                num1 = num2;
            }

            if (len_series != 0)
            {
                cnt++;
            }
        }
        return cnt;
    }

    public static void Main(string[] args)
    {
        int result = CntNonDecSeries();
        Console.WriteLine($"Количество неубывающих серий: {result}");
    }
}