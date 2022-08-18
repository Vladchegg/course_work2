package pro.sky.course_work2.service;

import pro.sky.course_work2.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
