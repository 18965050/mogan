package cn.xyz.io.mogan.repository.mapper;

import cn.xyz.chaos.orm.mybatis.MyBatisRepository;
import cn.xyz.io.mogan.entity.Test;
import cn.xyz.io.mogan.entity.TestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@MyBatisRepository
public interface TestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int countByCriteria(TestCriteria criteria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int deleteByCriteria(TestCriteria criteria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int deleteByPrimaryKey(Integer testId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int insert(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int insertSelective(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    List<Test> selectByCriteriaWithRowbounds(TestCriteria criteria, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    List<Test> selectByCriteria(TestCriteria criteria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    Test selectByPrimaryKey(Integer testId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int updateByCriteriaSelective(@Param("record") Test record, @Param("example") TestCriteria criteria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int updateByCriteria(@Param("record") Test record, @Param("example") TestCriteria criteria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mogan..test
     *
     * @mbggenerated Wed Mar 27 19:53:30 CST 2019
     */
    int updateByPrimaryKey(Test record);
}