package cn.xyz.io.mogan.api;

/**
 * 测试类
 *
 * @author lvchenggang.
 * @date 2019/3/27 15:16
 * @see
 * @since
 */
public interface HelloProvider {

    public String sayHello(String name);

    public void batchInsertCommit();

    public void batchInsertRollback();
}
