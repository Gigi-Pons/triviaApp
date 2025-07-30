package com.gbueno.app.services;

import com.gbueno.app.dtos.*;
import com.gbueno.app.entities.Quiz;
import com.gbueno.app.mappers.QuestionMapper;
import com.gbueno.app.mappers.QuizMapper;
import com.gbueno.app.repositories.CategoryRepository;
import com.gbueno.app.repositories.OptionRepository;
import com.gbueno.app.repositories.QuestionRepository;
import com.gbueno.app.repositories.QuizRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final CategoryRepository categoryRepository;
    private final QuizMapper quizMapper;
    public final QuestionMapper questionMapper;

    public List<QuestionDto> getQuizQuestions(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        return questionRepository.findByQuiz(quiz).stream().map(question -> {
            QuestionDto questionDto = new QuestionDto();
            questionDto.setId(question.getId());
            questionDto.setText(question.getText());

            List<OptionDto> optionDtos = optionRepository.findByQuestion(question).stream().map(option -> {
                OptionDto o = new OptionDto();
                o.setLabel(option.getLabel());
                o.setText((option.getText()));
                return o;
            }).toList();

            questionDto.setOptions(optionDtos);
            return questionDto;
        }).toList();
    }

    public List<QuizDto> getAllQuizzes() {
        return quizRepository.findAll()
                .stream()
                .map(quizMapper::toDto)
                .toList();
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(quizMapper::toCategoryDto)
                .toList();
    }

    public QuizDto getRandomQuizByCategoryId(Long categoryId) {
        Quiz quiz = quizRepository.findRandomQuizByCategoryId(categoryId)
                .orElseThrow(() -> new RuntimeException("No quiz found for this category"));
        return quizMapper.toDto(quiz);
    }

    public ResponseEntity<QuizWithQuestionsDto> getRandomQuizWithQuestions(Long categoryId) {
        var quiz = quizRepository.findRandomQuizByCategoryId(categoryId).orElse(null);
        if (quiz == null) {
            return ResponseEntity.badRequest().build();
        }


        QuizWithQuestionsDto dto = new QuizWithQuestionsDto();
        dto.setId(quiz.getId());
        dto.setTitle(quiz.getTitle());
        dto.setCategoryName(quiz.getCategory().getName());

        //get the list of questions
        List<QuestionDto> questions = questionRepository.findByQuiz(quiz)
                .stream()
                .map(question -> {
                    QuestionDto q = questionMapper.toQuestionDto(question);
                    q.setOptions(questionMapper.toOptionDtoList(optionRepository.findByQuestion(question)));
                    return q;
                }).toList();

            dto.setQuestions(questions);
            return ResponseEntity.ok(dto);
    }

    public QuizDto getQuizById(Long id) {
        var quiz = quizRepository.findByIdWithQuestions(id).orElse(null);

        return quizMapper.toDto(quiz);
    }

}
