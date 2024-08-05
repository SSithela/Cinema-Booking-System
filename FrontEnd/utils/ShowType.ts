import { Movie } from "./MoviesType";

export type Show = {
  showId: string;
  movieRoom: object;
  movie: Movie;
  dateCreated: string;
  startTime: string;
  room: object;
};
export type Shows = {
  shows: Show[];
};
