package wraap;

/**
 * @author Thomas Long
 * Created on 2/12/2020
 * Number类是所有包装类的父类。
 * 本类只提供所有包装类都共享的若干个方法，用于将本数据类型导出成其他的数据类型。
 */
public abstract class Number
{
    public abstract int intValue();
    public abstract float floatValue();
    public abstract double doubleValue();
    public abstract char charValue();
}
