package com.example.demo;

import com.example.Application;
import com.example.dao.StudentMapper;
import com.example.entity.Student;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
class DemoApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void TestInsert(){
        //插入一条记录
//        long startTime=System.currentTimeMillis();   //获取开始时间
//        Student build = Student.builder().name("zhangsan")
//                .age(new Date())
//                .sex("男").build();
//        studentMapper.insert(build);
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");    //595ms

//        //插入100条数据
//        long startTime=System.currentTimeMillis();   //获取开始时间
//        for (int i=0;i<100;i++){
//            Student build = Student.builder().name("zhangsan")
//                    .age(new Date())
//                    .sex("男").build();
//            studentMapper.insert(build);
//        }
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");    //4884ms    十倍


        //插入1000条数据
//        long startTime=System.currentTimeMillis();   //获取开始时间
//        for (int i=0;i<1000;i++){
//            Student build = Student.builder().name("zhangsan")
//                    .age(new Date())
//                    .sex("男").build();
//            studentMapper.insert(build);
//        }
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");    //43503ms  十倍

        //插入100条数据
//        long startTime=System.currentTimeMillis();
//        List<Student> list= Lists.newArrayList();
//        for (int i = 0; i < 100; i++) {
//            list.add(Student.builder().name("zhangsan")
//                    .age(new Date())
//                    .sex("男").build());
//        }
//        studentMapper.batchInsert(list);
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");           //600ms

        //插入1w条数据
//        long startTime=System.currentTimeMillis();
//        List<Student> list= Lists.newArrayList();
//        for (int i = 0; i < 10000; i++) {
//            list.add(Student.builder().name("zhangsan")
//                   .age(new Date())
//                   .sex("男").build());
//        }
//        studentMapper.batchInsert(list);
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");           //2174ms

    }


    @Test
    void TestSelect(){
        //重在强调 批量查询比 单次IO 耗时、以及性能优势
        long startTime=System.currentTimeMillis();
        List<Student> list =Lists.newArrayList();
        list.add(Student.builder().name("李四").build());
        list.add(Student.builder().name("王五").build());
        studentMapper.batchQuerySelective(list).forEach(System.out::println);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
    @Test
    void testUpdate(){

//        更新多条记录的同一个字段为同一个值
//        UPDATE course SET name='course1' WHERE id in('id1','id2','id3);

//        更新多条记录的同一个字段为不同的值

        //肯定比一个个更新要快很多
        //将1-100的更新为lixiang
//        long startTime=System.currentTimeMillis();
//        List<Student> list =Lists.newArrayList();
//        for (int i = 1; i < 10; i++) {
//            list.add(Student.builder().name("lixiang").id(Long.valueOf(String.valueOf(i))).build());
//        }
//        studentMapper.batchUpdateList(list);
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


        long startTime=System.currentTimeMillis();
        List<Student> list =Lists.newArrayList();
        for (int i = 100; i < 2000; i++) {
            list.add(Student.builder().name("wangwu").id(Long.valueOf(String.valueOf(i))).build());
        }
        studentMapper.updateBatchCaseWhen(list);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


    }

    @Test
    void TestDelete(){

    }
}
