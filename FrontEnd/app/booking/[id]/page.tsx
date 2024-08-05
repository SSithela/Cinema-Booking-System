import NavBar from "@/components/NavBar";
import BookingHeader from "@/components/bookings/BookingHeader";
import { loadStripe } from "@stripe/stripe-js";
export const generateStaticShow = async (id: string) => {
  const req = await fetch("http://localhost:8084/show/read/" + id, {
    method: "GET",
    next: { revalidate: 0 },
    headers: {
      "X-API-KEY": process.env.SPRING_API_KEY || "",
      "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
    },
  });
  const data = await req.json();
  return { data, fallback: true, cache: "no-store" };
};
const stripePromise = loadStripe(process.env.PUBLIC_KEY || "");
const Page = async ({ params }: { params: { id: string } }) => {
  const { data } = await generateStaticShow(params.id);
  // console.log(data);

  return (
    <>
      {/* <NavBar /> */}
      <div className="text-">
        <BookingHeader movieShow={data} />
      </div>
    </>
  );
};

export default Page;
