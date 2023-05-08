package typer.bible.service;


import typer.bible.domain.Verse;
import typer.bible.repository.MemoryVerseRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "verseServlet", urlPatterns = "/verse")
public class VerseServlet extends HttpServlet {

    MemoryVerseRepository memoryVerseRepository = new MemoryVerseRepository();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Verse foundVerse = memoryVerseRepository.findById(id).get();

        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
        res.getWriter().write(foundVerse.getText());
    }
}
