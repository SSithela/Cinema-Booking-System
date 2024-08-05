import { generateStaticMovies } from "@/app/page";
import MovieCard from "@/components/MovieCard";
import { Movie } from "@/utils/MoviesType";
import { useState } from "react";

const Page = async ({ params }: { params: { id: string } }) => {
  // const [genresS, setGenres] = useState({});
  let x: { name: string; id: number } = { name: "", id: 0 };
  console.log(params.id);
  const movies = await generateStaticMovies(
    process.env.SPRING_API_KEY,
    process.env.SPRING_SECRET_KEY
  );
  const movieFilter = movies.filter((movie: Movie) =>
    movie.genres.some((gens: any) => {
      gens.id == params.id ? (x = { name: gens.name, id: gens.id }) : "";
      return gens.id == params.id;
    })
  );

  console.log(x.name);
  return (
    <div className="min-h-screen p-4 ">
      <h2 className="text-2xl text-center">{x.name}</h2>
      <div className="grid grid-cols-4 items-center place-items-center">
        {movieFilter.length > 0 ? (
          movieFilter.map((movie: Movie) => <MovieCard movie={movie} />)
        ) : (
          <div>No mores yet</div>
        )}
      </div>
    </div>
  );
};

export default Page;
