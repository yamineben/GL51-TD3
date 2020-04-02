package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import gl51.movie.service.MovieService

import javax.inject.Inject

class MovieServiceImpl implements MovieService {
    @Inject
    MovieClient mvc

    @Override
    Movie getMovieInformations(String imdb) {
        return mvc.getMovieDetail(imdb)
    }

    MovieClient getMvc() {
        return mvc
    }

    void setMvc(MovieClient mvc) {
        this.mvc = mvc
    }
}
