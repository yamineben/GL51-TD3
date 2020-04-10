package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import io.micronaut.test.annotation.MockBean
import spock.lang.Specification
import io.micronaut.test.annotation.MicronautTest


@MicronautTest
class MovieServiceImplTest extends Specification {
    MovieServiceImpl movieService= new MovieServiceImpl()

    @MockBean(MovieClient)
    void theclientshouldgivethedetailsofthemovie(){
        when:
        MovieClient mvc= Mock()
        Movie m= new Movie()
        mvc.getMovieDetail("t151") >> m
        movieService.setMvc(mvc)
        then:
        movieService.getMovieInformations("t151")==m
    }
}
