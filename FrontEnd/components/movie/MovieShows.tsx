import Link from "next/link";
import { generateStaticMovie } from "./PageHead";

export const generateStaticShows = async (
  id: string,
  api_key: any,
  secret_key: any
) => {
  const req = await fetch("http://localhost:8084/show/", {
    method: "GET",
    headers: {
      "X-API-KEY": api_key,
      "X-API-SECRET": secret_key,
    },
  });
  const res = await req.json();
  return res.filter(
    (show: { movie: { movie_id: string } }) => show.movie.movie_id === id
  );
};

type movieId = {
  id: string;
};
const MovieShows = async ({ id }: movieId) => {
  const shows = await generateStaticShows(
    id,
    process.env.SPRING_API_KEY,
    process.env.SPRING_SECRET_KEY
  );
  const movie = await generateStaticMovie(
    id,
    process.env.SPRING_API_KEY,
    process.env.SPRING_SECRET_KEY
  );
  console.log({ show: movie });
  return (
    <div className="p-4">
      {movie.nowShowing === false && (
        <div className="bg-black text-center p-2">
          <h1 className="glow text-xl font-sans">Will be Showing soon</h1>
        </div>
      )}
      {shows?.map(
        (show: { showId: number; dateCreated: string; startTime: string }) => (
          <div className="w-40 h-20 bg-orange-500 p-1 flex justify-center items-center">
            <Link
              href={"/booking/" + show.showId}
              className="text-center w-full"
            >
              <h1 className="font-sans text-xl font-semibold text-gray-50">
                {show.dateCreated}
              </h1>
              <h1 className="font-semibold">{show.startTime}</h1>
            </Link>
          </div>
        )
      )}
    </div>
  );
};

export default MovieShows;
