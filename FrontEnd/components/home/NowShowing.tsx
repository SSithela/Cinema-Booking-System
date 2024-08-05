import { Movies } from "@/utils/MoviesType";
import React from "react";
import MovieCard from "../MovieCard";

const NowShowing = ({ movies }: Movies) => {
  return (
    <div className="p-3">
      <h1 className="text-4xl font-serif font-semibold text-center p-3 text-slate-700">
        Now Showing
      </h1>
      <div className="now-showing relative flex overflow-x-scroll items-center">
        {movies
          .filter((fl) => fl.nowShowing == true)
          .slice(0, 10)
          .map((movie) => (
            <div className="relative p-2">
              <MovieCard movie={movie} key={movie.movie_id} />
            </div>
          ))}
      </div>
    </div>
  );
};

export default NowShowing;
