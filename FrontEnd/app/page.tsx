import Banner from "@/components/Banner";
import Footer from "@/components/Footer";
import NavBar from "@/components/NavBar";
import NowShowing from "@/components/home/NowShowing";

export async function generateStaticMovies(api_key: any, secret_key: any) {
  const posts = await fetch("http://localhost:8084/movie/all", {
    headers: {
      "X-API-KEY": api_key,
      "X-API-SECRET": secret_key,
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then((res) => res.json());
  return posts;
}

const Page = async () => {
  const data = await generateStaticMovies(
    process.env.SPRING_API_KEY,
    process.env.SPRING_SECRET_KEY
  );
  // console.log(data);
  return (
    <>
      {/* <NavBar /> */}
      <Banner movies={data} />
      <NowShowing movies={data} />
      {/* <Footer /> */}
    </>
  );
};
export default Page;
