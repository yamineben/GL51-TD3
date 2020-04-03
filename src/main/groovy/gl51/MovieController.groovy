package gl51

import gl51.movie.data.AddToFavoriteRequest
import gl51.movie.data.Movie
import gl51.movie.data.MovieRequest
import gl51.movie.service.MovieRegistry
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post


@Controller("/movie")
class MovieController {

    @Get("/")
    List<Movie> index() {
        return []
    }

    @Post('/')
    HttpStatus addMovie(MovieRequest movieRequest) {
        HttpStatus.CREATED
    }

}