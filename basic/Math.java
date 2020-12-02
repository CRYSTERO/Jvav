package basic;

import exception.NaN_Exception;

/**
 * 基本数学类。包含常用的数学方法：
 *
 */
public final class Math
{
    private Math(){}

    //The PI value we use
    public static final double PI = 3.1415926535;

    //The E value we use
    public static final double E = 2.7182818284590452354;

    /**
     * 下面一组方法用于计算数的绝对值。每个基本数值型数据类型对应一个方法。
     * @param n 数值
     * @return 绝对值
     */
    public static int abs(int n)
    {
        return n > 0 ? n : (-n);
    }
    public static double abs(double n)
    {
        return n > 0 ? n : (-n);
    }
    public static float abs(float n)
    {
        return n > 0 ? n : (-n);
    }

    /**
     * 乘幂的方法。需要考虑多种情况：
     * 1 a 为 0， 直接返回0；
     * 2 b 为 0， 直接返回1；
     * 3 b 为负数，先将底数取倒数再乘幂运算
     * 4 b 为正数，则先不动，考虑下面带小数点的情况
     * 5 b 带小数点 将小数变为分数->约分->最后先分子次方->再分母开根号
     * @param a 底数
     * @param b 指数
     * @return 乘幂的结果
     */
    public static double pow(double a, double b)
    {
        if(a == 0) return 0;
        if (b == 0) return 1;
        if (b < 0)
        {
            a = 1 / a;
            b = abs(b);
        }
        if(b != floor(b))
        {
            Fraction f = new Fraction(b).getSimplestFraction();
            double temp = powLoop(a, f.getNumerator());
            return getRoot(temp, f.getDenominator());
        }
        else return powLoop(a, b);
    }
    private static double powLoop(double a, double b)
    {
        double res = 1;
        for (int i = 0; i < b; i++) res = res * a;
        return res;
    }

    /**
     * 一对去上整数和下整数的方法
     * @param n 要取整的数字
     * @return 取整结果
     */
    public static double floor(double n){ return n - (n % 1); }
    public static double ceil(double n){return n - (n % 1) + 1;}

    public static double getRoot(double n, double root)
    {
        return java.lang.Math.pow(n, 1 / root);
    }

    /**
     * 此方法使用欧几里得算法找到两个数的最大公约数。
     * @param n1 数1，要求为整数
     * @param n2 数2，同样要求为整数
     * @return 最大公约数
     */
    public static int findGCD(int n1, int n2)
    {
        if(n2 == 0) return n1;
        else return findGCD(n2, n1 % n2);
    }

    public static double getCircleArea(double radius)
    {
        return PI * radius * radius;
    }
    public static double getSphereVolume(double radius){return (4 * PI * radius * radius * radius) / 3;}

    //本类私有方法（请在结束后把所有的私有方法移到下面来，谢谢）

}

class Fraction
{
    private int numerator;
    private int denominator;

    private int value;

    public Fraction(){}
    public Fraction(int numerator, int denominator)
    {
        try
        {
            if(denominator == 0) throw new NaN_Exception("The denominator is zero.");
            else
            {
                this.numerator = numerator;
                this.denominator = denominator;
            }
        }catch (NaN_Exception e)
        {
            System.out.println(e);
        }
    }
    public Fraction(double n)
    {
        try
        {
            if(n == 0) throw new NaN_Exception("O has no fraction format.");
        }catch (NaN_Exception e)
        {
            System.out.println(e);
        }
        double temp = n;
        int digits = 0;
        while (true)
        {
            if(temp % 10 == 0) break;
            else
            {
                temp *= 10;
                digits ++;
            }
        }
        this.numerator = (int) temp;
        this.denominator = (int) Math.pow(10, digits);
    }

    public int getNumerator()
    {
        return this.numerator;
    }
    public int getDenominator()
    {
        return this.denominator;
    }

    public Fraction getSimplestFraction()
    {
        int numerator = this.numerator;
        int denominator = this.denominator;
        int gcd = Math.findGCD(numerator, denominator);
        return new Fraction(numerator /= gcd, denominator /= gcd);
    }
}
