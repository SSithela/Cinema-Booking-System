import NavBar from "@/components/NavBar";
import MovieShows from "@/components/movie/MovieShows";
import PageHead from "@/components/movie/PageHead";


const Page = async ({ params }: { params: { id: string } }) => {


  return (
    <>
      {/* <NavBar /> */}
      <PageHead id={params.id} />
      <MovieShows id={params.id} />
    </>
  );  
};

export default Page;
