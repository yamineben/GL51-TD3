package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import gl51.movie.service.impl.MovieRegistryImpl
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject
import java.security.Provider

@MicronautTest

class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void "injection shoud work"(){
        expect:
        registry!=null
    }

    void " favorites should be empty"() {
        expect:
        registry.listFavorites() == []
    }

    void "adding a favorite should fill in the database"(){
        when:
        registry.addMovieToFavorites("aaaaa")
        then:
        registry.listFavorites().size() == 1
    }

    void "the client should give the details of the movie"(){
        when:
        MovieClient mvc= Mock()
        Movie m= new Movie()
        mvc.getMovieDetail("t151") >> m
        def movieservice= new MovieServiceImpl()
        movieservice.mvc=mvc
        then:
            movieservice.getMovieInformations("t151")==m
    }
}
