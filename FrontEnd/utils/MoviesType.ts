// import { type } from "os";

export type Movie = {
  movie_id: string;
  title: string;
  overview: string;
  posterImg: string;
  backdropImg: string;
  releaseDate: string;
  ratting: number;
  genres: any;
  nowShowing: boolean;
};
export type Movies = {
  movies: Movie[];
};
export type MovieData = {
  movie: Movie;
};
