package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import gl51.movie.service.MovieService

class MovieServiceImpl implements MovieService {
    private MovieClient mvc
    @Override
    Movie getMovieInformations(String imdb) {
        return mvc.getMovieDetail(imdb)
    }
}
