import { NextApiRequest, NextApiResponse } from "next";

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  const { email } = JSON.parse(req.body);
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
  console.log(data);
  res.send(data);
}
