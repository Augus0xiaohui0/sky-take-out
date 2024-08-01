package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工数据
     * @param employee
     */
    @AutoFill(OperationType.INSERT)
    @Insert("insert into employee(name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user) " +
            "values " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);

    /**
     * 分页查看员工
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> selectPage(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用或者禁用员工账号
     * @param build
     */
    @AutoFill(OperationType.UPDATE)
    void updateStatus(Employee build);

    /**
     *根据id查找员工用于页面回显操作
     * @param id
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);

    /**
     * 编辑员工信息
     * @param employee
     */
    @AutoFill(OperationType.UPDATE)
    void updateEmployee(Employee employee);
}
