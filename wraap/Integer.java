package wraap;

/**
 * @author Thomas Long
 * Jvav包装类之一：Integer类
 * 此类继承自 Number 抽象类，故必须实现其中所有的四个比较方法。
 * 实现Comparable接口，故必须覆盖重写其中仅有的compareTo()方法，其中撰写自己的比较规则。
 */
public final class Integer extends Number implements Comparable<Integer>
{
    private int value;

    /**
     * Integer 最大可支持的数：2的31次方
     */
    public static final int MAX_INTEGER = 0x7fffffff;
    /**
     * Integer 最小可支持的数：-2的31次方减1
     */
    public static final int MIN_INTEGER = 0x80000000;

    /**
     * 将这个int类型的数以int类型导出
     * @return int 数据
     */
    @Override
    public int intValue() {return this.value;}

    /**
     * 将这个int类型的数以float类型导出
     * @return float 数据
     */
    @Override
    public float floatValue(){return (float)this.value;}

    /**
     * 将这个int类型的数以double类型导出
     * @return double 数据
     */
    @Override
    public double doubleValue(){return (double)this.value;}

    /**
     * 将这个int类型的数以char类型导出
     * @return char 数据
     */
    @Override
    public char charValue(){return (char)this.value;}

    /**
     * 此方法实现了 Comparable 接口中的 compareTo()方法，用以比较两个Integer类型的数值大小。
     * @param anotherInt 另一个 Integer 类型的实例
     * @return 0 -> 两者数值相等
     *          1 -> 本数大于另一个数
     *          -1 -> 本数小于另一个数
     */
    @Override
    public int compareTo(Integer anotherInt)
    {
        int x = this.value;
        int y = anotherInt.value;
        return x < y ? -1 : ((x == y) ? 0 : 1);
    }
}
