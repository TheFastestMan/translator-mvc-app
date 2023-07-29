package ru.rail;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.rail.dto.WordsPairDto;
import ru.rail.services.WordService;

import java.util.Optional;


import java.io.IOException;


@WebServlet("/translator")
public class TranslateServlet extends HttpServlet {

    private final WordService wordService = new WordService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("Russian/English word: <input type='text' name='inputWord'>");
        resp.getWriter().println("<input type='submit'>");
        resp.getWriter().println("</form>");
    }

    private boolean isEnglish(String word) {
        return word.matches("[a-zA-Z]+");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String inputWord = req.getParameter("inputWord");

        Optional<WordsPairDto> translation;
        if (isEnglish(inputWord)) {
            translation = wordService.getRussianTranslation(inputWord);
        } else {
            translation = wordService.getEnglishTranslation(inputWord);
        }

        resp.getWriter().println("<h1>Rail's translator says</h1>");
        if (translation.isPresent()) {
            resp.getWriter().println("English: " + translation.get().getEnglishWord() + "<br/>");
            resp.getWriter().println("Russian: " + translation.get().getRussianWord() + "<br/>");
        } else {
            resp.getWriter().println("No translation found for: " + inputWord);
        }
    }

}

