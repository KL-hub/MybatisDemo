package com.example.dao;

import com.example.entity.Student;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentMapper {
    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Student record);

    int insertOrUpdate(Student record);

    int insertOrUpdateSelective(Student record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Student record);

    int batchInsert(@Param("list") List<Student> list);

    /**
     * @Description: 批量查询   相同字段可以用子查询
     * @Author: lixiang
     * @Return: java.util.List<com.example.entity.Student>
     */
    List<Student> batchQuerySelective(@Param("list") List<Student> list);

    /**
     * @Description: 批量更新  这个需要根据业务进行改造
     * @Param list:
     * @Return: int
     */
    int batchUpdateList(@Param("list") List<Student> list);
    /**
     * @author  lixiang
     * @create  2021/3/6 17:31
     * @desc 通过ID进行批量更新
     **/
    int updateBatchCaseWhen(@Param("list") List<Student> list);




}