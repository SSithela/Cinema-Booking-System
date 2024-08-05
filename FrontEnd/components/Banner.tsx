import { Movies } from "@/utils/MoviesType";
import Image from "next/image";
import Link from "next/link";
import React from "react";
const Banner = ({ movies }: Movies) => {
  const movie = movies[Math.floor(Math.random() * 10)];
  function makeStrShorter(str: string) {
    return str.length > 250 ? str.substring(0, 250) + "..." : str;
  }
  return (
    <div
      className="banner relative overflow-hidden"
      style={{ height: "103vh" }}
    >
      <div className="w-full h-full absolute banner-content flex items-center p-7 font-sans">
        <div className=" text-slate-50 relative ">
          <h1 className="text-5xl mb-2 font-bold">{movie.title}</h1>
          <p className="pb-7 w-1/2">{makeStrShorter(movie.overview)}</p>
          <Link href={"/movie/" + movie.movie_id} className="btn-book btn">
            Book Now
          </Link>
        </div>
      </div>
      <Image
        placeholder="blur"
        width={6000}
        height={890}
        sizes="100vw"
        quality={100}
        blurDataURL="https://placehold.co/600x400"
        alt={movie.movie_id}
        src={"https://image.tmdb.org/t/p/original" + movie.backdropImg}
      />
    </div>
  );
};

export default Banner;
