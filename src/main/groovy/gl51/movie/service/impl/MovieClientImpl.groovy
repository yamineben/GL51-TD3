package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient

@Singleton
class MovieClientImpl implements MovieClient {
    @Override
    Movie getMovieDetail(String imdbID) {
        return null
    }
}
