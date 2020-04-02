package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import spock.lang.Specification
import io.micronaut.test.annotation.MicronautTest

import javax.inject.Inject

@MicronautTest
class MovieServiceImplTest extends Specification {
    MovieServiceImpl movieService= new MovieServiceImpl()

    void "the client should give the details of the movie"(){
        when:
        MovieClient mvc= Mock()
        Movie m= new Movie()
        mvc.getMovieDetail("t151") >> m
        movieService.setMvc(mvc)
        then:
        movieService.getMovieInformations("t151")==m
    }
}
