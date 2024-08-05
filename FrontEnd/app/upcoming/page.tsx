import NavBar from "@/components/NavBar";
import { generateStaticMovi } from "../now-showing/page";
import { Movie } from "@/utils/MoviesType";
import MovieCard from "@/components/MovieCard";

export default async function Upcoming() {
  const data = await generateStaticMovi();
  // console.log(data);
  return (
    <>
      {/* <NavBar /> */}
      <h4 className="text-2xl font-sans text-center p-4">Upcoming</h4>
      <div className="main grid grid-cols-4 p-2 gap-2 place-items-center">
        {data &&
          data?.map(
            (item: Movie) => !item.nowShowing && <MovieCard movie={item} />
          )}
      </div>
    </>
  );
}
