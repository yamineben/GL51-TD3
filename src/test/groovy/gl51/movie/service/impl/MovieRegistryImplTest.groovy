package gl51.movie.service.Impl

import gl51.movie.service.impl.MovieRegistryImpl
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

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

}