import Image from "next/image";
import Link from "next/link";
import {
  ReactElement,
  JSXElementConstructor,
  ReactNode,
  ReactPortal,
  PromiseLikeOfReactNode,
} from "react";

export const getGenres = async () => {
  const req = await fetch("http://localhost:8084/genre/", {
    method: "GET",
    headers: {
      "X-API-KEY": process.env.SPRING_API_KEY || "",
      "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
    },
  });
  const response = await req.json();
  return response;
};
const getImage = (name: string) => {
  switch (name) {
    case "Science Fiction":
      return "/img/genres/sci-fu.png";
      break;
    case "Horror":
      return "/img/genres/horror.png";
      break;
    case "Romance":
      return "/img/genres/rommance.png";
      break;
    default:
      return "/img/genres/all.png";
      break;
  }
};
const Page = async () => {
  const genres = await getGenres();
  return (
    <div className="min-h-screen p-4">
      <h2 className="text-2xl font-bold font-sans text-center p-5">
        Genre List
      </h2>
      <div className="grid grid-cols-4 gap-3 content-center">
        {genres.map((gen: { name: string; id: number }) => (
          <Link href={"/genre/" + gen.id} className="genre-card m-2 ">
            <div className="flex items-center">
              <div>
                <Image src={getImage(gen.name)} alt="" height={50} width={50} />
              </div>
              <div>
                <h1 className="text-xl font-sans font-bold">{gen.name}</h1>
              </div>
            </div>
          </Link>
        ))}
      </div>
    </div>
  );
};

export default Page;
