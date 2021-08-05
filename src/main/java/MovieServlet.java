import com.google.gson.Gson;
import data.Movie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();
            Movie movie = new Movie(
                    6,
                    "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
                    "Goodfellas",
                    "5",
                    "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.",
                    "Martin Scorsese",
                    "Robert De Niro, Ray Liotta, Joe Pesci, Lorraine Bracco",
                    "Biography, Crime, Drama",
                    "1990"
            );
            String movieString = new Gson().toJson(movie);
            out.println(movieString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Movie[] movies = new Gson().fromJson(request.getReader(), Movie[].class);
//            for (Movie movie : movies) {
//                System.out.println(movie.getId());
//                System.out.println(movie.getTitle());
//                System.out.println(movie.getDirector());
//                System.out.println(movie.getPlot());
//                System.out.println(movie.getPoster());
//                System.out.println(movie.getActors());
//                System.out.println(movie.getGenre());
//                System.out.println(movie.getYear());
//                System.out.println(movie.getRating());
//                System.out.println("========================================================");
//            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        out.println(new Gson().toJson("{message: \"Movies POST was successful\"}"));
        response.setStatus(200);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter out = null;
        try {
            out = response.getWriter();

            BufferedReader reader = request.getReader();

            Movie[] movies = new Gson().fromJson(reader, Movie[].class);

            for (Movie movie : movies) {
                System.out.println(movie.getId());
                System.out.println(movie.getTitle());
                System.out.println(movie.getDirector());
                System.out.println(movie.getPlot());
                System.out.println(movie.getPoster());
                System.out.println(movie.getActors());
                System.out.println(movie.getGenre());
                System.out.println(movie.getYear());
                System.out.println(movie.getRating());
                System.out.println("========================================================");
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json");

        PrintWriter out = null;

        try {
            out = response.getWriter();
            BufferedReader reader = request.getReader();
            int id = new Gson().fromJson(reader, int.class);
            System.out.println("The movie id to delete: " + id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        out.println(new Gson().toJson("{message: \"Movies DELETE was successful\"}"));
        response.setStatus(200);
    }
}


