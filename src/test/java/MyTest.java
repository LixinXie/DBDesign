import com.xie.dbdesign.entity.*;
import com.xie.dbdesign.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyTest {

    @Test
    public void testCourse() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService service = (CourseService) context.getBean("courseServiceImpl");
        //System.out.println(service.queryCourseByCno("abcd"));


        /*List<Course> list = service.queryCourseByCname("数据库");
        for (Course course : list) {
            System.out.println(course);
        }*/

        /*List<Course> list = service.queryCourseByTname("李老师");
        System.out.println(list);*/

        /*Course course = new Course();
        course.setCNo("dddd");
        course.setCName("毛概");
        course.setTNo("1234");
        course.setCHour(80);
        course.setCCredit(5);
        course.setCTime("星期四");
        course.setCSite("教三");
        //course.setCTestTime(new java.sql.Date(System.currentTimeMillis()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = simpleDateFormat.parse("2000-11-04 10:30:00");
        Timestamp timestamp = new Timestamp(date.getTime());
        course.setCTestTime(timestamp);
        service.addCourse(course);*/

        //service.deleteCourseByCno("abcd");

        /*Course course = service.queryCourseByCno("aaaa");
        course.setCTime("星期一");
        service.updateCourse(course);*/

        //System.out.println(service.queryCourseByCno("aaaa"));

    }

    @Test
    public void testDepartment(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService service = (DepartmentService) context.getBean("departmentServiceImpl");
        //System.out.println(service.queryDepartmentByDno("0001"));
        //System.out.println(service.queryDepartmentByDname("计算机"));

        /*Department dept = new Department();
        dept.setDNo("0002");
        dept.setDName("数学");
        dept.setDDescription("数学系的描述");
        service.addDepartment(dept);*/

        /*Department dep = service.queryDepartmentByDno("0001");
        dep.setDDescription("这是计算机系的描述");
        service.updateDepartment(dep);*/

        //service.deleteDepartmentByDno("0002");

        //System.out.println(service.queryAllDepartment());
    }

    @Test
    public void testGrade(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GradeService service = (GradeService) context.getBean("gradeServiceImpl");
        //System.out.println(service.queryGradeByuserId("1111"));
        //System.out.println(service.queryGradeByCno("aaaa"));
        //System.out.println(service.queryGradeBySname("张三"));
        //System.out.println(service.queryGradeByCname("数据库"));
        //System.out.println(service.queryGradeByTname("李老师"));
        //System.out.println(service.queryGradeByDno("0001"));

        /*Grade grade = new Grade();
        grade.setSNo("2222");
        grade.setCNo("eeee");
        grade.setUsualGrade(85);
        grade.setTestGrade(90);
        grade.setGeneralGrade(90);
        service.addGrade(grade);*/

        /*List<Grade> list = service.queryGradeBySname("张三");
        Grade g = list.get(0);
        g.setUsualGrade(90);
        service.updateGrade(g);*/

        //service.deleteGradeByuserIdCno("1111", "dddd");


    }

    @Test
    public void testStudent() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService) context.getBean("studentServiceImpl");
        //System.out.println(service.queryStudentByuserId("1111"));
        //System.out.println(service.queryStudentBySname("张三"));
        //System.out.println(service.queryStudentByDno("0001"));

        /*Student student = new Student();
        student.setuserId("3333");
        student.setSName("王五");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        student.setSBirthday(new java.sql.Date(format.parse("2000-01-02").getTime()));
        student.setSSex("男");
        student.setEnrollGrade(700);
        student.setDNo("0002");
        service.addStudent(student);*/

        /*Student stu = service.queryStudentByuserId("1111");
        stu.setSSex("女");
        service.updateStudent(stu);*/
    }

    @Test
    public void testTeacher() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService service = (TeacherService) context.getBean("teacherServiceImpl");
        //System.out.println(service.queryTeacherByTno("1234"));
        //System.out.println(service.queryTeacherByTname("老师"));
        //System.out.println(service.queryTeacherByDno("0001"));


        /*Teacher teacher = new Teacher();
        teacher.setTNo("3456");
        teacher.setTName("王老");
        teacher.setTSex("女");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        teacher.setTBirthday(new Date(format.parse("1990-01-03").getTime()));
        teacher.setDNo("0002");
        teacher.setTTitle("教师");
        teacher.setTMajor("数学");
        service.addTeacher(teacher);*/

        /*Teacher tea = service.queryTeacherByTno("1234");
        tea.setTMajor("网络工程");
        service.updateTeacher(tea);*/

        //service.deleteTeacherByTno("3456");

    }

    @Test
    public void testUsers(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService service = (UsersService) context.getBean("usersServiceImpl");
        //System.out.println(service.queryPswdByUname("3118005071"));
        /*Users user = new Users();
        user.setUsername("13579");
        user.setPswd("13579");
        user.setUsertype("学生");
        service.addUser(user);*/
    }

    @Test
    public void testGradeView(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GradeViewService service = (GradeViewService) context.getBean("gradeViewServiceImpl");
        //System.out.println(service.queryALLGradeView());
        System.out.println(service.queryGradeViewBySno("1111"));
    }

}
