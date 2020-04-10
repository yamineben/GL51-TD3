package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest

class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void injectionshouldwork(){
        expect:
        registry!=null
    }

    void favoritesshouldbeempty() {
        expect:
        registry.listFavorites() == []
    }

    void addingafavoriteshouldfillinthedatabase(){
        when:
        registry.addMovieToFavorites("aaaaa")
        then:
        registry.listFavorites().size() == 1
        registry.listFavorites().find { it.title == 'my movie'}
    }

    @MockBean(MovieClientImpl)
    MovieClient movieClient() {
        def mock = Mock(MovieClient)
        mock.getMovieDetail("aaaaa") >> new Movie(imdbID: "aaaaa", title: 'my movie')
        mock
    }
}
