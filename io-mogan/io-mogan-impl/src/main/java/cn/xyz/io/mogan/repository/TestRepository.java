package cn.xyz.io.mogan.repository;

import cn.xyz.io.mogan.entity.Test;
import cn.xyz.io.mogan.entity.TestCriteria;
import cn.xyz.io.mogan.repository.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lvchenggang.
 * @date 2019/3/28 15:42
 * @see
 * @since
 */
@Repository
public class TestRepository {

    @Autowired
    private TestDAO testDAO;

    @Transactional
    public void batchInsertCommit(){
        Test test=new Test();
        test.setName("aaa");
        this.testDAO.insertSelective(test);
        test.setName("bbb");
        this.testDAO.insertSelective(test);
    }

    @Transactional
    public void batchInsertRollback(){
        Test test=new Test();
        test.setName("aaa");
        this.testDAO.insertSelective(test);
        test.setName("bbb");
        this.testDAO.insertSelective(test);
        throw new RuntimeException("rollback");
    }

    public List<Test> selectAll(){
        TestCriteria testCriteria=new TestCriteria();
        TestCriteria.Criteria criteria=testCriteria.or();
        return this.testDAO.selectByCriteria(testCriteria);
    }

}
