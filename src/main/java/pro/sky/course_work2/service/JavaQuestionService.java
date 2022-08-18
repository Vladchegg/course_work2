package pro.sky.course_work2.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work2.domain.Question;
import pro.sky.course_work2.exception.QuestionAlreadyExistException;
import pro.sky.course_work2.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set <Question> questions;

    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {
            throw new QuestionAlreadyExistException();
        }
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }

}
