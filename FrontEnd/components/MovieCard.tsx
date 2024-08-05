"use client";
import { MovieData } from "@/utils/MoviesType";
import Image from "next/image";
import { useRouter } from "next/navigation";

const MovieCard = ({ movie }: MovieData) => {
  const router = useRouter();

  return (
    <div
      // href={`/movie/${movie.movie_id}`}
      className="card w-60 mt-5"
      onClick={() => {
        router.push(`/movie/${movie.movie_id}`);
      }}
    >
      <Image
        className="card-image"
        src={"https://image.tmdb.org/t/p/original" + movie.posterImg}
        width={799}
        height={100}
        objectFit="contain"
        alt={movie.title}
      />

      <div className="card-content w-full text-center p-3">
        <h5>{movie.title}</h5>
      </div>
    </div>
  );
};

export default MovieCard;
