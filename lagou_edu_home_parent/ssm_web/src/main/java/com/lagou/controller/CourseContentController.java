package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(int courseId) {

        List<CourseSection> list = courseContentService.findSectionAndLessonByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", list);

        return responseResult;
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(int courseId) {

        Course course = courseContentService.findCourseByCourseId(courseId);

        Map<String, Object> map = new HashMap<>();
        map.put("id", course.getId());
        map.put("courseName", course.getCourseName());

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);

        return responseResult;
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection section) {

        if (section.getId() == null) {
            courseContentService.saveSection(section);
            return new ResponseResult(true, 200, "响应成功", null);
        } else {
            courseContentService.updateSection(section);
            return new ResponseResult(true, 200, "响应成功", null);
        }
    }

    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id, int status) {

        courseContentService.updateSectionStatus(id, status);

        Map<String, Integer> map = new HashMap<>();
        map.put("status", status);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);

        return responseResult;
    }
}
