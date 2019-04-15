package cn.xyz.io.mogan.impl.junit5.interfacecontract;

/**
 * @author lvchenggang.
 * @date 2019/4/15 10:38
 * @see
 * @since
 */
public class StringTest implements ComparableContract<String>, EqualsContract<String> {

    @Override
    public String createSmallerValue() {
        return "bar"; // 'b' < 'f' in "foo"
    }

    @Override
    public String createNotEqualValue() {
        return "baz";
    }

    @Override
    public String createValue() {
        return "foo";
    }
}
