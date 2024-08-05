import NavBar from "@/components/NavBar";
import Update from "@/components/update/UserUpdate";
import { useSession } from "next-auth/react";
export async function getUser(email: string) {
  const user = await fetch("http://localhost:8084/user/" + email, {
    method: "GET",
    headers: {
      "X-API-KEY": process.env.SPRING_API_KEY || "",
      "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
    },
  })
    .then((v) => v.json())
    .catch((err) => err.message);
  const data = await user;
  //   console.log(user);
  return user;
}
const Page = async () => {
  return (
    <>
      {/* <NavBar /> */}
      <Update />
    </>
  );
};

export default Page;
